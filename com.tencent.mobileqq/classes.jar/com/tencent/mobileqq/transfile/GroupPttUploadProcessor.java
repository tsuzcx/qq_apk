package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.grap.voice.IVoiceRedPacketHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.ISttManagerService;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper.IOnCompressFinish;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttRsp;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class GroupPttUploadProcessor
  extends BaseUploadProcessor
  implements INetEventHandler, IGroupPttUploadProcessor, IVoiceChangeHelper.IOnCompressFinish
{
  public static final boolean NEW_STORE_FLAG = true;
  public static final String TAG = "GroupPttUploadProcessor";
  AppInterface app;
  BaseTransFileController mController;
  long mFileID;
  String mGroupFileKeyStr;
  boolean mHasVirtualStarted = false;
  boolean mIsGroup = true;
  private String mPttFilePath;
  BaseMessageObserver messageObserver;
  private boolean netDown = false;
  private long netDownTime = 0L;
  private long timeStamp = 0L;
  
  public GroupPttUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.mController = paramBaseTransFileController;
    this.app = this.app;
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
    this.messageObserver = ((IPttTransferTempApi)QRoute.api(IPttTransferTempApi.class)).getGroupPttUploadProcessorMsgObserver(this);
  }
  
  private void addInfoAndReport() {}
  
  private void checkConnErr()
  {
    if (this.mProcessorReport.errCode == 9004)
    {
      String str = (String)this.mProcessorReport.mReportInfo.get("param_reason");
      if ("connError_unreachable".equalsIgnoreCase(str))
      {
        this.mProcessorReport.mReportInfo.put("param_reason", "N_1");
        return;
      }
      if ("connError_noroute".equalsIgnoreCase(str)) {
        this.mProcessorReport.mReportInfo.put("param_reason", "N_2");
      }
    }
  }
  
  private void fillPttRichTextExtraValue(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(Utils.a(paramMessageForPtt.voiceLength));
    }
  }
  
  private void fixStepTime()
  {
    if (this.mUiRequest.mIsPttPreSend)
    {
      this.mProcessorReport.mStepUrl.fixAtPttPreSend(this.mProcessorReport.mStartTime);
      this.mProcessorReport.mStepTrans.fixAtPttPreSend(this.mProcessorReport.mStartTime);
    }
  }
  
  private void logErro(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Q.richmedia.");
    ((StringBuilder)localObject).append(TransFileUtil.getUinDesc(this.mUiRequest.mUinType));
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(RichMediaUtil.getFileType(this.mUiRequest.mFileType));
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("id:");
    localStringBuilder2.append(this.mUiRequest.mUniseq);
    localStringBuilder2.append("  ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("errCode:");
    localStringBuilder2.append(this.mProcessorReport.errCode);
    localStringBuilder2.append("  ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("errDesc:");
    localStringBuilder2.append(this.mProcessorReport.errDesc);
    localStringBuilder1.append(localStringBuilder2.toString());
    QLog.d((String)localObject, 1, localStringBuilder1.toString());
  }
  
  private RichProto.RichProtoReq.PttUpReq makePttUpReq()
  {
    RichProto.RichProtoReq.PttUpReq localPttUpReq = new RichProto.RichProtoReq.PttUpReq();
    localPttUpReq.fileName = this.mFileName;
    localPttUpReq.fileSize = ((int)this.mFileSize);
    localPttUpReq.md5 = this.mLocalMd5;
    localPttUpReq.voiceLength = ((IQQRecorderTempApi)QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(this.mUiRequest.mRec);
    localPttUpReq.audioPanelType = this.mUiRequest.mPttUploadPanel;
    localPttUpReq.voiceType = ((MessageForPtt)this.mUiRequest.mRec).voiceType;
    localPttUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPttUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPttUpReq.secondUin = this.mUiRequest.mSecondId;
    localPttUpReq.uinType = this.mUiRequest.mUinType;
    if (this.mUiRequest.mUinType == 1026)
    {
      localPttUpReq.uinType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    return localPttUpReq;
  }
  
  private void resetStatictisInfo()
  {
    this.file.stepSig.reset();
    this.file.stepUrl.reset();
    this.file.stepTrans.reset();
    this.file.stepNotify.reset();
    ProcessorReport localProcessorReport = this.mProcessorReport;
    FileMsg localFileMsg = this.file;
    long l = System.nanoTime();
    localFileMsg.startTime = l;
    localProcessorReport.mStartTime = l;
    this.file.endTime = 0L;
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
  
  /* Error */
  protected im_msg_body.RichText constructPTTRichText()
  {
    // Byte code:
    //   0: new 131	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 385	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getfield 388	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 146	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_2
    //   17: getfield 392	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 163	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   24: getfield 291	com/tencent/mobileqq/transfile/TransferRequest:mSelfUin	Ljava/lang/String;
    //   27: invokestatic 398	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 402	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_2
    //   34: getfield 405	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 407	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mFileID	J
    //   41: l2i
    //   42: invokevirtual 146	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 409	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mGroupFileKeyStr	Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +23 -> 74
    //   54: aload_2
    //   55: getfield 413	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 409	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mGroupFileKeyStr	Ljava/lang/String;
    //   62: ldc_w 415
    //   65: invokevirtual 419	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 425	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 430	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: ldc_w 432
    //   77: invokestatic 71	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   80: checkcast 432	com/tencent/mobileqq/ptt/temp/api/IPttTempApi
    //   83: aload_0
    //   84: getfield 51	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:app	Lcom/tencent/common/app/AppInterface;
    //   87: aload_0
    //   88: getfield 51	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:app	Lcom/tencent/common/app/AppInterface;
    //   91: invokevirtual 437	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   94: invokeinterface 441 3 0
    //   99: istore_1
    //   100: new 443	tencent/im/msg/im_msg_body$Elem
    //   103: dup
    //   104: invokespecial 444	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   107: astore_3
    //   108: new 446	tencent/im/msg/im_msg_body$ElemFlags2
    //   111: dup
    //   112: invokespecial 447	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   115: astore 4
    //   117: aload 4
    //   119: getfield 450	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: iload_1
    //   123: invokevirtual 146	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   126: aload_3
    //   127: getfield 454	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   130: aload 4
    //   132: invokevirtual 457	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   135: aload_2
    //   136: getfield 461	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   139: iconst_1
    //   140: invokevirtual 465	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   143: aload_2
    //   144: getfield 468	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   147: aload_0
    //   148: getfield 260	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mFileSize	J
    //   151: l2i
    //   152: invokevirtual 146	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   155: aload_2
    //   156: getfield 471	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   159: aload_0
    //   160: getfield 267	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mLocalMd5	[B
    //   163: invokestatic 425	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   166: invokevirtual 430	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   169: aload_2
    //   170: getfield 474	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   173: aload_0
    //   174: getfield 254	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mFileName	Ljava/lang/String;
    //   177: invokestatic 478	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   180: invokevirtual 430	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   183: ldc_w 480
    //   186: invokestatic 71	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   189: checkcast 480	com/tencent/mobileqq/data/utils/IMessageForPttUtilsApi
    //   192: aload_0
    //   193: getfield 163	com/tencent/mobileqq/transfile/GroupPttUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   196: getfield 276	com/tencent/mobileqq/transfile/TransferRequest:mRec	Lcom/tencent/mobileqq/data/MessageRecord;
    //   199: checkcast 137	com/tencent/mobileqq/data/MessageForPtt
    //   202: invokeinterface 484 2 0
    //   207: astore 4
    //   209: aload 4
    //   211: ifnull +15 -> 226
    //   214: aload_2
    //   215: getfield 487	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: aload 4
    //   220: invokestatic 425	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: invokevirtual 430	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   226: new 125	tencent/im/msg/im_msg_body$RichText
    //   229: dup
    //   230: invokespecial 488	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   233: astore 4
    //   235: aload 4
    //   237: getfield 129	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   240: aload_2
    //   241: invokevirtual 489	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   244: aload 4
    //   246: getfield 493	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   249: aload_3
    //   250: invokevirtual 498	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   253: aload 4
    //   255: areturn
    //   256: astore_2
    //   257: invokestatic 313	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +13 -> 273
    //   263: ldc 17
    //   265: iconst_2
    //   266: ldc_w 500
    //   269: aload_2
    //   270: invokestatic 504	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: aconst_null
    //   274: areturn
    //   275: astore_3
    //   276: goto -202 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	GroupPttUploadProcessor
    //   99	24	1	i	int
    //   7	234	2	localPtt	im_msg_body.Ptt
    //   256	14	2	localException	Exception
    //   49	201	3	localObject1	Object
    //   275	1	3	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   115	139	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	50	256	java/lang/Exception
    //   54	74	256	java/lang/Exception
    //   74	209	256	java/lang/Exception
    //   214	226	256	java/lang/Exception
    //   226	253	256	java/lang/Exception
    //   54	74	275	java/io/UnsupportedEncodingException
  }
  
  public void copyStatisInfo(StepInfo paramStepInfo, boolean paramBoolean1, boolean paramBoolean2, StatictisInfo paramStatictisInfo)
  {
    this.mProcessorReport.copyStatisInfo(paramStepInfo, paramBoolean1, paramBoolean2, paramStatictisInfo);
  }
  
  protected int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    int i = this.mUiRequest.mUinType;
    if ((i != 1) && (i != 1026)) {
      this.mIsGroup = false;
    } else {
      this.mIsGroup = true;
    }
    if (this.mUiRequest.mRec == null)
    {
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("message null")), null, null);
      onError();
      return -1;
    }
    Object localObject1 = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
      onError();
      return -1;
    }
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
    this.mPttFilePath = ((String)localObject1);
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
    this.mExtName = "amr";
    return 0;
  }
  
  public void doOnSendSuc(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() != 0))
      {
        paramArrayOfByte = (cmd0x388.TryUpPttRsp)paramArrayOfByte.get(0);
        if (paramArrayOfByte.uint64_fileid.has()) {
          this.mFileID = paramArrayOfByte.uint64_fileid.get();
        }
        if (paramArrayOfByte.bytes_file_key.has()) {
          this.mGroupFileKeyStr = new String(paramArrayOfByte.bytes_file_key.get().toByteArray(), "utf-8");
        }
      }
      else
      {
        throw new Exception("resps null");
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("GroupPttUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
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
        QLog.d("GroupPttUploadProcessor", 2, paramArrayOfByte.toString());
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
            QLog.d("GroupPttUploadProcessor", 4, "group send file success, wait for send msg");
          }
        }
        else
        {
          sendMsg();
          this.file.closeInputStream();
          if (this.mUiRequest.mIsPttPreSend)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("GroupPttUploadProcessor", 4, "group send file success, can send msg, direct send");
            }
            ((IPttPreSendService)this.app.getRuntimeService(IPttPreSendService.class, "all")).doOnPreSendEnd(getKey());
          }
        }
        this.file.closeInputStream();
        if (QLog.isColorLevel()) {
          QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
        }
        reportForServerMonitor("actRichMediaNetMonitor_pttUp", true, 0, (String)paramHashMap.get("ip"), (String)paramHashMap.get("port"), this.mMd5Str, this.mUuid, null);
        return;
      }
      finally {}
    }
  }
  
  protected void doRealReport(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramBoolean)
    {
      collectChnlCostReport();
      if (this.mUiRequest.mIsPresend)
      {
        long l;
        if (this.mEnterAioTime != 0L) {
          l = (paramLong2 - this.mEnterAioTime) / 1000000L;
        } else {
          l = 0L;
        }
        if (this.mUiRequest.myPresendInvalid) {
          l = paramLong1;
        }
        double d1 = l;
        double d2 = paramLong1;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        if ((d1 >= 0.0D) && (d1 <= 1.0D))
        {
          localObject = this.mProcessorReport.mReportInfo;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(d1);
          localStringBuilder.append("");
          ((HashMap)localObject).put("param_AIOPercent", localStringBuilder.toString());
        }
        Object localObject = this.mProcessorReport.mReportInfo;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        ((HashMap)localObject).put("param_AIODuration", localStringBuilder.toString());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("doReport ,mStartTime = ");
          ((StringBuilder)localObject).append(this.mProcessorReport.mStartTime);
          ((StringBuilder)localObject).append(",mEnterAioTime = ");
          ((StringBuilder)localObject).append(this.mEnterAioTime);
          ((StringBuilder)localObject).append(",finishTime  = ");
          ((StringBuilder)localObject).append(paramLong2);
          ((StringBuilder)localObject).append(", aioDuration = ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(", duration = ");
          ((StringBuilder)localObject).append(paramLong1);
          ((StringBuilder)localObject).append("processor:");
          ((StringBuilder)localObject).append(this);
          ((StringBuilder)localObject).append(",mUiRequest.myPresendInvalid = ");
          ((StringBuilder)localObject).append(this.mUiRequest.myPresendInvalid);
          ((StringBuilder)localObject).append(",Percent = ");
          ((StringBuilder)localObject).append(d1);
          QLog.d("GroupPttUploadProcessor", 2, ((StringBuilder)localObject).toString());
        }
      }
      this.mProcessorReport.mReportInfo.put("param_isSuccess", "1");
      this.mProcessorReport.reportForIpv6(true, paramLong1, true, getReportTAG());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, paramLong1, this.mFileSize, this.mProcessorReport.mReportInfo, "");
    }
    else
    {
      if (this.mProcessorReport.errCode != -9527) {
        this.mProcessorReport.mReportInfo.remove("param_rspHeader");
      }
      this.mProcessorReport.mReportInfo.remove("param_url");
      this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
      this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
      this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mProcessorReport.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
      this.mProcessorReport.mReportInfo.put("param_isSuccess", "0");
      this.mProcessorReport.reportForIpv6(false, paramLong1, true, getReportTAG());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, paramLong1, this.mFileSize, this.mProcessorReport.mReportInfo, "");
    }
    setReportFlag();
  }
  
  protected void doReport(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void doStart(boolean paramBoolean)
  {
    if (!paramBoolean) {
      sendMessageToUpdate(1001);
    }
    sendMessageToUpdate(1000);
    this.file.closeInputStream();
    sendMessageToUpdate(1001);
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
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportPttSendCost(this.mUiRequest.mLocalPath, false, false, i, l);
    this.app.getHwEngine().preConnect();
    sendFileByBDH();
  }
  
  public long getFileStatus()
  {
    if (this.mUiRequest.mPttCompressFinish) {
      return super.getFileStatus();
    }
    return 7000L;
  }
  
  public im_msg_body.RichText getNewestPTTRichText(MessageForPtt paramMessageForPtt)
  {
    im_msg_body.RichText localRichText = constructPTTRichText();
    fillPttRichTextExtraValue(localRichText, paramMessageForPtt);
    return localRichText;
  }
  
  protected String getReportTAG()
  {
    if (this.mIsGroup) {
      return "actGrpPttUp";
    }
    return "actDisscusPttUp";
  }
  
  public TransferRequest getRequest()
  {
    return this.mUiRequest;
  }
  
  public StepInfo getStepMsg()
  {
    return this.mProcessorReport.mStepMsg;
  }
  
  void inter_retry()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((this.mUkey != null) && (this.mFileID != 0L))
    {
      if (this.mTransferedSize >= this.mFileSize)
      {
        sendMsg();
        return;
      }
      if ((this.mChannelStatus == 1) && (this.mTrans != null))
      {
        log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.app.getHwEngine().resumeTransactionTask(this.mTrans);
        return;
      }
      start();
      return;
    }
    start();
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
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = -1;
      localSendResult.b = this.mProcessorReport.errCode;
      localSendResult.c = this.mProcessorReport.errDesc;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    if (this.mUiRequest.mIsPttPreSend) {
      ((IPttPreSendService)this.app.getRuntimeService(IPttPreSendService.class, "all")).doOnPreSendEnd(getKey());
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
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.e = this.mFileSize;
      localSendResult.g = this.mMd5Str;
      localSendResult.f = this.mFileName;
      localSendResult.d = this.mUiRequest.mLocalPath;
      localSendResult.h = this.mFileID;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    else
    {
      updateMessageDataBaseContent(true);
    }
    sendMessageToUpdate(1003);
  }
  
  public void pause()
  {
    super.pause();
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("pause", "");
      }
      sendMessageToUpdate(1006);
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
      int i = this.mChannelStatus;
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        if (this.mTrans != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("<BDH_LOG> pause() pause BDH channel, transation id=");
          localStringBuilder.append(this.mTrans.getTransationId());
          log(localStringBuilder.toString());
          this.app.getHwEngine().stopTransactionTask(this.mTrans);
          return;
        }
        log("<BDH_LOG> pause() pause BDH channel, but trans == null");
        return;
      }
      log("<BDH_LOG> pause() BUT current status is INIT");
    }
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
      return 0;
    }
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      sendMessageToUpdate(1002);
      if (this.mChannelStatus != 1) {
        this.mUkey = null;
      }
      this.mServerRollbackCount = 0;
      this.mTryCount = 0;
      this.mReqUrlCount = 0;
      this.mProcessorReport.errCode = 0;
      this.mProcessorReport.errDesc = "";
      resetStatictisInfo();
      this.mController.mHandler.post(new GroupPttUploadProcessor.3(this));
    }
    return 0;
  }
  
  void sendDiscussMsg()
  {
    Object localObject2 = constructPTTRichText();
    if (localObject2 == null)
    {
      this.mProcessorReport.setError(9368, "constructpberror", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (this.mUiRequest.mRec != null) {
      localObject1 = this.mUiRequest.mRec;
    } else {
      localObject1 = ((IPttTempApi)QRoute.api(IPttTempApi.class)).getMsgItemByUniseq(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    }
    Object localObject3;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt)))
    {
      localObject3 = (MessageForPtt)this.mUiRequest.mRec;
      fillPttRichTextExtraValue((im_msg_body.RichText)localObject2, (MessageForPtt)localObject3);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---sendDiscussMsg voiceType：");
        localStringBuilder.append(((MessageForPtt)localObject3).voiceType);
        localStringBuilder.append(" voiceLengh:");
        localStringBuilder.append(((MessageForPtt)localObject3).voiceLength);
        QLog.d("RecordParams", 2, localStringBuilder.toString());
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (this.needSendMsg)
      {
        if (((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isNeedInterceptSend((MessageRecord)localObject1))
        {
          ((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).checkAndSendMessage((MessageRecord)localObject1, this.messageObserver, this.mFileID, this.mLocalMd5, null, this);
          return;
        }
        ((IPttTempApi)QRoute.api(IPttTempApi.class)).sendMessage(this.app, (MessageRecord)localObject1, this.messageObserver);
        return;
      }
      if (this.mUiRequest.mUpCallBack != null)
      {
        ((MessageForPtt)localObject3).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject3).voiceType, this.mUiRequest.mLocalPath);
        ((MessageForPtt)localObject3).fileSize = this.mFileSize;
        ((MessageForPtt)localObject3).urlAtServer = this.mFileName;
        ((MessageForPtt)localObject3).itemType = 2;
        ((MessageForPtt)localObject3).groupFileID = this.mFileID;
        ((MessageForPtt)localObject3).groupFileKeyStr = this.mGroupFileKeyStr;
        ((MessageForPtt)localObject3).md5 = this.mMd5Str;
        ((MessageForPtt)localObject3).serial();
        this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject2);
      }
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Mr_");
    if (localObject1 == null)
    {
      localObject1 = "null";
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(((MessageRecord)localObject1).msgtype);
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    Object localObject1 = ((StringBuilder)localObject2).toString();
    this.mProcessorReport.setError(9368, "msgtypeError", (String)localObject1, this.mProcessorReport.mStepMsg);
    onError();
  }
  
  public void sendFileByBDH()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<BDH_LOG> sendFileByBDH Start.   this:");
      ((StringBuilder)localObject1).append(this);
      QLog.d("GroupPttUploadProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    if (this.mTrans != null) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject1 = new cmd0x388.ReqBody();
    ((cmd0x388.ReqBody)localObject1).setHasFlag(true);
    Object localObject2 = ((cmd0x388.ReqBody)localObject1).uint32_subcmd;
    int i = 3;
    ((PBUInt32Field)localObject2).set(3);
    int j = BaseHandler.getHandlerNetType();
    ((cmd0x388.ReqBody)localObject1).uint32_net_type.set(j);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GroupPttUp: net[");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("]");
      QLog.d("RecordParams", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = makePttUpReq();
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(((RichProto.RichProtoReq.PttUpReq)localObject2).selfUin).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(((RichProto.RichProtoReq.PttUpReq)localObject2).peerUin).longValue());
    localTryUpPttReq.uint64_file_id.set(0L);
    localTryUpPttReq.uint64_file_size.set(((RichProto.RichProtoReq.PttUpReq)localObject2).fileSize);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(((RichProto.RichProtoReq.PttUpReq)localObject2).md5));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((RichProto.RichProtoReq.PttUpReq)localObject2).fileName));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    Object localObject3 = localTryUpPttReq.uint32_bu_type;
    if (((RichProto.RichProtoReq.PttUpReq)localObject2).uinType != 1) {
      i = 4;
    }
    ((PBUInt32Field)localObject3).set(i);
    localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    localTryUpPttReq.uint32_voice_length.set(((RichProto.RichProtoReq.PttUpReq)localObject2).voiceLength);
    localTryUpPttReq.uint32_codec.set(((RichProto.RichProtoReq.PttUpReq)localObject2).voiceType);
    localTryUpPttReq.uint32_voice_type.set(((RichProto.RichProtoReq.PttUpReq)localObject2).audioPanelType);
    localTryUpPttReq.bool_new_up_chan.set(true);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("GroupPttUp: panel[");
      ((StringBuilder)localObject3).append(((RichProto.RichProtoReq.PttUpReq)localObject2).audioPanelType);
      ((StringBuilder)localObject3).append("] type[");
      ((StringBuilder)localObject3).append(((RichProto.RichProtoReq.PttUpReq)localObject2).voiceType);
      ((StringBuilder)localObject3).append("] length[");
      ((StringBuilder)localObject3).append(((RichProto.RichProtoReq.PttUpReq)localObject2).voiceLength);
      ((StringBuilder)localObject3).append("] size[");
      ((StringBuilder)localObject3).append(((RichProto.RichProtoReq.PttUpReq)localObject2).fileSize);
      ((StringBuilder)localObject3).append("]");
      QLog.d("RecordParams", 2, ((StringBuilder)localObject3).toString());
    }
    ((cmd0x388.ReqBody)localObject1).rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
    localObject1 = ((cmd0x388.ReqBody)localObject1).toByteArray();
    localObject2 = new GroupPttUploadProcessor.1(this, l);
    this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 29, this.mPttFilePath, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject2, (byte[])localObject1, false);
    localObject1 = new GroupPttUploadProcessor.2(this);
    this.mTrans.cbForReport = ((ITransCallbackForReport)localObject1);
    i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<BDH_LOG>sendFileByBDH Transaction submit RetCode:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" T_ID:");
      ((StringBuilder)localObject1).append(this.mTrans.getTransationId());
      ((StringBuilder)localObject1).append(" UniSeq:");
      ((StringBuilder)localObject1).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject1).append(" MD5:");
      ((StringBuilder)localObject1).append(this.mMd5Str);
      ((StringBuilder)localObject1).append(" uuid:");
      ((StringBuilder)localObject1).append(this.mUuid);
      ((StringBuilder)localObject1).append(" Path:");
      ((StringBuilder)localObject1).append(this.mTrans.filePath);
      ((StringBuilder)localObject1).append(" Cmd:");
      ((StringBuilder)localObject1).append(29);
      QLog.d("GroupPttUploadProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != 0)
    {
      this.mProcessorReport.setError(i, "sendFileByBDH SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  void sendGroupMsg()
  {
    Object localObject2 = constructPTTRichText();
    if (localObject2 == null)
    {
      this.mProcessorReport.setError(9368, "constructpberror", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    Object localObject1;
    if (this.mUiRequest.mRec != null) {
      localObject1 = this.mUiRequest.mRec;
    } else {
      localObject1 = ((IPttTempApi)QRoute.api(IPttTempApi.class)).getMsgItemByUniseq(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    }
    if (!(localObject1 instanceof MessageForPtt))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Mr_");
      if (localObject1 == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(((MessageRecord)localObject1).msgtype);
        localObject1 = ((StringBuilder)localObject3).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      this.mProcessorReport.setError(9368, "msgtypeError", (String)localObject1, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    Object localObject3 = (MessageForPtt)this.mUiRequest.mRec;
    fillPttRichTextExtraValue((im_msg_body.RichText)localObject2, (MessageForPtt)localObject3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<---sendGroupMsg voiceType：");
      localStringBuilder.append(((MessageForPtt)localObject3).voiceType);
      localStringBuilder.append(" voiceLengh:");
      localStringBuilder.append(((MessageForPtt)localObject3).voiceLength);
      QLog.d("RecordParams", 2, localStringBuilder.toString());
    }
    ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
    if ((this.mUiRequest.mUinType == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
    }
    if (this.needSendMsg)
    {
      if (((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).isNeedInterceptSend((MessageRecord)localObject1))
      {
        ((IVoiceRedPacketHelper)QRoute.api(IVoiceRedPacketHelper.class)).checkAndSendMessage((MessageRecord)localObject1, this.messageObserver, this.mFileID, this.mLocalMd5, null, this);
        return;
      }
      ((IPttTempApi)QRoute.api(IPttTempApi.class)).sendMessage(this.app, (MessageRecord)localObject1, this.messageObserver);
      return;
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      ((MessageForPtt)localObject3).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject3).voiceType, this.mUiRequest.mLocalPath);
      ((MessageForPtt)localObject3).fileSize = this.mFileSize;
      ((MessageForPtt)localObject3).urlAtServer = this.mFileName;
      ((MessageForPtt)localObject3).itemType = 2;
      ((MessageForPtt)localObject3).groupFileID = this.mFileID;
      ((MessageForPtt)localObject3).groupFileKeyStr = this.mGroupFileKeyStr;
      ((MessageForPtt)localObject3).md5 = this.mMd5Str;
      ((MessageForPtt)localObject3).serial();
      this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject2);
    }
  }
  
  void sendMsg()
  {
    if (!canDoNextStep()) {
      return;
    }
    this.mProcessorReport.mStepMsg.logStartTime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TestPicSend finish upload,currentTime = ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(",processor = ");
      localStringBuilder.append(this);
      QLog.d("GroupPttUploadProcessor", 2, localStringBuilder.toString());
    }
    if (this.mIsGroup)
    {
      sendGroupMsg();
      return;
    }
    sendDiscussMsg();
  }
  
  public void setShouldMsgReportSucc(int paramInt)
  {
    this.shouldMsgReportSucc = paramInt;
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
    MessageRecord localMessageRecord;
    if (this.mUiRequest.mRec != null)
    {
      localMessageRecord = this.mUiRequest.mRec;
    }
    else
    {
      localMessageRecord = ((IPttTempApi)QRoute.api(IPttTempApi.class)).getMsgItemByUniseq(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
    }
    if (localMessageRecord == null)
    {
      logRichMediaEvent("updateDb", "msg null");
      return;
    }
    if (localMessageRecord.isMultiMsg)
    {
      logRichMediaEvent("updateDb", "is multiMsg");
      return;
    }
    if (this.mUiRequest.mFileType == 2)
    {
      paramBoolean = localMessageRecord instanceof MessageForPtt;
      if (paramBoolean)
      {
        MessageForPtt localMessageForPtt = (MessageForPtt)localMessageRecord;
        if (!this.mUiRequest.mIsPttPreSend) {
          localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.mUiRequest.mLocalPath);
        }
        localMessageForPtt.fileSize = this.mFileSize;
        localMessageForPtt.urlAtServer = this.mFileName;
        localMessageForPtt.itemType = 2;
        localMessageForPtt.groupFileID = this.mFileID;
        localMessageForPtt.groupFileKeyStr = this.mGroupFileKeyStr;
        localMessageForPtt.md5 = this.mMd5Str;
        localMessageForPtt.serial();
        ((IPttTempApi)QRoute.api(IPttTempApi.class)).updateMsgContentByUniseq(this.app, this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, localMessageForPtt.msgData);
        if ((localMessageRecord != null) && (paramBoolean) && (((ISttManagerService)this.app.getRuntimeService(ISttManagerService.class, "all")).needAuotoChange(localMessageForPtt)))
        {
          ReportController.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
          ((ISttManagerService)this.app.getRuntimeService(ISttManagerService.class, "all")).translate(localMessageForPtt, 2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */