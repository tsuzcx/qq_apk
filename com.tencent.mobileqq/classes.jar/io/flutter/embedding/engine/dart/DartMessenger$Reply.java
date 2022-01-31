package io.flutter.embedding.engine.dart;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

class DartMessenger$Reply
  implements BinaryMessenger.BinaryReply
{
  private final AtomicBoolean done = new AtomicBoolean(false);
  @NonNull
  private final FlutterJNI flutterJNI;
  private final int replyId;
  
  DartMessenger$Reply(@NonNull FlutterJNI paramFlutterJNI, int paramInt)
  {
    this.flutterJNI = paramFlutterJNI;
    this.replyId = paramInt;
  }
  
  public void reply(@Nullable ByteBuffer paramByteBuffer)
  {
    if (!this.done.getAndSet(true))
    {
      if (paramByteBuffer == null)
      {
        this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
        return;
      }
      this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, paramByteBuffer, paramByteBuffer.position());
      return;
    }
    throw new IllegalStateException("Reply already submitted");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartMessenger.Reply
 * JD-Core Version:    0.7.0.1
 */