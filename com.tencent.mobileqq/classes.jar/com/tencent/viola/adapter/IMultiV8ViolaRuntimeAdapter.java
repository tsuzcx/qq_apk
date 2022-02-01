package com.tencent.viola.adapter;

public abstract interface IMultiV8ViolaRuntimeAdapter
{
  public abstract boolean needKeepGlobalVar(String paramString);
  
  public abstract boolean needPreloadRuntime(String paramString);
  
  public abstract void onViolaRuntimeReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.adapter.IMultiV8ViolaRuntimeAdapter
 * JD-Core Version:    0.7.0.1
 */