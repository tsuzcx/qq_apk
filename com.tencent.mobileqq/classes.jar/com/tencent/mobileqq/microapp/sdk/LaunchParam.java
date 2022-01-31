package com.tencent.mobileqq.microapp.sdk;

import android.text.TextUtils;
import java.io.Serializable;

public class LaunchParam
  implements Serializable
{
  public static final String MINI_APPID_COLLECTION_PAGE = "101495732";
  public static final int SCENE_ABOUT = 1216;
  public static final int SCENE_H5_LIST = 1201;
  public static final int SCENE_HOME_PLUS = 1202;
  public static final int SCENE_HOME_SEARCH = 1206;
  public static final int SCENE_NAVIGATE_BACK = 1215;
  public static final int SCENE_NAVIGATE_TO = 1214;
  public static final int SCENE_NOT_DEFINE = 1200;
  public static final int SCENE_PUBLIC_ACCOUNT_CUSTOM_MENU = 1209;
  public static final int SCENE_PUBLIC_ACCOUNT_TEMPLATE_MSG = 1210;
  public static final int SCENE_PUBLIC_GROUP_MSG = 1211;
  public static final int SCENE_SCAN_QQ = 1207;
  public static final int SCENE_SCAN_WX = 1208;
  public static final int SCENE_SHARE_C2C = 1212;
  public static final int SCENE_SHARE_GROUP = 1213;
  public static final int SCENE_WALLET_APPS = 1203;
  public static final int SCENE_WALLET_BANNER = 1204;
  public static final int SCENE_WALLET_CHOICENESS = 1205;
  public static final int STATE_LOADING = 1;
  public static final int STATE_NONE = 0;
  public String appInfo;
  public String entryPath;
  public String extraKey;
  public String fromMiniAppId;
  public String miniAppId;
  public String navigateExtData;
  public int scene = 1200;
  public int tempState = 0;
  
  public static boolean isCollectionPage(String paramString)
  {
    return "101495732".equals(paramString);
  }
  
  private static String standardEntryPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = "";
    int i = paramString.indexOf("?");
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = paramString.substring(0, i);
      str = paramString.substring(i + 1, paramString.length());
    }
    paramString = (String)localObject;
    if (!((String)localObject).toLowerCase().endsWith(".html")) {
      paramString = (String)localObject + ".html";
    }
    localObject = new StringBuilder().append(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (paramString = "";; paramString = "?" + str) {
      return paramString;
    }
  }
  
  public int getReqAction()
  {
    if (this.scene == 1207) {
      return 1;
    }
    if (this.scene == 1208) {
      return 2;
    }
    return 0;
  }
  
  public String getScheme()
  {
    Object localObject2 = "mqqapi://microapp/open?mini_appid=" + this.miniAppId;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.entryPath)) {
      localObject1 = (String)localObject2 + "&entryPath=" + this.entryPath;
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty(this.navigateExtData)) {
      localObject2 = (String)localObject1 + "&extraData=" + this.navigateExtData;
    }
    return localObject2;
  }
  
  public boolean isValid()
  {
    switch (this.scene)
    {
    default: 
      if (!TextUtils.isEmpty(this.miniAppId)) {
        break;
      }
    case 1207: 
    case 1208: 
    case 1214: 
      do
      {
        do
        {
          return false;
        } while (TextUtils.isEmpty(this.extraKey));
        return true;
      } while ((TextUtils.isEmpty(this.miniAppId)) || (TextUtils.isEmpty(this.fromMiniAppId)));
      return true;
    }
    return true;
  }
  
  public void standardize()
  {
    this.entryPath = standardEntryPath(this.entryPath);
  }
  
  public String toString()
  {
    return "LaunchParam{scene=" + this.scene + ", miniAppId='" + this.miniAppId + '\'' + ", extraKey='" + this.extraKey + '\'' + ", entryPath='" + this.entryPath + '\'' + ", navigateExtData='" + this.navigateExtData + '\'' + ", fromMiniAppId='" + this.fromMiniAppId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.LaunchParam
 * JD-Core Version:    0.7.0.1
 */