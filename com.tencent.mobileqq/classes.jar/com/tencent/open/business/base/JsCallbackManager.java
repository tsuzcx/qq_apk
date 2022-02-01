package com.tencent.open.business.base;

import java.util.ArrayList;

public class JsCallbackManager
{
  protected static JsCallbackManager a;
  protected ArrayList<IJsCallBack> b;
  
  public static JsCallbackManager a()
  {
    try
    {
      if (a == null)
      {
        a = new JsCallbackManager();
        a.b = new ArrayList();
      }
      JsCallbackManager localJsCallbackManager = a;
      return localJsCallbackManager;
    }
    finally {}
  }
  
  public void a(IJsCallBack paramIJsCallBack)
  {
    int j = a.b.size();
    int i = 0;
    while (i < j)
    {
      if ((IJsCallBack)a.b.get(i) == paramIJsCallBack) {
        return;
      }
      i += 1;
    }
    a.b.add(paramIJsCallBack);
  }
  
  public ArrayList<IJsCallBack> b()
  {
    return a.b;
  }
  
  public void b(IJsCallBack paramIJsCallBack)
  {
    int j = a.b.size();
    int i = 0;
    while (i < j)
    {
      if ((IJsCallBack)a.b.get(i) == paramIJsCallBack)
      {
        a.b.remove(i);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.base.JsCallbackManager
 * JD-Core Version:    0.7.0.1
 */