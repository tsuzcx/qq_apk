package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.wink.pick.circle.event.WinkCircleJumpCameraPageEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoGridAdapter$7
  implements View.OnClickListener
{
  PhotoGridAdapter$7(PhotoGridAdapter paramPhotoGridAdapter) {}
  
  public void onClick(View paramView)
  {
    SimpleEventBus.getInstance().dispatchEvent(new WinkCircleJumpCameraPageEvent());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoGridAdapter.7
 * JD-Core Version:    0.7.0.1
 */