package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class SuperPlayerMgrCallBack
  implements ISuperPlayer.OnAudioPcmDataListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoOutputFrameListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener
{
  private static final int ON_CAPTURE_IMAGE_FAILED = 7;
  private static final int ON_CAPTURE_IMAGE_SUCCEED = 6;
  private static final int ON_COMPLETION = 4;
  private static final int ON_ERROR = 2;
  private static final int ON_INFO = 3;
  private static final int ON_SEEK_COMPLETE = 5;
  private static final int ON_VIDEO_PREPARED = 1;
  private static final int ON_VIDEO_SIZE_CHANGED = 8;
  private SuperPlayerMgrCallBack.CallBackEventHandler mCallBackEventHandler;
  private WeakReference<SuperPlayerListenerMgr> mListenerMgrWeakReference;
  private WeakReference<ISuperPlayer> mPlayerMgrWeakReference;
  
  public SuperPlayerMgrCallBack(ISuperPlayer paramISuperPlayer, SuperPlayerListenerMgr paramSuperPlayerListenerMgr, Looper paramLooper)
  {
    this.mPlayerMgrWeakReference = new WeakReference(paramISuperPlayer);
    this.mListenerMgrWeakReference = new WeakReference(paramSuperPlayerListenerMgr);
    this.mCallBackEventHandler = new SuperPlayerMgrCallBack.CallBackEventHandler(this, paramISuperPlayer, paramSuperPlayerListenerMgr, paramLooper);
  }
  
  private void handleOnAudioPcmData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onAudioPcmData(paramArrayOfByte, paramInt1, paramInt2, paramLong);
    }
  }
  
  private void handleOnCaptureImageFailed(int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onCaptureImageFailed(localISuperPlayer, paramInt1, paramInt2);
    }
  }
  
  private void handleOnCaptureImageSucceed(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onCaptureImageSucceed(localISuperPlayer, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  private void handleOnCompletion()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onCompletion(localISuperPlayer);
    }
  }
  
  private void handleOnDefinitionUpdate(String paramString, ArrayList<String> paramArrayList)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((paramArrayList != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onDefinitionInfoUpdate(localISuperPlayer, paramString, paramArrayList);
    }
  }
  
  private boolean handleOnError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      return localSuperPlayerListenerMgr.onError(localISuperPlayer, paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  private boolean handleOnInfo(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      return localSuperPlayerListenerMgr.onInfo(localISuperPlayer, paramInt, paramLong1, paramLong2, paramObject);
    }
    return false;
  }
  
  private void handleOnSeekComplete()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onSeekComplete(localISuperPlayer);
    }
  }
  
  private void handleOnTVideoNetInfoUpdate(TVideoNetInfo paramTVideoNetInfo)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((paramTVideoNetInfo != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onTVideoNetInfoUpdate(localISuperPlayer, paramTVideoNetInfo);
    }
  }
  
  private void handleOnVideoOutputFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onVideoOutputFrame(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
    }
  }
  
  private void handleOnVideoPrepared()
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onVideoPrepared(localISuperPlayer);
    }
  }
  
  private void handleOnVideoSizeChanged(int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = (ISuperPlayer)this.mPlayerMgrWeakReference.get();
    SuperPlayerListenerMgr localSuperPlayerListenerMgr = (SuperPlayerListenerMgr)this.mListenerMgrWeakReference.get();
    if ((localISuperPlayer != null) && (localSuperPlayerListenerMgr != null)) {
      localSuperPlayerListenerMgr.onVideoSizeChanged(localISuperPlayer, paramInt1, paramInt2);
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
    paramISuperPlayer = new SuperPlayerMgrCallBack.OnCaptureImageSucceeParams(null);
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
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList)
  {
    handleOnDefinitionUpdate(paramString, paramArrayList);
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = new SuperPlayerMgrCallBack.OnErrorParams(null);
    paramISuperPlayer.module = paramInt1;
    paramISuperPlayer.errorType = paramInt2;
    paramISuperPlayer.errorCode = paramInt3;
    paramISuperPlayer.extraInfo = paramString;
    Message.obtain(this.mCallBackEventHandler, 2, paramISuperPlayer).sendToTarget();
    return true;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    paramISuperPlayer = new SuperPlayerMgrCallBack.OnInfoParams(null);
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
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo)
  {
    handleOnTVideoNetInfoUpdate(paramTVideoNetInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgrCallBack
 * JD-Core Version:    0.7.0.1
 */