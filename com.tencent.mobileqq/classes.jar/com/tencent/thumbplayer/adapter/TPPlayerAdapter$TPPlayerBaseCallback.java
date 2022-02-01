package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class TPPlayerAdapter$TPPlayerBaseCallback
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnSubtitleFrameOutListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
{
  private TPPlayerAdapter$TPPlayerBaseCallback(TPPlayerAdapter paramTPPlayerAdapter) {}
  
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    TPPlayerAdapter.access$1000(this.this$0, paramTPAudioFrameBuffer);
  }
  
  public void onCompletion()
  {
    TPPlayerAdapter.access$200(this.this$0);
  }
  
  public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    TPPlayerAdapter.access$400(this.this$0, paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    TPPlayerAdapter.access$300(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared()
  {
    TPPlayerAdapter.access$100(this.this$0);
  }
  
  public void onSeekComplete()
  {
    TPPlayerAdapter.access$500(this.this$0);
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    TPPlayerAdapter.access$700(this.this$0, paramTPSubtitleData);
  }
  
  public void onSubtitleFrameOut(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
  {
    TPPlayerAdapter.access$800(this.this$0, paramTPSubtitleFrameBuffer);
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    TPPlayerAdapter.access$900(this.this$0, paramTPVideoFrameBuffer);
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    TPPlayerAdapter.access$600(this.this$0, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerAdapter.TPPlayerBaseCallback
 * JD-Core Version:    0.7.0.1
 */