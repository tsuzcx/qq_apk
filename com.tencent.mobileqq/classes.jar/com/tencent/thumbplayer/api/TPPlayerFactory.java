package com.tencent.thumbplayer.api;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.log.TPLoggerContext;
import com.tencent.thumbplayer.richmedia.TPRichMediaSynchronizer;
import com.tencent.thumbplayer.tplayer.TPPlayer;
import com.tencent.thumbplayer.tplayer.TPPlayerProxy;
import com.tencent.thumbplayer.tplayer.TPSurface;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPPlayerFactory
{
  private static final String LOG_TAG = "TPPlayerFactory";
  
  @Nullable
  public static ITPRichMediaAsyncRequester createRichMediaASyncRequester(Context paramContext)
  {
    return null;
  }
  
  @Nullable
  public static ITPRichMediaSynchronizer createRichMediaSynchronizer(Context paramContext)
  {
    try
    {
      paramContext = new TPRichMediaSynchronizer(paramContext.getApplicationContext());
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to create rich media synchronizer:");
      localStringBuilder.append(paramContext.getMessage());
      TPLogUtil.e("TPPlayerFactory", localStringBuilder.toString());
    }
    return null;
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext)
  {
    return (ITPPlayer)new TPPlayerProxy(new TPPlayer(paramContext)).getProxyInstance();
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper)
  {
    return (ITPPlayer)new TPPlayerProxy(new TPPlayer(paramContext, paramLooper)).getProxyInstance();
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2)
  {
    return (ITPPlayer)new TPPlayerProxy(new TPPlayer(paramContext, paramLooper1, paramLooper2)).getProxyInstance();
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, Looper paramLooper1, Looper paramLooper2, TPLoggerContext paramTPLoggerContext)
  {
    return (ITPPlayer)new TPPlayerProxy(new TPPlayer(paramContext, paramLooper1, paramLooper2, paramTPLoggerContext)).getProxyInstance();
  }
  
  public static ITPPlayer createTPPlayer(Context paramContext, TPLoggerContext paramTPLoggerContext)
  {
    return (ITPPlayer)new TPPlayerProxy(new TPPlayer(paramContext, null, null, paramTPLoggerContext)).getProxyInstance();
  }
  
  public static ITPSurface createTPSurface(SurfaceTexture paramSurfaceTexture)
  {
    return new TPSurface(paramSurfaceTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerFactory
 * JD-Core Version:    0.7.0.1
 */