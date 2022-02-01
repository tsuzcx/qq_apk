package com.tencent.mobileqq.identification;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.util.FaceSharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceConfigManager
{
  public static int a()
  {
    return 32;
  }
  
  public static ConfigItem a()
  {
    try
    {
      ConfigItem localConfigItem = a(new JSONObject("{\n\"name\": \"new_qq_android_native_short_new_other_7\",\n\"arm_url\": \"\",\n\"armv7a_url\": \"https://downv6.qq.com/faceIdentify/new_qq_android_native_short_other_new_7_7.zip\",\n\"arm64v8a_url\": \"https://downv6.qq.com/faceIdentify/new_qq_android_native_short_other_new64_7_7.zip\",\n\"x86_url\": \" \",\n\"arm_md5\": \" \",\n\"arm64v8a_md5\": \"b2a772fb3347f863a2ec69b4459d5869\",\n\"armv7a_md5\": \"c2efd14194e1f7c6af3b75c9e5bd0414\",\n\"x86_md5\": \"\",\n\"versionCode\": \"7\",\n\"predownload\": false\n}"));
      return localConfigItem;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("FaceConfigManager", 1, "getDefaultConfig error : ", localJSONException);
    }
    return null;
  }
  
  public static ConfigItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          if (localJSONObject.getString("name").startsWith("new_qq_android_native_short_new_other")) {
            return a(localJSONObject);
          }
        }
        else
        {
          QLog.d("FaceConfigManager", 1, "no face config");
          return null;
        }
      }
      catch (JSONException paramString)
      {
        QLog.d("FaceConfigManager", 1, "getFaceConfig JSONException : ", paramString);
        return null;
      }
      i += 1;
    }
  }
  
  private static ConfigItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      ConfigItem localConfigItem = new ConfigItem();
      localConfigItem.jdField_a_of_type_JavaLangString = paramJSONObject.getString("name");
      localConfigItem.f = paramJSONObject.getString("arm_md5");
      localConfigItem.g = paramJSONObject.getString("armv7a_md5");
      localConfigItem.i = paramJSONObject.getString("arm64v8a_md5");
      localConfigItem.h = paramJSONObject.getString("x86_md5");
      localConfigItem.b = paramJSONObject.getString("arm_url");
      localConfigItem.e = paramJSONObject.getString("arm64v8a_url");
      localConfigItem.c = paramJSONObject.getString("armv7a_url");
      localConfigItem.d = paramJSONObject.getString("x86_url");
      localConfigItem.jdField_a_of_type_Int = paramJSONObject.getInt("versionCode");
      return localConfigItem;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.d("FaceConfigManager", 1, "json2ConfigObj error : ", paramJSONObject);
    }
    return null;
  }
  
  public static String a()
  {
    return FaceSharedPreUtils.b();
  }
  
  public static String a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/YT_identify_new/");
    return localStringBuilder.toString();
  }
  
  public static String a(ConfigItem paramConfigItem)
  {
    return paramConfigItem.c;
  }
  
  public static void a(FaceConfigDownloader.IDownloadCallback paramIDownloadCallback)
  {
    FaceConfigDownloader.a(a(), a(BaseApplication.getContext()), paramIDownloadCallback);
  }
  
  public static void a(AppRuntime paramAppRuntime, FaceConfigDownloader.IConfigObserver paramIConfigObserver)
  {
    QLog.d("FaceConfigManager", 1, "requestConfigJson");
    FaceConfigDownloader.a(paramAppRuntime, paramIConfigObserver);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, FaceConfigDownloader.IDownloadCallback paramIDownloadCallback)
  {
    paramString = a(paramString);
    if (FaceConfigChecker.a(paramString))
    {
      QLog.d("FaceConfigManager", 1, "config is valid");
      FaceConfigDownloader.a(paramString, a(BaseApplication.getContext()), paramIDownloadCallback);
      return;
    }
    if ((paramString != null) && (!FaceConfigChecker.b(paramString)))
    {
      QLog.d("FaceConfigManager", 1, "config version limit, download default config");
      a(paramIDownloadCallback);
      return;
    }
    QLog.d("FaceConfigManager", 1, "download config first");
    a(paramAppRuntime, new FaceConfigManager.1(paramAppRuntime, paramIDownloadCallback));
  }
  
  public static boolean a()
  {
    return FaceConfigChecker.a(FaceSharedPreUtils.a());
  }
  
  public static String b(ConfigItem paramConfigItem)
  {
    return paramConfigItem.g;
  }
  
  public static boolean b()
  {
    if (FaceConfigChecker.c(a(a()))) {
      return true;
    }
    if (!c()) {
      return true;
    }
    return FaceConfigChecker.b() ^ true;
  }
  
  public static boolean c()
  {
    return FaceConfigChecker.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceConfigManager
 * JD-Core Version:    0.7.0.1
 */