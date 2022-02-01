package com.tencent.tav.decoder.muxer;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@RequiresApi(api=18)
public class IMuxerFactory
{
  private static IMuxerFactory.DefaultMediaMuxerCreator defaultMuxerCreator = new IMuxerFactory.DefaultMediaMuxerCreator(null);
  private static IMuxerFactory.MediaMuxerCreator muxerCreator = null;
  
  public static IMediaMuxer createMediaMuxer(@NonNull String paramString, int paramInt)
  {
    IMuxerFactory.MediaMuxerCreator localMediaMuxerCreator = muxerCreator;
    if (localMediaMuxerCreator == null) {
      return defaultMuxerCreator.createMediaMuxer(paramString, paramInt);
    }
    return localMediaMuxerCreator.createMediaMuxer(paramString, paramInt);
  }
  
  public static void setMuxerCreator(IMuxerFactory.MediaMuxerCreator paramMediaMuxerCreator)
  {
    muxerCreator = paramMediaMuxerCreator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.IMuxerFactory
 * JD-Core Version:    0.7.0.1
 */