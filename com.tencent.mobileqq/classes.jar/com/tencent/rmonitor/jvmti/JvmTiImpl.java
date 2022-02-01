package com.tencent.rmonitor.jvmti;

import com.tencent.rmonitor.resource.IJvmTi;

public class JvmTiImpl
  implements IJvmTi
{
  public boolean canUseJvmTi()
  {
    return JvmtiHelper.canUseJvmTi();
  }
  
  public long[] getGcInfo()
  {
    return JvmtiHelper.getGcInfo();
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.jvmti.JvmTiImpl
 * JD-Core Version:    0.7.0.1
 */