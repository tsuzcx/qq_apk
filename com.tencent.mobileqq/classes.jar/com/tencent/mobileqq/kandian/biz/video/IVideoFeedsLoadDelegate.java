package com.tencent.mobileqq.kandian.biz.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;

public abstract interface IVideoFeedsLoadDelegate
{
  public abstract View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public abstract void a(DragFrameLayout paramDragFrameLayout);
  
  public abstract void a(VideoInfo paramVideoInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.IVideoFeedsLoadDelegate
 * JD-Core Version:    0.7.0.1
 */