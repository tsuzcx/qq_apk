package com.tencent.qqmini.sdk.core.widget.media;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import bdka;

public class MiniAppVideoPlayer$8$2
  implements Runnable
{
  public MiniAppVideoPlayer$8$2(bdka parambdka) {}
  
  public void run()
  {
    if (this.a.a.u) {
      MiniAppVideoPlayer.d(this.a.a).setVisibility(0);
    }
    for (;;)
    {
      MiniAppVideoPlayer.a(this.a.a).setVisibility(8);
      MiniAppVideoPlayer.a(this.a.a).removeMessages(2002);
      return;
      MiniAppVideoPlayer.d(this.a.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.8.2
 * JD-Core Version:    0.7.0.1
 */