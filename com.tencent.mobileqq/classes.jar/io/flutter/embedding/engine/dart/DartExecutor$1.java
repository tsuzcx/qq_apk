package io.flutter.embedding.engine.dart;

import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import io.flutter.plugin.common.StringCodec;
import java.nio.ByteBuffer;

class DartExecutor$1
  implements BinaryMessenger.BinaryMessageHandler
{
  DartExecutor$1(DartExecutor paramDartExecutor) {}
  
  public void onMessage(ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    DartExecutor.access$002(this.this$0, StringCodec.INSTANCE.decodeMessage(paramByteBuffer));
    if (DartExecutor.access$100(this.this$0) != null) {
      DartExecutor.access$100(this.this$0).onIsolateServiceIdAvailable(DartExecutor.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor.1
 * JD-Core Version:    0.7.0.1
 */