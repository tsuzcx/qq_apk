package com.tencent.mobileqq.kandian.base.video.plugin;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.IPlayerSDKMgr;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.plugin.api.IVideoPluginInstall;

public class VideoPluginInstall
  implements IVideoPluginInstall
{
  private static boolean b;
  private boolean a;
  private OnVideoPluginInstallListener c;
  private IPlayerSDKMgr d = PlayerHelper.a.c();
  private Handler e = new Handler(new VideoPluginInstall.3(this));
  
  public VideoPluginInstall()
  {
    ThreadManager.executeOnSubThread(new VideoPluginInstall.1(this));
  }
  
  private void e()
  {
    try
    {
      if (!b)
      {
        this.d.a();
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    if ((!b()) && (!this.a)) {
      ThreadManager.post(new VideoPluginInstall.2(this), 8, null, true);
    }
  }
  
  public void a(OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    this.c = paramOnVideoPluginInstallListener;
  }
  
  public boolean b()
  {
    return this.d.b();
  }
  
  public void c()
  {
    this.c = null;
    this.e.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall
 * JD-Core Version:    0.7.0.1
 */