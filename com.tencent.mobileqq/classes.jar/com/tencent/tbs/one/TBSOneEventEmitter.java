package com.tencent.tbs.one;

import java.util.Map;

public abstract interface TBSOneEventEmitter
{
  public abstract void emit(TBSOneEventEmitter.UnloadedBehavior paramUnloadedBehavior, String paramString1, String paramString2, String paramString3, Map<String, Object> paramMap);
  
  public abstract void emit(String paramString, Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneEventEmitter
 * JD-Core Version:    0.7.0.1
 */