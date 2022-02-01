package com.tencent.mobileqq.intervideo.lite_now_biz;

import com.tencent.mobileqq.intervideo.lite_now_biz.services.IAudioMediaServiceBuilder;
import com.tencent.mobileqq.intervideo.lite_now_biz.services.IPluginLoaderServiceBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ILiteNowBizFactory
  extends QRouteApi
{
  public abstract IAudioMediaServiceBuilder getAudioMediaServiceBuilder();
  
  public abstract IPluginLoaderServiceBuilder getPluginLoaderServiceBuilder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.ILiteNowBizFactory
 * JD-Core Version:    0.7.0.1
 */