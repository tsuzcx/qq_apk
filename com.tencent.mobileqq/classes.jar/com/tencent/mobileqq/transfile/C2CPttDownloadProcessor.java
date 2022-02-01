package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.streamtransfile.StreamFileInfo;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPttDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import mqq.manager.ProxyIpManager;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;

public class C2CPttDownloadProcessor
  extends BasePttDownloaderProcessor
  implements NetFailedListener, Runnable
{
  String mDirectDownloadURL = null;
  private TransferRequest.PttDownExtraInfo mExtraInfo;
  private long mMsgRecTime;
  private long mMsgTime;
  String[] mProtoMsg = null;
  MessageForPtt mPtt;
  protected SttManager mSttManager;
  String mTempPath;
  private boolean useUrlIp = false;
  
  public C2CPttDownloadProcessor() {}
  
  public C2CPttDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.mProxyIpList = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(4);
    this.mSttManager = ((SttManager)this.app.getManager(QQManagerFactory.STT_MANAGER));
  }
  
  private File getUnfinishedStreamFile(long paramLong1, long paramLong2)
  {
    Object localObject = StreamDataManager.a(paramLong1, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "try get stream info " + paramLong1 + " " + paramLong2 + " " + localObject);
    }
    if (localObject != null)
    {
      StreamFileInfo localStreamFileInfo = (StreamFileInfo)((Map.Entry)localObject).getValue();
      if (localStreamFileInfo != null)
      {
        StreamDataManager.a((String)((Map.Entry)localObject).getKey());
        localStreamFileInfo.a(false);
        localObject = localStreamFileInfo.a();
        if ((localObject != null) && (((File)localObject).exists())) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public int checkParam()
  {
    super.checkParam();
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    Object localObject1 = this.mUiRequest.mServerPath;
    Object localObject2 = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    if ((localObject2 != null) && (((MessageRecord)localObject2).getPttStreamFlag() == 10001)) {
      this.mIsOldDbRec = true;
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (FileUtils.c((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      setError(9302, getExpStackString(new Exception("uuid illegal " + (String)localObject1)));
      onError();
      return -1;
    }
    this.mPtt = ((MessageForPtt)this.mUiRequest.mRec);
    this.mExtraInfo = ((TransferRequest.PttDownExtraInfo)this.mUiRequest.mExtraObj);
    this.mMsgTime = this.mPtt.msgTime;
    this.mMsgRecTime = this.mPtt.msgRecTime;
    int i = this.mPtt.voiceType;
    if ((this.mUiRequest.mOutFilePath == null) || (!FileUtils.c(this.mUiRequest.mLocalPath))) {
      if ((this.mPtt.fullLocalPath != null) && (!this.mPtt.fullLocalPath.equals(""))) {
        break label377;
      }
    }
    label377:
    for (this.mUiRequest.mOutFilePath = getPttStorePath("c2c", (String)localObject1, i);; this.mUiRequest.mOutFilePath = this.mPtt.fullLocalPath)
    {
      this.mTempPath = (this.mUiRequest.mOutFilePath + "~tmp");
      localObject1 = getUnfinishedStreamFile(this.mUiRequest.mRec.msgUid, this.mUiRequest.mRec.shmsgseq);
      if (localObject1 != null)
      {
        localObject2 = new File(this.mTempPath);
        if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
          ((File)localObject2).delete();
        }
        ((File)localObject1).renameTo((File)localObject2);
      }
      return 0;
    }
  }
  
  cmd0x346.ReqBody constructApplyDownSuccess()
  {
    int j = 17;
    cmd0x346.DownloadSuccReq localDownloadSuccReq = new cmd0x346.DownloadSuccReq();
    localDownloadSuccReq.uint64_uin.set(Long.parseLong(this.mUiRequest.mSelfUin));
    localDownloadSuccReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.mUiRequest.mServerPath));
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1000);
    localReqBody.uint32_seq.set(0);
    int i;
    if ("ftn".equals(this.mStorageSource)) {
      i = 3;
    }
    for (;;)
    {
      localReqBody.uint32_business_id.set(i);
      localReqBody.uint32_client_type.set(104);
      localReqBody.msg_download_succ_req.set(localDownloadSuccReq);
      return localReqBody;
      i = j;
      if ("pttcenter".equals(this.mStorageSource)) {
        i = j;
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    boolean bool = true;
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) {
      break label17;
    }
    label17:
    while ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    label62:
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      l1 = (System.nanoTime() - this.mStartTime) / 1000000L;
      localObject1 = this.mStepDirectDown.getReportInfo(1) + ";" + this.mStepUrl.getReportInfo(2) + ";" + this.mStepTrans.getReportInfo(3) + ";" + this.mStepMsg.getReportInfo(4);
      this.mReportInfo.put("param_step", localObject1);
      localObject2 = this.mReportInfo;
      if (!this.mIsHttpsDownload) {
        break label525;
      }
      localObject1 = "1";
      label188:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      this.mReportInfo.put("param_trans_consume", String.valueOf(this.mStepTrans.getTimeConsume()));
      this.mReportInfo.put("param_fromUin", this.mUiRequest.mPeerUin);
      this.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      this.mReportInfo.put("param_writtenSize", String.valueOf(this.mRecvLen));
      this.mReportInfo.put("param_quickHttp", String.valueOf(this.mSendByQuickHttp));
      this.mReportInfo.put("param_pttOpt", String.valueOf(PttOptimizeParams.a(this.app, this.useUrlIp)));
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "totle=" + this.mTotolLen + " written=" + this.mRecvLen);
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder().append("C2cPttDownload success: ").append(paramBoolean).append(", cost: ").append(l1).append(" directDownloadIfCan: ");
        if (this.mDirectDownloadURL == null) {
          break label533;
        }
        label414:
        QLog.d("SPD", 4, bool);
      }
      if (!paramBoolean) {
        break label539;
      }
    }
    for (;;)
    {
      try
      {
        this.mReportInfo.put("param_isSuccess", "1");
        reportForIpv6(true, l1);
        StatisticCollector.getInstance(com.tencent.qphone.base.util.BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l1, this.mTotolLen, this.mReportInfo, "");
        setReportFlag();
      }
      catch (Exception localException)
      {
        label525:
        label533:
        label539:
        long l3;
        long l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("BaseTransProcessor", 2, "report exception =" + localException.toString());
        continue;
        String str = "0X80059B4";
        continue;
      }
      localObject1 = this.mPtt;
      if (localObject1 == null) {
        break;
      }
      PTTPreDownloader.a(this.app).a(paramBoolean, this.errCode, this.mExtraInfo, (MessageForPtt)localObject1);
      return;
      i = 1;
      break label62;
      localObject1 = "0";
      break label188;
      bool = false;
      break label414;
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      if ((this.mNetReq instanceof HttpNetReq))
      {
        localObject1 = TransFileUtil.getIpAndPortFromUrl(((HttpNetReq)this.mNetReq).mReqUrl);
        if (localObject1 != null) {
          this.mReportInfo.put("param_reqIp", ((ServerAddr)localObject1).mIp);
        }
      }
      this.mReportInfo.put("param_isSuccess", "0");
      reportForIpv6(false, l1);
      StatisticCollector.getInstance(com.tencent.qphone.base.util.BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l1, 0L, this.mReportInfo, "");
      if ((this.errCode == -9527) && (this.errDesc != null) && (this.errDesc.equals("H_400_-5103017")))
      {
        if (this.mMsgRecTime > this.mMsgTime)
        {
          localObject1 = new HashMap();
          l3 = System.currentTimeMillis() / 1000L;
          l1 = (this.mMsgRecTime - this.mMsgTime) / 86400L;
          l2 = (l3 - this.mMsgTime) / 86400L;
          l3 = (l3 - this.mMsgRecTime) / 86400L;
          ((HashMap)localObject1).put("MsgOff", String.valueOf(l1));
          ((HashMap)localObject1).put("PttOff", String.valueOf(l3));
          ((HashMap)localObject1).put("OutOfTimeReason", String.valueOf(256));
          ((HashMap)localObject1).put("param_FailCode", String.valueOf(l2));
          StatisticCollector.getInstance(com.tencent.qphone.base.util.BaseApplication.getContext()).collectPerformance(null, "actC2CPTTOutOfTime", false, 0L, 0L, (HashMap)localObject1, null);
        }
        if (this.mUiRequest.mExtraObj != null)
        {
          if (this.mUiRequest.mUinType != 0) {
            continue;
          }
          localObject1 = "0X80059B2";
          localObject2 = (TransferRequest.PttDownExtraInfo)this.mUiRequest.mExtraObj;
          ReportController.b(this.app, "CliOper", "", "", (String)localObject1, (String)localObject1, PttInfoCollector.mergeDownloadPTTFromType(((TransferRequest.PttDownExtraInfo)localObject2).mFromType, ((TransferRequest.PttDownExtraInfo)localObject2).mLayer), 0, "", "", "", "8.5.5");
        }
      }
    }
  }
  
  public String getDomainRequest(String paramString)
  {
    String str = null;
    if (paramString.startsWith("http://")) {
      str = "http://" + this.mDownDomain;
    }
    for (;;)
    {
      return TransFileUtil.replaceIp(paramString, str + "/");
      if (paramString.startsWith("https://")) {
        str = "https://" + this.mDownDomain;
      }
    }
  }
  
  protected String getReportTAG()
  {
    return "actC2CPttDownload";
  }
  
  boolean isFailedByOverDue()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.errCode == -9527)
    {
      bool1 = bool2;
      if (this.errDesc != null) {
        if (!this.errDesc.equals("H_400_-5103017"))
        {
          bool1 = bool2;
          if (!this.errDesc.equals("H_400_-5103039")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttDownResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mSendByQuickHttp);
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          this.mRespUrl = paramRichProtoReq.downloadUrl;
          if ((this.mRespUrl != null) && (this.mRespUrl.startsWith("https://")))
          {
            this.mIsHttpsDownload = true;
            this.mRSMReporter.mIsHttps = true;
          }
          this.file.fileUrl = this.mRespUrl;
          if ((paramRichProtoReq.domainV4V6 != null) && (paramRichProtoReq.domainV4V6.length() > 0)) {
            this.mDownDomain = paramRichProtoReq.domainV4V6;
          }
          this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.mIpList);
          if ((this.mProxyIpList != null) && (!this.mProxyIpList.isEmpty()))
          {
            paramRichProtoReq = TransFileUtil.getIpAndPortFromUrl(this.mRespUrl);
            if (paramRichProtoReq != null) {
              this.mIpList.add(paramRichProtoReq);
            }
          }
          if (this.isDomainTest)
          {
            this.mDownDomain = "grouptalk.c2c.qq.com";
            this.mIpList.clear();
          }
          recieveFile();
          i += 1;
        }
        else
        {
          onError();
        }
      }
    }
  }
  
  /* Error */
  protected void onC2CPttSetSuccess(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 724
    //   4: ldc_w 726
    //   7: invokevirtual 153	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokevirtual 731	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   14: sipush 1000
    //   17: if_icmpeq +38 -> 55
    //   20: aload_2
    //   21: invokevirtual 731	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   24: istore 4
    //   26: aload_0
    //   27: ldc_w 732
    //   30: new 86	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 734
    //   40: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload 4
    //   45: invokevirtual 737	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 153	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: new 739	tencent/im/cs/cmd0x346/cmd0x346$RspBody
    //   58: dup
    //   59: invokespecial 740	tencent/im/cs/cmd0x346/cmd0x346$RspBody:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: invokevirtual 744	tencent/im/cs/cmd0x346/cmd0x346$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload_1
    //   70: getfield 745	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 748	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +91 -> 167
    //   79: aload_1
    //   80: getfield 745	tencent/im/cs/cmd0x346/cmd0x346$RspBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 750	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: i2l
    //   87: lstore 5
    //   89: lload 5
    //   91: ldc2_w 751
    //   94: lcmp
    //   95: ifne -41 -> 54
    //   98: aload_1
    //   99: getfield 756	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   102: invokevirtual 759	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:has	()Z
    //   105: ifeq -51 -> 54
    //   108: aload_1
    //   109: getfield 756	tencent/im/cs/cmd0x346/cmd0x346$RspBody:msg_download_succ_rsp	Ltencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp;
    //   112: invokevirtual 762	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 758	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp
    //   118: getfield 766	tencent/im/cs/cmd0x346/cmd0x346$DownloadSuccRsp:int32_ret_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   121: invokevirtual 769	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   124: istore 4
    //   126: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq -75 -> 54
    //   132: aload_0
    //   133: ldc_w 732
    //   136: new 86	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 771
    //   146: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload 4
    //   151: invokevirtual 737	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 153	com/tencent/mobileqq/transfile/C2CPttDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: astore_1
    //   162: aload_1
    //   163: invokevirtual 774	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: ldc2_w 775
    //   170: lstore 5
    //   172: goto -83 -> 89
    //   175: astore_1
    //   176: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	C2CPttDownloadProcessor
    //   0	177	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	177	2	paramFromServiceMsg	FromServiceMsg
    //   0	177	3	paramArrayOfByte	byte[]
    //   24	126	4	i	int
    //   87	84	5	l	long
    // Exception table:
    //   from	to	target	type
    //   55	63	161	java/lang/Exception
    //   69	89	161	java/lang/Exception
    //   98	160	161	java/lang/Exception
    //   63	69	175	java/lang/Exception
  }
  
  void onError()
  {
    super.onError();
    if (this.mUiRequest.mDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.a = -1;
      this.mUiRequest.mDownCallBack.a(localDownResult);
      return;
    }
    sendMessageToUpdate(2005);
  }
  
  public void onFailed(NetResp paramNetResp)
  {
    this.mRSMReporter.mFileSize = this.mRecvLen;
    reportForServerMonitor(paramNetResp, false, "actRichMediaNetMonitor_pttDown", this.mUiRequest.mServerPath);
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    onC2CPttSetSuccess(null, paramProtoResp.resp, paramProtoResp.resp.getWupBuffer());
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    BaseTransProcessor.StepInfo localStepInfo;
    boolean bool;
    if (this.mDirectDownloadURL != null)
    {
      localStepInfo = this.mStepDirectDown;
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      StringBuilder localStringBuilder = new StringBuilder().append(" result:");
      if (paramNetResp.mResult != 0) {
        break label194;
      }
      bool = true;
      label48:
      logRichMediaEvent("onHttpResp", bool);
      if (paramNetResp.mResult != 0) {
        break label199;
      }
      bool = true;
      label73:
      copyStatisInfoFromNetResp(localStepInfo, paramNetResp, bool);
      this.mTotolLen = paramNetResp.mTotalFileLen;
      if (this.mTotolLen <= 0L) {
        this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
      }
      this.mRecvLen += paramNetResp.mWrittenBlockLen;
      if (paramNetResp.mResult != 0) {
        break label204;
      }
      sendPttDownSuccess();
      onSuccess();
      this.mRSMReporter.mFileSize = this.mRecvLen;
      reportForServerMonitor(paramNetResp, true, "actRichMediaNetMonitor_pttDown", this.mUiRequest.mServerPath);
      if (this.mDirectDownloadURL != null) {
        reportDirectDownload(0);
      }
    }
    for (;;)
    {
      this.mNetReq = null;
      return;
      localStepInfo = this.mStepTrans;
      break;
      label194:
      bool = false;
      break label48;
      label199:
      bool = false;
      break label73;
      label204:
      if (this.mDirectDownloadURL != null)
      {
        requestUrlWhileDirectFailed(false);
        return;
      }
      if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
      {
        logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
        this.mNetReq = null;
        this.mNetworkChgRetryCount += 1;
        clearReprotInfo();
        sendGetUrlReq();
        return;
      }
      onError();
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    this.mPtt.url = MessageForPtt.getMsgFilePath(this.mPtt.voiceType, this.mUiRequest.mOutFilePath);
    this.mPtt.fileSize = this.mTotolLen;
    this.mPtt.urlAtServer = this.mUiRequest.mServerPath;
    Object localObject = updateMessageDataBaseContent(this.mPtt);
    if ((localObject != null) && (this.mUiRequest.mServerPath != null) && (this.mUiRequest.mServerPath.equals(((Message)localObject).pttUrl))) {
      ((Message)localObject).pttUrl = this.mUiRequest.mOutFilePath;
    }
    if (this.mSttManager.b(this.mPtt))
    {
      ReportController.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
      this.mSttManager.b(this.mPtt, 2);
    }
    if (this.mUiRequest.mDownCallBack != null)
    {
      localObject = new DownCallBack.DownResult();
      ((DownCallBack.DownResult)localObject).a = 0;
      this.mUiRequest.mDownCallBack.a((DownCallBack.DownResult)localObject);
      return;
    }
    sendMessageToUpdate(2003);
  }
  
  void recieveFile()
  {
    this.mStepTrans.logStartTime();
    String str = this.mRespUrl;
    if (TextUtils.isEmpty(this.mDownDomain)) {
      this.mDownDomain = "grouptalk.c2c.qq.com";
    }
    if ((this.mIpList != null) && (this.mIpList.size() > 0))
    {
      str = TransFileUtil.replaceIp(str, ((ServerAddr)this.mIpList.get(0)).getServerUrl(str));
      this.mIpList.remove(0);
    }
    for (;;)
    {
      addDomainToList(this.mIpList, this.mDownDomain);
      recieveFile(str);
      return;
      str = getDomainRequest(str);
    }
  }
  
  void recieveFile(String paramString)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mFailedListener = this;
    localHttpNetReq.mReqUrl = paramString;
    if (paramString.startsWith("https://")) {
      localHttpNetReq.mIsHttps = true;
    }
    localHttpNetReq.mHostForHttpsVerify = this.mDownDomain;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mServerList = this.mIpList;
    localHttpNetReq.mOutPath = this.mUiRequest.mOutFilePath;
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mStartDownOffset = 0L;
    localHttpNetReq.mIsNetChgAsError = true;
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    localHttpNetReq.mCanPrintUrl = true;
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mTempPath = this.mTempPath;
    localHttpNetReq.mUseCmwapConnectionTypeFromDpc = true;
    if (this.mDirectDownloadURL != null)
    {
      localHttpNetReq.mExcuteTimeLimit = 120000L;
      localHttpNetReq.mContinuErrorLimit = 0;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mIpList != null)
    {
      localObject1 = localObject2;
      if (!this.mIpList.isEmpty()) {
        localObject1 = Arrays.toString(this.mIpList.toArray());
      }
    }
    paramString = TransFileUtil.getIpOrDomainFromURL(paramString);
    logRichMediaEvent("httpDown", "RespDomain: " + paramString + " ipList:" + (String)localObject1 + " uuid:" + this.mUiRequest.mServerPath + " downOffset:" + localHttpNetReq.mStartDownOffset);
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    setMtype();
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  void reportDirectDownload(int paramInt)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      StatisticCollector localStatisticCollector = StatisticCollector.getInstance(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext());
      if (paramInt == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localStatisticCollector.collectPerformance(null, "C2CPTTDirectUrl", bool, 0L, 0L, localHashMap, null);
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  void requestUrlWhileDirectFailed(boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.mDirectDownloadURL != null)
        {
          if ((this.errCode == -9527) && (this.errDesc != null) && (this.errDesc.equals("H_400_-5103017")))
          {
            if (i != 0)
            {
              if (!this.useUrlIp) {
                continue;
              }
              FMTSrvAddrProvider.getInstance().getPttIpSaver().a(0);
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SPD", 4, "c2c directDownloadIfCan error");
            }
            if (!paramBoolean) {
              break label163;
            }
            reportDirectDownload(4);
            if (!isFailedByOverDue()) {
              break label171;
            }
            this.mPtt.fileSize = 2005L;
            updateMessageDataBaseContent(this.mPtt);
            onError();
            this.mDirectDownloadURL = null;
          }
        }
        else {
          return;
        }
        if (this.errCode == 9366) {
          continue;
        }
        i = 1;
        continue;
        FMTSrvAddrProvider.getInstance().onFailed(16, this.mDirectDownloadURL);
        continue;
        reportDirectDownload(3);
      }
      finally {}
      label163:
      continue;
      label171:
      sendGetUrlReq();
    }
  }
  
  public void run()
  {
    if (this.mNetReq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SPD", 2, "Direct download failed overtime = " + this.mDirectDownloadURL);
      }
      this.mNetEngine.cancelReq(this.mNetReq);
      this.mNetReq = null;
    }
    requestUrlWhileDirectFailed(true);
  }
  
  void sendGetUrlReq()
  {
    this.mStepUrl.logStartTime();
    Object localObject = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    if ((localObject != null) && ((localObject instanceof MessageForPtt)))
    {
      this.mStorageSource = ((MessageForPtt)localObject).storageSource;
      localObject = new RichProto.RichProtoReq();
      RichProto.RichProtoReq.C2CPttDownReq localC2CPttDownReq = new RichProto.RichProtoReq.C2CPttDownReq();
      localC2CPttDownReq.selfUin = this.mUiRequest.mSelfUin;
      localC2CPttDownReq.peerUin = this.mUiRequest.mPeerUin;
      localC2CPttDownReq.secondUin = this.mUiRequest.mSecondId;
      localC2CPttDownReq.uinType = this.mUiRequest.mUinType;
      localC2CPttDownReq.uuid = this.mUiRequest.mServerPath;
      localC2CPttDownReq.storageSource = this.mStorageSource;
      localC2CPttDownReq.isSelfSend = this.mUiRequest.mIsSelfSend;
      MessageForPtt localMessageForPtt = this.mPtt;
      localC2CPttDownReq.voiceType = localMessageForPtt.voiceType;
      localC2CPttDownReq.autoToText = localMessageForPtt.autoToText;
      if (1008 == localC2CPttDownReq.uinType) {
        localC2CPttDownReq.busiType = this.mPtt.busiType;
      }
      localC2CPttDownReq.downType = this.mUiRequest.mDownMode;
      ((RichProto.RichProtoReq)localObject).callback = this;
      ((RichProto.RichProtoReq)localObject).protoKey = "c2c_ptt_dw";
      ((RichProto.RichProtoReq)localObject).reqs.add(localC2CPttDownReq);
      ((RichProto.RichProtoReq)localObject).protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
      if (isAppValid()) {
        break label293;
      }
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    label293:
    do
    {
      return;
      this.mStorageSource = "pttcenter";
      logRichMediaEvent("findDbRec", "not found");
      break;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", ((RichProto.RichProtoReq)localObject).toString());
      }
    } while (!canDoNextStep());
    this.mRichProtoReq = ((RichProto.RichProtoReq)localObject);
    RichProtoProc.procRichProtoReq((RichProto.RichProtoReq)localObject);
  }
  
  void sendPttDownSuccess()
  {
    logRichMediaEvent("setSuccess", "req");
    String str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    if ("pttcenter".equals(this.mStorageSource)) {
      str = "PttCenterSvr.pb_pttCenter_CMD_REQ_DOWNLOAD_SUCC-1000";
    }
    ProtoReqManagerImpl.ProtoReq localProtoReq;
    for (;;)
    {
      cmd0x346.ReqBody localReqBody = constructApplyDownSuccess();
      localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = str;
      localProtoReq.reqBody = localReqBody.toByteArray();
      localProtoReq.fixScheduleCount = 1;
      localProtoReq.tryTime = 30000;
      localProtoReq.tryCount = 1;
      localProtoReq.callback = this;
      if (isAppValid()) {
        break;
      }
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
      return;
      if ("ftn".equals(this.mStorageSource)) {
        str = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_DOWNLOAD_SUCC-1000";
      }
    }
    ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, "")).sendProtoReq(localProtoReq);
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttCd", ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    if (this.mPtt.extFlag == -1L) {
      this.mPtt.extFlag = 0L;
    }
    if (this.mExtraInfo.mFromType == 6)
    {
      localObject = this.mPtt;
      ((MessageForPtt)localObject).extFlag |= 1L;
    }
    super.start();
    Object localObject = this.app;
    if (this.mUiRequest.mUinType == 0) {}
    for (int i = 1;; i = 4)
    {
      PttInfoCollector.reportPTTPV((QQAppInterface)localObject, i, false, 2);
      if (!this.mUiRequest.mOutFilePath.equals(this.mPtt.fullLocalPath))
      {
        this.mPtt.fullLocalPath = this.mUiRequest.mOutFilePath;
        updateMessageDataBaseContent(this.mPtt);
      }
      sendGetUrlReq();
      return;
    }
  }
  
  Message updateMessageDataBaseContent(MessageForPtt paramMessageForPtt)
  {
    Object localObject = null;
    try
    {
      paramMessageForPtt.serial();
      this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      paramMessageForPtt = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, 0);
      return paramMessageForPtt;
    }
    catch (Exception localException)
    {
      do
      {
        paramMessageForPtt = localObject;
      } while (!QLog.isColorLevel());
      QLog.d("BaseTransProcessor", 2, "updatedb", localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPttDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */