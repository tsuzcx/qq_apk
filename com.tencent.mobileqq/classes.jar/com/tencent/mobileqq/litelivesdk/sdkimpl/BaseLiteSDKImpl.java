package com.tencent.mobileqq.litelivesdk.sdkimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.crash.CrashInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.lottie.LottieServiceInterface;
import com.tencent.falco.base.libapi.qqsdk.QQSdkInterface;
import com.tencent.falco.base.libapi.web.WebInterface;
import com.tencent.falco.base.libapi.weibosdk.WeiboSdkInterface;
import com.tencent.falco.base.libapi.wns.WnsInterface;
import com.tencent.ilive.LiveConfig;
import com.tencent.ilive.LiveSDK;
import com.tencent.ilive.base.bizmodule.BizModulesConfig;
import com.tencent.ilive.config.UIConfig;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaService;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderService;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.servicefactory.ServiceConfig;
import com.tencent.livesdk.servicefactory.ServiceEnginScope;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.lite_now_biz.ILiteNowBizFactory;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.MsfChannelBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.crash.CrashVersionUtils;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.crash.CustomCrashBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.datareport.CustomDataReportBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download.CustomDownLoadBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.http.CustomHttpBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.liveconfig.CustomLiveConfigBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.log.CustomLogBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.lottie.CustomLottieBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.push.CustomRoomPushBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.DefaultCustomRoomServiceBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.share.CustomQQSdkBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.share.CustomWeiboSdkBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.userinfo.CustomUserInfoServiceBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.web.CustomWebServiceBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.wns.CustomWnsServiceBuilder;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.CustomizedServiceManager;
import com.tencent.mobileqq.litelivesdk.framework.login.LoginManager;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public abstract class BaseLiteSDKImpl
  implements ILiveSDK
{
  private AppRuntime a;
  
  public static LiveConfig a(LiveConfig paramLiveConfig)
  {
    if (paramLiveConfig == null) {
      return null;
    }
    paramLiveConfig.serviceConfig.add(ChannelInterface.class, new MsfChannelBuilder());
    paramLiveConfig.serviceConfig.add(CrashInterface.class, new CustomCrashBuilder());
    paramLiveConfig.serviceConfig.add(HttpInterface.class, new CustomHttpBuilder());
    paramLiveConfig.serviceConfig.add(LogSdkServiceInterface.class, new CustomLogBuilder());
    paramLiveConfig.serviceConfig.add(RoomServiceInterface.class, new DefaultCustomRoomServiceBuilder());
    paramLiveConfig.serviceConfig.add(WebInterface.class, new CustomWebServiceBuilder());
    paramLiveConfig.serviceConfig.add(UserInfoServiceInterface.class, new CustomUserInfoServiceBuilder());
    paramLiveConfig.serviceConfig.add(WnsInterface.class, new CustomWnsServiceBuilder());
    paramLiveConfig.serviceConfig.add(RoomPushServiceInterface.class, new CustomRoomPushBuilder());
    paramLiveConfig.serviceConfig.add(LiveConfigServiceInterface.class, new CustomLiveConfigBuilder());
    paramLiveConfig.serviceConfig.add(WeiboSdkInterface.class, new CustomWeiboSdkBuilder());
    paramLiveConfig.serviceConfig.add(QQSdkInterface.class, new CustomQQSdkBuilder());
    paramLiveConfig.serviceConfig.add(DownLoaderInterface.class, new CustomDownLoadBuilder());
    paramLiveConfig.serviceConfig.add(LottieServiceInterface.class, new CustomLottieBuilder());
    paramLiveConfig.serviceConfig.add(DataReportInterface.class, new CustomDataReportBuilder());
    paramLiveConfig.serviceConfig.add(IAudioMediaService.class, (BaseServiceBuilder)((ILiteNowBizFactory)QRoute.api(ILiteNowBizFactory.class)).getAudioMediaServiceBuilder(), ServiceEnginScope.Room);
    paramLiveConfig.serviceConfig.add(IPluginLoaderService.class, (BaseServiceBuilder)((ILiteNowBizFactory)QRoute.api(ILiteNowBizFactory.class)).getPluginLoaderServiceBuilder(), ServiceEnginScope.Room);
    return paramLiveConfig;
  }
  
  private void a(LiveEngine paramLiveEngine)
  {
    if (paramLiveEngine == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new BaseLiteSDKImpl.2(this, paramLiveEngine));
  }
  
  private void a(String paramString)
  {
    CustomizedServiceManager.a.a(paramString);
    LoginManager.a.c();
    BusinessManager.a.a(false);
    BusinessManager.a.a(null);
    BusinessManager.a.a();
    LiveSDK.unInit();
    QLog.e("EnterInitQuestion", 1, "switchBusiness LiveSDK uninit");
  }
  
  public BusinessConfig a()
  {
    return BusinessManager.a.a();
  }
  
  public LoginResult a()
  {
    return LoginManager.a.a();
  }
  
  public void a()
  {
    CustomizedServiceManager.a.a();
    LoginManager.a.b();
    BusinessManager.a.a(false);
    BusinessManager.a.a(null);
    LiveSDK.unInit();
    QLog.e("EnterInitQuestion", 1, "unInitLiveSDK LiveSDK uninit");
  }
  
  public void a(BusinessConfig paramBusinessConfig)
  {
    if (BusinessManager.a.a())
    {
      if (BusinessManager.a.a().jdField_a_of_type_JavaLangString.equals(paramBusinessConfig.jdField_a_of_type_JavaLangString))
      {
        LogFactory.a().e("BaseLiteSDKImpl", "--------Already Init, will Return");
        return;
      }
      localObject1 = LogFactory.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("--------Other Business already Init, will Switch Biz, oldAppid = ");
      ((StringBuilder)localObject2).append(BusinessManager.a.a().jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", newAppid = ");
      ((StringBuilder)localObject2).append(paramBusinessConfig.jdField_a_of_type_JavaLangString);
      ((LogInterface)localObject1).e("BaseLiteSDKImpl", ((StringBuilder)localObject2).toString());
      a(BusinessManager.a.a().jdField_a_of_type_JavaLangString);
    }
    IliveLiteMonitorUtil.a("live_init_sdk");
    LogFactory.a().a("BaseLiteSDKImpl", "initLiveSDK------will Init New Biz");
    BusinessManager.a.a(true);
    CrashVersionUtils.a();
    BusinessManager.a.a(paramBusinessConfig);
    Object localObject1 = new LiveConfig();
    ((LiveConfig)localObject1).appid = paramBusinessConfig.jdField_a_of_type_JavaLangString;
    ((LiveConfig)localObject1).versionName = paramBusinessConfig.jdField_b_of_type_JavaLangString;
    ((LiveConfig)localObject1).versionCode = paramBusinessConfig.jdField_a_of_type_Int;
    ((LiveConfig)localObject1).clientType = paramBusinessConfig.d;
    ((LiveConfig)localObject1).wns_appid = paramBusinessConfig.jdField_c_of_type_Int;
    ((LiveConfig)localObject1).opensdk_appid = paramBusinessConfig.jdField_b_of_type_Int;
    ((LiveConfig)localObject1).sdkType = paramBusinessConfig.a();
    ((LiveConfig)localObject1).channelID = paramBusinessConfig.jdField_c_of_type_JavaLangString;
    ((LiveConfig)localObject1).liteSdk = true;
    paramBusinessConfig = a((LiveConfig)localObject1);
    CustomizedServiceManager.a.a(paramBusinessConfig.appid, paramBusinessConfig.serviceConfig.get());
    localObject1 = new BizModulesConfig();
    Object localObject2 = CustomizedServiceManager.a.a(paramBusinessConfig.appid);
    if ((localObject2 != null) && (((Map)localObject2).size() != 0))
    {
      CustomizedServiceManager.a.b(paramBusinessConfig.appid, ((BizModulesConfig)localObject1).get());
      paramBusinessConfig.uiConfig.addModulesTempConfig(((Integer)((BizModulesConfig)localObject1).get().keySet().iterator().next()).intValue(), (BizModulesConfig)localObject1);
    }
    else
    {
      ((BizModulesConfig)localObject1).add(7, new BaseLiteSDKImpl.1(this));
      paramBusinessConfig.uiConfig.addModulesTempConfig(7, (BizModulesConfig)localObject1);
    }
    if (this.a == null) {
      this.a = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("ilive_plugin");
    }
    boolean bool = false;
    try
    {
      localObject1 = BizEngineMgr.getInstance().getLiveEngine();
      LiveSDK.init(BaseApplicationImpl.getContext(), paramBusinessConfig);
      a((LiveEngine)localObject1);
    }
    catch (Throwable paramBusinessConfig)
    {
      label415:
      break label415;
    }
    System.exit(0);
    IliveLiteMonitorUtil.c("live_init_sdk");
    paramBusinessConfig = new StringBuilder();
    paramBusinessConfig.append("LiveSDK.after , liveEngine== null ? ");
    if (LiveSDK.userEngine == null) {
      bool = true;
    }
    paramBusinessConfig.append(bool);
    QLog.e("EnterInitQuestion", 1, paramBusinessConfig.toString());
  }
  
  public void a(BizLoginRequest paramBizLoginRequest)
  {
    LoginManager.a.a(LoginManager.a(paramBizLoginRequest));
  }
  
  public void a(String paramString, int paramInt, Class<? extends BaseSDKPageBizBootModules> paramClass)
  {
    CustomizedServiceManager.a.a(paramString, paramInt, paramClass);
  }
  
  public void a(String paramString, IBusinessExpireObserver paramIBusinessExpireObserver)
  {
    BusinessManager.a.a(paramString, paramIBusinessExpireObserver);
  }
  
  public void a(String paramString, ILiveLoginTicketListener paramILiveLoginTicketListener)
  {
    LoginManager.a.a(paramString, paramILiveLoginTicketListener);
  }
  
  public void a(String paramString, Class<? extends ServiceBaseInterface> paramClass, Class<? extends BaseServiceBuilder> paramClass1)
  {
    CustomizedServiceManager.a.a(paramString, paramClass, paramClass1);
  }
  
  public boolean a()
  {
    return BusinessManager.a.a();
  }
  
  public void b()
  {
    LoginManager.a.c();
  }
  
  public void b(BusinessConfig paramBusinessConfig)
  {
    BusinessManager.a.a(paramBusinessConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.BaseLiteSDKImpl
 * JD-Core Version:    0.7.0.1
 */