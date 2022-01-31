package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.TVideoNetInfo;
import java.util.ArrayList;

class SuperPlayerMgr$MgrListenerAdapter
  implements SuperPlayerListenerMgr.Combine
{
  private SuperPlayerMgrCallBack mMgrCallBack;
  
  public SuperPlayerMgr$MgrListenerAdapter(SuperPlayerMgrCallBack paramSuperPlayerMgrCallBack)
  {
    this.mMgrCallBack = paramSuperPlayerMgrCallBack;
  }
  
  public void onAudioPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong) {}
  
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
    this.mMgrCallBack.onCompletion(paramISuperPlayer);
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList)
  {
    this.mMgrCallBack.onDefinitionInfoUpdate(paramISuperPlayer, paramString, paramArrayList);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return this.mMgrCallBack.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return this.mMgrCallBack.onInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    this.mMgrCallBack.onSeekComplete(paramISuperPlayer);
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    this.mMgrCallBack.onTVideoNetInfoUpdate(paramISuperPlayer, paramTVideoNetInfo);
  }
  
  public void onVideoOutputFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if ((this.mMgrCallBack.getPlayer() instanceof SuperPlayerMgr)) {
      ((SuperPlayerMgr)this.mMgrCallBack.getPlayer()).handleOnVideoPrepared();
    }
    this.mMgrCallBack.onVideoPrepared(paramISuperPlayer);
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    this.mMgrCallBack.onVideoSizeChanged(paramISuperPlayer, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgr.MgrListenerAdapter
 * JD-Core Version:    0.7.0.1
 */