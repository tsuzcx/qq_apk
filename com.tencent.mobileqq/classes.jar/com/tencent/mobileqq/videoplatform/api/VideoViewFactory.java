package com.tencent.mobileqq.videoplatform.api;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.videoplatform.view.QQVideoPlayView;

public class VideoViewFactory
{
  public static IBaseVideoView createBaseVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return new BaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView, null);
  }
  
  public static IBaseVideoView createBaseVideoViewFS(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return new BaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView, null, true);
  }
  
  public static IBaseVideoView createCropBubbleView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    return new CropBubbleVideoView(paramContext, paramLong, paramVideoPlayParam, paramBoolean);
  }
  
  public static IBaseVideoView createQQVideoPlayView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    return new QQVideoPlayView(paramContext, paramLong, paramVideoPlayParam, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.api.VideoViewFactory
 * JD-Core Version:    0.7.0.1
 */