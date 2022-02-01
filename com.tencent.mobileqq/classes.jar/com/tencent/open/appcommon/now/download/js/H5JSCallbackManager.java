package com.tencent.open.appcommon.now.download.js;

import com.tencent.open.business.base.IJsCallBack;
import java.util.ArrayList;

public class H5JSCallbackManager
{
  protected static H5JSCallbackManager a;
  protected ArrayList<IJsCallBack> b;
  
  public static H5JSCallbackManager a()
  {
    try
    {
      if (a == null)
      {
        a = new H5JSCallbackManager();
        a.b = new ArrayList();
      }
      H5JSCallbackManager localH5JSCallbackManager = a;
      return localH5JSCallbackManager;
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
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.H5JSCallbackManager
 * JD-Core Version:    0.7.0.1
 */