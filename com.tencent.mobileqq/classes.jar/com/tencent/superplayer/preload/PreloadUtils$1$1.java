package com.tencent.superplayer.preload;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.superplayer.view.ISPlayerVideoView;

class PreloadUtils$1$1
  implements Runnable
{
  PreloadUtils$1$1(PreloadUtils.1 param1) {}
  
  public void run()
  {
    this.this$0.val$videoView.disableViewCallback();
    this.this$0.val$decorView.removeView((View)this.this$0.val$videoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadUtils.1.1
 * JD-Core Version:    0.7.0.1
 */