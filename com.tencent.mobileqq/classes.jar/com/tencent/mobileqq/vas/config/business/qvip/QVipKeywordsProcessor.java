package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.vas.helper.AioVipKeywordConfigHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

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
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
    AioVipKeywordConfigHelper.a().a(((AppRuntime)localObject).getApplication(), paramArrayOfQConfItem, ((AppRuntime)localObject).getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receiveAllConfigs|type: 76,content: ");
      ((StringBuilder)localObject).append(paramArrayOfQConfItem);
      QLog.d("QVipKeywordsProcessor", 2, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipKeywordsProcessor
 * JD-Core Version:    0.7.0.1
 */