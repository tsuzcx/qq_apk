package com.tencent.qqmini.minigame.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

class FloatDragAdManager$2
  implements View.OnClickListener
{
  FloatDragAdManager$2(FloatDragAdManager paramFloatDragAdManager, FloatDragAdInfo paramFloatDragAdInfo, MiniAppProxy paramMiniAppProxy) {}
  
  public void onClick(View paramView)
  {
    FloatDragAdManager.access$100(this.this$0, this.val$floatDragAdInfo.getAdItem(), this.val$floatDragAdInfo.getType(), 102);
    FloatDragAdManager.access$200(this.this$0, this.val$floatDragAdInfo, this.val$proxy);
    FloatDragAdDataManager.requestAd(FloatDragAdManager.access$300(this.this$0), FloatDragAdManager.access$400(this.this$0), this.val$floatDragAdInfo.getAppId(), this.val$floatDragAdInfo.getScene());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.FloatDragAdManager.2
 * JD-Core Version:    0.7.0.1
 */