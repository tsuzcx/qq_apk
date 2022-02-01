package com.tencent.mobileqq.nearpeople.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils;
import java.util.List;

public class NearbyRecommenderUtilsImpl
  implements INearbyRecommenderUtils
{
  public void addGrayTipsMsg(Object paramObject, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    NearbyRecommenderUtils.a((QQAppInterface)paramObject, paramString1, paramString2, paramString3, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void addNearbyRecommenderMsg(Object paramObject, String paramString, long paramLong)
  {
    NearbyRecommenderUtils.a((QQAppInterface)paramObject, paramString, paramLong);
  }
  
  public void checkExpireTime(Object paramObject)
  {
    NearbyRecommenderUtils.a((QQAppInterface)paramObject);
  }
  
  public boolean checkShowNearbyRecommender(Object paramObject)
  {
    return NearbyRecommenderUtils.b((QQAppInterface)paramObject);
  }
  
  public boolean checkUnreadMsgForNearbyRecommender(Object paramObject)
  {
    return NearbyRecommenderUtils.a((QQAppInterface)paramObject);
  }
  
  public String[] getReasonTypeAndUins(Object paramObject)
  {
    return NearbyRecommenderUtils.a((QQAppInterface)paramObject);
  }
  
  public boolean isNeedPullNearbyRecommenderData(Object paramObject, int paramInt)
  {
    return NearbyRecommenderUtils.a((QQAppInterface)paramObject, paramInt);
  }
  
  public void setNearbyRecommenderMsgRead(Object paramObject)
  {
    NearbyRecommenderUtils.b((QQAppInterface)paramObject);
  }
  
  public void storeNearbyRecommenderList(Context paramContext, String paramString, List<Object> paramList)
  {
    NearbyRecommenderUtils.a(paramContext, paramString, paramList);
  }
  
  public void updateConfigs(AppInterface paramAppInterface, Bundle paramBundle)
  {
    NearbyRecommenderUtils.a(paramAppInterface, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.api.impl.NearbyRecommenderUtilsImpl
 * JD-Core Version:    0.7.0.1
 */