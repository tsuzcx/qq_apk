package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
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
    localWindowInfo.backgroundColor = DisplayUtil.parseColor("#ffffff");
    localWindowInfo.backgroundTextStyle = "dark";
    localWindowInfo.enablePullDownRefresh = null;
    localWindowInfo.onReachBottomDistance = 50;
    localWindowInfo.disableScroll = null;
    localWindowInfo.pageOrientation = null;
    return localWindowInfo;
  }
  
  public WindowInfo clone()
  {
    WindowInfo localWindowInfo;
    try
    {
      localWindowInfo = (WindowInfo)super.clone();
      try
      {
        localWindowInfo.navigationBarInfo = this.navigationBarInfo.clone();
        return localWindowInfo;
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2)
    {
      localWindowInfo = null;
    }
    return localWindowInfo;
  }
  
  public void updateInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.navigationBarInfo.updateInfo(paramJSONObject);
      Object localObject1 = paramJSONObject.optString("backgroundColor");
      int i;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        i = this.backgroundColor;
      } else {
        i = DisplayUtil.parseColor((String)localObject1);
      }
      this.backgroundColor = i;
      this.backgroundTextStyle = paramJSONObject.optString("backgroundTextStyle", this.backgroundTextStyle);
      boolean bool = paramJSONObject.has("enablePullDownRefresh");
      Object localObject2 = null;
      if (bool) {
        localObject1 = Boolean.valueOf(paramJSONObject.optBoolean("enablePullDownRefresh"));
      } else {
        localObject1 = null;
      }
      this.enablePullDownRefresh = ((Boolean)localObject1);
      this.onReachBottomDistance = paramJSONObject.optInt("onReachBottomDistance", this.onReachBottomDistance);
      if (paramJSONObject.has("disableScroll")) {
        localObject1 = Boolean.valueOf(paramJSONObject.optBoolean("disableScroll"));
      } else {
        localObject1 = null;
      }
      this.disableScroll = ((Boolean)localObject1);
      localObject1 = localObject2;
      if (paramJSONObject.has("pageOrientation")) {
        localObject1 = paramJSONObject.optString("pageOrientation", ORIENTATION_PORTRAIT);
      }
      this.pageOrientation = ((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.WindowInfo
 * JD-Core Version:    0.7.0.1
 */