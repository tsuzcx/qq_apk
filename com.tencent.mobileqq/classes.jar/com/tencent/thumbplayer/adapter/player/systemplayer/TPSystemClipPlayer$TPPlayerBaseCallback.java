package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioPcmOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnAudioProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnCompletionListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnErrorListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnInfoListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnPreparedListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoProcessOutListener;
import com.tencent.thumbplayer.adapter.player.ITPPlayerBaseListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class TPSystemClipPlayer$TPPlayerBaseCallback
  implements ITPPlayerBaseListener.IOnAudioPcmOutListener, ITPPlayerBaseListener.IOnAudioProcessOutListener, ITPPlayerBaseListener.IOnCompletionListener, ITPPlayerBaseListener.IOnErrorListener, ITPPlayerBaseListener.IOnInfoListener, ITPPlayerBaseListener.IOnPreparedListener, ITPPlayerBaseListener.IOnSeekCompleteListener, ITPPlayerBaseListener.IOnSubtitleDataListener, ITPPlayerBaseListener.IOnVideoFrameOutListener, ITPPlayerBaseListener.IOnVideoProcessOutListener, ITPPlayerBaseListener.IOnVideoSizeChangedListener
{
  private TPSystemClipPlayer$TPPlayerBaseCallback(TPSystemClipPlayer paramTPSystemClipPlayer) {}
  
  public void onAudioPcmOut(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    TPSystemClipPlayer.access$900(this.this$0, paramTPAudioFrameBuffer);
  }
  
  public TPPostProcessFrameBuffer onAudioProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    return TPSystemClipPlayer.access$1100(this.this$0, paramTPPostProcessFrameBuffer);
  }
  
  public void onCompletion()
  {
    TPSystemClipPlayer.access$200(this.this$0);
  }
  
  public void onError(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    TPSystemClipPlayer.access$400(this.this$0, paramInt1, paramInt2, paramLong1, paramLong2);
  }
  
  public void onInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    TPSystemClipPlayer.access$300(this.this$0, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onPrepared()
  {
    TPSystemClipPlayer.access$100(this.this$0);
  }
  
  public void onSeekComplete()
  {
    TPSystemClipPlayer.access$500(this.this$0);
  }
  
  public void onSubtitleData(TPSubtitleData paramTPSubtitleData)
  {
    TPSystemClipPlayer.access$700(this.this$0, paramTPSubtitleData);
  }
  
  public void onVideoFrameOut(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    TPSystemClipPlayer.access$800(this.this$0, paramTPVideoFrameBuffer);
  }
  
  public TPPostProcessFrameBuffer onVideoProcessFrameOut(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    return TPSystemClipPlayer.access$1000(this.this$0, paramTPPostProcessFrameBuffer);
  }
  
  public void onVideoSizeChanged(long paramLong1, long paramLong2)
  {
    TPSystemClipPlayer.access$600(this.this$0, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSystemClipPlayer.TPPlayerBaseCallback
 * JD-Core Version:    0.7.0.1
 */