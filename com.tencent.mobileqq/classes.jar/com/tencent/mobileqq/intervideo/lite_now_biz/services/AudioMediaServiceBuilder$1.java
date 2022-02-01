package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.ClassLoaderCallback;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;

class AudioMediaServiceBuilder$1
  implements IAudioMediaServiceAdapter
{
  AudioMediaServiceBuilder$1(AudioMediaServiceBuilder paramAudioMediaServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public ChannelInterface a()
  {
    return (ChannelInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(ChannelInterface.class);
  }
  
  public AppGeneralInfoService a()
  {
    return (AppGeneralInfoService)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(AppGeneralInfoService.class);
  }
  
  public HttpInterface a()
  {
    return (HttpInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(HttpInterface.class);
  }
  
  public LogInterface a()
  {
    return (LogInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(LogInterface.class);
  }
  
  public LoginServiceInterface a()
  {
    return (LoginServiceInterface)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(LoginServiceInterface.class);
  }
  
  public <T> void a(Class<T> paramClass, String paramString, ClassLoaderCallback paramClassLoaderCallback)
  {
    ((IPluginLoaderService)this.jdField_a_of_type_ComTencentLivesdkServicefactoryServiceAccessor.getService(IPluginLoaderService.class)).a(paramClass, paramString, new AudioMediaServiceBuilder.1.1(this, paramClassLoaderCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.AudioMediaServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */