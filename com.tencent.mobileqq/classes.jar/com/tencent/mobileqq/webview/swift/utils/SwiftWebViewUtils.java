package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class SwiftWebViewUtils
{
  public static int a(int paramInt)
  {
    return paramInt & 0xFF;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + (paramInt2 << 8);
  }
  
  public static Bundle a()
  {
    if ((SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Boolean) || (SwiftWebViewUtils.CdnCacheConfig.b))
    {
      StringBuilder localStringBuilder1 = new StringBuilder("_tcvassp_0_=");
      if ((SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int != -1) && (SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList.size() != 0))
      {
        localStringBuilder1.append(SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int);
        if (SwiftWebViewUtils.CdnCacheConfig.b) {
          localObject = "shp";
        } else {
          localObject = "webp";
        }
        localStringBuilder1.append((String)localObject);
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("argument", localStringBuilder1.toString());
        ((Bundle)localObject).putStringArrayList("domains", SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("getCDNExtensionData, arg: ");
          localStringBuilder2.append(localStringBuilder1.toString());
          QLog.i("SwiftWebViewUtils", 2, localStringBuilder2.toString());
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("getCDNExtensionData, domainList: ");
          localStringBuilder1.append(TextUtils.join(", ", SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList));
          QLog.i("SwiftWebViewUtils", 2, localStringBuilder1.toString());
        }
        return localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.w("SwiftWebViewUtils", 2, "CdnCacheConfig did not parse!!!");
      }
    }
    return null;
  }
  
  public static WebResourceResponse a()
  {
    WebResourceResponse localWebResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
    Map localMap = localWebResourceResponse.getResponseHeaders();
    Object localObject = localMap;
    if (localMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("cache-control", "must-revalidate，no-store");
    localWebResourceResponse.setResponseHeaders((Map)localObject);
    return localWebResourceResponse;
  }
  
  public static String a(Intent paramIntent)
  {
    String str = "";
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("url");
      if (TextUtils.isEmpty(str))
      {
        paramIntent = paramIntent.getStringExtra("key_params_qq");
        if (paramIntent == null) {
          return "";
        }
        return paramIntent;
      }
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("url:");
    if ((paramString != null) && (paramString.length() > 512)) {
      localStringBuilder.append(paramString.substring(0, 512));
    } else {
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a()
  {
    if ((SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList.size() != 0) && (SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int != -1)) {
      return;
    }
    Object localObject1 = ClubContentJsonTask.e.a;
    localObject1 = new File(BaseApplication.getContext().getFilesDir(), (String)localObject1);
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("SwiftWebViewUtils", 2, "no WebviewCrashReport.json exists!");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = FileUtils.readFileContent((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject1 = new JSONObject((String)localObject1);
        if ((((JSONObject)localObject1).has("group_domain")) && (((JSONObject)localObject1).has("group_strategy")))
        {
          Object localObject2 = ((JSONObject)localObject1).getString("group_domain");
          localObject1 = ((JSONObject)localObject1).getString("group_strategy");
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("cdnCacheConfig, domain: ");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(", strategys: ");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.i("SwiftWebViewUtils", 2, ((StringBuilder)localObject3).toString());
          }
          localObject2 = ((String)localObject2).replace("[", "").replace("]", "").replace("\"", "").split(",");
          if (localObject2.length > 0)
          {
            SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList.clear();
            j = localObject2.length;
            i = 0;
            if (i < j)
            {
              localObject3 = localObject2[i];
              SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_JavaUtilArrayList.add(((String)localObject3).trim());
              i += 1;
              continue;
            }
          }
          int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
          localObject2 = ((String)localObject1).substring(1, ((String)localObject1).length() - 1).split("\\],\\[");
          if (localObject2.length > 0)
          {
            SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int = -1;
            int k = localObject2.length;
            i = 0;
            if (i < k)
            {
              localObject1 = localObject2[i].replace("[", "").replace("]", "").replace("\"", "");
              localObject3 = ((String)localObject1).split(",");
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("stragegy: ");
                localStringBuilder.append((String)localObject1);
                QLog.i("SwiftWebViewUtils", 2, localStringBuilder.toString());
              }
              if (localObject3.length == 3)
              {
                int m = Integer.parseInt(localObject3[0].trim());
                int n = Integer.parseInt(localObject3[1].trim());
                if ((j < m) || (j > n)) {
                  break label566;
                }
                i = Integer.parseInt(localObject3[2]);
                SwiftWebViewUtils.CdnCacheConfig.jdField_a_of_type_Int = i;
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("hit stragegy, target cdn size: ");
                  ((StringBuilder)localObject2).append(i);
                  ((StringBuilder)localObject2).append(", stragegy: ");
                  ((StringBuilder)localObject2).append((String)localObject1);
                  QLog.i("SwiftWebViewUtils", 2, ((StringBuilder)localObject2).toString());
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.e("SwiftWebViewUtils", 2, Arrays.toString((Object[])localObject3));
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.w("SwiftWebViewUtils", 2, "no cdnCacheConfig!");
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SwiftWebViewUtils", 2, "", localException);
        }
      }
      return;
      label566:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    return BaseApplication.getContext().getSharedPreferences("webview_report_config", 0).getBoolean("hide_back_text", false);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = Uri.parse(paramString);
    if (paramString.isHierarchical())
    {
      paramString = paramString.getQueryParameter("_tbs_xv");
      if ((!TextUtils.isEmpty(paramString)) && (1L == (Long.parseLong(paramString) & 1L))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      int m = Math.min(paramString1.length, paramString2.length);
      int i = 0;
      for (;;)
      {
        if ((i >= m) || (i < paramString1.length)) {}
        try
        {
          j = Integer.parseInt(paramString1[i]);
        }
        catch (Exception localException1)
        {
          int j;
          label65:
          break label65;
        }
        j = 0;
        if (i < paramString2.length) {}
        try
        {
          k = Integer.parseInt(paramString2[i]);
        }
        catch (Exception localException2)
        {
          int k;
          label84:
          break label84;
        }
        k = 0;
        if (i != m - 1)
        {
          if (k > j) {
            return true;
          }
          if (k < j) {
            return false;
          }
        }
        else
        {
          if (k >= j) {
            return true;
          }
          if (k < j) {
            return false;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    int i = 0;
    if (localObject != null)
    {
      if (!((AppRuntime)localObject).isLogin()) {
        return false;
      }
      String str = paramJSONObject.optString("platformId", "");
      if ((!"0".equals(str)) && (!"2".equals(str)))
      {
        paramString = new StringBuilder();
        paramString.append("not support Android! ");
        paramString.append(paramJSONObject.toString());
        QLog.e("SwiftWebViewUtils", 1, paramString.toString());
        return false;
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(paramJSONObject.optString("business", "")))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool1 = bool2;
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
            if (!a(paramString, "8.7.0.5295")) {
              bool1 = false;
            }
          }
        }
      }
      boolean bool2 = bool1;
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
            if (!a("8.7.0.5295", paramString)) {
              bool2 = false;
            }
          }
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        paramString = ((AppRuntime)localObject).getAccount();
        int m = paramJSONObject.optInt("startIndex");
        int k = paramJSONObject.optInt("endIndex");
        int j;
        if (m >= k)
        {
          j = paramString.length();
          if ((j >= m) && (j >= k))
          {
            m = j - m;
            k = j - k;
            if ((m < j) && (k < j) && (m <= k))
            {
              long l1 = Long.parseLong(paramString.substring(m, k + 1));
              long l2 = paramJSONObject.optLong("min");
              long l3 = paramJSONObject.optLong("max");
              if ((l1 >= l2) && (l1 <= l3))
              {
                bool1 = true;
                break label392;
              }
            }
          }
        }
        bool1 = false;
        label392:
        if (!bool1)
        {
          localObject = paramJSONObject.optString("uinWhiteList");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).split(";");
            j = localObject.length;
            while (i < j)
            {
              if (paramString.equals(localObject[i]))
              {
                bool1 = true;
                break;
              }
              i += 1;
            }
          }
        }
      }
      if (!bool1)
      {
        paramString = new StringBuilder();
        paramString.append("Config is not valid: ");
        paramString.append(paramJSONObject);
        QLog.e("SwiftWebViewUtils", 1, paramString.toString());
      }
      return bool1;
    }
    return false;
  }
  
  public static int b(int paramInt)
  {
    return paramInt >> 8 & 0xFF;
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(":");
      if (i > 0) {
        return paramString.substring(0, i).toLowerCase();
      }
    }
    return "";
  }
  
  public static boolean b()
  {
    int i = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[14].intValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSupportPreRend: ");
    localStringBuilder.append(i);
    QLog.d("SwiftWebViewUtils", 1, localStringBuilder.toString());
    return i == 1;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      int m = Math.max(paramString1.length, paramString2.length);
      int i = 0;
      for (;;)
      {
        if ((i >= m) || (i < paramString1.length)) {}
        try
        {
          j = Integer.parseInt(paramString1[i]);
        }
        catch (Exception localException1)
        {
          int j;
          label65:
          break label65;
        }
        j = 0;
        if (i < paramString2.length) {}
        try
        {
          k = Integer.parseInt(paramString2[i]);
        }
        catch (Exception localException2)
        {
          int k;
          label84:
          break label84;
        }
        k = 0;
        if (i != m - 1)
        {
          if (k > j) {
            return true;
          }
          if (k < j) {
            return false;
          }
        }
        else
        {
          if (k >= j) {
            return true;
          }
          if (k < j) {
            return false;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("Dalvik/");
    localStringBuilder.append(System.getProperty("java.vm.version"));
    localStringBuilder.append(" (Linux; U; Android ");
    String str = Build.VERSION.RELEASE;
    if (str.length() <= 0) {
      str = "1.0";
    }
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
  }
  
  public static String d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.indexOf(":");
      if (k > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("?#");
        int j = localStringBuilder.toString().indexOf("?");
        int i = j;
        if (j > 50) {
          i = 50;
        }
        j = k + 3;
        if ((j < paramString.length()) && (i >= 0)) {
          return paramString.substring(j, i);
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils
 * JD-Core Version:    0.7.0.1
 */