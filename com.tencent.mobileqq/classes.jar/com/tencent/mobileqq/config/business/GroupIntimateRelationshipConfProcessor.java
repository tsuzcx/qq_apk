package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class GroupIntimateRelationshipConfProcessor
  extends IQConfigProcessor<GroupIntimateRelationshipBean>
{
  public static GroupIntimateRelationshipBean a()
  {
    GroupIntimateRelationshipBean localGroupIntimateRelationshipBean2 = (GroupIntimateRelationshipBean)QConfigManager.b().b(492);
    GroupIntimateRelationshipBean localGroupIntimateRelationshipBean1 = localGroupIntimateRelationshipBean2;
    if (localGroupIntimateRelationshipBean2 == null) {
      localGroupIntimateRelationshipBean1 = new GroupIntimateRelationshipBean();
    }
    return localGroupIntimateRelationshipBean1;
  }
  
  @NonNull
  public GroupIntimateRelationshipBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GroupIntimateRelationshipConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new GroupIntimateRelationshipBean();
  }
  
  @Nullable
  public GroupIntimateRelationshipBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      GroupIntimateRelationshipBean localGroupIntimateRelationshipBean = GroupIntimateRelationshipBean.a(paramArrayOfQConfItem[0]);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].b);
        QLog.d("GroupIntimateRelationshipConfProcessor", 2, localStringBuilder.toString());
      }
      return localGroupIntimateRelationshipBean;
    }
    return new GroupIntimateRelationshipBean();
  }
  
  public void a(GroupIntimateRelationshipBean paramGroupIntimateRelationshipBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate newConf:");
      localStringBuilder.append(paramGroupIntimateRelationshipBean);
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<GroupIntimateRelationshipBean> clazz()
  {
    return GroupIntimateRelationshipBean.class;
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
      QLog.d("GroupIntimateRelationshipConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 492;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GroupIntimateRelationshipConfProcessor
 * JD-Core Version:    0.7.0.1
 */