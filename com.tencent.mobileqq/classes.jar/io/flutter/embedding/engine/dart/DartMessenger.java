package io.flutter.embedding.engine.dart;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

class DartMessenger
  implements PlatformMessageHandler, BinaryMessenger
{
  private static final String TAG = "DartMessenger";
  @NonNull
  private final FlutterJNI flutterJNI;
  @NonNull
  private final Map<String, BinaryMessenger.BinaryMessageHandler> messageHandlers;
  private int nextReplyId = 1;
  @NonNull
  private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;
  
  DartMessenger(@NonNull FlutterJNI paramFlutterJNI)
  {
    this.flutterJNI = paramFlutterJNI;
    this.messageHandlers = new HashMap();
    this.pendingReplies = new HashMap();
  }
  
  @UiThread
  public int getPendingChannelResponseCount()
  {
    return this.pendingReplies.size();
  }
  
  public void handleMessageFromDart(@NonNull String paramString, @Nullable byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Received message from Dart over channel '");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("'");
    Log.v("DartMessenger", ((StringBuilder)localObject).toString());
    localObject = (BinaryMessenger.BinaryMessageHandler)this.messageHandlers.get(paramString);
    if (localObject != null) {
      try
      {
        Log.v("DartMessenger", "Deferring to registered handler to process message.");
        if (paramArrayOfByte == null) {}
        for (paramString = null;; paramString = ByteBuffer.wrap(paramArrayOfByte))
        {
          ((BinaryMessenger.BinaryMessageHandler)localObject).onMessage(paramString, new DartMessenger.Reply(this.flutterJNI, paramInt));
          return;
        }
        Log.v("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
      }
      catch (Exception paramString)
      {
        Log.e("DartMessenger", "Uncaught exception in binary message listener", paramString);
        this.flutterJNI.invokePlatformMessageEmptyResponseCallback(paramInt);
        return;
      }
    }
    this.flutterJNI.invokePlatformMessageEmptyResponseCallback(paramInt);
  }
  
  public void handlePlatformMessageResponse(int paramInt, @Nullable byte[] paramArrayOfByte)
  {
    Log.v("DartMessenger", "Received message reply from Dart.");
    BinaryMessenger.BinaryReply localBinaryReply = (BinaryMessenger.BinaryReply)this.pendingReplies.remove(Integer.valueOf(paramInt));
    if (localBinaryReply != null) {
      try
      {
        Log.v("DartMessenger", "Invoking registered callback for reply from Dart.");
        if (paramArrayOfByte == null) {}
        for (paramArrayOfByte = null;; paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte))
        {
          localBinaryReply.reply(paramArrayOfByte);
          return;
        }
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("DartMessenger", "Uncaught exception in binary message reply handler", paramArrayOfByte);
      }
    }
  }
  
  @UiThread
  public void send(@NonNull String paramString, @NonNull ByteBuffer paramByteBuffer)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sending message over channel '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    Log.v("DartMessenger", localStringBuilder.toString());
    send(paramString, paramByteBuffer, null);
  }
  
  public void send(@NonNull String paramString, @Nullable ByteBuffer paramByteBuffer, @Nullable BinaryMessenger.BinaryReply paramBinaryReply)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sending message with callback over channel '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    Log.v("DartMessenger", localStringBuilder.toString());
    int i;
    if (paramBinaryReply != null)
    {
      i = this.nextReplyId;
      this.nextReplyId = (i + 1);
      this.pendingReplies.put(Integer.valueOf(i), paramBinaryReply);
    }
    while (paramByteBuffer == null)
    {
      this.flutterJNI.dispatchEmptyPlatformMessage(paramString, i);
      return;
      i = 0;
    }
    this.flutterJNI.dispatchPlatformMessage(paramString, paramByteBuffer, paramByteBuffer.position(), i);
  }
  
  public void setMessageHandler(@NonNull String paramString, @Nullable BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    if (paramBinaryMessageHandler == null)
    {
      paramBinaryMessageHandler = new StringBuilder();
      paramBinaryMessageHandler.append("Removing handler for channel '");
      paramBinaryMessageHandler.append(paramString);
      paramBinaryMessageHandler.append("'");
      Log.v("DartMessenger", paramBinaryMessageHandler.toString());
      this.messageHandlers.remove(paramString);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Setting handler for channel '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    Log.v("DartMessenger", localStringBuilder.toString());
    this.messageHandlers.put(paramString, paramBinaryMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartMessenger
 * JD-Core Version:    0.7.0.1
 */