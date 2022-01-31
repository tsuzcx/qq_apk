package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioPcmDataListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoOutputFrameListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import java.lang.ref.WeakReference;

class SPlayerManagerCallBack
  implements ISuperPlayer.OnAudioPcmDataListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoOutputFrameListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener
{
  private static final int ON_CAPTURE_IMAGE_FAILED = 7;
  private static final int ON_CAPTURE_IMAGE_SUCCEED = 6;
  private static final int ON_COMPLETION = 4;
  private static final int ON_ERROR = 2;
  private static final int ON_INFO = 3;
  private static final int ON_SEEK_COMPLETE = 5;
  private static final int ON_VIDEO_PREPARED = 1;
  private static final int ON_VIDEO_SIZE_CHANGED = 8;
  private SPlayerManagerCallBack.CallBackEventHandler mCallBackEventHandler;
  private WeakReference<SPlayerListenerManager> mFCCListenerManagerWeakReference;
  private WeakReference<ISuperPlayer> mPlayerMgrWeakReference;
  
  public SPlayerManagerCallBack(ISuperPlayer paramISuperPlayer, SPlayerListenerManager paramSPlayerListenerManager, Looper paramLooper)
  {
    this.mPlayerMgrWeakReference = new WeakReference(paramISuperPlayer);
    this.mFCCListenerManagerWeakReference = new WeakReference(paramSPlayerListenerManager);
    this.mCallBackEventHandler = new SPlayerManagerCallBack.CallBackEventHandler(this, paramISuperPlayer, paramSPlayerListenerManager, paramLooper);
  }
  
  private void handleOnAudioPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      localSPlayerListenerManager.onAudioPcmData(paramArrayOfByte, paramInt1, paramInt2, paramLong);
    }
  }
  
  private void handleOnCaptureImageFailed(int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      localSPlayerListenerManager.onCaptureImageFailed(localISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  private void handleOnCaptureImageSucceed(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      localSPlayerListenerManager.onCaptureImageSucceed(localISuperPlayer, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  private void handleOnCompletion()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      localSPlayerListenerManager.onCompletion(localISuperPlayer);
    }
  }
  
  private boolean handleOnError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      return localSPlayerListenerManager.onError(localISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  private boolean handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      return localSPlayerListenerManager.onInfo(localISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
    return false;
  }
  
  private void handleOnSeekComplete()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      localSPlayerListenerManager.onSeekComplete(localISuperPlayer);
    }
  }
  
  private void handleOnVideoOutputFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      localSPlayerListenerManager.onVideoOutputFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
    }
  }
  
  private void handleOnVideoPrepared()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      localSPlayerListenerManager.onVideoPrepared(localISuperPlayer);
    }
  }
  
  private void handleOnVideoSizeChanged(int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SPlayerListenerManager localSPlayerListenerManager = (SPlayerListenerManager)this.mFCCListenerManagerWeakReference.get();
    if ((localISuperPlayer != null) && (localSPlayerListenerManager != null)) {
      localSPlayerListenerManager.onVideoSizeChanged(localISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  public ISuperPlayer getPlayer()
  {
    if ((this.mPlayerMgrWeakReference != null) && (this.mPlayerMgrWeakReference.get() != null)) {
      return (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    }
    return null;
  }
  
  public void onAudioPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    handleOnAudioPcmData(paramArrayOfByte, paramInt1, paramInt2, paramLong);
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    Message.obtain(this.mCallBackEventHandler, 7, paramInt1, paramInt2).sendToTarget();
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    paramISuperPlayer = new SPlayerManagerCallBack.OnCaptureImageSucceeParams(null);
    paramISuperPlayer.id = paramInt1;
    paramISuperPlayer.width = paramInt2;
    paramISuperPlayer.height = paramInt3;
    paramISuperPlayer.bitmap = paramBitmap;
    Message.obtain(this.mCallBackEventHandler, 6, 0, 0, paramISuperPlayer).sendToTarget();
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    this.mCallBackEventHandler.sendEmptyMessage(4);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new SPlayerManagerCallBack.OnErrorParams(null);
    paramISuperPlayer.module = paramInt1;
    paramISuperPlayer.errorType = paramInt2;
    paramISuperPlayer.errorCode = paramInt3;
    paramISuperPlayer.extraInfo = paramString;
    Message.obtain(this.mCallBackEventHandler, 2, paramISuperPlayer).sendToTarget();
    return true;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramISuperPlayer = new SPlayerManagerCallBack.OnInfoParams(null);
    paramISuperPlayer.what = paramInt;
    paramISuperPlayer.arg1 = paramLong1;
    paramISuperPlayer.arg2 = paramLong2;
    paramISuperPlayer.extra = paramObject;
    Message.obtain(this.mCallBackEventHandler, 3, paramISuperPlayer).sendToTarget();
    return true;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    this.mCallBackEventHandler.sendEmptyMessage(5);
  }
  
  public void onVideoOutputFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    handleOnVideoOutputFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    this.mCallBackEventHandler.sendEmptyMessage(1);
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    Message.obtain(this.mCallBackEventHandler, 8, paramInt1, paramInt2).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SPlayerManagerCallBack
 * JD-Core Version:    0.7.0.1
 */