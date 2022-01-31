package io.flutter.plugin.common;

import android.support.annotation.NonNull;
import android.support.annotation.UiThread;

public abstract interface MethodChannel$MethodCallHandler
{
  @UiThread
  public abstract void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel.MethodCallHandler
 * JD-Core Version:    0.7.0.1
 */