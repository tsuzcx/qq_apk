package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import anjy;
import aqxa;
import aqxe;
import arek;
import arem;
import blqp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQComicConfBean
{
  private arek jdField_a_of_type_Arek = new arek();
  public arem a;
  private QQComicConfBean.IPExpressionConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig = new QQComicConfBean.IPExpressionConfig();
  public Map<String, String> a;
  
  public QQComicConfBean()
  {
    this.jdField_a_of_type_Arem = new arem(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static arek a()
  {
    return ((QQComicConfBean)aqxe.a().a(534)).jdField_a_of_type_Arek;
  }
  
  public static QQComicConfBean.IPExpressionConfig a()
  {
    return ((QQComicConfBean)aqxe.a().a(534)).jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig;
  }
  
  public static QQComicConfBean a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length == 0)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfBean", 2, "parse");
    }
    QQComicConfBean localQQComicConfBean;
    int i;
    Object localObject2;
    Object localObject3;
    try
    {
      localQQComicConfBean = new QQComicConfBean();
      int k = paramArrayOfaqxa.length;
      i = 0;
      if (i >= k) {
        break label618;
      }
      localObject1 = paramArrayOfaqxa[i];
      if (TextUtils.isEmpty(((aqxa)localObject1).jdField_a_of_type_JavaLangString)) {
        break label659;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfBean", 2, new Object[] { "parse, content=", ((aqxa)localObject1).jdField_a_of_type_JavaLangString });
      }
      localObject1 = new JSONObject(((aqxa)localObject1).jdField_a_of_type_JavaLangString);
      if (((JSONObject)localObject1).has("ipEmoji"))
      {
        localObject1 = ((JSONObject)localObject1).optJSONObject("ipEmoji");
        if (localObject1 == null) {
          break label659;
        }
        localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig.mPrefixUrl = ((JSONObject)localObject1).optString("url");
        localObject1 = ((JSONObject)localObject1).optJSONObject("matchList");
        if (localObject1 == null) {
          break label659;
        }
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig.mExpressionMap.put(localObject3, localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig.mPrefixUrl + ((JSONObject)localObject1).optString((String)localObject3));
        }
      }
      if (!((JSONObject)localObject1).has("webbundle")) {
        break label338;
      }
    }
    catch (Exception paramArrayOfaqxa)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQComicConfBean", 1, new Object[] { "parse e:", paramArrayOfaqxa.toString() });
      }
      return null;
    }
    Object localObject1 = ((JSONObject)localObject1).optJSONObject("webbundle");
    label338:
    int m;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).optJSONObject("qqcomic");
      if (localObject1 != null)
      {
        localQQComicConfBean.jdField_a_of_type_Arem.jdField_a_of_type_Boolean = ((JSONObject)localObject1).optBoolean("enable", false);
        localQQComicConfBean.jdField_a_of_type_Arem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("preload_url", "");
        break label659;
        if (((JSONObject)localObject1).has("urlConfig"))
        {
          localObject3 = ((JSONObject)localObject1).optJSONArray("urlConfig");
          if (QLog.isColorLevel()) {
            QLog.d("QQComicConfBean", 2, new Object[] { "parse, urlConfig=", localObject3 });
          }
          m = ((JSONArray)localObject3).length();
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (j < m)
      {
        JSONObject localJSONObject = ((JSONArray)localObject3).getJSONObject(j);
        String str = localJSONObject.optString("bizName");
        if (TextUtils.isEmpty(str)) {
          break label666;
        }
        if (anjy.a("8.4.10", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion")))
        {
          localObject2 = localJSONObject.optString("androidUrl");
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localJSONObject.optString("url");
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label666;
          }
          localQQComicConfBean.jdField_a_of_type_JavaUtilMap.put(str, localObject1);
          QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", str, ", url=", localObject1 });
          break label666;
        }
        QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", str, ", version not match" });
        break label666;
        if (((JSONObject)localObject1).has("serviceAccount"))
        {
          localObject1 = ((JSONObject)localObject1).optJSONObject("serviceAccount");
          if (localObject1 != null)
          {
            arek.a(localQQComicConfBean.jdField_a_of_type_Arek, ((JSONObject)localObject1).optString("uin"));
            arek.b(localQQComicConfBean.jdField_a_of_type_Arek, ((JSONObject)localObject1).optString("url"));
            break label659;
            label618:
            blqp.a((String)localQQComicConfBean.jdField_a_of_type_JavaUtilMap.get("danmuAnswerUrl"));
            QLog.d("QQComicConfBean", 1, new Object[] { "parse, confBean=", localQQComicConfBean });
            return localQQComicConfBean;
          }
        }
      }
      label659:
      i += 1;
      break;
      label666:
      j += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("qqComicConfig:").append(this.jdField_a_of_type_Arem);
    localStringBuilder.append(" ,urlConfigMap:").append(this.jdField_a_of_type_JavaUtilMap);
    localStringBuilder.append(" ,serviceAccountConfig:").append(this.jdField_a_of_type_Arek);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQComicConfBean
 * JD-Core Version:    0.7.0.1
 */