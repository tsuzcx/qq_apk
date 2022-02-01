package com.tencent.tav.decoder.muxer;

import android.support.annotation.RequiresApi;

@RequiresApi(api=18)
public class MediaMuxerFactory
{
  private static MediaMuxerFactory.DefaultMediaMuxerCreator defaultMuxerCreator = new MediaMuxerFactory.DefaultMediaMuxerCreator(null);
  private static MediaMuxerFactory.MediaMuxerCreator muxerCreator = null;
  
  public static MediaMuxerFactory.MediaMuxerCreator getMuxerCreator()
  {
    MediaMuxerFactory.MediaMuxerCreator localMediaMuxerCreator = muxerCreator;
    Object localObject = localMediaMuxerCreator;
    if (localMediaMuxerCreator == null) {
      localObject = defaultMuxerCreator;
    }
    return localObject;
  }
  
  public static void setMuxerCreator(MediaMuxerFactory.MediaMuxerCreator paramMediaMuxerCreator)
  {
    muxerCreator = paramMediaMuxerCreator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.MediaMuxerFactory
 * JD-Core Version:    0.7.0.1
 */