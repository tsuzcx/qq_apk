package com.tencent.wifisdk;

import android.os.Looper;

public abstract interface TMSDKCustomConfig$IThreadPoolManager
{
  public static final int TYPE_DB = 2;
  public static final int TYPE_FILE = 3;
  public static final int TYPE_NETWORK = 4;
  public static final int TYPE_NORMAL = 1;
  
  public abstract void addTask(int paramInt, Runnable paramRunnable, String paramString);
  
  public abstract void addTypeTask(Runnable paramRunnable, int paramInt);
  
  public abstract Looper getSubThreadLooper();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKCustomConfig.IThreadPoolManager
 * JD-Core Version:    0.7.0.1
 */