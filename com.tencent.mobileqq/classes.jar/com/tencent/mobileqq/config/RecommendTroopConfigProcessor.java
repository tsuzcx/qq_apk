package com.tencent.mobileqq.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class RecommendTroopConfigProcessor
  extends IQConfigProcessor<RecommendTroopConfigProcessor.RecommendTroopConfigBean>
{
  public static RecommendTroopConfigProcessor.RecommendTroopConfigBean a()
  {
    return (RecommendTroopConfigProcessor.RecommendTroopConfigBean)QConfigManager.a().a(457);
  }
  
  @NonNull
  public RecommendTroopConfigProcessor.RecommendTroopConfigBean a(int paramInt)
  {
    return new RecommendTroopConfigProcessor.RecommendTroopConfigBean();
  }
  
  @Nullable
  public RecommendTroopConfigProcessor.RecommendTroopConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      return null;
    }
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor onParsed, content:" + paramArrayOfQConfItem);
    }
    return RecommendTroopConfigProcessor.RecommendTroopConfigBean.a(paramArrayOfQConfItem);
  }
  
  public void a(RecommendTroopConfigProcessor.RecommendTroopConfigBean paramRecommendTroopConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopConfigProcessor", 2, "RecommendTroopConfigProcessor update.");
    }
    ((MayknowRecommendManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a();
  }
  
  public Class<RecommendTroopConfigProcessor.RecommendTroopConfigBean> clazz()
  {
    return RecommendTroopConfigProcessor.RecommendTroopConfigBean.class;
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
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 457;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.RecommendTroopConfigProcessor
 * JD-Core Version:    0.7.0.1
 */