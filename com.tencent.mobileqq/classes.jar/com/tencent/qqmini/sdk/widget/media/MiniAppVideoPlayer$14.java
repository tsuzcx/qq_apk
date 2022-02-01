package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qqmini.sdk.action.GetPageIntAction;
import com.tencent.qqmini.sdk.action.SetViewVisibilityAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$14
  implements Runnable
{
  MiniAppVideoPlayer$14(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
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
    } while ((localActivity == null) || (!(this.this$0.getParent() instanceof CoverVideoView)));
    this.this$0.isFullScreen = true;
    MiniAppVideoPlayer.access$4400(this.this$0).setVisibility(0);
    MiniAppVideoPlayer.access$4500(this.this$0).setVisibility(0);
    if (this.this$0.hideTimeDesc)
    {
      MiniAppVideoPlayer.access$3400(this.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$300(this.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$3500(this.this$0).setVisibility(0);
      MiniAppVideoPlayer.access$3400(this.this$0).setText(MiniAppVideoPlayer.access$100(MiniAppVideoPlayer.access$000(this.this$0).getDuration()));
    }
    if (this.this$0.mMiniAppContext != null) {}
    for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.this$0.mMiniAppContext.get();; localIMiniAppContext = null)
    {
      if (localIMiniAppContext != null)
      {
        MiniAppVideoPlayer.access$4602(this.this$0, GetPageIntAction.obtain(localIMiniAppContext).getNaviBarVisibility());
        MiniAppVideoPlayer.access$4702(this.this$0, GetPageIntAction.obtain(localIMiniAppContext).getTabBarVisibility());
        SetViewVisibilityAction.obtain(localIMiniAppContext).setNaviBarVisibility(8);
        SetViewVisibilityAction.obtain(localIMiniAppContext).setTabBarVisibility(8);
      }
      MiniAppVideoPlayer.access$4802(this.this$0, ((CoverVideoView)this.this$0.getParent()).getLayoutParams());
      if (this.this$0.getParent().getParent() != null)
      {
        MiniAppVideoPlayer.access$4902(this.this$0, ((ViewGroup)this.this$0.getParent().getParent()).getScrollY());
        ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, 0);
      }
      boolean bool = MiniAppVideoPlayer.access$5000(this.this$0);
      MiniAppVideoPlayer.access$5100(this.this$0, localIMiniAppContext, bool);
      localActivity.getWindow().getDecorView().setSystemUiVisibility(2);
      MiniAppVideoPlayer.access$5200(this.this$0, localActivity, bool);
      MiniAppVideoPlayer.access$5300(this.this$0, localActivity);
      MiniAppVideoPlayer.access$3800(this.this$0);
      MiniAppVideoPlayer.access$5400(this.this$0, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.14
 * JD-Core Version:    0.7.0.1
 */