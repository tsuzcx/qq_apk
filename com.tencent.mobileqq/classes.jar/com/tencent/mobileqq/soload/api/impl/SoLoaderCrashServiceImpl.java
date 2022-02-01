package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.api.ISoLoaderCrashService;
import com.tencent.mobileqq.soload.util.SoCrashUtils;

public class SoLoaderCrashServiceImpl
  implements ISoLoaderCrashService
{
  public void handleCrash(String paramString1, String paramString2)
  {
    SoCrashUtils.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderCrashServiceImpl
 * JD-Core Version:    0.7.0.1
 */