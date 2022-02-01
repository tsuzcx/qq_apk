package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

public class QVipWatchWordProcessor
  extends BaseQVipConfigProcessor<QVipWatchWordConfig>
{
  @NonNull
  public QVipWatchWordConfig a()
  {
    return new QVipWatchWordConfig();
  }
  
  @NonNull
  public QVipWatchWordConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    String str = paramArrayOfQConfItem[0].a;
    if (!TextUtils.isEmpty(str))
    {
      QVipWatchWordConfig localQVipWatchWordConfig = (QVipWatchWordConfig)JSONConverter.a(str, QVipWatchWordConfig.class);
      paramArrayOfQConfItem = localQVipWatchWordConfig;
      if (QLog.isColorLevel())
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("content:");
        paramArrayOfQConfItem.append(str);
        paramArrayOfQConfItem.append(" config:");
        paramArrayOfQConfItem.append(localQVipWatchWordConfig.toString());
        QLog.d("QVipWatchWordProcessor", 2, paramArrayOfQConfItem.toString());
        return localQVipWatchWordConfig;
      }
    }
    else
    {
      paramArrayOfQConfItem = null;
    }
    return paramArrayOfQConfItem;
  }
  
  @NonNull
  public QVipWatchWordConfig b()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipWatchWordProcessor
 * JD-Core Version:    0.7.0.1
 */