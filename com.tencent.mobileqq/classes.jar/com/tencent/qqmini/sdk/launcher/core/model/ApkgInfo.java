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
    this.isReadApkg = (paramMiniAppInfo.launchParam.isFlutterMode ^ true);
  }
  
  public static boolean initNetwork(ApkgInfo paramApkgInfo)
  {
    if (paramApkgInfo != null) {}
    try
    {
      if ((paramApkgInfo.mAppConfigInfo != null) && (paramApkgInfo.mAppConfigInfo.networkTimeoutInfo != null))
      {
        SpecialProxy localSpecialProxy = (SpecialProxy)AppLoaderFactory.g().getProxyManager().get(SpecialProxy.class);
        if (localSpecialProxy == null) {
          break label98;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("NetworkTimeOutInfo", paramApkgInfo.mAppConfigInfo.networkTimeoutInfo);
        localSpecialProxy.sendEventToHost(2, localBundle, null);
        break label98;
      }
      QMLog.e("ApkgInfo", "initNetwork param is wrong");
      return false;
    }
    catch (Throwable paramApkgInfo)
    {
      label88:
      break label88;
    }
    QMLog.e("ApkgInfo", "initNetwork failed", paramApkgInfo);
    return false;
    label98:
    return true;
  }
  
  public static ApkgInfo loadApkgInfoFromFolderPath(String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists()))
    {
      paramString1 = new ApkgInfo(paramString1, paramMiniAppInfo);
      paramString1.init(paramString2);
      QMLog.e("ApkgInfo", "loadApkgInfoFromFolderPath initNetwork");
      initNetwork(paramString1);
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
  
  public File getApkgFile(String paramString)
  {
    paramString = getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return new File(getApkgFolderPath(), "mini.qapkg");
    }
    paramString = paramString.replaceAll("/", "");
    String str = getApkgFolderPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".qapkg");
    return new File(str, localStringBuilder.toString());
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
      if (paramString.endsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("app-service.js");
        return readApkgToString(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("app-service.js");
      return readApkgToString(localStringBuilder.toString());
    }
    return FileUtils.readFileToStr(new File(getAppServiceJsPath(paramString)));
  }
  
  public String getAppServiceJsPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getApkgFolderPath());
    localStringBuilder.append("/");
    localStringBuilder.append("app-service.js");
    return localStringBuilder.toString();
  }
  
  public String getAppServiceJsPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append(getApkgFolderPath());
      paramString.append("/");
      paramString.append("app-service.js");
      return paramString.toString();
    }
    return new File(new File(getApkgFolderPath(), paramString), "app-service.js").getAbsolutePath();
  }
  
  public boolean getDebug()
  {
    AppConfigInfo localAppConfigInfo = this.mAppConfigInfo;
    if (localAppConfigInfo != null) {
      return localAppConfigInfo.debug;
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
      if (paramString.endsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("page-frame.js");
        return readApkgToString(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("page-frame.js");
      return readApkgToString(localStringBuilder.toString());
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
    paramString = ((String)localObject).substring(((String)localObject).indexOf("<script>") + 8, ((String)localObject).indexOf("</script>"));
    localPageHtmlContent.htmlStr = ((String)localObject);
    localPageHtmlContent.jsStr = paramString;
    return localPageHtmlContent;
  }
  
  public String getPageJsStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str3 = normalize(paramString);
    String str1 = (String)this.mPageJsMap.get(str3);
    paramString = str1;
    if (TextUtils.isEmpty(str1))
    {
      paramString = str1;
      try
      {
        String str2;
        if (this.isReadApkg)
        {
          paramString = str1;
          str2 = readApkgToString(str3);
        }
        else
        {
          paramString = str1;
          str2 = FileUtils.readFileToString(new File(getApkgFolderPath(), str3));
        }
        paramString = str1;
        str1 = str2.substring(str2.indexOf("<script>") + 8, str2.indexOf("</script>"));
        paramString = str1;
        this.mPageJsMap.put(str3, str1);
        return str1;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return paramString;
  }
  
  public String getRootPath(String paramString)
  {
    AppConfigInfo localAppConfigInfo = this.mAppConfigInfo;
    if (localAppConfigInfo != null) {
      return localAppConfigInfo.getRootPath(paramString);
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
      if (paramString1.endsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(paramString2);
        return readApkgToString(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString2);
      return readApkgToString(localStringBuilder.toString());
    }
    return FileUtils.readFileToStr(new File(getWorkerPath(paramString1, paramString2)));
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
    if (this.isReadApkg)
    {
      if (paramString1.endsWith("/"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getApkgFolderPath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString1);
        localStringBuilder.append(paramString2);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getApkgFolderPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString1);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    return new File(new File(getApkgFolderPath(), paramString1), paramString2).getAbsolutePath();
  }
  
  public void init(String paramString)
  {
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getApkgFolderPath());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
      if (this.isReadApkg)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append("app-config.json");
        paramString = readApkgToString(((StringBuilder)localObject).toString());
      }
      else
      {
        paramString = FileUtils.readFileToString(new File((String)localObject, "app-config.json"));
      }
      this.mConfigStr = paramString;
    }
    else
    {
      if (this.isReadApkg) {
        paramString = readApkgToString("app-config.json");
      } else {
        paramString = FileUtils.readFileToString(new File(getApkgFolderPath(), "app-config.json"));
      }
      this.mConfigStr = paramString;
    }
    JSONObject localJSONObject = new JSONObject(this.mConfigStr);
    paramString = new JSONObject();
    paramString.put("USER_DATA_PATH", "wxfile://usr");
    localJSONObject.put("env", paramString);
    Object localObject = localJSONObject.optString("entryPagePath");
    paramString = null;
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    if (localMiniAppInfo != null) {
      paramString = localMiniAppInfo.launchParam.entryPath;
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)localObject;
    }
    paramString = AppBrandUtil.getAppLaunchInfo(paramString, this.mMiniAppInfo);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appLaunchInfo : ");
    ((StringBuilder)localObject).append(paramString.toString());
    QMLog.d("ApkgInfo", ((StringBuilder)localObject).toString());
    localJSONObject.put("appLaunchInfo", paramString);
    this.mConfigStr = localJSONObject.toString();
    this.mAppConfigInfo = AppConfigInfo.parseAppConfig(localJSONObject);
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
    String str = AppBrandUtil.getUrlWithoutParams(paramString);
    paramString = this.mAppConfigInfo;
    if (paramString != null) {
      paramString = paramString.tabBarInfo;
    } else {
      paramString = null;
    }
    if (paramString != null)
    {
      paramString = paramString.list.iterator();
      while (paramString.hasNext()) {
        if (((TabBarInfo.ButtonInfo)paramString.next()).pagePath.equals(str)) {
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
    if (!this.isReadApkg) {
      return new File(getChildFileAbsolutePath(paramString)).exists();
    }
    String str = paramString;
    if (paramString.startsWith("/")) {
      str = paramString.substring(1);
    }
    Object localObject = getApkgFile(str);
    paramString = ((File)localObject).getName();
    str = AppBrandUtil.getUrlWithoutParams(str);
    if (isUrlResReady(str, this.mMiniAppInfo))
    {
      if (!this.fileMap.containsKey(paramString)) {
        try
        {
          localObject = ApkgFileUtils.getFileMapFromApkg((File)localObject);
          if (localObject != null) {
            this.fileMap.put(paramString, localObject);
          } else {
            return false;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFileMapFromApkg err | url is ");
          localStringBuilder.append(str);
          QMLog.e("ApkgInfo", localStringBuilder.toString(), localThrowable);
        }
      }
      if (paramString != null) {
        paramString = Boolean.valueOf(((HashMap)this.fileMap.get(paramString)).containsKey(str));
      } else {
        paramString = null;
      }
      return paramString.booleanValue();
    }
    return false;
  }
  
  public boolean isUrlResReady(String paramString, MiniAppInfo paramMiniAppInfo)
  {
    paramString = getRootPath(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    paramMiniAppInfo = new File(ApkgManager.getApkgFolderPath(paramMiniAppInfo), paramString).getAbsolutePath();
    paramString = paramString.replaceAll("/", "");
    boolean bool;
    if (this.isReadApkg)
    {
      paramMiniAppInfo = getApkgFolderPath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(".qapkg");
      bool = new File(paramMiniAppInfo, localStringBuilder.toString()).exists();
    }
    else
    {
      bool = new File(paramMiniAppInfo).exists();
    }
    paramMiniAppInfo = new StringBuilder();
    paramMiniAppInfo.append("isUrlResReady | subApkgPath :");
    paramMiniAppInfo.append(paramString);
    paramMiniAppInfo.append("isExist:");
    paramMiniAppInfo.append(bool);
    QMLog.d("ApkgInfo", paramMiniAppInfo.toString());
    return bool;
  }
  
  public boolean isValidPrefix(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramBoolean = bool1;
        if (paramString.startsWith("https://")) {
          break label66;
        }
        paramBoolean = bool1;
        if (paramString.startsWith("wss://")) {
          break label66;
        }
        paramBoolean = bool1;
        if (paramString.startsWith("ws://")) {
          break label66;
        }
        if (paramString.startsWith("http://")) {
          return true;
        }
      }
      paramBoolean = false;
      label66:
      return paramBoolean;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramBoolean = bool2;
      if (paramString.startsWith("https://")) {
        return paramBoolean;
      }
      if (paramString.startsWith("wss://")) {
        return true;
      }
    }
    paramBoolean = false;
    return paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo
 * JD-Core Version:    0.7.0.1
 */