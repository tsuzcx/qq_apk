package com.tencent.qqmini.sdk.launcher.model;

import org.json.JSONObject;

public class PageInfo
  implements Cloneable
{
  public WindowInfo windowInfo;
  
  public static PageInfo getDefault()
  {
    PageInfo localPageInfo = new PageInfo();
    localPageInfo.windowInfo = WindowInfo.getDefault();
    return localPageInfo;
  }
  
  public PageInfo clone()
  {
    PageInfo localPageInfo;
    try
    {
      localPageInfo = (PageInfo)super.clone();
      try
      {
        localPageInfo.windowInfo = this.windowInfo.clone();
        return localPageInfo;
      }
      catch (Throwable localThrowable1) {}
      localThrowable2.printStackTrace();
    }
    catch (Throwable localThrowable2)
    {
      localPageInfo = null;
    }
    return localPageInfo;
  }
  
  public void updateInfo(JSONObject paramJSONObject)
  {
    WindowInfo localWindowInfo = this.windowInfo;
    if (localWindowInfo != null)
    {
      if (paramJSONObject == null) {
        paramJSONObject = null;
      } else {
        paramJSONObject = paramJSONObject.optJSONObject("window");
      }
      localWindowInfo.updateInfo(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PageInfo
 * JD-Core Version:    0.7.0.1
 */