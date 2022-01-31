package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

public class TPPlayerBaseListeners
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
{
  private static String TAG = "TPPlayerListenerS";
  private TPPlayerBaseListeners.TPPlayerListenersEmptyImpl EMPTY_LISTENERS;
  private ITPPlayerBaseListener.IOnAudioPcmOutListener mOnAudioFrameOutListener;
  private ITPPlayerBaseListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerBaseListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerBaseListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerBaseListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerBaseListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerBaseListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  private ITPPlayerBaseListener.IOnVideoFrameOutListener mOnVideoFrameOutListener;
  private ITPPlayerBaseListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  
  public TPPlayerBaseListeners(String paramString)
  {
    TAG = paramString;
    this.EMPTY_LISTENERS = new TPPlayerBaseListeners.TPPlayerListenersEmptyImpl(null);
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
  
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.mOnAudioFrameOutListener.onAudioPcmOut(paramTPAudioFrameBuffer);
  }
  
  public void onCompletion()
  {
    this.mOnCompletionListener.onCompletion();
  }
  
  public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.mOnErrorListener.onError(paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    this.mOnInfoListener.onInfo(paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared()
  {
    this.mOnPreparedListener.onPrepared();
  }
  
  public void onSeekComplete()
  {
    this.mOnSeekCompleteListener.onSeekComplete();
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    this.mOnSubtitleDataListener.onSubtitleData(paramTPSubtitleData);
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mOnVideoFrameOutListener.onVideoFrameOut(paramTPVideoFrameBuffer);
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    this.mOnVideoSizeChangedListener.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmOutListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    this.mOnAudioFrameOutListener = paramIOnAudioPcmOutListener;
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.mOnCompletionListener = paramIOnCompletionListener;
  }
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    this.mOnErrorListener = paramIOnErrorListener;
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    this.mOnInfoListener = paramIOnInfoListener;
  }
  
  public void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.mOnPreparedListener = paramIOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramIOnSeekCompleteListener;
  }
  
  public void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    this.mOnSubtitleDataListener = paramIOnSubtitleDataListener;
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    this.mOnVideoFrameOutListener = paramIOnVideoFrameOutListener;
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramIOnVideoSizeChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerBaseListeners
 * JD-Core Version:    0.7.0.1
 */