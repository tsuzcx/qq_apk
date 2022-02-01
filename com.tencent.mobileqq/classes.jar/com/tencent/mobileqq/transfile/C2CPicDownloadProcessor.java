package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPicDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.PicDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class C2CPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  public C2CPicDownloadProcessor() {}
  
  public C2CPicDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.file.fileType = this.mUiRequest.mFileType;
    this.file.uniseq = this.mUiRequest.mUniseq;
    this.file.mSubMsgId = this.mUiRequest.mSubMsgId;
  }
  
  public int checkParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    String str = this.mUiRequest.mServerPath;
    if ((str != null) && (!str.equals("")) && (!str.equals("null")) && (!FileUtils.isLocalPath(str)) && (!str.startsWith("http")))
    {
      if ((this.mUiRequest.mOut == null) && (this.mUiRequest.useOutputstream))
      {
        this.mProcessorReport.setError(9302, getExpStackString(new Exception("no output stream")), null, null);
        onError();
        return -1;
      }
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicDownExtraInfo)))
      {
        this.mPicDownExtra = ((TransferRequest.PicDownExtraInfo)this.mUiRequest.mExtraObj);
        this.mRecvLen = this.mPicDownExtra.mStartDownOffset;
        return 0;
      }
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("extra obj")), null, null);
      onError();
      return -1;
    }
    ProcessorReport localProcessorReport = this.mProcessorReport;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uuid illegal ");
    localStringBuilder.append(str);
    localProcessorReport.setError(9302, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
    onError();
    return -1;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (!paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Q.richmedia.");
      ((StringBuilder)localObject1).append(TransFileUtil.getUinDesc(this.mUiRequest.mUinType));
      ((StringBuilder)localObject1).append(".");
      ((StringBuilder)localObject1).append(RichMediaUtil.getFileType(this.mUiRequest.mFileType));
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("id:");
      ((StringBuilder)localObject3).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject3).append("  ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("errCode:");
      ((StringBuilder)localObject3).append(this.mProcessorReport.errCode);
      ((StringBuilder)localObject3).append("  ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("errDesc:");
      ((StringBuilder)localObject3).append(this.mProcessorReport.errDesc);
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.mUiRequest.mNeedReport) {
      return;
    }
    if (this.mUiRequest.mBusiType == 1030) {
      return;
    }
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      localObject1 = this.mProcessorReport;
      int j = this.mProcessorReport.mReportedFlag;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((ProcessorReport)localObject1).mReportedFlag = (j | i);
      long l1 = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepDirectDown.getReportInfo(1));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepUrl.getReportInfo(2));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepTrans.getReportInfo(3));
      localObject1 = ((StringBuilder)localObject1).toString();
      this.mProcessorReport.mReportInfo.put("param_step", localObject1);
      localObject2 = this.mProcessorReport.mReportInfo;
      if (this.mDirectMsgUrlDown) {
        localObject1 = this.mProcessorReport.mStepDirectDown;
      } else {
        localObject1 = this.mProcessorReport.mStepTrans;
      }
      ((HashMap)localObject2).put("param_trans_consume", String.valueOf(((StepInfo)localObject1).getTimeConsume()));
      this.mProcessorReport.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
      this.mProcessorReport.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      this.mProcessorReport.mReportInfo.put("param_DownMode", String.valueOf(this.mUiRequest.mDownMode));
      this.mProcessorReport.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
      this.mProcessorReport.mReportInfo.put("param_quickHttp", String.valueOf(this.mProcessorReport.mSendByQuickHttp));
      localObject1 = this.mProcessorReport.mReportInfo;
      long l2 = this.mRecvLen;
      if (this.mPicDownExtra == null) {
        i = 0;
      } else {
        i = this.mPicDownExtra.mStartDownOffset;
      }
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l2 - i));
      this.mProcessorReport.mReportInfo.put("param_directFailCode", String.valueOf(this.mSSORequestReason));
      localObject1 = this.mProcessorReport.mReportInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.mDirectDownFailReason);
      ((HashMap)localObject1).put("param_directFailDesc", ((StringBuilder)localObject2).toString());
      localObject1 = this.mProcessorReport.mReportInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.inQueueCost);
      ((HashMap)localObject1).put("param_inQueueCost", ((StringBuilder)localObject2).toString());
      localObject1 = this.mProcessorReport.mReportInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.mIpFromInnerDns);
      ((HashMap)localObject1).put("ipFromDns", ((StringBuilder)localObject2).toString());
      localObject1 = this.mProcessorReport.mReportInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.mPicEncryptRollback);
      ((StringBuilder)localObject2).append(",decryptErrorMsg:");
      ((StringBuilder)localObject2).append(this.mDecryptErrorMsg);
      ((HashMap)localObject1).put("param_encryptRollback", ((StringBuilder)localObject2).toString());
      localObject3 = this.mProcessorReport.mReportInfo;
      boolean bool = this.mPicEncryptRollback;
      localObject2 = "1";
      if (bool) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      ((HashMap)localObject3).put("param_encRetry", localObject1);
      localObject3 = this.mProcessorReport.mReportInfo;
      if (this.mIsHttpsDownload) {
        localObject1 = localObject2;
      } else {
        localObject1 = "0";
      }
      ((HashMap)localObject3).put("param_isHttps", localObject1);
      if ((this.mNetReq != null) && (((HttpNetReq)this.mNetReq).decoder != null))
      {
        localObject1 = (HttpNetReq)this.mNetReq;
        this.mProcessorReport.mReportInfo.put("param_picDecryptTime", String.valueOf(((PicCryptor)((HttpNetReq)localObject1).decoder).b));
      }
      localObject2 = this.mUiRequest.mRec;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.mProcessorReport.mReportInfo.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      checkFailCodeReport(paramBoolean);
      if (paramBoolean)
      {
        reportForIpv6(true, l1);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l1, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
      }
      else
      {
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        reportForIpv6(false, l1);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l1, 0L, this.mProcessorReport.mReportInfo, "");
      }
      setReportFlag();
      super.doReport(paramBoolean, "C2CPicDownloadErrorCode", l1, this.mProcessorReport.mReportInfo);
    }
  }
  
  protected String getReportTAG()
  {
    if (this.mUiRequest.mFileType == 65537) {
      return "actC2CPicSmallDownV1";
    }
    return "actC2CPicDownloadV1";
  }
  
  public boolean isAllowEncrypt(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.mUiRequest.bEnableEnc) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x1) != 0);
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.PicDownResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.mIpList);
          this.mDownDomain = paramRichProtoReq.domain;
          this.mUrlPath = paramRichProtoReq.urlPath;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("picResp.protocolType = ");
            localStringBuilder.append(paramRichProtoReq.protocolType);
            logRichMediaEvent("proUrl", localStringBuilder.toString());
          }
          if (paramRichProtoReq.protocolType == 1) {
            receiveFile(true);
          } else {
            receiveFile(false);
          }
          i += 1;
        }
        else
        {
          onError();
        }
      }
    }
  }
  
  void receiveFile(boolean paramBoolean)
  {
    this.mIsHttpsDownload = paramBoolean;
    this.mRSMReporter.mIsHttps = paramBoolean;
    this.mProcessorReport.mStepTrans.logStartTime();
    if (this.mIsCancel) {
      return;
    }
    if (TextUtils.isEmpty(this.mDownDomain)) {
      this.mDownDomain = "c2cpicdw.qpic.cn";
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    if (paramBoolean) {
      localObject1 = "https://";
    } else {
      localObject1 = "http://";
    }
    StringBuilder localStringBuilder;
    if (this.isDomainTest)
    {
      this.mIpList.clear();
      localHttpNetReq.mIsHostIP = false;
      localHttpNetReq.mHostForHttpsVerify = "c2cpicdw.qpic.cn";
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("c2cpicdw.qpic.cn");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else if ((this.mIpList != null) && (this.mIpList.size() > 0))
    {
      localHttpNetReq.mIsHostIP = true;
      localObject2 = (ServerAddr)this.mIpList.get(0);
      if ((((ServerAddr)localObject2).isIpv6) && (!((ServerAddr)localObject2).mIp.startsWith("[")))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("[");
        localStringBuilder.append(((ServerAddr)localObject2).mIp);
        localStringBuilder.append("]");
        localObject1 = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(((ServerAddr)localObject2).mIp);
        localObject1 = localStringBuilder.toString();
      }
      if (((ServerAddr)localObject2).port != 80)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(":");
        localStringBuilder.append(((ServerAddr)localObject2).port);
        localObject1 = localStringBuilder.toString();
      }
    }
    else
    {
      localHttpNetReq.mIsHostIP = false;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.mDownDomain);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.mUrlPath);
    Object localObject1 = appendInfoForSvr(((StringBuilder)localObject2).toString(), this.mUiRequest.mDownMode);
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mFailedListener = this;
    localHttpNetReq.mReqUrl = ((String)localObject1);
    localHttpNetReq.mIsHttps = paramBoolean;
    localHttpNetReq.mHostForHttpsVerify = this.mDownDomain;
    localHttpNetReq.mHttpMethod = 0;
    TransFileUtil.addDomainToList(this.mIpList, this.mDownDomain);
    localHttpNetReq.mServerList = this.mIpList;
    localHttpNetReq.mOutPath = this.mUiRequest.mOutFilePath;
    if (this.mUiRequest.useOutputstream) {
      localHttpNetReq.mOutStream = this.mUiRequest.mOut;
    }
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mStartDownOffset = 0L;
    localHttpNetReq.mIsNetChgAsError = true;
    int i = getDownloadStatus(this.mUiRequest);
    if (i == 4)
    {
      localHttpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
      localHttpNetReq.mEndDownOffset = 0L;
      localHttpNetReq.mIsRenameInEngine = false;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bytes=");
      ((StringBuilder)localObject2).append(this.mUiRequest.mRequestOffset);
      ((StringBuilder)localObject2).append("-");
      localObject2 = ((StringBuilder)localObject2).toString();
      localHttpNetReq.mReqProperties.put("Range", localObject2);
    }
    else if ((i != 3) && (i != 2))
    {
      localHttpNetReq.mEndDownOffset = 0L;
      localObject2 = localHttpNetReq.mReqProperties;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bytes=");
      localStringBuilder.append(localHttpNetReq.mStartDownOffset);
      localStringBuilder.append("-");
      ((HashMap)localObject2).put("Range", localStringBuilder.toString());
    }
    else
    {
      localHttpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
      localHttpNetReq.mEndDownOffset = (this.mUiRequest.mRequestOffset + this.mUiRequest.mRequestLength - 1);
      localHttpNetReq.mIsRenameInEngine = false;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bytes=");
      ((StringBuilder)localObject2).append(this.mUiRequest.mRequestOffset);
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(localHttpNetReq.mEndDownOffset);
      localObject2 = ((StringBuilder)localObject2).toString();
      localHttpNetReq.mReqProperties.put("Range", localObject2);
    }
    encryptReqInit(localHttpNetReq, (String)localObject1);
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    localHttpNetReq.mReqProperties.put("mType", "picCd");
    localHttpNetReq.mReqProperties.put("Referer", "http://im.qq.com/mobileqq");
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mPrioty = this.mUiRequest.mPrioty;
    if (this.mTimeoutProfile != null) {
      localHttpNetReq.mTimeoutParam = this.mTimeoutProfile.getTimeoutParam();
    }
    localHttpNetReq.mWhiteListContentType = new String[] { "image" };
    localHttpNetReq.mCanPrintUrl = true;
    localHttpNetReq.mUseCmwapConnectionTypeFromDpc = true;
    if (this.mDirectMsgUrlDown) {
      localHttpNetReq.mExcuteTimeLimit = 0L;
    }
    localObject2 = null;
    localObject1 = localObject2;
    if (this.mIpList != null)
    {
      localObject1 = localObject2;
      if (!this.mIpList.isEmpty()) {
        localObject1 = Arrays.toString(this.mIpList.toArray());
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("directMsgUrlDown:");
    ((StringBuilder)localObject2).append(this.mDirectMsgUrlDown);
    ((StringBuilder)localObject2).append(" ipList:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" uniSeq:");
    ((StringBuilder)localObject2).append(localHttpNetReq.mMsgId);
    ((StringBuilder)localObject2).append(" uuid:");
    ((StringBuilder)localObject2).append(this.mUiRequest.mServerPath);
    ((StringBuilder)localObject2).append(",downOffset:");
    ((StringBuilder)localObject2).append(localHttpNetReq.mStartDownOffset);
    ((StringBuilder)localObject2).append(",isEncryptUrl:");
    ((StringBuilder)localObject2).append(this.mEncryptUrl);
    ((StringBuilder)localObject2).append(",isEncryptPic:");
    ((StringBuilder)localObject2).append(this.mEncryptPic);
    ((StringBuilder)localObject2).append(",isEncryptRollbackReq:");
    ((StringBuilder)localObject2).append(this.mPicEncryptRollback);
    logRichMediaEvent("httpDown", ((StringBuilder)localObject2).toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    this.mDirectMsgUrlDown = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq = new RichProto.RichProtoReq.C2CPicDownReq();
    localC2CPicDownReq.selfUin = this.mUiRequest.mSelfUin;
    localC2CPicDownReq.peerUin = this.mUiRequest.mPeerUin;
    localC2CPicDownReq.secondUin = this.mUiRequest.mSecondId;
    localC2CPicDownReq.uinType = this.mUiRequest.mUinType;
    localC2CPicDownReq.uuid = this.mUiRequest.mServerPath;
    localC2CPicDownReq.msgTime = ((int)this.mUiRequest.mMsgTime);
    MessageRecord localMessageRecord2 = this.mUiRequest.mRec;
    MessageRecord localMessageRecord1 = localMessageRecord2;
    if (localMessageRecord2 == null) {
      localMessageRecord1 = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    }
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.mStorageSource = ((MessageForPic)localMessageRecord1).serverStoreSource;
    }
    else
    {
      this.mStorageSource = "picplatform";
      logRichMediaEvent("findDbRec", "not found");
    }
    localC2CPicDownReq.storageSource = this.mStorageSource;
    localC2CPicDownReq.fileType = this.mUiRequest.mFileType;
    boolean bool;
    if (this.mUiRequest.mUinType == 1006) {
      bool = true;
    } else {
      bool = false;
    }
    localC2CPicDownReq.isContact = bool;
    localC2CPicDownReq.protocolType = 0;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "c2c_pic_dw";
    localRichProtoReq.reqs.add(localC2CPicDownReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    }
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public void start()
  {
    super.start();
    if ((this.mEncryptUrl) && (this.mEncryptPic) && (!checkMemoryForEncrypt()))
    {
      this.mEncryptUrl = false;
      this.mEncryptPic = false;
      sendRequest();
      return;
    }
    try
    {
      directMsgUrlDown("c2cpicdw.qpic.cn", 1004);
      return;
    }
    catch (Exception localException)
    {
      ProcessorReport localProcessorReport = this.mProcessorReport;
      logRichMediaEvent("reportFailed", ProcessorReport.getExceptionMessage(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */