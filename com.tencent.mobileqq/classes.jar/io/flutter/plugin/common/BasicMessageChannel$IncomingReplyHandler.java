package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

final class BasicMessageChannel$IncomingReplyHandler
  implements BinaryMessenger.BinaryReply
{
  private final BasicMessageChannel.Reply<T> callback;
  
  private BasicMessageChannel$IncomingReplyHandler(@NonNull BasicMessageChannel.Reply<T> paramReply)
  {
    Object localObject;
    this.callback = localObject;
  }
  
  public void reply(@Nullable ByteBuffer paramByteBuffer)
  {
    try
    {
      this.callback.reply(BasicMessageChannel.access$200(this.this$0).decodeMessage(paramByteBuffer));
      return;
    }
    catch (RuntimeException paramByteBuffer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BasicMessageChannel#");
      localStringBuilder.append(BasicMessageChannel.access$300(this.this$0));
      Log.e(localStringBuilder.toString(), "Failed to handle message reply", paramByteBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.common.BasicMessageChannel.IncomingReplyHandler
 * JD-Core Version:    0.7.0.1
 */