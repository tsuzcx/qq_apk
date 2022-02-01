package com.tencent.mobileqq.danmaku;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;

public class QQDanmakuDependImp
  implements IDanmakuDepend
{
  private Handler a;
  
  public Resources a()
  {
    return MobileQQ.sMobileQQ.getApplicationContext().getResources();
  }
  
  public Handler a()
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper());
    }
    return this.a;
  }
  
  public Object a(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass = paramClass.get(paramObject);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public boolean c()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.QQDanmakuDependImp
 * JD-Core Version:    0.7.0.1
 */