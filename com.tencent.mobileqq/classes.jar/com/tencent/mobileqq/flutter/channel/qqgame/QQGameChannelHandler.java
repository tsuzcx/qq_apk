package com.tencent.mobileqq.flutter.channel.qqgame;

import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;

public abstract class QQGameChannelHandler
  implements MethodChannel.MethodCallHandler
{
  public static final MethodCodec b = JSONMethodCodec.INSTANCE;
  
  protected abstract void a(MethodChannel.Result paramResult);
  
  protected abstract void a(Object paramObject, MethodChannel.Result paramResult);
  
  protected abstract void b(Object paramObject, MethodChannel.Result paramResult);
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    int i = str.hashCode();
    if (i != -165665114)
    {
      if (i != 111002744)
      {
        if ((i == 356076693) && (str.equals("getBaseInfo")))
        {
          i = 0;
          break label80;
        }
      }
      else if (str.equals("reportToAttaForDNFlutter"))
      {
        i = 2;
        break label80;
      }
    }
    else if (str.equals("reportByWebSSO"))
    {
      i = 1;
      break label80;
    }
    i = -1;
    label80:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          paramResult.notImplemented();
          return;
        }
        b(paramMethodCall.arguments, paramResult);
        return;
      }
      a(paramMethodCall.arguments, paramResult);
      return;
    }
    a(paramResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqgame.QQGameChannelHandler
 * JD-Core Version:    0.7.0.1
 */