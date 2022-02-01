package com.tencent.thumbplayer.tplayer;

import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

public class TPPlayerListeners
  implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoSizeChangedListener
{
  private static String TAG = "TPPlayerListenerS";
  private TPPlayerListeners.TPPlayerListenersEmptyImpl EMPTY_LISTENERS;
  private ITPPlayerListener.IOnAudioFrameOutputListener mOnAudioFrameOutListener;
  private ITPPlayerListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerListener.IOnStateChangeListener mOnPlayerStateChangeListener;
  private ITPPlayerListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  private ITPPlayerListener.IOnSubtitleFrameOutListener mOnSubtitleFrameOutListener;
  private ITPPlayerListener.IOnVideoFrameOutListener mOnVideoFrameOutListener;
  private ITPPlayerListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  
  TPPlayerListeners(String paramString)
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
    this.mOnSubtitleFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnVideoFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnAudioFrameOutListener = this.EMPTY_LISTENERS;
    this.mOnPlayerStateChangeListener = this.EMPTY_LISTENERS;
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
    this.mOnPlayerStateChangeListener = this.EMPTY_LISTENERS;
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
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    this.mOnPlayerStateChangeListener.onStateChange(paramInt1, paramInt2);
  }
  
  public void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
  {
    this.mOnSubtitleDataListener.onSubtitleData(paramITPPlayer, paramTPSubtitleData);
  }
  
  public void onSubtitleFrameOut(ITPPlayer paramITPPlayer, TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    this.mOnSubtitleFrameOutListener.onSubtitleFrameOut(paramITPPlayer, paramTPSubtitleFrameBuffer);
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
    Object localObject = paramIOnAudioFrameOutputListener;
    if (paramIOnAudioFrameOutputListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnAudioFrameOutListener = ((ITPPlayerListener.IOnAudioFrameOutputListener)localObject);
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    Object localObject = paramIOnCompletionListener;
    if (paramIOnCompletionListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnCompletionListener = ((ITPPlayerListener.IOnCompletionListener)localObject);
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    Object localObject = paramIOnErrorListener;
    if (paramIOnErrorListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnErrorListener = ((ITPPlayerListener.IOnErrorListener)localObject);
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    Object localObject = paramIOnInfoListener;
    if (paramIOnInfoListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnInfoListener = ((ITPPlayerListener.IOnInfoListener)localObject);
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    Object localObject = paramIOnStateChangeListener;
    if (paramIOnStateChangeListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnPlayerStateChangeListener = ((ITPPlayerListener.IOnStateChangeListener)localObject);
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    Object localObject = paramIOnPreparedListener;
    if (paramIOnPreparedListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnPreparedListener = ((ITPPlayerListener.IOnPreparedListener)localObject);
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    Object localObject = paramIOnSeekCompleteListener;
    if (paramIOnSeekCompleteListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSeekCompleteListener = ((ITPPlayerListener.IOnSeekCompleteListener)localObject);
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    Object localObject = paramIOnSubtitleDataListener;
    if (paramIOnSubtitleDataListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSubtitleDataListener = ((ITPPlayerListener.IOnSubtitleDataListener)localObject);
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    Object localObject = paramIOnSubtitleFrameOutListener;
    if (paramIOnSubtitleFrameOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSubtitleFrameOutListener = ((ITPPlayerListener.IOnSubtitleFrameOutListener)localObject);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    Object localObject = paramIOnVideoFrameOutListener;
    if (paramIOnVideoFrameOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoFrameOutListener = ((ITPPlayerListener.IOnVideoFrameOutListener)localObject);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    Object localObject = paramIOnVideoSizeChangedListener;
    if (paramIOnVideoSizeChangedListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoSizeChangedListener = ((ITPPlayerListener.IOnVideoSizeChangedListener)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayerListeners
 * JD-Core Version:    0.7.0.1
 */