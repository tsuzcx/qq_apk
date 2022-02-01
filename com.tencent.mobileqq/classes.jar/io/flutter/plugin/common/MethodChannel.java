package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

public class MethodChannel
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
  public void invokeMethod(String paramString, @Nullable Object paramObject, @Nullable MethodChannel.Result paramResult)
  {
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    paramObject = this.codec.encodeMethodCall(new MethodCall(paramString, paramObject));
    if (paramResult == null) {
      paramString = null;
    } else {
      paramString = new MethodChannel.IncomingResultHandler(this, paramResult);
    }
    localBinaryMessenger.send(str, paramObject, paramString);
  }
  
  public void resizeChannelBuffer(int paramInt)
  {
    BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, paramInt);
  }
  
  @UiThread
  public void setMethodCallHandler(@Nullable MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramMethodCallHandler == null) {
      paramMethodCallHandler = null;
    } else {
      paramMethodCallHandler = new MethodChannel.IncomingMethodCallHandler(this, paramMethodCallHandler);
    }
    localBinaryMessenger.setMessageHandler(str, paramMethodCallHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.common.MethodChannel
 * JD-Core Version:    0.7.0.1
 */