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
        paramResult.notImplemented();
        return;
      }
    }
    catch (JSONException paramMethodCall)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON error: ");
      ((StringBuilder)localObject).append(paramMethodCall.getMessage());
      paramResult.error("error", ((StringBuilder)localObject).toString(), null);
      return;
    }
    if (((String)localObject).equals("SystemChrome.setPreferredOrientations"))
    {
      i = 2;
      break label986;
      if (((String)localObject).equals("SystemChrome.setEnabledSystemUIOverlays"))
      {
        i = 4;
        break label986;
        if (((String)localObject).equals("Clipboard.getData"))
        {
          i = 10;
          break label986;
          if (((String)localObject).equals("SystemChrome.setSystemUIOverlayStyle"))
          {
            i = 6;
            break label986;
            if (((String)localObject).equals("SystemChrome.restoreSystemUIOverlays"))
            {
              i = 5;
              break label986;
              if (((String)localObject).equals("SystemGestures.setSystemGestureExclusionRects"))
              {
                i = 9;
                break label986;
                if (((String)localObject).equals("SystemGestures.getSystemGestureExclusionRects"))
                {
                  i = 8;
                  break label986;
                  if (((String)localObject).equals("SystemSound.play"))
                  {
                    i = 0;
                    break label986;
                    if (((String)localObject).equals("HapticFeedback.vibrate"))
                    {
                      i = 1;
                      break label986;
                      if (((String)localObject).equals("SystemChrome.setApplicationSwitcherDescription"))
                      {
                        i = 3;
                        break label986;
                        if (((String)localObject).equals("Clipboard.setData"))
                        {
                          i = 11;
                          break label986;
                          if (((String)localObject).equals("SystemNavigator.pop"))
                          {
                            i = 7;
                            break label986;
                            paramMethodCall = ((JSONObject)paramMethodCall).getString("text");
                            PlatformChannel.access$000(this.this$0).setClipboardData(paramMethodCall);
                            paramResult.success(null);
                            return;
                            localObject = (String)paramMethodCall;
                            if (localObject == null) {
                              break label1051;
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
        }
      }
    }
    for (;;)
    {
      try
      {
        paramMethodCall = PlatformChannel.ClipboardContentFormat.fromValue((String)localObject);
        paramMethodCall = PlatformChannel.access$000(this.this$0).getClipboardData(paramMethodCall);
        if (paramMethodCall != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("text", paramMethodCall);
          paramResult.success(localObject);
          return;
        }
      }
      catch (NoSuchFieldException paramMethodCall)
      {
        paramMethodCall = new StringBuilder();
        paramMethodCall.append("No such clipboard content format: ");
        paramMethodCall.append((String)localObject);
        paramResult.error("error", paramMethodCall.toString(), null);
      }
      paramResult.success(null);
      return;
      if (!(paramMethodCall instanceof JSONArray))
      {
        paramResult.error("inputTypeError", "Input type is incorrect. Ensure that a List<Map<String, int>> is passed as the input for SystemGestureExclusionRects.setSystemGestureExclusionRects.", null);
        return;
      }
      paramMethodCall = (JSONArray)paramMethodCall;
      paramMethodCall = PlatformChannel.access$600(this.this$0, paramMethodCall);
      PlatformChannel.access$000(this.this$0).setSystemGestureExclusionRects(paramMethodCall);
      paramResult.success(null);
      return;
      paramMethodCall = PlatformChannel.access$000(this.this$0).getSystemGestureExclusionRects();
      if (paramMethodCall == null)
      {
        paramResult.error("error", "Exclusion rects only exist for Android API 29+.", null);
        return;
      }
      paramResult.success(PlatformChannel.access$500(this.this$0, paramMethodCall));
      return;
      PlatformChannel.access$000(this.this$0).popSystemNavigator();
      paramResult.success(null);
      return;
      try
      {
        paramMethodCall = PlatformChannel.access$400(this.this$0, (JSONObject)paramMethodCall);
        PlatformChannel.access$000(this.this$0).setSystemUiOverlayStyle(paramMethodCall);
        paramResult.success(null);
        return;
      }
      catch (JSONException paramMethodCall)
      {
        paramResult.error("error", paramMethodCall.getMessage(), null);
        return;
        PlatformChannel.access$000(this.this$0).restoreSystemUiOverlays();
        paramResult.success(null);
        return;
        try
        {
          paramMethodCall = PlatformChannel.access$300(this.this$0, (JSONArray)paramMethodCall);
          PlatformChannel.access$000(this.this$0).showSystemOverlays(paramMethodCall);
          paramResult.success(null);
          return;
        }
        catch (JSONException paramMethodCall)
        {
          paramResult.error("error", paramMethodCall.getMessage(), null);
          return;
          try
          {
            paramMethodCall = PlatformChannel.access$200(this.this$0, (JSONObject)paramMethodCall);
            PlatformChannel.access$000(this.this$0).setApplicationSwitcherDescription(paramMethodCall);
            paramResult.success(null);
            return;
          }
          catch (JSONException paramMethodCall)
          {
            paramResult.error("error", paramMethodCall.getMessage(), null);
            return;
          }
          try
          {
            i = PlatformChannel.access$100(this.this$0, (JSONArray)paramMethodCall);
            PlatformChannel.access$000(this.this$0).setPreferredOrientations(i);
            paramResult.success(null);
            return;
          }
          catch (JSONException paramMethodCall)
          {
            paramResult.error("error", paramMethodCall.getMessage(), null);
            return;
            try
            {
              paramMethodCall = PlatformChannel.HapticFeedbackType.fromValue((String)paramMethodCall);
              PlatformChannel.access$000(this.this$0).vibrateHapticFeedback(paramMethodCall);
              paramResult.success(null);
              return;
            }
            catch (NoSuchFieldException paramMethodCall)
            {
              paramResult.error("error", paramMethodCall.getMessage(), null);
              return;
            }
            try
            {
              paramMethodCall = PlatformChannel.SoundType.fromValue((String)paramMethodCall);
              PlatformChannel.access$000(this.this$0).playSystemSound(paramMethodCall);
              paramResult.success(null);
              return;
            }
            catch (NoSuchFieldException paramMethodCall)
            {
              paramResult.error("error", paramMethodCall.getMessage(), null);
              return;
            }
          }
          catch (NoSuchFieldException paramMethodCall)
          {
            break label872;
          }
        }
        catch (NoSuchFieldException paramMethodCall)
        {
          label776:
          break label776;
        }
      }
      catch (NoSuchFieldException paramMethodCall)
      {
        label708:
        label872:
        break label708;
      }
      label986:
      switch (i)
      {
      }
      break;
      label1051:
      paramMethodCall = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.PlatformChannel.1
 * JD-Core Version:    0.7.0.1
 */