package com.tencent.mobileqq.javahook;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.OOMHandler;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class BitmapOOMHooker
{
  private static OOMHandler a = new OOMHandler(BaseApplicationImpl.sApplication);
  
  public static void a()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(Bitmap.class, "createBitmap", new Object[] { DisplayMetrics.class, Integer.TYPE, Integer.TYPE, Bitmap.Config.class, Boolean.TYPE, new BitmapOOMHooker.MyHookMethodCallback(90001) });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      try
      {
        JavaHookBridge.findAndHookMethod(Bitmap.class, "createBitmap", new Object[] { DisplayMetrics.class, [I.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Bitmap.Config.class, new BitmapOOMHooker.MyHookMethodCallback(90002) });
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          for (;;)
          {
            JavaHookBridge.findAndHookMethod(BitmapFactory.class, "decodeResource", new Object[] { Resources.class, Integer.TYPE, BitmapFactory.Options.class, new BitmapOOMHooker.MyHookMethodCallback(90003) });
            try
            {
              JavaHookBridge.findAndHookMethod(BitmapFactory.class, "decodeFile", new Object[] { String.class, BitmapFactory.Options.class, new BitmapOOMHooker.MyHookMethodCallback(90004) });
              return;
            }
            catch (NoSuchMethodException localNoSuchMethodException4)
            {
              Utils.a(localNoSuchMethodException4);
            }
            localNoSuchMethodException1 = localNoSuchMethodException1;
            Utils.a(localNoSuchMethodException1);
            continue;
            localNoSuchMethodException2 = localNoSuchMethodException2;
            Utils.a(localNoSuchMethodException2);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          for (;;)
          {
            Utils.a(localNoSuchMethodException3);
          }
        }
      }
    }
  }
  
  private static void b(boolean paramBoolean, int paramInt)
  {
    String str = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      str = ((QQAppInterface)localObject).getCurrentAccountUin();
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(str, "BitmapOOMHooker", paramBoolean, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  private static void c()
  {
    if (GlobalImageCache.a != null) {
      GlobalImageCache.a.evictAll();
    }
    System.gc();
    Thread.yield();
    System.gc();
    if (ThreadManager.getUIHandler().getLooper() != Looper.myLooper()) {}
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.javahook.BitmapOOMHooker
 * JD-Core Version:    0.7.0.1
 */