package com.tencent.mobileqq.litelivesdk.sdkimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.crash.CrashInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.qqsdk.QQSdkInterface;
import com.tencent.falco.base.libapi.web.WebInterface;
import com.tencent.falco.base.libapi.weibosdk.WeiboSdkInterface;
import com.tencent.falco.base.libapi.wns.WnsInterface;
import com.tencent.ilive.LiveConfig;
import com.tencent.ilive.LiveSDK;
import com.tencent.ilive.base.bizmodule.BizModulesConfig;
import com.tencent.ilive.config.UIConfig;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieServiceInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaService;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderService;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceConfig;
import com.tencent.livesdk.servicefactory.ServiceEnginScope;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.services.AudioMediaServiceBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.services.PluginLoaderServiceBuilder;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class BaseLiteSDKImpl
  implements ILiveSDK
{
  private AppRuntime a;
  
  private void a(String paramString)
  {
    CustomizedServiceManager.a.a(paramString);
    LoginManager.a.c();
    BusinessManager.a.a(false);
    BusinessManager.a.a(null);
    LiveSDK.unInit();
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
      LogFactory.a().e("BaseLiteSDKImpl", "--------Other Business already Init, will Switch Biz, oldAppid = " + BusinessManager.a.a().jdField_a_of_type_JavaLangString + ", newAppid = " + paramBusinessConfig.jdField_a_of_type_JavaLangString);
      a(BusinessManager.a.a().jdField_a_of_type_JavaLangString);
    }
    LogFactory.a().a("BaseLiteSDKImpl", "initLiveSDK------will Init New Biz");
    BusinessManager.a.a(true);
    CrashVersionUtils.a();
    BusinessManager.a.a(paramBusinessConfig);
    LiveConfig localLiveConfig = new LiveConfig();
    localLiveConfig.appid = paramBusinessConfig.jdField_a_of_type_JavaLangString;
    localLiveConfig.versionName = paramBusinessConfig.jdField_b_of_type_JavaLangString;
    localLiveConfig.versionCode = paramBusinessConfig.jdField_a_of_type_Int;
    localLiveConfig.clientType = paramBusinessConfig.d;
    localLiveConfig.wns_appid = paramBusinessConfig.jdField_c_of_type_Int;
    localLiveConfig.opensdk_appid = paramBusinessConfig.jdField_b_of_type_Int;
    localLiveConfig.sdkType = paramBusinessConfig.a();
    localLiveConfig.channelID = paramBusinessConfig.jdField_c_of_type_JavaLangString;
    localLiveConfig.liteSdk = true;
    localLiveConfig.serviceConfig.add(ChannelInterface.class, new MsfChannelBuilder());
    localLiveConfig.serviceConfig.add(CrashInterface.class, new CustomCrashBuilder());
    localLiveConfig.serviceConfig.add(HttpInterface.class, new CustomHttpBuilder());
    localLiveConfig.serviceConfig.add(LogSdkServiceInterface.class, new CustomLogBuilder());
    localLiveConfig.serviceConfig.add(RoomServiceInterface.class, new DefaultCustomRoomServiceBuilder());
    localLiveConfig.serviceConfig.add(WebInterface.class, new CustomWebServiceBuilder());
    localLiveConfig.serviceConfig.add(UserInfoServiceInterface.class, new CustomUserInfoServiceBuilder());
    localLiveConfig.serviceConfig.add(WnsInterface.class, new CustomWnsServiceBuilder());
    localLiveConfig.serviceConfig.add(RoomPushServiceInterface.class, new CustomRoomPushBuilder());
    localLiveConfig.serviceConfig.add(LiveConfigServiceInterface.class, new CustomLiveConfigBuilder());
    localLiveConfig.serviceConfig.add(WeiboSdkInterface.class, new CustomWeiboSdkBuilder());
    localLiveConfig.serviceConfig.add(QQSdkInterface.class, new CustomQQSdkBuilder());
    localLiveConfig.serviceConfig.add(DownLoaderInterface.class, new CustomDownLoadBuilder());
    localLiveConfig.serviceConfig.add(LottieServiceInterface.class, new CustomLottieBuilder());
    localLiveConfig.serviceConfig.add(DataReportInterface.class, new CustomDataReportBuilder());
    localLiveConfig.serviceConfig.add(IAudioMediaService.class, new AudioMediaServiceBuilder(), ServiceEnginScope.Room);
    localLiveConfig.serviceConfig.add(IPluginLoaderService.class, new PluginLoaderServiceBuilder(), ServiceEnginScope.Room);
    CustomizedServiceManager.a.a(localLiveConfig.appid, localLiveConfig.serviceConfig.get());
    paramBusinessConfig = new BizModulesConfig();
    Map localMap = CustomizedServiceManager.a.a(localLiveConfig.appid);
    if ((localMap == null) || (localMap.size() == 0))
    {
      paramBusinessConfig.add(7, new BaseLiteSDKImpl.1(this));
      localLiveConfig.uiConfig.addModulesTempConfig(7, paramBusinessConfig);
    }
    for (;;)
    {
      if (this.a == null) {
        this.a = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("ilive_plugin");
      }
      LiveSDK.init(BaseApplicationImpl.getContext(), localLiveConfig);
      return;
      CustomizedServiceManager.a.b(localLiveConfig.appid, paramBusinessConfig.get());
      localLiveConfig.uiConfig.addModulesTempConfig(((Integer)paramBusinessConfig.get().keySet().iterator().next()).intValue(), paramBusinessConfig);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.BaseLiteSDKImpl
 * JD-Core Version:    0.7.0.1
 */