package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class QVipPerfLevelProcessor
  extends BaseQVipConfigProcessor<QVipPerfLevelConfig>
{
  @NonNull
  public QVipPerfLevelConfig a()
  {
    return QVipPerfLevelConfig.a();
  }
  
  @NonNull
  public QVipPerfLevelConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.PERF.ConfigProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    return QVipPerfLevelConfig.a(paramArrayOfQConfItem[0].b);
  }
  
  @NonNull
  public QVipPerfLevelConfig b()
  {
    return QVipPerfLevelConfig.a();
  }
  
  public Class<QVipPerfLevelConfig> clazz()
  {
    return QVipPerfLevelConfig.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public int type()
  {
    return 580;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPerfLevelProcessor
 * JD-Core Version:    0.7.0.1
 */