package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class FriendIntimateRelationshipConfProcessor
  extends IQConfigProcessor<FriendIntimateRelationshipBean>
{
  @NonNull
  public static FriendIntimateRelationshipBean a()
  {
    FriendIntimateRelationshipBean localFriendIntimateRelationshipBean2 = (FriendIntimateRelationshipBean)QConfigManager.b().b(455);
    FriendIntimateRelationshipBean localFriendIntimateRelationshipBean1 = localFriendIntimateRelationshipBean2;
    if (localFriendIntimateRelationshipBean2 == null) {
      localFriendIntimateRelationshipBean1 = new FriendIntimateRelationshipBean();
    }
    return localFriendIntimateRelationshipBean1;
  }
  
  @NonNull
  public FriendIntimateRelationshipBean a(int paramInt)
  {
    return new FriendIntimateRelationshipBean();
  }
  
  @Nullable
  public FriendIntimateRelationshipBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      FriendIntimateRelationshipBean localFriendIntimateRelationshipBean = FriendIntimateRelationshipBean.a(paramArrayOfQConfItem[0].b);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("FriendIntimateRelationshipConfProcessor", 2, localStringBuilder.toString());
      }
      return localFriendIntimateRelationshipBean;
    }
    return new FriendIntimateRelationshipBean();
  }
  
  public void a(FriendIntimateRelationshipBean paramFriendIntimateRelationshipBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate newConf:");
      localStringBuilder.append(paramFriendIntimateRelationshipBean);
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<FriendIntimateRelationshipBean> clazz()
  {
    return FriendIntimateRelationshipBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed failCode:");
      localStringBuilder.append(paramInt);
      QLog.d("FriendIntimateRelationshipConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 455;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor
 * JD-Core Version:    0.7.0.1
 */