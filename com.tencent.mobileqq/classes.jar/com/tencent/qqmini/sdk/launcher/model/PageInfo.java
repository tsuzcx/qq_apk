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
    try
    {
      localPageInfo = (PageInfo)super.clone();
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localPageInfo.windowInfo = this.windowInfo.clone();
        return localPageInfo;
      }
      catch (Throwable localThrowable2)
      {
        PageInfo localPageInfo;
        break label24;
      }
      localThrowable1 = localThrowable1;
      localPageInfo = null;
    }
    label24:
    return localPageInfo;
  }
  
  public void updateInfo(JSONObject paramJSONObject)
  {
    WindowInfo localWindowInfo;
    if (this.windowInfo != null)
    {
      localWindowInfo = this.windowInfo;
      if (paramJSONObject != null) {
        break label24;
      }
    }
    label24:
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optJSONObject("window"))
    {
      localWindowInfo.updateInfo(paramJSONObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.PageInfo
 * JD-Core Version:    0.7.0.1
 */