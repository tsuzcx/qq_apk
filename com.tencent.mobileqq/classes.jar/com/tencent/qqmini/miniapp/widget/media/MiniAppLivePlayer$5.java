package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.TabBar;
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
    Object localObject = this.this$0.baseRuntime.getPage();
    if (!(localObject instanceof AppBrandPageContainer))
    {
      QMLog.d("MiniAppLivePlayer", "Page is invalid");
      return;
    }
    localObject = ((AppBrandPageContainer)localObject).getShowingPage();
    if (localObject != null)
    {
      if (((AppBrandPage)localObject).getNavBar() != null) {
        ((AppBrandPage)localObject).getNavBar().setVisibility(MiniAppLivePlayer.access$000(this.this$0));
      }
      if (((AppBrandPage)localObject).getTabBar() != null) {
        ((AppBrandPage)localObject).getTabBar().setVisibility(MiniAppLivePlayer.access$100(this.this$0));
      }
    }
    localActivity.getWindow().clearFlags(1024);
    localActivity.setRequestedOrientation(1);
    if (Build.VERSION.SDK_INT >= 16) {
      localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        i = ((AppBrandPage)localObject).getNavBar().getStatusNavigationBarTextStyle();
        if (i != -1) {
          continue;
        }
        ImmersiveUtils.setStatusTextColor(false, localActivity.getWindow());
      }
      catch (Exception localException)
      {
        int i;
        QMLog.e("MiniAppLivePlayer", "smallScreen: ", localException);
        continue;
      }
      this.this$0.lastSmallScreenTime = System.currentTimeMillis();
      this.this$0.isBusyInChangeScreen = true;
      MiniAppLivePlayer.access$700(this.this$0).postDelayed(new MiniAppLivePlayer.5.1(this), 200L);
      return;
      if (i == -16777216) {
        ImmersiveUtils.setStatusTextColor(true, localActivity.getWindow());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.5
 * JD-Core Version:    0.7.0.1
 */