package com.tencent.mobileqq.pttlogic.api.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.ptt.preop.PreSendTypeStrategy;
import com.tencent.mobileqq.ptt.preop.PttPreFlowController;
import com.tencent.mobileqq.ptt.preop.PttPreVoiceChanger;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.qqaudio.QQAudioSystemInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class PttPreSendServiceImpl
  implements IPttPreSendService
{
  public static final String TAG = "PttPreSendManager";
  private volatile boolean hasInit = false;
  AppRuntime mApp;
  int mFileSize = 0;
  PttPreFlowController mFlowController;
  boolean mIsWifi;
  volatile boolean mIsWorking = false;
  MessageRecord mMessage;
  String mPath;
  PreSendTypeStrategy mStrategy;
  String mTempPath;
  int mType = -1;
  PttPreVoiceChanger mVoiceChanger;
  public boolean sCpuSupport = false;
  private ConcurrentHashMap<String, PttPreSendServiceImpl.PreSendTask> sTasks = new ConcurrentHashMap();
  
  private boolean isPttCfgSupport(AppRuntime paramAppRuntime)
  {
    return ((IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class)).getPreSend_dpc(paramAppRuntime) == 1;
  }
  
  public void cleanUp()
  {
    if (!this.mIsWorking) {
      return;
    }
    this.mIsWorking = false;
    this.mPath = null;
    this.mTempPath = null;
    this.mMessage = null;
    if (QLog.isDevelopLevel()) {
      QLog.e("PttPreSendManager", 4, "clean up");
    }
  }
  
  public void doOnCancelSend()
  {
    this.mStrategy.a(null, -1);
    if (!this.mIsWorking) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("PttPreSendManager", 4, "doOnCancelSend");
    }
    Object localObject1 = (ITransFileController)this.mApp.getRuntimeService(ITransFileController.class, "all");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mMessage.frienduin);
    ((StringBuilder)localObject2).append(this.mMessage.uniseq);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = (BaseUploadProcessor)((ITransFileController)localObject1).findProcessor((String)localObject2);
    if (localObject1 != null) {
      ((BaseUploadProcessor)localObject1).cancel();
    }
    this.sTasks.remove(localObject2);
    this.mVoiceChanger.b();
    cleanUp();
  }
  
  public void doOnPreSendEnd(String paramString)
  {
    paramString = (PttPreSendServiceImpl.PreSendTask)this.sTasks.remove(paramString);
    if (paramString != null)
    {
      Object localObject = new File(paramString.b);
      if (((File)localObject).exists())
      {
        File localFile = new File(paramString.jdField_a_of_type_JavaLangString);
        if (localFile.exists()) {
          localFile.delete();
        }
        ((File)localObject).renameTo(localFile);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("rename presend file ! , from ");
          ((StringBuilder)localObject).append(paramString.b);
          ((StringBuilder)localObject).append(" to ");
          ((StringBuilder)localObject).append(paramString.jdField_a_of_type_JavaLangString);
          QLog.d("PttPreSendManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public boolean doOnRealSend(BaseSessionInfo paramBaseSessionInfo, int paramInt)
  {
    if ((this.sCpuSupport) && (isPttCfgSupport(this.mApp)))
    {
      this.mStrategy.a(this.mApp, paramInt);
      if (this.mType == paramInt) {
        this.mFlowController.a(this.mIsWifi, 1000L);
      }
    }
    boolean bool2 = this.mIsWorking;
    boolean bool1 = true;
    ITransFileController localITransFileController;
    Object localObject1;
    String str;
    if (bool2)
    {
      localITransFileController = (ITransFileController)this.mApp.getRuntimeService(ITransFileController.class, "all");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mMessage.frienduin);
      ((StringBuilder)localObject1).append(this.mMessage.uniseq);
      str = ((StringBuilder)localObject1).toString();
      localObject1 = (BaseUploadProcessor)localITransFileController.findProcessor(str);
      if (localObject1 != null)
      {
        if (paramInt == this.mType) {
          break label208;
        }
        if (QLog.isColorLevel()) {
          QLog.e("PttPreSendManager", 2, "doOnRealSend : predict failed, do origin logic");
        }
        ((BaseUploadProcessor)localObject1).cancel();
        localITransFileController.removeProcessor(str);
        this.sTasks.remove(str);
        this.mVoiceChanger.b();
      }
    }
    bool1 = false;
    break label403;
    label208:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doOnRealSend : predict hit !!, is send file end : ");
      ((StringBuilder)localObject2).append(((BaseUploadProcessor)localObject1).mUiRequest.mCanSendMsg);
      QLog.d("PttPreSendManager", 2, ((StringBuilder)localObject2).toString());
    }
    this.mFlowController.a(this.mIsWifi, this.mFileSize);
    Object localObject2 = (IPttTempApi)QRoute.api(IPttTempApi.class);
    AppRuntime localAppRuntime = this.mApp;
    ((IPttTempApi)localObject2).addAIOMessage(localAppRuntime, this.mMessage, localAppRuntime.getCurrentAccountUin());
    ((IPttTempApi)QRoute.api(IPttTempApi.class)).updatePttRecordMessage(this.mApp, paramBaseSessionInfo, this.mPath, -3, this.mMessage.uniseq);
    ThreadManager.postImmediately(new PttPreSendServiceImpl.1(this), null, false);
    ((BaseUploadProcessor)localObject1).fixTimeAtPttPreSend();
    try
    {
      if (((BaseUploadProcessor)localObject1).mUiRequest.mCanSendMsg)
      {
        localITransFileController.transferAsync(((BaseUploadProcessor)localObject1).mUiRequest);
        doOnPreSendEnd(str);
      }
      else
      {
        ((BaseUploadProcessor)localObject1).mUiRequest.mCanSendMsg = true;
      }
      label403:
      cleanUp();
      return bool1;
    }
    finally {}
  }
  
  public void doPreSendIfIcan(BaseSessionInfo paramBaseSessionInfo, RecordParams.RecorderParam paramRecorderParam)
  {
    if (!this.mIsWorking) {
      return;
    }
    int j = this.mVoiceChanger.a();
    this.mVoiceChanger.a();
    this.mFileSize = ((int)new File(this.mTempPath).length());
    int i = this.mFileSize;
    if ((i > 0) && (this.mFlowController.a(this.mIsWifi, i)))
    {
      MessageForPtt localMessageForPtt = ((IPttTempApi)QRoute.api(IPttTempApi.class)).createPttMessage(this.mApp, this.mPath, paramBaseSessionInfo, -2, paramRecorderParam.c);
      if (localMessageForPtt == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "createPttMessage null");
        }
        cleanUp();
        return;
      }
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mSelfUin = this.mApp.getAccount();
      localTransferRequest.mPeerUin = paramBaseSessionInfo.jdField_a_of_type_JavaLangString;
      localTransferRequest.mUinType = paramBaseSessionInfo.jdField_a_of_type_Int;
      localTransferRequest.mFileType = 2;
      localTransferRequest.mUniseq = localMessageForPtt.uniseq;
      i = 1;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mLocalPath = this.mTempPath;
      localTransferRequest.mBusiType = 1002;
      localTransferRequest.mPttCompressFinish = true;
      localTransferRequest.mPttUploadPanel = 3;
      localTransferRequest.mIsPttPreSend = true;
      localTransferRequest.mRec = localMessageForPtt;
      this.mMessage = localMessageForPtt;
      paramBaseSessionInfo = (MessageForPtt)this.mMessage;
      paramBaseSessionInfo.voiceType = paramRecorderParam.c;
      paramBaseSessionInfo.voiceLength = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(j);
      if (this.mType <= 0) {
        i = 0;
      }
      paramBaseSessionInfo.voiceChangeFlag = i;
      ((ITransFileController)this.mApp.getRuntimeService(ITransFileController.class, "all")).transferAsync(localTransferRequest);
      paramBaseSessionInfo = new StringBuilder();
      paramBaseSessionInfo.append(localTransferRequest.mPeerUin);
      paramBaseSessionInfo.append(localTransferRequest.mUniseq);
      paramBaseSessionInfo = paramBaseSessionInfo.toString();
      this.sTasks.put(paramBaseSessionInfo, new PttPreSendServiceImpl.PreSendTask(this.mPath, this.mTempPath));
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "doPreSendIfIcan ：true");
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramBaseSessionInfo = new StringBuilder();
        paramBaseSessionInfo.append("doPreSendIfIcan : false, flow don't enough or size < 0, seiz : ");
        paramBaseSessionInfo.append(this.mFileSize);
        QLog.e("PttPreSendManager", 2, paramBaseSessionInfo.toString());
      }
      cleanUp();
    }
  }
  
  public void handleSliceData(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.mIsWorking) {
      return;
    }
    if (!this.mVoiceChanger.a(paramArrayOfByte, paramInt)) {
      cleanUp();
    }
  }
  
  public void init()
  {
    if (!this.sCpuSupport)
    {
      int i = QQAudioSystemInfo.d();
      if ((i == 3) || (i == 4) || (i == 5)) {
        this.sCpuSupport = true;
      }
    }
    this.mFlowController = new PttPreFlowController(this.mApp, 100000, 10000000, 86399999L);
    this.mStrategy = new PreSendTypeStrategy(this.mApp);
    this.mVoiceChanger = new PttPreVoiceChanger();
    if (QLog.isColorLevel()) {
      QLog.d("PttPreSendManager", 2, "init manager end ");
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    init();
  }
  
  public void onDestroy()
  {
    Object localObject = this.mFlowController;
    if (localObject != null) {
      ((PttPreFlowController)localObject).a();
    }
    localObject = this.mStrategy;
    if (localObject != null) {
      ((PreSendTypeStrategy)localObject).a(this.mApp);
    }
  }
  
  public void startPreSendIfNeed(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    boolean bool2 = false;
    this.mIsWorking = false;
    this.mType = -1;
    boolean bool3 = isPttCfgSupport(this.mApp);
    boolean bool1 = bool2;
    if (this.sCpuSupport)
    {
      bool1 = bool2;
      if (bool3)
      {
        this.mType = this.mStrategy.a();
        long l = SystemClock.uptimeMillis();
        int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        bool1 = true;
        if (i != 1) {
          bool1 = false;
        }
        this.mIsWifi = bool1;
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get network type cost ");
          localStringBuilder.append(SystemClock.uptimeMillis() - l);
          QLog.d("PttPreSendManager", 4, localStringBuilder.toString());
        }
        bool1 = this.mFlowController.a(this.mIsWifi);
        if ((bool1) && (this.mType != -1))
        {
          this.mPath = paramString1;
          i = this.mPath.lastIndexOf(".");
          this.mTempPath = paramString1.substring(0, i);
          this.mTempPath = this.mTempPath.concat("_pre").concat(paramString1.substring(i, paramString1.length()));
          this.mIsWorking = this.mVoiceChanger.a(this.mApp.getApp(), this.mTempPath, this.mType, paramRecorderParam, paramString2);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append(" startPreSendIfNeed : ");
      paramString1.append(this.mIsWorking);
      paramString1.append(", cpu : ");
      paramString1.append(this.sCpuSupport);
      paramString1.append(", flow enough : ");
      paramString1.append(bool1);
      paramString1.append(", type : ");
      paramString1.append(this.mType);
      paramString1.append(", cfg : ");
      paramString1.append(bool3);
      QLog.d("PttPreSendManager", 2, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.PttPreSendServiceImpl
 * JD-Core Version:    0.7.0.1
 */