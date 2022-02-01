package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi;
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
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.pttlogic.api.IPttSSCMPool;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.grap.voice.IVoiceRedPacketHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper.IOnCompressFinish;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.ProxyIpManager;
import mqq.util.WeakReference;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.TmpPtt;

public class C2CPttUploadProcessor
  extends BaseUploadProcessor
  implements INetEventHandler, IC2CPttUploadProcessor, IVoiceChangeHelper.IOnCompressFinish
{
  public static final String TAG = "C2CPicUploadProcessor";
  private static int s0x346Seq;
  WeakReference<AppInterface> app = new WeakReference(this.app);
  String mFileKey;
  boolean mHasVirtualStarted = false;
  private String mPttFilePath;
  BaseMessageObserver messageObserver;
  private boolean netDown = false;
  private long netDownTime = 0L;
  private long timeStamp = 0L;
  
  public C2CPttUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    paramBaseTransFileController = (ProxyIpManager)((AppInterface)this.app.get()).getManager(3);
    try
    {
      paramBaseTransFileController = ((IPttSSCMPool)QRoute.api(IPttSSCMPool.class)).getSSCM();
      this.sscmObject = paramBaseTransFileController;
      AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
      this.messageObserver = ((IPttTransferTempApi)QRoute.api(IPttTransferTempApi.class)).getC2CPttUploadProcessorMsgObserver(this);
      return;
    }
    finally {}
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
  
  public byte[] c2cConstructPTTExtraInfo()
  {
    return ((IMessageForPttUtilsApi)QRoute.api(IMessageForPttUtilsApi.class)).c2cConstructPTTExtraInfo((MessageForPtt)this.mUiRequest.mRec);
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
          ((im_msg_body.Ptt)localObject1).uint32_server_ip.set(ipToLong(((ServerAddr)localObject2).mIp));
          ((im_msg_body.Ptt)localObject1).uint32_server_port.set(((ServerAddr)localObject2).port);
        }
        localObject2 = new im_msg_body.Elem();
        Object localObject3 = new im_msg_body.ElemFlags2();
        if ((this.app != null) && (this.app.get() != null))
        {
          i = ((IPttTempApi)QRoute.api(IPttTempApi.class)).getPttVipFlag((AppRuntime)this.app.get(), ((AppInterface)this.app.get()).getCurrentAccountUin());
          ((im_msg_body.ElemFlags2)localObject3).uint32_vip_status.set(i);
        }
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.Ptt)localObject1).bool_valid.set(true);
        ((im_msg_body.Ptt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
        ((im_msg_body.Ptt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
        ((im_msg_body.Ptt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mFileName));
        ((im_msg_body.Ptt)localObject1).uint32_file_size.set((int)this.mFileSize);
        localObject3 = c2cConstructPTTExtraInfo();
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
        localObject2 = ((AppInterface)this.app.get()).getCurrentAccountUin();
        i = ((IPttTempApi)QRoute.api(IPttTempApi.class)).getPttVipFlag((AppRuntime)this.app.get(), (String)localObject2);
        ((im_msg_body.TmpPtt)localObject1).uint32_user_type.set(i);
      }
      ((im_msg_body.TmpPtt)localObject1).uint64_ptt_times.set(((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(this.mUiRequest.mRec));
      if (this.mUiRequest.mUinType == 1008) {
        ((im_msg_body.TmpPtt)localObject1).uint32_busi_type.set(3);
      }
      Object localObject2 = (MessageForPtt)this.mUiRequest.mRec;
      localObject2 = ((IMessageForPttUtilsApi)QRoute.api(IMessageForPttUtilsApi.class)).c2cConstructPttReserveInfo((MessageForPtt)localObject2);
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
  
  public void copyStatisInfo(StepInfo paramStepInfo, boolean paramBoolean1, boolean paramBoolean2, StatictisInfo paramStatictisInfo)
  {
    this.mProcessorReport.copyStatisInfo(paramStepInfo, paramBoolean1, paramBoolean2, paramStatictisInfo);
  }
  
  int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    Object localObject1 = this.mUiRequest.mLocalPath;
    if ((localObject1 != null) && (!"".equals(localObject1)))
    {
      if (localObject1 != null)
      {
        this.mPttFilePath = ((String)localObject1);
        Object localObject2 = new File((String)localObject1);
        StringBuilder localStringBuilder;
        if (!((File)localObject2).exists())
        {
          localObject2 = this.mProcessorReport;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendFile not exist ");
          localStringBuilder.append((String)localObject1);
          ((ProcessorReport)localObject2).setError(9042, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
          onError();
          return -1;
        }
        if (!((File)localObject2).canRead())
        {
          localObject1 = this.mProcessorReport;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sendFile not readable ");
          ((StringBuilder)localObject2).append(this.file.filePath);
          ((ProcessorReport)localObject1).setError(9070, getExpStackString(new Exception(((StringBuilder)localObject2).toString())), null, null);
          onError();
          return -1;
        }
        this.mExtName = "amr";
        long l = ((File)localObject2).length();
        this.file.fileSize = l;
        this.mFileSize = l;
        if (l <= 0L)
        {
          localObject2 = this.mProcessorReport;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file size 0 ");
          localStringBuilder.append((String)localObject1);
          ((ProcessorReport)localObject2).setError(9071, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
          onError();
          return -1;
        }
      }
      return 0;
    }
    this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
    onError();
    return -1;
  }
  
  public void doOnSendSuc(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
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
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
      }
    }
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("<BDH_LOG> Transaction End : Success. New : SendTotalCost:");
      paramArrayOfByte.append(l - paramLong);
      paramArrayOfByte.append("ms ,fileSize:");
      paramArrayOfByte.append(this.file.fileSize);
      paramArrayOfByte.append(" transInfo:");
      paramArrayOfByte.append((String)paramHashMap.get("rep_bdhTrans"));
      QLog.d("C2CPicUploadProcessor", 2, paramArrayOfByte.toString());
    }
    addBDHReportInfo(paramHashMap);
    this.mProcessorReport.mStepTrans.logFinishTime();
    this.mProcessorReport.mStepTrans.result = 1;
    this.mTransferedSize = this.mFileSize;
    try
    {
      if ((this.mUiRequest.mIsPttPreSend) && (!this.mUiRequest.mCanSendMsg))
      {
        this.mUiRequest.mCanSendMsg = true;
        if (QLog.isDevelopLevel()) {
          QLog.d("C2CPicUploadProcessor", 4, "presend file success, wait for send msg");
        }
      }
      else
      {
        sendProgressMessage();
        sendMsg();
        if (this.mUiRequest.mIsPttPreSend)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("C2CPicUploadProcessor", 4, "presend file success, can send msg, direct send");
          }
          if ((this.app != null) && (this.app.get() != null)) {
            ((IPttPreSendService)((AppInterface)this.app.get()).getRuntimeService(IPttPreSendService.class, "all")).doOnPreSendEnd(getKey());
          }
        }
      }
      this.file.closeInputStream();
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      String str1 = (String)paramHashMap.get("ip");
      paramHashMap = (String)paramHashMap.get("port");
      String str2 = this.mMd5Str;
      if (this.mResid == null) {
        paramArrayOfByte = this.mUuid;
      } else {
        paramArrayOfByte = this.mResid;
      }
      reportForServerMonitor("actRichMediaNetMonitor_pttUp", true, 0, str1, paramHashMap, str2, paramArrayOfByte, null);
      return;
    }
    finally {}
  }
  
  protected void doReport(boolean paramBoolean)
  {
    try
    {
      ((IPttSSCMPool)QRoute.api(IPttSSCMPool.class)).returnObject(this.sscmObject);
      if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
        return;
      }
      if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
      {
        if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
          return;
        }
        Object localObject1 = this.mProcessorReport;
        int j = this.mProcessorReport.mReportedFlag;
        int i;
        if (paramBoolean) {
          i = 2;
        } else {
          i = 1;
        }
        ((ProcessorReport)localObject1).mReportedFlag = (j | i);
        this.mProcessorReport.mEndTime = System.currentTimeMillis();
        long l2 = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
        if (this.mUiRequest.mIsPttPreSend)
        {
          this.mProcessorReport.mStepUrl.fixAtPttPreSend(this.mProcessorReport.mStartTime);
          this.mProcessorReport.mStepTrans.fixAtPttPreSend(this.mProcessorReport.mStartTime);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.mProcessorReport.mStepUrl.getReportInfo(1));
        ((StringBuilder)localObject1).append(";");
        ((StringBuilder)localObject1).append(this.mProcessorReport.mStepTrans.getReportInfo(2));
        ((StringBuilder)localObject1).append(";");
        ((StringBuilder)localObject1).append(this.mProcessorReport.mStepMsg.getReportInfo(3));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.mProcessorReport.mReportInfo.put("param_step", localObject1);
        Object localObject3 = this.mProcessorReport.mReportInfo;
        if (this.mResid == null) {
          localObject1 = this.mUuid;
        } else {
          localObject1 = this.mResid;
        }
        ((HashMap)localObject3).put("param_uuid", localObject1);
        this.mProcessorReport.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
        this.mProcessorReport.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
        this.mProcessorReport.mReportInfo.put("param_quickHttp", String.valueOf(this.mProcessorReport.mSendByQuickHttp));
        localObject1 = this.app;
        if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
          this.mProcessorReport.mReportInfo.put("param_pttOpt", String.valueOf(((IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class)).getOptString((AppRuntime)this.app.get(), false)));
        }
        if (this.netDown)
        {
          this.mProcessorReport.mReportInfo.put("param_pttNetDown", String.valueOf(this.netDownTime / 1000000L));
          if (QLog.isColorLevel()) {
            QLog.d("weak_net", 2, String.valueOf(this.netDownTime / 1000000L));
          }
        }
        ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPttUploadType(paramBoolean, this.mUiRequest.mUinType, l2, this.mFileSize);
        if (!TextUtils.isEmpty(this.mUiRequest.mLocalPath))
        {
          localObject1 = (MessageForPtt)this.mUiRequest.mRec;
          localObject3 = (IPttInfoCollector)QRoute.api(IPttInfoCollector.class);
          String str = this.mUiRequest.mLocalPath;
          if (localObject1 == null) {
            i = 0;
          } else {
            i = ((MessageForPtt)localObject1).voiceChangeFlag;
          }
          long l1;
          if (localObject1 == null) {
            l1 = 0L;
          } else {
            l1 = ((MessageForPtt)localObject1).fileSize;
          }
          ((IPttInfoCollector)localObject3).reportPttSendCost(str, true, paramBoolean, i, l1);
        }
        if (paramBoolean)
        {
          this.mProcessorReport.mReportInfo.put("param_isSuccess", "1");
          this.mProcessorReport.reportForIpv6(true, l2, true, getReportTAG());
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l2, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        else
        {
          if (this.mProcessorReport.errCode != -9527) {
            this.mProcessorReport.mReportInfo.remove("param_rspHeader");
          }
          this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
          this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
          this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
          this.mProcessorReport.mReportInfo.put("param_isSuccess", "0");
          this.mProcessorReport.reportForIpv6(false, l2, true, getReportTAG());
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l2, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        setReportFlag();
        AppNetConnInfo.unregisterNetEventHandler(this);
      }
      return;
    }
    finally {}
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
    if (this.mRaf == null)
    {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        this.mRaf = null;
      }
      if (this.mRaf == null)
      {
        this.mProcessorReport.setError(9303, "read file error", null, null);
        onError();
        return;
      }
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)this.mUiRequest.mRec;
    IPttInfoCollector localIPttInfoCollector = (IPttInfoCollector)QRoute.api(IPttInfoCollector.class);
    String str = this.mUiRequest.mLocalPath;
    int i;
    if (localMessageForPtt == null) {
      i = 0;
    } else {
      i = localMessageForPtt.voiceChangeFlag;
    }
    long l;
    if (localMessageForPtt == null) {
      l = 0L;
    } else {
      l = localMessageForPtt.fileSize;
    }
    localIPttInfoCollector.reportPttSendCost(str, false, false, i, l);
    sendFileByBDH();
  }
  
  public long getFileStatus()
  {
    if (this.mUiRequest.mPttCompressFinish) {
      return super.getFileStatus();
    }
    return 7000L;
  }
  
  protected MessageRecord getMessageRecord()
  {
    return ((IPttTempApi)QRoute.api(IPttTempApi.class)).getMsgItemByUniseq((AppRuntime)this.app.get(), this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
  }
  
  public im_msg_body.RichText getNewestPTTRichText()
  {
    return constructPTTRichText();
  }
  
  protected String getReportTAG()
  {
    return "actC2CPttUpload";
  }
  
  public StepInfo getStepMsg()
  {
    return this.mProcessorReport.mStepMsg;
  }
  
  public IVoiceRedPacketHelper getVoiceRedPacketHelper()
  {
    return (IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class);
  }
  
  public void onCompressFinished(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      this.mUiRequest.mPttCompressFinish = true;
      paramString = (MessageForPtt)this.mUiRequest.mRec;
      paramString.voiceLength = paramInt2;
      paramString.voiceType = paramInt1;
      if (!this.mHasVirtualStarted)
      {
        if (doCheckParam() == 0) {
          doStart(false);
        }
      }
      else if (doCheckParam() == 0) {
        doStart(true);
      }
      return;
    }
    finally {}
  }
  
  public void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject = new UpCallBack.SendResult();
      ((UpCallBack.SendResult)localObject).a = -1;
      ((UpCallBack.SendResult)localObject).b = this.mProcessorReport.errCode;
      ((UpCallBack.SendResult)localObject).c = this.mProcessorReport.errDesc;
      this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject);
    }
    Object localObject = this.app;
    if ((localObject != null) && (((WeakReference)localObject).get() != null) && (this.mUiRequest.mIsPttPreSend)) {
      ((IPttPreSendService)((AppInterface)this.app.get()).getRuntimeService(IPttPreSendService.class, "all")).doOnPreSendEnd(getKey());
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.timeStamp > 0L)
      {
        this.netDownTime += System.nanoTime() - this.timeStamp;
        this.timeStamp = 0L;
      }
    }
    else {
      this.timeStamp = System.nanoTime();
    }
    this.netDown = true;
  }
  
  public void onSuccess()
  {
    super.onSuccess();
    updateMessageDataBaseContent(true);
    sendMessageToUpdate(1003);
  }
  
  protected boolean queryStateByPath()
  {
    return ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).queryStateByPath(this.mUiRequest.mLocalPath, this);
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<BDH_LOG> sendFileByBDH Start.   this:");
      ((StringBuilder)localObject1).append(this);
      QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    if (this.mTrans != null) {
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    RichProto.RichProtoReq.PttUpReq localPttUpReq = makePttUpReq();
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(500);
    Object localObject1 = localReqBody.uint32_seq;
    int i = s0x346Seq;
    s0x346Seq = i + 1;
    ((PBUInt32Field)localObject1).set(i);
    localReqBody.uint32_business_id.set(17);
    localReqBody.uint32_client_type.set(104);
    cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
    localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localPttUpReq.selfUin));
    try
    {
      localObject3 = localPttUpReq.peerUin;
      localObject1 = localObject3;
      if (((String)localObject3).startsWith("+")) {
        localObject1 = ((String)localObject3).substring(1);
      }
      long l2 = Long.valueOf((String)localObject1).longValue();
      localApplyUploadReq.uint64_recver_uin.set(l2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localApplyUploadReq.uint32_file_type.set(2);
    localApplyUploadReq.str_file_name.set(localPttUpReq.fileName);
    localApplyUploadReq.uint64_file_size.set(localPttUpReq.fileSize);
    localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localPttUpReq.md5));
    localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
    Object localObject2 = new cmd0x346.ExtensionReq();
    ((cmd0x346.ExtensionReq)localObject2).uint64_id.set(3L);
    ((cmd0x346.ExtensionReq)localObject2).uint32_ptt_format.set(localPttUpReq.voiceType);
    ((cmd0x346.ExtensionReq)localObject2).uint32_ptt_time.set(localPttUpReq.voiceLength);
    i = BaseHandler.getHandlerNetType();
    ((cmd0x346.ExtensionReq)localObject2).uint32_net_type.set(i);
    ((cmd0x346.ExtensionReq)localObject2).uint32_voice_type.set(localPttUpReq.audioPanelType);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("C2CPttUp: panel[");
      ((StringBuilder)localObject3).append(localPttUpReq.audioPanelType);
      ((StringBuilder)localObject3).append("] type[");
      ((StringBuilder)localObject3).append(localPttUpReq.voiceType);
      ((StringBuilder)localObject3).append("] length[");
      ((StringBuilder)localObject3).append(localPttUpReq.voiceLength);
      ((StringBuilder)localObject3).append("] size[");
      ((StringBuilder)localObject3).append(localPttUpReq.fileSize);
      ((StringBuilder)localObject3).append("]");
      QLog.d("RecordParams", 2, ((StringBuilder)localObject3).toString());
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("C2CPttUp: net[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("]");
        QLog.d("RecordParams", 2, ((StringBuilder)localObject3).toString());
      }
    }
    setUinType(localPttUpReq, (cmd0x346.ExtensionReq)localObject2);
    if (localPttUpReq.uinType == 1008) {
      ((cmd0x346.ExtensionReq)localObject2).uint32_file_type.set(3);
    } else if (localPttUpReq.uinType == 9999) {
      ((cmd0x346.ExtensionReq)localObject2).uint32_file_type.set(102);
    }
    localReqBody.msg_extension_req.set((MessageMicro)localObject2);
    localObject2 = localReqBody.toByteArray();
    Object localObject3 = new C2CPttUploadProcessor.1(this, l1);
    this.mTrans = new Transaction(((AppInterface)this.app.get()).getCurrentAccountUin(), 26, this.mPttFilePath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject3, (byte[])localObject2, false);
    localObject2 = new C2CPttUploadProcessor.2(this);
    this.mTrans.cbForReport = ((ITransCallbackForReport)localObject2);
    i = ((AppInterface)this.app.get()).getHwEngine().submitTransactionTask(this.mTrans);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<BDH_LOG>sendFileByBDH Transaction submit RetCode:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" T_ID:");
      ((StringBuilder)localObject2).append(this.mTrans.getTransationId());
      ((StringBuilder)localObject2).append(" UniSeq:");
      ((StringBuilder)localObject2).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject2).append(" MD5:");
      ((StringBuilder)localObject2).append(this.mMd5Str);
      ((StringBuilder)localObject2).append(" uuid:");
      ((StringBuilder)localObject2).append(this.mUuid);
      ((StringBuilder)localObject2).append(" Path:");
      ((StringBuilder)localObject2).append(this.mTrans.filePath);
      ((StringBuilder)localObject2).append(" Cmd:");
      ((StringBuilder)localObject2).append(26);
      QLog.d("C2CPicUploadProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (i != 0)
    {
      this.mProcessorReport.setError(i, "sendFileByBDH SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  protected void sendMessageInner(MessageRecord paramMessageRecord)
  {
    ((IPttTempApi)QRoute.api(IPttTempApi.class)).sendMessage((AppRuntime)this.app.get(), paramMessageRecord, this.messageObserver);
  }
  
  void sendMsg()
  {
    if (!canDoNextStep()) {
      return;
    }
    this.mProcessorReport.mStepMsg.logStartTime();
    Object localObject2 = constructPTTRichText();
    if (localObject2 == null)
    {
      this.mProcessorReport.setError(9360, "constructpberror", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    Object localObject1;
    if (this.mUiRequest.mRec != null) {
      localObject1 = this.mUiRequest.mRec;
    }
    for (;;)
    {
      break;
      localObject1 = this.app;
      if ((localObject1 == null) || (((WeakReference)localObject1).get() == null)) {
        return;
      }
      localObject1 = getMessageRecord();
      logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
    }
    if (!(localObject1 instanceof MessageForPtt))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("accost_ptt", 4, "mr not ptt?......");
      }
      this.mProcessorReport.setError(9360, "constructpberror", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("accost_ptt", 4, "mr is ptt......");
    }
    Object localObject3 = (MessageForPtt)localObject1;
    Object localObject4;
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("<---sendC2CMsg voiceType：");
      ((StringBuilder)localObject4).append(((MessageForPtt)localObject3).voiceType);
      ((StringBuilder)localObject4).append(" voiceLengh:");
      ((StringBuilder)localObject4).append(((MessageForPtt)localObject3).voiceLength);
      QLog.d("RecordParams", 2, ((StringBuilder)localObject4).toString());
    }
    ((MessageForPtt)localObject3).richText = ((im_msg_body.RichText)localObject2);
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      updateMessageDataBaseContent(true);
      this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject2);
      return;
    }
    localObject2 = this.app;
    if ((localObject2 != null) && (((WeakReference)localObject2).get() != null))
    {
      localObject3 = getVoiceRedPacketHelper();
      if (((IVoiceRedPacketHelper)localObject3).isNeedInterceptSend((MessageRecord)localObject1))
      {
        localObject4 = this.messageObserver;
        byte[] arrayOfByte = this.mLocalMd5;
        if (this.mResid == null) {
          localObject2 = this.mUuid;
        } else {
          localObject2 = this.mResid;
        }
        ((IVoiceRedPacketHelper)localObject3).checkAndSendMessage((MessageRecord)localObject1, (BaseMessageObserver)localObject4, 0L, arrayOfByte, (String)localObject2, this);
        return;
      }
      sendMessageInner((MessageRecord)localObject1);
    }
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttCu", ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void setUinType(RichProto.RichProtoReq.PttUpReq paramPttUpReq, cmd0x346.ExtensionReq paramExtensionReq)
  {
    int k = paramPttUpReq.uinType;
    int j = 104;
    if (k != 0)
    {
      i = j;
      if (k == 1020) {
        break label194;
      }
      if (k != 9999) {
        if ((k != 10002) && (k != 10004))
        {
          i = j;
          if (k == 1000) {
            break label194;
          }
          if (k != 1001) {
            if (k != 1008) {
              if (k != 1009) {
                if ((k == 1023) || (k == 1024)) {
                  break label192;
                }
              }
            }
          }
        }
      }
    }
    switch (k)
    {
    default: 
      break;
    case 1006: 
      i = 102;
      paramExtensionReq.str_dst_phonenum.set(paramPttUpReq.peerUin);
      break;
    case 1004: 
      i = 105;
      break label194;
      i = 103;
      break label194;
      i = 101;
      break label194;
      i = 100;
      break label194;
      i = 114;
      break label194;
      if (paramPttUpReq.forceViaOffline) {
        i = 500;
      }
      break;
    }
    label192:
    int i = 0;
    label194:
    paramExtensionReq.uint64_type.set(i);
  }
  
  public void start()
  {
    super.start();
    if (!this.mUiRequest.mPttCompressFinish) {
      try
      {
        boolean bool = queryStateByPath();
        if (bool) {
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
        if (doCheckParam() != 0) {
          return;
        }
        doStart(false);
        return;
      }
      finally {}
    } else {
      doStart(false);
    }
  }
  
  public void updateMessageDataBaseContent(boolean paramBoolean)
  {
    Object localObject;
    if (this.mUiRequest.mRec != null)
    {
      localObject = this.mUiRequest.mRec;
    }
    else
    {
      localObject = this.app;
      if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
        return;
      }
      localObject = getMessageRecord();
      logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
    }
    if (localObject == null)
    {
      logRichMediaEvent("updateDb", "msg null");
      return;
    }
    paramBoolean = localObject instanceof MessageForPtt;
    if (paramBoolean)
    {
      MessageForPtt localMessageForPtt = (MessageForPtt)localObject;
      if (!this.mUiRequest.mIsPttPreSend) {
        localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.mUiRequest.mLocalPath);
      }
      localMessageForPtt.fileSize = this.mFileSize;
      localMessageForPtt.urlAtServer = this.mResid;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.md5 = this.mMd5Str;
      localMessageForPtt.serial();
      WeakReference localWeakReference = this.app;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq((AppRuntime)this.app.get(), this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, ((MessageRecord)localObject).uniseq, localMessageForPtt.msgData);
      }
      localWeakReference = this.app;
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (localObject != null) && (paramBoolean) && (((ISttManagerService)((AppInterface)this.app.get()).getRuntimeService(ISttManagerService.class, "all")).needAuotoChange(localMessageForPtt)))
      {
        ReportController.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
        ((ISttManagerService)((AppInterface)this.app.get()).getRuntimeService(ISttManagerService.class, "all")).translate(localMessageForPtt, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */