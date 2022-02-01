package com.tencent.mobileqq.vas.config.business.qvip;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipQidConfig
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public QVipQidConfig()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "https://club.vip.qq.com/qid/mine?_wv=16777218&_proxy=1";
    this.jdField_b_of_type_JavaLangString = "https://club.vip.qq.com/qid/card?wv=16781315&_proxy=1";
  }
  
  public static QVipQidConfig a(String paramString)
  {
    QVipQidConfig localQVipQidConfig = new QVipQidConfig();
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QVipQidConfig", 2, "QID_LOG,configContent,empty");
      }
      return localQVipQidConfig;
    }
    Object localObject;
    try
    {
      paramString = new JSONObject(paramString);
      try
      {
        localQVipQidConfig.jdField_a_of_type_Boolean = paramString.optBoolean("isEnable", false);
        localQVipQidConfig.jdField_a_of_type_JavaLangString = paramString.optString("homePageUrl", "https://club.vip.qq.com/qid/mine?_wv=16777218&_proxy=1");
        localQVipQidConfig.jdField_b_of_type_JavaLangString = paramString.optString("qidProfileUrl", "https://club.vip.qq.com/qid/card?wv=16781315&_proxy=1");
        localObject = paramString;
      }
      catch (JSONException localJSONException1) {}
      localObject = paramString;
    }
    catch (JSONException localJSONException2)
    {
      paramString = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QID_LOG,configContent,error:");
      ((StringBuilder)localObject).append(localJSONException2);
      QLog.d("QVipQidConfig", 2, ((StringBuilder)localObject).toString());
      localObject = paramString;
    }
    try
    {
      localQVipQidConfig.jdField_b_of_type_Boolean = ((JSONObject)localObject).optBoolean("qidProfileEnable", true);
      return localQVipQidConfig;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localQVipQidConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipQidConfig
 * JD-Core Version:    0.7.0.1
 */