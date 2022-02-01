package com.tencent.mobileqq.minigame.jsapi.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.minigame.data.FloatDragAdInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FloatDragAdManager$2
  implements View.OnClickListener
{
  FloatDragAdManager$2(FloatDragAdManager paramFloatDragAdManager, FloatDragAdInfo paramFloatDragAdInfo, FloatDragAdDataManager.DragAdListener paramDragAdListener) {}
  
  public void onClick(View paramView)
  {
    FloatDragAdManager.access$100(this.this$0, this.val$floatDragAdInfo.getAdItem(), this.val$floatDragAdInfo.getType(), 102);
    FloatDragAdManager.access$200(this.this$0, this.val$floatDragAdInfo);
    FloatDragAdDataManager.requestAd(this.val$listener, this.val$floatDragAdInfo.getAppId(), this.val$floatDragAdInfo.getScene());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.FloatDragAdManager.2
 * JD-Core Version:    0.7.0.1
 */