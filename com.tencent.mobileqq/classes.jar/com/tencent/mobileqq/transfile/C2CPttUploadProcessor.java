package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.ptt.PttSSCMPool;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.SliceSttManager;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeParams.IOnCompressFinish;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.ProxyIpManager;
import mqq.util.WeakReference;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.TmpPtt;

public class C2CPttUploadProcessor
  extends BaseUploadProcessor
  implements INetEventHandler, VoiceChangeParams.IOnCompressFinish
{
  public static final String TAG = "C2CPicUploadProcessor";
  private static int s0x346Seq = 0;
  WeakReference<QQAppInterface> app = new WeakReference((QQAppInterface)this.app);
  String mFileKey;
  boolean mHasVirtualStarted = false;
  private String mPttFilePath;
  MessageObserver messageObserver = new C2CPttUploadProcessor.1(this);
  private boolean netDown = false;
  private long netDownTime = 0L;
  private long timeStamp = 0L;
  
  public C2CPttUploadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.mProxyIpList = ((ProxyIpManager)((QQAppInterface)this.app.get()).getManager(3)).getProxyIp(4);
    this.sscmObject = PttSSCMPool.a();
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  public static byte[] constructPTTExtraInfo(MessageForPtt paramMessageForPtt)
  {
    byte[] arrayOfByte1 = constructPttReserveInfo(paramMessageForPtt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 3 + 15];
    arrayOfByte2[0] = 3;
    arrayOfByte2[1] = 8;
    byte[] arrayOfByte3 = PkgTools.shortToHL((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 2, arrayOfByte3.length);
    int i = arrayOfByte3.length + 2;
    arrayOfByte3 = PkgTools.intToHL(paramMessageForPtt.voiceType);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, arrayOfByte3.length);
    i += arrayOfByte3.length;
    arrayOfByte2[i] = 9;
    i += 1;
    arrayOfByte3 = PkgTools.shortToHL((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, 2);
    i += arrayOfByte3.length;
    paramMessageForPtt = PkgTools.intToHL(Utils.a(paramMessageForPtt.voiceLength));
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, paramMessageForPtt.length);
    i += paramMessageForPtt.length;
    arrayOfByte2[i] = 10;
    i += 1;
    paramMessageForPtt = PkgTools.shortToHL((short)arrayOfByte1.length);
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, 2);
    i += paramMessageForPtt.length;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i, arrayOfByte1.length);
    i = arrayOfByte1.length;
    return arrayOfByte2;
  }
  
  public static byte[] constructPttReserveInfo(MessageForPtt paramMessageForPtt)
  {
    ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
    localReserveStruct.uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
    localReserveStruct.uint32_redpack_type.set(VoiceRedPacketHelper.a(paramMessageForPtt));
    localReserveStruct.uint32_autototext_voice.set(paramMessageForPtt.autoToText);
    if (paramMessageForPtt.hasSttTxt()) {
      localReserveStruct.bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
    }
    paramMessageForPtt = VoiceRedPacketHelper.a(paramMessageForPtt);
    if (paramMessageForPtt != null) {
      localReserveStruct.bytes_redpack_score_id.set(paramMessageForPtt);
    }
    return localReserveStruct.toByteArray();
  }
  
  private RichProto.RichProtoReq.PttUpReq makePttUpReq()
  {
    RichProto.RichProtoReq.PttUpReq localPttUpReq = new RichProto.RichProtoReq.PttUpReq();
    localPttUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPttUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPttUpReq.secondUin = this.mUiRequest.mSecondId;
    localPttUpReq.uinType = this.mUiRequest.mUinType;
    localPttUpReq.fileName = this.mFileName;
    localPttUpReq.fileSize = ((int)this.mFileSize);
    localPttUpReq.md5 = this.mLocalMd5;
    MessageForPtt localMessageForPtt = (MessageForPtt)this.mUiRequest.mRec;
    if (localMessageForPtt != null)
    {
      localPttUpReq.voiceType = localMessageForPtt.voiceType;
      localPttUpReq.voiceLength = localMessageForPtt.voiceLength;
      localPttUpReq.autoToText = localMessageForPtt.autoToText;
    }
    localPttUpReq.audioPanelType = this.mUiRequest.mPttUploadPanel;
    return localPttUpReq;
  }
  
  public int cancel()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.cancel();
  }
  
  public int checkParam()
  {
    super.checkParam();
    if (!this.mUiRequest.mPttCompressFinish) {
      return 0;
    }
    return doCheckParam();
  }
  
  protected HttpNetReq constructHttpNetReq(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.constructHttpNetReq(paramArrayOfByte);
    paramArrayOfByte.mUseCmwapConnectionTypeFromDpc = true;
    return paramArrayOfByte;
  }
  
  protected im_msg_body.RichText constructPTTRichText()
  {
    try
    {
      int i;
      if (this.mUiRequest.mUinType == 0)
      {
        localObject1 = new im_msg_body.Ptt();
        ((im_msg_body.Ptt)localObject1).uint32_file_type.set(4);
        ((im_msg_body.Ptt)localObject1).uint64_src_uin.set(Long.parseLong(this.mUiRequest.mSelfUin));
        if ((this.mIpList != null) && (this.mIpList.size() > 0))
        {
          localObject2 = (ServerAddr)this.mIpList.get(0);
          ((im_msg_body.Ptt)localObject1).uint32_server_ip.set(GroupPicUploadProcessor.ipToLong(((ServerAddr)localObject2).mIp));
          ((im_msg_body.Ptt)localObject1).uint32_server_port.set(((ServerAddr)localObject2).port);
        }
        localObject2 = new im_msg_body.Elem();
        Object localObject3 = new im_msg_body.ElemFlags2();
        if ((this.app != null) && (this.app.get() != null))
        {
          i = VipUtils.a((QQAppInterface)this.app.get(), ((QQAppInterface)this.app.get()).getCurrentAccountUin());
          ((im_msg_body.ElemFlags2)localObject3).uint32_vip_status.set(i);
        }
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.Ptt)localObject1).bool_valid.set(true);
        ((im_msg_body.Ptt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
        ((im_msg_body.Ptt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
        ((im_msg_body.Ptt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mFileName));
        ((im_msg_body.Ptt)localObject1).uint32_file_size.set((int)this.mFileSize);
        localObject3 = constructPTTExtraInfo((MessageForPtt)this.mUiRequest.mRec);
        if (localObject3 != null) {
          ((im_msg_body.Ptt)localObject1).bytes_reserve.set(ByteStringMicro.copyFrom((byte[])localObject3));
        }
        localObject3 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject3).ptt.set((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
        return localObject3;
      }
      Object localObject1 = new im_msg_body.TmpPtt();
      ((im_msg_body.TmpPtt)localObject1).uint32_file_type.set(4);
      ((im_msg_body.TmpPtt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mFileName));
      ((im_msg_body.TmpPtt)localObject1).uint32_file_size.set((int)this.mFileSize);
      if ((this.app != null) && (this.app.get() != null))
      {
        localObject2 = ((QQAppInterface)this.app.get()).getCurrentAccountUin();
        i = VipUtils.a((QQAppInterface)this.app.get(), (String)localObject2);
        ((im_msg_body.TmpPtt)localObject1).uint32_user_type.set(i);
      }
      ((im_msg_body.TmpPtt)localObject1).uint64_ptt_times.set(QQRecorder.a(this.mUiRequest.mRec));
      if (this.mUiRequest.mUinType == 1008) {
        ((im_msg_body.TmpPtt)localObject1).uint32_busi_type.set(3);
      }
      Object localObject2 = constructPttReserveInfo((MessageForPtt)this.mUiRequest.mRec);
      if (localObject2 != null) {
        ((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      if (localObject2 != null) {
        ((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).tmp_ptt.set((MessageMicro)localObject1);
      return localObject2;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error");
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    String str = this.mUiRequest.mLocalPath;
    if ((str == null) || ("".equals(str)))
    {
      setError(9302, getExpStackString(new Exception("filePath null")));
      onError();
      return -1;
    }
    if (str != null)
    {
      this.mPttFilePath = str;
      File localFile = new File(str);
      if (!localFile.exists())
      {
        setError(9042, getExpStackString(new Exception("sendFile not exist " + str)));
        onError();
        return -1;
      }
      if (!localFile.canRead())
      {
        setError(9070, getExpStackString(new Exception("sendFile not readable " + this.file.filePath)));
        onError();
        return -1;
      }
      this.mExtName = "amr";
      long l = localFile.length();
      this.file.fileSize = l;
      this.mFileSize = l;
      if (l <= 0L)
      {
        setError(9071, getExpStackString(new Exception("file size 0 " + str)));
        onError();
        return -1;
      }
    }
    return 0;
  }
  
  public void doOnSendSuc(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (cmd0x346.RspBody)new cmd0x346.RspBody().mergeFrom(paramArrayOfByte);
        if ((paramArrayOfByte.msg_apply_upload_rsp != null) && (paramArrayOfByte.msg_apply_upload_rsp.get() != null))
        {
          paramArrayOfByte = (cmd0x346.ApplyUploadRsp)paramArrayOfByte.msg_apply_upload_rsp.get();
          if ((paramArrayOfByte.bytes_uuid != null) && (paramArrayOfByte.bytes_uuid.get() != null))
          {
            paramArrayOfByte = paramArrayOfByte.bytes_uuid.get().toStringUtf8();
            if (paramArrayOfByte.length() > 0)
            {
              this.mResid = paramArrayOfByte;
              if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "set uuid from BDH ");
              }
            }
          }
        }
        Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
        Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
        Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
        Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - paramLong) + "ms ,fileSize:" + this.file.fileSize + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
        }
        addBDHReportInfo(paramHashMap);
        this.mStepTrans.logFinishTime();
        this.mStepTrans.result = 1;
        this.mTransferedSize = this.mFileSize;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          if ((!this.mUiRequest.mIsPttPreSend) || (this.mUiRequest.mCanSendMsg))
          {
            sendProgressMessage();
            sendMsg();
            if (this.mUiRequest.mIsPttPreSend)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("PttPreSendManager", 4, "presend file success, can send msg, direct send");
              }
              if ((this.app != null) && (this.app.get() != null)) {
                PttPreSendManager.a((QQAppInterface)this.app.get()).a(getKey());
              }
            }
            this.file.closeInputStream();
            if (QLog.isColorLevel()) {
              QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
            }
            String str1 = (String)paramHashMap.get("ip");
            paramHashMap = (String)paramHashMap.get("port");
            String str2 = this.mMd5Str;
            if (this.mResid == null)
            {
              paramArrayOfByte = this.mUuid;
              reportForServerMonitor("actRichMediaNetMonitor_pttUp", true, 0, str1, paramHashMap, str2, paramArrayOfByte, null);
              return;
              paramArrayOfByte = paramArrayOfByte;
              paramArrayOfByte.printStackTrace();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("C2CPicUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
            }
          }
          else
          {
            this.mUiRequest.mCanSendMsg = true;
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.d("PttPreSendManager", 4, "presend file success, wait for send msg");
            continue;
          }
          paramArrayOfByte = this.mResid;
        }
        finally {}
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    PttSSCMPool.a(this.sscmObject);
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) {}
    while ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    long l2;
    Object localObject1;
    label215:
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      this.mEndTime = System.currentTimeMillis();
      l2 = (System.nanoTime() - this.mStartTime) / 1000000L;
      if (this.mUiRequest.mIsPttPreSend)
      {
        this.mStepUrl.fixAtPttPreSend(this.mStartTime);
        this.mStepTrans.fixAtPttPreSend(this.mStartTime);
      }
      localObject1 = this.mStepUrl.getReportInfo(1) + ";" + this.mStepTrans.getReportInfo(2) + ";" + this.mStepMsg.getReportInfo(3);
      this.mReportInfo.put("param_step", localObject1);
      Object localObject2 = this.mReportInfo;
      if (this.mResid != null) {
        break label525;
      }
      localObject1 = this.mUuid;
      ((HashMap)localObject2).put("param_uuid", localObject1);
      this.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
      this.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
      this.mReportInfo.put("param_quickHttp", String.valueOf(this.mSendByQuickHttp));
      if ((this.app != null) && (this.app.get() != null)) {
        this.mReportInfo.put("param_pttOpt", String.valueOf(PttOptimizeParams.a((QQAppInterface)this.app.get())));
      }
      if (this.netDown)
      {
        this.mReportInfo.put("param_pttNetDown", String.valueOf(this.netDownTime / 1000000L));
        if (QLog.isColorLevel()) {
          QLog.d("weak_net", 2, String.valueOf(this.netDownTime / 1000000L));
        }
      }
      PttInfoCollector.reportPttUploadType(paramBoolean, this.mUiRequest.mUinType, l2, this.mFileSize);
      if (!TextUtils.isEmpty(this.mUiRequest.mLocalPath))
      {
        localObject1 = (MessageForPtt)this.mUiRequest.mRec;
        localObject2 = this.mUiRequest.mLocalPath;
        if (localObject1 != null) {
          break label534;
        }
        i = 0;
        label439:
        if (localObject1 != null) {
          break label543;
        }
        l1 = 0L;
        label447:
        PttInfoCollector.reportPttSendCost((String)localObject2, true, paramBoolean, i, l1);
      }
      if (!paramBoolean) {
        break label553;
      }
      this.mReportInfo.put("param_isSuccess", "1");
      reportForIpv6(true, l2);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l2, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      AppNetConnInfo.unregisterNetEventHandler(this);
      return;
      i = 1;
      break;
      label525:
      localObject1 = this.mResid;
      break label215;
      label534:
      i = ((MessageForPtt)localObject1).voiceChangeFlag;
      break label439;
      label543:
      l1 = ((MessageForPtt)localObject1).fileSize;
      break label447;
      label553:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mReportInfo.put("param_isSuccess", "0");
      reportForIpv6(false, l2);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l2, this.mFileSize, this.mReportInfo, "");
    }
  }
  
  void doStart(boolean paramBoolean)
  {
    if (!paramBoolean) {
      sendMessageToUpdate(1001);
    }
    this.file.closeInputStream();
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      onError();
      return;
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
        if (this.mRaf == null)
        {
          setError(9303, "read file error");
          onError();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.mRaf = null;
        }
      }
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)this.mUiRequest.mRec;
    String str = this.mUiRequest.mLocalPath;
    int i;
    if (localMessageForPtt == null)
    {
      i = 0;
      if (localMessageForPtt != null) {
        break label160;
      }
    }
    label160:
    for (long l = 0L;; l = localMessageForPtt.fileSize)
    {
      PttInfoCollector.reportPttSendCost(str, false, false, i, l);
      sendFileByBDH();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  public long getFileStatus()
  {
    if (this.mUiRequest.mPttCompressFinish) {
      return super.getFileStatus();
    }
    return 7000L;
  }
  
  public im_msg_body.RichText getNewestPTTRichText()
  {
    return constructPTTRichText();
  }
  
  protected String getReportTAG()
  {
    return "actC2CPttUpload";
  }
  
  /* Error */
  public void onCompressFinished(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 215	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   6: iconst_1
    //   7: putfield 287	com/tencent/mobileqq/transfile/TransferRequest:mPttCompressFinish	Z
    //   10: aload_0
    //   11: getfield 215	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   14: getfield 264	com/tencent/mobileqq/transfile/TransferRequest:mRec	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 123	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 133	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 126	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 39	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:mHasVirtualStarted	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 290	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:doCheckParam	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 885	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:doStart	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 290	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:doCheckParam	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 885	com/tencent/mobileqq/transfile/C2CPttUploadProcessor:doStart	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	C2CPttUploadProcessor
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.b = this.errCode;
      localSendResult.jdField_a_of_type_JavaLangString = this.errDesc;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    if ((this.app != null) && (this.app.get() != null) && (this.mUiRequest.mIsPttPreSend)) {
      PttPreSendManager.a((QQAppInterface)this.app.get()).a(getKey());
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.timeStamp > 0L) {
        this.netDownTime += System.nanoTime() - this.timeStamp;
      }
    }
    for (this.timeStamp = 0L;; this.timeStamp = System.nanoTime())
    {
      this.netDown = true;
      return;
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    updateMessageDataBaseContent(true);
    sendMessageToUpdate(1003);
  }
  
  public int resume()
  {
    if ((this.mUiRequest.mIsPttPreSend) && (this.mUiRequest.mCanSendMsg))
    {
      sendProgressMessage();
      sendMsg();
    }
    return super.resume();
  }
  
  public void sendFileByBDH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.mStepTrans.logStartTime();
    if (this.mTrans != null) {}
    int i;
    do
    {
      return;
      long l1 = SystemClock.uptimeMillis();
      localPttUpReq = makePttUpReq();
      cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
      localReqBody.uint32_cmd.set(500);
      Object localObject1 = localReqBody.uint32_seq;
      i = s0x346Seq;
      s0x346Seq = i + 1;
      ((PBUInt32Field)localObject1).set(i);
      localReqBody.uint32_business_id.set(17);
      localReqBody.uint32_client_type.set(104);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localPttUpReq.selfUin));
      try
      {
        localObject2 = localPttUpReq.peerUin;
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("+")) {
          localObject1 = ((String)localObject2).substring(1);
        }
        long l2 = Long.valueOf((String)localObject1).longValue();
        localApplyUploadReq.uint64_recver_uin.set(l2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localException.printStackTrace();
          continue;
          if (localPttUpReq.uinType == 9999) {
            localException.uint32_file_type.set(102);
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localPttUpReq.fileName);
      localApplyUploadReq.uint64_file_size.set(localPttUpReq.fileSize);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localPttUpReq.md5));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      localObject1 = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject1).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject1).uint32_ptt_format.set(localPttUpReq.voiceType);
      ((cmd0x346.ExtensionReq)localObject1).uint32_ptt_time.set(localPttUpReq.voiceLength);
      i = BaseHandler.getHandlerNetType();
      ((cmd0x346.ExtensionReq)localObject1).uint32_net_type.set(i);
      ((cmd0x346.ExtensionReq)localObject1).uint32_voice_type.set(localPttUpReq.audioPanelType);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localPttUpReq.audioPanelType + "] type[" + localPttUpReq.voiceType + "] length[" + localPttUpReq.voiceLength + "] size[" + localPttUpReq.fileSize + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      setUinType(localPttUpReq, (cmd0x346.ExtensionReq)localObject1);
      if (localPttUpReq.uinType != 1008) {
        break;
      }
      ((cmd0x346.ExtensionReq)localObject1).uint32_file_type.set(3);
      localReqBody.msg_extension_req.set((MessageMicro)localObject1);
      localObject1 = localReqBody.toByteArray();
      localObject2 = new C2CPttUploadProcessor.2(this, l1);
      this.mTrans = new Transaction(((QQAppInterface)this.app.get()).getCurrentAccountUin(), 26, this.mPttFilePath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      localObject1 = new C2CPttUploadProcessor.3(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject1);
      i = ((QQAppInterface)this.app.get()).getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 26);
      }
    } while (i == 0);
    setError(i, "sendFileByBDH SubmitError.", "", this.mStepTrans);
    onError();
  }
  
  void sendMsg()
  {
    if (!canDoNextStep()) {}
    Object localObject1;
    MessageRecord localMessageRecord;
    label173:
    Object localObject2;
    do
    {
      return;
      this.mStepMsg.logStartTime();
      localObject1 = constructPTTRichText();
      if (localObject1 == null)
      {
        setError(9360, "constructpberror", null, this.mStepMsg);
        onError();
        return;
      }
      if (this.mUiRequest.mRec != null) {
        localMessageRecord = this.mUiRequest.mRec;
      }
      for (;;)
      {
        if ((localMessageRecord instanceof MessageForPtt)) {
          break label173;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("accost_ptt", 4, "mr not ptt?......");
        }
        setError(9360, "constructpberror", null, this.mStepMsg);
        onError();
        return;
        if ((this.app == null) || (this.app.get() == null)) {
          break;
        }
        localMessageRecord = ((QQAppInterface)this.app.get()).getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
        logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("accost_ptt", 4, "mr is ptt......");
      }
      localObject2 = (MessageForPtt)localMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendC2CMsg voiceType：" + ((MessageForPtt)localObject2).voiceType + " voiceLengh:" + ((MessageForPtt)localObject2).voiceLength);
      }
      ((MessageForPtt)localObject2).richText = ((im_msg_body.RichText)localObject1);
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mStepMsg);
        onError();
        return;
      }
      if (this.mUiRequest.mUpCallBack != null)
      {
        updateMessageDataBaseContent(true);
        this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject1);
        return;
      }
    } while ((this.app == null) || (this.app.get() == null));
    if (VoiceRedPacketHelper.a(localMessageRecord))
    {
      localObject2 = VoiceRedPacketHelper.a();
      MessageObserver localMessageObserver = this.messageObserver;
      byte[] arrayOfByte = this.mLocalMd5;
      if (this.mResid == null) {}
      for (localObject1 = this.mUuid;; localObject1 = this.mResid)
      {
        ((VoiceRedPacketHelper)localObject2).a(localMessageRecord, localMessageObserver, 0L, arrayOfByte, (String)localObject1, this);
        return;
      }
    }
    ((QQAppInterface)this.app.get()).getMessageFacade().b(localMessageRecord, this.messageObserver);
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttCu", ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void setUinType(RichProto.RichProtoReq.PttUpReq paramPttUpReq, cmd0x346.ExtensionReq paramExtensionReq)
  {
    int j = 0;
    int i = j;
    switch (paramPttUpReq.uinType)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      paramExtensionReq.uint64_type.set(i);
      return;
      i = j;
      if (paramPttUpReq.forceViaOffline)
      {
        i = 500;
        continue;
        i = 102;
        paramExtensionReq.str_dst_phonenum.set(paramPttUpReq.peerUin);
        continue;
        i = 104;
        continue;
        i = 104;
        continue;
        i = 105;
        continue;
        i = 101;
        continue;
        i = 103;
        continue;
        i = 100;
        continue;
        i = 114;
        continue;
        i = 130;
      }
    }
  }
  
  public void start()
  {
    super.start();
    if (!this.mUiRequest.mPttCompressFinish)
    {
      if (VoiceChangeManager.a(this.mUiRequest.mLocalPath, this)) {
        try
        {
          if (this.mHasVirtualStarted)
          {
            sendMessageToUpdate(1001);
            this.mHasVirtualStarted = true;
          }
          return;
        }
        finally {}
      }
      if (doCheckParam() == 0) {
        doStart(false);
      }
    }
    else
    {
      doStart(false);
    }
  }
  
  public void updateMessageDataBaseContent(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.mUiRequest.mRec != null)
    {
      localMessageRecord = this.mUiRequest.mRec;
      if (localMessageRecord != null) {
        break label101;
      }
      logRichMediaEvent("updateDb", "msg null");
    }
    label101:
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.app == null) || (this.app.get() == null));
        localMessageRecord = ((QQAppInterface)this.app.get()).getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
        logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
        break;
      } while (!(localMessageRecord instanceof MessageForPtt));
      MessageForPtt localMessageForPtt = (MessageForPtt)localMessageRecord;
      if (!this.mUiRequest.mIsPttPreSend) {
        localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.mUiRequest.mLocalPath);
      }
      localMessageForPtt.fileSize = this.mFileSize;
      localMessageForPtt.urlAtServer = this.mResid;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.md5 = this.mMd5Str;
      localMessageForPtt.serial();
      if ((this.app != null) && (this.app.get() != null)) {
        ((QQAppInterface)this.app.get()).getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, localMessageForPtt.msgData);
      }
    } while ((this.app == null) || (this.app.get() == null) || (localMessageRecord == null) || (!(localMessageRecord instanceof MessageForPtt)) || (!((SttManager)((QQAppInterface)this.app.get()).getManager(QQManagerFactory.STT_MANAGER)).b((MessageForPtt)localMessageRecord)));
    ReportController.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
    ((SliceSttManager)((QQAppInterface)this.app.get()).getManager(QQManagerFactory.STT_MANAGER)).a((MessageForPtt)localMessageRecord, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */