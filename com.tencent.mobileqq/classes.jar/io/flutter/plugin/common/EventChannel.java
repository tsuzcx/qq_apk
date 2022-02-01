package io.flutter.plugin.common;

import androidx.annotation.UiThread;

public final class EventChannel
{
  private static final String TAG = "EventChannel#";
  private final MethodCodec codec;
  private final BinaryMessenger messenger;
  private final String name;
  
  public EventChannel(BinaryMessenger paramBinaryMessenger, String paramString)
  {
    this(paramBinaryMessenger, paramString, StandardMethodCodec.INSTANCE);
  }
  
  public EventChannel(BinaryMessenger paramBinaryMessenger, String paramString, MethodCodec paramMethodCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMethodCodec;
  }
  
  @UiThread
  public void setStreamHandler(EventChannel.StreamHandler paramStreamHandler)
  {
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramStreamHandler == null) {}
    for (paramStreamHandler = null;; paramStreamHandler = new EventChannel.IncomingStreamRequestHandler(this, paramStreamHandler))
    {
      localBinaryMessenger.setMessageHandler(str, paramStreamHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.EventChannel
 * JD-Core Version:    0.7.0.1
 */