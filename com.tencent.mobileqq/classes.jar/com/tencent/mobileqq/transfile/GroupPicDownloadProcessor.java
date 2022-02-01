package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.RichMediaBugReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPicDownReq;
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

public class GroupPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  long mGroupFileID;
  boolean mIsGroup = true;
  byte[] mMsgFileMd5;
  
  public GroupPicDownloadProcessor() {}
  
  public GroupPicDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.file.fileType = this.mUiRequest.mFileType;
    this.file.uniseq = this.mUiRequest.mUniseq;
    this.file.mSubMsgId = this.mUiRequest.mSubMsgId;
  }
  
  private boolean shouldReport(boolean paramBoolean)
  {
    if (!this.mUiRequest.mNeedReport) {
      return false;
    }
    if (this.mUiRequest.mBusiType == 1030) {
      return false;
    }
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return false;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0))) {
      return (paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x1) <= 0);
    }
    return false;
  }
  
  public int checkParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    Object localObject1 = this.mUiRequest.mServerPath;
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (((String)localObject1).equals("null")) || (FileUtils.isLocalPath((String)localObject1)) || (((String)localObject1).startsWith("http://")))
    {
      if ((localObject1 == null) || (!((String)localObject1).startsWith("http://"))) {
        break label480;
      }
      localObject2 = parseUuidFromUrl((String)localObject1);
      if (localObject2 != null) {
        this.mUiRequest.mServerPath = ((String)localObject2);
      }
    }
    else
    {
      if ((this.mUiRequest.mOut == null) && (this.mUiRequest.useOutputstream))
      {
        setError(9302, getExpStackString(new Exception("no output stream")));
        onError();
        return -1;
      }
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicDownExtraInfo)))
      {
        this.mPicDownExtra = ((TransferRequest.PicDownExtraInfo)this.mUiRequest.mExtraObj);
        this.mRecvLen = this.mPicDownExtra.mStartDownOffset;
        int i = this.mUiRequest.mUinType;
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        this.mIsGroup = bool;
      }
    }
    try
    {
      this.mMsgFileMd5 = getMd5InBytesOfGroup(this.mUiRequest.mMd5, this.mUiRequest.mServerPath);
      this.mGroupFileID = this.mUiRequest.mGroupFileID;
      if (this.mMsgFileMd5 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("convert md5 error,md5:");
        ((StringBuilder)localObject1).append(this.mUiRequest.mMd5);
        ((StringBuilder)localObject1).append("  uuid:");
        ((StringBuilder)localObject1).append(this.mUiRequest.mServerPath);
        setError(9302, getExpStackString(new Exception(((StringBuilder)localObject1).toString())));
        onError();
        return -1;
      }
      return 0;
    }
    catch (Exception localException)
    {
      label330:
      break label330;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("convert md5 error,md5:");
    ((StringBuilder)localObject1).append(this.mUiRequest.mMd5);
    ((StringBuilder)localObject1).append("  uuid:");
    ((StringBuilder)localObject1).append(this.mUiRequest.mServerPath);
    setError(9302, getExpStackString(new Exception(((StringBuilder)localObject1).toString())));
    onError();
    return -1;
    setError(9302, getExpStackString(new Exception("extra obj")));
    onError();
    return -1;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("uuid illegal ");
    ((StringBuilder)localObject2).append((String)localObject1);
    setError(9302, getExpStackString(new Exception(((StringBuilder)localObject2).toString())));
    onError();
    return -1;
    label480:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("uuid illegal ");
    ((StringBuilder)localObject2).append((String)localObject1);
    setError(9302, getExpStackString(new Exception(((StringBuilder)localObject2).toString())));
    onError();
    return -1;
  }
  
  protected void doReport(boolean paramBoolean)
  {
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
    if (!shouldReport(paramBoolean)) {
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
    long l1 = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.mProcessorReport.mStepDirectDown.getReportInfo(1));
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(this.mProcessorReport.mStepUrl.getReportInfo(2));
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(this.mProcessorReport.mStepTrans.getReportInfo(3));
    localObject1 = ((StringBuilder)localObject1).toString();
    this.mProcessorReport.mReportInfo.put("param_step", localObject1);
    Object localObject2 = this.mProcessorReport.mReportInfo;
    if (this.mDirectMsgUrlDown) {
      localObject1 = this.mProcessorReport.mStepDirectDown;
    } else {
      localObject1 = this.mProcessorReport.mStepTrans;
    }
    ((HashMap)localObject2).put("param_trans_consume", String.valueOf(((StepInfo)localObject1).getTimeConsume()));
    this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
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
    Object localObject3 = this.mProcessorReport.mReportInfo;
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
      this.mProcessorReport.mReportInfo.put("param_picDecryptTime", String.valueOf(((PicCryptor)((HttpNetReq)localObject1).decoder).a));
    }
    if (this.mUiRequest.mUinType == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      i = -1;
      if (this.app != null) {
        i = ((IConversationFacade)this.app.getRuntimeService(IConversationFacade.class, "")).getTroopMask(this.mUiRequest.mPeerUin);
      }
      this.mProcessorReport.mReportInfo.put("param_groupPolicy", String.valueOf(i));
    }
    localObject2 = this.mUiRequest.mRec;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this.app != null) {
        localObject1 = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      }
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
    super.doReport(paramBoolean, "GroupPicDownloadErrorCode", l1, this.mProcessorReport.mReportInfo);
  }
  
  protected String getReportTAG()
  {
    if (this.mUiRequest.mUinType == 1)
    {
      if (this.mUiRequest.mFileType == 65537) {
        return "actGroupPicSmallDownV1";
      }
      return "actGroupPicDownloadV1";
    }
    if (this.mUiRequest.mFileType == 65537) {
      return "actDiscussPicSmallDown";
    }
    return "actDiscussPicDown";
  }
  
  public boolean isAllowEncrypt(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return (this.mUiRequest.bEnableEnc) && (paramDownloadEncryptConf != null) && ((paramDownloadEncryptConf.uint32_ctrl_flag.get() & 0x2) != 0);
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
  
  String parseUuidFromUrl(String paramString)
  {
    Object localObject2 = paramString;
    if (paramString != null) {
      localObject2 = paramString;
    }
    try
    {
      if (paramString.startsWith("/")) {
        localObject2 = paramString.substring(1);
      }
      Object localObject3 = null;
      paramString = null;
      if ((localObject2 != null) && (!((String)localObject2).equals("null")) && (!((String)localObject2).startsWith("http://"))) {
        return null;
      }
      Object localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject2).length() > 0)
        {
          localObject1 = localObject3;
          if (((String)localObject2).contains("?"))
          {
            int i = ((String)localObject2).indexOf("?");
            localObject1 = localObject3;
            if (i >= 0)
            {
              localObject1 = localObject3;
              if (i < ((String)localObject2).length() - 1)
              {
                localObject2 = ((String)localObject2).substring(i + 1).split("\\&");
                localObject1 = localObject3;
                if (localObject2 != null)
                {
                  i = 0;
                  for (;;)
                  {
                    localObject1 = paramString;
                    if (i >= localObject2.length) {
                      break;
                    }
                    if (localObject2[i].startsWith("pic=")) {
                      paramString = localObject2[i].substring(4);
                    }
                    i += 1;
                  }
                }
              }
            }
          }
        }
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject2 = paramString;
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
      this.mDownDomain = "gchat.qpic.cn";
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    if (paramBoolean) {
      str = "https://";
    } else {
      str = "http://";
    }
    StringBuilder localStringBuilder;
    if (this.isDomainTest)
    {
      this.mIpList.clear();
      localHttpNetReq.mIsHostIP = false;
      localHttpNetReq.mHostForHttpsVerify = "gchat.qpic.cn";
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("gchat.qpic.cn");
      str = ((StringBuilder)localObject).toString();
    }
    else if ((this.mIpList != null) && (this.mIpList.size() > 0))
    {
      localHttpNetReq.mIsHostIP = true;
      localObject = (ServerAddr)this.mIpList.get(0);
      if ((((ServerAddr)localObject).isIpv6) && (!((ServerAddr)localObject).mIp.startsWith("[")))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("[");
        localStringBuilder.append(((ServerAddr)localObject).mIp);
        localStringBuilder.append("]");
        str = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(((ServerAddr)localObject).mIp);
        str = localStringBuilder.toString();
      }
      if (((ServerAddr)localObject).port != 80)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(":");
        localStringBuilder.append(((ServerAddr)localObject).port);
        str = localStringBuilder.toString();
      }
    }
    else
    {
      localHttpNetReq.mIsHostIP = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(this.mDownDomain);
      str = ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(this.mUrlPath);
    String str = appendInfoForSvr(((StringBuilder)localObject).toString(), this.mUiRequest.mDownMode);
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mFailedListener = this;
    localHttpNetReq.mReqUrl = str;
    localHttpNetReq.mIsHttps = paramBoolean;
    localHttpNetReq.mHostForHttpsVerify = this.mDownDomain;
    localHttpNetReq.mHttpMethod = 0;
    TransFileUtil.addDomainToList(this.mIpList, this.mDownDomain);
    localHttpNetReq.mServerList = this.mIpList;
    if (this.mTimeoutProfile != null) {
      localHttpNetReq.mTimeoutParam = this.mTimeoutProfile.getTimeoutParam();
    }
    localHttpNetReq.mOutPath = this.mUiRequest.mOutFilePath;
    if (this.mUiRequest.useOutputstream) {
      localHttpNetReq.mOutStream = this.mUiRequest.mOut;
    }
    localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
    localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
    localHttpNetReq.mFileType = this.mUiRequest.mFileType;
    localHttpNetReq.mIsNetChgAsError = true;
    localHttpNetReq.mStartDownOffset = 0L;
    localHttpNetReq.mWhiteListContentType = new String[] { "image" };
    int i = getDownloadStatus(this.mUiRequest);
    if (i == 4)
    {
      localHttpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
      localHttpNetReq.mEndDownOffset = 0L;
      localHttpNetReq.mIsRenameInEngine = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bytes=");
      ((StringBuilder)localObject).append(this.mUiRequest.mRequestOffset);
      ((StringBuilder)localObject).append("-");
      localObject = ((StringBuilder)localObject).toString();
      localHttpNetReq.mReqProperties.put("Range", localObject);
    }
    else if ((i != 3) && (i != 2))
    {
      localHttpNetReq.mEndDownOffset = 0L;
      localObject = localHttpNetReq.mReqProperties;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("bytes=");
      localStringBuilder.append(localHttpNetReq.mStartDownOffset);
      localStringBuilder.append("-");
      ((HashMap)localObject).put("Range", localStringBuilder.toString());
    }
    else
    {
      localHttpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
      localHttpNetReq.mEndDownOffset = (this.mUiRequest.mRequestOffset + this.mUiRequest.mRequestLength - 1);
      localHttpNetReq.mIsRenameInEngine = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bytes=");
      ((StringBuilder)localObject).append(this.mUiRequest.mRequestOffset);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(localHttpNetReq.mEndDownOffset);
      localObject = ((StringBuilder)localObject).toString();
      localHttpNetReq.mReqProperties.put("Range", localObject);
    }
    localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
    localHttpNetReq.mSupportBreakResume = true;
    localHttpNetReq.mReqProperties.put("Referer", "http://im.qq.com/mobileqq");
    encryptReqInit(localHttpNetReq, str);
    localHttpNetReq.mCanPrintUrl = true;
    localHttpNetReq.mUseCmwapConnectionTypeFromDpc = true;
    localHttpNetReq.mReqProperties.put("mType", "picCu");
    localHttpNetReq.mPrioty = this.mUiRequest.mPrioty;
    if (this.mDirectMsgUrlDown) {
      localHttpNetReq.mContinuErrorLimit = 0;
    }
    str = null;
    if (!this.mIpList.isEmpty()) {
      str = Arrays.toString(this.mIpList.toArray());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("directMsgUrlDown:");
    ((StringBuilder)localObject).append(this.mDirectMsgUrlDown);
    ((StringBuilder)localObject).append(",req.mReqUrl = ");
    ((StringBuilder)localObject).append(localHttpNetReq.mReqUrl);
    ((StringBuilder)localObject).append(" ipList:");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" uuid:");
    ((StringBuilder)localObject).append(this.mUiRequest.mServerPath);
    ((StringBuilder)localObject).append(" FileID:");
    ((StringBuilder)localObject).append(this.mUiRequest.mGroupFileID);
    ((StringBuilder)localObject).append(" downOffset:");
    ((StringBuilder)localObject).append(localHttpNetReq.mStartDownOffset);
    ((StringBuilder)localObject).append(",isEncryptUrl:");
    ((StringBuilder)localObject).append(this.mEncryptUrl);
    ((StringBuilder)localObject).append(",isEncryptPic:");
    ((StringBuilder)localObject).append(this.mEncryptPic);
    ((StringBuilder)localObject).append(",isEncryptRollbackReq:");
    ((StringBuilder)localObject).append(this.mPicEncryptRollback);
    logRichMediaEvent("httpDown", ((StringBuilder)localObject).toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    setMtype();
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    this.mDirectMsgUrlDown = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    Object localObject = new RichProto.RichProtoReq.GroupPicDownReq();
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).selfUin = this.mUiRequest.mSelfUin;
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).peerUin = this.mUiRequest.mPeerUin;
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).secondUin = this.mUiRequest.mSecondId;
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).uinType = this.mUiRequest.mUinType;
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).fileType = this.mUiRequest.mFileType;
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).groupFileID = this.mGroupFileID;
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).md5 = this.mMsgFileMd5;
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).msgTime = ((int)this.mUiRequest.mMsgTime);
    ((RichProto.RichProtoReq.GroupPicDownReq)localObject).protocolType = 0;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "grp_pic_dw";
    localRichProtoReq.reqs.add(localObject);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendGroupPicDownRequest:");
    ((StringBuilder)localObject).append(this.mUiRequest.mUniseq);
    QLog.d("BaseTransProcessor", 1, ((StringBuilder)localObject).toString());
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    }
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public void setError(int paramInt, String paramString)
  {
    this.mProcessorReport.setError(paramInt, paramString, null, null);
    if (paramInt == 9302)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      paramString = this.mUiRequest.mServerPath;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setError,uuid:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" md5:");
      localStringBuilder.append(this.mUiRequest.mMd5);
      paramString = localStringBuilder.toString();
      QLog.d("BaseTransProcessor", 1, paramString);
      RichMediaBugReport.a("Download_Pic_Error_Param_Check", paramString);
    }
  }
  
  protected void setMtype()
  {
    int i = this.mUiRequest.mFileType;
    if ((this.mNetReq instanceof HttpNetReq))
    {
      if (this.mIsGroup)
      {
        if (i == 2)
        {
          ((HttpNetReq)this.mNetReq).mReqProperties.put("mType", "pttGd");
          return;
        }
        ((HttpNetReq)this.mNetReq).mReqProperties.put("mType", "picGd");
        return;
      }
      if (i == 2)
      {
        ((HttpNetReq)this.mNetReq).mReqProperties.put("mType", "pttDd");
        return;
      }
      ((HttpNetReq)this.mNetReq).mReqProperties.put("mType", "picDd");
    }
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
    directMsgUrlDown("gchat.qpic.cn", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */