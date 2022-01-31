package com.tencent.shadow.dynamic.host;

import com.tencent.shadow.core.common.InstalledApk;

public abstract interface UuidManager
{
  public static final String DESCRIPTOR = UuidManager.class.getName();
  public static final int TRANSACTION_CODE_FAILED_EXCEPTION = 1;
  public static final int TRANSACTION_CODE_NOT_FOUND_EXCEPTION = 2;
  public static final int TRANSACTION_CODE_NO_EXCEPTION = 0;
  public static final int TRANSACTION_getPlugin = 1;
  public static final int TRANSACTION_getPluginLoader = 2;
  public static final int TRANSACTION_getRuntime = 3;
  
  public abstract InstalledApk getPlugin(String paramString1, String paramString2);
  
  public abstract InstalledApk getPluginLoader(String paramString);
  
  public abstract InstalledApk getRuntime(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.UuidManager
 * JD-Core Version:    0.7.0.1
 */