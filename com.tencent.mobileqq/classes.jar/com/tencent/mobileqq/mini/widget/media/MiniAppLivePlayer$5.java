package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

class MiniAppLivePlayer$5
  implements Runnable
{
  MiniAppLivePlayer$5(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
  public void run()
  {
    if (this.this$0.isBusyInChangeScreen) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.atyRef == null);
      localActivity = (Activity)this.this$0.atyRef.get();
    } while ((localActivity == null) || (MiniAppLivePlayer.access$600(this.this$0) == null) || (!(this.this$0.getParent() instanceof CoverLiveView)) || (!this.this$0.isFullScreen));
    this.this$0.isFullScreen = false;
    MiniAppLivePlayer.access$500(this.this$0);
    if ((this.this$0.webviewContainer != null) && (this.this$0.webviewContainer.appBrandRuntime != null) && (this.this$0.webviewContainer.appBrandRuntime.getCurPage() != null))
    {
      if (this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar() != null) {
        this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar().setVisibility(MiniAppLivePlayer.access$000(this.this$0));
      }
      if (this.this$0.webviewContainer.appBrandRuntime.getCurPage().getTabBar() != null) {
        this.this$0.webviewContainer.appBrandRuntime.getCurPage().getTabBar().setVisibility(MiniAppLivePlayer.access$100(this.this$0));
      }
    }
    localActivity.getWindow().clearFlags(1024);
    localActivity.setRequestedOrientation(1);
    if (Build.VERSION.SDK_INT >= 16) {
      localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    for (;;)
    {
      try
      {
        if ((this.this$0.webviewContainer != null) && (this.this$0.webviewContainer.appBrandRuntime != null) && (this.this$0.webviewContainer.appBrandRuntime.getCurPage() != null) && (this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar() != null))
        {
          i = this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar().getStatusNavigationBarTextStyle();
          if (i != -1) {
            continue;
          }
          ImmersiveUtils.a(false, localActivity.getWindow());
        }
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("MiniAppLivePlayer", 1, "smallScreen: ", localException);
        continue;
      }
      this.this$0.lastSmallScreenTime = System.currentTimeMillis();
      this.this$0.isBusyInChangeScreen = true;
      MiniAppLivePlayer.access$700(this.this$0).postDelayed(new MiniAppLivePlayer.5.1(this), 200L);
      return;
      if (i == -16777216) {
        ImmersiveUtils.a(true, localActivity.getWindow());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppLivePlayer.5
 * JD-Core Version:    0.7.0.1
 */