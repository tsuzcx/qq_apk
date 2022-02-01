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
    return (ChannelInterface)this.a.getService(ChannelInterface.class);
  }
  
  public <T> void a(Class<T> paramClass, String paramString, ClassLoaderCallback paramClassLoaderCallback)
  {
    ((IPluginLoaderService)this.a.getService(IPluginLoaderService.class)).a(paramClass, paramString, new AudioMediaServiceBuilder.1.1(this, paramClassLoaderCallback));
  }
  
  public LoginServiceInterface b()
  {
    return (LoginServiceInterface)this.a.getService(LoginServiceInterface.class);
  }
  
  public LogInterface c()
  {
    return (LogInterface)this.a.getService(LogInterface.class);
  }
  
  public AppGeneralInfoService d()
  {
    return (AppGeneralInfoService)this.a.getService(AppGeneralInfoService.class);
  }
  
  public HttpInterface e()
  {
    return (HttpInterface)this.a.getService(HttpInterface.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.AudioMediaServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */