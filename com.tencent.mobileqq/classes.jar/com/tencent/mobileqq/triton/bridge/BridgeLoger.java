package com.tencent.mobileqq.triton.bridge;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class BridgeLoger
{
  private static final String HTTP_CALLBACK_PREFIX = "WeixinJSBridge.subscribeHandler(\"onRequestTaskStateChange\",";
  private static int MAX_CALLBACKID = 1048576;
  private static int MAX_UNIKEYID = 1024;
  private static int RESERVER_BIT = 0;
  private static Pattern SUBSCRIBE_PATTERN = Pattern.compile("(?<=\").*?(?=\")");
  private static final String SUBSCRIBE_PREFIX = "WeixinJSBridge.subscribeHandler";
  private static final String TAG = "<API>";
  private static final String TT_GLOBAL = "__TT__GLOBAL__";
  private static Pattern TT_GLOBAL_PATTERN = Pattern.compile(".*__TT__GLOBAL__.*");
  private static final String __JSBRIDGE_ALL_LOG__ = "__jsBridge_all_log__";
  private static int gApiCount = 0;
  private static int gUniKeyPrev = 0;
  private HashMap<Integer, Long> CallbackID2StartTime = new HashMap();
  private HashMap<Integer, String> EventName2CallbackID = new HashMap();
  private Set<String> LOG_BLACK_LIST;
  private Set<String> LOG_WHITE_LIST;
  private HashMap<Integer, Integer> RequestTaskID2CallbackID = new HashMap();
  private TTEngine mTritonEngine;
  private boolean printAllLog = false;
  
  static
  {
    RESERVER_BIT = 11;
  }
  
  public BridgeLoger(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private String cutString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.length() < 256) || (paramString.length() < 256)) {
      return paramString;
    }
    return paramString.substring(0, 256);
  }
  
  private void ensureWhiteBlackList()
  {
    Set localSet;
    Object localObject;
    if (this.LOG_WHITE_LIST == null)
    {
      localSet = this.mTritonEngine.getQQEnv().getLogWhiteList();
      localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      this.LOG_WHITE_LIST = ((Set)localObject);
      this.printAllLog = this.LOG_WHITE_LIST.contains("__jsBridge_all_log__");
    }
    if (this.LOG_BLACK_LIST == null)
    {
      localSet = this.mTritonEngine.getQQEnv().getLogBlackList();
      localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      this.LOG_BLACK_LIST = ((Set)localObject);
    }
  }
  
  private String findEventTag(String paramString)
  {
    Object localObject = null;
    String str = null;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = SUBSCRIBE_PATTERN.matcher(paramString);
      if (((Matcher)localObject).find()) {
        str = ((Matcher)localObject).group();
      }
      localObject = str;
      if (str == null)
      {
        localObject = str;
        if (TT_GLOBAL_PATTERN.matcher(paramString).find()) {
          localObject = "__TT__GLOBAL__";
        }
      }
    }
    return localObject;
  }
  
  private boolean isEnableLog(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      ensureWhiteBlackList();
      if (this.printAllLog) {
        return true;
      }
      if ((this.LOG_WHITE_LIST != null) && (this.LOG_WHITE_LIST.contains(paramString))) {
        return true;
      }
    } while ((this.LOG_BLACK_LIST != null) && (this.LOG_BLACK_LIST.contains(paramString)));
    return true;
  }
  
  private String trimString(String paramString)
  {
    try
    {
      if (paramString.indexOf("WeixinJSBridge.subscribeHandler") != -1)
      {
        if ((paramString.indexOf("onDownloadTaskStateChange") > 0) && (paramString.indexOf("totalBytesWritten") > 0) && (paramString.indexOf("progress") > 0)) {
          return "";
        }
        return paramString.replace("WeixinJSBridge.subscribeHandler", "");
      }
      if (paramString.indexOf("WeixinJSBridge.invokeCallbackHandler") != -1) {
        return "";
      }
    }
    catch (Throwable localThrowable)
    {
      TTLog.i("<API>", "trimString exception:" + localThrowable.getMessage());
    }
    return paramString;
  }
  
  public int changeCallbackId(int paramInt)
  {
    if (paramInt < MAX_CALLBACKID)
    {
      int i = RESERVER_BIT;
      int j = gUniKeyPrev;
      gUniKeyPrev = j + 1;
      if (gUniKeyPrev > MAX_UNIKEYID) {
        gUniKeyPrev = 0;
      }
      return (paramInt << i) + j;
    }
    TTLog.e("<API>", "callbackId is toooo large, start vs end might not match");
    return paramInt;
  }
  
  public String getKey(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder().append(" api(");
      paramInt = gApiCount;
      gApiCount = paramInt + 1;
      return paramInt + ") : eventName=[" + paramString1 + "] Params=[" + cutString(paramString2) + "]";
    }
    if (paramInt == 2)
    {
      localStringBuilder = new StringBuilder().append("OPENCONTEXT api(");
      paramInt = gApiCount;
      gApiCount = paramInt + 1;
      return paramInt + ") : eventName=[" + paramString1 + "] Params=[" + cutString(paramString2) + "]";
    }
    if (paramInt == 3)
    {
      localStringBuilder = new StringBuilder().append("WORKER api(");
      paramInt = gApiCount;
      gApiCount = paramInt + 1;
      return paramInt + ") : eventName=[" + paramString1 + "] Params=[" + cutString(paramString2) + "]";
    }
    return "UNKNOW API";
  }
  
  public int printEndLog(int paramInt1, int paramInt2, String paramString)
  {
    String str;
    if (this.EventName2CallbackID.containsKey(Integer.valueOf(paramInt2)))
    {
      str = (String)this.EventName2CallbackID.remove(Integer.valueOf(paramInt2));
      Long localLong = (Long)this.CallbackID2StartTime.remove(Integer.valueOf(paramInt2));
      if ((localLong == null) || (localLong.longValue() <= 0L)) {
        break label130;
      }
      TTLog.i("<API>", "end cost:" + (System.currentTimeMillis() - localLong.longValue()) + "ms " + str + " R=[" + cutString(paramString) + "]");
    }
    for (;;)
    {
      return paramInt2 >> RESERVER_BIT;
      label130:
      TTLog.i("<API>", "end " + str + " R=[" + cutString(paramString) + "]");
    }
  }
  
  public void printEndLog(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!isEnableLog(findEventTag(paramString)));
        if (!paramString.startsWith("WeixinJSBridge.subscribeHandler(\"onRequestTaskStateChange\",")) {
          break;
        }
        paramString = paramString.replace("WeixinJSBridge.subscribeHandler(\"onRequestTaskStateChange\",", "");
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.endsWith(")")));
      paramString = paramString.substring(0, paramString.length() - 1);
      String str;
      try
      {
        paramInt = new JSONObject(paramString).optInt("requestTaskId");
        paramInt = ((Integer)this.RequestTaskID2CallbackID.get(Integer.valueOf(paramInt))).intValue();
        str = (String)this.EventName2CallbackID.get(Integer.valueOf(paramInt));
        Long localLong = (Long)this.CallbackID2StartTime.get(Integer.valueOf(paramInt));
        if ((localLong != null) && (localLong.longValue() > 0L))
        {
          TTLog.i("<API>", "end cost:" + (System.currentTimeMillis() - localLong.longValue()) + "ms " + str + " R=[" + cutString(paramString) + "]");
          return;
        }
      }
      catch (Exception paramString)
      {
        TTLog.e("<API>", "printEndLog get http requestTaskId exception");
        return;
      }
      TTLog.i("<API>", "end  " + str + " R=[" + cutString(paramString) + "]");
      return;
      paramString = cutString(trimString(paramString));
    } while (TextUtils.isEmpty(paramString));
    TTLog.i("<API>", "end evaluateJS():" + paramString);
  }
  
  public void printEndLog(int paramInt, String paramString1, String paramString2)
  {
    if (!isEnableLog(paramString1)) {}
    do
    {
      return;
      paramString1 = cutString("eventName:" + paramString1 + ", params:" + paramString2);
    } while (TextUtils.isEmpty(paramString1));
    TTLog.i("<API>", "end evaluateJS():" + paramString1);
  }
  
  public void printStartLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    if (!isEnableLog(paramString1)) {}
    do
    {
      do
      {
        return;
        paramString2 = getKey(paramInt1, paramString1, paramString2);
        this.EventName2CallbackID.put(Integer.valueOf(paramInt2), paramString2);
        this.CallbackID2StartTime.put(Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()));
        if ("{}".equals(paramString3))
        {
          TTLog.i("<API>", "start " + paramString2 + "###NEED CALLBACK###");
          return;
        }
        if (!"createRequestTask".equals(paramString1)) {
          break;
        }
        TTLog.i("<API>", "start " + paramString2 + " R=[" + cutString(paramString3) + "]");
      } while (TextUtils.isEmpty(paramString3));
      try
      {
        paramInt1 = new JSONObject(paramString3).optInt("requestTaskId");
        this.RequestTaskID2CallbackID.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        return;
      }
      catch (Exception paramString1)
      {
        TTLog.e("<API>", "printStartLog get http requestTaskId exception");
        return;
      }
    } while ("getAudioState".equals(paramString1));
    TTLog.i("<API>", "start " + paramString2 + " R=[" + cutString(paramString3) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.BridgeLoger
 * JD-Core Version:    0.7.0.1
 */