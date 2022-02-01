package com.tencent.mtt.hippy.common;

import android.view.View;

public class HippyTag
{
  private static final String TAG_CLASS_NAME = "className";
  private static final String TAG_EXPOSURE_STATE = "exposureState";
  public static final int TAG_EXPOSURE_STATE_DID_APPEAR = 1;
  public static final int TAG_EXPOSURE_STATE_DID_DISAPPEAR = 2;
  public static final int TAG_EXPOSURE_STATE_WILL_APPEAR = 0;
  public static final String TAG_PROPS_DID_APPEAR = "onDidAppear";
  public static final String TAG_PROPS_DID_DISAPPEAR = "onDidDisappear";
  public static final String TAG_PROPS_WILL_APPEAR = "onWillAppear";
  
  public static HippyMap createTagMap(String paramString, HippyMap paramHippyMap)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("className", paramString);
    if ((paramHippyMap != null) && (paramHippyMap.size() > 0))
    {
      if (paramHippyMap.containsKey("onWillAppear")) {
        localHippyMap.pushString("onWillAppear", "");
      }
      if (paramHippyMap.containsKey("onDidAppear")) {
        localHippyMap.pushString("onDidAppear", "");
      }
      if (paramHippyMap.containsKey("onDidDisappear")) {
        localHippyMap.pushString("onDidDisappear", "");
      }
    }
    return localHippyMap;
  }
  
  public static String getClassName(View paramView)
  {
    return getStringValue(paramView, "className");
  }
  
  public static int getExposureState(View paramView)
  {
    return getIntValue(paramView, "exposureState");
  }
  
  private static int getIntValue(View paramView, String paramString)
  {
    if ((paramView != null) && (paramString != null))
    {
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof HippyMap)))
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
      if ((paramView != null) && ((paramView instanceof HippyMap)))
      {
        paramView = (HippyMap)paramView;
        if (paramView.containsKey(paramString)) {
          return paramView.getString(paramString);
        }
      }
    }
    return null;
  }
  
  public static boolean isContainTheSpecKey(View paramView, String paramString)
  {
    if ((paramView != null) && (paramString != null))
    {
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof HippyMap))) {
        return ((HippyMap)paramView).containsKey(paramString);
      }
    }
    return false;
  }
  
  public static boolean jsJustLayout(HippyMap paramHippyMap)
  {
    return (paramHippyMap == null) || ((!paramHippyMap.containsKey("onWillAppear")) && (!paramHippyMap.containsKey("onDidAppear")) && (!paramHippyMap.containsKey("onDidDisappear")));
  }
  
  public static void setExposureState(View paramView, int paramInt)
  {
    setIntValue(paramView, "exposureState", paramInt);
  }
  
  private static void setIntValue(View paramView, String paramString, int paramInt)
  {
    if ((paramView != null) && (paramString != null))
    {
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof HippyMap))) {
        ((HippyMap)paramView).pushInt(paramString, paramInt);
      }
    }
  }
  
  private static void setStringValue(View paramView, String paramString1, String paramString2)
  {
    if ((paramView != null) && (paramString1 != null))
    {
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof HippyMap)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.common.HippyTag
 * JD-Core Version:    0.7.0.1
 */