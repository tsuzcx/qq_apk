package com.tencent.mobileqq.config.business.qvip;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;

public class QVipServiceAccountFolderProcessor
  extends BaseQVipConfigProcessor<QVipServiceAccountFolderConfig>
{
  public static QVipServiceAccountFolderConfig a()
  {
    QVipServiceAccountFolderConfig localQVipServiceAccountFolderConfig2 = (QVipServiceAccountFolderConfig)QConfigManager.a().a(722);
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
      QLog.d("QVIP.SDK.QVipServiceAccountFolderProcessor", 1, paramArrayOfQConfItem[0].a);
    }
    try
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
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
    BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 4).edit().putBoolean("showRecommendPage", paramBoolean).commit();
  }
  
  @NonNull
  public QVipServiceAccountFolderConfig b()
  {
    return new QVipServiceAccountFolderConfig();
  }
  
  @NonNull
  public QVipServiceAccountFolderConfig c()
  {
    return new QVipServiceAccountFolderConfig();
  }
  
  public Class<QVipServiceAccountFolderConfig> clazz()
  {
    return QVipServiceAccountFolderConfig.class;
  }
  
  public int type()
  {
    return 722;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipServiceAccountFolderProcessor
 * JD-Core Version:    0.7.0.1
 */