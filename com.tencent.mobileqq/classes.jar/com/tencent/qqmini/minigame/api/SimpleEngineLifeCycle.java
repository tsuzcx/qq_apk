package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import org.jetbrains.annotations.NotNull;

public abstract class SimpleEngineLifeCycle
  implements LifeCycle
{
  public void onDestroy() {}
  
  public void onFirstFrame() {}
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine) {}
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.SimpleEngineLifeCycle
 * JD-Core Version:    0.7.0.1
 */