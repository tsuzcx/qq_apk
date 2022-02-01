package com.tencent.qqmini.sdk.launcher.core.model;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo;
import com.tencent.qqmini.sdk.launcher.utils.ApkgFileUtils;
import com.tencent.qqmini.sdk.launcher.utils.ApkgFileUtils.WxapkgFile;
import com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.utils.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
  private static final String NAME_MAIN_APKG = "mini.qapkg";
  private static final String NAME_PAGE_FRAME_HTML = "page-frame.html";
  private static final String NAME_PAGE_FRAME_JS = "page-frame.js";
  private static final String NAME_WXSS_JS = "app-wxss.js";
  private static final String SUFFIX_WXAPKG = ".qapkg";
  private static final String TAG = "ApkgInfo";
  public static final int URL_OPEN_TYPE_EXTERNAL = 1;
  public static final int URL_OPEN_TYPE_INTERNAL = 0;
  private Map<String, Bitmap> bitmapCache = new HashMap();
  private HashMap<String, HashMap<String, ApkgFileUtils.WxapkgFile>> fileMap = new HashMap();
  private boolean isReadApkg;
  public AppConfigInfo mAppConfigInfo;
  public MiniAppInfo mMiniAppInfo;
  private Map<String, String> mPageJsMap = new HashMap();
  
  public ApkgInfo() {}
  
  public ApkgInfo(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    super(paramString, paramMiniAppInfo);
    this.mMiniAppInfo = paramMiniAppInfo;
    if (!paramMiniAppInfo.launchParam.isFlutterMode) {}
    for (boolean bool = true;; bool = false)
    {
      this.isReadApkg = bool;
      return;
    }
  }
  
  public static boolean initNetwork(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo != null) {}
    try
    {
      if ((paramApkgInfo.mAppConfigInfo == null) || (paramApkgInfo.mAppConfigInfo.networkTimeoutInfo == null))
      {
        QMLog.e("ApkgInfo", "initNetwork param is wrong");
        return false;
      }
      SpecialProxy localSpecialProxy = (SpecialProxy)AppLoaderFactory.g().getProxyManager().get(SpecialProxy.class);
      if (localSpecialProxy != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("NetworkTimeOutInfo", paramApkgInfo.mAppConfigInfo.networkTimeoutInfo);
        localSpecialProxy.sendEventToHost(2, localBundle, null);
      }
      return true;
    }
    catch (Throwable paramApkgInfo)
    {
      QMLog.e("ApkgInfo", "initNetwork failed", paramApkgInfo);
    }
    return false;
  }
  
  public static ApkgInfo loadApkgInfoFromFolderPath(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (!new File(paramString1).exists())) {
      return null;
    }
    paramString1 = new ApkgInfo(paramString1, paramMiniAppInfo);
    paramString1.init(paramString2);
    QMLog.e("ApkgInfo", "loadApkgInfoFromFolderPath initNetwork");
    initNetwork(paramString1);
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
  
  public File getApkgFile(String paramString)
  {
    paramString = getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return new File(getApkgFolderPath(), "mini.qapkg");
    }
    paramString = paramString.replaceAll("/", "");
    return new File(getApkgFolderPath(), paramString + ".qapkg");
  }
  
  public AppConfigInfo getAppConfigInfo()
  {
    return this.mAppConfigInfo;
  }
  
  public String getAppServiceJsContent()
  {
    try
    {
      if (this.isReadApkg) {
        return readApkgToString("app-service.js");
      }
      String str = FileUtils.readFileToString(new File(getAppServiceJsPath()));
      return str;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return "";
  }
  
  public String getAppServiceJsContent(String paramString)
  {
    if (this.isReadApkg)
    {
      if (TextUtils.isEmpty(paramString)) {
        return readApkgToString("mini.qapkg");
      }
      if (paramString.endsWith("/")) {
        return readApkgToString(paramString + "app-service.js");
      }
      return readApkgToString(paramString + File.separator + "app-service.js");
    }
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
    if (this.isReadApkg)
    {
      if (paramString.endsWith("/")) {
        return readApkgToString(paramString + "page-frame.js");
      }
      return readApkgToString(paramString + File.separator + "page-frame.js");
    }
    paramString = new File(new File(getApkgFolderPath(), paramString), "page-frame.js");
    if (paramString.exists()) {
      return FileUtils.readFileToStr(paramString);
    }
    return "";
  }
  
  public ApkgInfo.PageHtmlContent getPageHtmlContent(String paramString)
  {
    ApkgInfo.PageHtmlContent localPageHtmlContent = new ApkgInfo.PageHtmlContent();
    Object localObject;
    if (this.isReadApkg)
    {
      String str = readApkgToString("page-frame.html");
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localPageHtmlContent.htmlStr = paramString;
        return localPageHtmlContent;
      }
    }
    else
    {
      localObject = new File(getApkgFolderPath(), "page-frame.html");
      if (!((File)localObject).exists())
      {
        localPageHtmlContent.htmlStr = paramString;
        return localPageHtmlContent;
      }
      localObject = FileUtils.readFileToStr((File)localObject);
    }
    paramString = ((String)localObject).substring(((String)localObject).indexOf("<script>") + "<script>".length(), ((String)localObject).indexOf("</script>"));
    localPageHtmlContent.htmlStr = ((String)localObject);
    localPageHtmlContent.jsStr = paramString;
    return localPageHtmlContent;
  }
  
  public String getPageJsStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    String str3;
    do
    {
      return str1;
      str3 = normalize(paramString);
      paramString = (String)this.mPageJsMap.get(str3);
      str1 = paramString;
    } while (!TextUtils.isEmpty(paramString));
    String str1 = paramString;
    for (;;)
    {
      try
      {
        if (this.isReadApkg)
        {
          str1 = paramString;
          str2 = readApkgToString(str3);
          str1 = paramString;
          paramString = str2.substring(str2.indexOf("<script>") + "<script>".length(), str2.indexOf("</script>"));
          str1 = paramString;
          this.mPageJsMap.put(str3, paramString);
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return str1;
      }
      str1 = paramString;
      String str2 = FileUtils.readFileToString(new File(getApkgFolderPath(), str3));
    }
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
    if (this.isReadApkg) {
      return readApkgToString("app-wxss.js");
    }
    File localFile = new File(new File(getApkgFolderPath()), "app-wxss.js");
    if (localFile.exists()) {
      return FileUtils.readFileToStr(localFile);
    }
    return "";
  }
  
  public String getWorkerJsContent(String paramString1, String paramString2)
  {
    if (this.isReadApkg)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return readApkgToString(paramString2);
      }
      if (paramString1.endsWith("/")) {
        return readApkgToString(paramString1 + paramString2);
      }
      return readApkgToString(paramString1 + File.separator + paramString2);
    }
    return FileUtils.readFileToStr(new File(getWorkerPath(paramString1, paramString2)));
  }
  
  public String getWorkerPath(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return getApkgFolderPath() + File.separator + paramString2;
    }
    if (this.isReadApkg)
    {
      if (paramString1.endsWith("/")) {
        return getApkgFolderPath() + File.separator + paramString1 + paramString2;
      }
      return getApkgFolderPath() + File.separator + paramString1 + File.separator + paramString2;
    }
    return new File(new File(getApkgFolderPath(), paramString1), paramString2).getAbsolutePath();
  }
  
  public void init(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = getApkgFolderPath() + "/" + paramString;
      if (this.isReadApkg) {}
      for (paramString = readApkgToString(paramString + File.separator + "app-config.json");; paramString = FileUtils.readFileToString(new File((String)localObject, "app-config.json")))
      {
        this.mConfigStr = paramString;
        JSONObject localJSONObject = new JSONObject(this.mConfigStr);
        paramString = new JSONObject();
        paramString.put("USER_DATA_PATH", "wxfile://usr");
        localJSONObject.put("env", paramString);
        String str = localJSONObject.optString("entryPagePath");
        paramString = null;
        if (this.mMiniAppInfo != null) {
          paramString = this.mMiniAppInfo.launchParam.entryPath;
        }
        localObject = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject = str;
        }
        paramString = AppBrandUtil.getAppLaunchInfo((String)localObject, this.mMiniAppInfo);
        QMLog.d("ApkgInfo", "appLaunchInfo : " + paramString.toString());
        localJSONObject.put("appLaunchInfo", paramString);
        this.mConfigStr = localJSONObject.toString();
        this.mAppConfigInfo = AppConfigInfo.parseAppConfig(localJSONObject);
        return;
      }
    }
    if (this.isReadApkg) {}
    for (paramString = readApkgToString("app-config.json");; paramString = FileUtils.readFileToString(new File(getApkgFolderPath(), "app-config.json")))
    {
      this.mConfigStr = paramString;
      break;
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
    for (;;)
    {
      return false;
      String str;
      Object localObject;
      if (!this.isReadApkg)
      {
        if (new File(getChildFileAbsolutePath(paramString)).exists()) {
          return true;
        }
      }
      else
      {
        str = paramString;
        if (paramString.startsWith("/")) {
          str = paramString.substring(1);
        }
        localObject = getApkgFile(str);
        paramString = ((File)localObject).getName();
        str = AppBrandUtil.getUrlWithoutParams(str);
        if (isUrlResReady(str, this.mMiniAppInfo)) {
          if (this.fileMap.containsKey(paramString)) {}
        }
      }
      try
      {
        localObject = ApkgFileUtils.getFileMapFromApkg((File)localObject);
        if (localObject != null) {
          this.fileMap.put(paramString, localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          QMLog.e("ApkgInfo", "getFileMapFromApkg err | url is " + str, localThrowable);
          continue;
          paramString = null;
        }
      }
    }
    if (paramString != null)
    {
      paramString = Boolean.valueOf(((HashMap)this.fileMap.get(paramString)).containsKey(str));
      return paramString.booleanValue();
    }
  }
  
  public boolean isUrlResReady(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    paramString = getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramMiniAppInfo = new File(ApkgManager.getApkgFolderPath(paramMiniAppInfo), paramString).getAbsolutePath();
    paramString = paramString.replaceAll("/", "");
    if (this.isReadApkg) {}
    for (boolean bool = new File(getApkgFolderPath(), paramString + ".qapkg").exists();; bool = new File(paramMiniAppInfo).exists())
    {
      QMLog.d("ApkgInfo", "isUrlResReady | subApkgPath :" + paramString + "isExist:" + bool);
      if (!bool) {
        break;
      }
      return true;
    }
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
  
  public ByteArrayInputStream readApkgToStream(String paramString)
  {
    if (!isUrlFileExist(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (paramString.startsWith("/")) {
      localObject = paramString.substring(1);
    }
    paramString = getApkgFile((String)localObject);
    String str = paramString.getName();
    localObject = AppBrandUtil.getUrlWithoutParams((String)localObject);
    localObject = (ApkgFileUtils.WxapkgFile)((HashMap)this.fileMap.get(str)).get(localObject);
    return ApkgFileUtils.readApkgToStream(paramString, ((ApkgFileUtils.WxapkgFile)localObject).start, ((ApkgFileUtils.WxapkgFile)localObject).length);
  }
  
  public String readApkgToString(String paramString)
  {
    if (!isUrlFileExist(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (paramString.startsWith("/")) {
      localObject = paramString.substring(1);
    }
    paramString = getApkgFile((String)localObject);
    String str = paramString.getName();
    localObject = AppBrandUtil.getUrlWithoutParams((String)localObject);
    localObject = (ApkgFileUtils.WxapkgFile)((HashMap)this.fileMap.get(str)).get(localObject);
    return ApkgFileUtils.readApkgToStr(paramString, ((ApkgFileUtils.WxapkgFile)localObject).start, ((ApkgFileUtils.WxapkgFile)localObject).length);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo
 * JD-Core Version:    0.7.0.1
 */