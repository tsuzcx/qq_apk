package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import org.json.JSONObject;

public class NavigationBarInfo
  implements Cloneable
{
  public int backgoundColor;
  public String style;
  public String textStyle;
  public String titleText;
  
  public static NavigationBarInfo getDefault()
  {
    NavigationBarInfo localNavigationBarInfo = new NavigationBarInfo();
    localNavigationBarInfo.backgoundColor = ColorUtils.parseColor("#000000");
    localNavigationBarInfo.textStyle = "white";
    localNavigationBarInfo.style = "default";
    return localNavigationBarInfo;
  }
  
  public NavigationBarInfo clone()
  {
    try
    {
      NavigationBarInfo localNavigationBarInfo = (NavigationBarInfo)super.clone();
      return localNavigationBarInfo;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public void updateInfo(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("navigationBarBackgroundColor");
    if (TextUtils.isEmpty(str)) {}
    for (int i = this.backgoundColor;; i = ColorUtils.parseColor(str))
    {
      this.backgoundColor = i;
      this.textStyle = paramJSONObject.optString("navigationBarTextStyle", this.textStyle);
      if ((!"white".equals(this.textStyle)) && (!"black".equals(this.textStyle))) {
        this.textStyle = "white";
      }
      this.titleText = paramJSONObject.optString("navigationBarTitleText", this.titleText);
      this.style = paramJSONObject.optString("navigationStyle", this.style);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo
 * JD-Core Version:    0.7.0.1
 */