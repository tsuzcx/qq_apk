package com.tencent.mobileqq.intervideo.lite_now_biz.impl;

import com.tencent.mobileqq.intervideo.lite_now_biz.ILiteNowBizFactory;
import com.tencent.mobileqq.intervideo.lite_now_biz.services.AudioMediaServiceBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.services.IAudioMediaServiceBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.services.IPluginLoaderServiceBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.services.PluginLoaderServiceBuilder;

public class LiteNowBizFactoryImpl
  implements ILiteNowBizFactory
{
  public IAudioMediaServiceBuilder getAudioMediaServiceBuilder()
  {
    return new AudioMediaServiceBuilder();
  }
  
  public IPluginLoaderServiceBuilder getPluginLoaderServiceBuilder()
  {
    return new PluginLoaderServiceBuilder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.impl.LiteNowBizFactoryImpl
 * JD-Core Version:    0.7.0.1
 */