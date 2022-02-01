package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$ModuleViewHolder$1
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$ModuleViewHolder$1(MiniAppDesktopAdapter.ModuleViewHolder paramModuleViewHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = (Activity)MiniAppDesktopAdapter.ModuleViewHolder.access$2700(this.this$0).get();
    if ((localActivity != null) && (MiniAppDesktopAdapter.ModuleViewHolder.access$2800(this.this$0) != null)) {
      if (this.val$moduleType != 1) {
        break label60;
      }
    }
    label60:
    for (int i = 3005;; i = 3004)
    {
      MiniAppDesktopAdapter.startMiniApp(localActivity, MiniAppDesktopAdapter.ModuleViewHolder.access$2800(this.this$0), i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleViewHolder.1
 * JD-Core Version:    0.7.0.1
 */