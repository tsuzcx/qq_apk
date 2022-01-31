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
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPPlayerListeners$TPPlayerListenersEmptyImpl
  implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoSizeChangedListener
{
  public void onAudioFrameOut(ITPPlayer paramITPPlayer, TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onAudioFrameOut");
  }
  
  public void onCompletion(ITPPlayer paramITPPlayer)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onCompletion");
  }
  
  public void onError(ITPPlayer paramITPPlayer, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onError");
  }
  
  public void onInfo(ITPPlayer paramITPPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onInfo");
  }
  
  public void onPrepared(ITPPlayer paramITPPlayer)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onPrepared");
  }
  
  public void onSeekComplete(ITPPlayer paramITPPlayer)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onSeekComplete");
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onStateChange");
  }
  
  public void onSubtitleData(ITPPlayer paramITPPlayer, TPSubtitleData paramTPSubtitleData)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onSubtitleData");
  }
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onVideoFrameOut");
  }
  
  public void onVideoSizeChanged(ITPPlayer paramITPPlayer, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(TPPlayerListeners.access$100(), " empty player listener , notify , onVideoSizeChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPPlayerListeners.TPPlayerListenersEmptyImpl
 * JD-Core Version:    0.7.0.1
 */