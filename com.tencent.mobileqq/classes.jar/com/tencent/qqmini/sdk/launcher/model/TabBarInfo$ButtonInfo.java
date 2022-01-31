package com.tencent.qqmini.sdk.launcher.model;

import android.graphics.Bitmap;
import org.json.JSONObject;

public class TabBarInfo$ButtonInfo
  implements Cloneable
{
  public Bitmap iconBitmap;
  public String iconPath;
  public String pagePath;
  public Bitmap selectedBitmap;
  public String selectedIconPath;
  public String text;
  
  public static ButtonInfo parse(JSONObject paramJSONObject)
  {
    ButtonInfo localButtonInfo = new ButtonInfo();
    if (paramJSONObject != null)
    {
      localButtonInfo.pagePath = paramJSONObject.optString("pagePath");
      localButtonInfo.text = paramJSONObject.optString("text");
      localButtonInfo.iconPath = paramJSONObject.optString("iconData");
      localButtonInfo.selectedIconPath = paramJSONObject.optString("selectedIconData");
      localButtonInfo.iconBitmap = TabBarInfo.transDataToBitmap(localButtonInfo.iconPath);
      localButtonInfo.selectedBitmap = TabBarInfo.transDataToBitmap(localButtonInfo.selectedIconPath);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo
 * JD-Core Version:    0.7.0.1
 */