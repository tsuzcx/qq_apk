package com.tencent.mobileqq.mini.apkg;

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
    int i;
    if (TextUtils.isEmpty(str)) {
      i = this.backgoundColor;
    } else {
      i = ColorUtils.parseColor(str);
    }
    this.backgoundColor = i;
    this.textStyle = paramJSONObject.optString("navigationBarTextStyle", this.textStyle);
    if ((!"white".equals(this.textStyle)) && (!"black".equals(this.textStyle))) {
      this.textStyle = "white";
    }
    this.titleText = paramJSONObject.optString("navigationBarTitleText", this.titleText);
    this.style = paramJSONObject.optString("navigationStyle", this.style);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.NavigationBarInfo
 * JD-Core Version:    0.7.0.1
 */