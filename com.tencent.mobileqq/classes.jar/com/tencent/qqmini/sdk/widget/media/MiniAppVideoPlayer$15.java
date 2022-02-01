package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qqmini.sdk.action.SetViewVisibilityAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$15
  implements Runnable
{
  MiniAppVideoPlayer$15(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    if ((this.this$0.isBusyInChangeScreen) || (!this.this$0.isFullScreen)) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.atyRef == null);
      localActivity = (Activity)this.this$0.atyRef.get();
    } while ((localActivity == null) || (MiniAppVideoPlayer.access$000(this.this$0) == null) || (!(this.this$0.getParent() instanceof CoverVideoView)));
    MiniAppVideoPlayer.access$5402(this.this$0, MiniAppVideoPlayer.access$000(this.this$0).getCurrentPostion());
    QMLog.d("MiniAppVideoPlayer", "smallScreen current pos is: " + MiniAppVideoPlayer.access$5400(this.this$0));
    this.this$0.isFullScreen = false;
    MiniAppVideoPlayer.access$5500(this.this$0);
    MiniAppVideoPlayer.access$4300(this.this$0).setVisibility(8);
    MiniAppVideoPlayer.access$4400(this.this$0).setVisibility(8);
    if (this.this$0.hideTimeDesc)
    {
      MiniAppVideoPlayer.access$3400(this.this$0).setVisibility(8);
      MiniAppVideoPlayer.access$300(this.this$0).setVisibility(8);
      MiniAppVideoPlayer.access$3500(this.this$0).setVisibility(8);
    }
    if (this.this$0.mMiniAppContext != null) {}
    for (IMiniAppContext localIMiniAppContext = (IMiniAppContext)this.this$0.mMiniAppContext.get();; localIMiniAppContext = null)
    {
      if (localIMiniAppContext != null)
      {
        SetViewVisibilityAction.obtain(localIMiniAppContext).setNaviBarVisibility(MiniAppVideoPlayer.access$4500(this.this$0));
        SetViewVisibilityAction.obtain(localIMiniAppContext).setTabBarVisibility(MiniAppVideoPlayer.access$4600(this.this$0));
      }
      localActivity.getWindow().clearFlags(1024);
      if (localIMiniAppContext != null)
      {
        MiniAppVideoPlayer.access$5600(this.this$0, localActivity, localIMiniAppContext);
        MiniAppVideoPlayer.access$5700(this.this$0, localActivity, localIMiniAppContext);
      }
      this.this$0.lastSmallScreenTime = System.currentTimeMillis();
      this.this$0.isBusyInChangeScreen = true;
      MiniAppVideoPlayer.access$2700(this.this$0).postDelayed(new MiniAppVideoPlayer.15.1(this), 200L);
      MiniAppVideoPlayer.access$3800(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.15
 * JD-Core Version:    0.7.0.1
 */