package com.tencent.superplayer.preload;

import com.tencent.superplayer.player.SuperPlayerWrapper;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;
import com.tencent.superplayer.view.SPlayerVideoView;

class PreloadPlayerMgr$1$1
  implements ISPlayerVideoView.IVideoViewCallBack
{
  PreloadPlayerMgr$1$1(PreloadPlayerMgr.1 param1, SuperPlayerWrapper paramSuperPlayerWrapper, SPlayerVideoView paramSPlayerVideoView) {}
  
  public void onSurfaceChanged(Object paramObject) {}
  
  public void onSurfaceCreated(Object paramObject)
  {
    this.val$playerWrapper.setSurface(this.val$cleanVideoView.getSurface());
  }
  
  public void onSurfaceDestroy(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadPlayerMgr.1.1
 * JD-Core Version:    0.7.0.1
 */