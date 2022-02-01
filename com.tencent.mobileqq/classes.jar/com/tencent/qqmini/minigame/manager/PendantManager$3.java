package com.tencent.qqmini.minigame.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;

class PendantManager$3
  implements View.OnClickListener
{
  PendantManager$3(PendantManager paramPendantManager, PendantAdInfo paramPendantAdInfo, MiniAppProxy paramMiniAppProxy) {}
  
  public void onClick(View paramView)
  {
    PendantManager.access$400(this.this$0, this.val$pendantAdInfo, this.val$proxy);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantManager.3
 * JD-Core Version:    0.7.0.1
 */