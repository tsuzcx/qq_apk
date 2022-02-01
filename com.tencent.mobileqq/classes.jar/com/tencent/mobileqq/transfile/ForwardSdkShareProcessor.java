package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardConstants;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class ForwardSdkShareProcessor
  extends BaseTransProcessor
  implements ForwardConstants
{
  private static final String DEFAULT_UPLOAD_FAIL_IMG_URL = "https://pub.idqqimg.com/pc/misc/files/20191015/32ed5b691a1138ac452a59e42f3f83b5.png";
  private static final int MAX_RETRY_COUNT = 2;
  private static final String STAG = "Q.share.ForwardSdkShareProcessor";
  protected QQAppInterface app;
  protected Context mAppContext;
  private long mAppId;
  protected TransferRequest.AppInfo mAppInfo;
  protected String mAudioUrl;
  protected int mForwardType;
  private long mGetAppInfoTime;
  protected AtomicBoolean mIsAllUrlShort;
  private AtomicBoolean mIsImgUrlShort;
  private AtomicBoolean mIsThumbReady;
  private int mLackOfItems;
  protected String mLocalImgUrl;
  private String mPkgName;
  private boolean mRefreshTicket;
  protected String mRemoteImgUrl;
  private int mRetryCount;
  private ForwardSdkShareProcessor.RichStep mRichStep;
  private String mSKey;
  private ForwardSdkShareProcessor.ForwardStep mSendMsgByServerStep;
  private ForwardSdkShareProcessor.ForwardStep mSendMsgStep;
  protected int mServiceType;
  protected String mShareSummary;
  protected String mShareTitle;
  long mStartTime;
  protected String mTargetUrl;
  protected HashMap<String, String> mUrlMap;
  
  public ForwardSdkShareProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    boolean bool2 = false;
    this.mIsThumbReady = new AtomicBoolean(false);
    this.mIsImgUrlShort = new AtomicBoolean(false);
    this.mIsAllUrlShort = new AtomicBoolean(false);
    this.mRefreshTicket = false;
    this.mUrlMap = new HashMap();
    this.mRetryCount = 0;
    this.mStartTime = 0L;
    this.app = ((QQAppInterface)this.app);
    this.mAppContext = this.app.getApp().getApplicationContext();
    if ((this.mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo))
    {
      paramBaseTransFileController = (TransferRequest.ShareExtraInfo)this.mUiRequest.mExtraObj;
      this.mForwardType = paramBaseTransFileController.forwardType;
      this.mServiceType = paramBaseTransFileController.serviceType;
      this.mTargetUrl = paramBaseTransFileController.targetUrl;
      this.mShareTitle = paramBaseTransFileController.title;
      this.mShareSummary = paramBaseTransFileController.summary;
      this.mAudioUrl = paramBaseTransFileController.audioUrl;
      this.mAppId = paramBaseTransFileController.appId;
      this.mPkgName = paramBaseTransFileController.pkgName;
      this.mAppInfo = paramBaseTransFileController.appInfo;
      if (paramBaseTransFileController.imageUrlStatus == 2) {
        this.mLocalImgUrl = paramBaseTransFileController.imageUrl;
      } else {
        this.mRemoteImgUrl = paramBaseTransFileController.imageUrl;
      }
      paramTransferRequest = new StringBuilder();
      paramTransferRequest.append("forwardShare info.imageUrlStatus =");
      paramTransferRequest.append(paramBaseTransFileController.imageUrlStatus);
      paramTransferRequest.append(",mRemoteImgUrl=");
      paramTransferRequest.append(this.mRemoteImgUrl);
      QLog.i("BaseTransProcessor", 1, paramTransferRequest.toString());
      paramTransferRequest = this.mIsThumbReady;
      if ((paramBaseTransFileController.imageUrlStatus != 1) && (paramBaseTransFileController.imageUrlStatus != 3)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      paramTransferRequest.set(bool1);
      paramTransferRequest = this.mIsImgUrlShort;
      if (paramBaseTransFileController.imageUrlStatus == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramTransferRequest.set(bool1);
      paramTransferRequest = this.mIsAllUrlShort;
      boolean bool1 = bool2;
      if (paramBaseTransFileController.shortUrlStatus == 1) {
        bool1 = true;
      }
      paramTransferRequest.set(bool1);
      return;
    }
    QLog.i("BaseTransProcessor", 1, "mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo : false");
  }
  
  public static TransferRequest buildTransferRequest(MessageRecord paramMessageRecord, JSONObject paramJSONObject, UpCallBack paramUpCallBack)
  {
    TransferRequest.ShareExtraInfo localShareExtraInfo = new TransferRequest.ShareExtraInfo();
    localShareExtraInfo.forwardType = paramJSONObject.optInt("forward_type");
    localShareExtraInfo.serviceType = paramJSONObject.optInt("serviceType");
    localShareExtraInfo.appId = paramJSONObject.optLong("appId");
    localShareExtraInfo.pkgName = paramJSONObject.optString("pkg_name");
    localShareExtraInfo.targetUrl = paramJSONObject.optString("targetUrl");
    localShareExtraInfo.title = paramJSONObject.optString("title");
    localShareExtraInfo.summary = paramJSONObject.optString("summary");
    localShareExtraInfo.imageUrl = paramJSONObject.optString("image_url");
    localShareExtraInfo.audioUrl = paramJSONObject.optString("audio_url");
    localShareExtraInfo.imageUrlStatus = paramJSONObject.optInt("imageUrlStatus");
    localShareExtraInfo.shortUrlStatus = paramJSONObject.optInt("shortUrlStatus");
    localShareExtraInfo.appInfo = new TransferRequest.AppInfo();
    localShareExtraInfo.appInfo.sourceName = paramJSONObject.optString("appInfo_sourceName");
    localShareExtraInfo.appInfo.sourceIconSmall = paramJSONObject.optString("appInfo_sourceIconSmall");
    localShareExtraInfo.appInfo.sourceIconBig = paramJSONObject.optString("appInfo_sourceIconBig");
    localShareExtraInfo.appInfo.sourceUrl = paramJSONObject.optString("appInfo_sourceUrl");
    localShareExtraInfo.appInfo.packName = paramJSONObject.optString("appInfo_packName");
    localShareExtraInfo.appInfo.status = paramJSONObject.optInt("appInfo_status");
    paramJSONObject = new TransferRequest();
    paramJSONObject.mSelfUin = paramMessageRecord.selfuin;
    paramJSONObject.mPeerUin = paramMessageRecord.frienduin;
    paramJSONObject.mUinType = paramMessageRecord.istroop;
    paramJSONObject.mFileType = 52;
    paramJSONObject.mUniseq = paramMessageRecord.uniseq;
    paramJSONObject.mIsUp = true;
    paramJSONObject.mBusiType = 11;
    paramJSONObject.needSendMsg = false;
    paramJSONObject.mExtraObj = localShareExtraInfo;
    paramJSONObject.mUpCallBack = paramUpCallBack;
    return paramJSONObject;
  }
  
  public static TransferRequest buildTransferRequestFromMessage(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    TransferRequest.ShareExtraInfo localShareExtraInfo = new TransferRequest.ShareExtraInfo();
    localShareExtraInfo.forwardType = paramAbsShareMsg.forwardType;
    localShareExtraInfo.serviceType = paramAbsShareMsg.mMsgServiceID;
    localShareExtraInfo.appId = paramAbsShareMsg.mSourceAppid;
    localShareExtraInfo.pkgName = paramAbsShareMsg.shareData.pkgName;
    localShareExtraInfo.targetUrl = paramAbsShareMsg.mMsgUrl;
    localShareExtraInfo.title = paramAbsShareMsg.mContentTitle;
    localShareExtraInfo.summary = paramAbsShareMsg.mContentSummary;
    localShareExtraInfo.imageUrl = paramAbsShareMsg.mContentCover;
    localShareExtraInfo.audioUrl = paramAbsShareMsg.mContentSrc;
    localShareExtraInfo.imageUrlStatus = paramAbsShareMsg.shareData.imageUrlStatus;
    localShareExtraInfo.shortUrlStatus = paramAbsShareMsg.shareData.shortUrlStatus;
    localShareExtraInfo.appInfo = new TransferRequest.AppInfo();
    localShareExtraInfo.appInfo.sourceName = paramAbsShareMsg.mSourceName;
    localShareExtraInfo.appInfo.sourceIconSmall = paramAbsShareMsg.mSourceIcon;
    localShareExtraInfo.appInfo.sourceIconBig = paramAbsShareMsg.shareData.sourceIconBig;
    localShareExtraInfo.appInfo.sourceUrl = paramAbsShareMsg.mSourceUrl;
    localShareExtraInfo.appInfo.packName = paramAbsShareMsg.mSource_A_ActionData;
    localShareExtraInfo.appInfo.status = paramAbsShareMsg.shareData.appInfoStatus;
    paramAbsShareMsg = new TransferRequest();
    paramAbsShareMsg.mSelfUin = paramMessageRecord.selfuin;
    paramAbsShareMsg.mPeerUin = paramMessageRecord.frienduin;
    paramAbsShareMsg.mUinType = paramMessageRecord.istroop;
    paramAbsShareMsg.mFileType = 52;
    paramAbsShareMsg.mUniseq = paramMessageRecord.uniseq;
    paramAbsShareMsg.mIsUp = true;
    paramAbsShareMsg.mBusiType = 11;
    paramAbsShareMsg.needSendMsg = false;
    paramAbsShareMsg.mExtraObj = localShareExtraInfo;
    return paramAbsShareMsg;
  }
  
  public static TransferRequest buildTransferRequestFromMessageExtra(MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg, UpCallBack paramUpCallBack)
  {
    paramMessageRecord = buildTransferRequestFromMessage(paramMessageRecord, paramAbsShareMsg);
    paramMessageRecord.mUpCallBack = paramUpCallBack;
    return paramMessageRecord;
  }
  
  private void innerRetry()
  {
    if (this.mIsCancel) {
      return;
    }
    ForwardSdkShareProcessor.ForwardStep localForwardStep = this.mSendMsgStep;
    if (localForwardStep != null) {
      localForwardStep.cancel();
    }
    localForwardStep = this.mSendMsgByServerStep;
    if (localForwardStep != null) {
      localForwardStep.cancel();
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.1(this), 128, null, true);
  }
  
  public int cancel()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.cancel();
    ForwardSdkShareProcessor.ForwardStep localForwardStep = this.mSendMsgStep;
    if (localForwardStep != null) {
      localForwardStep.cancel();
    }
    localForwardStep = this.mSendMsgByServerStep;
    if (localForwardStep != null) {
      localForwardStep.cancel();
    }
    this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq, 32768, 9037);
    sendMessageToUpdate(1004);
    return 0;
  }
  
  public int checkParam()
  {
    Object localObject;
    if (!(this.mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParam|");
      ((StringBuilder)localObject).append("SdkShareInfo null");
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject).toString());
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("SdkShareInfo null")), null, null);
      onError();
      return -1;
    }
    if (TextUtils.isEmpty(this.mTargetUrl))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParam|");
      ((StringBuilder)localObject).append("share targetUrl null");
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject).toString());
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("share targetUrl null")), null, null);
      onError();
      return -1;
    }
    if (this.mAppInfo == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParam|");
      ((StringBuilder)localObject).append("mAppInfo null");
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject).toString());
      this.mProcessorReport.setError(9302, getExpStackString(new Exception("mAppInfo null")), null, null);
      onError();
      return -1;
    }
    if (!ForwardUtils.a(this.mForwardType, this.mServiceType))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("err forwardType=");
      ((StringBuilder)localObject).append(this.mForwardType);
      ((StringBuilder)localObject).append(",serviceType=");
      ((StringBuilder)localObject).append(this.mServiceType);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkParam|");
      localStringBuilder.append((String)localObject);
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
      this.mProcessorReport.setError(9302, getExpStackString(new Exception((String)localObject)), null, null);
      onError();
      return -1;
    }
    return 0;
  }
  
  public boolean isSdkShare()
  {
    return this.mForwardType == 11;
  }
  
  void onError()
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("On Error, code=");
    ((StringBuilder)localObject1).append(this.mProcessorReport.errCode);
    ((StringBuilder)localObject1).append(", cost=");
    ((StringBuilder)localObject1).append(l);
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject1).toString());
    super.onError();
    localObject1 = this.mSendMsgStep;
    if (localObject1 != null) {
      ((ForwardSdkShareProcessor.ForwardStep)localObject1).cancel();
    }
    localObject1 = this.mSendMsgByServerStep;
    if (localObject1 != null) {
      ((ForwardSdkShareProcessor.ForwardStep)localObject1).cancel();
    }
    Object localObject3 = new UpCallBack.SendResult();
    ((UpCallBack.SendResult)localObject3).jdField_a_of_type_Int = -1;
    if ((this.mUiRequest != null) && (this.mUiRequest.mUpCallBack != null))
    {
      if ((isSdkShare()) && (this.mProcessorReport.errCode == 9402) && (!ForwardUtils.a(this.mAppContext)))
      {
        localObject2 = (String)this.mUrlMap.get("audioUrl");
        String str = this.mRemoteImgUrl;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.mAudioUrl;
        }
        ((UpCallBack.SendResult)localObject3).jdField_a_of_type_JavaLangObject = new String[] { str, localObject1 };
        ((UpCallBack.SendResult)localObject3).b = this.mProcessorReport.errCode;
      }
      this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject3);
    }
    if (isSdkShare())
    {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SDK_SHARE onError");
    }
    else
    {
      this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq, 32768, this.mProcessorReport.errCode);
      sendMessageToUpdate(1005);
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "56");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.mProcessorReport.errCode);
    ((Bundle)localObject1).putString("intext_1", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(l);
    ((Bundle)localObject1).putString("intext_5", ((StringBuilder)localObject2).toString());
    localObject2 = ReportCenter.a();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(this.mAppId);
    ((ReportCenter)localObject2).a((Bundle)localObject1, ((StringBuilder)localObject3).toString(), this.app.getCurrentUin(), false, isSdkShare());
  }
  
  void onSuccess()
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("OnSuccess, cost=");
    ((StringBuilder)localObject1).append(l);
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.app.getMessageFacade().b(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    if ((localObject1 != null) && ((localObject1 instanceof MessageForStructing)))
    {
      localObject1 = (MessageForStructing)localObject1;
      if ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg))
      {
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        ((AbsShareMsg)localObject1).shareData.status = 1003;
        ((AbsShareMsg)localObject1).forwardType = 0;
        this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq, ((AbsShareMsg)localObject1).getBytes());
      }
    }
    super.onSuccess();
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("report_type", "102");
    ((Bundle)localObject1).putString("act_type", "56");
    ((Bundle)localObject1).putString("intext_1", "0");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(l);
    ((Bundle)localObject1).putString("intext_5", ((StringBuilder)localObject2).toString());
    localObject2 = ReportCenter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.mAppId);
    ((ReportCenter)localObject2).a((Bundle)localObject1, localStringBuilder.toString(), this.app.getCurrentUin(), false, isSdkShare());
  }
  
  public void pause()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "pause");
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      ForwardSdkShareProcessor.ForwardStep localForwardStep = this.mSendMsgStep;
      if (localForwardStep != null) {
        localForwardStep.cancel();
      }
      localForwardStep = this.mSendMsgByServerStep;
      if (localForwardStep != null) {
        localForwardStep.cancel();
      }
    }
  }
  
  public int resume()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "resume");
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      start();
    }
    return 0;
  }
  
  public void start()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "start");
    this.mSendMsgStep = new ForwardSdkShareProcessor.SendMsgStep(this);
    this.mSendMsgByServerStep = new ForwardSdkShareProcessor.SendMsgByServerStep(this);
    ForwardSdkShareProcessor.UrlExchangeStep localUrlExchangeStep = new ForwardSdkShareProcessor.UrlExchangeStep(this);
    if (isSdkShare()) {
      this.mSendMsgByServerStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localUrlExchangeStep });
    } else {
      this.mSendMsgStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localUrlExchangeStep });
    }
    ForwardSdkShareProcessor.GetSKeyStep localGetSKeyStep = new ForwardSdkShareProcessor.GetSKeyStep(this);
    ForwardSdkShareProcessor.GetAppInfoStep localGetAppInfoStep = new ForwardSdkShareProcessor.GetAppInfoStep(this);
    ForwardSdkShareProcessor.ImageUploadStep localImageUploadStep = new ForwardSdkShareProcessor.ImageUploadStep(this);
    if ((!localUrlExchangeStep.isFinished()) && (localImageUploadStep.isFinished()))
    {
      localUrlExchangeStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localGetAppInfoStep, localGetSKeyStep });
    }
    else
    {
      localUrlExchangeStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localImageUploadStep });
      this.mRichStep = new ForwardSdkShareProcessor.RichStep(this);
      localImageUploadStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localGetAppInfoStep, this.mRichStep, localGetSKeyStep });
    }
    this.mStartTime = System.currentTimeMillis();
    if (isSdkShare())
    {
      this.mSendMsgByServerStep.doStep();
      return;
    }
    this.mSendMsgStep.doStep();
    sendMessageToUpdate(1001);
    sendMessageToUpdateDelay(1002, MessageHandler.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor
 * JD-Core Version:    0.7.0.1
 */