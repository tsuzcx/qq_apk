package com.tencent.thumbplayer.core.common;

public class TPDrm
{
  public static int[] getDRMCapabilities()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = native_getDRMCapabilities();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new int[0];
    }
    return localObject2;
  }
  
  static native int[] native_getDRMCapabilities();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPDrm
 * JD-Core Version:    0.7.0.1
 */