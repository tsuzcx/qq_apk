package com.tencent.mobileqq.flutter.channel.relation;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcClient;
import com.tencent.mobileqq.profile.vote.LikeRankingUtil;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class ZanRankingChannel$1
  extends ZanRankingChannelHandler
{
  ZanRankingChannel$1(ZanRankingChannel paramZanRankingChannel) {}
  
  protected void a(String paramString, MethodChannel.Result paramResult)
  {
    Integer localInteger = Integer.valueOf(ZanRankingChannel.d.incrementAndGet());
    ZanRankingChannel.a(this.a).put(localInteger, paramResult);
    ZanRankingIpcClient.a().a(localInteger.intValue(), paramString, true);
  }
  
  protected void a(ArrayList<String> paramArrayList, MethodChannel.Result paramResult)
  {
    try
    {
      paramResult.success(ZanRankingIpcClient.a().a(paramArrayList));
      return;
    }
    catch (Throwable paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  protected void b(String paramString, MethodChannel.Result paramResult)
  {
    Integer localInteger = Integer.valueOf(ZanRankingChannel.d.incrementAndGet());
    ZanRankingChannel.a(this.a).put(localInteger, paramResult);
    ZanRankingIpcClient.a().a(localInteger.intValue(), paramString, false);
  }
  
  protected void c(String paramString, MethodChannel.Result paramResult)
  {
    LikeRankingUtil.a(BaseApplicationImpl.getContext(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.ZanRankingChannel.1
 * JD-Core Version:    0.7.0.1
 */