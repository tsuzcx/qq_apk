package io.flutter.plugin.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import java.nio.ByteBuffer;

public final class BasicMessageChannel<T>
{
  private static final String TAG = "BasicMessageChannel#";
  @NonNull
  private final MessageCodec<T> codec;
  @NonNull
  private final BinaryMessenger messenger;
  @NonNull
  private final String name;
  
  public BasicMessageChannel(@NonNull BinaryMessenger paramBinaryMessenger, @NonNull String paramString, @NonNull MessageCodec<T> paramMessageCodec)
  {
    this.messenger = paramBinaryMessenger;
    this.name = paramString;
    this.codec = paramMessageCodec;
  }
  
  public void send(@Nullable T paramT)
  {
    send(paramT, null);
  }
  
  @UiThread
  public void send(@Nullable T paramT, @Nullable BasicMessageChannel.Reply<T> paramReply)
  {
    Object localObject = null;
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    ByteBuffer localByteBuffer = this.codec.encodeMessage(paramT);
    if (paramReply == null) {}
    for (paramT = localObject;; paramT = new BasicMessageChannel.IncomingReplyHandler(this, paramReply, null))
    {
      localBinaryMessenger.send(str, localByteBuffer, paramT);
      return;
    }
  }
  
  @UiThread
  public void setMessageHandler(@Nullable BasicMessageChannel.MessageHandler<T> paramMessageHandler)
  {
    Object localObject = null;
    BinaryMessenger localBinaryMessenger = this.messenger;
    String str = this.name;
    if (paramMessageHandler == null) {}
    for (paramMessageHandler = localObject;; paramMessageHandler = new BasicMessageChannel.IncomingMessageHandler(this, paramMessageHandler, null))
    {
      localBinaryMessenger.setMessageHandler(str, paramMessageHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.common.BasicMessageChannel
 * JD-Core Version:    0.7.0.1
 */