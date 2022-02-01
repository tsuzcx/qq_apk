package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class RestorationChannel$2
  implements MethodChannel.MethodCallHandler
{
  RestorationChannel$2(RestorationChannel paramRestorationChannel) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    paramMethodCall = paramMethodCall.arguments;
    int i = str.hashCode();
    if (i != 102230)
    {
      if ((i == 111375) && (str.equals("put")))
      {
        i = 0;
        break label64;
      }
    }
    else if (str.equals("get"))
    {
      i = 1;
      break label64;
    }
    i = -1;
    label64:
    if (i != 0)
    {
      if (i != 1)
      {
        paramResult.notImplemented();
        return;
      }
      RestorationChannel.access$102(this.this$0, true);
      if ((!RestorationChannel.access$200(this.this$0)) && (this.this$0.waitForRestorationData))
      {
        RestorationChannel.access$402(this.this$0, paramResult);
        return;
      }
      paramMethodCall = this.this$0;
      paramMethodCall = RestorationChannel.access$300(paramMethodCall, RestorationChannel.access$000(paramMethodCall));
    }
    else
    {
      RestorationChannel.access$002(this.this$0, (byte[])paramMethodCall);
      paramMethodCall = null;
    }
    paramResult.success(paramMethodCall);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.RestorationChannel.2
 * JD-Core Version:    0.7.0.1
 */