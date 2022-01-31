package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnStateChangeListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPPlayerBaseListeners$TPPlayerListenersEmptyImpl
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnStateChangeListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
{
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onAudioFrameOut");
  }
  
  public void onCompletion()
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onCompletion");
  }
  
  public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onError");
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onInfo");
  }
  
  public void onPrepared()
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onPrepared");
  }
  
  public void onSeekComplete()
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onSeekComplete");
  }
  
  public void onStateChange(int paramInt1, int paramInt2)
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onStateChange");
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onSubtitleData");
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onVideoFrameOut");
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    TPLogUtil.i(TPPlayerBaseListeners.access$100(), " empty base listener , notify , onVideoSizeChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerBaseListeners.TPPlayerListenersEmptyImpl
 * JD-Core Version:    0.7.0.1
 */