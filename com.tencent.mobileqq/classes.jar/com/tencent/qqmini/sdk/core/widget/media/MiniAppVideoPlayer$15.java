package com.tencent.qqmini.sdk.core.widget.media;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import betc;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
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
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localActivity = (Activity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localActivity == null) || (MiniAppVideoPlayer.a(this.this$0) == null) || (!(this.this$0.getParent() instanceof CoverVideoView)) || (!this.this$0.c));
    MiniAppVideoPlayer.a(this.this$0, MiniAppVideoPlayer.a(this.this$0).getCurrentPostion());
    betc.a("MiniAppVideoPlayer", "smallScreen current pos is: " + MiniAppVideoPlayer.a(this.this$0));
    this.this$0.c = false;
    MiniAppVideoPlayer.j(this.this$0);
    MiniAppVideoPlayer.e(this.this$0).setVisibility(8);
    MiniAppVideoPlayer.d(this.this$0).setVisibility(8);
    localActivity.getWindow().clearFlags(1024);
    if (this.this$0.jdField_a_of_type_Benc != null) {}
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
      }
      this.this$0.b = System.currentTimeMillis();
      this.this$0.D = true;
      MiniAppVideoPlayer.a(this.this$0).postDelayed(new MiniAppVideoPlayer.15.1(this), 200L);
      MiniAppVideoPlayer.g(this.this$0);
      return;
      localActivity.setRequestedOrientation(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.15
 * JD-Core Version:    0.7.0.1
 */