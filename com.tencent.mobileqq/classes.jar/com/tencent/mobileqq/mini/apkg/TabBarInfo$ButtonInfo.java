package com.tencent.mobileqq.mini.apkg;

import android.graphics.Bitmap;
import android.text.TextUtils;
import org.json.JSONObject;

public class TabBarInfo$ButtonInfo
  implements Cloneable
{
  public Bitmap iconBitmap;
  public String iconData;
  public String iconPath;
  public String pagePath;
  public Bitmap selectedBitmap;
  public String selectedIconData;
  public String selectedIconPath;
  public String text;
  
  public static ButtonInfo parse(JSONObject paramJSONObject, ApkgInfo paramApkgInfo)
  {
    ButtonInfo localButtonInfo = new ButtonInfo();
    if (paramJSONObject != null)
    {
      localButtonInfo.pagePath = paramJSONObject.optString("pagePath");
      localButtonInfo.text = paramJSONObject.optString("text");
      localButtonInfo.iconData = paramJSONObject.optString("iconData");
      localButtonInfo.iconPath = paramJSONObject.optString("iconPath");
      localButtonInfo.selectedIconData = paramJSONObject.optString("selectedIconData");
      localButtonInfo.selectedIconPath = paramJSONObject.optString("selectedIconPath");
      if (!TextUtils.isEmpty(localButtonInfo.iconPath)) {
        localButtonInfo.iconBitmap = TabBarInfo.transPathToBitmap(localButtonInfo.iconPath, paramApkgInfo);
      } else {
        localButtonInfo.iconBitmap = TabBarInfo.transDataToBitmap(localButtonInfo.iconData);
      }
      if (!TextUtils.isEmpty(localButtonInfo.selectedIconPath))
      {
        localButtonInfo.selectedBitmap = TabBarInfo.transPathToBitmap(localButtonInfo.selectedIconPath, paramApkgInfo);
        return localButtonInfo;
      }
      localButtonInfo.selectedBitmap = TabBarInfo.transDataToBitmap(localButtonInfo.selectedIconData);
    }
    return localButtonInfo;
  }
  
  public ButtonInfo clone()
  {
    try
    {
      ButtonInfo localButtonInfo = (ButtonInfo)super.clone();
      return localButtonInfo;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.TabBarInfo.ButtonInfo
 * JD-Core Version:    0.7.0.1
 */