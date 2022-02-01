package com.tencent.mobileqq.qqvideoplatform.api;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoViewFactory;

public class QQVideoViewFactory
{
  static {}
  
  public static IBaseVideoView a(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return VideoViewFactory.createQQVideoPlayView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
  
  public static IBaseVideoView a(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    return VideoViewFactory.createCropBubbleView(paramContext, paramLong, paramVideoPlayParam, paramBoolean);
  }
  
  public static IBaseVideoView b(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return VideoViewFactory.createBaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
  
  public static IBaseVideoView c(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return VideoViewFactory.createBaseVideoViewFS(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory
 * JD-Core Version:    0.7.0.1
 */