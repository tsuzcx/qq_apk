package com.tencent.mobileqq.triton.sdk;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerFactory;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;

public class TTEngineBuilder
{
  private static final String ENGINE_FACTORY_IMPL_CLASS_NAME = "com.tencent.mobileqq.triton.engine.EngineFactory";
  private static final String TAG = "TTEngineBuilder";
  private IAudioPlayerFactory mAudioPlayerBuilder;
  private Context mContext;
  private EnvConfig mEnvConfig;
  private IJSEngine mJsEngine;
  private ITLog mLog;
  private IQQEnv mQQEnv;
  
  private static TTEngineBuilder.EngineFactory getFactory(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      try
      {
        paramClassLoader = paramClassLoader.loadClass("com.tencent.mobileqq.triton.engine.EngineFactory");
        paramClassLoader = (TTEngineBuilder.EngineFactory)paramClassLoader.newInstance();
        return paramClassLoader;
      }
      catch (ClassCastException paramClassLoader)
      {
        throw new TTEngineBuilder.EngineCreationException(paramClassLoader);
      }
      catch (InstantiationException paramClassLoader)
      {
        throw new TTEngineBuilder.EngineCreationException(paramClassLoader);
      }
      catch (IllegalAccessException paramClassLoader)
      {
        throw new TTEngineBuilder.EngineCreationException(paramClassLoader);
      }
      catch (ClassNotFoundException paramClassLoader)
      {
        throw new TTEngineBuilder.EngineCreationException(paramClassLoader);
      }
      paramClassLoader = Class.forName("com.tencent.mobileqq.triton.engine.EngineFactory");
    }
  }
  
  public ITTEngine build(@Nullable ClassLoader paramClassLoader)
  {
    if (this.mContext != null)
    {
      if (this.mQQEnv != null)
      {
        if (this.mJsEngine != null) {
          return getFactory(paramClassLoader).createEngine(this.mContext, this.mQQEnv, this.mLog, this.mJsEngine, this.mAudioPlayerBuilder, this.mEnvConfig);
        }
        throw new TTEngineBuilder.EngineCreationException("JSEngine must be set");
      }
      throw new TTEngineBuilder.EngineCreationException("QQEnv must be set");
    }
    throw new TTEngineBuilder.EngineCreationException("Context must be set");
  }
  
  public TTEngineBuilder setAudioPlayerFactory(IAudioPlayerFactory paramIAudioPlayerFactory)
  {
    this.mAudioPlayerBuilder = paramIAudioPlayerFactory;
    return this;
  }
  
  public TTEngineBuilder setContext(Context paramContext)
  {
    this.mContext = paramContext;
    return this;
  }
  
  public TTEngineBuilder setEnvConfig(EnvConfig paramEnvConfig)
  {
    this.mEnvConfig = paramEnvConfig;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.TTEngineBuilder
 * JD-Core Version:    0.7.0.1
 */