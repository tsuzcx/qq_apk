package com.tencent.mobileqq.kandian.biz.gifvideo.media;

import android.content.Context;

public class MediaViewFactory
{
  public static IMediaView a(int paramInt, Context paramContext)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return new MediaGifView(paramContext);
      }
      return new MediaVideoView(paramContext);
    }
    return new MediaGifView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.media.MediaViewFactory
 * JD-Core Version:    0.7.0.1
 */