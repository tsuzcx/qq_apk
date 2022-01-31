package com.tencent.thumbplayer.api;

import android.content.Context;
import android.os.Looper;
import com.tencent.thumbplayer.tplayer.TPPlayer;

public class TPPlayerFactory
{
  public static ITPPlayer createTPPlayer(Context paramContext)
  {
    return new TPPlayer(paramContext);
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper)
  {
    return new TPPlayer(paramContext, paramLooper);
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2)
  {
    return new TPPlayer(paramContext, paramLooper1, paramLooper2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerFactory
 * JD-Core Version:    0.7.0.1
 */