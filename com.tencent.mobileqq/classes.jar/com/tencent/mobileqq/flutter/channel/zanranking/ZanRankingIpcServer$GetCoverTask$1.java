package com.tencent.mobileqq.flutter.channel.zanranking;

import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;

class ZanRankingIpcServer$GetCoverTask$1
  extends CallBacker
{
  ZanRankingIpcServer$GetCoverTask$1(ZanRankingIpcServer.GetCoverTask paramGetCoverTask) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")) && (paramInt1 == 0) && (this.a.c != null))
    {
      paramString1 = this.a;
      ZanRankingIpcServer.GetCoverTask.a(paramString1, paramString1.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer.GetCoverTask.1
 * JD-Core Version:    0.7.0.1
 */