package com.tencent.mobileqq.qqgamepub.config;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQGameConfBean
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public int d = 0;
  public int e = 0;
  public int f;
  public int g = 168;
  
  public QQGameConfBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static QQGameConfBean a()
  {
    return (QQGameConfBean)QConfigManager.a().a(441);
  }
  
  public static QQGameConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1 = "hippySwitch";
    QQGameConfBean localQQGameConfBean = new QQGameConfBean();
    int i = 0;
    Object localObject2 = paramArrayOfQConfItem;
    for (;;)
    {
      try
      {
        if (i < localObject2.length)
        {
          localObject2 = new JSONObject(localObject2[i].jdField_a_of_type_JavaLangString);
          StringBuilder localStringBuilder;
          if (((JSONObject)localObject2).has("pubaccountSwitch"))
          {
            localQQGameConfBean.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("pubaccountSwitch");
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed swtich=");
              localStringBuilder.append(localQQGameConfBean.jdField_a_of_type_Int);
              QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
            }
          }
          if (((JSONObject)localObject2).has("fullPopIntervalDay"))
          {
            localQQGameConfBean.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("fullPopIntervalDay");
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed fullPopIntervalDay=");
              localStringBuilder.append(localQQGameConfBean.jdField_b_of_type_Int);
              QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
            }
          }
          if (((JSONObject)localObject2).has("isFeedByWeb"))
          {
            localQQGameConfBean.c = ((JSONObject)localObject2).optInt("isFeedByWeb");
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed isFeedByWeb=");
              localStringBuilder.append(localQQGameConfBean.c);
              QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
            }
          }
          if (((JSONObject)localObject2).has("gamePubUrl"))
          {
            localQQGameConfBean.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("gamePubUrl");
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed gamePubUlr=");
              localStringBuilder.append(localQQGameConfBean.jdField_a_of_type_JavaLangString);
              QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
            }
          }
          if (((JSONObject)localObject2).has("feedUrl"))
          {
            localQQGameConfBean.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("feedUrl");
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed feedUrl=");
              localStringBuilder.append(localQQGameConfBean.jdField_a_of_type_JavaLangString);
              QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
            }
          }
          if (!((JSONObject)localObject2).has((String)localObject1)) {
            break label833;
          }
          if (((JSONObject)localObject2).optInt((String)localObject1, 0) != 1) {
            break label828;
          }
          bool = true;
          localQQGameConfBean.jdField_a_of_type_Boolean = bool;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onParsed hippySwitch=");
            localStringBuilder.append(localQQGameConfBean.jdField_a_of_type_Boolean);
            QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
          }
          if (((JSONObject)localObject2).has("hippySoDownload"))
          {
            if (((JSONObject)localObject2).optInt("hippySoDownload", 0) != 1) {
              break label836;
            }
            bool = true;
            localQQGameConfBean.jdField_b_of_type_Boolean = bool;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed hippySoDownload=");
              localStringBuilder.append(localQQGameConfBean.jdField_b_of_type_Boolean);
              QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
            }
          }
          if (((JSONObject)localObject2).has("hippyJsPluginType"))
          {
            localQQGameConfBean.d = ((JSONObject)localObject2).optInt("hippyJsPluginType", 0);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed hippyJsPluginType=");
              localStringBuilder.append(localQQGameConfBean.d);
              QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
            }
          }
          if (((JSONObject)localObject2).has("gameCenterPreLoadType"))
          {
            localQQGameConfBean.e = ((JSONObject)localObject2).optInt("gameCenterPreLoadType", 0);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onParsed gameCenterPreLoadType=");
              localStringBuilder.append(localQQGameConfBean.e);
              QLog.d("QQGameConfBean", 2, localStringBuilder.toString());
            }
          }
          if (((JSONObject)localObject2).has("publicAccountSessionConfig"))
          {
            localObject2 = ((JSONObject)localObject2).optJSONObject("publicAccountSessionConfig");
            if (localObject2 != null)
            {
              localQQGameConfBean.f = ((JSONObject)localObject2).optInt("style");
              localQQGameConfBean.g = ((JSONObject)localObject2).optInt("unUsedTime", 168);
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onParsed publicAccountSessionConfig, sessionStyle=");
              ((StringBuilder)localObject2).append(localQQGameConfBean.f);
              ((StringBuilder)localObject2).append(", sessionUnUsedTime=");
              ((StringBuilder)localObject2).append(localQQGameConfBean.g);
              QLog.d("QQGameConfBean", 2, ((StringBuilder)localObject2).toString());
            }
          }
          i += 1;
        }
      }
      catch (Throwable paramArrayOfQConfItem)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("QQGameConfBean parse error e=");
        ((StringBuilder)localObject1).append(paramArrayOfQConfItem.toString());
        QLog.e("QQGameConfBean", 1, ((StringBuilder)localObject1).toString());
      }
      return localQQGameConfBean;
      label828:
      boolean bool = false;
      continue;
      label833:
      continue;
      label836:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGameConfBean
 * JD-Core Version:    0.7.0.1
 */