package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;
import com.tencent.qphone.base.util.QLog;

public class QVipKeywordsProcessor
  extends BaseQVipConfigProcessor<QVipKeywordsConfig>
{
  @NonNull
  public QVipKeywordsConfig a()
  {
    return new QVipKeywordsConfig();
  }
  
  @NonNull
  public QVipKeywordsConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    AioVipKeywordHelper.a().a(localQQAppInterface.getApplication(), paramArrayOfQConfItem, localQQAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("QVipKeywordsProcessor", 2, "receiveAllConfigs|type: 76,content: " + paramArrayOfQConfItem);
    }
    return new QVipKeywordsConfig();
  }
  
  @NonNull
  public QVipKeywordsConfig b()
  {
    return new QVipKeywordsConfig();
  }
  
  public Class<QVipKeywordsConfig> clazz()
  {
    return QVipKeywordsConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 76;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipKeywordsProcessor
 * JD-Core Version:    0.7.0.1
 */