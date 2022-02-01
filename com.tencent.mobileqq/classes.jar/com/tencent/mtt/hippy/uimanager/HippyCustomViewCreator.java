package com.tencent.mtt.hippy.uimanager;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;

public abstract interface HippyCustomViewCreator
{
  public static final String HIPPY_CUSTOM_VIEW_CREATOR = "CustomViewCreator";
  
  public abstract View createCustomView(String paramString, Context paramContext, HippyMap paramHippyMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator
 * JD-Core Version:    0.7.0.1
 */