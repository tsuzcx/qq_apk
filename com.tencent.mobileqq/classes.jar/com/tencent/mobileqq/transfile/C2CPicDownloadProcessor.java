package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPicDownReq;
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

public class C2CPicDownloadProcessor
  extends BasePicDownloadProcessor
{
  public C2CPicDownloadProcessor() {}
  
  public C2CPicDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.file.fileType = this.mUiRequest.mFileType;
    this.file.uniseq = this.mUiRequest.mUniseq;
    this.file.mSubMsgId = this.mUiRequest.mSubMsgId;
  }
  
  public int checkParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    String str = this.mUiRequest.mServerPath;
    if ((str == null) || (str.equals("")) || (str.equals("null")) || (FileUtils.isLocalPath(str)) || (str.startsWith("http")))
    {
      setError(9302, getExpStackString(new Exception("uuid illegal " + str)));
      onError();
      return -1;
    }
    if ((this.mUiRequest.mOut == null) && (this.mUiRequest.useOutputstream))
    {
      setError(9302, getExpStackString(new Exception("no output stream")));
      onError();
      return -1;
    }
    if ((this.mUiRequest.mExtraObj == null) || (!(this.mUiRequest.mExtraObj instanceof TransferRequest.PicDownExtraInfo)))
    {
      setError(9302, getExpStackString(new Exception("extra obj")));
      onError();
      return -1;
    }
    this.mPicDownExtra = ((TransferRequest.PicDownExtraInfo)this.mUiRequest.mExtraObj);
    this.mRecvLen = this.mPicDownExtra.mStartDownOffset;
    return 0;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + RichMediaUtil.getUinDesc(this.mUiRequest.mUinType) + "." + RichMediaUtil.getFileType(this.mUiRequest.mFileType);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.mUiRequest.mUniseq + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.errCode + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.errDesc);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!this.mUiRequest.mNeedReport) {}
    while ((this.mUiRequest.mBusiType == 1030) || ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) || (this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
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
        break label934;
      }
      l1 = this.mStepDirectDown.getTimeConsume();
      label361:
      ((HashMap)localObject1).put("param_trans_consume", String.valueOf(l1));
      this.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
      this.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      this.mReportInfo.put("param_DownMode", String.valueOf(this.mUiRequest.mDownMode));
      this.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
      this.mReportInfo.put("param_quickHttp", String.valueOf(this.mSendByQuickHttp));
      localObject1 = this.mReportInfo;
      l1 = this.mRecvLen;
      if (this.mPicDownExtra != null) {
        break label946;
      }
      i = 0;
      label489:
      ((HashMap)localObject1).put("param_recvDataLen", String.valueOf(l1 - i));
      this.mReportInfo.put("param_directFailCode", String.valueOf(this.mSSORequestReason));
      this.mReportInfo.put("param_directFailDesc", "" + this.mDirectDownFailReason);
      this.mReportInfo.put("param_inQueueCost", "" + this.inQueueCost);
      this.mReportInfo.put("ipFromDns", "" + this.mIpFromInnerDns);
      this.mReportInfo.put("param_encryptRollback", "" + this.mPicEncryptRollback + ",decryptErrorMsg:" + this.mDecryptErrorMsg);
      localObject2 = this.mReportInfo;
      if (!this.mPicEncryptRollback) {
        break label957;
      }
      localObject1 = "1";
      label687:
      ((HashMap)localObject2).put("param_encRetry", localObject1);
      localObject2 = this.mReportInfo;
      if (!this.mIsHttpsDownload) {
        break label965;
      }
      localObject1 = "1";
      label716:
      ((HashMap)localObject2).put("param_isHttps", localObject1);
      if ((this.mNetReq != null) && (((HttpNetReq)this.mNetReq).decoder != null))
      {
        localObject1 = (HttpNetReq)this.mNetReq;
        this.mReportInfo.put("param_picDecryptTime", String.valueOf(((PicCryptor)((HttpNetReq)localObject1).decoder).a));
      }
      localObject2 = this.mUiRequest.mRec;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic))) {
        this.mReportInfo.put("param_imgType", String.valueOf(((MessageForPic)localObject1).imageType));
      }
      checkFailCodeReport(paramBoolean);
      if (!paramBoolean) {
        break label973;
      }
      reportForIpv6(true, l2);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l2, this.mTotolLen, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      super.doReport(paramBoolean, "C2CPicDownloadErrorCode", l2, this.mReportInfo);
      return;
      i = 1;
      break;
      label934:
      l1 = this.mStepTrans.getTimeConsume();
      break label361;
      label946:
      i = this.mPicDownExtra.mStartDownOffset;
      break label489;
      label957:
      localObject1 = "0";
      break label687;
      label965:
      localObject1 = "0";
      break label716;
      label973:
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
  
  void receiveFile(boolean paramBoolean)
  {
    this.mIsHttpsDownload = paramBoolean;
    this.mRSMReporter.mIsHttps = paramBoolean;
    this.mStepTrans.logStartTime();
    if (this.mIsCancel) {
      return;
    }
    if (TextUtils.isEmpty(this.mDownDomain)) {
      this.mDownDomain = "c2cpicdw.qpic.cn";
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
        break label699;
      }
      this.mIpList.clear();
      localHttpNetReq.mIsHostIP = false;
      localHttpNetReq.mHostForHttpsVerify = "c2cpicdw.qpic.cn";
      localObject = (String)localObject + "c2cpicdw.qpic.cn";
      localObject = appendInfoForSvr((String)localObject + this.mUrlPath, this.mUiRequest.mDownMode);
      localHttpNetReq.mCallback = this;
      localHttpNetReq.mFailedListener = this;
      localHttpNetReq.mReqUrl = ((String)localObject);
      localHttpNetReq.mIsHttps = paramBoolean;
      localHttpNetReq.mHostForHttpsVerify = this.mDownDomain;
      localHttpNetReq.mHttpMethod = 0;
      addDomainToList(this.mIpList, this.mDownDomain);
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
      i = getDownloadStatus(this.mUiRequest);
      if (i != 4) {
        break label897;
      }
      localHttpNetReq.mStartDownOffset = this.mUiRequest.mRequestOffset;
      localHttpNetReq.mEndDownOffset = 0L;
      localHttpNetReq.mIsRenameInEngine = false;
      str = "bytes=" + this.mUiRequest.mRequestOffset + "-";
      localHttpNetReq.mReqProperties.put("Range", str);
    }
    for (;;)
    {
      encryptReqInit(localHttpNetReq, (String)localObject);
      localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
      localHttpNetReq.mReqProperties.put("mType", "picCd");
      localHttpNetReq.mReqProperties.put("Referer", "http://im.qq.com/mobileqq");
      localHttpNetReq.mBreakDownFix = mPicBreakDownFixForOldHttpEngine;
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
      str = null;
      localObject = str;
      if (this.mIpList != null)
      {
        localObject = str;
        if (!this.mIpList.isEmpty()) {
          localObject = Arrays.toString(this.mIpList.toArray());
        }
      }
      logRichMediaEvent("httpDown", "directMsgUrlDown:" + this.mDirectMsgUrlDown + " ipList:" + (String)localObject + " uniSeq:" + localHttpNetReq.mMsgId + " uuid:" + this.mUiRequest.mServerPath + ",downOffset:" + localHttpNetReq.mStartDownOffset + ",isEncryptUrl:" + this.mEncryptUrl + ",isEncryptPic:" + this.mEncryptPic + ",isEncryptRollbackReq:" + this.mPicEncryptRollback);
      if (!canDoNextStep()) {
        break;
      }
      this.mNetReq = localHttpNetReq;
      this.mNetEngine.sendReq(localHttpNetReq);
      return;
      localObject = "http://";
      break label62;
      label699:
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
      label897:
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
      localMessageRecord1 = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    }
    boolean bool;
    if ((localMessageRecord1 != null) && ((localMessageRecord1 instanceof MessageForPic)))
    {
      this.mStorageSource = ((MessageForPic)localMessageRecord1).serverStoreSource;
      localC2CPicDownReq.storageSource = this.mStorageSource;
      localC2CPicDownReq.fileType = this.mUiRequest.mFileType;
      if (this.mUiRequest.mUinType != 1006) {
        break label305;
      }
      bool = true;
      label207:
      localC2CPicDownReq.isContact = bool;
      localC2CPicDownReq.protocolType = 0;
      localRichProtoReq.callback = this;
      localRichProtoReq.protoKey = "c2c_pic_dw";
      localRichProtoReq.reqs.add(localC2CPicDownReq);
      localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
      if (isAppValid()) {
        break label310;
      }
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    label305:
    label310:
    do
    {
      return;
      this.mStorageSource = "picplatform";
      logRichMediaEvent("findDbRec", "not found");
      break;
      bool = false;
      break label207;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while (!canDoNextStep());
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
      logRichMediaEvent("reportFailed", ChatImageDownloader.getExceptionMessage(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */