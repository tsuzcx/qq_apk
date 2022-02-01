package com.tencent.mobileqq.config.business;

import amio;
import android.text.TextUtils;
import aptx;
import apub;
import aqbh;
import aqbj;
import bkfe;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQComicConfBean
{
  private aqbh jdField_a_of_type_Aqbh = new aqbh();
  public aqbj a;
  private QQComicConfBean.IPExpressionConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig = new QQComicConfBean.IPExpressionConfig();
  public Map<String, String> a;
  
  public QQComicConfBean()
  {
    this.jdField_a_of_type_Aqbj = new aqbj(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static aqbh a()
  {
    return ((QQComicConfBean)apub.a().a(534)).jdField_a_of_type_Aqbh;
  }
  
  public static QQComicConfBean.IPExpressionConfig a()
  {
    return ((QQComicConfBean)apub.a().a(534)).jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig;
  }
  
  public static QQComicConfBean a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length == 0)) {
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
      int k = paramArrayOfaptx.length;
      i = 0;
      if (i >= k) {
        break label618;
      }
      localObject1 = paramArrayOfaptx[i];
      if (TextUtils.isEmpty(((aptx)localObject1).jdField_a_of_type_JavaLangString)) {
        break label659;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfBean", 2, new Object[] { "parse, content=", ((aptx)localObject1).jdField_a_of_type_JavaLangString });
      }
      localObject1 = new JSONObject(((aptx)localObject1).jdField_a_of_type_JavaLangString);
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
    catch (Exception paramArrayOfaptx)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQComicConfBean", 1, new Object[] { "parse e:", paramArrayOfaptx.toString() });
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
        localQQComicConfBean.jdField_a_of_type_Aqbj.jdField_a_of_type_Boolean = ((JSONObject)localObject1).optBoolean("enable", false);
        localQQComicConfBean.jdField_a_of_type_Aqbj.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("preload_url", "");
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
        if (amio.a("8.4.8", localJSONObject.optString("minVersion"), localJSONObject.optString("maxVersion")))
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
            aqbh.a(localQQComicConfBean.jdField_a_of_type_Aqbh, ((JSONObject)localObject1).optString("uin"));
            aqbh.b(localQQComicConfBean.jdField_a_of_type_Aqbh, ((JSONObject)localObject1).optString("url"));
            break label659;
            label618:
            bkfe.a((String)localQQComicConfBean.jdField_a_of_type_JavaUtilMap.get("danmuAnswerUrl"));
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
    localStringBuilder.append("qqComicConfig:").append(this.jdField_a_of_type_Aqbj);
    localStringBuilder.append(" ,urlConfigMap:").append(this.jdField_a_of_type_JavaUtilMap);
    localStringBuilder.append(" ,serviceAccountConfig:").append(this.jdField_a_of_type_Aqbh);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQComicConfBean
 * JD-Core Version:    0.7.0.1
 */