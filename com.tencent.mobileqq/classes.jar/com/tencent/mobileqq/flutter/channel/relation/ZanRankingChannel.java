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
  public static final AtomicInteger a;
  private Map<Integer, MethodChannel.Result> a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public ZanRankingChannel()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    ZanRankingIpcClient.a().a();
    ZanRankingIpcClient.a().a(this);
  }
  
  public MethodChannel.MethodCallHandler a()
  {
    return new ZanRankingChannel.1(this);
  }
  
  public MethodCodec a()
  {
    return ZanRankingChannelHandler.a;
  }
  
  public String a()
  {
    return "com.tencent.qflutter/zanranking";
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaUtilMap.clear();
    ZanRankingIpcClient.a().b();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean, CardCoverData paramCardCoverData)
  {
    QLog.d("ZanRankingChannel", 1, String.format("onGetCardCover seq=%d uin=%s fromCache=%b data=%s", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean), paramCardCoverData }));
    paramString = (MethodChannel.Result)this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    if (paramString == null) {
      return;
    }
    paramString = new ZanRankingChannel.2(this, paramString, paramCardCoverData);
    ThreadManager.getUIHandlerV2().post(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannel
 * JD-Core Version:    0.7.0.1
 */