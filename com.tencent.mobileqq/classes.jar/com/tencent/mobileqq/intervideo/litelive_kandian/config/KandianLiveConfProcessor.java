package com.tencent.mobileqq.intervideo.litelive_kandian.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.qphone.base.util.QLog;

public class KandianLiveConfProcessor
  extends BaseQVipConfigProcessor<KandianLiveCfgBean>
{
  public static KandianLiveCfgBean a()
  {
    return (KandianLiveCfgBean)QConfigManager.a().a(714);
  }
  
  @NonNull
  public KandianLiveCfgBean a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QLog.e("KandianLiveConfProcessor", 1, "onParsed ");
    if (paramArrayOfQConfItem != null) {
      try
      {
        if (paramArrayOfQConfItem.length > 0)
        {
          int j = paramArrayOfQConfItem.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramArrayOfQConfItem[i];
            if (localObject != null)
            {
              QLog.e("KandianLiveConfProcessor", 1, "=======onParsed content = " + ((QConfItem)localObject).a);
              localObject = KandianLiveCfgBean.a(((QConfItem)localObject).a);
              if (localObject != null) {
                return localObject;
              }
            }
            i += 1;
          }
        }
        return new KandianLiveCfgBean();
      }
      catch (Throwable paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
        QLog.e("KandianLiveConfProcessor", 1, "onParsed Exception = " + paramArrayOfQConfItem.getMessage());
      }
    }
  }
  
  @NonNull
  public KandianLiveCfgBean b()
  {
    return new KandianLiveCfgBean();
  }
  
  @NonNull
  public KandianLiveCfgBean c()
  {
    return new KandianLiveCfgBean();
  }
  
  public Class<KandianLiveCfgBean> clazz()
  {
    return KandianLiveCfgBean.class;
  }
  
  public int type()
  {
    return 714;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveConfProcessor
 * JD-Core Version:    0.7.0.1
 */