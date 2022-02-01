package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StandardMethodCodec;

public class MouseCursorChannel
{
  private static final String TAG = "MouseCursorChannel";
  @NonNull
  public final MethodChannel channel;
  @Nullable
  private MouseCursorChannel.MouseCursorMethodHandler mouseCursorMethodHandler;
  @NonNull
  private final MethodChannel.MethodCallHandler parsingMethodCallHandler = new MouseCursorChannel.1(this);
  
  public MouseCursorChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingMethodCallHandler);
  }
  
  public void setMethodHandler(@Nullable MouseCursorChannel.MouseCursorMethodHandler paramMouseCursorMethodHandler)
  {
    this.mouseCursorMethodHandler = paramMouseCursorMethodHandler;
  }
  
  @VisibleForTesting
  public void synthesizeMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    this.parsingMethodCallHandler.onMethodCall(paramMethodCall, paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.MouseCursorChannel
 * JD-Core Version:    0.7.0.1
 */