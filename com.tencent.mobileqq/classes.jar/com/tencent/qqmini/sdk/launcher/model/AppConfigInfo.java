package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppConfigInfo
{
  private static final boolean mEnableSubpakPathIntercapt = false;
  public String PackageToolVersion;
  private Map<String, String> configStrs = new HashMap();
  public boolean debug;
  public String entryPagePath;
  public PageInfo globalPageInfo;
  public NetworkTimeoutInfo networkTimeoutInfo;
  private Map<String, PageInfo> pagesInfo;
  public List<String> pagesPathList;
  public JSONObject permissionInfo;
  public List<String> subPackRoots = new LinkedList();
  public TabBarInfo tabBarInfo;
  
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
  
  public static String getUrlWithoutParams(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("?");
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public static AppConfigInfo parseAppConfig(String paramString)
  {
    try
    {
      paramString = parseAppConfig(new JSONObject(paramString));
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return new AppConfigInfo();
  }
  
  public static AppConfigInfo parseAppConfig(JSONObject paramJSONObject)
  {
    AppConfigInfo localAppConfigInfo = new AppConfigInfo();
    try
    {
      localObject1 = paramJSONObject.keys();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        String str = paramJSONObject.optString((String)localObject2);
        localAppConfigInfo.configStrs.put(localObject2, str);
      }
      localAppConfigInfo.debug = paramJSONObject.optBoolean("debug");
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return localAppConfigInfo;
    }
    localAppConfigInfo.entryPagePath = paramJSONObject.optString("entryPagePath");
    localAppConfigInfo.globalPageInfo = PageInfo.getDefault();
    localAppConfigInfo.globalPageInfo.updateInfo(paramJSONObject.optJSONObject("global"));
    localAppConfigInfo.pagesInfo = parsePagesInfo(paramJSONObject.optJSONObject("page"), localAppConfigInfo.globalPageInfo);
    localAppConfigInfo.pagesPathList = parsePagesPathList(paramJSONObject.optJSONArray("pages"));
    localAppConfigInfo.networkTimeoutInfo = NetworkTimeoutInfo.parse(paramJSONObject.optJSONObject("networkTimeout"));
    localAppConfigInfo.tabBarInfo = TabBarInfo.parse(paramJSONObject.optJSONObject("tabBar"));
    Object localObject2 = paramJSONObject.optJSONArray("subpackages");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramJSONObject.optJSONArray("subPackages");
    }
    localAppConfigInfo.subPackRoots = getSubPackRoots((JSONArray)localObject1);
    localAppConfigInfo.PackageToolVersion = paramJSONObject.optString("PackageToolVersion");
    localAppConfigInfo.permissionInfo = paramJSONObject.optJSONObject("permission");
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
    paramString = getUrlWithoutParams(paramString);
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
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str2 = getUrlWithoutParams(paramString);
    Iterator localIterator = this.subPackRoots.iterator();
    label97:
    label100:
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if (str3.startsWith("/"))
      {
        paramString = str3.substring(1);
        if (!str2.startsWith("/")) {
          break label97;
        }
      }
      for (String str1 = str2.substring(1);; str1 = str2)
      {
        if (!str1.startsWith(paramString)) {
          break label100;
        }
        return str3;
        paramString = str3;
        break;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.AppConfigInfo
 * JD-Core Version:    0.7.0.1
 */