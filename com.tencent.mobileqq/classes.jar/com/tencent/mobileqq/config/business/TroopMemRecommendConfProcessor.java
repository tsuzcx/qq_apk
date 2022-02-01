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
    TroopMemRecommendConfBean localTroopMemRecommendConfBean2 = (TroopMemRecommendConfBean)QConfigManager.a().a(550);
    TroopMemRecommendConfBean localTroopMemRecommendConfBean1 = localTroopMemRecommendConfBean2;
    if (localTroopMemRecommendConfBean2 == null) {
      localTroopMemRecommendConfBean1 = new TroopMemRecommendConfBean();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "loadConfig(): bean = " + localTroopMemRecommendConfBean1.toString());
    }
    return localTroopMemRecommendConfBean1;
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
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onUpdate bean = " + paramTroopMemRecommendConfBean.toString());
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.ConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 550;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopMemRecommendConfProcessor
 * JD-Core Version:    0.7.0.1
 */