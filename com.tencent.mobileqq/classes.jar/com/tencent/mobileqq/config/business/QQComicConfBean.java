package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.uitls.IApolloConfigHelper;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQComicConfBean
{
  private QQComicConfBean.BoodoHippyConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig = new QQComicConfBean.BoodoHippyConfig();
  private QQComicConfBean.ComicReaderConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ComicReaderConfig = new QQComicConfBean.ComicReaderConfig();
  private QQComicConfBean.IPExpressionConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig = new QQComicConfBean.IPExpressionConfig();
  private QQComicConfBean.ServiceAccountConfig jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ServiceAccountConfig = new QQComicConfBean.ServiceAccountConfig();
  public QQComicConfBean.WebBundleConfig a;
  public Map<String, String> a;
  
  public QQComicConfBean()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$WebBundleConfig = new QQComicConfBean.WebBundleConfig(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static QQComicConfBean.BoodoHippyConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig;
  }
  
  public static QQComicConfBean.ComicReaderConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ComicReaderConfig;
  }
  
  public static QQComicConfBean.IPExpressionConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig;
  }
  
  public static QQComicConfBean.ServiceAccountConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ServiceAccountConfig;
  }
  
  public static QQComicConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfBean", 2, "parse");
    }
    QQComicConfBean localQQComicConfBean;
    int i;
    Object localObject2;
    int j;
    int m;
    Object localObject3;
    try
    {
      localQQComicConfBean = new QQComicConfBean();
      int k = paramArrayOfQConfItem.length;
      i = 0;
      if (i >= k) {
        break label962;
      }
      localObject1 = paramArrayOfQConfItem[i];
      if (TextUtils.isEmpty(((QConfItem)localObject1).jdField_a_of_type_JavaLangString)) {
        break label1005;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfBean", 2, new Object[] { "parse, content=", ((QConfItem)localObject1).jdField_a_of_type_JavaLangString });
      }
      localObject1 = new JSONObject(((QConfItem)localObject1).jdField_a_of_type_JavaLangString);
      if (((JSONObject)localObject1).has("hippyConfig"))
      {
        localObject1 = ((JSONObject)localObject1).optJSONObject("hippyConfig");
        if (localObject1 == null) {
          break label1005;
        }
        localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig.mHippyStatus = ((JSONObject)localObject1).optInt("hippyStatus");
        localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig.mMainModuleName = ((JSONObject)localObject1).optString("mainModuleName");
        localObject2 = ((JSONObject)localObject1).optJSONArray("preloadModules");
        localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig.mPreloadModules.clear();
        j = 0;
        m = ((JSONArray)localObject2).length();
        while (j < m)
        {
          localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig.mPreloadModules.add(((JSONArray)localObject2).optString(j));
          j += 1;
        }
        localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig.mAllModules.clear();
        localObject1 = ((JSONObject)localObject1).optJSONArray("allModules");
        j = 0;
        m = ((JSONArray)localObject1).length();
        while (j < m)
        {
          localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$BoodoHippyConfig.mAllModules.add(((JSONArray)localObject1).optString(j));
          j += 1;
        }
      }
      if (((JSONObject)localObject1).has("ipEmoji"))
      {
        localObject1 = ((JSONObject)localObject1).optJSONObject("ipEmoji");
        if (localObject1 == null) {
          break label1005;
        }
        localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig.mPrefixUrl = ((JSONObject)localObject1).optString("url");
        localObject1 = ((JSONObject)localObject1).optJSONObject("matchList");
        if (localObject1 == null) {
          break label1005;
        }
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig.mExpressionMap.put(localObject3, localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$IPExpressionConfig.mPrefixUrl + ((JSONObject)localObject1).optString((String)localObject3));
        }
      }
      if (!((JSONObject)localObject1).has("webbundle")) {
        break label520;
      }
    }
    catch (Exception paramArrayOfQConfItem)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQComicConfBean", 1, new Object[] { "parse e:", paramArrayOfQConfItem.toString() });
      }
      return null;
    }
    Object localObject1 = ((JSONObject)localObject1).optJSONObject("webbundle");
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).optJSONObject("qqcomic");
      if (localObject1 != null)
      {
        localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$WebBundleConfig.jdField_a_of_type_Boolean = ((JSONObject)localObject1).optBoolean("enable", false);
        localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$WebBundleConfig.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("preload_url", "");
        break label1005;
        label520:
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
          break label1012;
        }
        localObject1 = localJSONObject.optString("minVersion");
        localObject2 = localJSONObject.optString("maxVersion");
        if (((IApolloConfigHelper)QRoute.api(IApolloConfigHelper.class)).isTargetVersion("8.5.5", (String)localObject1, (String)localObject2))
        {
          localObject2 = localJSONObject.optString("androidUrl");
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = localJSONObject.optString("url");
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1012;
          }
          localQQComicConfBean.jdField_a_of_type_JavaUtilMap.put(str, localObject1);
          QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", str, ", url=", localObject1 });
          break label1012;
        }
        QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", str, ", version not match" });
        break label1012;
        if (((JSONObject)localObject1).has("serviceAccount"))
        {
          localObject1 = ((JSONObject)localObject1).optJSONObject("serviceAccount");
          if (localObject1 != null)
          {
            QQComicConfBean.ServiceAccountConfig.a(localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ServiceAccountConfig, ((JSONObject)localObject1).optString("uin"));
            QQComicConfBean.ServiceAccountConfig.b(localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ServiceAccountConfig, ((JSONObject)localObject1).optString("url"));
          }
        }
        else if (((JSONObject)localObject1).has("comicReader"))
        {
          localObject2 = ((JSONObject)localObject1).optJSONObject("comicReader");
          if (localObject2 != null)
          {
            localObject1 = ((JSONObject)localObject2).optJSONObject("newVersion");
            if (localObject1 != null)
            {
              localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ComicReaderConfig.enableNewVersion = ((JSONObject)localObject1).optBoolean("enable");
              localObject3 = ((JSONObject)localObject1).optJSONObject("preload");
              if (localObject3 != null)
              {
                localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ComicReaderConfig.enablePreload = ((JSONObject)localObject3).optBoolean("enable");
                localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ComicReaderConfig.preloadNum = ((JSONObject)localObject3).optInt("maxNum");
              }
            }
            localObject2 = ((JSONObject)localObject2).optJSONObject("preRead");
            if (localObject1 != null)
            {
              localQQComicConfBean.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ComicReaderConfig.enablePreRead = ((JSONObject)localObject2).optBoolean("enable");
              break label1005;
              label962:
              VipComicHelper.a((String)localQQComicConfBean.jdField_a_of_type_JavaUtilMap.get("danmuAnswerUrl"));
              QLog.d("QQComicConfBean", 1, new Object[] { "parse, confBean=", localQQComicConfBean });
              return localQQComicConfBean;
            }
          }
        }
      }
      label1005:
      i += 1;
      break;
      label1012:
      j += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("qqComicConfig:").append(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$WebBundleConfig);
    localStringBuilder.append(" ,urlConfigMap:").append(this.jdField_a_of_type_JavaUtilMap);
    localStringBuilder.append(" ,serviceAccountConfig:").append(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQQComicConfBean$ServiceAccountConfig);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQComicConfBean
 * JD-Core Version:    0.7.0.1
 */