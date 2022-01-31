package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.widget.TabBarView;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class MiniAppVideoPlayer$17
  implements Runnable
{
  MiniAppVideoPlayer$17(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    int i = 4;
    int j = 0;
    if (this.this$0.isBusyInChangeScreen) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.atyRef == null);
      localActivity = (Activity)this.this$0.atyRef.get();
    } while ((localActivity == null) || (MiniAppVideoPlayer.access$1100(this.this$0) == null) || (!(this.this$0.getParent() instanceof CoverVideoView)) || (!this.this$0.isFullScreen));
    MiniAppVideoPlayer.access$5202(this.this$0, MiniAppVideoPlayer.access$1100(this.this$0));
    MiniAppVideoPlayer.access$5302(this.this$0, MiniAppVideoPlayer.access$1100(this.this$0).getCurrentPostion());
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppVideoPlayer", 2, "smallScreen current pos is: " + MiniAppVideoPlayer.access$5300(this.this$0));
    }
    this.this$0.isFullScreen = false;
    MiniAppVideoPlayer.access$4400(this.this$0).setVisibility(8);
    MiniAppVideoPlayer.access$4500(this.this$0).setVisibility(8);
    if (this.this$0.hideTimeDesc)
    {
      MiniAppVideoPlayer.access$3500(this.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$2200(this.this$0).setVisibility(4);
      MiniAppVideoPlayer.access$3600(this.this$0).setVisibility(4);
    }
    if ((this.this$0.webviewContainer != null) && (this.this$0.webviewContainer.appBrandRuntime != null) && (this.this$0.webviewContainer.appBrandRuntime.getCurPage() != null))
    {
      if (this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar() != null) {
        this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar().setVisibility(MiniAppVideoPlayer.access$4600(this.this$0));
      }
      if (this.this$0.webviewContainer.appBrandRuntime.getCurPage().getTabBar() != null) {
        this.this$0.webviewContainer.appBrandRuntime.getCurPage().getTabBar().setVisibility(MiniAppVideoPlayer.access$4700(this.this$0));
      }
    }
    localActivity.getWindow().clearFlags(1024);
    Object localObject;
    if (this.this$0.webviewContainer != null)
    {
      localObject = this.this$0.webviewContainer.getPageOrientation();
      if (!WindowInfo.ORIENTATION_AUTO.equals(localObject)) {}
    }
    for (;;)
    {
      localActivity.setRequestedOrientation(i);
      label400:
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
          QLog.e("MiniAppVideoPlayer", 1, "smallScreen: ", localException);
          continue;
          i = 1;
          continue;
          i = 1;
        }
        this.this$0.lastSmallScreenTime = System.currentTimeMillis();
        this.this$0.isBusyInChangeScreen = true;
        MiniAppVideoPlayer.access$4200(this.this$0).postDelayed(new MiniAppVideoPlayer.17.1(this), 200L);
        MiniAppVideoPlayer.access$3800(this.this$0);
        MiniAppVideoPlayer.access$5400(this.this$0);
        return;
        if (!WindowInfo.ORIENTATION_LANDSCAPE.equals(localObject)) {
          continue;
        }
        i = 0;
        break;
        if ((GameRuntimeLoaderManager.g().getBindRuntimeLoader(localActivity) == null) || (GameRuntimeLoaderManager.g().getBindRuntimeLoader(localActivity).getMiniGamePkg() == null)) {
          break label400;
        }
        localObject = GameRuntimeLoaderManager.g().getBindRuntimeLoader(localActivity).getMiniGamePkg().mGameConfigJson;
        if (localObject == null) {
          break label400;
        }
        localObject = ((JSONObject)localObject).optString("deviceOrientation", null);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label400;
        }
        if (!"landscape".equals(localObject)) {
          continue;
        }
        i = j;
        localActivity.setRequestedOrientation(i);
        break label400;
        if (i == -16777216) {
          ImmersiveUtils.a(true, localActivity.getWindow());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.17
 * JD-Core Version:    0.7.0.1
 */