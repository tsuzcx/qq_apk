package com.tencent.mobileqq.vas.config.business.qvip;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipPrettyAccountConfig
{
  public boolean a = true;
  
  public static QVipPrettyAccountConfig a(String paramString)
  {
    QVipPrettyAccountConfig localQVipPrettyAccountConfig = new QVipPrettyAccountConfig();
    if (TextUtils.isEmpty(paramString)) {
      return localQVipPrettyAccountConfig;
    }
    try
    {
      localQVipPrettyAccountConfig.a = new JSONObject(paramString).optBoolean("isEnable", true);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("pretty_account config :");
        paramString.append(localQVipPrettyAccountConfig.a);
        QLog.d("QVipPrettyAccountConfig", 2, paramString.toString());
        return localQVipPrettyAccountConfig;
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pretty_account config init error:");
        localStringBuilder.append(paramString);
        QLog.d("QVipPrettyAccountConfig", 2, localStringBuilder.toString());
      }
    }
    return localQVipPrettyAccountConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountConfig
 * JD-Core Version:    0.7.0.1
 */