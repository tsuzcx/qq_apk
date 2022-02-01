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
    int i = paramString.indexOf("?");
    String str = "";
    Object localObject1;
    if (i != -1)
    {
      localObject1 = paramString.substring(0, i);
      localObject2 = paramString.substring(i + 1, paramString.length());
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = paramString;
    if (!paramString.toLowerCase().endsWith(".html"))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(".html");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramString = str;
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("?");
      paramString.append((String)localObject1);
      paramString = paramString.toString();
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public int getReqAction()
  {
    int i = this.scene;
    if (i == 1207) {
      return 1;
    }
    if (i == 1208) {
      return 2;
    }
    return 0;
  }
  
  public String getScheme()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("mqqapi://microapp/open?mini_appid=");
    ((StringBuilder)localObject1).append(this.miniAppId);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.entryPath))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&entryPath=");
      ((StringBuilder)localObject1).append(this.entryPath);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty(this.navigateExtData))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&extraData=");
      ((StringBuilder)localObject2).append(this.navigateExtData);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public boolean isValid()
  {
    int i = this.scene;
    if ((i != 1207) && (i != 1208))
    {
      if (i != 1214) {
        return !TextUtils.isEmpty(this.miniAppId);
      }
      if (!TextUtils.isEmpty(this.miniAppId)) {
        return !TextUtils.isEmpty(this.fromMiniAppId);
      }
      return false;
    }
    return !TextUtils.isEmpty(this.extraKey);
  }
  
  public void standardize()
  {
    this.entryPath = standardEntryPath(this.entryPath);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LaunchParam{scene=");
    localStringBuilder.append(this.scene);
    localStringBuilder.append(", miniAppId='");
    localStringBuilder.append(this.miniAppId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extraKey='");
    localStringBuilder.append(this.extraKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", entryPath='");
    localStringBuilder.append(this.entryPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", navigateExtData='");
    localStringBuilder.append(this.navigateExtData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fromMiniAppId='");
    localStringBuilder.append(this.fromMiniAppId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.LaunchParam
 * JD-Core Version:    0.7.0.1
 */