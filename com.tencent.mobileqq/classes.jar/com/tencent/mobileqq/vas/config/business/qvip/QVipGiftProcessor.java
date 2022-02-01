package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

public class QVipGiftProcessor
  extends BaseQVipConfigProcessor<QVipGiftConfig>
{
  public static QVipGiftConfig a()
  {
    QVipGiftConfig localQVipGiftConfig2 = (QVipGiftConfig)QConfigManager.b().b(667);
    QVipGiftConfig localQVipGiftConfig1 = localQVipGiftConfig2;
    if (localQVipGiftConfig2 == null) {
      localQVipGiftConfig1 = new QVipGiftConfig();
    }
    return localQVipGiftConfig1;
  }
  
  @NonNull
  public QVipGiftConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipGfitProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    Object localObject = null;
    String str = paramArrayOfQConfItem[0].b;
    paramArrayOfQConfItem = localObject;
    if (!TextUtils.isEmpty(str)) {
      paramArrayOfQConfItem = (QVipGiftConfig)JSONConverter.a(str, QVipGiftConfig.class);
    }
    return paramArrayOfQConfItem;
  }
  
  @NonNull
  public QVipGiftConfig b()
  {
    return new QVipGiftConfig();
  }
  
  public Class<QVipGiftConfig> clazz()
  {
    return QVipGiftConfig.class;
  }
  
  @NonNull
  public QVipGiftConfig e()
  {
    return new QVipGiftConfig();
  }
  
  public int type()
  {
    return 667;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor
 * JD-Core Version:    0.7.0.1
 */