package com.tencent.qqmini.sdk.launcher.core.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo;
import com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ApkgInfo
  extends ApkgBaseInfo
{
  public static final int DOMIAN_TYPE_DOWNLOAD = 2;
  public static final int DOMIAN_TYPE_REQUEST = 0;
  public static final int DOMIAN_TYPE_UPLOAD = 3;
  public static final int DOMIAN_TYPE_WEBSOCKET = 1;
  public static final int DOMIAN_TYPE_WEBVIEW = 4;
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
  public MiniAppInfo mMiniAppInfo;
  private Map<String, String> mPageJsMap = new HashMap();
  
  public ApkgInfo() {}
  
  public ApkgInfo(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    super(paramString, paramMiniAppInfo);
    this.mMiniAppInfo = paramMiniAppInfo;
  }
  
  public static ApkgInfo loadApkgInfoFromFolderPath(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return null;
    }
    paramString1 = new ApkgInfo(paramString1, paramMiniAppInfo);
    paramString1.init(paramString2);
    return paramString1;
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
  
  public AppConfigInfo getAppConfigInfo()
  {
    return this.mAppConfigInfo;
  }
  
  public String getAppServiceJsContent(String paramString)
  {
    return FileUtils.readFileToStr(new File(getAppServiceJsPath(paramString)));
  }
  
  public String getAppServiceJsPath()
  {
    return getApkgFolderPath() + "/" + "app-service.js";
  }
  
  public String getAppServiceJsPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return getApkgFolderPath() + "/" + "app-service.js";
    }
    return new File(new File(getApkgFolderPath(), paramString), "app-service.js").getAbsolutePath();
  }
  
  public boolean getDebug()
  {
    if (this.mAppConfigInfo != null) {
      return this.mAppConfigInfo.debug;
    }
    return false;
  }
  
  public String getPageFrameHtmlUrl()
  {
    return "https://servicewechat.com/page-frame.html";
  }
  
  public String getPageFrameJSStr(String paramString)
  {
    paramString = this.mAppConfigInfo.getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(new File(getApkgFolderPath(), paramString), "page-frame.js");
    if (paramString.exists()) {
      return FileUtils.readFileToStr(paramString);
    }
    return "";
  }
  
  public ApkgInfo.PageHtmlContent getPageHtmlContent(String paramString)
  {
    Object localObject = new File(getApkgFolderPath(), "page-frame.html");
    ApkgInfo.PageHtmlContent localPageHtmlContent = new ApkgInfo.PageHtmlContent();
    if (!((File)localObject).exists())
    {
      localPageHtmlContent.htmlStr = paramString;
      return localPageHtmlContent;
    }
    try
    {
      paramString = FileUtils.readFileToStr((File)localObject);
      localObject = paramString.substring(paramString.indexOf("<script>") + "<script>".length(), paramString.indexOf("</script>"));
      localPageHtmlContent.htmlStr = paramString;
      localPageHtmlContent.jsStr = ((String)localObject);
      return localPageHtmlContent;
    }
    catch (Exception paramString) {}
    return localPageHtmlContent;
  }
  
  public String getPageJsStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str2;
    String str1;
    do
    {
      return paramString;
      str2 = normalize(paramString);
      str1 = (String)this.mPageJsMap.get(str2);
      paramString = str1;
    } while (!TextUtils.isEmpty(str1));
    paramString = str1;
    try
    {
      String str3 = FileUtils.readFileToString(new File(getApkgFolderPath(), str2));
      paramString = str1;
      str1 = str3.substring(str3.indexOf("<script>") + "<script>".length(), str3.indexOf("</script>"));
      paramString = str1;
      this.mPageJsMap.put(str2, str1);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return paramString;
  }
  
  public String getRootPath(String paramString)
  {
    if (this.mAppConfigInfo != null) {
      return this.mAppConfigInfo.getRootPath(paramString);
    }
    return null;
  }
  
  public String getRootWxssJsContent()
  {
    File localFile = new File(new File(getApkgFolderPath()), "app-wxss.js");
    if (localFile.exists()) {
      return FileUtils.readFileToStr(localFile);
    }
    return "";
  }
  
  public String getWorkerJsContent(String paramString1, String paramString2)
  {
    return FileUtils.readFileToStr(new File(getWorkerPath(paramString1, paramString2)));
  }
  
  public String getWorkerPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return getApkgFolderPath() + File.separator + paramString2;
    }
    return new File(new File(getApkgFolderPath(), paramString1), paramString2).getAbsolutePath();
  }
  
  public void init(String paramString)
  {
    if (paramString != null) {}
    for (this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath() + "/" + paramString, "app-config.json"));; this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath(), "app-config.json")))
    {
      JSONObject localJSONObject = new JSONObject(this.mConfigStr);
      paramString = new JSONObject();
      paramString.put("USER_DATA_PATH", "wxfile://usr");
      localJSONObject.put("env", paramString);
      String str2 = localJSONObject.optString("entryPagePath");
      paramString = null;
      if (this.mMiniAppInfo != null) {
        paramString = this.mMiniAppInfo.launchParam.entryPath;
      }
      String str1 = paramString;
      if (!isUrlFileExist(paramString)) {
        str1 = str2;
      }
      paramString = AppBrandUtil.getAppLaunchInfo(str1, this.mMiniAppInfo);
      QMLog.d("ApkgInfo", "appLaunchInfo : " + paramString.toString());
      localJSONObject.put("appLaunchInfo", paramString);
      this.mConfigStr = localJSONObject.toString();
      this.mAppConfigInfo = AppConfigInfo.parseAppConfig(localJSONObject);
      return;
    }
  }
  
  public boolean isHomePage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = AppBrandUtil.getUrlWithoutParams(paramString);
    } while ((!isTabBarPage(paramString)) && (!paramString.equals(this.mAppConfigInfo.entryPagePath)));
    return true;
  }
  
  public boolean isTabBarPage(String paramString)
  {
    String str = AppBrandUtil.getUrlWithoutParams(paramString);
    if (this.mAppConfigInfo != null) {}
    for (paramString = this.mAppConfigInfo.tabBarInfo; paramString != null; paramString = null)
    {
      paramString = paramString.list.iterator();
      do
      {
        if (!paramString.hasNext()) {
          break;
        }
      } while (!((TabBarInfo.ButtonInfo)paramString.next()).pagePath.equals(str));
      return true;
    }
    return false;
  }
  
  public boolean isUrlFileExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(getChildFileAbsolutePath(AppBrandUtil.getUrlWithoutParams(paramString))).exists()) {
      return false;
    }
    return true;
  }
  
  public boolean isUrlResReady(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    paramString = getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      return true;
      paramString = new File(ApkgManager.getApkgFolderPath(paramMiniAppInfo), paramString).getAbsolutePath();
      bool = new File(paramString).exists();
      QMLog.d("ApkgInfo", "isUrlResReady | subFolderPath :" + paramString + "isExist:" + bool);
    } while (bool);
    return false;
  }
  
  public boolean isValidPrefix(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("https://")) && (!paramString.startsWith("wss://")) && (!paramString.startsWith("ws://")) && (!paramString.startsWith("http://")))) {}
    }
    while ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("wss://"))))
    {
      return true;
      return false;
    }
    return false;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo
 * JD-Core Version:    0.7.0.1
 */