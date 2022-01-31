package com.tencent.qqmini.sdk.core.widget.media;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import bglv;
import bgmf;
import bgmg;
import bgmq;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$15
  implements Runnable
{
  MiniAppVideoPlayer$15(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void run()
  {
    if (this.this$0.D) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.a == null);
      localActivity = (Activity)this.this$0.a.get();
    } while ((localActivity == null) || (MiniAppVideoPlayer.a(this.this$0) == null) || (!(this.this$0.getParent() instanceof CoverVideoView)) || (!this.this$0.c));
    MiniAppVideoPlayer.a(this.this$0, MiniAppVideoPlayer.a(this.this$0).getCurrentPostion());
    QMLog.d("MiniAppVideoPlayer", "smallScreen current pos is: " + MiniAppVideoPlayer.a(this.this$0));
    this.this$0.c = false;
    MiniAppVideoPlayer.j(this.this$0);
    MiniAppVideoPlayer.e(this.this$0).setVisibility(8);
    MiniAppVideoPlayer.d(this.this$0).setVisibility(8);
    bglv localbglv;
    String str;
    int i;
    if (this.this$0.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      localbglv = (bglv)this.this$0.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localbglv != null)
      {
        bgmq.a(localbglv).b(MiniAppVideoPlayer.i(this.this$0));
        bgmq.a(localbglv).a(MiniAppVideoPlayer.j(this.this$0));
      }
      localActivity.getWindow().clearFlags(1024);
      if (localbglv != null)
      {
        str = bgmg.a(localbglv).a();
        if (!WindowInfo.ORIENTATION_AUTO.equals(str)) {
          break label356;
        }
        i = 4;
      }
    }
    for (;;)
    {
      label251:
      localActivity.setRequestedOrientation(i);
      if (Build.VERSION.SDK_INT >= 16) {
        localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
      }
      if (localbglv != null) {}
      for (;;)
      {
        try
        {
          i = bgmf.a(localbglv).c();
          if (i != -1) {
            continue;
          }
          ImmersiveUtils.setStatusTextColor(false, localActivity.getWindow());
        }
        catch (Exception localException)
        {
          label356:
          QMLog.e("MiniAppVideoPlayer", "smallScreen: ", localException);
          continue;
          i = 1;
        }
        this.this$0.jdField_b_of_type_Long = System.currentTimeMillis();
        this.this$0.D = true;
        MiniAppVideoPlayer.a(this.this$0).postDelayed(new MiniAppVideoPlayer.15.1(this), 200L);
        MiniAppVideoPlayer.g(this.this$0);
        return;
        localbglv = null;
        break;
        if (!WindowInfo.ORIENTATION_LANDSCAPE.equals(str)) {
          continue;
        }
        i = 0;
        break label251;
        if (i == -16777216) {
          ImmersiveUtils.setStatusTextColor(true, localActivity.getWindow());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.15
 * JD-Core Version:    0.7.0.1
 */