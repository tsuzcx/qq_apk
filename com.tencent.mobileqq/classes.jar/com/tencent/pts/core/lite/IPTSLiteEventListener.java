package com.tencent.pts.core.lite;

import android.view.View;
import com.tencent.pts.core.PTSComposer;
import java.util.HashMap;

public abstract interface IPTSLiteEventListener
{
  public static final int LITE_EVENT_TYPE_EXPOSURE = 2;
  public static final int LITE_EVENT_TYPE_SCROLL_ITEM_EXPOSURE = 5;
  public static final int LITE_EVENT_TYPE_SWIPER_DRAG = 4;
  public static final int LITE_EVENT_TYPE_SWIPER_ITEM_EXPOSURE = 3;
  public static final int LITE_EVENT_TYPE_TAP = 1;
  public static final int LITE_EVENT_TYPE_UNKNOWN = 0;
  
  public abstract void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer);
  
  public abstract void onScrollViewItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer);
  
  public abstract void onSwiperDragTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer);
  
  public abstract void onSwiperItemExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer);
  
  public abstract void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView, PTSComposer paramPTSComposer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.lite.IPTSLiteEventListener
 * JD-Core Version:    0.7.0.1
 */