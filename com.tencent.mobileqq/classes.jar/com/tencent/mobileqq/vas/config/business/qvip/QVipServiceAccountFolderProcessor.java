package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QVipServiceAccountFolderProcessor
  extends BaseQVipConfigProcessor<QVipServiceAccountFolderConfig>
{
  public static QVipServiceAccountFolderConfig a()
  {
    QVipServiceAccountFolderConfig localQVipServiceAccountFolderConfig2 = (QVipServiceAccountFolderConfig)QConfigManager.b().b(722);
    QVipServiceAccountFolderConfig localQVipServiceAccountFolderConfig1 = localQVipServiceAccountFolderConfig2;
    if (localQVipServiceAccountFolderConfig2 == null) {
      localQVipServiceAccountFolderConfig1 = new QVipServiceAccountFolderConfig();
    }
    return localQVipServiceAccountFolderConfig1;
  }
  
  @NonNull
  public QVipServiceAccountFolderConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVIP.SDK.QVipServiceAccountFolderProcessor", 1, paramArrayOfQConfItem[0].b);
    }
    try
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        paramArrayOfQConfItem = (QVipServiceAccountFolderConfig)JSONConverter.a(paramArrayOfQConfItem, QVipServiceAccountFolderConfig.class);
        a(paramArrayOfQConfItem.showRecommendPage);
        return paramArrayOfQConfItem;
      }
    }
    catch (Exception paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
    }
    return new QVipServiceAccountFolderConfig();
  }
  
  public void a(boolean paramBoolean)
  {
    MobileQQ.getContext().getSharedPreferences("banner_and_splash", 4).edit().putBoolean("showRecommendPage", paramBoolean).commit();
  }
  
  @NonNull
  public QVipServiceAccountFolderConfig b()
  {
    return new QVipServiceAccountFolderConfig();
  }
  
  public Class<QVipServiceAccountFolderConfig> clazz()
  {
    return QVipServiceAccountFolderConfig.class;
  }
  
  @NonNull
  public QVipServiceAccountFolderConfig e()
  {
    return new QVipServiceAccountFolderConfig();
  }
  
  public int type()
  {
    return 722;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor
 * JD-Core Version:    0.7.0.1
 */