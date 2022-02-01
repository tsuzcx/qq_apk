package com.tencent.mobileqq.newnearby;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyReportHelper
  extends QRouteApi
{
  public abstract void reportEnterFakeNearby(AppInterface paramAppInterface);
  
  public abstract void reportEnterNewNearby(AppInterface paramAppInterface);
  
  public abstract void reportEnterOldNearby(AppInterface paramAppInterface);
  
  public abstract void reportLiveTipListClick(AppInterface paramAppInterface);
  
  public abstract void reportMomentListClick(AppInterface paramAppInterface);
  
  public abstract void reportMsgListExp(AppInterface paramAppInterface);
  
  public abstract void reportMsgListItemClick(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportMsgListItemExp(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract void reportNearbyAIOExp(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract void reportNearbyAIOSendMsg(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract void reportProfileInfoTabExp(String paramString1, String paramString2);
  
  public abstract void reportProfileTrendsTabExp(String paramString1, String paramString2);
  
  public abstract void reportQQNearbyTabClick(AppInterface paramAppInterface);
  
  public abstract void reportSayHelloMsgListItemClick(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportSayHelloMsgListItemExp(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportTrendDetailCommentClick(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportTrendDetailExp(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportTrendDetailLikeClick(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportTrendDetailSafeReportClick(AppInterface paramAppInterface, String paramString);
  
  public abstract void reportTrendDetailShareClick(AppInterface paramAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.INearbyReportHelper
 * JD-Core Version:    0.7.0.1
 */