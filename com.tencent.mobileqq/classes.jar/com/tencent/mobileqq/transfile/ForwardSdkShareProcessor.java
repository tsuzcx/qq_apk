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
  protected QQAppInterface app = (QQAppInterface)this.app;
  protected Context mAppContext = this.app.getApp().getApplicationContext();
  private long mAppId;
  protected TransferRequest.AppInfo mAppInfo;
  protected String mAudioUrl;
  protected int mForwardType;
  private long mGetAppInfoTime;
  protected AtomicBoolean mIsAllUrlShort = new AtomicBoolean(false);
  private AtomicBoolean mIsImgUrlShort = new AtomicBoolean(false);
  private AtomicBoolean mIsThumbReady = new AtomicBoolean(false);
  private int mLackOfItems;
  protected String mLocalImgUrl;
  private String mPkgName;
  private boolean mRefreshTicket = false;
  protected String mRemoteImgUrl;
  private int mRetryCount = 0;
  private ForwardSdkShareProcessor.RichStep mRichStep;
  private String mSKey;
  private ForwardSdkShareProcessor.ForwardStep mSendMsgByServerStep;
  private ForwardSdkShareProcessor.ForwardStep mSendMsgStep;
  protected int mServiceType;
  protected String mShareSummary;
  protected String mShareTitle;
  long mStartTime = 0L;
  protected String mTargetUrl;
  protected HashMap<String, String> mUrlMap = new HashMap();
  
  public ForwardSdkShareProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
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
      if (paramBaseTransFileController.imageUrlStatus == 2)
      {
        this.mLocalImgUrl = paramBaseTransFileController.imageUrl;
        QLog.i("BaseTransProcessor", 1, "forwardShare info.imageUrlStatus =" + paramBaseTransFileController.imageUrlStatus + ",mRemoteImgUrl=" + this.mRemoteImgUrl);
        paramTransferRequest = this.mIsThumbReady;
        if ((paramBaseTransFileController.imageUrlStatus != 1) && (paramBaseTransFileController.imageUrlStatus != 3)) {
          break label329;
        }
        bool1 = true;
        label271:
        paramTransferRequest.set(bool1);
        paramTransferRequest = this.mIsImgUrlShort;
        if (paramBaseTransFileController.imageUrlStatus != 1) {
          break label334;
        }
        bool1 = true;
        label291:
        paramTransferRequest.set(bool1);
        paramTransferRequest = this.mIsAllUrlShort;
        if (paramBaseTransFileController.shortUrlStatus != 1) {
          break label339;
        }
      }
      label329:
      label334:
      label339:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramTransferRequest.set(bool1);
        return;
        this.mRemoteImgUrl = paramBaseTransFileController.imageUrl;
        break;
        bool1 = false;
        break label271;
        bool1 = false;
        break label291;
      }
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
    if (this.mSendMsgStep != null) {
      this.mSendMsgStep.cancel();
    }
    if (this.mSendMsgByServerStep != null) {
      this.mSendMsgByServerStep.cancel();
    }
    ThreadManager.excute(new ForwardSdkShareProcessor.1(this), 128, null, true);
  }
  
  public int cancel()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "cancel");
    super.cancel();
    if (this.mSendMsgStep != null) {
      this.mSendMsgStep.cancel();
    }
    if (this.mSendMsgByServerStep != null) {
      this.mSendMsgByServerStep.cancel();
    }
    this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq, 32768, 9037);
    sendMessageToUpdate(1004);
    return 0;
  }
  
  public int checkParam()
  {
    if (!(this.mUiRequest.mExtraObj instanceof TransferRequest.ShareExtraInfo))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "SdkShareInfo null");
      setError(9302, getExpStackString(new Exception("SdkShareInfo null")));
      onError();
      return -1;
    }
    if (TextUtils.isEmpty(this.mTargetUrl))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "share targetUrl null");
      setError(9302, getExpStackString(new Exception("share targetUrl null")));
      onError();
      return -1;
    }
    if (this.mAppInfo == null)
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + "mAppInfo null");
      setError(9302, getExpStackString(new Exception("mAppInfo null")));
      onError();
      return -1;
    }
    if (!ForwardUtils.a(this.mForwardType, this.mServiceType))
    {
      String str = "err forwardType=" + this.mForwardType + ",serviceType=" + this.mServiceType;
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "checkParam|" + str);
      setError(9302, getExpStackString(new Exception(str)));
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
    QLog.e("Q.share.ForwardSdkShareProcessor", 1, "On Error, code=" + this.errCode + ", cost=" + l);
    super.onError();
    if (this.mSendMsgStep != null) {
      this.mSendMsgStep.cancel();
    }
    if (this.mSendMsgByServerStep != null) {
      this.mSendMsgByServerStep.cancel();
    }
    UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
    localSendResult.jdField_a_of_type_Int = -1;
    Object localObject;
    if ((this.mUiRequest != null) && (this.mUiRequest.mUpCallBack != null))
    {
      if ((isSdkShare()) && (this.errCode == 9402) && (!ForwardUtils.a(this.mAppContext)))
      {
        String str1 = (String)this.mUrlMap.get("audioUrl");
        String str2 = this.mRemoteImgUrl;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = this.mAudioUrl;
        }
        localSendResult.jdField_a_of_type_JavaLangObject = new String[] { str2, localObject };
        localSendResult.b = this.errCode;
      }
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    if (isSdkShare()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SDK_SHARE onError");
    }
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "56");
      ((Bundle)localObject).putString("intext_1", "" + this.errCode);
      ((Bundle)localObject).putString("intext_5", "" + l);
      ReportCenter.a().a((Bundle)localObject, "" + this.mAppId, this.app.getCurrentUin(), false, isSdkShare());
      return;
      this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq, 32768, this.errCode);
      sendMessageToUpdate(1005);
    }
  }
  
  void onSuccess()
  {
    long l = System.currentTimeMillis() - this.mStartTime;
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "OnSuccess, cost=" + l);
    Object localObject = this.app.getMessageFacade().b(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).shareData.status = 1003;
      ((AbsShareMsg)localObject).forwardType = 0;
      this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq, ((AbsShareMsg)localObject).getBytes());
    }
    super.onSuccess();
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "56");
    ((Bundle)localObject).putString("intext_1", "0");
    ((Bundle)localObject).putString("intext_5", "" + l);
    ReportCenter.a().a((Bundle)localObject, "" + this.mAppId, this.app.getCurrentUin(), false, isSdkShare());
  }
  
  public void pause()
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "pause");
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (this.mSendMsgStep != null) {
        this.mSendMsgStep.cancel();
      }
      if (this.mSendMsgByServerStep != null) {
        this.mSendMsgByServerStep.cancel();
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
    ForwardSdkShareProcessor.GetSKeyStep localGetSKeyStep;
    ForwardSdkShareProcessor.GetAppInfoStep localGetAppInfoStep;
    ForwardSdkShareProcessor.ImageUploadStep localImageUploadStep;
    if (isSdkShare())
    {
      this.mSendMsgByServerStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localUrlExchangeStep });
      localGetSKeyStep = new ForwardSdkShareProcessor.GetSKeyStep(this);
      localGetAppInfoStep = new ForwardSdkShareProcessor.GetAppInfoStep(this);
      localImageUploadStep = new ForwardSdkShareProcessor.ImageUploadStep(this);
      if ((localUrlExchangeStep.isFinished()) || (!localImageUploadStep.isFinished())) {
        break label163;
      }
      localUrlExchangeStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localGetAppInfoStep, localGetSKeyStep });
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      if (!isSdkShare()) {
        break label215;
      }
      this.mSendMsgByServerStep.doStep();
      return;
      this.mSendMsgStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localUrlExchangeStep });
      break;
      label163:
      localUrlExchangeStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localImageUploadStep });
      this.mRichStep = new ForwardSdkShareProcessor.RichStep(this);
      localImageUploadStep.setLastSteps(new ForwardSdkShareProcessor.ForwardStep[] { localGetAppInfoStep, this.mRichStep, localGetSKeyStep });
    }
    label215:
    this.mSendMsgStep.doStep();
    sendMessageToUpdate(1001);
    sendMessageToUpdateDelay(1002, MessageHandler.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor
 * JD-Core Version:    0.7.0.1
 */