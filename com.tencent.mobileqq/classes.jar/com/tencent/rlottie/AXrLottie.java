package com.tencent.rlottie;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AXrLottie
{
  static Context a;
  static float b = 60.0F;
  public static boolean c = false;
  @Nullable
  private static AXrLottieCacheManager d;
  @Nullable
  private static AXrLottieOptions e;
  
  @Nullable
  public static AXrLottieOptions a()
  {
    return e;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      a = paramContext.getApplicationContext();
      b(paramContext);
      try
      {
        if (!c) {
          System.loadLibrary("jlottie");
        }
        c = true;
      }
      catch (Throwable paramContext)
      {
        c = false;
        Log.e("AXrLottie", "load so fail", paramContext);
      }
      boolean bool = c;
      return bool;
    }
    finally {}
  }
  
  public static float b()
  {
    return b;
  }
  
  public static void b(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext != null)
    {
      paramContext = paramContext.getDefaultDisplay();
      if (paramContext != null) {
        b = paramContext.getRefreshRate();
      }
    }
  }
  
  @NonNull
  public static AXrLottieCacheManager c(Context paramContext)
  {
    Object localObject = d;
    if (localObject == null) {
      try
      {
        AXrLottieCacheManager localAXrLottieCacheManager = d;
        localObject = localAXrLottieCacheManager;
        if (localAXrLottieCacheManager == null)
        {
          localObject = paramContext;
          if (paramContext == null) {
            localObject = a;
          }
          localObject = new AXrLottieCacheManager((Context)localObject);
          d = (AXrLottieCacheManager)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottie
 * JD-Core Version:    0.7.0.1
 */