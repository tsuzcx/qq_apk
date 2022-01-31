package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioPcmDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoOutputFrameListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.utils.LogUtil;
import java.util.ArrayList;

class SuperPlayerListenerMgr
  implements ISuperPlayer.OnAudioPcmDataListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoOutputFrameListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener
{
  private static final String FILENAME = "SuperPlayerListenerMgr.java";
  private String TAG;
  private ISuperPlayer.OnAudioPcmDataListener mOnAudioPcmDataListener = null;
  private ISuperPlayer.OnCaptureImageListener mOnCaptureImageListener = null;
  private ISuperPlayer.OnCompletionListener mOnCompletionListener = null;
  private ISuperPlayer.OnDefinitionInfoListener mOnDefinitionInfoListener = null;
  private ISuperPlayer.OnErrorListener mOnErrorListener = null;
  private ISuperPlayer.OnInfoListener mOnInfoListener = null;
  private ISuperPlayer.OnSeekCompleteListener mOnSeekCompleteListener = null;
  private ISuperPlayer.OnTVideoNetInfoListener mOnTVideoNetInfoListener = null;
  private ISuperPlayer.OnVideoOutputFrameListener mOnVideoOutputFrameListener = null;
  private ISuperPlayer.OnVideoPreparedListener mOnVideoPreparedListener = null;
  private ISuperPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = null;
  
  public SuperPlayerListenerMgr(String paramString)
  {
    this.TAG = (paramString + "_" + "SuperPlayerListenerMgr.java");
  }
  
  public void onAudioPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if (this.mOnAudioPcmDataListener != null) {
      this.mOnAudioPcmDataListener.onAudioPcmData(paramArrayOfByte, paramInt1, paramInt2, paramLong);
    }
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    if (this.mOnCaptureImageListener != null) {
      this.mOnCaptureImageListener.onCaptureImageFailed(paramISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (this.mOnCaptureImageListener != null) {
      this.mOnCaptureImageListener.onCaptureImageSucceed(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (this.mOnCompletionListener != null)
    {
      LogUtil.i(this.TAG, "notify : video completion");
      this.mOnCompletionListener.onCompletion(paramISuperPlayer);
    }
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList)
  {
    if (this.mOnDefinitionInfoListener != null)
    {
      LogUtil.i(this.TAG, "notify : onDefinitionInfoUpdate");
      this.mOnDefinitionInfoListener.onDefinitionInfoUpdate(paramISuperPlayer, paramString, paramArrayList);
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.mOnErrorListener != null) {
      return this.mOnErrorListener.onError(paramISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (this.mOnInfoListener != null)
    {
      LogUtil.i(this.TAG, "notify : on info  , cmd : " + paramInt);
      return this.mOnInfoListener.onInfo(paramISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    if (this.mOnSeekCompleteListener != null)
    {
      LogUtil.i(this.TAG, "notify : video onSeekComplete");
      this.mOnSeekCompleteListener.onSeekComplete(paramISuperPlayer);
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    if (this.mOnTVideoNetInfoListener != null)
    {
      LogUtil.i(this.TAG, "notify : onTVideoNetInfoUpdate");
      this.mOnTVideoNetInfoListener.onTVideoNetInfoUpdate(paramISuperPlayer, paramTVideoNetInfo);
    }
  }
  
  public void onVideoOutputFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    if (this.mOnVideoOutputFrameListener != null) {
      this.mOnVideoOutputFrameListener.onVideoOutputFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (this.mOnVideoPreparedListener != null)
    {
      LogUtil.i(this.TAG, "notify : video prepared");
      this.mOnVideoPreparedListener.onVideoPrepared(paramISuperPlayer);
    }
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    if (this.mOnVideoSizeChangedListener != null)
    {
      LogUtil.i(this.TAG, "onVideoSizeChanged : width：" + paramInt1 + ", height:" + paramInt2);
      this.mOnVideoSizeChangedListener.onVideoSizeChanged(paramISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  public void release()
  {
    this.mOnAudioPcmDataListener = null;
    this.mOnCaptureImageListener = null;
    this.mOnCompletionListener = null;
    this.mOnDefinitionInfoListener = null;
    this.mOnTVideoNetInfoListener = null;
    this.mOnErrorListener = null;
    this.mOnInfoListener = null;
    this.mOnSeekCompleteListener = null;
    this.mOnVideoOutputFrameListener = null;
    this.mOnVideoPreparedListener = null;
    this.mOnVideoSizeChangedListener = null;
  }
  
  public void setOnAudioPcmDataListener(ISuperPlayer.OnAudioPcmDataListener paramOnAudioPcmDataListener)
  {
    this.mOnAudioPcmDataListener = paramOnAudioPcmDataListener;
  }
  
  public void setOnCaptureImageListener(ISuperPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.mOnCaptureImageListener = paramOnCaptureImageListener;
  }
  
  public void setOnCompletionListener(ISuperPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnDefinitionInfoListener(ISuperPlayer.OnDefinitionInfoListener paramOnDefinitionInfoListener)
  {
    this.mOnDefinitionInfoListener = paramOnDefinitionInfoListener;
  }
  
  public void setOnErrorListener(ISuperPlayer.OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(ISuperPlayer.OnInfoListener paramOnInfoListener)
  {
    this.mOnInfoListener = paramOnInfoListener;
  }
  
  public void setOnSeekCompleteListener(ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setOnTVideoNetVideoInfoListener(ISuperPlayer.OnTVideoNetInfoListener paramOnTVideoNetInfoListener)
  {
    this.mOnTVideoNetInfoListener = paramOnTVideoNetInfoListener;
  }
  
  public void setOnVideoOutputFrameListener(ISuperPlayer.OnVideoOutputFrameListener paramOnVideoOutputFrameListener)
  {
    this.mOnVideoOutputFrameListener = paramOnVideoOutputFrameListener;
  }
  
  public void setOnVideoPreparedListener(ISuperPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    this.mOnVideoPreparedListener = paramOnVideoPreparedListener;
  }
  
  public void setOnVideoSizeChangedListener(ISuperPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerListenerMgr
 * JD-Core Version:    0.7.0.1
 */