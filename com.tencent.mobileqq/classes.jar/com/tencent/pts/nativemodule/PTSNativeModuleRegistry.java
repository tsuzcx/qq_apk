package com.tencent.pts.nativemodule;

import android.text.TextUtils;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;

public class PTSNativeModuleRegistry
{
  public static final String MODULE_NAME_ALL_IN_ONE_JUMP_REQUEST = "AllInOneJumpModule";
  public static final String MODULE_NAME_HANDLE_JS_EXCEPTION = "HandleJSException";
  public static final String MODULE_NAME_LOAD_FEEDS = "LoadFeedsModule";
  public static final String MODULE_NAME_MAKE_HTTP_REQUEST = "MakeHttpRequest";
  public static final String MODULE_NAME_MARK_ARTICLE_READ = "MarkArticleRead";
  public static final String MODULE_NAME_NAVIGATE_TO = "NavigateToModule";
  public static final String MODULE_NAME_REPORT_TO_1160 = "ReportTo1160";
  public static final String MODULE_NAME_REQUEST_FEEDS = "RequestFeedsModule";
  public static final String TAG = "PTSNativeModuleRegistry";
  public static boolean sIsDemo = false;
  private static HashMap<String, PTSNativeModuleRegistry.PTSNativeModule> sNativeModuleMap = new HashMap();
  
  public static void JSLog(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if ("EVENT".equalsIgnoreCase(paramString1)) {
        PTSLog.e("PTSNativeModuleRegistry", paramString2);
      }
      do
      {
        return;
        if ("DEBUG".equalsIgnoreCase(paramString1))
        {
          PTSLog.d("PTSNativeModuleRegistry", paramString2);
          return;
        }
        if ("INFO".equalsIgnoreCase(paramString1))
        {
          PTSLog.i("PTSNativeModuleRegistry", paramString2);
          return;
        }
      } while (!"WARN".equalsIgnoreCase(paramString1));
      PTSLog.w("PTSNativeModuleRegistry", paramString2);
      return;
    }
    PTSLog.i("PTSNativeModuleRegistry", paramString2);
  }
  
  public static void allInOneJump(String paramString)
  {
    PTSNativeModuleRegistry.PTSNativeModule localPTSNativeModule = (PTSNativeModuleRegistry.PTSNativeModule)sNativeModuleMap.get("AllInOneJumpModule");
    if ((localPTSNativeModule instanceof IPTSAllInOneJump)) {
      ((IPTSAllInOneJump)localPTSNativeModule).allInOneJump(paramString);
    }
  }
  
  public static void clearNativeModule()
  {
    sNativeModuleMap.clear();
  }
  
  public static String getEnvVariable(String paramString)
  {
    if (TextUtils.equals(paramString, "is_demo"))
    {
      if (sIsDemo) {
        return "1";
      }
      return "0";
    }
    if (TextUtils.equals(paramString, "platform")) {
      return "Android";
    }
    return "";
  }
  
  public static void handleJSException(int paramInt1, int paramInt2, String paramString)
  {
    PTSNativeModuleRegistry.PTSNativeModule localPTSNativeModule = (PTSNativeModuleRegistry.PTSNativeModule)sNativeModuleMap.get("HandleJSException");
    if ((localPTSNativeModule instanceof IPTSHandleJSException)) {
      ((IPTSHandleJSException)localPTSNativeModule).handleJSException(paramInt1, paramInt2, paramString);
    }
  }
  
  public static void loadFeeds(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    PTSNativeModuleRegistry.PTSNativeModule localPTSNativeModule = (PTSNativeModuleRegistry.PTSNativeModule)sNativeModuleMap.get("LoadFeedsModule");
    if ((localPTSNativeModule instanceof IPTSLoadFeeds)) {
      ((IPTSLoadFeeds)localPTSNativeModule).loadFeeds(paramLong1, paramLong2, paramInt, paramLong3);
    }
  }
  
  public static void makeHTTPRequest(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    PTSNativeModuleRegistry.PTSNativeModule localPTSNativeModule = (PTSNativeModuleRegistry.PTSNativeModule)sNativeModuleMap.get("MakeHttpRequest");
    if ((localPTSNativeModule instanceof IPTSMakeHttpRequest)) {
      ((IPTSMakeHttpRequest)localPTSNativeModule).makeHTTPRequest(paramString, paramInt, paramLong1, paramLong2, paramLong3);
    }
  }
  
  public static void markArticleRead(long paramLong1, long paramLong2)
  {
    PTSNativeModuleRegistry.PTSNativeModule localPTSNativeModule = (PTSNativeModuleRegistry.PTSNativeModule)sNativeModuleMap.get("MarkArticleRead");
    if ((localPTSNativeModule instanceof PTSNativeModuleRegistry.IPTSMarkArticleRead)) {
      ((PTSNativeModuleRegistry.IPTSMarkArticleRead)localPTSNativeModule).markArticleRead(paramLong1, paramLong2);
    }
  }
  
  public static void navigateTo(String paramString)
  {
    PTSNativeModuleRegistry.PTSNativeModule localPTSNativeModule = (PTSNativeModuleRegistry.PTSNativeModule)sNativeModuleMap.get("NavigateToModule");
    if ((localPTSNativeModule instanceof IPTSNavigateTo)) {
      ((IPTSNavigateTo)localPTSNativeModule).navigateTo(paramString);
    }
  }
  
  public static void ptsLogger(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (PTSLog.isColorLevel()) {
        PTSLog.i("PTSNativeModuleRegistry", paramString);
      }
      return;
    }
    PTSLog.i("PTSNativeModuleRegistry", paramString);
  }
  
  public static void registerNativeModule(String paramString, PTSNativeModuleRegistry.PTSNativeModule paramPTSNativeModule)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramPTSNativeModule != null)) {
      sNativeModuleMap.put(paramString, paramPTSNativeModule);
    }
  }
  
  public static void reportTo1160(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4)
  {
    PTSNativeModuleRegistry.PTSNativeModule localPTSNativeModule = (PTSNativeModuleRegistry.PTSNativeModule)sNativeModuleMap.get("ReportTo1160");
    if ((localPTSNativeModule instanceof PTSNativeModuleRegistry.IPTSReportTo1160)) {
      ((PTSNativeModuleRegistry.IPTSReportTo1160)localPTSNativeModule).reportTo1160(paramString1, paramString2, paramLong, paramInt, paramString3, paramString4);
    }
  }
  
  public static void requestFeeds(long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, long paramLong4)
  {
    PTSNativeModuleRegistry.PTSNativeModule localPTSNativeModule = (PTSNativeModuleRegistry.PTSNativeModule)sNativeModuleMap.get("RequestFeedsModule");
    if ((localPTSNativeModule instanceof IPTSRequestFeeds)) {
      ((IPTSRequestFeeds)localPTSNativeModule).requestFeeds(paramLong1, paramLong2, paramBoolean, paramLong3, paramLong4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.nativemodule.PTSNativeModuleRegistry
 * JD-Core Version:    0.7.0.1
 */