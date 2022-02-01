package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager;
import com.tencent.qphone.base.util.QLog;

public class TroopMemRecommendConfProcessor
  extends IQConfigProcessor<TroopMemRecommendConfBean>
{
  @NonNull
  public static TroopMemRecommendConfBean a()
  {
    Object localObject2 = (TroopMemRecommendConfBean)QConfigManager.b().b(550);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new TroopMemRecommendConfBean();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadConfig(): bean = ");
      ((StringBuilder)localObject2).append(((TroopMemRecommendConfBean)localObject1).toString());
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  @NonNull
  public TroopMemRecommendConfBean a(int paramInt)
  {
    return new TroopMemRecommendConfBean();
  }
  
  @Nullable
  public TroopMemRecommendConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return TroopMemRecommendConfBean.a(paramArrayOfQConfItem);
  }
  
  public void a(TroopMemRecommendConfBean paramTroopMemRecommendConfBean)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).isCreateManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER))
      {
        ((TroopMemberRecommendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER)).a = paramTroopMemRecommendConfBean;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onUpdate bean = ");
          ((StringBuilder)localObject).append(paramTroopMemRecommendConfBean.toString());
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public Class clazz()
  {
    return TroopMemRecommendConfBean.class;
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
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 550;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopMemRecommendConfProcessor
 * JD-Core Version:    0.7.0.1
 */