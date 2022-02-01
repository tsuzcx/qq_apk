package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.api.ISoloadCrashService;
import com.tencent.mobileqq.soload.util.SoCrashUtils;

public class SoloadCrashServiceImpl
  implements ISoloadCrashService
{
  public void handleCrash(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    SoCrashUtils.a(paramBoolean, paramString1, paramString2, paramString3, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoloadCrashServiceImpl
 * JD-Core Version:    0.7.0.1
 */