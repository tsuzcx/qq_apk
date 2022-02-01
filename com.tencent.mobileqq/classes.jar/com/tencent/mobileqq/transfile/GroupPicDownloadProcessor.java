package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.RichMediaBugReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPicDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.PicDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
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
  
  public GroupPicDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.file.fileType = this.mUiRequest.mFileType;
    this.file.uniseq = this.mUiRequest.mUniseq;
    this.file.mSubMsgId = this.mUiRequest.mSubMsgId;
  }
  
  private boolean shouldReport(boolean paramBoolean)
  {
    if (!this.mUiRequest.mNeedReport) {}
    while ((this.mUiRequest.mBusiType == 1030) || ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) || (this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return false;
    }
    return true;
  }
  
  public int checkParam()
  {
    int i = 0;
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    String str1 = this.mUiRequest.mServerPath;
    if ((str1 == null) || (str1.equals("")) || (str1.equals("null")) || (FileUtils.c(str1)) || (str1.startsWith("http://")))
    {
      if ((str1 == null) || (!str1.startsWith("http://"))) {
        break label184;
      }
      String str2 = parseUuidFromUrl(str1);
      if (str2 != null) {
        this.mUiRequest.mServerPath = str2;
      }
    }
    else
    {
      if ((this.mUiRequest.mOut != null) || (!this.mUiRequest.useOutputstream)) {
        break label226;
      }
      setError(9302, getExpStackString(new Exception("no output stream")));
      onError();
      i = -1;
      return i;
    }
    setError(9302, getExpStackString(new Exception("uuid illegal " + str1)));
    onError();
    return -1;
    label184:
    setError(9302, getExpStackString(new Exception("uuid illegal " + str1)));
    onError();
    return -1;
    label226:
    if ((this.mUiRequest.mExtraObj == null) || (!(this.mUiRequest.mExtraObj instanceof TransferRequest.PicDownExtraInfo)))
    {
      setError(9302, getExpStackString(new Exception("extra obj")));
      onError();
      return -1;
    }
    this.mPicDownExtra = ((TransferRequest.PicDownExtraInfo)this.mUiRequest.mExtraObj);
    this.mRecvLen = this.mPicDownExtra.mStartDownOffset;
    if (this.mUiRequest.mUinType == 1) {}
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        this.mIsGroup = bool;
        try
        {
          this.mMsgFileMd5 = getMd5InBytesOfGroup(this.mUiRequest.mMd5, this.mUiRequest.mServerPath);
          this.mGroupFileID = this.mUiRequest.mGroupFileID;
          if (this.mMsgFileMd5 != null) {
            break;
          }
          setError(9302, getExpStackString(new Exception("convert md5 error,md5:" + this.mUiRequest.mMd5 + "  uuid:" + this.mUiRequest.mServerPath)));
          onError();
          return -1;
        }
        catch (Exception localException)
        {
          setError(9302, getExpStackString(new Exception("convert md5 error,md5:" + this.mUiRequest.mMd5 + "  uuid:" + this.mUiRequest.mServerPath)));
          onError();
        }
      }
    }
    return -1;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + TransFileUtil.getUinDesc(this.mUiRequest.mUinType) + "." + RichMediaUtil.getFileType(this.mUiRequest.mFileType);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.mUiRequest.mUniseq + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.errCode + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.errDesc);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!shouldReport(paramBoolean)) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    long l2;
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      l2 = (System.nanoTime() - this.mStartTime) / 1000000L;
      localObject1 = this.mStepDirectDown.getReportInfo(1) + ";" + this.mStepUrl.getReportInfo(2) + ";" + this.mStepTrans.getReportInfo(3);
      this.mReportInfo.put("param_step", localObject1);
      localObject1 = this.mReportInfo;
      if (!this.mDirectMsgUrlDown) {
        break label943;
      }
      l1 = this.mStepDirectDown.getTimeConsume();
      label300:
      ((HashMap)localObject1).put("param_trans_consume", String.valueOf(l1));
      this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      this.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      this.mReportInfo.put("param_DownMode", String.valueOf(this.mUiRequest.mDownMode));
      this.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
      this.mReportInfo.put("param_quickHttp", String.valueOf(this.mSendByQuickHttp));
      localObject1 = this.mReportInfo;
      l1 = this.mRecvLen;
      if (this.mPicDownExtra != null) {
        break label955;
      }
      i = 0;
      label431:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l1 - i));
      this.mReportInfo.put("param_directFailCode", String.valueOf(this.mSSORequestReason));
      this.mReportInfo.put("param_directFailDesc", "" + this.mDirectDownFailReason);
      this.mReportInfo.put("param_inQueueCost", "" + this.inQueueCost);
      this.mReportInfo.put("ipFromDns", "" + this.mIpFromInnerDns);
      this.mReportInfo.put("param_encryptRollback", "" + this.mPicEncryptRollback + ",decryptErrorMsg:" + this.mDecryptErrorMsg);
      localObject2 = this.mReportInfo;
      if (!this.mPicEncryptRollback) {
        break label966;
      }
      localObject1 = "1";
      label629:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.mReportInfo;
      if (!this.mIsHttpsDownload) {
        break label974;
      }
      localObject1 = "1";
      label658:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.mNetReq != null) && (((HttpNetReq)this.mNetReq).decoder != null))
      {
        localObject1 = (HttpNetReq)this.mNetReq;
        this.mReportInfo.put("param_picDecryptTime", String.valueOf(((PicCryptor)((HttpNetReq)localObject1).decoder).a));
      }
      if (this.mUiRequest.mUinType != 1) {
        break label982;
      }
      i = 1;
      label736:
      if (i != 0)
      {
        i = -1;
        if (this.app != null) {
          i = this.app.getTroopMask(this.mUiRequest.mPeerUin);
        }
        this.mReportInfo.put("param_groupPolicy", String.valueOf(i));
      }
      localObject2 = this.mUiRequest.mRec;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.app != null) {
          localObject1 = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.mReportInfo.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      checkFailCodeReport(paramBoolean);
      if (!paramBoolean) {
        break label987;
      }
      reportForIpv6(true, l2);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l2, this.mTotolLen, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      super.doReport(paramBoolean, "GroupPicDownloadErrorCode", l2, this.mReportInfo);
      return;
      i = 1;
      break;
      label943:
      l1 = this.mStepTrans.getTimeConsume();
      break label300;
      label955:
      i = this.mPicDownExtra.mStartDownOffset;
      break label431;
      label966:
      localObject1 = "0";
      break label629;
      label974:
      localObject1 = "0";
      break label658;
      label982:
      i = 0;
      break label736;
      label987:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      reportForIpv6(false, l2);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l2, 0L, this.mReportInfo, "");
    }
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
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.PicDownResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.mIpList);
          this.mDownDomain = paramRichProtoReq.domain;
          this.mUrlPath = paramRichProtoReq.urlPath;
          if (QLog.isColorLevel()) {
            logRichMediaEvent("proUrl", "picResp.protocolType = " + paramRichProtoReq.protocolType);
          }
          if (paramRichProtoReq.protocolType == 1) {
            receiveFile(true);
          }
          for (;;)
          {
            i += 1;
            break;
            receiveFile(false);
          }
        }
        onError();
      }
    }
  }
  
  String parseUuidFromUrl(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null) {
      localObject = paramString;
    }
    try
    {
      if (paramString.startsWith("/")) {
        localObject = paramString.substring(1);
      }
      if ((localObject != null) && (!((String)localObject).equals("null")) && (!((String)localObject).startsWith("http://"))) {}
      do
      {
        do
        {
          do
          {
            return null;
          } while ((localObject == null) || (((String)localObject).length() <= 0) || (!((String)localObject).contains("?")));
          i = ((String)localObject).indexOf("?");
        } while ((i < 0) || (i >= ((String)localObject).length() - 1));
        localObject = ((String)localObject).substring(i + 1).split("\\&");
      } while (localObject == null);
      paramString = null;
      int i = 0;
      while (i < localObject.length)
      {
        if (localObject[i].startsWith("pic=")) {
          paramString = localObject[i].substring(4);
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = paramString;
      }
    }
    return paramString;
  }
  
  void receiveFile(boolean paramBoolean)
  {
    this.mIsHttpsDownload = paramBoolean;
    this.mRSMReporter.mIsHttps = paramBoolean;
    this.mStepTrans.logStartTime();
    if (this.mIsCancel) {
      return;
    }
    if (TextUtils.isEmpty(this.mDownDomain)) {
      this.mDownDomain = "gchat.qpic.cn";
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    Object localObject;
    label62:
    label111:
    int i;
    String str;
    if (paramBoolean)
    {
      localObject = "https://";
      if (!this.isDomainTest) {
        break label702;
      }
      this.mIpList.clear();
      localHttpNetReq.mIsHostIP = false;
      localHttpNetReq.mHostForHttpsVerify = "gchat.qpic.cn";
      localObject = (String)localObject + "gchat.qpic.cn";
      localObject = appendInfoForSvr((String)localObject + this.mUrlPath, this.mUiRequest.mDownMode);
      localHttpNetReq.mCallback = this;
      localHttpNetReq.mFailedListener = this;
      localHttpNetReq.mReqUrl = ((String)localObject);
      localHttpNetReq.mIsHttps = paramBoolean;
      localHttpNetReq.mHostForHttpsVerify = this.mDownDomain;
      localHttpNetReq.mHttpMethod = 0;
      addDomainToList(this.mIpList, this.mDownDomain);
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
      i = getDownloadStatus(this.mUiRequest);
      if (i != 4) {
        break label900;
      }
      localHttpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
      localHttpNetReq.mEndDownOffset = 0L;
      localHttpNetReq.mIsRenameInEngine = false;
      str = "bytes=" + this.mUiRequest.mRequestOffset + "-";
      localHttpNetReq.mReqProperties.put("Range", str);
    }
    for (;;)
    {
      localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
      localHttpNetReq.mSupportBreakResume = true;
      localHttpNetReq.mReqProperties.put("Referer", "http://im.qq.com/mobileqq");
      encryptReqInit(localHttpNetReq, (String)localObject);
      localHttpNetReq.mCanPrintUrl = true;
      localHttpNetReq.mUseCmwapConnectionTypeFromDpc = true;
      localHttpNetReq.mReqProperties.put("mType", "picCu");
      localHttpNetReq.mPrioty = this.mUiRequest.mPrioty;
      if (this.mDirectMsgUrlDown) {
        localHttpNetReq.mContinuErrorLimit = 0;
      }
      localObject = null;
      if (!this.mIpList.isEmpty()) {
        localObject = Arrays.toString(this.mIpList.toArray());
      }
      logRichMediaEvent("httpDown", "directMsgUrlDown:" + this.mDirectMsgUrlDown + ",req.mReqUrl = " + localHttpNetReq.mReqUrl + " ipList:" + (String)localObject + " uuid:" + this.mUiRequest.mServerPath + " FileID:" + this.mUiRequest.mGroupFileID + " downOffset:" + localHttpNetReq.mStartDownOffset + ",isEncryptUrl:" + this.mEncryptUrl + ",isEncryptPic:" + this.mEncryptPic + ",isEncryptRollbackReq:" + this.mPicEncryptRollback);
      if (!canDoNextStep()) {
        break;
      }
      this.mNetReq = localHttpNetReq;
      setMtype();
      this.mNetEngine.sendReq(localHttpNetReq);
      return;
      localObject = "http://";
      break label62;
      label702:
      if ((this.mIpList != null) && (this.mIpList.size() > 0))
      {
        localHttpNetReq.mIsHostIP = true;
        ServerAddr localServerAddr = (ServerAddr)this.mIpList.get(0);
        if ((localServerAddr.isIpv6) && (!localServerAddr.mIp.startsWith("["))) {}
        for (str = (String)localObject + "[" + localServerAddr.mIp + "]";; str = (String)localObject + localServerAddr.mIp)
        {
          localObject = str;
          if (localServerAddr.port == 80) {
            break;
          }
          localObject = str + ":" + localServerAddr.port;
          break;
        }
      }
      localHttpNetReq.mIsHostIP = false;
      localObject = (String)localObject + this.mDownDomain;
      break label111;
      label900:
      if ((i == 3) || (i == 2))
      {
        localHttpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
        localHttpNetReq.mEndDownOffset = (this.mUiRequest.mRequestOffset + this.mUiRequest.mRequestLength - 1);
        localHttpNetReq.mIsRenameInEngine = false;
        str = "bytes=" + this.mUiRequest.mRequestOffset + "-" + localHttpNetReq.mEndDownOffset;
        localHttpNetReq.mReqProperties.put("Range", str);
      }
      else
      {
        localHttpNetReq.mEndDownOffset = 0L;
        localHttpNetReq.mReqProperties.put("Range", "bytes=" + localHttpNetReq.mStartDownOffset + "-");
      }
    }
  }
  
  void sendRequest()
  {
    this.mStepUrl.logStartTime();
    this.mDirectMsgUrlDown = false;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.GroupPicDownReq localGroupPicDownReq = new RichProto.RichProtoReq.GroupPicDownReq();
    localGroupPicDownReq.selfUin = this.mUiRequest.mSelfUin;
    localGroupPicDownReq.peerUin = this.mUiRequest.mPeerUin;
    localGroupPicDownReq.secondUin = this.mUiRequest.mSecondId;
    localGroupPicDownReq.uinType = this.mUiRequest.mUinType;
    localGroupPicDownReq.fileType = this.mUiRequest.mFileType;
    localGroupPicDownReq.groupFileID = this.mGroupFileID;
    localGroupPicDownReq.md5 = this.mMsgFileMd5;
    localGroupPicDownReq.msgTime = ((int)this.mUiRequest.mMsgTime);
    localGroupPicDownReq.protocolType = 0;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "grp_pic_dw";
    localRichProtoReq.reqs.add(localGroupPicDownReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      return;
      QLog.d("BaseTransProcessor", 1, "sendGroupPicDownRequest:" + this.mUiRequest.mUniseq);
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while (!canDoNextStep());
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public void setError(int paramInt, String paramString)
  {
    super.setError(paramInt, paramString);
    if ((paramInt != 9302) || (!QLog.isColorLevel())) {
      return;
    }
    paramString = this.mUiRequest.mServerPath;
    paramString = "setError,uuid:" + paramString + " md5:" + this.mUiRequest.mMd5;
    QLog.d("BaseTransProcessor", 1, paramString);
    RichMediaBugReport.a("Download_Pic_Error_Param_Check", paramString);
  }
  
  protected void setMtype()
  {
    int i = this.mUiRequest.mFileType;
    if ((this.mNetReq instanceof HttpNetReq))
    {
      if (!this.mIsGroup) {
        break label72;
      }
      if (i == 2) {
        ((HttpNetReq)this.mNetReq).mReqProperties.put("mType", "pttGd");
      }
    }
    else
    {
      return;
    }
    ((HttpNetReq)this.mNetReq).mReqProperties.put("mType", "picGd");
    return;
    label72:
    if (i == 2)
    {
      ((HttpNetReq)this.mNetReq).mReqProperties.put("mType", "pttDd");
      return;
    }
    ((HttpNetReq)this.mNetReq).mReqProperties.put("mType", "picDd");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */