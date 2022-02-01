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
    if ((paramView != null) && (MiniAppDesktopAdapter.ModuleViewHolder.access$2800(this.this$0) != null))
    {
      int i;
      if (this.val$moduleType == 1) {
        i = 3005;
      } else {
        i = 3004;
      }
      MiniAppDesktopAdapter.startMiniApp(paramView, MiniAppDesktopAdapter.ModuleViewHolder.access$2800(this.this$0), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleViewHolder.1
 * JD-Core Version:    0.7.0.1
 */