package com.tencent.superplayer.preload;

import android.view.ViewGroup;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

final class PreloadUtils$1
  implements ISPlayerVideoView.IVideoViewCallBack
{
  PreloadUtils$1(ViewGroup paramViewGroup, ISPlayerVideoView paramISPlayerVideoView) {}
  
  public void onSurfaceChanged(Object paramObject) {}
  
  public void onSurfaceCreated(Object paramObject)
  {
    this.val$decorView.post(new PreloadUtils.1.1(this));
  }
  
  public void onSurfaceDestroy(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadUtils.1
 * JD-Core Version:    0.7.0.1
 */