package com.tencent.qqmini.minigame;

import android.webkit.ValueCallback;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class GameJsService
  implements IJsService
{
  private final String TAG;
  private int mContextType;
  private volatile boolean mIsDestroyed;
  public ITTJSRuntime realJsRuntime;
  
  public GameJsService(ITTJSRuntime paramITTJSRuntime, int paramInt)
  {
    this.TAG = ("[minigame] " + this + "[" + paramInt + "]");
    this.realJsRuntime = paramITTJSRuntime;
    this.mContextType = paramInt;
  }
  
  public void clearUp()
  {
    this.mIsDestroyed = true;
  }
  
  public void evaluateCallbackJs(int paramInt, String paramString)
  {
    if (isDestroyed()) {
      return;
    }
    if (this.realJsRuntime != null)
    {
      this.realJsRuntime.evaluateCallbackJs(paramInt, paramString);
      return;
    }
    QMLog.e(this.TAG, "evaluateCallbackJs on null realJsRuntime");
  }
  
  public void evaluateJs(String paramString, ValueCallback paramValueCallback)
  {
    if (isDestroyed()) {
      return;
    }
    if (this.realJsRuntime != null)
    {
      this.realJsRuntime.evaluateJs(paramString);
      return;
    }
    QMLog.e(this.TAG, "evaluateJs on null realJsRuntime");
  }
  
  public void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    if (isDestroyed()) {
      return;
    }
    if (this.realJsRuntime != null)
    {
      this.realJsRuntime.evaluateSubscribeJs(paramString1, paramString2);
      return;
    }
    QMLog.e(this.TAG, "evaluateSubscribeJS on null realJsRuntime");
  }
  
  public int getTargetContextType()
  {
    return this.mContextType;
  }
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameJsService
 * JD-Core Version:    0.7.0.1
 */