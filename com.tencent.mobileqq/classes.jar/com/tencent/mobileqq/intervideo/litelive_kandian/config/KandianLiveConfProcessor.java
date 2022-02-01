package com.tencent.mobileqq.intervideo.litelive_kandian.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.qphone.base.util.QLog;

public class KandianLiveConfProcessor
  extends BaseQVipConfigProcessor<KandianLiveCfgBean>
{
  public static KandianLiveCfgBean a()
  {
    return (KandianLiveCfgBean)QConfigManager.b().b(714);
  }
  
  @NonNull
  public KandianLiveCfgBean a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QLog.e("KandianLiveConfProcessor", 1, "onParsed ");
    if (paramArrayOfQConfItem != null) {
      try
      {
        Object localObject;
        if (paramArrayOfQConfItem.length > 0)
        {
          int j = paramArrayOfQConfItem.length;
          int i = 0;
          while (i < j)
          {
            localObject = paramArrayOfQConfItem[i];
            if (localObject != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("=======onParsed content = ");
              localStringBuilder.append(((QConfItem)localObject).b);
              QLog.e("KandianLiveConfProcessor", 1, localStringBuilder.toString());
              localObject = KandianLiveCfgBean.a(((QConfItem)localObject).b);
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onParsed Exception = ");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem.getMessage());
        QLog.e("KandianLiveConfProcessor", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @NonNull
  public KandianLiveCfgBean b()
  {
    return new KandianLiveCfgBean();
  }
  
  public Class<KandianLiveCfgBean> clazz()
  {
    return KandianLiveCfgBean.class;
  }
  
  @NonNull
  public KandianLiveCfgBean e()
  {
    return new KandianLiveCfgBean();
  }
  
  public int type()
  {
    return 714;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveConfProcessor
 * JD-Core Version:    0.7.0.1
 */