package com.tencent.mobileqq.danmaku;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.danmaku.IDanmakuDepend;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;

public class QQDanmakuDependImp
  implements IDanmakuDepend
{
  private Handler a;
  
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
  
  public Resources b()
  {
    return MobileQQ.sMobileQQ.getApplicationContext().getResources();
  }
  
  public Handler c()
  {
    if (this.a == null) {
      this.a = new Handler(Looper.getMainLooper());
    }
    return this.a;
  }
  
  public boolean d()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public boolean e()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.QQDanmakuDependImp
 * JD-Core Version:    0.7.0.1
 */