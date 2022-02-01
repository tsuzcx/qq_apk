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
    if (i != 102230) {
      if (i != 111375) {
        label29:
        i = -1;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramResult.notImplemented();
        return;
        if (!str.equals("put")) {
          break label29;
        }
        i = 0;
        continue;
        if (!str.equals("get")) {
          break label29;
        }
        i = 1;
      }
    }
    RestorationChannel.access$102(this.this$0, true);
    if ((RestorationChannel.access$200(this.this$0)) || (!this.this$0.waitForRestorationData))
    {
      paramResult.success(RestorationChannel.access$300(this.this$0, RestorationChannel.access$000(this.this$0)));
      return;
    }
    RestorationChannel.access$402(this.this$0, paramResult);
    return;
    RestorationChannel.access$002(this.this$0, (byte[])paramMethodCall);
    paramResult.success(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.RestorationChannel.2
 * JD-Core Version:    0.7.0.1
 */