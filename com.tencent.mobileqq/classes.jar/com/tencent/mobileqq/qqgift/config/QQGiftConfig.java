package com.tencent.mobileqq.qqgift.config;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQGiftConfig
{
  private QQGiftRechargeConfig a = new QQGiftRechargeConfig();
  
  @Nullable
  public static QQGiftConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    QQGiftConfig localQQGiftConfig = new QQGiftConfig();
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length == 0) {
        return localQQGiftConfig;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGiftConfig", 2, "parse");
      }
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        a(localQQGiftConfig, paramArrayOfQConfItem[i]);
        i += 1;
      }
      QLog.d("QQGiftConfig", 1, new Object[] { "parse, config=", localQQGiftConfig });
    }
    return localQQGiftConfig;
  }
  
  public static QQGiftRechargeConfig a()
  {
    return ((QQGiftConfig)QConfigManager.b().b(765)).a;
  }
  
  private static void a(QQGiftConfig paramQQGiftConfig, QConfItem paramQConfItem)
  {
    try
    {
      if (!TextUtils.isEmpty(paramQConfItem.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGiftConfig", 2, new Object[] { "parse, content=", paramQConfItem.b });
        }
        paramQConfItem = new JSONObject(paramQConfItem.b);
        if (paramQConfItem.has("recharge"))
        {
          JSONObject localJSONObject = paramQConfItem.optJSONObject("recharge");
          if (localJSONObject != null) {
            paramQQGiftConfig.a.rechargeUrl = localJSONObject.optString("url");
          }
        }
        if (paramQConfItem.has("bannerDefaultMaterialId"))
        {
          paramQQGiftConfig.a.bannerDefaultMaterialId = paramQConfItem.optInt("bannerDefaultMaterialId");
          return;
        }
      }
    }
    catch (Exception paramQQGiftConfig)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQGiftConfig", 1, new Object[] { "parse e:", paramQQGiftConfig.getMessage() });
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGiftConfig{rechargeConfig=");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.config.QQGiftConfig
 * JD-Core Version:    0.7.0.1
 */