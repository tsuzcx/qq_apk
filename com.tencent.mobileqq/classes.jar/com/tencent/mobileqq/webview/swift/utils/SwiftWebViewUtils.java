package com.tencent.mobileqq.webview.swift.utils;

import akqx;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class SwiftWebViewUtils
{
  public static Bundle a()
  {
    if ((SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Boolean) || (SwiftWebViewUtils.CdnCacheConfig.b))
    {
      StringBuilder localStringBuilder = new StringBuilder("_tcvassp_0_=");
      if ((SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int != -1) && (SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList.size() != 0))
      {
        localStringBuilder.append(SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int);
        if (SwiftWebViewUtils.CdnCacheConfig.b) {}
        for (Object localObject = "shp";; localObject = "webp")
        {
          localStringBuilder.append((String)localObject);
          localObject = new Bundle();
          ((Bundle)localObject).putString("argument", localStringBuilder.toString());
          ((Bundle)localObject).putStringArrayList("domains", SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList);
          if (QLog.isColorLevel())
          {
            QLog.i("SwiftWebViewUtils", 2, "getCDNExtensionData, arg: " + localStringBuilder.toString());
            QLog.i("SwiftWebViewUtils", 2, "getCDNExtensionData, domainList: " + TextUtils.join(", ", SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList));
          }
          return localObject;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("SwiftWebViewUtils", 2, "CdnCacheConfig did not parse!!!");
      }
    }
    return null;
  }
  
  public static Bundle a(WebViewFragment paramWebViewFragment, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    Object localObject = Uri.parse(paramWebViewFragment.g);
    paramIntent = localBundle;
    if (localObject != null)
    {
      localObject = ((Uri)localObject).getHost();
      paramIntent = localBundle;
      if (Build.VERSION.SDK_INT >= 19) {
        if (!PublicAccountUtil.d((String)localObject))
        {
          paramIntent = localBundle;
          if (!"buluo.qq.com".equalsIgnoreCase((String)localObject)) {}
        }
        else
        {
          paramWebViewFragment.a.evaluateJavascript("document.querySelector(\"meta[itemprop='name']\").getAttribute('content')", new akqx(paramWebViewFragment));
          paramIntent = null;
        }
      }
    }
    return paramIntent;
  }
  
  public static String a(Intent paramIntent)
  {
    Object localObject = "";
    if (paramIntent != null)
    {
      String str = paramIntent.getStringExtra("url");
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        paramIntent = paramIntent.getStringExtra("key_params_qq");
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = "";
        }
      }
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(":");
      if (i > 0) {
        return paramString.substring(0, i);
      }
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str1;
    String str2;
    label58:
    int i;
    Object localObject;
    switch ()
    {
    case 0: 
    default: 
      str1 = "";
      str2 = "";
      if (WebpSoLoader.b())
      {
        str2 = " WebP/0.3.1";
        if (!TextUtils.isEmpty(str2)) {
          SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Boolean = true;
        }
        SwiftWebViewUtils.CdnCacheConfig.b = paramBoolean;
        i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = paramString1;
        if (paramString1 == null) {
          localObject = "";
        }
        localObject = localStringBuilder.append((String)localObject).append(" ").append(QZoneHelper.a());
        if (!TextUtils.isEmpty(paramString2)) {
          break label286;
        }
      }
      break;
    }
    label286:
    for (paramString1 = "";; paramString1 = " " + paramString2)
    {
      return paramString1 + " QQ/" + "7.6.3" + "." + "3560" + str1 + str2 + " Pixel/" + i;
      str1 = " NetType/UNKNOWN";
      break;
      str1 = " NetType/WIFI";
      break;
      str1 = " NetType/2G";
      break;
      str1 = " NetType/3G";
      break;
      str1 = " NetType/4G";
      break;
      localObject = WebpSoLoader.a();
      if (paramBoolean)
      {
        str2 = " WebP/0.3.0";
        break label58;
      }
      if (localObject == null) {
        break label58;
      }
      str2 = String.format(" WebP/%d.%d.%d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]), Integer.valueOf(localObject[2]) });
      break label58;
    }
  }
  
  public static void a()
  {
    int j = 0;
    if ((SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList.size() != 0) && (SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int != -1)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), ClubContentJsonTask.e.jdField_a_of_type_JavaLangString);
      if (((File)localObject1).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("SwiftWebViewUtils", 2, "no WebviewCrashReport.json exists!");
    return;
    for (;;)
    {
      int i;
      String[] arrayOfString;
      try
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = new JSONObject((String)localObject1);
        if ((!((JSONObject)localObject1).has("group_domain")) || (!((JSONObject)localObject1).has("group_strategy"))) {
          break label520;
        }
        Object localObject2 = ((JSONObject)localObject1).getString("group_domain");
        localObject1 = ((JSONObject)localObject1).getString("group_strategy");
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewUtils", 2, "cdnCacheConfig, domain: " + (String)localObject2 + ", strategys: " + (String)localObject1);
        }
        localObject2 = ((String)localObject2).replace("[", "").replace("]", "").replace("\"", "").split(",");
        if (localObject2.length > 0)
        {
          SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList.clear();
          k = localObject2.length;
          i = 0;
          if (i < k)
          {
            arrayOfString = localObject2[i];
            SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList.add(arrayOfString.trim());
            i += 1;
            continue;
          }
        }
        int k = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
        localObject1 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1).split("\\],\\[");
        if (localObject1.length <= 0) {
          break;
        }
        SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int = -1;
        int m = localObject1.length;
        i = j;
        if (i >= m) {
          break;
        }
        localObject2 = localObject1[i].replace("[", "").replace("]", "").replace("\"", "");
        arrayOfString = ((String)localObject2).split(",");
        if (QLog.isColorLevel()) {
          QLog.i("SwiftWebViewUtils", 2, "stragegy: " + (String)localObject2);
        }
        if (arrayOfString.length != 3) {
          break label502;
        }
        j = Integer.parseInt(arrayOfString[0].trim());
        int n = Integer.parseInt(arrayOfString[1].trim());
        if ((k < j) || (k > n)) {
          break label536;
        }
        i = Integer.parseInt(arrayOfString[2]);
        SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SwiftWebViewUtils", 2, "hit stragegy, target cdn size: " + i + ", stragegy: " + (String)localObject2);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SwiftWebViewUtils", 2, "", localException);
      return;
      label502:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SwiftWebViewUtils", 2, Arrays.toString(arrayOfString));
      return;
      label520:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("SwiftWebViewUtils", 2, "no cdnCacheConfig!");
      return;
      label536:
      i += 1;
    }
  }
  
  public static void a(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (paramWebView.getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("address", paramString);
      paramWebView.getX5WebViewExtension().invokeMiscMethod("setHttpSystemProxy", localBundle);
    }
  }
  
  public static boolean a()
  {
    int i = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[14].intValue();
    QLog.d("SwiftWebViewUtils", 1, "isSupportPreRend: " + i);
    return i == 1;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = Uri.parse(paramString);
      } while (!paramString.isHierarchical());
      paramString = paramString.getQueryParameter("_tbs_xv");
    } while ((TextUtils.isEmpty(paramString)) || (1L != (Long.parseLong(paramString) & 1L)));
    return true;
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    int i = 0;
    boolean bool1 = false;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = bool1;
    if (localObject != null)
    {
      if (!((AppRuntime)localObject).isLogin()) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    String str = paramJSONObject.optString("platformId", "");
    if ((!"0".equals(str)) && (!"2".equals(str)))
    {
      QLog.e("SwiftWebViewUtils", 1, "not support Android! " + paramJSONObject.toString());
      return false;
    }
    label127:
    int j;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(paramJSONObject.optString("business", ""))))
    {
      bool2 = true;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramJSONObject.has("minVersion"))
        {
          paramString = paramJSONObject.optString("minVersion");
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString))
          {
            bool1 = bool2;
            if (!IndividuationUrlHelper.a(paramString, "7.6.3.3560")) {
              bool1 = false;
            }
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramJSONObject.has("maxVersion"))
        {
          paramString = paramJSONObject.optString("maxVersion");
          bool2 = bool1;
          if (!TextUtils.isEmpty(paramString))
          {
            bool2 = bool1;
            if (!IndividuationUrlHelper.a("7.6.3.3560", paramString)) {
              bool2 = false;
            }
          }
        }
      }
      bool1 = bool2;
      if (!bool2) {
        break label503;
      }
      paramString = ((AppRuntime)localObject).getAccount();
      int m = paramJSONObject.optInt("startIndex");
      int k = paramJSONObject.optInt("endIndex");
      if (m < k) {
        break label506;
      }
      j = paramString.length();
      if ((j < m) || (j < k)) {
        break label506;
      }
      m = j - m;
      k = j - k;
      if ((m >= j) || (k >= j) || (m > k)) {
        break label506;
      }
      long l1 = Long.parseLong(paramString.substring(m, k + 1));
      long l2 = paramJSONObject.optLong("min");
      long l3 = paramJSONObject.optLong("max");
      if ((l1 < l2) || (l1 > l3)) {
        break label506;
      }
    }
    label429:
    label503:
    label506:
    for (bool2 = true;; bool2 = false)
    {
      bool1 = bool2;
      if (!bool2)
      {
        localObject = paramJSONObject.optString("uinWhiteList");
        bool1 = bool2;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          j = localObject.length;
          bool1 = bool2;
          if (i < j) {
            if (paramString.equals(localObject[i])) {
              bool1 = true;
            }
          }
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        QLog.e("SwiftWebViewUtils", 1, "Config is not valid: " + paramJSONObject);
        return bool1;
        bool2 = false;
        break label127;
        i += 1;
        break label429;
      }
    }
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("Dalvik/");
    localStringBuilder.append(System.getProperty("java.vm.version"));
    localStringBuilder.append(" (Linux; U; Android ");
    String str = Build.VERSION.RELEASE;
    if (str.length() > 0) {}
    for (;;)
    {
      localStringBuilder.append(str);
      if ("REL".equals(Build.VERSION.CODENAME))
      {
        str = Build.MODEL;
        if (str.length() > 0)
        {
          localStringBuilder.append("; ");
          localStringBuilder.append(str);
        }
      }
      str = Build.ID;
      if (str.length() > 0)
      {
        localStringBuilder.append(" Build/");
        localStringBuilder.append(str);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      str = "1.0";
    }
  }
  
  public static void b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("x5_proxy_setting", 4);
    SwiftWebViewUtils.ProxyConfig.jdField_a_of_type_JavaLangString = localSharedPreferences.getString("http_proxy_address", "");
    SwiftWebViewUtils.ProxyConfig.jdField_a_of_type_Boolean = localSharedPreferences.contains("need_set_proxy");
    localSharedPreferences.edit().remove("need_set_proxy").apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils
 * JD-Core Version:    0.7.0.1
 */