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
    switch (((String)localObject1).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        return;
        if (((String)localObject1).equals("TextInput.requestAutofill"))
        {
          i = 3;
          continue;
          if (((String)localObject1).equals("TextInput.clearClient"))
          {
            i = 7;
            continue;
            if (((String)localObject1).equals("TextInput.finishAutofillContext"))
            {
              i = 9;
              continue;
              if (((String)localObject1).equals("TextInput.setEditableSizeAndTransform"))
              {
                i = 6;
                continue;
                if (((String)localObject1).equals("TextInput.sendAppPrivateCommand"))
                {
                  i = 8;
                  continue;
                  if (((String)localObject1).equals("TextInput.show"))
                  {
                    i = 0;
                    continue;
                    if (((String)localObject1).equals("TextInput.hide"))
                    {
                      i = 1;
                      continue;
                      if (((String)localObject1).equals("TextInput.setClient"))
                      {
                        i = 2;
                        continue;
                        if (((String)localObject1).equals("TextInput.setEditingState"))
                        {
                          i = 5;
                          continue;
                          if (((String)localObject1).equals("TextInput.setPlatformViewClient")) {
                            i = 4;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    TextInputChannel.access$000(this.this$0).finishAutofillContext(((Boolean)paramMethodCall).booleanValue());
    paramResult.success(null);
    return;
    for (;;)
    {
      try
      {
        paramMethodCall = (JSONObject)paramMethodCall;
        localObject1 = paramMethodCall.getString("action");
        localObject2 = paramMethodCall.getString("data");
        if ((localObject2 != null) && (!((String)localObject2).isEmpty()))
        {
          paramMethodCall = new Bundle();
          paramMethodCall.putString("data", (String)localObject2);
          TextInputChannel.access$000(this.this$0).sendAppPrivateCommand((String)localObject1, paramMethodCall);
          paramResult.success(null);
          return;
        }
      }
      catch (JSONException paramMethodCall)
      {
        paramResult.error("error", paramMethodCall.getMessage(), null);
        return;
      }
      paramMethodCall = null;
    }
    TextInputChannel.access$000(this.this$0).clearClient();
    paramResult.success(null);
    return;
    try
    {
      paramMethodCall = (JSONObject)paramMethodCall;
      double d1 = paramMethodCall.getDouble("width");
      double d2 = paramMethodCall.getDouble("height");
      paramMethodCall = paramMethodCall.getJSONArray("transform");
      localObject1 = new double[16];
      i = 0;
      while (i < 16)
      {
        localObject1[i] = paramMethodCall.getDouble(i);
        i += 1;
      }
      TextInputChannel.access$000(this.this$0).setEditableSizeAndTransform(d1, d2, (double[])localObject1);
      return;
    }
    catch (JSONException paramMethodCall)
    {
      paramResult.error("error", paramMethodCall.getMessage(), null);
      return;
    }
    try
    {
      paramMethodCall = (JSONObject)paramMethodCall;
      TextInputChannel.access$000(this.this$0).setEditingState(TextInputChannel.TextEditState.fromJson(paramMethodCall));
      paramResult.success(null);
      return;
    }
    catch (JSONException paramMethodCall)
    {
      paramResult.error("error", paramMethodCall.getMessage(), null);
      return;
    }
    i = ((Integer)paramMethodCall).intValue();
    TextInputChannel.access$000(this.this$0).setPlatformViewClient(i);
    return;
    TextInputChannel.access$000(this.this$0).requestAutofill();
    paramResult.success(null);
    return;
    try
    {
      paramMethodCall = (JSONArray)paramMethodCall;
      i = paramMethodCall.getInt(0);
      paramMethodCall = paramMethodCall.getJSONObject(1);
      TextInputChannel.access$000(this.this$0).setClient(i, TextInputChannel.Configuration.fromJson(paramMethodCall));
      paramResult.success(null);
      return;
    }
    catch (JSONException paramMethodCall)
    {
      paramResult.error("error", paramMethodCall.getMessage(), null);
      return;
      TextInputChannel.access$000(this.this$0).hide();
      paramResult.success(null);
      return;
      TextInputChannel.access$000(this.this$0).show();
      paramResult.success(null);
      return;
    }
    catch (NoSuchFieldException paramMethodCall)
    {
      label760:
      break label760;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.1
 * JD-Core Version:    0.7.0.1
 */