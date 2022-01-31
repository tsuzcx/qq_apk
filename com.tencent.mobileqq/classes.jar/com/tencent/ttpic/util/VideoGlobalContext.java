package com.tencent.ttpic.util;

import android.content.Context;

public class VideoGlobalContext
{
  private static Context sContext;
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static void setContext(Context paramContext)
  {
    sContext = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoGlobalContext
 * JD-Core Version:    0.7.0.1
 */