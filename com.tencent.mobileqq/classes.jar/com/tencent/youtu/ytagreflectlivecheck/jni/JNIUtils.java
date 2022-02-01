package com.tencent.youtu.ytagreflectlivecheck.jni;

import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;

public class JNIUtils
{
  private static final String TAG = "LightLiveCheck";
  
  public static Timeval getTimeval(long paramLong)
  {
    return new Timeval(paramLong / 1000L, (int)(paramLong * 1000L % 1000000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils
 * JD-Core Version:    0.7.0.1
 */