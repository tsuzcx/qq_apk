package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants.ElementFormatMode;
import java.util.HashSet;
import java.util.Set;

public class DTHandleEventFormatFactory
{
  static final Set<String> APP_KEY_SET;
  static final Set<String> PAGE_KEY_SET;
  static final Set<String> VIEW_KEY_SET = new HashSet();
  @DTConfigConstants.ElementFormatMode
  private static int sElementFormatMode;
  
  static
  {
    APP_KEY_SET = new HashSet();
    PAGE_KEY_SET = new HashSet();
    sElementFormatMode = 0;
    VIEW_KEY_SET.add("imp");
    VIEW_KEY_SET.add("clck");
    VIEW_KEY_SET.add("imp_end");
    APP_KEY_SET.add("appout");
    APP_KEY_SET.add("appin");
    APP_KEY_SET.add("origin_vst");
    APP_KEY_SET.add("vst");
    APP_KEY_SET.add("act");
    PAGE_KEY_SET.add("pgin");
    PAGE_KEY_SET.add("pgout");
  }
  
  @NonNull
  public static IEventMapHandler fetchEventHandler(String paramString)
  {
    if (VIEW_KEY_SET.contains(paramString))
    {
      switch (sElementFormatMode)
      {
      default: 
        return DTHandleEventFormatFactory.EventHandlerHolder.getViewNonFlattenEventHandler();
      }
      return DTHandleEventFormatFactory.EventHandlerHolder.getViewFlattenEventHandler();
    }
    if (APP_KEY_SET.contains(paramString)) {
      return DTHandleEventFormatFactory.EventHandlerHolder.getAppEventHandler();
    }
    if (PAGE_KEY_SET.contains(paramString)) {
      return DTHandleEventFormatFactory.EventHandlerHolder.getPageEventHandler();
    }
    return DTHandleEventFormatFactory.EventHandlerHolder.getEventDefaultMapHandler();
  }
  
  public static void setElementFormatMode(@DTConfigConstants.ElementFormatMode int paramInt)
  {
    sElementFormatMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory
 * JD-Core Version:    0.7.0.1
 */