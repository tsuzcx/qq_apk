package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class VideoReportPlayerUtils
{
  private static final int SCENES_ID = 1;
  private static final String TAG = "VideoReportPlayerUtils";
  private static int bufferEndEventId;
  private static int bufferStartEventId;
  private static Method getCurrentPosition;
  private static Method getKey = null;
  private static Method getParamLong;
  private static Method getParamType;
  private static int paramsTypeLongId;
  private static Field paramsValue = null;
  private static Field scenesId = null;
  private static int startParamsId = 0;
  private static Class<?> tpDefaultReportInfoClass;
  private static Class<?> tpOptionalParamClass;
  private static Class<?> tpOptionalParamLongClass;
  private static Class<?> tpPlayerClass;
  
  static
  {
    bufferStartEventId = 0;
    bufferEndEventId = 0;
    paramsTypeLongId = 0;
    tpPlayerClass = null;
    tpOptionalParamClass = null;
    tpOptionalParamLongClass = null;
    tpDefaultReportInfoClass = null;
    getCurrentPosition = null;
    getParamType = null;
    getParamLong = null;
  }
  
  public static int convertEventIdToPlayer(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 3: 
      if (startParamsId > 0) {
        return startParamsId;
      }
      paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPOptionalID", "OPTION_ID_BEFORE_LONG_START_PLAYING_TIME_MS");
      startParamsId = paramInt;
      return paramInt;
    case 1: 
      if (bufferStartEventId > 0) {
        return bufferStartEventId;
      }
      paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", "TP_PLAYER_INFO_LONG0_BUFFERING_START");
      bufferStartEventId = paramInt;
      return paramInt;
    case 2: 
      if (bufferEndEventId > 0) {
        return bufferEndEventId;
      }
      paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", "TP_PLAYER_INFO_LONG0_BUFFERING_END");
      bufferEndEventId = paramInt;
      return paramInt;
    }
    if (paramsTypeLongId > 0) {
      return paramsTypeLongId;
    }
    paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPOptionalParam", "TP_OPTIONAL_RARAM_TYPE_LONG");
    paramsTypeLongId = paramInt;
    return paramInt;
  }
  
  public static void debugEnd(String paramString, VideoReportPlayerUtils.DebugTime paramDebugTime)
  {
    if ((paramDebugTime != null) && (VideoReportInner.getInstance().isDebugMode())) {
      paramDebugTime.debug(paramString);
    }
  }
  
  public static VideoReportPlayerUtils.DebugTime debugStart()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      return new VideoReportPlayerUtils.DebugTime(System.currentTimeMillis());
    }
    return null;
  }
  
  public static long getCurrentPosition(Object paramObject)
  {
    try
    {
      if (tpPlayerClass == null) {
        tpPlayerClass = Class.forName("com.tencent.thumbplayer.api.ITPPlayer");
      }
      if (getCurrentPosition == null) {
        getCurrentPosition = tpPlayerClass.getDeclaredMethod("getCurrentPositionMs", new Class[0]);
      }
      long l = ((Long)getCurrentPosition.invoke(paramObject, new Object[0])).longValue();
      Log.i("VideoReportPlayerUtils", "getCurrentPosition,time=" + l);
      return l;
    }
    catch (Exception paramObject)
    {
      Log.w("VideoReportPlayerUtils", "getCurrentPosition," + paramObject.toString());
    }
    return 0L;
  }
  
  public static long getStartPosition(Object paramObject)
  {
    try
    {
      if (tpOptionalParamClass == null) {
        tpOptionalParamClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam");
      }
      if (getParamType == null) {
        getParamType = tpOptionalParamClass.getMethod("getParamType", new Class[0]);
      }
      if (((Integer)getParamType.invoke(paramObject, new Object[0])).intValue() != convertEventIdToPlayer(4)) {
        return 0L;
      }
      if (getParamLong == null) {
        getParamLong = tpOptionalParamClass.getMethod("getParamLong", new Class[0]);
      }
      paramObject = getParamLong.invoke(paramObject, new Object[0]);
      if (tpOptionalParamLongClass == null) {
        tpOptionalParamLongClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam$OptionalParamLong");
      }
      if (paramsValue == null) {
        paramsValue = tpOptionalParamLongClass.getField("value");
      }
      long l = ((Long)paramsValue.get(paramObject)).longValue();
      return l;
    }
    catch (Exception paramObject)
    {
      Log.w("VideoReportPlayerUtils", "getStartPosition," + paramObject.toString());
    }
    return 0L;
  }
  
  private static int getStaticFiledFromClass(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getField(paramString2);
      int i = ((Integer)paramString1.get(paramString1)).intValue();
      return i;
    }
    catch (Exception paramString1)
    {
      Log.w("VideoReportPlayerUtils", "getStaticFiledFromClass," + paramString1.toString());
    }
    return -1;
  }
  
  public static boolean isPlayAdByPlayer(Object paramObject)
  {
    try
    {
      if (tpDefaultReportInfoClass == null) {
        tpDefaultReportInfoClass = Class.forName("com.tencent.thumbplayer.api.report.TPDefaultReportInfo");
      }
      if (scenesId == null) {
        scenesId = tpDefaultReportInfoClass.getField("scenesId");
      }
      int i = ((Integer)scenesId.get(paramObject)).intValue();
      if (i == 1) {
        return true;
      }
    }
    catch (Exception paramObject)
    {
      Log.w("VideoReportPlayerUtils", "isPlayAdByPlayer," + paramObject.toString());
    }
    return false;
  }
  
  public static boolean isSetStartPosition(Object paramObject)
  {
    try
    {
      if (tpOptionalParamClass == null) {
        tpOptionalParamClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam");
      }
      if (getKey == null) {
        getKey = tpOptionalParamClass.getMethod("getKey", new Class[0]);
      }
      int i = ((Integer)getKey.invoke(paramObject, new Object[0])).intValue();
      int j = convertEventIdToPlayer(3);
      if (i == j) {
        return true;
      }
    }
    catch (Exception paramObject)
    {
      Log.w("VideoReportPlayerUtils", "isSetStartPosition," + paramObject.toString());
    }
    return false;
  }
  
  public static String stateToString(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return "";
    case -1: 
      return "init";
    case 3: 
      return "paused";
    case 1: 
      return "prepared";
    case 2: 
      return "started";
    }
    return "stoped";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils
 * JD-Core Version:    0.7.0.1
 */