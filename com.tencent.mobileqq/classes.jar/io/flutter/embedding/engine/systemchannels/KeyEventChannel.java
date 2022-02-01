package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;

public class KeyEventChannel
{
  private static final String TAG = "KeyEventChannel";
  @NonNull
  public final BasicMessageChannel<Object> channel;
  private KeyEventChannel.EventResponseHandler eventResponseHandler;
  
  public KeyEventChannel(@NonNull BinaryMessenger paramBinaryMessenger)
  {
    this.channel = new BasicMessageChannel(paramBinaryMessenger, "flutter/keyevent", JSONMessageCodec.INSTANCE);
  }
  
  private void encodeKeyEvent(@NonNull KeyEventChannel.FlutterKeyEvent paramFlutterKeyEvent, @NonNull Map<String, Object> paramMap)
  {
    paramMap.put("flags", Integer.valueOf(paramFlutterKeyEvent.flags));
    paramMap.put("plainCodePoint", Integer.valueOf(paramFlutterKeyEvent.plainCodePoint));
    paramMap.put("codePoint", Integer.valueOf(paramFlutterKeyEvent.codePoint));
    paramMap.put("keyCode", Integer.valueOf(paramFlutterKeyEvent.keyCode));
    paramMap.put("scanCode", Integer.valueOf(paramFlutterKeyEvent.scanCode));
    paramMap.put("metaState", Integer.valueOf(paramFlutterKeyEvent.metaState));
    if (paramFlutterKeyEvent.complexCharacter != null) {
      paramMap.put("character", paramFlutterKeyEvent.complexCharacter.toString());
    }
    paramMap.put("source", Integer.valueOf(paramFlutterKeyEvent.source));
    paramMap.put("vendorId", Integer.valueOf(paramFlutterKeyEvent.vendorId));
    paramMap.put("productId", Integer.valueOf(paramFlutterKeyEvent.productId));
    paramMap.put("deviceId", Integer.valueOf(paramFlutterKeyEvent.deviceId));
    paramMap.put("repeatCount", Integer.valueOf(paramFlutterKeyEvent.repeatCount));
  }
  
  BasicMessageChannel.Reply<Object> createReplyHandler(long paramLong)
  {
    return new KeyEventChannel.1(this, paramLong);
  }
  
  public void keyDown(@NonNull KeyEventChannel.FlutterKeyEvent paramFlutterKeyEvent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "keydown");
    localHashMap.put("keymap", "android");
    encodeKeyEvent(paramFlutterKeyEvent, localHashMap);
    this.channel.send(localHashMap, createReplyHandler(paramFlutterKeyEvent.eventId));
  }
  
  public void keyUp(@NonNull KeyEventChannel.FlutterKeyEvent paramFlutterKeyEvent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "keyup");
    localHashMap.put("keymap", "android");
    encodeKeyEvent(paramFlutterKeyEvent, localHashMap);
    this.channel.send(localHashMap, createReplyHandler(paramFlutterKeyEvent.eventId));
  }
  
  public void setEventResponseHandler(KeyEventChannel.EventResponseHandler paramEventResponseHandler)
  {
    this.eventResponseHandler = paramEventResponseHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.KeyEventChannel
 * JD-Core Version:    0.7.0.1
 */