package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.cmshow.engine.script.Script;

public abstract interface IRenderRunner
{
  public abstract long getLuaState();
  
  public abstract long getRenderThreadId();
  
  public abstract boolean isJsRuntime();
  
  public abstract void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask);
  
  public abstract void runRenderTask(Script paramScript);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner
 * JD-Core Version:    0.7.0.1
 */