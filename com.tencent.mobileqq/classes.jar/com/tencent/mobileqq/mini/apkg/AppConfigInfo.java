package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.utils.StringUtil;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppConfigInfo
{
  private static final boolean mEnableSubpakPathIntercapt;
  public String PackageToolVersion;
  private Map<String, String> configStrs = new HashMap();
  public boolean darkmode;
  public boolean debug;
  public String entryPagePath;
  public PageInfo globalPageInfo;
  public NetworkTimeoutInfo networkTimeoutInfo;
  private Map<String, PageInfo> pagesInfo;
  public List<String> pagesPathList;
  public JSONObject permissionInfo;
  public List<String> subPackRoots = new LinkedList();
  public TabBarInfo tabBarInfo;
  
  static
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqminiapp", "mini_app_subpkg_path_intercept", 0) == 1) {
      bool = true;
    }
    mEnableSubpakPathIntercapt = bool;
  }
  
  private static List<String> getSubPackRoots(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString("root");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localLinkedList.add(localObject);
          }
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static AppConfigInfo parseAppConfig(String paramString, ApkgInfo paramApkgInfo)
  {
    AppConfigInfo localAppConfigInfo = new AppConfigInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.keys();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        String str2 = localJSONObject.optString(str1);
        localAppConfigInfo.configStrs.put(str1, str2);
      }
      localAppConfigInfo.debug = localJSONObject.optBoolean("debug");
      localAppConfigInfo.entryPagePath = localJSONObject.optString("entryPagePath");
      localAppConfigInfo.globalPageInfo = PageInfo.getDefault();
      localAppConfigInfo.globalPageInfo.updateInfo(localJSONObject.optJSONObject("global"));
      localAppConfigInfo.pagesInfo = parsePagesInfo(localJSONObject.optJSONObject("page"), localAppConfigInfo.globalPageInfo);
      localAppConfigInfo.pagesPathList = parsePagesPathList(localJSONObject.optJSONArray("pages"));
      localAppConfigInfo.networkTimeoutInfo = NetworkTimeoutInfo.parse(localJSONObject.optJSONObject("networkTimeout"));
      localAppConfigInfo.tabBarInfo = TabBarInfo.parse(localJSONObject.optJSONObject("tabBar"), paramApkgInfo);
      paramApkgInfo = localJSONObject.optJSONArray("subpackages");
      paramString = paramApkgInfo;
      if (paramApkgInfo == null) {
        paramString = localJSONObject.optJSONArray("subPackages");
      }
      localAppConfigInfo.subPackRoots = getSubPackRoots(paramString);
      localAppConfigInfo.PackageToolVersion = localJSONObject.optString("PackageToolVersion");
      localAppConfigInfo.permissionInfo = localJSONObject.optJSONObject("permission");
      localAppConfigInfo.darkmode = localJSONObject.optBoolean("darkmode");
      return localAppConfigInfo;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return localAppConfigInfo;
  }
  
  public static Map<String, PageInfo> parsePagesInfo(JSONObject paramJSONObject, PageInfo paramPageInfo)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject != null)
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        PageInfo localPageInfo = paramPageInfo.clone();
        localPageInfo.updateInfo(paramJSONObject.optJSONObject(str));
        localHashMap.put(str, localPageInfo);
      }
    }
    return localHashMap;
  }
  
  public static List<String> parsePagesPathList(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        String str = paramJSONArray.optString(i);
        if (!TextUtils.isEmpty(str)) {
          localLinkedList.add(str);
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public PageInfo getPageInfo(String paramString)
  {
    paramString = AppBrandUtil.getUrlWithoutParams(paramString);
    PageInfo localPageInfo = (PageInfo)this.pagesInfo.get(paramString);
    paramString = localPageInfo;
    if (localPageInfo == null) {
      paramString = this.globalPageInfo;
    }
    return paramString;
  }
  
  public String getPagesStr()
  {
    return (String)this.configStrs.get("pages");
  }
  
  public String getRootPath(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    String str2 = AppBrandUtil.getUrlWithoutParams(paramString);
    Iterator localIterator = this.subPackRoots.iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if (str3.startsWith("/")) {
        paramString = str3.substring(1);
      } else {
        paramString = str3;
      }
      String str1 = paramString;
      if (mEnableSubpakPathIntercapt)
      {
        str1 = paramString;
        if (paramString.endsWith("/")) {
          str1 = paramString.substring(0, paramString.length() - 1);
        }
      }
      if (str2.startsWith("/")) {
        paramString = str2.substring(1);
      } else {
        paramString = str2;
      }
      if (paramString.startsWith(str1)) {
        return str3;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.AppConfigInfo
 * JD-Core Version:    0.7.0.1
 */