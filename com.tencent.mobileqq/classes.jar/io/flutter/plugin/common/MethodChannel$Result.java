package io.flutter.plugin.common;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

public abstract interface MethodChannel$Result
{
  @UiThread
  public abstract void error(String paramString1, @Nullable String paramString2, @Nullable Object paramObject);
  
  @UiThread
  public abstract void notImplemented();
  
  @UiThread
  public abstract void success(@Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel.Result
 * JD-Core Version:    0.7.0.1
 */