package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

public class QVipTroopNickProcessor
  extends BaseQVipConfigProcessor<QVipTroopNickConfig>
{
  @NonNull
  public static QVipTroopNickConfig e()
  {
    QVipTroopNickConfig localQVipTroopNickConfig2 = (QVipTroopNickConfig)QConfigManager.b().b(684);
    QVipTroopNickConfig localQVipTroopNickConfig1 = localQVipTroopNickConfig2;
    if (localQVipTroopNickConfig2 == null) {
      localQVipTroopNickConfig1 = new QVipTroopNickConfig();
    }
    return localQVipTroopNickConfig1;
  }
  
  @NonNull
  public QVipTroopNickConfig a()
  {
    return new QVipTroopNickConfig();
  }
  
  @NonNull
  public QVipTroopNickConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    String str = paramArrayOfQConfItem[0].b;
    if (!TextUtils.isEmpty(str))
    {
      localObject = (QVipTroopNickConfig)JSONConverter.a(str, QVipTroopNickConfig.class);
      paramArrayOfQConfItem = (QConfItem[])localObject;
      if (QLog.isColorLevel())
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("content:");
        paramArrayOfQConfItem.append(str);
        paramArrayOfQConfItem.append(" config:");
        paramArrayOfQConfItem.append(localObject.toString());
        QLog.d("QVipTroopNickConfig", 2, paramArrayOfQConfItem.toString());
        paramArrayOfQConfItem = (QConfItem[])localObject;
      }
    }
    else
    {
      paramArrayOfQConfItem = null;
    }
    Object localObject = paramArrayOfQConfItem;
    if (paramArrayOfQConfItem == null) {
      localObject = new QVipTroopNickConfig();
    }
    return localObject;
  }
  
  @NonNull
  public QVipTroopNickConfig b()
  {
    return new QVipTroopNickConfig();
  }
  
  public Class<QVipTroopNickConfig> clazz()
  {
    return QVipTroopNickConfig.class;
  }
  
  public int type()
  {
    return 684;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopNickProcessor
 * JD-Core Version:    0.7.0.1
 */