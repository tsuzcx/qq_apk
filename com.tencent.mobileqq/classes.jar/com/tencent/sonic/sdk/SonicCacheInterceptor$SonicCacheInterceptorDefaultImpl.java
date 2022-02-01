package com.tencent.sonic.sdk;

import android.text.TextUtils;
import java.io.File;

class SonicCacheInterceptor$SonicCacheInterceptorDefaultImpl
{
  public static final String TAG = "SonicSdk_DefaultSonicCacheInterceptor";
  
  public static String getCacheData(SonicSession paramSonicSession)
  {
    Object localObject;
    if (paramSonicSession == null)
    {
      SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "getCache is null");
      localObject = null;
      return localObject;
    }
    SonicDataHelper.SessionData localSessionData = SonicDataHelper.getSessionData(paramSonicSession.id);
    String str = "";
    boolean bool;
    if ((TextUtils.isEmpty(localSessionData.eTag)) || (TextUtils.isEmpty(localSessionData.htmlSha1)))
    {
      SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "session(" + paramSonicSession.sId + ") runSonicFlow : session data is empty.");
      bool = true;
    }
    for (;;)
    {
      localObject = str;
      if (!bool) {
        break;
      }
      long l = System.currentTimeMillis();
      SonicUtils.removeSessionCache(paramSonicSession.id);
      localSessionData.reset();
      SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "session(" + paramSonicSession.sId + ") runSonicFlow:verify error so remove session cache, cost " + (System.currentTimeMillis() - l) + "ms.");
      return str;
      SonicDataHelper.updateSonicCacheHitCount(paramSonicSession.id);
      localObject = new File(SonicFileUtils.getSonicHtmlPath(paramSonicSession.id));
      str = SonicFileUtils.readFile((File)localObject);
      bool = TextUtils.isEmpty(str);
      if (bool)
      {
        SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, "session(" + paramSonicSession.sId + ") runSonicFlow error:cache data is null.");
      }
      else if (SonicEngine.getInstance().getConfig().VERIFY_CACHE_FILE_WITH_SHA1)
      {
        if (!SonicFileUtils.verifyData(str, localSessionData.htmlSha1))
        {
          str = "";
          SonicEngine.getInstance().getRuntime().notifyError(paramSonicSession.sessionClient, paramSonicSession.srcUrl, -1001);
          SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, "session(" + paramSonicSession.sId + ") runSonicFlow error:verify html cache with sha1 fail.");
          bool = true;
        }
        else
        {
          SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "session(" + paramSonicSession.sId + ") runSonicFlow verify html cache with sha1 success.");
        }
      }
      else if (localSessionData.htmlSize != ((File)localObject).length())
      {
        str = "";
        SonicEngine.getInstance().getRuntime().notifyError(paramSonicSession.sessionClient, paramSonicSession.srcUrl, -1001);
        SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, "session(" + paramSonicSession.sId + ") runSonicFlow error:verify html cache with size fail.");
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicCacheInterceptor.SonicCacheInterceptorDefaultImpl
 * JD-Core Version:    0.7.0.1
 */