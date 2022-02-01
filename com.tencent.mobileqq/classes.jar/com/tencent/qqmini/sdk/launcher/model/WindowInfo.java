package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import org.json.JSONObject;

public class WindowInfo
  implements Cloneable
{
  public static String ORIENTATION_AUTO = "auto";
  public static String ORIENTATION_LANDSCAPE = "landscape";
  public static String ORIENTATION_PORTRAIT = "portrait";
  public int backgroundColor;
  public String backgroundTextStyle;
  public Boolean disableScroll;
  public Boolean enablePullDownRefresh;
  public NavigationBarInfo navigationBarInfo;
  public int onReachBottomDistance;
  public String pageOrientation;
  
  public static WindowInfo getDefault()
  {
    WindowInfo localWindowInfo = new WindowInfo();
    localWindowInfo.navigationBarInfo = NavigationBarInfo.getDefault();
    localWindowInfo.backgroundColor = ColorUtils.parseColor("#ffffff");
    localWindowInfo.backgroundTextStyle = "dark";
    localWindowInfo.enablePullDownRefresh = null;
    localWindowInfo.onReachBottomDistance = 50;
    localWindowInfo.disableScroll = null;
    localWindowInfo.pageOrientation = null;
    return localWindowInfo;
  }
  
  public WindowInfo clone()
  {
    try
    {
      localWindowInfo = (WindowInfo)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localWindowInfo.navigationBarInfo = this.navigationBarInfo.clone();
        return localWindowInfo;
      }
      catch (Throwable localThrowable2)
      {
        WindowInfo localWindowInfo;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localWindowInfo = null;
    }
    label24:
    return localWindowInfo;
  }
  
  public void updateInfo(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    int i;
    if (paramJSONObject != null)
    {
      this.navigationBarInfo.updateInfo(paramJSONObject);
      localObject1 = paramJSONObject.optString("backgroundColor");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label143;
      }
      i = this.backgroundColor;
      this.backgroundColor = i;
      this.backgroundTextStyle = paramJSONObject.optString("backgroundTextStyle", this.backgroundTextStyle);
      if (!paramJSONObject.has("enablePullDownRefresh")) {
        break label151;
      }
      localObject1 = Boolean.valueOf(paramJSONObject.optBoolean("enablePullDownRefresh"));
      label72:
      this.enablePullDownRefresh = ((Boolean)localObject1);
      this.onReachBottomDistance = paramJSONObject.optInt("onReachBottomDistance", this.onReachBottomDistance);
      if (!paramJSONObject.has("disableScroll")) {
        break label156;
      }
    }
    label143:
    label151:
    label156:
    for (Object localObject1 = Boolean.valueOf(paramJSONObject.optBoolean("disableScroll"));; localObject1 = null)
    {
      this.disableScroll = ((Boolean)localObject1);
      localObject1 = localObject2;
      if (paramJSONObject.has("pageOrientation")) {
        localObject1 = paramJSONObject.optString("pageOrientation", ORIENTATION_PORTRAIT);
      }
      this.pageOrientation = ((String)localObject1);
      return;
      i = ColorUtils.parseColor((String)localObject1);
      break;
      localObject1 = null;
      break label72;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.WindowInfo
 * JD-Core Version:    0.7.0.1
 */