package com.tencent.mobileqq.flutter.channel.qqgame;

import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;

public abstract class QQGameChannelHandler
  implements MethodChannel.MethodCallHandler
{
  public static final MethodCodec a = JSONMethodCodec.INSTANCE;
  
  protected abstract void a(MethodChannel.Result paramResult);
  
  protected abstract void a(Object paramObject, MethodChannel.Result paramResult);
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    int i = str.hashCode();
    if (i != -165665114)
    {
      if ((i == 356076693) && (str.equals("getBaseInfo")))
      {
        i = 0;
        break label59;
      }
    }
    else if (str.equals("reportByWebSSO"))
    {
      i = 1;
      break label59;
    }
    i = -1;
    label59:
    if (i != 0)
    {
      if (i != 1)
      {
        paramResult.notImplemented();
        return;
      }
      a(paramMethodCall.arguments, paramResult);
      return;
    }
    a(paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqgame.QQGameChannelHandler
 * JD-Core Version:    0.7.0.1
 */