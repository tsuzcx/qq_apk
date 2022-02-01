package com.tencent.xweb.xwalk.updater;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.ad;
import com.tencent.xweb.xwalk.p;
import java.util.HashMap;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.ErrorInfo;

public class g
  extends AsyncTask<String, Integer, Integer>
{
  static XWalkUpdater a;
  private static String c = "0";
  private HashMap<String, String> b;
  
  public g(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    a = paramXWalkUpdater;
    this.b = paramHashMap;
    if (paramHashMap != null)
    {
      c = (String)paramHashMap.get("UpdaterCheckType");
      paramXWalkUpdater = c;
      if ((paramXWalkUpdater != null) && (paramXWalkUpdater.equals("1")))
      {
        Scheduler.m();
      }
      else
      {
        paramXWalkUpdater = c;
        if ((paramXWalkUpdater != null) && (paramXWalkUpdater.equals("2")))
        {
          Scheduler.m();
          com.tencent.xweb.util.h.a(93L, 1);
        }
        else
        {
          paramXWalkUpdater = c;
          if ((paramXWalkUpdater != null) && (paramXWalkUpdater.equals("3")))
          {
            XWebCoreScheduler.z().r().q = true;
            com.tencent.xweb.util.h.a(94L, 1);
          }
          else
          {
            c = "0";
          }
        }
      }
    }
    paramXWalkUpdater = new StringBuilder();
    paramXWalkUpdater.append("XWalkUpdateChecker notify received !! mNotifyType = ");
    paramXWalkUpdater.append(c);
    XWalkInitializer.addXWalkInitializeLog(paramXWalkUpdater.toString());
  }
  
  public static void a(int paramInt, Scheduler paramScheduler)
  {
    
    if (paramScheduler != null) {
      paramScheduler.b(paramInt);
    }
  }
  
  public static void a(Scheduler paramScheduler)
  {
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    c();
    if (paramScheduler != null) {
      paramScheduler.b(null);
    }
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = h.a();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static boolean a(XWebCoreScheduler paramXWebCoreScheduler)
  {
    c localc = paramXWebCoreScheduler.r();
    if (a()) {
      return false;
    }
    XWalkUpdater.ErrorInfo localErrorInfo;
    if (!XWalkEnvironment.isSelfProvider())
    {
      b();
      localErrorInfo = a.updateRuntimeFromProvider(paramXWebCoreScheduler);
    }
    try
    {
      Object localObject2 = XWalkEnvironment.getPackageName();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localErrorInfo.errorCode);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localErrorInfo.targetVer);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localErrorInfo.readFileListFailedCount);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localErrorInfo.noMatchedVersionCount);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localErrorInfo.copyFailedCount);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localErrorInfo.md5FailedCount);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localErrorInfo.extractFailedCount);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localErrorInfo.setVersionFailedCount);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(localErrorInfo.extractRetryFailedCount);
      localObject1 = ((StringBuilder)localObject1).toString();
      ContentResolver localContentResolver = XWalkEnvironment.getContentResolver();
      if (localContentResolver == null) {
        break label262;
      }
      localObject2 = XWebCoreContentProvider.a("com.tencent.mm", (String)localObject2, 3, 0, "");
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(String.valueOf(15626), (String)localObject1);
      localContentResolver.insert((Uri)localObject2, localContentValues);
    }
    catch (Exception localException)
    {
      label257:
      break label257;
    }
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate report error");
    label262:
    if (localErrorInfo.errorCode == 0)
    {
      p.a("finished", 0);
      a(paramXWebCoreScheduler);
      return true;
    }
    if (localErrorInfo.errorCode == -10)
    {
      a(localErrorInfo.errorCode, paramXWebCoreScheduler);
      return false;
    }
    c();
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramXWebCoreScheduler = ad.a();
      if (paramXWebCoreScheduler != null) {
        paramXWebCoreScheduler.c();
      }
      return false;
    }
    if ((!localc.q) && (!NetworkUtil.isWifiAvailable()))
    {
      XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
      paramXWebCoreScheduler = ad.a();
      if (paramXWebCoreScheduler != null) {
        paramXWebCoreScheduler.c();
      }
      return false;
    }
    if (b())
    {
      if (a.updateXWalkRuntime(paramXWebCoreScheduler.c(localc))) {
        return true;
      }
      XWalkInitializer.addXWalkInitializeLog("start update failed");
      c();
    }
    return false;
  }
  
  static void b(XWebCoreScheduler paramXWebCoreScheduler)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("try update after config ");
    ((StringBuilder)localObject).append(paramXWebCoreScheduler.toString());
    XWalkEnvironment.addXWalkInitializeLog(((StringBuilder)localObject).toString());
    if (a()) {
      return;
    }
    com.tencent.xweb.util.h.b(903L, 160L, 1L);
    localObject = ad.a();
    if (localObject != null) {
      ((com.tencent.xweb.xwalk.c)localObject).a();
    }
    a(paramXWebCoreScheduler);
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = h.b();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void c()
  {
    try
    {
      h.d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static boolean d()
  {
    if ((!XWalkEnvironment.hasInstalledAvailableVersion()) && (!XWebCoreScheduler.z().h()))
    {
      XWalkEnvironment.addXWalkInitializeLog("isNeedFecthConfig: true because no scheduler and no availableVersion ");
      return true;
    }
    return (Scheduler.b(false).q()) && (!a());
  }
  
  static void e()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      localObject = ad.a();
      if (localObject != null) {
        ((com.tencent.xweb.xwalk.c)localObject).b(1);
      }
      XWalkEnvironment.addXWalkInitializeLog("network not available!!");
      return;
    }
    XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew begin!!");
    Object localObject = new j.a();
    ((j.a)localObject).a = XWalkEnvironment.getXWalkUpdateConfigUrl();
    ((j.a)localObject).b = XWalkEnvironment.getUpdateConfigFullPath();
    ((j.a)localObject).c = true;
    j.a((j.a)localObject, new g.1());
  }
  
  static void f()
  {
    if (XWebCoreScheduler.z().c(true))
    {
      b(XWebCoreScheduler.z());
      return;
    }
    if (i.y().c(true))
    {
      b(i.y());
      return;
    }
    p.a("finished", -5);
  }
  
  protected Integer a(String... paramVarArgs)
  {
    boolean bool = d();
    paramVarArgs = Integer.valueOf(2);
    if (bool) {
      return paramVarArgs;
    }
    if ((!XWebCoreScheduler.z().c(false)) && (!i.y().c(false))) {
      return Integer.valueOf(0);
    }
    XWalkEnvironment.addXWalkInitializeLog("fetch config before update");
    com.tencent.xweb.util.h.a(903L, 159L, 1L);
    return paramVarArgs;
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 2) {
      e();
    }
    super.onPostExecute(paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.g
 * JD-Core Version:    0.7.0.1
 */