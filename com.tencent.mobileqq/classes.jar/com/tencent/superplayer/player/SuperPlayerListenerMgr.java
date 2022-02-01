package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSubtitleDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import java.util.ArrayList;

class SuperPlayerListenerMgr
  implements ListenerCombine.ISuperPlayerCombine
{
  private static final String FILENAME = "SuperPlayerListenerMgr.java";
  private ISuperPlayer.OnAudioFrameOutputListener mOnAudioFrameOutputListener = null;
  private ISuperPlayer.OnCaptureImageListener mOnCaptureImageListener = null;
  private ISuperPlayer.OnCompletionListener mOnCompletionListener = null;
  private ISuperPlayer.OnDefinitionInfoListener mOnDefinitionInfoListener = null;
  private ISuperPlayer.OnErrorListener mOnErrorListener = null;
  private ISuperPlayer.OnInfoListener mOnInfoListener = null;
  private ISuperPlayer.OnSeekCompleteListener mOnSeekCompleteListener = null;
  private ISuperPlayer.OnSubtitleDataListener mOnSubtitleDataListener = null;
  private ISuperPlayer.OnTVideoNetInfoListener mOnTVideoNetInfoListener = null;
  private ISuperPlayer.OnVideoFrameOutputListener mOnVideoFrameOutputListener = null;
  private ISuperPlayer.OnVideoPreparedListener mOnVideoPreparedListener = null;
  private ISuperPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = null;
  private String mTag;
  
  SuperPlayerListenerMgr(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    localStringBuilder.append("SuperPlayerListenerMgr.java");
    this.mTag = localStringBuilder.toString();
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    ISuperPlayer.OnAudioFrameOutputListener localOnAudioFrameOutputListener = this.mOnAudioFrameOutputListener;
    if (localOnAudioFrameOutputListener != null) {
      localOnAudioFrameOutputListener.onAudioFrameOutput(paramTPAudioFrameBuffer);
    }
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    ISuperPlayer.OnCaptureImageListener localOnCaptureImageListener = this.mOnCaptureImageListener;
    if (localOnCaptureImageListener != null) {
      localOnCaptureImageListener.onCaptureImageFailed(paramISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    ISuperPlayer.OnCaptureImageListener localOnCaptureImageListener = this.mOnCaptureImageListener;
    if (localOnCaptureImageListener != null) {
      localOnCaptureImageListener.onCaptureImageSucceed(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    ISuperPlayer.OnCompletionListener localOnCompletionListener = this.mOnCompletionListener;
    if (localOnCompletionListener != null)
    {
      LogUtil.i(this.mTag, "notify : video completion");
      localOnCompletionListener.onCompletion(paramISuperPlayer);
    }
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList)
  {
    ISuperPlayer.OnDefinitionInfoListener localOnDefinitionInfoListener = this.mOnDefinitionInfoListener;
    if (localOnDefinitionInfoListener != null)
    {
      String str = this.mTag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notify : onDefinitionInfoUpdate currentDefinition:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", definitionList.size():");
      localStringBuilder.append(paramArrayList.size());
      LogUtil.i(str, localStringBuilder.toString());
      localOnDefinitionInfoListener.onDefinitionInfoUpdate(paramISuperPlayer, paramString, paramArrayList);
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ISuperPlayer.OnErrorListener localOnErrorListener = this.mOnErrorListener;
    if (localOnErrorListener != null)
    {
      String str = this.mTag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notify : on error, module:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", errorType:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", errorCode:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", extraInfo:");
      localStringBuilder.append(paramString);
      LogUtil.e(str, localStringBuilder.toString());
      return localOnErrorListener.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ISuperPlayer.OnInfoListener localOnInfoListener = this.mOnInfoListener;
    if (localOnInfoListener != null)
    {
      String str = this.mTag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notify : on info  , cmd : ");
      localStringBuilder.append(paramInt);
      LogUtil.i(str, localStringBuilder.toString());
      return localOnInfoListener.onInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    ISuperPlayer.OnSeekCompleteListener localOnSeekCompleteListener = this.mOnSeekCompleteListener;
    if (localOnSeekCompleteListener != null)
    {
      LogUtil.i(this.mTag, "notify : video onSeekComplete");
      localOnSeekCompleteListener.onSeekComplete(paramISuperPlayer);
    }
  }
  
  public void onSubtitleData(ISuperPlayer paramISuperPlayer, TPSubtitleData paramTPSubtitleData)
  {
    ISuperPlayer.OnSubtitleDataListener localOnSubtitleDataListener = this.mOnSubtitleDataListener;
    if (localOnSubtitleDataListener != null) {
      localOnSubtitleDataListener.onSubtitleData(paramISuperPlayer, paramTPSubtitleData);
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    ISuperPlayer.OnTVideoNetInfoListener localOnTVideoNetInfoListener = this.mOnTVideoNetInfoListener;
    if (localOnTVideoNetInfoListener != null)
    {
      LogUtil.i(this.mTag, "notify : onTVideoNetInfoUpdate");
      localOnTVideoNetInfoListener.onTVideoNetInfoUpdate(paramISuperPlayer, paramTVideoNetInfo);
    }
  }
  
  public void onVideoFrameOutput(TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    ISuperPlayer.OnVideoFrameOutputListener localOnVideoFrameOutputListener = this.mOnVideoFrameOutputListener;
    if (localOnVideoFrameOutputListener != null) {
      localOnVideoFrameOutputListener.onVideoFrameOutput(paramTPVideoFrameBuffer);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    ISuperPlayer.OnVideoPreparedListener localOnVideoPreparedListener = this.mOnVideoPreparedListener;
    if (localOnVideoPreparedListener != null)
    {
      LogUtil.i(this.mTag, "notify : video prepared");
      localOnVideoPreparedListener.onVideoPrepared(paramISuperPlayer);
    }
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    ISuperPlayer.OnVideoSizeChangedListener localOnVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
    if (localOnVideoSizeChangedListener != null)
    {
      String str = this.mTag;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoSizeChanged : width：");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", height:");
      localStringBuilder.append(paramInt2);
      LogUtil.i(str, localStringBuilder.toString());
      localOnVideoSizeChangedListener.onVideoSizeChanged(paramISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  void release()
  {
    this.mOnAudioFrameOutputListener = null;
    this.mOnCaptureImageListener = null;
    this.mOnCompletionListener = null;
    this.mOnDefinitionInfoListener = null;
    this.mOnErrorListener = null;
    this.mOnInfoListener = null;
    this.mOnSeekCompleteListener = null;
    this.mOnVideoFrameOutputListener = null;
    this.mOnVideoPreparedListener = null;
    this.mOnVideoSizeChangedListener = null;
    this.mOnTVideoNetInfoListener = null;
    this.mOnSubtitleDataListener = null;
  }
  
  void setOnAudioFrameOutputListener(ISuperPlayer.OnAudioFrameOutputListener paramOnAudioFrameOutputListener)
  {
    this.mOnAudioFrameOutputListener = paramOnAudioFrameOutputListener;
  }
  
  void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mOnCaptureImageListener = paramOnCaptureImageListener;
  }
  
  void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mOnDefinitionInfoListener = paramOnDefinitionInfoListener;
  }
  
  void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mOnInfoListener = paramOnInfoListener;
  }
  
  void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  void setOnSubtitleDataListener(ISuperPlayer.OnSubtitleDataListener paramOnSubtitleDataListener)
  {
    this.mOnSubtitleDataListener = paramOnSubtitleDataListener;
  }
  
  void setOnTVideoNetVideoInfoListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    this.mOnTVideoNetInfoListener = paramOnTVideoNetInfoListener;
  }
  
  void setOnVideoOutputFrameListener(ISuperPlayer.OnVideoFrameOutputListener paramOnVideoFrameOutputListener)
  {
    this.mOnVideoFrameOutputListener = paramOnVideoFrameOutputListener;
  }
  
  void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    this.mOnVideoPreparedListener = paramOnVideoPreparedListener;
  }
  
  void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
  
  public void updatePlayerTag(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    localStringBuilder.append("SuperPlayerListenerMgr.java");
    this.mTag = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerListenerMgr
 * JD-Core Version:    0.7.0.1
 */