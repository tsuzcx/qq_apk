package io.flutter.plugin.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

public final class MethodChannel
{
  private static final String TAG = "MethodChannel#";
  private final MethodCodec codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public MethodChannel(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    this(paramBinaryMessenger, paramString, StandardMethodCodec.INSTANCE);
  }
  
  public MethodChannel(BinaryMessenger paramBinaryMessenger, String paramString, MethodCodec paramMethodCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMethodCodec;
  }
  
  @UiThread
  public void invokeMethod(@NonNull String paramString, @Nullable Object paramObject)
  {
    invokeMethod(paramString, paramObject, null);
  }
  
  @UiThread
  public void invokeMethod(String paramString, @Nullable Object paramObject, MethodChannel.Result paramResult)
  {
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    paramObject = this.codec.encodeMethodCall(new MethodCall(paramString, paramObject));
    if (paramResult == null) {}
    for (paramString = null;; paramString = new MethodChannel.IncomingResultHandler(this, paramResult))
    {
      localBinaryMessenger.send(str, paramObject, paramString);
      return;
    }
  }
  
  @UiThread
  public void setMethodCallHandler(@Nullable MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramMethodCallHandler == null) {}
    for (paramMethodCallHandler = null;; paramMethodCallHandler = new MethodChannel.IncomingMethodCallHandler(this, paramMethodCallHandler))
    {
      localBinaryMessenger.setMessageHandler(str, paramMethodCallHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel
 * JD-Core Version:    0.7.0.1
 */