package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import java.util.ArrayList;

class SuperPlayerMgr$WrapperListenerAdapter
  implements ListenerCombine.ISuperPlayerCombine
{
  private SuperPlayerListenerCallBack mMgrCallBack;
  
  public SuperPlayerMgr$WrapperListenerAdapter(SuperPlayerListenerCallBack paramSuperPlayerListenerCallBack)
  {
    this.mMgrCallBack = paramSuperPlayerListenerCallBack;
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    this.mMgrCallBack.onAudioFrameOutput(paramTPAudioFrameBuffer);
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    this.mMgrCallBack.onCaptureImageFailed(paramISuperPlayer, paramInt1, paramInt2);
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.mMgrCallBack.onCaptureImageSucceed(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramBitmap);
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
      SuperPlayerMgr.access$300((SuperPlayerMgr)this.mMgrCallBack.getPlayer());
    }
    this.mMgrCallBack.onCompletion(paramISuperPlayer);
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList)
  {
    this.mMgrCallBack.onDefinitionInfoUpdate(paramISuperPlayer, paramString, paramArrayList);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
      SuperPlayerMgr.access$500((SuperPlayerMgr)this.mMgrCallBack.getPlayer(), paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    }
    return this.mMgrCallBack.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
      SuperPlayerMgr.access$400((SuperPlayerMgr)this.mMgrCallBack.getPlayer(), paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
    return this.mMgrCallBack.onInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
      SuperPlayerMgr.access$600((SuperPlayerMgr)this.mMgrCallBack.getPlayer());
    }
    this.mMgrCallBack.onSeekComplete(paramISuperPlayer);
  }
  
  public void onSubtitleData(ISuperPlayer paramISuperPlayer, TPSubtitleData paramTPSubtitleData)
  {
    this.mMgrCallBack.onSubtitleData(paramISuperPlayer, paramTPSubtitleData);
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    this.mMgrCallBack.onTVideoNetInfoUpdate(paramISuperPlayer, paramTVideoNetInfo);
  }
  
  public void onVideoFrameOutput(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    this.mMgrCallBack.onVideoFrameOutput(paramTPVideoFrameBuffer);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
      SuperPlayerMgr.access$200((SuperPlayerMgr)this.mMgrCallBack.getPlayer());
    }
    this.mMgrCallBack.onVideoPrepared(paramISuperPlayer);
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    this.mMgrCallBack.onVideoSizeChanged(paramISuperPlayer, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgr.WrapperListenerAdapter
 * JD-Core Version:    0.7.0.1
 */