package com.tencent.xaction.openapi;

import android.content.Context;
import com.tencent.xaction.openapi.api.IXAEngine;
import com.tencent.xaction.openapi.api.IXAGlobal;

public class XAApi
  extends BaseApi
{
  static IXAGlobal a;
  
  public static IXAEngine c(Context paramContext)
  {
    
    IXAEngine localIXAEngine1;
    if (a()) {
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
  
  public static IXAGlobal c()
  {
    
    if (a == null)
    {
      if (a()) {
        a = a();
      }
      if (a == null) {
        a = b();
      }
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.openapi.XAApi
 * JD-Core Version:    0.7.0.1
 */