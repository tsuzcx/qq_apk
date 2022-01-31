package io.flutter.embedding.engine.systemchannels;

import android.support.annotation.NonNull;
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
    String str = paramMethodCall.method;
    paramMethodCall = paramMethodCall.arguments;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Received '");
    localStringBuilder.append(str);
    localStringBuilder.append("' message.");
    Log.v("TextInputChannel", localStringBuilder.toString());
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        return;
        if (str.equals("TextInput.clearClient"))
        {
          i = 5;
          continue;
          if (str.equals("TextInput.show"))
          {
            i = 0;
            continue;
            if (str.equals("TextInput.hide"))
            {
              i = 1;
              continue;
              if (str.equals("TextInput.setClient"))
              {
                i = 2;
                continue;
                if (str.equals("TextInput.setEditingState"))
                {
                  i = 4;
                  continue;
                  if (str.equals("TextInput.setPlatformViewClient")) {
                    i = 3;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    TextInputChannel.access$000(this.this$0).clearClient();
    paramResult.success(null);
    return;
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
      label398:
      break label398;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.1
 * JD-Core Version:    0.7.0.1
 */