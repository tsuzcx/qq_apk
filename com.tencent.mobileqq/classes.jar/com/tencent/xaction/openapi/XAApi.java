package com.tencent.xaction.openapi;

import android.content.Context;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.openapi.api.IXAGlobal;

public class XAApi
  extends BaseApi
{
  static IXAGlobal d;
  
  public static IXAEngine c(Context paramContext)
  {
    
    IXAEngine localIXAEngine1;
    if (c()) {
      localIXAEngine1 = a(paramContext);
    } else {
      localIXAEngine1 = null;
    }
    IXAEngine localIXAEngine2 = localIXAEngine1;
    if (localIXAEngine1 == null) {
      localIXAEngine2 = b(paramContext);
    }
    return localIXAEngine2;
  }
  
  public static IXAGlobal e()
  {
    
    if (d == null)
    {
      if (c()) {
        d = a();
      }
      if (d == null) {
        d = b();
      }
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.XAApi
 * JD-Core Version:    0.7.0.1
 */