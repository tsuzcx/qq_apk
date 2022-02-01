package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;

class MouseCursorChannel$1
  implements MethodChannel.MethodCallHandler
{
  MouseCursorChannel$1(MouseCursorChannel paramMouseCursorChannel) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if (MouseCursorChannel.access$000(this.this$0) == null) {
      return;
    }
    Object localObject = paramMethodCall.method;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Received '");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("' message.");
    Log.v("MouseCursorChannel", localStringBuilder.toString());
    int i = -1;
    do
    {
      try
      {
        if ((((String)localObject).hashCode() != -1307105544) || (!((String)localObject).equals("activateSystemCursor"))) {
          continue;
        }
        i = 0;
      }
      catch (Exception paramMethodCall)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unhandled error: ");
        ((StringBuilder)localObject).append(paramMethodCall.getMessage());
        paramResult.error("error", ((StringBuilder)localObject).toString(), null);
        return;
      }
      paramMethodCall = (String)((HashMap)paramMethodCall.arguments).get("kind");
      try
      {
        MouseCursorChannel.access$000(this.this$0).activateSystemCursor(paramMethodCall);
        paramResult.success(Boolean.valueOf(true));
        return;
      }
      catch (Exception paramMethodCall)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Error when setting cursors: ");
        ((StringBuilder)localObject).append(paramMethodCall.getMessage());
        paramResult.error("error", ((StringBuilder)localObject).toString(), null);
        return;
      }
    } while (i == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.MouseCursorChannel.1
 * JD-Core Version:    0.7.0.1
 */