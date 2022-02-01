package com.tencent.mobileqq.triton.sdk;

import android.content.Context;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerFactory;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;

public abstract interface TTEngineBuilder$EngineFactory
{
  public abstract ITTEngine createEngine(Context paramContext, IQQEnv paramIQQEnv, ITLog paramITLog, IJSEngine paramIJSEngine, IAudioPlayerFactory paramIAudioPlayerFactory, EnvConfig paramEnvConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.TTEngineBuilder.EngineFactory
 * JD-Core Version:    0.7.0.1
 */