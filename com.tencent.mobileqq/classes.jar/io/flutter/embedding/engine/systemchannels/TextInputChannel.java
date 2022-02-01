package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
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
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

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
  
  private static HashMap<Object, Object> createEditingStateJSON(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("text", paramString);
    localHashMap.put("selectionBase", Integer.valueOf(paramInt1));
    localHashMap.put("selectionExtent", Integer.valueOf(paramInt2));
    localHashMap.put("composingBase", Integer.valueOf(paramInt3));
    localHashMap.put("composingExtent", Integer.valueOf(paramInt4));
    return localHashMap;
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
  
  public void performPrivateCommand(int paramInt, String paramString, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("action", paramString);
    if (paramBundle != null)
    {
      paramString = new HashMap();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramBundle.get(str);
        if ((localObject instanceof byte[])) {
          paramString.put(str, paramBundle.getByteArray(str));
        } else if ((localObject instanceof Byte)) {
          paramString.put(str, Byte.valueOf(paramBundle.getByte(str)));
        } else if ((localObject instanceof char[])) {
          paramString.put(str, paramBundle.getCharArray(str));
        } else if ((localObject instanceof Character)) {
          paramString.put(str, Character.valueOf(paramBundle.getChar(str)));
        } else if ((localObject instanceof CharSequence[])) {
          paramString.put(str, paramBundle.getCharSequenceArray(str));
        } else if ((localObject instanceof CharSequence)) {
          paramString.put(str, paramBundle.getCharSequence(str));
        } else if ((localObject instanceof float[])) {
          paramString.put(str, paramBundle.getFloatArray(str));
        } else if ((localObject instanceof Float)) {
          paramString.put(str, Float.valueOf(paramBundle.getFloat(str)));
        }
      }
      localHashMap.put("data", paramString);
    }
    this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), localHashMap }));
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sending message to update editing state: \nText: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\nSelection start: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("\nSelection end: ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("\nComposing start: ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("\nComposing end: ");
    localStringBuilder.append(paramInt5);
    Log.v("TextInputChannel", localStringBuilder.toString());
    paramString = createEditingStateJSON(paramString, paramInt2, paramInt3, paramInt4, paramInt5);
    this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt1), paramString }));
  }
  
  public void updateEditingStateWithTag(int paramInt, HashMap<String, TextInputChannel.TextEditState> paramHashMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Sending message to update editing state for ");
    ((StringBuilder)localObject).append(String.valueOf(paramHashMap.size()));
    ((StringBuilder)localObject).append(" field(s).");
    Log.v("TextInputChannel", ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      TextInputChannel.TextEditState localTextEditState = (TextInputChannel.TextEditState)localEntry.getValue();
      ((HashMap)localObject).put(localEntry.getKey(), createEditingStateJSON(localTextEditState.text, localTextEditState.selectionStart, localTextEditState.selectionEnd, -1, -1));
    }
    this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(new Serializable[] { Integer.valueOf(paramInt), localObject }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel
 * JD-Core Version:    0.7.0.1
 */