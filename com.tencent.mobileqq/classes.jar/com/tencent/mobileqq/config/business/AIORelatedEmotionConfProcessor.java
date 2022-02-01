package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class AIORelatedEmotionConfProcessor
  extends IQConfigProcessor<AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean>
{
  public static AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean a()
  {
    return (AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean)QConfigManager.a().a(655);
  }
  
  @NonNull
  public AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean a(int paramInt)
  {
    return new AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean();
  }
  
  @Nullable
  public AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean paramRelatedEmotionConfigBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionConfProcessor", 2, "AIORelatedEmotionConfProcessor onUpdate");
    }
  }
  
  public Class<AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean> clazz()
  {
    return AIORelatedEmotionConfProcessor.RelatedEmotionConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 655;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor
 * JD-Core Version:    0.7.0.1
 */