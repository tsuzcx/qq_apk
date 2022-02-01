package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import com.tencent.ilivesdk.audiomediaservice.AudioMediaService;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class AudioMediaServiceBuilder
  implements BaseServiceBuilder
{
  public IAudioMediaService a(ServiceAccessor paramServiceAccessor)
  {
    AudioMediaService localAudioMediaService = new AudioMediaService();
    localAudioMediaService.a(new AudioMediaServiceBuilder.1(this, paramServiceAccessor));
    return localAudioMediaService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.AudioMediaServiceBuilder
 * JD-Core Version:    0.7.0.1
 */