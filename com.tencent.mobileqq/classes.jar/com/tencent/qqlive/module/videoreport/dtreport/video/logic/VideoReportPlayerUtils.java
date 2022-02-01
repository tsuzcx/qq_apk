package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class VideoReportPlayerUtils
{
  private static final int SCENES_ID = 1;
  private static final String TAG = "VideoReportPlayerUtils";
  private static int sBufferEndEventId;
  private static int sBufferStartEventId;
  private static Method sGetCurrentPosition;
  private static Method sGetDuration;
  private static Method sGetKey;
  private static Method sGetParamLong;
  private static Method sGetParamType;
  private static int sLoopEndId;
  private static int sLoopStartId;
  private static int sParamsTypeLongId;
  private static Field sParamsValue;
  private static Field sScenesId;
  private static int sStartParamsId;
  private static Class<?> sTpDefaultReportInfoClass;
  private static Class<?> sTpOptionalParamClass;
  private static Class<?> sTpOptionalParamLongClass;
  private static Class<?> sTpPlayerClass;
  private static Field sVid;
  
  public static int convertEventIdToPlayer(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 6: 
      return getEventOfLoopEnd();
    case 5: 
      return getEventOfLoopStart();
    case 4: 
      return getEventOfParamTypeLong();
    case 3: 
      return getEventOfSetStartPosition();
    case 2: 
      return getEventOfBufferEnd();
    }
    return getEventOfBufferStart();
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
  
  public static String entityLog(VideoEntity paramVideoEntity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("contentId=");
    localStringBuilder.append(paramVideoEntity.getContentId());
    localStringBuilder.append(", identifyer=");
    localStringBuilder.append(paramVideoEntity.getIdentifier());
    localStringBuilder.append(", contentType=");
    localStringBuilder.append(paramVideoEntity.getContentType());
    localStringBuilder.append(", isBizReady=");
    localStringBuilder.append(paramVideoEntity.isBizReady());
    return localStringBuilder.toString();
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
      if (sTpPlayerClass == null) {
        sTpPlayerClass = Class.forName("com.tencent.thumbplayer.api.ITPPlayer");
      }
      if (sGetCurrentPosition == null) {
        sGetCurrentPosition = sTpPlayerClass.getDeclaredMethod("getCurrentPositionMs", new Class[0]);
      }
      long l = ((Long)sGetCurrentPosition.invoke(paramObject, new Object[0])).longValue();
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
      if (sTpPlayerClass == null) {
        sTpPlayerClass = Class.forName("com.tencent.thumbplayer.api.ITPPlayer");
      }
      if (sGetDuration == null) {
        sGetDuration = sTpPlayerClass.getDeclaredMethod("getDurationMs", new Class[0]);
      }
      int i = ((Integer)sGetDuration.invoke(paramObject, new Object[0])).intValue();
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
  
  private static int getEventOfBufferEnd()
  {
    int i = sBufferEndEventId;
    if (i > 0) {
      return i;
    }
    i = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", new String[] { "TP_PLAYER_INFO_LONG0_BUFFERING_END" });
    sBufferEndEventId = i;
    return i;
  }
  
  private static int getEventOfBufferStart()
  {
    int i = sBufferStartEventId;
    if (i > 0) {
      return i;
    }
    i = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", new String[] { "TP_PLAYER_INFO_LONG0_BUFFERING_START" });
    sBufferStartEventId = i;
    return i;
  }
  
  private static int getEventOfLoopEnd()
  {
    int i = sLoopEndId;
    if (i > 0) {
      return i;
    }
    i = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", new String[] { "TP_PLAYER_INFO_LONG0_CURRENT_LOOP_END" });
    sLoopEndId = i;
    return i;
  }
  
  private static int getEventOfLoopStart()
  {
    int i = sLoopStartId;
    if (i > 0) {
      return i;
    }
    i = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPPlayerMsg", new String[] { "TP_PLAYER_INFO_LONG0_CURRENT_LOOP_START" });
    sLoopStartId = i;
    return i;
  }
  
  private static int getEventOfParamTypeLong()
  {
    int i = sParamsTypeLongId;
    if (i > 0) {
      return i;
    }
    i = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPOptionalParam", new String[] { "TP_OPTIONAL_RARAM_TYPE_LONG", "TP_OPTIONAL_PARAM_TYPE_LONG" });
    sParamsTypeLongId = i;
    return i;
  }
  
  private static int getEventOfSetStartPosition()
  {
    int i = sStartParamsId;
    if (i > 0) {
      return i;
    }
    i = getStaticFiledFromClass("com.tencent.thumbplayer.api.TPOptionalID", new String[] { "OPTION_ID_BEFORE_LONG_START_PLAYING_TIME_MS" });
    sStartParamsId = i;
    return i;
  }
  
  public static long getStartPosition(Object paramObject)
  {
    try
    {
      if (sTpOptionalParamClass == null) {
        sTpOptionalParamClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam");
      }
      if (sGetParamType == null) {
        sGetParamType = sTpOptionalParamClass.getMethod("getParamType", new Class[0]);
      }
      if (((Integer)sGetParamType.invoke(paramObject, new Object[0])).intValue() != convertEventIdToPlayer(4)) {
        return 0L;
      }
      if (sGetParamLong == null) {
        sGetParamLong = sTpOptionalParamClass.getMethod("getParamLong", new Class[0]);
      }
      paramObject = sGetParamLong.invoke(paramObject, new Object[0]);
      if (sTpOptionalParamLongClass == null) {
        sTpOptionalParamLongClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam$OptionalParamLong");
      }
      if (sParamsValue == null) {
        sParamsValue = sTpOptionalParamLongClass.getField("value");
      }
      long l = ((Long)sParamsValue.get(paramObject)).longValue();
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
      if (sTpDefaultReportInfoClass == null) {
        sTpDefaultReportInfoClass = Class.forName("com.tencent.thumbplayer.api.report.TPDefaultReportInfo");
      }
      if (sVid == null) {
        sVid = sTpDefaultReportInfoClass.getField("vid");
      }
      paramObject = (String)sVid.get(paramObject);
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
      if (sTpDefaultReportInfoClass == null) {
        sTpDefaultReportInfoClass = Class.forName("com.tencent.thumbplayer.api.report.TPDefaultReportInfo");
      }
      if (sScenesId == null) {
        sScenesId = sTpDefaultReportInfoClass.getField("scenesId");
      }
      int i = ((Integer)sScenesId.get(paramObject)).intValue();
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
      if (sTpOptionalParamClass == null) {
        sTpOptionalParamClass = Class.forName("com.tencent.thumbplayer.api.TPOptionalParam");
      }
      if (sGetKey == null) {
        sGetKey = sTpOptionalParamClass.getMethod("getKey", new Class[0]);
      }
      int i = ((Integer)sGetKey.invoke(paramObject, new Object[0])).intValue();
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
  
  public static String sessionLog(VideoSession paramVideoSession)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("contentId=");
    localStringBuilder.append(paramVideoSession.getContentId());
    localStringBuilder.append(", identifyer=");
    localStringBuilder.append(paramVideoSession.getIdentifier());
    localStringBuilder.append(", contentType=");
    localStringBuilder.append(paramVideoSession.getContentType());
    localStringBuilder.append(", isBizReady=");
    localStringBuilder.append(paramVideoSession.isBizReady());
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils
 * JD-Core Version:    0.7.0.1
 */