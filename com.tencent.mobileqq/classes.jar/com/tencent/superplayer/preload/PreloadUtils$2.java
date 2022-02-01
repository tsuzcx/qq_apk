package com.tencent.superplayer.preload;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.superplayer.view.ISPlayerVideoView;

final class PreloadUtils$2
  implements Runnable
{
  PreloadUtils$2(ViewGroup paramViewGroup, ISPlayerVideoView paramISPlayerVideoView) {}
  
  public void run()
  {
    this.val$decorView.addView((View)this.val$videoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadUtils.2
 * JD-Core Version:    0.7.0.1
 */