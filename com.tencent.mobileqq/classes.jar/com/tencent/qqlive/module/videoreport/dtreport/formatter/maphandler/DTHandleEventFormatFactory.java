package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants.ElementFormatMode;
import java.util.HashSet;
import java.util.Set;

public class DTHandleEventFormatFactory
{
  static final Set<String> APP_KEY_SET;
  private static final Set<String> AUDIO_KEY_SET;
  static final Set<String> PAGE_KEY_SET;
  static final Set<String> VIEW_KEY_SET = new HashSet();
  @DTConfigConstants.ElementFormatMode
  static int sElementFormatMode;
  
  static
  {
    APP_KEY_SET = new HashSet();
    PAGE_KEY_SET = new HashSet();
    AUDIO_KEY_SET = new HashSet();
    sElementFormatMode = 1;
    VIEW_KEY_SET.add("imp");
    VIEW_KEY_SET.add("clck");
    VIEW_KEY_SET.add("imp_end");
    APP_KEY_SET.add("appout");
    APP_KEY_SET.add("appin");
    APP_KEY_SET.add("origin_vst");
    APP_KEY_SET.add("vst");
    APP_KEY_SET.add("act");
    APP_KEY_SET.add("dt_app_heartbeat");
    PAGE_KEY_SET.add("pgin");
    PAGE_KEY_SET.add("pgout");
    AUDIO_KEY_SET.add("dt_audio_start");
    AUDIO_KEY_SET.add("dt_audio_end");
    AUDIO_KEY_SET.add("dt_audio_heartbeat");
  }
  
  @NonNull
  public static IEventMapHandler fetchEventHandler(String paramString)
  {
    if (VIEW_KEY_SET.contains(paramString)) {
      return getViewEventHandler();
    }
    if (APP_KEY_SET.contains(paramString)) {
      return getAppEventHandler();
    }
    if (PAGE_KEY_SET.contains(paramString)) {
      return getPageEventHandler();
    }
    if (AUDIO_KEY_SET.contains(paramString)) {
      return getAudioEventHandler();
    }
    return getBizEventHandler();
  }
  
  private static IEventMapHandler getAppEventHandler()
  {
    return DTHandleEventFormatFactory.EventHandlerHolder.getAppEventHandler();
  }
  
  private static DTBaseEventMapHandler getAudioEventHandler()
  {
    return DTHandleEventFormatFactory.EventHandlerHolder.getAudioEventMapHandler();
  }
  
  private static DTBaseEventMapHandler getBizEventHandler()
  {
    return DTHandleEventFormatFactory.EventHandlerHolder.getBizEventHandler();
  }
  
  private static IEventMapHandler getPageEventHandler()
  {
    return DTHandleEventFormatFactory.EventHandlerHolder.getPageEventHandler();
  }
  
  private static IEventMapHandler getViewEventHandler()
  {
    return DTHandleEventFormatFactory.EventHandlerHolder.getViewEventHandler();
  }
  
  public static void setElementFormatMode(@DTConfigConstants.ElementFormatMode int paramInt)
  {
    sElementFormatMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory
 * JD-Core Version:    0.7.0.1
 */