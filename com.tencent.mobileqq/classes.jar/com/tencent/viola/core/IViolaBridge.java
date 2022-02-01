package com.tencent.viola.core;

import com.tencent.viola.commons.JSParam;
import java.util.List;

public abstract interface IViolaBridge
{
  public abstract int callJS(String paramString1, String paramString2);
  
  public abstract int createInstance(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract int destroy();
  
  public abstract int destroyInstance(String paramString);
  
  public abstract int execJSFunc(String paramString1, String paramString2);
  
  public abstract JSParam execJSFuncWithResult(String paramString, List<JSParam> paramList);
  
  public abstract int init();
  
  public abstract int initJsFramework(String paramString1, String paramString2);
  
  public abstract void preloadTest(String paramString1, String paramString2);
  
  public abstract int updateInstance(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.IViolaBridge
 * JD-Core Version:    0.7.0.1
 */