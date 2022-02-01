package com.tribe.async.async;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;

public class Bosses
{
  private static Context sApp;
  private static volatile Boss sBoss;
  private static Looper sLooper;
  
  @NonNull
  public static Boss get()
  {
    if (sBoss != null) {
      return sBoss;
    }
    try
    {
      if (sBoss != null)
      {
        localBoss = sBoss;
        return localBoss;
      }
      sBoss = new BossImp(sApp, sLooper);
      Boss localBoss = sBoss;
      return localBoss;
    }
    finally {}
  }
  
  public static void init(Context paramContext)
  {
    init(paramContext, Looper.myLooper());
  }
  
  public static void init(Context paramContext, Looper paramLooper)
  {
    sApp = paramContext.getApplicationContext();
    sLooper = paramLooper;
  }
  
  public static void initWithBoss(Context paramContext, Boss paramBoss)
  {
    sApp = paramContext.getApplicationContext();
    try
    {
      sBoss = paramBoss;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tribe.async.async.Bosses
 * JD-Core Version:    0.7.0.1
 */