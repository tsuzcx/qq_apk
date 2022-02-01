package com.tencent.qqmini.v8rt.engine;

import java.util.ArrayList;

public class JsEngineProvider
  extends ArrayList<IJsEngine>
{
  public static final String TAG = "JsEngineProvider";
  public static JsEngineProvider sInstance = new JsEngineProvider();
  
  public static JsEngineProvider getInstance()
  {
    return sInstance;
  }
  
  public boolean add(IJsEngine paramIJsEngine)
  {
    if (paramIJsEngine == null)
    {
      Logger.e("JsEngineProvider", "null engine");
      return false;
    }
    if (contains(paramIJsEngine))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIJsEngine);
      localStringBuilder.append(" already added");
      Logger.w("JsEngineProvider", localStringBuilder.toString());
      return false;
    }
    return super.add(paramIJsEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.JsEngineProvider
 * JD-Core Version:    0.7.0.1
 */