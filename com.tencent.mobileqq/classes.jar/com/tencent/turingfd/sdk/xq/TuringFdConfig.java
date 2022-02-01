package com.tencent.turingfd.sdk.xq;

import android.content.Context;

public final class TuringFdConfig
  extends break
{
  public static TuringFdConfig createDefault(Context paramContext, String paramString)
  {
    return new TuringFdConfig.Builder(paramContext, paramString, null).build();
  }
  
  public static TuringFdConfig.Builder newBuilder(Context paramContext, String paramString)
  {
    return new TuringFdConfig.Builder(paramContext, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringFdConfig
 * JD-Core Version:    0.7.0.1
 */