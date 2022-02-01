package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsGestureLayout;", "", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getLastMotionTouchTime", "", "handleGestureEvent", "", "event", "", "percent", "", "onTouchEvent", "resetUI", "setChannelID", "channelID", "setContext", "activity", "Landroid/app/Activity;", "setIsInFullScreen", "isFullScreen", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOnCustomClickListener", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/CustomClickListener;", "setSeekBar", "seekBar", "Landroid/widget/SeekBar;", "setVideoBrightnessController", "brightnessController", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoBrightnessController;", "setVideoPlayManager", "playManager", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/api/IVideoPlayManager;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsPlayManager;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsGestureLayout
{
  public abstract void a();
  
  public abstract void setChannelID(long paramLong);
  
  public abstract void setContext(@Nullable Activity paramActivity);
  
  public abstract void setIsInFullScreen(boolean paramBoolean);
  
  public abstract void setOnCustomClickListener(@NotNull CustomClickListener paramCustomClickListener);
  
  public abstract void setVideoBrightnessController(@Nullable VideoBrightnessController paramVideoBrightnessController);
  
  public abstract void setVideoPlayManager(@Nullable IVideoFeedsPlayManager paramIVideoFeedsPlayManager);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsGestureLayout
 * JD-Core Version:    0.7.0.1
 */