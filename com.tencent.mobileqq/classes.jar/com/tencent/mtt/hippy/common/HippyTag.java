package com.tencent.mtt.hippy.common;

import android.view.View;

public class HippyTag
{
  private static final String TAG_CLASS_NAME = "className";
  
  public static HippyMap createTagMap(String paramString, HippyMap paramHippyMap)
  {
    paramHippyMap = new HippyMap();
    paramHippyMap.pushString("className", paramString);
    return paramHippyMap;
  }
  
  public static String getClassName(View paramView)
  {
    return getStringValue(paramView, "className");
  }
  
  private static int getIntValue(View paramView, String paramString)
  {
    if ((paramView != null) && (paramString != null))
    {
      paramView = paramView.getTag();
      if ((paramView instanceof HippyMap))
      {
        paramView = (HippyMap)paramView;
        if (paramView.containsKey(paramString)) {
          return paramView.getInt(paramString);
        }
      }
    }
    return -1;
  }
  
  private static String getStringValue(View paramView, String paramString)
  {
    if ((paramView != null) && (paramString != null))
    {
      paramView = paramView.getTag();
      if ((paramView instanceof HippyMap))
      {
        paramView = (HippyMap)paramView;
        if (paramView.containsKey(paramString)) {
          return paramView.getString(paramString);
        }
      }
    }
    return null;
  }
  
  private static void setIntValue(View paramView, String paramString, int paramInt)
  {
    if ((paramView != null) && (paramString != null))
    {
      paramView = paramView.getTag();
      if ((paramView instanceof HippyMap)) {
        ((HippyMap)paramView).pushInt(paramString, paramInt);
      }
    }
  }
  
  private static void setStringValue(View paramView, String paramString1, String paramString2)
  {
    if ((paramView != null) && (paramString1 != null))
    {
      paramView = paramView.getTag();
      if ((paramView instanceof HippyMap))
      {
        HippyMap localHippyMap = (HippyMap)paramView;
        paramView = paramString2;
        if (paramString2 == null) {
          paramView = "";
        }
        localHippyMap.pushString(paramString1, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyTag
 * JD-Core Version:    0.7.0.1
 */