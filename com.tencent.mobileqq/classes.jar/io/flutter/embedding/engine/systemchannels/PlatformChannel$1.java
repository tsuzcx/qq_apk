package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class PlatformChannel$1
  implements MethodChannel.MethodCallHandler
{
  PlatformChannel$1(PlatformChannel paramPlatformChannel) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (PlatformChannel.access$000(this.this$0) == null) {
      return;
    }
    Object localObject = paramMethodCall.method;
    paramMethodCall = paramMethodCall.arguments;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Received '");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("' message.");
    Log.v("PlatformChannel", localStringBuilder.toString());
    int i = -1;
    try
    {
      switch (((String)localObject).hashCode())
      {
      case 2119655719: 
        if (((String)localObject).equals("SystemChrome.setPreferredOrientations")) {
          i = 2;
        }
        break;
      case 1674312266: 
        if (((String)localObject).equals("SystemChrome.setEnabledSystemUIOverlays")) {
          i = 4;
        }
        break;
      case 1514180520: 
        if (((String)localObject).equals("Clipboard.getData")) {
          i = 8;
        }
        break;
      case 1390477857: 
        if (((String)localObject).equals("SystemChrome.setSystemUIOverlayStyle")) {
          i = 6;
        }
        break;
      case 875995648: 
        if (((String)localObject).equals("Clipboard.hasStrings")) {
          i = 10;
        }
        break;
      case 241845679: 
        if (((String)localObject).equals("SystemChrome.restoreSystemUIOverlays")) {
          i = 5;
        }
        break;
      case -215273374: 
        if (((String)localObject).equals("SystemSound.play")) {
          i = 0;
        }
        break;
      case -247230243: 
        if (((String)localObject).equals("HapticFeedback.vibrate")) {
          i = 1;
        }
        break;
      case -548468504: 
        if (((String)localObject).equals("SystemChrome.setApplicationSwitcherDescription")) {
          i = 3;
        }
        break;
      case -720677196: 
        if (((String)localObject).equals("Clipboard.setData")) {
          i = 9;
        }
        break;
      case -766342101: 
        boolean bool = ((String)localObject).equals("SystemNavigator.pop");
        if (bool) {
          i = 7;
        }
        switch (i)
        {
        default: 
          paramResult.notImplemented();
          return;
        case 10: 
          bool = PlatformChannel.access$000(this.this$0).clipboardHasStrings();
          paramMethodCall = new JSONObject();
          paramMethodCall.put("value", bool);
          paramResult.success(paramMethodCall);
          return;
        case 9: 
          paramMethodCall = ((JSONObject)paramMethodCall).getString("text");
          PlatformChannel.access$000(this.this$0).setClipboardData(paramMethodCall);
          paramResult.success(null);
          return;
        case 8: 
          label473:
          localObject = (String)paramMethodCall;
          if (localObject == null) {
            break label928;
          }
        }
        break;
      }
    }
    catch (JSONException paramMethodCall)
    {
      label501:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON error: ");
      ((StringBuilder)localObject).append(paramMethodCall.getMessage());
      paramResult.error("error", ((StringBuilder)localObject).toString(), null);
      return;
    }
    try
    {
      paramMethodCall = PlatformChannel.ClipboardContentFormat.fromValue((String)localObject);
    }
    catch (NoSuchFieldException paramMethodCall)
    {
      break label501;
    }
    paramMethodCall = new StringBuilder();
    paramMethodCall.append("No such clipboard content format: ");
    paramMethodCall.append((String)localObject);
    paramResult.error("error", paramMethodCall.toString(), null);
    for (;;)
    {
      paramMethodCall = PlatformChannel.access$000(this.this$0).getClipboardData(paramMethodCall);
      if (paramMethodCall == null) {
        break label473;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("text", paramMethodCall);
      paramResult.success(localObject);
      return;
      PlatformChannel.access$000(this.this$0).popSystemNavigator();
      break label473;
      try
      {
        paramMethodCall = PlatformChannel.access$400(this.this$0, (JSONObject)paramMethodCall);
        PlatformChannel.access$000(this.this$0).setSystemUiOverlayStyle(paramMethodCall);
        paramResult.success(null);
        return;
      }
      catch (NoSuchFieldException paramMethodCall) {}catch (JSONException paramMethodCall) {}
      paramMethodCall = paramMethodCall.getMessage();
      for (;;)
      {
        paramResult.error("error", paramMethodCall, null);
        return;
        PlatformChannel.access$000(this.this$0).restoreSystemUiOverlays();
        break;
        try
        {
          paramMethodCall = PlatformChannel.access$300(this.this$0, (JSONArray)paramMethodCall);
          PlatformChannel.access$000(this.this$0).showSystemOverlays(paramMethodCall);
          paramResult.success(null);
          return;
        }
        catch (NoSuchFieldException paramMethodCall) {}catch (JSONException paramMethodCall) {}
        paramMethodCall = paramMethodCall.getMessage();
        continue;
        try
        {
          paramMethodCall = PlatformChannel.access$200(this.this$0, (JSONObject)paramMethodCall);
          PlatformChannel.access$000(this.this$0).setApplicationSwitcherDescription(paramMethodCall);
          paramResult.success(null);
          return;
        }
        catch (JSONException paramMethodCall)
        {
          paramMethodCall = paramMethodCall.getMessage();
        }
        continue;
        try
        {
          i = PlatformChannel.access$100(this.this$0, (JSONArray)paramMethodCall);
          PlatformChannel.access$000(this.this$0).setPreferredOrientations(i);
          paramResult.success(null);
          return;
        }
        catch (NoSuchFieldException paramMethodCall) {}catch (JSONException paramMethodCall) {}
        paramMethodCall = paramMethodCall.getMessage();
        continue;
        try
        {
          paramMethodCall = PlatformChannel.HapticFeedbackType.fromValue((String)paramMethodCall);
          PlatformChannel.access$000(this.this$0).vibrateHapticFeedback(paramMethodCall);
          paramResult.success(null);
          return;
        }
        catch (NoSuchFieldException paramMethodCall)
        {
          paramMethodCall = paramMethodCall.getMessage();
        }
        continue;
        try
        {
          paramMethodCall = PlatformChannel.SoundType.fromValue((String)paramMethodCall);
          PlatformChannel.access$000(this.this$0).playSystemSound(paramMethodCall);
          paramResult.success(null);
          return;
        }
        catch (NoSuchFieldException paramMethodCall)
        {
          paramMethodCall = paramMethodCall.getMessage();
        }
      }
      break;
      label928:
      paramMethodCall = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel.1
 * JD-Core Version:    0.7.0.1
 */