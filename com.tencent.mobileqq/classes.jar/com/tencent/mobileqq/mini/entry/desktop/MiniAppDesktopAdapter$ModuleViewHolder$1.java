package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$ModuleViewHolder$1
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$ModuleViewHolder$1(MiniAppDesktopAdapter.ModuleViewHolder paramModuleViewHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Activity localActivity = (Activity)MiniAppDesktopAdapter.ModuleViewHolder.access$2700(this.this$0).get();
    LaunchParam localLaunchParam;
    int i;
    if ((localActivity != null) && (MiniAppDesktopAdapter.ModuleViewHolder.access$2800(this.this$0) != null))
    {
      localLaunchParam = new LaunchParam();
      if (this.val$moduleType != 1) {
        break label76;
      }
      i = 3005;
    }
    for (;;)
    {
      localLaunchParam.scene = i;
      try
      {
        MiniAppController.launchMiniAppByAppInfo(localActivity, MiniAppDesktopAdapter.ModuleViewHolder.access$2800(this.this$0), localLaunchParam);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label76:
        i = 3004;
      }
      catch (MiniAppException localMiniAppException)
      {
        for (;;)
        {
          QLog.e("MiniAppDesktopAdapter", 1, "desktop start app store exception: " + Log.getStackTraceString(localMiniAppException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleViewHolder.1
 * JD-Core Version:    0.7.0.1
 */