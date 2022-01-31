package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.widget.TabBarView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$15
  implements Runnable
{
  MiniAppVideoPlayer$15(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    int m = 0;
    if (this.this$0.isBusyInChangeScreen) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.atyRef == null);
      localActivity = (Activity)this.this$0.atyRef.get();
    } while ((localActivity == null) || (!(this.this$0.getParent() instanceof CoverVideoView)));
    this.this$0.isFullScreen = true;
    MiniAppVideoPlayer.access$4100(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.access$4200(this.this$0).setVisibility(0);
    if (this.this$0.webviewContainer != null)
    {
      MiniAppVideoPlayer.access$4302(this.this$0, this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar().getVisibility());
      this.this$0.webviewContainer.appBrandRuntime.getCurPage().getNavBar().setVisibility(8);
      MiniAppVideoPlayer.access$4402(this.this$0, this.this$0.webviewContainer.appBrandRuntime.getCurPage().getTabBar().getVisibility());
      this.this$0.webviewContainer.appBrandRuntime.getCurPage().getTabBar().setVisibility(8);
    }
    MiniAppVideoPlayer.access$4502(this.this$0, ((CoverVideoView)this.this$0.getParent()).getLayoutParams());
    if (this.this$0.getParent().getParent() != null)
    {
      MiniAppVideoPlayer.access$4602(this.this$0, ((ViewGroup)this.this$0.getParent().getParent()).getScrollY());
      ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, 0);
    }
    int j;
    int k;
    int i;
    boolean bool;
    if (MiniAppVideoPlayer.access$800(this.this$0) != null)
    {
      j = MiniAppVideoPlayer.access$800(this.this$0).getVideoWidth();
      k = MiniAppVideoPlayer.access$800(this.this$0).getVideoHeight();
      if (j != 0)
      {
        i = k;
        if (k != 0) {}
      }
      else
      {
        j = MiniAppVideoPlayer.access$4700(this.this$0);
        i = MiniAppVideoPlayer.access$4800(this.this$0);
      }
      if ((MiniAppVideoPlayer.access$4900(this.this$0) == 0) || (MiniAppVideoPlayer.access$4900(this.this$0) == 180))
      {
        if (j >= i) {
          break label622;
        }
        bool = false;
      }
    }
    for (;;)
    {
      i = DisplayUtil.getRealHeight(this.this$0.getContext());
      j = ImmersiveUtils.a();
      label390:
      label395:
      Object localObject;
      if (bool)
      {
        k = i;
        if (!bool) {
          break label539;
        }
        if (this.this$0.webviewContainer != null) {
          break label544;
        }
        localObject = new RelativeLayout.LayoutParams(k, j);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
        ((CoverVideoView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        label443:
        localActivity.getWindow().getDecorView().setSystemUiVisibility(2);
        if (!bool) {
          break label585;
        }
        if (this.this$0.direction != -90)
        {
          i = m;
          if (this.this$0.direction != 270) {}
        }
        else
        {
          i = 8;
        }
      }
      for (;;)
      {
        localActivity.setRequestedOrientation(i);
        MiniAppVideoPlayer.access$5000(this.this$0, localActivity);
        MiniAppVideoPlayer.access$3500(this.this$0);
        MiniAppVideoPlayer.access$5100(this.this$0, bool);
        return;
        if (j <= i) {
          break label622;
        }
        bool = false;
        break;
        k = j;
        break label390;
        label539:
        j = i;
        break label395;
        label544:
        localObject = new FrameLayout.LayoutParams(k, j);
        ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
        ((FrameLayout.LayoutParams)localObject).topMargin = 0;
        ((CoverVideoView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label443;
        label585:
        if ((this.this$0.direction == 180) || (this.this$0.direction == -180)) {
          i = 9;
        } else {
          i = 1;
        }
      }
      label622:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.15
 * JD-Core Version:    0.7.0.1
 */