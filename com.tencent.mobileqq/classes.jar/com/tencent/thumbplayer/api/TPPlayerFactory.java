package com.tencent.thumbplayer.api;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.tplayer.TPPlayer;
import com.tencent.thumbplayer.tplayer.TPSurface;

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
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2, TPLoggerContext paramTPLoggerContext)
  {
    return new TPPlayer(paramContext, paramLooper1, paramLooper2, paramTPLoggerContext);
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, TPLoggerContext paramTPLoggerContext)
  {
    return new TPPlayer(paramContext, null, null, paramTPLoggerContext);
  }
  
  public static ITPSurface createTPSurface(SurfaceTexture paramSurfaceTexture)
  {
    return new TPSurface(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerFactory
 * JD-Core Version:    0.7.0.1
 */