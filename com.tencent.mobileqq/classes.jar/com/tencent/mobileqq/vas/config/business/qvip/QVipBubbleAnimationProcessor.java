package com.tencent.mobileqq.vas.config.business.qvip;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class QVipBubbleAnimationProcessor
  extends BaseQVipConfigProcessor<QVipBubbleAnimationConfig>
{
  public static QVipBubbleAnimationConfig a()
  {
    QVipBubbleAnimationConfig localQVipBubbleAnimationConfig2 = (QVipBubbleAnimationConfig)QConfigManager.b().b(727);
    QVipBubbleAnimationConfig localQVipBubbleAnimationConfig1 = localQVipBubbleAnimationConfig2;
    if (localQVipBubbleAnimationConfig2 == null) {
      localQVipBubbleAnimationConfig1 = new QVipBubbleAnimationConfig();
    }
    return localQVipBubbleAnimationConfig1;
  }
  
  @NonNull
  public QVipBubbleAnimationConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipServiceAccountFolderProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    QVipBubbleAnimationConfig localQVipBubbleAnimationConfig = new QVipBubbleAnimationConfig();
    try
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        localQVipBubbleAnimationConfig.a = paramArrayOfQConfItem;
        return localQVipBubbleAnimationConfig;
      }
    }
    catch (Exception paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
    }
    return localQVipBubbleAnimationConfig;
  }
  
  @NonNull
  public QVipBubbleAnimationConfig b()
  {
    return new QVipBubbleAnimationConfig();
  }
  
  public Class<QVipBubbleAnimationConfig> clazz()
  {
    return QVipBubbleAnimationConfig.class;
  }
  
  @NonNull
  public QVipBubbleAnimationConfig e()
  {
    return new QVipBubbleAnimationConfig();
  }
  
  public int type()
  {
    return 727;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipBubbleAnimationProcessor
 * JD-Core Version:    0.7.0.1
 */