package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;

public class KeyEventChannel
{
  @NonNull
  public final BasicMessageChannel<Object> channel;
  
  public KeyEventChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/keyevent", JSONMessageCodec.INSTANCE);
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
  }
  
  public void keyDown(@NonNull KeyEventChannel.FlutterKeyEvent paramFlutterKeyEvent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "keydown");
    localHashMap.put("keymap", "android");
    encodeKeyEvent(paramFlutterKeyEvent, localHashMap);
    this.channel.send(localHashMap);
  }
  
  public void keyUp(@NonNull KeyEventChannel.FlutterKeyEvent paramFlutterKeyEvent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "keyup");
    localHashMap.put("keymap", "android");
    encodeKeyEvent(paramFlutterKeyEvent, localHashMap);
    this.channel.send(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.KeyEventChannel
 * JD-Core Version:    0.7.0.1
 */