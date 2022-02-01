package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class TextInputChannel
{
  private static final String TAG = "TextInputChannel";
  @NonNull
  public final MethodChannel channel;
  private final MethodChannel.MethodCallHandler parsingMethodHandler = new TextInputChannel.1(this);
  @Nullable
  private TextInputChannel.TextInputMethodHandler textInputMethodHandler;
  
  public TextInputChannel(@NonNull DartExecutor paramDartExecutor)
  {
    this.channel = new MethodChannel(paramDartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
    this.channel.setMethodCallHandler(this.parsingMethodHandler);
  }
  
  public void done(int paramInt)
  {
    Log.v("TextInputChannel", "Sending 'done' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.done" }));
  }
  
  public void go(int paramInt)
  {
    Log.v("TextInputChannel", "Sending 'go' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.go" }));
  }
  
  public void newline(int paramInt)
  {
    Log.v("TextInputChannel", "Sending 'newline' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.newline" }));
  }
  
  public void next(int paramInt)
  {
    Log.v("TextInputChannel", "Sending 'next' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.next" }));
  }
  
  public void previous(int paramInt)
  {
    Log.v("TextInputChannel", "Sending 'previous' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.previous" }));
  }
  
  public void requestExistingInputState()
  {
    this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
  }
  
  public void search(int paramInt)
  {
    Log.v("TextInputChannel", "Sending 'search' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.search" }));
  }
  
  public void send(int paramInt)
  {
    Log.v("TextInputChannel", "Sending 'send' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.send" }));
  }
  
  public void setTextInputMethodHandler(@Nullable TextInputChannel.TextInputMethodHandler paramTextInputMethodHandler)
  {
    this.textInputMethodHandler = paramTextInputMethodHandler;
  }
  
  public void unspecifiedAction(int paramInt)
  {
    Log.v("TextInputChannel", "Sending 'unspecified' message.");
    this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), "TextInputAction.unspecified" }));
  }
  
  public void updateEditingState(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Sending message to update editing state: \nText: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("\nSelection start: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("\nSelection end: ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("\nComposing start: ");
    ((StringBuilder)localObject).append(paramInt4);
    ((StringBuilder)localObject).append("\nComposing end: ");
    ((StringBuilder)localObject).append(paramInt5);
    Log.v("TextInputChannel", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("text", paramString);
    ((HashMap)localObject).put("selectionBase", Integer.valueOf(paramInt2));
    ((HashMap)localObject).put("selectionExtent", Integer.valueOf(paramInt3));
    ((HashMap)localObject).put("composingBase", Integer.valueOf(paramInt4));
    ((HashMap)localObject).put("composingExtent", Integer.valueOf(paramInt5));
    this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt1), localObject }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel
 * JD-Core Version:    0.7.0.1
 */