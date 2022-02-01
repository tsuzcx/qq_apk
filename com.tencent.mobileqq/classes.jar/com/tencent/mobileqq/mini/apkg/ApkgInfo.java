package com.tencent.mobileqq.mini.apkg;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ApkgInfo
  extends ApkgBaseInfo
{
  private static final String NAME_APP_SERVICE_JS = "app-service.js";
  private static final String NAME_CONFIG_JSON = "app-config.json";
  private static final String NAME_PAGE_FRAME_HTML = "page-frame.html";
  private static final String NAME_PAGE_FRAME_JS = "page-frame.js";
  private static final String NAME_WXSS_JS = "app-wxss.js";
  private static final String TAG = "ApkgInfo";
  public static final int URL_OPEN_TYPE_EXTERNAL = 1;
  public static final int URL_OPEN_TYPE_INTERNAL = 0;
  private Map<String, Bitmap> bitmapCache = new HashMap();
  public AppConfigInfo mAppConfigInfo;
  private Map<String, String> mPageJsMap = new HashMap();
  
  public ApkgInfo(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    super(paramString, paramMiniAppConfig);
  }
  
  public static ApkgInfo loadApkgInfoFromFolderPath(String paramString1, String paramString2, MiniAppConfig paramMiniAppConfig)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists()))
    {
      paramString1 = new ApkgInfo(paramString1, paramMiniAppConfig);
      paramString1.init(paramString2);
      paramString2 = paramString1.mAppConfigInfo.networkTimeoutInfo;
      MiniOkHttpClientFactory.init(paramString2.request, paramString2.uploadFile, paramString2.downloadFile);
      return paramString1;
    }
    return null;
  }
  
  public static String normalize(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int j = paramString.indexOf("?");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public Bitmap getBitmap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Bitmap localBitmap2 = (Bitmap)this.bitmapCache.get(paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = ImageUtil.getLocalBitmap(paramString);
      this.bitmapCache.put(paramString, localBitmap1);
    }
    return localBitmap1;
  }
  
  public boolean getDebug()
  {
    AppConfigInfo localAppConfigInfo = this.mAppConfigInfo;
    if (localAppConfigInfo != null) {
      return localAppConfigInfo.debug;
    }
    return false;
  }
  
  public String getPageJsStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = normalize(paramString);
    String str1 = (String)this.mPageJsMap.get(localObject);
    paramString = str1;
    if (TextUtils.isEmpty(str1))
    {
      paramString = str1;
      try
      {
        String str2 = FileUtils.readFileToString(new File(getApkgFolderPath(), (String)localObject));
        paramString = str1;
        str1 = str2.substring(str2.indexOf("<script>") + 8, str2.indexOf("</script>"));
        paramString = str1;
        this.mPageJsMap.put(localObject, str1);
        return str1;
      }
      catch (Throwable localThrowable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getPageJsStr error.");
        ((StringBuilder)localObject).append(localThrowable);
        QLog.e("ApkgInfo", 1, ((StringBuilder)localObject).toString());
        localThrowable.printStackTrace();
      }
    }
    return paramString;
  }
  
  public String getRootPath(String paramString)
  {
    return this.mAppConfigInfo.getRootPath(paramString);
  }
  
  public int getURLOpenType(String paramString)
  {
    if ("fbf1c3b512b1e5f14b1c8629c8677961".equals(this.appConfig.config.appId)) {
      return 1;
    }
    return 0;
  }
  
  public String getWorkerPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append(getApkgFolderPath());
      paramString1.append(File.separator);
      paramString1.append(paramString2);
      return paramString1.toString();
    }
    return new File(new File(getApkgFolderPath(), paramString1), paramString2).getAbsolutePath();
  }
  
  public void init(String paramString)
  {
    if (paramString != null) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getApkgFolderPath());
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      this.mConfigStr = FileUtils.readFileToString(new File(localStringBuilder.toString(), "app-config.json"));
      break label77;
      this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath(), "app-config.json"));
      label77:
      updateConfigStr(this.mConfigStr);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean isHomePage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = AppBrandUtil.getUrlWithoutParams(paramString);
    return (isTabBarPage(paramString)) || (paramString.equals(this.mAppConfigInfo.entryPagePath));
  }
  
  public boolean isTabBarPage(String paramString)
  {
    paramString = AppBrandUtil.getUrlWithoutParams(paramString);
    Object localObject = this.mAppConfigInfo.tabBarInfo;
    if (localObject != null)
    {
      localObject = ((TabBarInfo)localObject).list.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TabBarInfo.ButtonInfo)((Iterator)localObject).next()).pagePath.equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isUrlFileExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(getFilePath(AppBrandUtil.getUrlWithoutParams(paramString))).exists();
  }
  
  public boolean isUrlResReady(String paramString)
  {
    paramString = getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramString = new File(ApkgManager.getApkgFolderPath(this.appConfig.config), paramString).getAbsolutePath();
    boolean bool = new File(paramString).exists();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUrlResReady | subFolderPath :");
      localStringBuilder.append(paramString);
      localStringBuilder.append("isExist:");
      localStringBuilder.append(bool);
      QLog.d("ApkgInfo", 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void setDebug(boolean paramBoolean)
  {
    if (paramBoolean == this.mAppConfigInfo.debug) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(this.mConfigStr);
      ((JSONObject)localObject).put("debug", paramBoolean);
      localObject = ((JSONObject)localObject).toString().replaceAll("\\\\", "");
      FileUtils.writeFile(new File(getApkgFolderPath(), "app-config.json").getAbsolutePath(), (String)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void updateConfigStr(String paramString)
  {
    for (;;)
    {
      try
      {
        this.mConfigStr = paramString;
        JSONObject localJSONObject = new JSONObject(this.mConfigStr);
        paramString = new JSONObject();
        paramString.put("USER_DATA_PATH", "wxfile://usr");
        localJSONObject.put("env", paramString);
        String str = localJSONObject.optString("entryPagePath");
        paramString = this.appConfig;
        MiniAppInfo localMiniAppInfo = null;
        if (paramString == null) {
          break label187;
        }
        LaunchParam localLaunchParam2 = this.appConfig.launchParam;
        if (localLaunchParam2 != null)
        {
          paramString = localLaunchParam2.entryPath;
          localLaunchParam1 = localLaunchParam2;
          localObject = paramString;
          if (this.appConfig.config != null)
          {
            localMiniAppInfo = this.appConfig.config;
            localLaunchParam1 = localLaunchParam2;
            localObject = paramString;
          }
          if (isUrlFileExist((String)localObject)) {
            break label194;
          }
          paramString = str;
          localJSONObject.put("appLaunchInfo", AppBrandUtil.getAppLaunchInfo(paramString, localLaunchParam1, localMiniAppInfo));
          this.mConfigStr = localJSONObject.toString();
          this.mAppConfigInfo = AppConfigInfo.parseAppConfig(this.mConfigStr, this);
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = null;
      continue;
      label187:
      LaunchParam localLaunchParam1 = null;
      Object localObject = localLaunchParam1;
      continue;
      label194:
      paramString = (String)localObject;
    }
  }
  
  public void updateMiniConfig(MiniAppConfig paramMiniAppConfig)
  {
    String str = this.appConfig.config.version;
    this.appConfig = paramMiniAppConfig;
    this.appConfig.config.version = str;
    init(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgInfo
 * JD-Core Version:    0.7.0.1
 */