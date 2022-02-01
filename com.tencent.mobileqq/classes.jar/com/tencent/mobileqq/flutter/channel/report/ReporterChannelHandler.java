package com.tencent.mobileqq.flutter.channel.report;

import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;

public abstract class ReporterChannelHandler
  implements MethodChannel.MethodCallHandler
{
  public static final MethodCodec a = StandardMethodCodec.INSTANCE;
  
  protected abstract void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString5, String paramString6, Boolean paramBoolean, MethodChannel.Result paramResult);
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    QLog.d("flutter.ReporterChannel", 1, String.format("onMethodCall methodName=%s", new Object[] { str }));
    if ("report".equals(str))
    {
      a(((Integer)paramMethodCall.argument("tableTarget")).intValue(), (String)paramMethodCall.argument("opUin"), (String)paramMethodCall.argument("targetUin"), (String)paramMethodCall.argument("opType"), (String)paramMethodCall.argument("opName"), (Integer)paramMethodCall.argument("entry"), (Integer)paramMethodCall.argument("reserved1"), (Integer)paramMethodCall.argument("reserved2"), (String)paramMethodCall.argument("reserved3"), (String)paramMethodCall.argument("reserved4"), (Boolean)paramMethodCall.argument("immediate"), paramResult);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.report.ReporterChannelHandler
 * JD-Core Version:    0.7.0.1
 */