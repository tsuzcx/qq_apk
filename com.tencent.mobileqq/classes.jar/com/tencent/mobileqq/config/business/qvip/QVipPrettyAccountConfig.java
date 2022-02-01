package com.tencent.mobileqq.config.business.qvip;

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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return localQVipPrettyAccountConfig;
        try
        {
          localQVipPrettyAccountConfig.a = new JSONObject(paramString).optBoolean("isEnable", true);
          if (QLog.isColorLevel())
          {
            QLog.d("QVipPrettyAccountConfig", 2, "pretty_account config :" + localQVipPrettyAccountConfig.a);
            return localQVipPrettyAccountConfig;
          }
        }
        catch (JSONException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("QVipPrettyAccountConfig", 2, "pretty_account config init error:" + paramString);
    return localQVipPrettyAccountConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipPrettyAccountConfig
 * JD-Core Version:    0.7.0.1
 */