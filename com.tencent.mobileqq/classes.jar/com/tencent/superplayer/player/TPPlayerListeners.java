package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class TPPlayerListeners
  implements ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoSizeChangedListener, TPCaptureCallBack
{
  private SPTPPlayerListeners mListeners;
  private ISPTPPlayer mPlayer;
  
  public TPPlayerListeners(ISPTPPlayer paramISPTPPlayer, SPTPPlayerListeners paramSPTPPlayerListeners)
  {
    this.mPlayer = paramISPTPPlayer;
    this.mListeners = paramSPTPPlayerListeners;
  }
  
  public void onCaptureVideoFailed(int paramInt)
  {
    this.mListeners.onCaptureVideoFailed(paramInt);
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    this.mListeners.onCaptureVideoSuccess(paramBitmap);
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    this.mListeners.onCompletion(this.mPlayer);
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.mListeners.onError(this.mPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    this.mListeners.onInfo(this.mPlayer, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    this.mListeners.onPrepared(this.mPlayer);
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    this.mListeners.onSeekComplete(this.mPlayer);
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mListeners.onVideoFrameOut(this.mPlayer, paramTPVideoFrameBuffer);
  }
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    this.mListeners.onVideoSizeChanged(this.mPlayer, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.TPPlayerListeners
 * JD-Core Version:    0.7.0.1
 */