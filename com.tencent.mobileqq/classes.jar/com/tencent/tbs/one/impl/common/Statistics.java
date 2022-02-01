package com.tencent.tbs.one.impl.common;

import com.tencent.tbs.one.impl.base.Logging;
import java.util.HashMap;
import java.util.Map;

public final class Statistics
{
  public static final String EVENT_ACTION = "TBSOneAction";
  public static final String EVENT_ERROR = "TBSOneError";
  public static final String KEY_COMPONENT_NAME = "COMPONENT_NAME";
  public static final String KEY_COMPONENT_VERSION_CODE = "COMPONENT_VERSION_CODE";
  public static final String KEY_DEPS_VERSION_CODE = "DEPS_VERSION_CODE";
  public static final String KEY_DESCRIPTION = "DESCRIPTION";
  public static final String KEY_THROWABLE = "THROWABLE";
  private static Statistics.StatisticsProvider sProvider;
  
  public static void initialize(Statistics.StatisticsProvider paramStatisticsProvider)
  {
    sProvider = paramStatisticsProvider;
  }
  
  public static void reportAction(int paramInt)
  {
    reportEvent("TBSOneAction", paramInt, null);
  }
  
  public static void reportAction(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("DESCRIPTION", paramString);
    reportEvent("TBSOneAction", paramInt, localHashMap);
  }
  
  public static void reportError(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, Throwable paramThrowable)
  {
    Logging.i("Reporting error: [%d] %s", new Object[] { Integer.valueOf(paramInt3), paramString2, paramThrowable });
    HashMap localHashMap = new HashMap();
    localHashMap.put("DEPS_VERSION_CODE", Integer.valueOf(paramInt1));
    localHashMap.put("COMPONENT_NAME", paramString1);
    localHashMap.put("COMPONENT_VERSION_CODE", Integer.valueOf(paramInt2));
    localHashMap.put("DESCRIPTION", paramString2);
    localHashMap.put("THROWABLE", paramThrowable);
    reportEvent("TBSOneError", paramInt3, localHashMap);
  }
  
  public static void reportEvent(String paramString, int paramInt, Map paramMap)
  {
    if (sProvider != null) {
      sProvider.reportEvent(paramString, paramInt, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.Statistics
 * JD-Core Version:    0.7.0.1
 */