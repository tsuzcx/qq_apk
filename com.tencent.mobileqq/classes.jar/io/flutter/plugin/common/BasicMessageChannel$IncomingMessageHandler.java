package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

final class BasicMessageChannel$IncomingMessageHandler
  implements BinaryMessenger.BinaryMessageHandler
{
  private final BasicMessageChannel.MessageHandler<T> handler;
  
  private BasicMessageChannel$IncomingMessageHandler(@NonNull BasicMessageChannel.MessageHandler<T> paramMessageHandler)
  {
    Object localObject;
    this.handler = localObject;
  }
  
  public void onMessage(@Nullable ByteBuffer paramByteBuffer, @NonNull BinaryMessenger.BinaryReply paramBinaryReply)
  {
    try
    {
      this.handler.onMessage(BasicMessageChannel.access$200(this.this$0).decodeMessage(paramByteBuffer), new BasicMessageChannel.IncomingMessageHandler.1(this, paramBinaryReply));
      return;
    }
    catch (RuntimeException paramByteBuffer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicMessageChannel#");
      localStringBuilder.append(BasicMessageChannel.access$300(this.this$0));
      Log.e(localStringBuilder.toString(), "Failed to handle message", paramByteBuffer);
      paramBinaryReply.reply(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.BasicMessageChannel.IncomingMessageHandler
 * JD-Core Version:    0.7.0.1
 */