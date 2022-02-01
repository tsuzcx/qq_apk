package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipAutoPttProcessor
  extends BaseQVipConfigProcessor<QVipAutoPttConfig>
{
  public static QVipAutoPttConfig c()
  {
    QVipAutoPttConfig localQVipAutoPttConfig2 = (QVipAutoPttConfig)QConfigManager.a().a(498);
    QVipAutoPttConfig localQVipAutoPttConfig1 = localQVipAutoPttConfig2;
    if (localQVipAutoPttConfig2 == null) {
      localQVipAutoPttConfig1 = new QVipAutoPttConfig();
    }
    return localQVipAutoPttConfig1;
  }
  
  @NonNull
  public QVipAutoPttConfig a()
  {
    return new QVipAutoPttConfig();
  }
  
  @NonNull
  public QVipAutoPttConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QVipAutoPttConfig localQVipAutoPttConfig = new QVipAutoPttConfig();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramArrayOfQConfItem)) {}
    for (;;)
    {
      return localQVipAutoPttConfig;
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
        localQVipAutoPttConfig.jdField_a_of_type_Int = paramArrayOfQConfItem.optInt("stage");
        localQVipAutoPttConfig.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localQVipAutoPttConfig.jdField_a_of_type_Int + " url=" + localQVipAutoPttConfig.jdField_a_of_type_JavaLangString);
          return localQVipAutoPttConfig;
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfQConfItem);
        localQVipAutoPttConfig.b = paramArrayOfQConfItem.toString();
      }
    }
    return localQVipAutoPttConfig;
  }
  
  @NonNull
  public QVipAutoPttConfig b()
  {
    return new QVipAutoPttConfig();
  }
  
  public Class<QVipAutoPttConfig> clazz()
  {
    return QVipAutoPttConfig.class;
  }
  
  public int type()
  {
    return 498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor
 * JD-Core Version:    0.7.0.1
 */