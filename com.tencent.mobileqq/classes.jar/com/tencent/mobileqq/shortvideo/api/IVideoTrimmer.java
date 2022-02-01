package com.tencent.mobileqq.shortvideo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

@QAPI(process={"all"})
public abstract interface IVideoTrimmer
  extends QRouteApi
{
  public abstract VideoConverterConfig getCompressConfig(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.api.IVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */