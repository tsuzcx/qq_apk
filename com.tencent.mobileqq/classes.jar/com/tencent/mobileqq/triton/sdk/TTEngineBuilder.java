package com.tencent.mobileqq.triton.sdk;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerBuilder;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.reflection.Reflect;
import java.util.concurrent.Executor;

public class TTEngineBuilder
{
  private static final String TAG = "TTEngineBuilder";
  private static final String TTENGINE_CLASS_NAME = "com.tencent.mobileqq.triton.engine.TTEngine";
  private APIProxy mAPIProxy;
  private IAudioPlayerBuilder mAudioPlayerBuilder;
  private Executor mDiskIoExecutor;
  private IJSEngine mJsEngine;
  private ITLog mLog;
  private IQQEnv mQQEnv;
  private ITSoLoader mSoLoader;
  
  private ITTEngine engineInstance(ClassLoader paramClassLoader)
  {
    try
    {
      paramClassLoader = (ITTEngine)Reflect.on("com.tencent.mobileqq.triton.engine.TTEngine", paramClassLoader).create().get();
      return paramClassLoader;
    }
    catch (Exception paramClassLoader)
    {
      for (;;)
      {
        if (this.mLog != null)
        {
          this.mLog.i("TTEngineBuilder", "engineInstance error : ", paramClassLoader);
          paramClassLoader = null;
        }
        else
        {
          Log.i("TTEngineBuilder", "engineInstance error : ", paramClassLoader);
          paramClassLoader = null;
        }
      }
    }
    finally {}
  }
  
  public ITTEngine createInstance(ClassLoader paramClassLoader)
  {
    paramClassLoader = engineInstance(paramClassLoader);
    if (paramClassLoader != null)
    {
      paramClassLoader.setQQEnv(this.mQQEnv);
      paramClassLoader.setDiskIoExecutor(this.mDiskIoExecutor);
      paramClassLoader.setApiProxy(this.mAPIProxy);
      paramClassLoader.setLog(this.mLog);
      paramClassLoader.setSoLoader(this.mSoLoader);
      paramClassLoader.setJsEngine(this.mJsEngine);
      paramClassLoader.setAudioPlayerBuilder(this.mAudioPlayerBuilder);
    }
    return paramClassLoader;
  }
  
  public TTEngineBuilder setApiProxy(APIProxy paramAPIProxy)
  {
    this.mAPIProxy = paramAPIProxy;
    return this;
  }
  
  public TTEngineBuilder setAudioPlayerBuilder(IAudioPlayerBuilder paramIAudioPlayerBuilder)
  {
    this.mAudioPlayerBuilder = paramIAudioPlayerBuilder;
    return this;
  }
  
  public TTEngineBuilder setDiskIoExecutor(@NonNull Executor paramExecutor)
  {
    this.mDiskIoExecutor = paramExecutor;
    return this;
  }
  
  public TTEngineBuilder setJsEngine(IJSEngine paramIJSEngine)
  {
    this.mJsEngine = paramIJSEngine;
    return this;
  }
  
  public TTEngineBuilder setLog(ITLog paramITLog)
  {
    this.mLog = paramITLog;
    return this;
  }
  
  public TTEngineBuilder setQQEnv(IQQEnv paramIQQEnv)
  {
    this.mQQEnv = paramIQQEnv;
    return this;
  }
  
  public TTEngineBuilder setSoLoader(ITSoLoader paramITSoLoader)
  {
    this.mSoLoader = paramITSoLoader;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.TTEngineBuilder
 * JD-Core Version:    0.7.0.1
 */