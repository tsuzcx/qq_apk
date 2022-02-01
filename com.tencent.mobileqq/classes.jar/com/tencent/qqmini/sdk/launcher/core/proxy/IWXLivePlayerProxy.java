package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.content.Context;
import android.view.Surface;
import java.lang.reflect.InvocationHandler;

public abstract interface IWXLivePlayerProxy
{
  public abstract void hookListenerAndGoOn(String paramString, InvocationHandler paramInvocationHandler);
  
  public abstract void init(Context paramContext, InvocationHandler paramInvocationHandler1, InvocationHandler paramInvocationHandler2);
  
  public abstract void initLivePlayer(Object paramObject);
  
  public abstract boolean needLoadAvJar();
  
  public abstract void txCloudVideoView_disableLog(Boolean paramBoolean);
  
  public abstract void txCloudVideoView_showLog(Boolean paramBoolean);
  
  public abstract void txLivePlayConfig_setAutoAdjustCacheTime(Boolean paramBoolean);
  
  public abstract void txLivePlayConfig_setCacheTime(float paramFloat);
  
  public abstract void txLivePlayConfig_setEnableMetaData(Boolean paramBoolean);
  
  public abstract void txLivePlayConfig_setMaxAutoAdjustCacheTime(float paramFloat);
  
  public abstract void txLivePlayConfig_setMinAutoAdjustCacheTime(float paramFloat);
  
  public abstract void txLivePlay_snapshot(InvocationHandler paramInvocationHandler);
  
  public abstract void txLivePlayer_enableAudioVolumeEvaluation(int paramInt);
  
  public abstract void txLivePlayer_enableHardwareDecode(Boolean paramBoolean);
  
  public abstract boolean txLivePlayer_isPlaying();
  
  public abstract void txLivePlayer_muteAudio(Boolean paramBoolean);
  
  public abstract void txLivePlayer_muteVideo(Boolean paramBoolean);
  
  public abstract void txLivePlayer_pause();
  
  public abstract void txLivePlayer_resume();
  
  public abstract void txLivePlayer_setAudioRoute(int paramInt);
  
  public abstract void txLivePlayer_setAudioVolumeEvaluationListener(Object paramObject);
  
  public abstract void txLivePlayer_setConfig();
  
  public abstract void txLivePlayer_setPlayListener(Object paramObject);
  
  public abstract void txLivePlayer_setPlayerView(Object paramObject);
  
  public abstract void txLivePlayer_setRenderMode(int paramInt);
  
  public abstract void txLivePlayer_setRenderRotation(int paramInt);
  
  public abstract void txLivePlayer_setSurface(Surface paramSurface);
  
  public abstract void txLivePlayer_setSurfaceSize(int paramInt1, int paramInt2);
  
  public abstract void txLivePlayer_showDebugLog(Boolean paramBoolean);
  
  public abstract int txLivePlayer_startPlay(String paramString, int paramInt);
  
  public abstract int txLivePlayer_stopPlay(Boolean paramBoolean);
  
  public abstract void txPlayConfig_setEnableMessage(Boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy
 * JD-Core Version:    0.7.0.1
 */