package com.tencent.mobileqq.vas.config.business.qvip;

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
  public static QVipAutoPttConfig e()
  {
    QVipAutoPttConfig localQVipAutoPttConfig2 = (QVipAutoPttConfig)QConfigManager.b().b(498);
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
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
    if (TextUtils.isEmpty(paramArrayOfQConfItem)) {
      return localQVipAutoPttConfig;
    }
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
      localQVipAutoPttConfig.a = paramArrayOfQConfItem.optInt("stage");
      localQVipAutoPttConfig.b = paramArrayOfQConfItem.optString("pay_url");
      if (QLog.isColorLevel())
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("json parse config.stage:");
        paramArrayOfQConfItem.append(localQVipAutoPttConfig.a);
        paramArrayOfQConfItem.append(" url=");
        paramArrayOfQConfItem.append(localQVipAutoPttConfig.b);
        QLog.d("vip_ptt.ConfigProcessor", 1, paramArrayOfQConfItem.toString());
        return localQVipAutoPttConfig;
      }
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("json parse error:");
      localStringBuilder.append(paramArrayOfQConfItem);
      QLog.e("vip_ptt.ConfigProcessor", 1, localStringBuilder.toString());
      localQVipAutoPttConfig.c = paramArrayOfQConfItem.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor
 * JD-Core Version:    0.7.0.1
 */