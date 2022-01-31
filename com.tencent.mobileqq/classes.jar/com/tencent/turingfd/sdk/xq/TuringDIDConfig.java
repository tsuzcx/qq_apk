package com.tencent.turingfd.sdk.xq;

import android.content.Context;

public class TuringDIDConfig
  extends case
{
  public static TuringDIDConfig createDefault(Context paramContext)
  {
    return new TuringDIDConfig.Builder(paramContext, null).build();
  }
  
  public static TuringDIDConfig.Builder newBuilder(Context paramContext)
  {
    return new TuringDIDConfig.Builder(paramContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringDIDConfig
 * JD-Core Version:    0.7.0.1
 */