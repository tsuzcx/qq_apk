package com.tencent.thumbplayer.adapter;

import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCommonEnum.TPErrorType;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

public class TPPlayerBaseListeners
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnStateChangeListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnSubtitleFrameOutListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
{
  private static final String TAG = "TPPlayerListenerS";
  private TPPlayerBaseListeners.TPPlayerListenersEmptyImpl EMPTY_LISTENERS;
  private ITPPlayerBaseListener.IOnAudioPcmOutListener mOnAudioFrameOutListener;
  private ITPPlayerBaseListener.IOnAudioProcessOutListener mOnAudioProcessFrameOutListener;
  private ITPPlayerBaseListener.IOnCompletionListener mOnCompletionListener;
  private ITPPlayerBaseListener.IOnErrorListener mOnErrorListener;
  private ITPPlayerBaseListener.IOnInfoListener mOnInfoListener;
  private ITPPlayerBaseListener.IOnPreparedListener mOnPreparedListener;
  private ITPPlayerBaseListener.IOnSeekCompleteListener mOnSeekCompleteListener;
  private ITPPlayerBaseListener.IOnStateChangeListener mOnStateChangeListener;
  private ITPPlayerBaseListener.IOnSubtitleDataListener mOnSubtitleDataListener;
  private ITPPlayerBaseListener.IOnSubtitleFrameOutListener mOnSubtitleFrameOutListener;
  private ITPPlayerBaseListener.IOnVideoFrameOutListener mOnVideoFrameOutListener;
  private ITPPlayerBaseListener.IOnVideoProcessOutListener mOnVideoProcessFrameOutListener;
  private ITPPlayerBaseListener.IOnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private String mTag = "TPPlayerListenerS";
  
  public TPPlayerBaseListeners(String paramString)
  {
    updateTag(paramString);
    this.EMPTY_LISTENERS = new TPPlayerBaseListeners.TPPlayerListenersEmptyImpl(this.mTag);
    paramString = this.EMPTY_LISTENERS;
    this.mOnPreparedListener = paramString;
    this.mOnCompletionListener = paramString;
    this.mOnInfoListener = paramString;
    this.mOnErrorListener = paramString;
    this.mOnSeekCompleteListener = paramString;
    this.mOnVideoSizeChangedListener = paramString;
    this.mOnSubtitleDataListener = paramString;
    this.mOnVideoFrameOutListener = paramString;
    this.mOnAudioFrameOutListener = paramString;
    this.mOnSubtitleFrameOutListener = paramString;
    this.mOnVideoProcessFrameOutListener = paramString;
    this.mOnAudioProcessFrameOutListener = paramString;
  }
  
  public void clear()
  {
    TPPlayerBaseListeners.TPPlayerListenersEmptyImpl localTPPlayerListenersEmptyImpl = this.EMPTY_LISTENERS;
    this.mOnPreparedListener = localTPPlayerListenersEmptyImpl;
    this.mOnCompletionListener = localTPPlayerListenersEmptyImpl;
    this.mOnInfoListener = localTPPlayerListenersEmptyImpl;
    this.mOnErrorListener = localTPPlayerListenersEmptyImpl;
    this.mOnSeekCompleteListener = localTPPlayerListenersEmptyImpl;
    this.mOnVideoSizeChangedListener = localTPPlayerListenersEmptyImpl;
    this.mOnSubtitleDataListener = localTPPlayerListenersEmptyImpl;
    this.mOnVideoFrameOutListener = localTPPlayerListenersEmptyImpl;
    this.mOnAudioFrameOutListener = localTPPlayerListenersEmptyImpl;
    this.mOnSubtitleFrameOutListener = localTPPlayerListenersEmptyImpl;
    this.mOnStateChangeListener = localTPPlayerListenersEmptyImpl;
    this.mOnVideoProcessFrameOutListener = localTPPlayerListenersEmptyImpl;
    this.mOnAudioProcessFrameOutListener = localTPPlayerListenersEmptyImpl;
  }
  
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.mOnAudioFrameOutListener.onAudioPcmOut(paramTPAudioFrameBuffer);
  }
  
  public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    return this.mOnAudioProcessFrameOutListener.onAudioProcessFrameOut(paramTPPostProcessFrameBuffer);
  }
  
  public void onCompletion()
  {
    this.mOnCompletionListener.onCompletion();
  }
  
  public void onError(@TPCommonEnum.TPErrorType int paramInt1, int paramInt2, long paramLong1, long paramLong2)
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
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    this.mOnStateChangeListener.onStateChange(paramInt1, paramInt2);
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    this.mOnSubtitleDataListener.onSubtitleData(paramTPSubtitleData);
  }
  
  public void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    this.mOnSubtitleFrameOutListener.onSubtitleFrameOut(paramTPSubtitleFrameBuffer);
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mOnVideoFrameOutListener.onVideoFrameOut(paramTPVideoFrameBuffer);
  }
  
  public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    return this.mOnVideoProcessFrameOutListener.onVideoProcessFrameOut(paramTPPostProcessFrameBuffer);
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    this.mOnVideoSizeChangedListener.onVideoSizeChanged(paramLong1, paramLong2);
  }
  
  public void setOnAudioPcmOutListener(ITPPlayerBaseListener.IOnAudioPcmOutListener paramIOnAudioPcmOutListener)
  {
    Object localObject = paramIOnAudioPcmOutListener;
    if (paramIOnAudioPcmOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnAudioFrameOutListener = ((ITPPlayerBaseListener.IOnAudioPcmOutListener)localObject);
  }
  
  public void setOnAudioProcessFrameListener(ITPPlayerBaseListener.IOnAudioProcessOutListener paramIOnAudioProcessOutListener)
  {
    Object localObject = paramIOnAudioProcessOutListener;
    if (paramIOnAudioProcessOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnAudioProcessFrameOutListener = ((ITPPlayerBaseListener.IOnAudioProcessOutListener)localObject);
  }
  
  public void setOnCompletionListener(ITPPlayerBaseListener.IOnCompletionListener paramIOnCompletionListener)
  {
    Object localObject = paramIOnCompletionListener;
    if (paramIOnCompletionListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnCompletionListener = ((ITPPlayerBaseListener.IOnCompletionListener)localObject);
  }
  
  public void setOnErrorListener(ITPPlayerBaseListener.IOnErrorListener paramIOnErrorListener)
  {
    Object localObject = paramIOnErrorListener;
    if (paramIOnErrorListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnErrorListener = ((ITPPlayerBaseListener.IOnErrorListener)localObject);
  }
  
  public void setOnInfoListener(ITPPlayerBaseListener.IOnInfoListener paramIOnInfoListener)
  {
    Object localObject = paramIOnInfoListener;
    if (paramIOnInfoListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnInfoListener = ((ITPPlayerBaseListener.IOnInfoListener)localObject);
  }
  
  public void setOnPreparedListener(ITPPlayerBaseListener.IOnPreparedListener paramIOnPreparedListener)
  {
    Object localObject = paramIOnPreparedListener;
    if (paramIOnPreparedListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnPreparedListener = ((ITPPlayerBaseListener.IOnPreparedListener)localObject);
  }
  
  public void setOnSeekCompleteListener(ITPPlayerBaseListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    Object localObject = paramIOnSeekCompleteListener;
    if (paramIOnSeekCompleteListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSeekCompleteListener = ((ITPPlayerBaseListener.IOnSeekCompleteListener)localObject);
  }
  
  public void setOnStateChangeListener(ITPPlayerBaseListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    Object localObject = paramIOnStateChangeListener;
    if (paramIOnStateChangeListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnStateChangeListener = ((ITPPlayerBaseListener.IOnStateChangeListener)localObject);
  }
  
  public void setOnSubtitleDataListener(ITPPlayerBaseListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    Object localObject = paramIOnSubtitleDataListener;
    if (paramIOnSubtitleDataListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSubtitleDataListener = ((ITPPlayerBaseListener.IOnSubtitleDataListener)localObject);
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerBaseListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    Object localObject = paramIOnSubtitleFrameOutListener;
    if (paramIOnSubtitleFrameOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnSubtitleFrameOutListener = ((ITPPlayerBaseListener.IOnSubtitleFrameOutListener)localObject);
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerBaseListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    Object localObject = paramIOnVideoFrameOutListener;
    if (paramIOnVideoFrameOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoFrameOutListener = ((ITPPlayerBaseListener.IOnVideoFrameOutListener)localObject);
  }
  
  public void setOnVideoProcessFrameListener(ITPPlayerBaseListener.IOnVideoProcessOutListener paramIOnVideoProcessOutListener)
  {
    Object localObject = paramIOnVideoProcessOutListener;
    if (paramIOnVideoProcessOutListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoProcessFrameOutListener = ((ITPPlayerBaseListener.IOnVideoProcessOutListener)localObject);
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerBaseListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    Object localObject = paramIOnVideoSizeChangedListener;
    if (paramIOnVideoSizeChangedListener == null) {
      localObject = this.EMPTY_LISTENERS;
    }
    this.mOnVideoSizeChangedListener = ((ITPPlayerBaseListener.IOnVideoSizeChangedListener)localObject);
  }
  
  public void updateTag(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      this.mTag = "TPPlayerListenerS";
    } else {
      this.mTag = paramString;
    }
    paramString = this.EMPTY_LISTENERS;
    if (paramString != null) {
      TPPlayerBaseListeners.TPPlayerListenersEmptyImpl.access$002(paramString, this.mTag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerBaseListeners
 * JD-Core Version:    0.7.0.1
 */