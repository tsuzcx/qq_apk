package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.TPLogUtil;

class SPTPPlayerListeners$TPPlayerListenersEmptyImpl
  implements SPTPPlayerListeners.Combine
{
  private String TAG;
  
  public SPTPPlayerListeners$TPPlayerListenersEmptyImpl(String paramString)
  {
    this.TAG = paramString;
  }
  
  public void onCaptureVideoFailed(int paramInt)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onCaptureVideoFailed");
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onCaptureVideoSuccess");
  }
  
  public void onCompletion(ISPTPPlayer paramISPTPPlayer)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onCompletion");
  }
  
  public void onError(ISPTPPlayer paramISPTPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onError");
  }
  
  public void onInfo(ISPTPPlayer paramISPTPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onInfo");
  }
  
  public void onPrepared(ISPTPPlayer paramISPTPPlayer)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onPrepared");
  }
  
  public void onSeekComplete(ISPTPPlayer paramISPTPPlayer)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onSeekComplete");
  }
  
  public void onVideoFrameOut(ISPTPPlayer paramISPTPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onVideoFrameOut");
  }
  
  public void onVideoSizeChanged(ISPTPPlayer paramISPTPPlayer, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(this.TAG, " empty player listener, notify, onVideoSizeChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPTPPlayerListeners.TPPlayerListenersEmptyImpl
 * JD-Core Version:    0.7.0.1
 */