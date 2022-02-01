package com.tencent.timi.game.env;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tencent.timi.game.utils.Logger;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public final class Env
{
  private static Application a;
  private static String b = "";
  private static String c;
  private static boolean d = false;
  private static volatile AtomicBoolean e;
  private static volatile AtomicBoolean f;
  
  public static Application a()
  {
    return MobileQQ.getContext();
  }
  
  public static void a(Application paramApplication)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("attachContext - ");
    localStringBuilder.append(paramApplication);
    Logger.a("ENV", localStringBuilder.toString());
    a = paramApplication;
  }
  
  public static boolean b()
  {
    return (c()) || (d());
  }
  
  public static boolean c()
  {
    AtomicBoolean localAtomicBoolean = e;
    boolean bool2 = false;
    if (localAtomicBoolean == null) {}
    for (;;)
    {
      try
      {
        if ((e == null) && (a != null))
        {
          if ((a.getApplicationInfo() == null) || ((a.getApplicationInfo().flags & 0x2) == 0)) {
            break label93;
          }
          bool1 = true;
          e = new AtomicBoolean(bool1);
        }
      }
      finally {}
      boolean bool1 = bool2;
      if (e != null) {
        bool1 = e.get();
      }
      return bool1;
      label93:
      bool1 = false;
    }
  }
  
  private static boolean d()
  {
    if (c == null) {
      try
      {
        if (c == null)
        {
          String str = "";
          Object localObject1 = null;
          Object localObject3;
          try
          {
            InputStream localInputStream = a().getResources().getAssets().open("enable_debug_for_release.txt");
            localObject1 = localInputStream;
            Object localObject4 = new Properties();
            localObject1 = localInputStream;
            ((Properties)localObject4).load(localInputStream);
            localObject1 = localInputStream;
            localInputStream.close();
            localObject1 = localInputStream;
            localObject4 = ((Properties)localObject4).getProperty("ENABLE_DEBUG_FOR_RELEASE", "");
            localObject1 = localObject4;
          }
          catch (Exception localException1)
          {
            Logger.a("ENV", localException1.getMessage());
            localObject3 = localObject1;
            localObject1 = str;
          }
          if (localObject3 != null) {
            try
            {
              localObject3.close();
            }
            catch (Exception localException2)
            {
              Logger.a("ENV", "isEnableDebugModeInRelease close stream error", localException2);
            }
          }
          c = (String)localObject1;
          d = "true".equals(c);
        }
      }
      finally {}
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.env.Env
 * JD-Core Version:    0.7.0.1
 */