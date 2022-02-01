package io.flutter.embedding.engine.systemchannels;

import android.os.Bundle;
import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class TextInputChannel$1
  implements MethodChannel.MethodCallHandler
{
  TextInputChannel$1(TextInputChannel paramTextInputChannel) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (TextInputChannel.access$000(this.this$0) == null) {
      return;
    }
    Object localObject1 = paramMethodCall.method;
    paramMethodCall = paramMethodCall.arguments;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Received '");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("' message.");
    Log.v("TextInputChannel", ((StringBuilder)localObject2).toString());
    int i = -1;
    int k = ((String)localObject1).hashCode();
    int j = 0;
    switch (k)
    {
    default: 
      break;
    case 2113369584: 
      if (((String)localObject1).equals("TextInput.requestAutofill")) {
        i = 3;
      }
      break;
    case 1904427655: 
      if (((String)localObject1).equals("TextInput.clearClient")) {
        i = 7;
      }
      break;
    case 1727570905: 
      if (((String)localObject1).equals("TextInput.finishAutofillContext")) {
        i = 9;
      }
      break;
    case 1204752139: 
      if (((String)localObject1).equals("TextInput.setEditableSizeAndTransform")) {
        i = 6;
      }
      break;
    case 649192816: 
      if (((String)localObject1).equals("TextInput.sendAppPrivateCommand")) {
        i = 8;
      }
      break;
    case 270803918: 
      if (((String)localObject1).equals("TextInput.show")) {
        i = 0;
      }
      break;
    case 270476819: 
      if (((String)localObject1).equals("TextInput.hide")) {
        i = 1;
      }
      break;
    case -37561188: 
      if (((String)localObject1).equals("TextInput.setClient")) {
        i = 2;
      }
      break;
    case -1015421462: 
      if (((String)localObject1).equals("TextInput.setEditingState")) {
        i = 5;
      }
      break;
    case -1779068172: 
      if (((String)localObject1).equals("TextInput.setPlatformViewClient")) {
        i = 4;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramResult.notImplemented();
      return;
    case 9: 
      TextInputChannel.access$000(this.this$0).finishAutofillContext(((Boolean)paramMethodCall).booleanValue());
      break;
    }
    for (;;)
    {
      try
      {
        paramMethodCall = (JSONObject)paramMethodCall;
        localObject1 = paramMethodCall.getString("action");
        localObject2 = paramMethodCall.getString("data");
        if ((localObject2 == null) || (((String)localObject2).isEmpty())) {
          break label771;
        }
        paramMethodCall = new Bundle();
        paramMethodCall.putString("data", (String)localObject2);
        TextInputChannel.access$000(this.this$0).sendAppPrivateCommand((String)localObject1, paramMethodCall);
        paramResult.success(null);
        return;
      }
      catch (JSONException paramMethodCall)
      {
        double d1;
        double d2;
        paramMethodCall = paramMethodCall.getMessage();
        continue;
        i = ((Integer)paramMethodCall).intValue();
        TextInputChannel.access$000(this.this$0).setPlatformViewClient(i);
        return;
        TextInputChannel.access$000(this.this$0).requestAutofill();
        break label763;
        try
        {
          paramMethodCall = (JSONArray)paramMethodCall;
          i = paramMethodCall.getInt(0);
          paramMethodCall = paramMethodCall.getJSONObject(1);
          TextInputChannel.access$000(this.this$0).setClient(i, TextInputChannel.Configuration.fromJson(paramMethodCall));
          paramResult.success(null);
          return;
        }
        catch (NoSuchFieldException paramMethodCall) {}catch (JSONException paramMethodCall) {}
        paramMethodCall = paramMethodCall.getMessage();
        paramResult.error("error", paramMethodCall, null);
        return;
      }
      TextInputChannel.access$000(this.this$0).clearClient();
      break label763;
      paramMethodCall = (JSONObject)paramMethodCall;
      d1 = paramMethodCall.getDouble("width");
      d2 = paramMethodCall.getDouble("height");
      paramMethodCall = paramMethodCall.getJSONArray("transform");
      localObject1 = new double[16];
      i = j;
      if (i < 16)
      {
        localObject1[i] = paramMethodCall.getDouble(i);
        i += 1;
      }
      else
      {
        TextInputChannel.access$000(this.this$0).setEditableSizeAndTransform(d1, d2, (double[])localObject1);
        return;
        paramMethodCall = (JSONObject)paramMethodCall;
        TextInputChannel.access$000(this.this$0).setEditingState(TextInputChannel.TextEditState.fromJson(paramMethodCall));
        paramResult.success(null);
        return;
        TextInputChannel.access$000(this.this$0).hide();
        break label763;
        TextInputChannel.access$000(this.this$0).show();
        label763:
        paramResult.success(null);
        return;
        label771:
        paramMethodCall = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.1
 * JD-Core Version:    0.7.0.1
 */