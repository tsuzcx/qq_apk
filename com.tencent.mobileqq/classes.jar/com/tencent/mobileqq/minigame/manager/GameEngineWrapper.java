package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITLog;
import com.tencent.mobileqq.triton.sdk.ITSoLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
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

public class GameEngineWrapper
  implements ITTEngine
{
  private ITTEngine baseEngine;
  private APIProxy mAPIProxy;
  
  public void addFPSCallback(FPSCallback paramFPSCallback)
  {
    if (this.baseEngine != null) {
      this.baseEngine.addFPSCallback(paramFPSCallback);
    }
  }
  
  public void addGameLifeCycle(GameLifecycle paramGameLifecycle)
  {
    if (this.baseEngine != null) {
      this.baseEngine.addGameLifeCycle(paramGameLifecycle);
    }
  }
  
  public View createGameView(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (this.baseEngine != null) {
      return this.baseEngine.createGameView(paramActivity, paramInt1, paramInt2);
    }
    return null;
  }
  
  public APIProxy getApiProxy()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getApiProxy();
    }
    return this.mAPIProxy;
  }
  
  public long getCurrentDrawCount()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getCurrentDrawCount();
    }
    return 0L;
  }
  
  public int getDisplayRefreshRate()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getDisplayRefreshRate();
    }
    return 0;
  }
  
  public IGameLauncher getGameLauncher()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getGameLauncher();
    }
    return null;
  }
  
  public IJSEngine getJsEngine()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getJsEngine();
    }
    return null;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getJsRuntime(paramInt);
    }
    return null;
  }
  
  public long getLastBlackTime()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getLastBlackTime();
    }
    return -1L;
  }
  
  public ITNativeBufferPool getNativeBufferPool()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getNativeBufferPool();
    }
    return null;
  }
  
  public ITHttp getNativeHttp()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getNativeHttp();
    }
    return null;
  }
  
  public Map<String, String> getResPathCache()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getResPathCache();
    }
    return null;
  }
  
  public void getScreenShot(ScreenShotCallback paramScreenShotCallback)
  {
    if (this.baseEngine != null) {
      this.baseEngine.getScreenShot(paramScreenShotCallback);
    }
  }
  
  public int getTargetFPS()
  {
    if (this.baseEngine != null) {
      return this.baseEngine.getTargetFPS();
    }
    return 0;
  }
  
  public void handleFocusGain()
  {
    if (this.baseEngine != null) {
      this.baseEngine.handleFocusGain();
    }
  }
  
  public void handleFocusLoss()
  {
    if (this.baseEngine != null) {
      this.baseEngine.handleFocusLoss();
    }
  }
  
  public int initEngine(Context paramContext, ITTEngine.IListener paramIListener, @Nullable IInspectorAgent paramIInspectorAgent)
  {
    if (this.baseEngine != null) {
      return this.baseEngine.initEngine(paramContext, paramIListener, paramIInspectorAgent);
    }
    return 1;
  }
  
  public void onCreate(Activity paramActivity)
  {
    if (this.baseEngine != null) {
      this.baseEngine.onCreate(paramActivity);
    }
  }
  
  public void onDestroy()
  {
    if (this.baseEngine != null) {
      this.baseEngine.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.baseEngine != null) {
      this.baseEngine.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.baseEngine != null) {
      this.baseEngine.onResume();
    }
  }
  
  public void removeFPSCallback(FPSCallback paramFPSCallback)
  {
    if (this.baseEngine != null) {
      this.baseEngine.removeFPSCallback(paramFPSCallback);
    }
  }
  
  public void setApiProxy(APIProxy paramAPIProxy)
  {
    if (this.baseEngine != null)
    {
      this.baseEngine.setApiProxy(paramAPIProxy);
      return;
    }
    this.mAPIProxy = paramAPIProxy;
  }
  
  public void setAudioPlayerBuilder(IAudioPlayerBuilder paramIAudioPlayerBuilder)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setAudioPlayerBuilder(paramIAudioPlayerBuilder);
    }
  }
  
  public void setBaseEngine(ITTEngine paramITTEngine)
  {
    this.baseEngine = paramITTEngine;
  }
  
  public void setDiskIoExecutor(@NonNull Executor paramExecutor)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setDiskIoExecutor(paramExecutor);
    }
  }
  
  public void setEnableCodeCache(boolean paramBoolean)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setEnableCodeCache(paramBoolean);
    }
  }
  
  public void setEngineListener(ITTEngine.IListener paramIListener)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setEngineListener(paramIListener);
    }
  }
  
  public void setJsEngine(IJSEngine paramIJSEngine)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setJsEngine(paramIJSEngine);
    }
  }
  
  public void setLog(ITLog paramITLog)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setLog(paramITLog);
    }
  }
  
  public void setQQEnv(IQQEnv paramIQQEnv)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setQQEnv(paramIQQEnv);
    }
  }
  
  public void setSoLoader(ITSoLoader paramITSoLoader)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setSoLoader(paramITSoLoader);
    }
  }
  
  public void setTargetFPS(int paramInt)
  {
    if (this.baseEngine != null) {
      this.baseEngine.setTargetFPS(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameEngineWrapper
 * JD-Core Version:    0.7.0.1
 */