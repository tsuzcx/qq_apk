package com.tencent.mobileqq.flutter.channel.relation;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import com.tencent.mobileqq.flutter.channel.model.CardCoverData;
import com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcClient;
import com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcClient.ICallback;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ZanRankingChannel
  extends BaseMethodChannel
  implements ZanRankingIpcClient.ICallback
{
  public static final AtomicInteger d = new AtomicInteger();
  private Map<Integer, MethodChannel.Result> e = new ConcurrentHashMap();
  
  public ZanRankingChannel()
  {
    ZanRankingIpcClient.a().b();
    ZanRankingIpcClient.a().a(this);
  }
  
  public String a()
  {
    return "com.tencent.qflutter/zanranking";
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean, CardCoverData paramCardCoverData)
  {
    QLog.d("ZanRankingChannel", 1, String.format("onGetCardCover seq=%d uin=%s fromCache=%b data=%s", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean), paramCardCoverData }));
    paramString = (MethodChannel.Result)this.e.remove(Integer.valueOf(paramInt));
    if (paramString == null) {
      return;
    }
    paramString = new ZanRankingChannel.2(this, paramString, paramCardCoverData);
    ThreadManager.getUIHandlerV2().post(paramString);
  }
  
  public MethodCodec b()
  {
    return ZanRankingChannelHandler.b;
  }
  
  public MethodChannel.MethodCallHandler c()
  {
    return new ZanRankingChannel.1(this);
  }
  
  public void f()
  {
    super.f();
    this.e.clear();
    ZanRankingIpcClient.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannel
 * JD-Core Version:    0.7.0.1
 */