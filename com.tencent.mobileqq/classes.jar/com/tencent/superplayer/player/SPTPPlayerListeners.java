package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class SPTPPlayerListeners
  implements ISPTPPlayer.IOnCaptureCallback, ISPTPPlayer.IOnCompletionListener, ISPTPPlayer.IOnErrorListener, ISPTPPlayer.IOnInfoListener, ISPTPPlayer.IOnPreparedListener, ISPTPPlayer.IOnSeekCompleteListener, ISPTPPlayer.IOnVideoFrameOutListener, ISPTPPlayer.IOnVideoSizeChangedListener
{
  private static final String FILENAME = "FCCTPPlayerListeners.java";
  private SPTPPlayerListeners.TPPlayerListenersEmptyImpl EMPTY_LISTENERS;
  private String TAG;
  private ISPTPPlayer.IOnCaptureCallback mOnCaptureListener;
  private ISPTPPlayer.IOnCompletionListener mOnCompletionListener;
  private ISPTPPlayer.IOnErrorListener mOnErrorListener;
  private ISPTPPlayer.IOnInfoListener mOnInfoListener;
  private ISPTPPlayer.IOnPreparedListener mOnPreparedListener;
  private ISPTPPlayer.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ISPTPPlayer.IOnVideoFrameOutListener mOnVideoFrameOutListener;
  private ISPTPPlayer.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  
  public SPTPPlayerListeners(String paramString)
  {
    this.TAG = (paramString + "_" + "FCCTPPlayerListeners.java");
    this.EMPTY_LISTENERS = new SPTPPlayerListeners.TPPlayerListenersEmptyImpl(this.TAG);
    this.mOnPreparedListener = this.EMPTY_LISTENERS;
    this.mOnCompletionListener = this.EMPTY_LISTENERS;
    this.mOnInfoListener = this.EMPTY_LISTENERS;
    this.mOnErrorListener = this.EMPTY_LISTENERS;
    this.mOnSeekCompleteListener = this.EMPTY_LISTENERS;
    this.mOnVideoSizeChangedListener = this.EMPTY_LISTENERS;
    this.mOnVideoFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnCaptureListener = this.EMPTY_LISTENERS;
  }
  
  public void clear()
  {
    this.mOnPreparedListener = this.EMPTY_LISTENERS;
    this.mOnCompletionListener = this.EMPTY_LISTENERS;
    this.mOnInfoListener = this.EMPTY_LISTENERS;
    this.mOnErrorListener = this.EMPTY_LISTENERS;
    this.mOnSeekCompleteListener = this.EMPTY_LISTENERS;
    this.mOnVideoSizeChangedListener = this.EMPTY_LISTENERS;
    this.mOnVideoFrameOutListener = this.EMPTY_LISTENERS;
  }
  
  public void onCaptureVideoFailed(int paramInt)
  {
    this.mOnCaptureListener.onCaptureVideoFailed(paramInt);
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    this.mOnCaptureListener.onCaptureVideoSuccess(paramBitmap);
  }
  
  public void onCompletion(ISPTPPlayer paramISPTPPlayer)
  {
    this.mOnCompletionListener.onCompletion(paramISPTPPlayer);
  }
  
  public void onError(ISPTPPlayer paramISPTPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.mOnErrorListener.onError(paramISPTPPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onInfo(ISPTPPlayer paramISPTPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    this.mOnInfoListener.onInfo(paramISPTPPlayer, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ISPTPPlayer paramISPTPPlayer)
  {
    this.mOnPreparedListener.onPrepared(paramISPTPPlayer);
  }
  
  public void onSeekComplete(ISPTPPlayer paramISPTPPlayer)
  {
    this.mOnSeekCompleteListener.onSeekComplete(paramISPTPPlayer);
  }
  
  public void onVideoFrameOut(ISPTPPlayer paramISPTPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mOnVideoFrameOutListener.onVideoFrameOut(paramISPTPPlayer, paramTPVideoFrameBuffer);
  }
  
  public void onVideoSizeChanged(ISPTPPlayer paramISPTPPlayer, long paramLong1, long paramLong2)
  {
    this.mOnVideoSizeChangedListener.onVideoSizeChanged(paramISPTPPlayer, paramLong1, paramLong2);
  }
  
  public void setOnCaptureListener(ISPTPPlayer.IOnCaptureCallback paramIOnCaptureCallback)
  {
    this.mOnCaptureListener = paramIOnCaptureCallback;
  }
  
  public void setOnCompletionListener(ISPTPPlayer.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mOnCompletionListener = paramIOnCompletionListener;
  }
  
  public void setOnErrorListener(ISPTPPlayer.IOnErrorListener paramIOnErrorListener)
  {
    this.mOnErrorListener = paramIOnErrorListener;
  }
  
  public void setOnInfoListener(ISPTPPlayer.IOnInfoListener paramIOnInfoListener)
  {
    this.mOnInfoListener = paramIOnInfoListener;
  }
  
  public void setOnPreparedListener(ISPTPPlayer.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mOnPreparedListener = paramIOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(ISPTPPlayer.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramIOnSeekCompleteListener;
  }
  
  public void setOnVideoFrameOutListener(ISPTPPlayer.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    this.mOnVideoFrameOutListener = paramIOnVideoFrameOutListener;
  }
  
  public void setOnVideoSizeChangedListener(ISPTPPlayer.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramIOnVideoSizeChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPTPPlayerListeners
 * JD-Core Version:    0.7.0.1
 */