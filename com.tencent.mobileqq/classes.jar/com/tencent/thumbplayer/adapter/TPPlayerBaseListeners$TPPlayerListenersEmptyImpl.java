package com.tencent.thumbplayer.adapter;

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
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPPlayerBaseListeners$TPPlayerListenersEmptyImpl
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnStateChangeListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnSubtitleFrameOutListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
{
  private String mTag;
  
  public TPPlayerBaseListeners$TPPlayerListenersEmptyImpl(String paramString)
  {
    this.mTag = paramString;
  }
  
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onAudioFrameOut");
  }
  
  public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onAudioProcessFrameOut");
    return null;
  }
  
  public void onCompletion()
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onCompletion");
  }
  
  public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onError");
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onInfo");
  }
  
  public void onPrepared()
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onPrepared");
  }
  
  public void onSeekComplete()
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onSeekComplete");
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onStateChange");
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onSubtitleData");
  }
  
  public void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , TPSubtitleFrameBuffer");
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onVideoFrameOut");
  }
  
  public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onVideoProcessFrameOut");
    return null;
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    TPLogUtil.i(this.mTag, " empty base listener , notify , onVideoSizeChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerBaseListeners.TPPlayerListenersEmptyImpl
 * JD-Core Version:    0.7.0.1
 */