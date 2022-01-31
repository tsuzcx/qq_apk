package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;

public abstract interface PlatformViewsChannel$PlatformViewsHandler
{
  public abstract void clearFocus(int paramInt);
  
  public abstract long createPlatformView(@NonNull PlatformViewsChannel.PlatformViewCreationRequest paramPlatformViewCreationRequest);
  
  public abstract void disposePlatformView(int paramInt);
  
  public abstract void onTouch(@NonNull PlatformViewsChannel.PlatformViewTouch paramPlatformViewTouch);
  
  public abstract void resizePlatformView(@NonNull PlatformViewsChannel.PlatformViewResizeRequest paramPlatformViewResizeRequest, @NonNull Runnable paramRunnable);
  
  public abstract void setDirection(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler
 * JD-Core Version:    0.7.0.1
 */