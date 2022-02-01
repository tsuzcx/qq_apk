package com.tencent.mobileqq.flashshow.inject;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.mobileqq.auto.engine.lib.IToastDelegate;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import com.tencent.qphone.base.util.QLog;

public class FSToast
{
  public static int a = -1;
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  private static volatile FSToast f;
  private IToastDelegate e;
  
  private static FSToast a()
  {
    try
    {
      if (f == null) {
        try
        {
          if (f == null) {
            f = new FSToast();
          }
        }
        finally {}
      }
      FSToast localFSToast = f;
      return localFSToast;
    }
    finally {}
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, FSApplication.APP.getResources().getString(paramInt2), paramInt3);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    IToastDelegate localIToastDelegate = a().b();
    if (localIToastDelegate != null)
    {
      localIToastDelegate.makeTextAndShow(paramInt1, paramString, paramInt2);
      return;
    }
    QLog.e("QCircleToast", 1, "makeTextAndShow() get delegate is null!");
  }
  
  public static void a(IToastDelegate paramIToastDelegate)
  {
    a().b(paramIToastDelegate);
  }
  
  private IToastDelegate b()
  {
    return this.e;
  }
  
  private void b(IToastDelegate paramIToastDelegate)
  {
    if (paramIToastDelegate != null)
    {
      this.e = paramIToastDelegate;
      a = paramIToastDelegate.getIconTypeNone();
      b = paramIToastDelegate.getIconTypeDefault();
      c = paramIToastDelegate.getIconTypeError();
      d = paramIToastDelegate.getIconTypeSuccess();
      return;
    }
    Log.d("QCircleToast", "setDelegate input delegate is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.inject.FSToast
 * JD-Core Version:    0.7.0.1
 */