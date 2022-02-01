package com.tencent.tbs.one.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.tbs.log.TBSLog;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.common.Statistics;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import com.tencent.tbs.one.impl.policy.CleanupThread;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.PolicyManager;
import com.tencent.tbs.one.impl.policy.PolicyManagerImpl;
import com.tencent.tbs.one.impl.policy.auto.AutoComponentInstallationJob;
import com.tencent.tbs.one.impl.policy.auto.AutoDEPSInstallationJob;
import com.tencent.tbs.sdk.BuildConfig;
import java.io.File;
import java.util.Map;
import java.util.Set;

public final class Factory
{
  private static final String DEBUG_CONFIG_FILE = "debug.conf";
  private static final String LOCAL_REPOSITORY_PATH = "/android_asset/";
  private static final String OFFICIAL_ONLINE_SERVICE_URL = "https://tbsone.imtt.qq.com";
  private static final String[] SHARABLE_APPLICATION_PACKAGES = { "com.tencent.mm", "com.tencent.mobileqq", "com.tencent.tbs" };
  private static final String TEST_ONLINE_SERVICE_URL = "https://tbsone.sparta.html5.qq.com";
  private static boolean sInitialized;
  private static final Object sLock = new Object();
  
  private static void initialize(Context paramContext)
  {
    TBSLog.initialize(paramContext.getApplicationContext(), "onelog", 604800000L, 3145728L);
    Logging.override(new Factory.1());
    StatisticReport.initialize(paramContext.getApplicationContext());
    Statistics.initialize(new Factory.2());
    Runtime.getRuntime().addShutdownHook(new CleanupThread(PathService.getDataRootDirectory(paramContext)));
  }
  
  public static void initializeOnce(Context paramContext)
  {
    synchronized (sLock)
    {
      if (!sInitialized)
      {
        initialize(paramContext);
        sInitialized = true;
      }
      return;
    }
  }
  
  public static CancellableJob<InstallationResult<File>> newAutoComponentInstallationJob(PolicyManagerImpl paramPolicyManagerImpl, DEPSConfig.ComponentConfig paramComponentConfig, File paramFile, Bundle paramBundle)
  {
    return new AutoComponentInstallationJob(paramPolicyManagerImpl.getCallerContext(), paramPolicyManagerImpl.getCategory(), paramPolicyManagerImpl.getOnlineServiceUrl(), paramPolicyManagerImpl.getSharableApplicationPackages(), paramComponentConfig, paramFile, paramBundle);
  }
  
  public static CancellableJob<InstallationResult<DEPSConfig>> newAutoDEPSInstallationJob(PolicyManagerImpl paramPolicyManagerImpl, int paramInt, File paramFile, Bundle paramBundle)
  {
    return new AutoDEPSInstallationJob(paramPolicyManagerImpl.getCallerContext(), paramPolicyManagerImpl.getCategory(), paramPolicyManagerImpl.getOnlineServiceUrl(), paramPolicyManagerImpl.getSharableApplicationPackages(), paramInt, paramFile, paramBundle);
  }
  
  public static PolicyManager newPolicyManager(Context paramContext, String paramString)
  {
    Object localObject2 = new File(new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "tencent"), "tbs"), paramContext.getPackageName()), paramString), "debug.conf");
    if (((File)localObject2).exists()) {}
    for (Object localObject1 = "https://tbsone.sparta.html5.qq.com";; localObject1 = "https://tbsone.imtt.qq.com")
    {
      StatisticReport.shiftRepService(((File)localObject2).exists());
      paramContext = new PolicyManagerImpl(paramContext, paramString, "/android_asset/", (String)localObject1, SHARABLE_APPLICATION_PACKAGES);
      if ("default".equals(paramString))
      {
        localObject2 = paramContext.getPreferences();
        if (((SharedPreferences)localObject2).contains("in_use_component_names")) {}
      }
      try
      {
        localObject1 = BuildConfig.COMPONENT_SDK_VERSIONS.keySet();
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putStringSet("in_use_component_names", (Set)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
        return paramContext;
      }
      catch (Throwable localThrowable)
      {
        Logging.e("[%s] Failed to preset in-use component names", new Object[] { paramString, localThrowable });
      }
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.Factory
 * JD-Core Version:    0.7.0.1
 */