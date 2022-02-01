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
  private static Method getDuration;
  private static Method getKey;
  private static Method getParamLong;
  private static Method getParamType;
  private static int loopEndId;
  private static int loopStartId;
  private static int paramsTypeLongId;
  private static Field paramsValue;
  private static Field scenesId;
  private static int startParamsId;
  private static Class<?> tpDefaultReportInfoClass;
  private static Class<?> tpOptionalParamClass;
  private static Class<?> tpOptionalParamLongClass;
  private static Class<?> tpPlayerClass;
  private static Field vid;
  
  public static int convertEventIdToPlayer(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 6: 
      paramInt = loopEndId;
      if (paramInt > 0) {
        return paramInt;
      }
      paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", new String[] { "TP_PLAYER_INFO_LONG0_CURRENT_LOOP_END" });
      loopEndId = paramInt;
      return paramInt;
    case 5: 
      paramInt = loopStartId;
      if (paramInt > 0) {
        return paramInt;
      }
      paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", new String[] { "TP_PLAYER_INFO_LONG0_CURRENT_LOOP_START" });
      loopStartId = paramInt;
      return paramInt;
    case 4: 
      paramInt = paramsTypeLongId;
      if (paramInt > 0) {
        return paramInt;
      }
      paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPOptionalParam", new String[] { "TP_OPTIONAL_RARAM_TYPE_LONG", "TP_OPTIONAL_PARAM_TYPE_LONG" });
      paramsTypeLongId = paramInt;
      return paramInt;
    case 3: 
      paramInt = startParamsId;
      if (paramInt > 0) {
        return paramInt;
      }
      paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPOptionalID", new String[] { "OPTION_ID_BEFORE_LONG_START_PLAYING_TIME_MS" });
      startParamsId = paramInt;
      return paramInt;
    case 2: 
      paramInt = bufferEndEventId;
      if (paramInt > 0) {
        return paramInt;
      }
      paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", new String[] { "TP_PLAYER_INFO_LONG0_BUFFERING_END" });
      bufferEndEventId = paramInt;
      return paramInt;
    }
    paramInt = bufferStartEventId;
    if (paramInt > 0) {
      return paramInt;
    }
    paramInt = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", new String[] { "TP_PLAYER_INFO_LONG0_BUFFERING_START" });
    bufferStartEventId = paramInt;
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
  
  private static Field findFieldSafely(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getField(paramString);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      label8:
      break label8;
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
      paramObject = new StringBuilder();
      paramObject.append("getCurrentPosition,time=");
      paramObject.append(l);
      Log.i("VideoReportPlayerUtils", paramObject.toString());
      return l;
    }
    catch (Exception paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPosition,");
      localStringBuilder.append(paramObject.toString());
      Log.w("VideoReportPlayerUtils", localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static int getDuration(Object paramObject)
  {
    try
    {
      if (tpPlayerClass == null) {
        tpPlayerClass = Class.forName("com.tencent.thumbplayer.api.ITPPlayer");
      }
      if (getDuration == null) {
        getDuration = tpPlayerClass.getDeclaredMethod("getDurationMs", new Class[0]);
      }
      int i = ((Integer)getDuration.invoke(paramObject, new Object[0])).intValue();
      paramObject = new StringBuilder();
      paramObject.append("getDuration,time=");
      paramObject.append(i);
      Log.i("VideoReportPlayerUtils", paramObject.toString());
      return i;
    }
    catch (Exception paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDuration,");
      localStringBuilder.append(paramObject.toString());
      Log.w("VideoReportPlayerUtils", localStringBuilder.toString());
    }
    return 0;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStartPosition,");
      localStringBuilder.append(paramObject.toString());
      Log.w("VideoReportPlayerUtils", localStringBuilder.toString());
    }
    return 0L;
  }
  
  private static int getStaticFiledFromClass(String paramString, String... paramVarArgs)
  {
    try
    {
      paramString = Class.forName(paramString);
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Field localField = findFieldSafely(paramString, paramVarArgs[i]);
        if (localField != null)
        {
          i = ((Integer)localField.get(localField)).intValue();
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramString)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("getStaticFiledFromClass,");
      paramVarArgs.append(paramString.toString());
      Log.w("VideoReportPlayerUtils", paramVarArgs.toString());
    }
  }
  
  public static String getVidByReportInfo(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      if (tpDefaultReportInfoClass == null) {
        tpDefaultReportInfoClass = Class.forName("com.tencent.thumbplayer.api.report.TPDefaultReportInfo");
      }
      if (vid == null) {
        vid = tpDefaultReportInfoClass.getField("vid");
      }
      paramObject = (String)vid.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getVidByReportInfo,");
      localStringBuilder.append(paramObject.toString());
      Log.w("VideoReportPlayerUtils", localStringBuilder.toString());
    }
    return null;
  }
  
  public static boolean isPlayAdByPlayer(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPlayAdByPlayer,");
      localStringBuilder.append(paramObject.toString());
      Log.w("VideoReportPlayerUtils", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSetStartPosition,");
      localStringBuilder.append(paramObject.toString());
      Log.w("VideoReportPlayerUtils", localStringBuilder.toString());
    }
    return false;
  }
  
  public static String stateToString(int paramInt)
  {
    if (paramInt != -1)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "";
            }
            return "stoped";
          }
          return "paused";
        }
        return "started";
      }
      return "prepared";
    }
    return "init";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils
 * JD-Core Version:    0.7.0.1
 */