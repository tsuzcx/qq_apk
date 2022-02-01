package com.tencent.mobileqq.flutter.channel.relation;

import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.ArrayList;

public abstract class ZanRankingChannelHandler
  implements MethodChannel.MethodCallHandler
{
  public static final MethodCodec b = StandardMethodCodec.INSTANCE;
  
  protected abstract void a(String paramString, MethodChannel.Result paramResult);
  
  protected abstract void a(ArrayList<String> paramArrayList, MethodChannel.Result paramResult);
  
  protected abstract void b(String paramString, MethodChannel.Result paramResult);
  
  protected abstract void c(String paramString, MethodChannel.Result paramResult);
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    QLog.d("flutter.ZanRankingChannel", 1, String.format("onMethodCall methodName=%s", new Object[] { str }));
    if ("getCoverFromCacheCard".equals(str))
    {
      a((String)paramMethodCall.argument("uin"), paramResult);
      return;
    }
    if ("getCoverFromSvrCard".equals(str))
    {
      b((String)paramMethodCall.argument("uin"), paramResult);
      return;
    }
    if ("getFriendsNickDict".equals(str))
    {
      a((ArrayList)paramMethodCall.argument("uinList"), paramResult);
      return;
    }
    if ("jumpToSummaryCard".equals(str))
    {
      c((String)paramMethodCall.argument("uin"), paramResult);
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannelHandler
 * JD-Core Version:    0.7.0.1
 */