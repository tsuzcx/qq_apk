package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformViewsChannel
{
  private static final String TAG = "PlatformViewsChannel";
  private final MethodChannel channel;
  private PlatformViewsChannel.PlatformViewsHandler handler;
  private final MethodChannel.MethodCallHandler parsingHandler = new PlatformViewsChannel.1(this);
  
  public PlatformViewsChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingHandler);
  }
  
  private static String detailedExceptionString(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public void invokeViewFocused(int paramInt)
  {
    MethodChannel localMethodChannel = this.channel;
    if (localMethodChannel == null) {
      return;
    }
    localMethodChannel.invokeMethod("viewFocused", Integer.valueOf(paramInt));
  }
  
  public void setPlatformViewsHandler(@Nullable PlatformViewsChannel.PlatformViewsHandler paramPlatformViewsHandler)
  {
    this.handler = paramPlatformViewsHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformViewsChannel
 * JD-Core Version:    0.7.0.1
 */