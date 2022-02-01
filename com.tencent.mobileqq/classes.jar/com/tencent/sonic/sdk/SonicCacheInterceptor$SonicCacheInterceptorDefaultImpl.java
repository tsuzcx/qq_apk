package com.tencent.sonic.sdk;

import android.text.TextUtils;
import java.io.File;

class SonicCacheInterceptor$SonicCacheInterceptorDefaultImpl
{
  public static final String TAG = "SonicSdk_DefaultSonicCacheInterceptor";
  
  public static String getCacheData(SonicSession paramSonicSession)
  {
    if (paramSonicSession == null)
    {
      SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, "getCache is null");
      return null;
    }
    SonicDataHelper.SessionData localSessionData = SonicDataHelper.getSessionData(paramSonicSession.id);
    boolean bool = TextUtils.isEmpty(localSessionData.eTag);
    int i = 1;
    Object localObject1 = "";
    Object localObject2;
    if ((!bool) && (!TextUtils.isEmpty(localSessionData.htmlSha1)))
    {
      SonicDataHelper.updateSonicCacheHitCount(paramSonicSession.id);
      File localFile = new File(SonicFileUtils.getSonicHtmlPath(paramSonicSession.id));
      localObject2 = SonicFileUtils.readFile(localFile);
      bool = TextUtils.isEmpty((CharSequence)localObject2);
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("session(");
        ((StringBuilder)localObject1).append(paramSonicSession.sId);
        ((StringBuilder)localObject1).append(") runSonicFlow error:cache data is null.");
        SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, ((StringBuilder)localObject1).toString());
      }
      else if (SonicEngine.getInstance().getConfig().VERIFY_CACHE_FILE_WITH_SHA1)
      {
        if (!SonicFileUtils.verifyData((String)localObject2, localSessionData.htmlSha1))
        {
          SonicEngine.getInstance().getRuntime().notifyError(paramSonicSession.sessionClient, paramSonicSession.srcUrl, -1001);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("session(");
          ((StringBuilder)localObject2).append(paramSonicSession.sId);
          ((StringBuilder)localObject2).append(") runSonicFlow error:verify html cache with sha1 fail.");
          SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, ((StringBuilder)localObject2).toString());
          break label429;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("session(");
        ((StringBuilder)localObject1).append(paramSonicSession.sId);
        ((StringBuilder)localObject1).append(") runSonicFlow verify html cache with sha1 success.");
        SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, ((StringBuilder)localObject1).toString());
      }
      else if (localSessionData.htmlSize != localFile.length())
      {
        SonicEngine.getInstance().getRuntime().notifyError(paramSonicSession.sessionClient, paramSonicSession.srcUrl, -1001);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("session(");
        ((StringBuilder)localObject2).append(paramSonicSession.sId);
        ((StringBuilder)localObject2).append(") runSonicFlow error:verify html cache with size fail.");
        SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 6, ((StringBuilder)localObject2).toString());
        break label429;
      }
      localObject1 = localObject2;
      i = bool;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("session(");
      ((StringBuilder)localObject2).append(paramSonicSession.sId);
      ((StringBuilder)localObject2).append(") runSonicFlow : session data is empty.");
      SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, ((StringBuilder)localObject2).toString());
    }
    label429:
    if (i != 0)
    {
      long l = System.currentTimeMillis();
      SonicUtils.removeSessionCache(paramSonicSession.id);
      localSessionData.reset();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("session(");
      ((StringBuilder)localObject2).append(paramSonicSession.sId);
      ((StringBuilder)localObject2).append(") runSonicFlow:verify error so remove session cache, cost ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject2).append("ms.");
      SonicUtils.log("SonicSdk_DefaultSonicCacheInterceptor", 4, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicCacheInterceptor.SonicCacheInterceptorDefaultImpl
 * JD-Core Version:    0.7.0.1
 */