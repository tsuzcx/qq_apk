package com.tencent.mobileqq.triton.sdk;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerBuilder;
import com.tencent.mobileqq.triton.sdk.bridge.IInspectorAgent;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import java.util.Map;
import java.util.concurrent.Executor;

public abstract interface ITTEngine
{
  public abstract void addFPSCallback(FPSCallback paramFPSCallback);
  
  public abstract void addGameLifeCycle(GameLifecycle paramGameLifecycle);
  
  public abstract View createGameView(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract APIProxy getApiProxy();
  
  public abstract long getCurrentDrawCount();
  
  public abstract int getDisplayRefreshRate();
  
  public abstract IGameLauncher getGameLauncher();
  
  public abstract IJSEngine getJsEngine();
  
  public abstract ITTJSRuntime getJsRuntime(int paramInt);
  
  public abstract long getLastBlackTime();
  
  public abstract ITNativeBufferPool getNativeBufferPool();
  
  public abstract ITHttp getNativeHttp();
  
  public abstract Map<String, String> getResPathCache();
  
  public abstract void getScreenShot(ScreenShotCallback paramScreenShotCallback);
  
  public abstract int getTargetFPS();
  
  public abstract void handleFocusGain();
  
  public abstract void handleFocusLoss();
  
  public abstract int initEngine(Context paramContext, ITTEngine.IListener paramIListener, @Nullable IInspectorAgent paramIInspectorAgent);
  
  public abstract void onCreate(Activity paramActivity);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void removeFPSCallback(FPSCallback paramFPSCallback);
  
  public abstract void setApiProxy(APIProxy paramAPIProxy);
  
  public abstract void setAudioPlayerBuilder(IAudioPlayerBuilder paramIAudioPlayerBuilder);
  
  public abstract void setDiskIoExecutor(@NonNull Executor paramExecutor);
  
  public abstract void setEnableCodeCache(boolean paramBoolean);
  
  public abstract void setEngineListener(ITTEngine.IListener paramIListener);
  
  public abstract void setJsEngine(IJSEngine paramIJSEngine);
  
  public abstract void setLog(ITLog paramITLog);
  
  public abstract void setQQEnv(IQQEnv paramIQQEnv);
  
  public abstract void setSoLoader(ITSoLoader paramITSoLoader);
  
  public abstract void setTargetFPS(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.ITTEngine
 * JD-Core Version:    0.7.0.1
 */