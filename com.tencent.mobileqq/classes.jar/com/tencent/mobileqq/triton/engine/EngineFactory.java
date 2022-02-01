package com.tencent.mobileqq.triton.engine;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.mobileqq.triton.sdk.EnvConfig;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITLog;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.TTEngineBuilder.EngineFactory;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerFactory;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;

@Keep
public class EngineFactory
  implements TTEngineBuilder.EngineFactory
{
  public ITTEngine createEngine(Context paramContext, IQQEnv paramIQQEnv, ITLog paramITLog, IJSEngine paramIJSEngine, IAudioPlayerFactory paramIAudioPlayerFactory, EnvConfig paramEnvConfig)
  {
    return new TTEngine(paramContext, paramIQQEnv, paramITLog, paramIJSEngine, paramIAudioPlayerFactory, paramEnvConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.EngineFactory
 * JD-Core Version:    0.7.0.1
 */