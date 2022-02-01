package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
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
  public int e;
  public int f = 168;
  
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
    localQQGameConfBean = new QQGameConfBean();
    int i = 0;
    try
    {
      if (i < paramArrayOfQConfItem.length)
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
        if (localJSONObject.has("pubaccountSwitch"))
        {
          localQQGameConfBean.jdField_a_of_type_Int = localJSONObject.optInt("pubaccountSwitch");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed swtich=" + localQQGameConfBean.jdField_a_of_type_Int);
          }
        }
        if (localJSONObject.has("fullPopIntervalDay"))
        {
          localQQGameConfBean.jdField_b_of_type_Int = localJSONObject.optInt("fullPopIntervalDay");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed fullPopIntervalDay=" + localQQGameConfBean.jdField_b_of_type_Int);
          }
        }
        if (localJSONObject.has("isFeedByWeb"))
        {
          localQQGameConfBean.c = localJSONObject.optInt("isFeedByWeb");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed isFeedByWeb=" + localQQGameConfBean.c);
          }
        }
        if (localJSONObject.has("gamePubUrl"))
        {
          localQQGameConfBean.jdField_b_of_type_JavaLangString = localJSONObject.optString("gamePubUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed gamePubUlr=" + localQQGameConfBean.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("feedUrl"))
        {
          localQQGameConfBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("feedUrl");
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed feedUrl=" + localQQGameConfBean.jdField_a_of_type_JavaLangString);
          }
        }
        if (localJSONObject.has("hippySwitch"))
        {
          if (localJSONObject.optInt("hippySwitch", 0) != 1) {
            break label590;
          }
          bool = true;
          label330:
          localQQGameConfBean.jdField_a_of_type_Boolean = bool;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed hippySwitch=" + localQQGameConfBean.jdField_a_of_type_Boolean);
          }
        }
        if (localJSONObject.has("hippySoDownload")) {
          if (localJSONObject.optInt("hippySoDownload", 0) != 1) {
            break label595;
          }
        }
        label590:
        label595:
        for (boolean bool = true;; bool = false)
        {
          localQQGameConfBean.jdField_b_of_type_Boolean = bool;
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed hippySoDownload=" + localQQGameConfBean.jdField_b_of_type_Boolean);
          }
          if (localJSONObject.has("hippyJsPluginType"))
          {
            localQQGameConfBean.d = localJSONObject.optInt("hippyJsPluginType", 0);
            if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
              com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed hippyJsPluginType=" + localQQGameConfBean.d);
            }
          }
          if (localJSONObject.has("publicAccountSessionConfig"))
          {
            localJSONObject = localJSONObject.optJSONObject("publicAccountSessionConfig");
            if (localJSONObject != null)
            {
              localQQGameConfBean.e = localJSONObject.optInt("style");
              localQQGameConfBean.f = localJSONObject.optInt("unUsedTime", 168);
            }
            if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
              com.tencent.qphone.base.util.QLog.d("QQGameConfBean", 2, "onParsed publicAccountSessionConfig, sessionStyle=" + localQQGameConfBean.e + ", sessionUnUsedTime=" + localQQGameConfBean.f);
            }
          }
          i += 1;
          break;
          bool = false;
          break label330;
        }
      }
      return localQQGameConfBean;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      com.tencent.TMG.utils.QLog.e("QQGameConfBean", 1, "QQGameConfBean parse error e=" + paramArrayOfQConfItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQGameConfBean
 * JD-Core Version:    0.7.0.1
 */