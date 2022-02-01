package com.tencent.mobileqq.flutter.channel.zanranking;

import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class ZanRankingIpcServer$GetCoverTask$2
  extends ProfileCardObserver
{
  ZanRankingIpcServer$GetCoverTask$2(ZanRankingIpcServer.GetCoverTask paramGetCoverTask) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      String str = this.a.b.getString("uin");
      if (paramObject.uin.equals(str)) {
        ZanRankingIpcServer.GetCoverTask.a(this.a, paramObject, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer.GetCoverTask.2
 * JD-Core Version:    0.7.0.1
 */