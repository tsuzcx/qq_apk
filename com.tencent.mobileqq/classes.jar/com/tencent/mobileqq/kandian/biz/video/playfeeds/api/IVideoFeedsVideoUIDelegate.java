package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import android.widget.SeekBar;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;

public abstract interface IVideoFeedsVideoUIDelegate
  extends IVideoUIDelegate
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(IVideoFeedsVideoUIDelegate.CallBack paramCallBack);
  
  public abstract void a(VideoInfo paramVideoInfo);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void onStartTrackingTouch(SeekBar paramSeekBar);
  
  public abstract void onStopTrackingTouch(SeekBar paramSeekBar);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate
 * JD-Core Version:    0.7.0.1
 */