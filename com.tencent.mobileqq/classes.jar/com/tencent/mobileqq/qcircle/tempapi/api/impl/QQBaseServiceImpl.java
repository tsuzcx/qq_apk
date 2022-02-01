package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.biz.qqstory.notification.StoryMsgNotificationUtils;
import com.tencent.biz.subscribe.beans.SerializableMap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment;
import com.tencent.mobileqq.activity.qcircle.handler.QCircleHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.intervideo.IVLoggerFactory;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdFragment;
import com.tencent.mobileqq.qcircle.api.hybird.QCircleHybirdStyleFactory;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper;
import com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.FlutterInstallCallBack;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.IAEKitResult;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.QCircleVideoSdkInitListener;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.tavcut.TAVCut;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.aeeditor.AEEditorProcessManager;
import java.io.Serializable;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQBaseServiceImpl
  implements IQQBaseService
{
  private static final int RETCODE_AEKITFORQQ_NOT_INIT = -601;
  private static final int RETCODE_IMAGE_ALGO_FAIL = -606;
  private static final int RETCODE_LIGHT_SDK_FAIL = -607;
  private static final int RETCODE_PAG_FAIL = -605;
  private static final int RETCODE_PTU_ALGO_FAIL = -604;
  private static final int RETCODE_PTU_TOOLS_FAIL = -603;
  private static final int RETCODE_YT_COMMON_FAIL = -602;
  private static final String TAG = "QQBaseServiceImpl";
  private static final String UPLOAD_TAG = "[upload2]";
  
  private AppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  private QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public int SUPPORT_AVC_DEC()
  {
    return 1;
  }
  
  public int SUPPORT_AVC_ENC()
  {
    return 2;
  }
  
  public int checkSupportMediaCodecFeature()
  {
    return ShortVideoCodec.checkSupportMediaCodecFeature(MobileQQ.sMobileQQ.getApplicationContext());
  }
  
  public void clearAvatarListener()
  {
    if (getQCircleHandler() != null) {
      getQCircleHandler().a();
    }
  }
  
  public void clearRedDotInfo()
  {
    ThreadManager.post(new QQBaseServiceImpl.3(this), 5, null, false);
  }
  
  public String getAccountName(String paramString)
  {
    if (getQQAppInterface() != null) {
      return ContactUtils.h(getQQAppInterface(), paramString);
    }
    return "";
  }
  
  public String getBuddyName(String paramString)
  {
    if (getQQAppInterface() != null) {
      return ContactUtils.c(getQQAppInterface(), paramString, true);
    }
    return "";
  }
  
  public BusinessHandler getBusinessHandler(String paramString)
  {
    if (getAppInterface() == null) {
      return null;
    }
    return getQQAppInterface().getBusinessHandler(paramString);
  }
  
  public int getDoubleEmoji(int paramInt1, int paramInt2)
  {
    return EmotcationConstants.getDoubleEmoji(paramInt1, paramInt2);
  }
  
  public int getEmojiUnicode(int paramInt)
  {
    return QQEmojiUtil.getEmojiUnicode(paramInt);
  }
  
  public IEmoticonMainPanelApp getEmotionImpl()
  {
    return new QQEmoticonMainPanelApp();
  }
  
  public String getFaceString(int paramInt)
  {
    return QQSysFaceUtil.getFaceString(paramInt);
  }
  
  public String getFriendNick(String paramString)
  {
    if (getQQAppInterface() != null) {
      return ContactUtils.a(getQQAppInterface(), paramString);
    }
    return "";
  }
  
  public ILoggerFactory getILoggerFactory()
  {
    return IVLoggerFactory.a();
  }
  
  public String getImei()
  {
    return MobileInfoUtil.c();
  }
  
  public int getLocalIdFromEMCodeFromEmoji(String paramString)
  {
    return QQEmojiUtil.getLocalIdFromEMCode(paramString);
  }
  
  public int getLocalIdFromEMCodeFromSystem(String paramString)
  {
    return QQSysFaceUtil.getLocalIdFromEMCode(paramString);
  }
  
  public void getNewQQHead(String paramString, IAvatarListener paramIAvatarListener)
  {
    QCircleHandler localQCircleHandler = getQCircleHandler();
    ToServiceMsg localToServiceMsg;
    QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq;
    QQHeadUrl.ReqUsrInfo localReqUsrInfo;
    if (localQCircleHandler != null)
    {
      localToServiceMsg = localQCircleHandler.createToServiceMsg("IncreaseURLSvr.QQHeadUrlReq");
      localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
      localQQHeadUrlReq.srcUsrType.set(1);
      localQQHeadUrlReq.srcUin.set(Long.parseLong(((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getCurrentAccountUin()));
      localQQHeadUrlReq.dstUsrType.set(1);
      localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
    }
    try
    {
      localReqUsrInfo.dstUin.set(Long.parseLong(paramString));
      label89:
      localReqUsrInfo.timestamp.set(0);
      localQQHeadUrlReq.dstUsrInfos.add(localReqUsrInfo);
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("dstUsrType", 1);
      localToServiceMsg.extraData.putString("dstUin", paramString);
      localToServiceMsg.extraData.putBoolean("qcircle", true);
      localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
      localQCircleHandler.a(paramString, paramIAvatarListener);
      localQCircleHandler.sendPbReq(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      break label89;
    }
  }
  
  public QCircleHandler getQCircleHandler()
  {
    QCircleHandler localQCircleHandler = null;
    if ((MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof QQAppInterface)) {
      localQCircleHandler = (QCircleHandler)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(BusinessHandlerFactory.QCIRCLE_HANDLER);
    }
    return localQCircleHandler;
  }
  
  public Class getQCircleHippyFragmentClass()
  {
    return QCircleHippyFragment.class;
  }
  
  public Class getQQBrowserActivityClass()
  {
    return QQBrowserActivity.class;
  }
  
  public Class getQQTranslucentBrowserActivityClass()
  {
    return QQTranslucentBrowserActivity.class;
  }
  
  public String getResolution()
  {
    return MobileInfoUtil.e();
  }
  
  public int getSingleEmoji(int paramInt)
  {
    return EmotcationConstants.getSingleEmoji(paramInt);
  }
  
  public Bundle getTroopProfileExtra(String paramString)
  {
    return TroopInfoActivity.a(paramString, 0);
  }
  
  public Intent handleQCircleHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("QQBaseServiceImpl", 1, "launchQCircleHybirdActivity url isEmpty");
      return paramIntent;
    }
    paramString = new StringBuilder().append(paramString).append("&theme=");
    int i;
    if (((IQCircleCommonUtil)QRoute.api(IQCircleCommonUtil.class)).isInNightMode())
    {
      i = 1;
      String str = i;
      paramString = paramContext;
      if (paramContext == null) {
        paramString = MobileQQ.sMobileQQ.getApplicationContext();
      }
      paramContext = paramIntent;
      if (paramIntent == null) {
        paramContext = new Intent();
      }
      paramContext.putExtra("url", str);
      QCircleHybirdStyleFactory.a(paramContext, str);
      paramContext.putExtra("titleBarStyle", 4);
      paramContext.putExtra(((IQZoneHelper)QRoute.api(IQZoneHelper.class)).KEY_TITLE_STYLE(), QCircleHybirdStyleFactory.a().a(paramString, str));
      if (!QCircleHybirdStyleFactory.a(str)) {
        break label237;
      }
      paramContext.putExtra("fromOneCLickCLose", false);
      paramContext.setClass(paramString, QQTranslucentBrowserActivity.class);
    }
    for (;;)
    {
      paramContext.putExtra(((IQZoneHelper)QRoute.api(IQZoneHelper.class)).FRAGMENT_CLASS(), QCircleHybirdFragment.class.getCanonicalName());
      if (paramInt == -1) {
        break label258;
      }
      paramContext.putExtra(((IQZoneHelper)QRoute.api(IQZoneHelper.class)).FRAGMENT_CLASS(), QCircleHybirdFragment.class.getCanonicalName());
      return paramContext;
      i = 0;
      break;
      label237:
      paramContext.putExtra("fromOneCLickCLose", true);
      paramContext.setClass(paramString, QQBrowserActivity.class);
    }
    label258:
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  public boolean initAEKit(IAEKitResult paramIAEKitResult)
  {
    if (!AEKitForQQ.a())
    {
      QLog.e("[upload2]QQBaseServiceImpl", 1, "!AEKitForQQ.init()");
      paramIAEKitResult.onDone(-601);
      return false;
    }
    if (!FeatureManager.Features.YT_COMMON.init())
    {
      QLog.e("[upload2]QQBaseServiceImpl", 1, "INIT_FAILED_LOAD_YTCOMMON_FAILED");
      paramIAEKitResult.onDone(-602);
      return false;
    }
    if (!FeatureManager.Features.PTU_TOOLS.init())
    {
      QLog.e("[upload2]QQBaseServiceImpl", 1, "INIT_FAILED_LOAD_PTUTOOLS_FAILED");
      paramIAEKitResult.onDone(-603);
      return false;
    }
    if (!FeatureManager.Features.PTU_ALGO.init())
    {
      QLog.e("[upload2]QQBaseServiceImpl", 1, "INIT_FAILED_LOAD_PTU_ALGO_FAILED");
      paramIAEKitResult.onDone(-604);
      return false;
    }
    if (!FeatureManager.Features.LIGHT_SDK.init())
    {
      QLog.e("[upload2]QQBaseServiceImpl", 1, "INIT_FAILED_LOAD_LIGHT_SDK_FAILED");
      paramIAEKitResult.onDone(-607);
      return false;
    }
    if (!FeatureManager.Features.IMAGE_ALGO.init())
    {
      QLog.e("[upload2]QQBaseServiceImpl", 1, "INIT_FAILED_LOAD_IMAGE_ALGO_FEATURE_FAILED");
      paramIAEKitResult.onDone(-606);
      return false;
    }
    TAVCut.initTAVCut(MobileQQ.sMobileQQ, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new QQBaseServiceImpl.5(this, paramIAEKitResult));
    return true;
  }
  
  public void initSDKAsync(QCircleVideoSdkInitListener paramQCircleVideoSdkInitListener)
  {
    QQVideoPlaySDKManager.a(MobileQQ.context, new QQBaseServiceImpl.4(this, paramQCircleVideoSdkInitListener));
  }
  
  public void installQFlutter(FlutterInstallCallBack paramFlutterInstallCallBack)
  {
    try
    {
      if (getQQAppInterface() == null) {
        return;
      }
      QFlutterInstaller.a(getQQAppInterface(), new QQBaseServiceImpl.2(this, paramFlutterInstallCallBack));
      return;
    }
    catch (Exception paramFlutterInstallCallBack)
    {
      QLog.e("QQBaseServiceImpl", 1, "[preloadFlutter] ", paramFlutterInstallCallBack);
    }
  }
  
  public boolean isDeviceSupport()
  {
    return QQSharpPUtil.b();
  }
  
  public boolean isFunctionAvaliable(Context paramContext)
  {
    return QQSharpPUtil.a(paramContext);
  }
  
  public boolean isQQForeground()
  {
    return StoryMsgNotificationUtils.a(getQQAppInterface());
  }
  
  public boolean isSkinEmoji(int paramInt)
  {
    return EmotcationConstants.isSkinEmoji(paramInt);
  }
  
  public void nativeSetMaxPhotoFrameCount(int paramInt)
  {
    VideoSourceHelper.nativeSetMaxPhotoFrameCount(paramInt);
  }
  
  public void openBottomTabSwitchActivity()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    try
    {
      Intent localIntent1 = new Intent(BaseActivity.sTopActivity, QQSettingSettingActivity.class);
      Intent localIntent2 = new Intent(BaseActivity.sTopActivity, AssistantSettingActivity.class);
      localIntent2.addFlags(268435456);
      Intent localIntent3 = new Intent();
      localIntent3.addFlags(268435456);
      localIntent3.addFlags(536870912);
      localIntent3.addFlags(67108864);
      localIntent3.setClass(BaseActivity.sTopActivity, PublicFragmentActivity.class);
      localIntent3.putExtra("public_fragment_class", BottomTabSettingFragment.class.getName());
      BaseActivity.sTopActivity.startActivities(new Intent[] { localIntent1, localIntent2, localIntent3 });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void requestGenerateVideo(String paramString)
  {
    AEEditorProcessManager.a().a(paramString);
  }
  
  public void sendQCircleAccountIdentityRequest(AccountIdentityCallBack paramAccountIdentityCallBack)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof QQAppInterface)) {
      LoginVerifyServlet.b((QQAppInterface)localAppRuntime, new QQBaseServiceImpl.1(this, paramAccountIdentityCallBack));
    }
  }
  
  public void updateRedDotInfo()
  {
    if (getQCircleHandler() != null) {
      getQCircleHandler().b();
    }
  }
  
  public Serializable wrapSerializableMap(HashMap paramHashMap)
  {
    SerializableMap localSerializableMap = new SerializableMap();
    localSerializableMap.setMap(paramHashMap);
    return localSerializableMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QQBaseServiceImpl
 * JD-Core Version:    0.7.0.1
 */