package com.tencent.tav.decoder.muxer;

import android.support.annotation.NonNull;

class IMuxerFactory$DefaultMediaMuxerCreator
  implements IMuxerFactory.MediaMuxerCreator
{
  public IMediaMuxer createMediaMuxer(@NonNull String paramString, int paramInt)
  {
    return new DefaultMediaMuxer(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.muxer.IMuxerFactory.DefaultMediaMuxerCreator
 * JD-Core Version:    0.7.0.1
 */