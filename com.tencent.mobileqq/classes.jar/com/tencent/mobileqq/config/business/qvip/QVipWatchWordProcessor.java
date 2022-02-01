package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QVipWatchWordProcessor
  extends BaseQVipConfigProcessor<QVipWatchWordConfig>
{
  public static QVipWatchWordConfig a()
  {
    return (QVipWatchWordConfig)QConfigManager.a().a(648);
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    Object localObject = a();
    boolean bool1 = bool2;
    int i;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((QVipWatchWordConfig)localObject).isEnable())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QVipWatchWordProcessor", 2, "isShowWatchWord:" + paramString + " configUrl:" + ((QVipWatchWordConfig)localObject).getWatchUrl() + " configPattern:" + ((QVipWatchWordConfig)localObject).getPattern());
        }
        localObject = ((QVipWatchWordConfig)localObject).getWatchUrl();
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < ((ArrayList)localObject).size())
      {
        if (paramString.contains((CharSequence)((ArrayList)localObject).get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  @NonNull
  public QVipWatchWordConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QVipWatchWordConfig localQVipWatchWordConfig = null;
    String str = paramArrayOfQConfItem[0].a;
    paramArrayOfQConfItem = localQVipWatchWordConfig;
    if (!TextUtils.isEmpty(str))
    {
      localQVipWatchWordConfig = (QVipWatchWordConfig)JSONConverter.a(str, QVipWatchWordConfig.class);
      paramArrayOfQConfItem = localQVipWatchWordConfig;
      if (QLog.isColorLevel())
      {
        QLog.d("QVipWatchWordProcessor", 2, "content:" + str + " config:" + localQVipWatchWordConfig.toString());
        paramArrayOfQConfItem = localQVipWatchWordConfig;
      }
    }
    return paramArrayOfQConfItem;
  }
  
  @NonNull
  public QVipWatchWordConfig b()
  {
    return new QVipWatchWordConfig();
  }
  
  @NonNull
  public QVipWatchWordConfig c()
  {
    return new QVipWatchWordConfig();
  }
  
  public Class<QVipWatchWordConfig> clazz()
  {
    return QVipWatchWordConfig.class;
  }
  
  public int type()
  {
    return 648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipWatchWordProcessor
 * JD-Core Version:    0.7.0.1
 */