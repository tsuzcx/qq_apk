package com.tencent.tmassistant.appinfo.a;

import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;

public class b
{
  private static volatile b a;
  private a b = new a();
  
  public static b a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new b();
        }
      }
      finally {}
    }
    return a;
  }
  
  public int a(AppDetailReqParam paramAppDetailReqParam, IGetAppInfoCallback paramIGetAppInfoCallback)
  {
    return this.b.a(paramAppDetailReqParam, paramIGetAppInfoCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.a.b
 * JD-Core Version:    0.7.0.1
 */