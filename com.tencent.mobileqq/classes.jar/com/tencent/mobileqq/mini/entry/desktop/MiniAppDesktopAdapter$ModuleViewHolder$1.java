package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$ModuleViewHolder$1
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$ModuleViewHolder$1(MiniAppDesktopAdapter.ModuleViewHolder paramModuleViewHolder) {}
  
  public void onClick(View paramView)
  {
    paramView = (Activity)MiniAppDesktopAdapter.ModuleViewHolder.access$2600(this.this$0).get();
    LaunchParam localLaunchParam;
    if ((paramView != null) && (MiniAppDesktopAdapter.ModuleViewHolder.access$2700(this.this$0) != null))
    {
      localLaunchParam = new LaunchParam();
      localLaunchParam.scene = 3005;
    }
    try
    {
      MiniAppController.launchMiniAppByAppInfo(paramView, MiniAppDesktopAdapter.ModuleViewHolder.access$2700(this.this$0), localLaunchParam);
      return;
    }
    catch (MiniAppException paramView)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "desktop start app store exception: " + Log.getStackTraceString(paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleViewHolder.1
 * JD-Core Version:    0.7.0.1
 */