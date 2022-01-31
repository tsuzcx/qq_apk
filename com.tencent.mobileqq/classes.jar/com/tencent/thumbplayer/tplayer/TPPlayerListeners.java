package com.tencent.thumbplayer.tplayer;

import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

public class TPPlayerListeners
  implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoSizeChangedListener
{
  private static String TAG = "TPPlayerListenerS";
  private TPPlayerListeners.TPPlayerListenersEmptyImpl EMPTY_LISTENERS;
  private ITPPlayerListener.IOnAudioFrameOutputListener mOnAudioFrameOutListener;
  private ITPPlayerListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  private ITPPlayerListener.IOnVideoFrameOutListener mOnVideoFrameOutListener;
  private ITPPlayerListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  
  public TPPlayerListeners(String paramString)
  {
    TAG = paramString;
    this.EMPTY_LISTENERS = new TPPlayerListeners.TPPlayerListenersEmptyImpl(null);
    this.mOnPreparedListener = this.EMPTY_LISTENERS;
    this.mOnCompletionListener = this.EMPTY_LISTENERS;
    this.mOnInfoListener = this.EMPTY_LISTENERS;
    this.mOnErrorListener = this.EMPTY_LISTENERS;
    this.mOnSeekCompleteListener = this.EMPTY_LISTENERS;
    this.mOnVideoSizeChangedListener = this.EMPTY_LISTENERS;
    this.mOnSubtitleDataListener = this.EMPTY_LISTENERS;
    this.mOnVideoFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioFrameOutListener = this.EMPTY_LISTENERS;
  }
  
  public void clear()
  {
    this.mOnPreparedListener = this.EMPTY_LISTENERS;
    this.mOnCompletionListener = this.EMPTY_LISTENERS;
    this.mOnInfoListener = this.EMPTY_LISTENERS;
    this.mOnErrorListener = this.EMPTY_LISTENERS;
    this.mOnSeekCompleteListener = this.EMPTY_LISTENERS;
    this.mOnVideoSizeChangedListener = this.EMPTY_LISTENERS;
    this.mOnSubtitleDataListener = this.EMPTY_LISTENERS;
    this.mOnVideoFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioFrameOutListener = this.EMPTY_LISTENERS;
  }
  
  public void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.mOnAudioFrameOutListener.onAudioFrameOut(paramITPPlayer, paramTPAudioFrameBuffer);
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    this.mOnCompletionListener.onCompletion(paramITPPlayer);
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.mOnErrorListener.onError(paramITPPlayer, paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    this.mOnInfoListener.onInfo(paramITPPlayer, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    this.mOnPreparedListener.onPrepared(paramITPPlayer);
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    this.mOnSeekCompleteListener.onSeekComplete(paramITPPlayer);
  }
  
  public void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
  {
    this.mOnSubtitleDataListener.onSubtitleData(paramITPPlayer, paramTPSubtitleData);
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mOnVideoFrameOutListener.onVideoFrameOut(paramITPPlayer, paramTPVideoFrameBuffer);
  }
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    this.mOnVideoSizeChangedListener.onVideoSizeChanged(paramITPPlayer, paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener)
  {
    this.mOnAudioFrameOutListener = paramIOnAudioFrameOutputListener;
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mOnCompletionListener = paramIOnCompletionListener;
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    this.mOnErrorListener = paramIOnErrorListener;
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    this.mOnInfoListener = paramIOnInfoListener;
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mOnPreparedListener = paramIOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramIOnSeekCompleteListener;
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    this.mOnSubtitleDataListener = paramIOnSubtitleDataListener;
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    this.mOnVideoFrameOutListener = paramIOnVideoFrameOutListener;
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramIOnVideoSizeChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayerListeners
 * JD-Core Version:    0.7.0.1
 */