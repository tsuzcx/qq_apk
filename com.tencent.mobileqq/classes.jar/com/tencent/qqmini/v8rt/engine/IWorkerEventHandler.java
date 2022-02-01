package com.tencent.qqmini.v8rt.engine;

public abstract interface IWorkerEventHandler
{
  public abstract int create(String paramString);
  
  public abstract void postMsgToAppService(String paramString);
  
  public abstract void postMsgToWorker(int paramInt, String paramString);
  
  public abstract void terminate(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
 * JD-Core Version:    0.7.0.1
 */