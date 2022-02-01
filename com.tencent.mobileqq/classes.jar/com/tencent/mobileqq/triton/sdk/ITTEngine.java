package com.tencent.mobileqq.triton.sdk;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import com.tencent.mobileqq.triton.sdk.debug.JankTraceLevel;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import java.util.Map;

public abstract interface ITTEngine
{
  public abstract void addFPSCallback(FPSCallback paramFPSCallback);
  
  public abstract void addGameLifeCycle(GameLifecycle paramGameLifecycle);
  
  public abstract View createGameView(Activity paramActivity, int paramInt1, int paramInt2);
  
  public abstract IAudioNativeManager getAudioNativeManager();
  
  public abstract long getCurrentDrawCount();
  
  public abstract IGameLauncher getGameLauncher();
  
  public abstract IJSEngine getJsEngine();
  
  public abstract ITTJSRuntime getJsRuntime(int paramInt);
  
  public abstract long getLastBlackTime();
  
  public abstract String getLastClicks();
  
  public abstract ITNativeBufferPool getNativeBufferPool();
  
  public abstract boolean getOptionalSoLoadStatus(String paramString);
  
  public abstract Map<String, String> getResPathCache();
  
  public abstract void getScreenShot(ScreenShotCallback paramScreenShotCallback);
  
  public abstract int getTargetFPS();
  
  public abstract void getTraceRecord(@NonNull ITTEngine.OnGetTraceRecordCallback paramOnGetTraceRecordCallback);
  
  public abstract void handleFocusGain();
  
  public abstract void handleFocusLoss();
  
  public abstract void onCreate(Activity paramActivity);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void removeFPSCallback(FPSCallback paramFPSCallback);
  
  public abstract void setEnableCodeCache(boolean paramBoolean);
  
  public abstract void setEngineListener(ITTEngine.IListener paramIListener);
  
  public abstract void setJankTraceLevel(JankTraceLevel paramJankTraceLevel);
  
  public abstract void setTargetFPS(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.ITTEngine
 * JD-Core Version:    0.7.0.1
 */