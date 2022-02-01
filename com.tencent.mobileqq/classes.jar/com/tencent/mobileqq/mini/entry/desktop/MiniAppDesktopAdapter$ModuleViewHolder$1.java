package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$ModuleViewHolder$1
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$ModuleViewHolder$1(MiniAppDesktopAdapter.ModuleViewHolder paramModuleViewHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = (Activity)MiniAppDesktopAdapter.ModuleViewHolder.access$2700(this.this$0).get();
    if ((paramView != null) && (MiniAppDesktopAdapter.ModuleViewHolder.access$2800(this.this$0) != null)) {
      if (this.val$moduleType != 1) {
        break label53;
      }
    }
    label53:
    for (int i = 3005;; i = 3004)
    {
      MiniAppDesktopAdapter.startMiniApp(paramView, MiniAppDesktopAdapter.ModuleViewHolder.access$2800(this.this$0), i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleViewHolder.1
 * JD-Core Version:    0.7.0.1
 */