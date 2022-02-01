package com.tencent.mobileqq.intervideo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Shadow
{
  private static PluginManagerWrapper jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper;
  public static final IVPluginDataReporter a;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
    jdField_a_of_type_JavaLangObject = new Object();
    a();
  }
  
  public static IVPluginManager a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = (IVPluginManager)ThreadManagerExecutor.getExecutorService(192).submit(new Shadow.1(paramContext, paramString1)).get(20L, TimeUnit.SECONDS);
      return paramContext;
    }
    catch (TimeoutException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
    catch (InterruptedException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
    catch (ExecutionException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
  }
  
  private static PluginManagerWrapper a(String paramString, CdnPmUpdater paramCdnPmUpdater)
  {
    QLog.i("shadow::Shadow", 2, "pluginManagerWrapper ，sPluginManagerWrapper = " + jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper + " bizType:" + paramString);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper == null)
      {
        jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper = new PluginManagerWrapper(paramString, new DynamicPluginManager(paramCdnPmUpdater));
        QLog.i("shadow::Shadow", 2, "new pluginManagerWrapper : " + jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper);
      }
      paramString = jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper;
      return paramString;
    }
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      LoggerFactory.setILoggerFactory(IVLoggerFactory.a());
      label12:
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label12;
    }
  }
  
  public static IVPluginManager b(Context paramContext, String paramString1, String paramString2)
  {
    l1 = System.currentTimeMillis();
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(paramString1).opType("CdnGetBizPm").toUin(paramString2);
    Object localObject1 = new DataLocalTmpPmUpdater(paramString1);
    if (((DataLocalTmpPmUpdater)localObject1).getLatest() != null) {
      return new PluginManagerWrapper(paramString1, new DynamicPluginManager((PluginManagerUpdater)localObject1));
    }
    localCdnPmUpdater = new CdnPmUpdater(paramContext.getApplicationContext(), paramString1, paramString2, "9_1");
    if (QLog.isColorLevel()) {
      QLog.i("shadow::Shadow", 2, "wasUpdating:" + localCdnPmUpdater.wasUpdating() + " getLatest:" + localCdnPmUpdater.getLatest());
    }
    if ((localCdnPmUpdater.wasUpdating()) || (localCdnPmUpdater.getLatest() == null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.i("shadow::Shadow", 2, "needWaitingUpdate:" + bool);
      }
      if (TextUtils.equals("GVideo", paramString1)) {
        localCdnPmUpdater.a(new Shadow.2(paramString1));
      }
      paramString2 = localCdnPmUpdater.update();
      if (!bool) {}
    }
    for (;;)
    {
      try
      {
        paramString2.get();
        localObject2 = paramContext.getPackageManager();
        if (localCdnPmUpdater.getLatest() != null)
        {
          paramContext = localCdnPmUpdater.getLatest().getAbsolutePath();
          l2 = System.currentTimeMillis();
          localObject1 = null;
          paramString2 = null;
        }
      }
      catch (ExecutionException paramContext)
      {
        Object localObject2;
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(1).report();
        throw paramContext;
      }
      catch (InterruptedException paramContext)
      {
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(2).report();
        throw paramContext;
      }
      try
      {
        localObject2 = ((PackageManager)localObject2).getPackageArchiveInfo(paramContext, 128);
        paramString2 = (String)localObject2;
        localObject1 = localObject2;
        QLog.i("shadow::Shadow", 2, "getPackageArchiveInfo，timespan = " + (System.currentTimeMillis() - l2));
        if (localObject2 == null) {
          paramString1 = "";
        }
      }
      catch (Exception localException)
      {
        if (paramString2 == null) {
          paramString1 = "";
        }
        try
        {
          paramString2 = MD5FileUtil.a(localCdnPmUpdater.getLatest());
          paramString1 = paramString2;
        }
        catch (IOException paramString2)
        {
          break label497;
        }
        QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
        localCdnPmUpdater.a();
        throw new InvalidFileException("pluginManager apk file is invalid!");
      }
      finally
      {
        if (localException == null) {
          paramString1 = "";
        }
        try
        {
          paramString2 = MD5FileUtil.a(localCdnPmUpdater.getLatest());
          paramString1 = paramString2;
        }
        catch (IOException paramString2)
        {
          break label592;
        }
        QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
        localCdnPmUpdater.a();
        throw new InvalidFileException("pluginManager apk file is invalid!");
        throw paramString1;
        l2 = System.currentTimeMillis();
        if (TextUtils.equals("GVideo", paramString1)) {}
        for (paramContext = a(paramString1, localCdnPmUpdater);; paramContext = new PluginManagerWrapper(paramString1, new DynamicPluginManager(localCdnPmUpdater)))
        {
          jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(0).report();
          return paramContext;
        }
      }
      try
      {
        paramString2 = MD5FileUtil.a(localCdnPmUpdater.getLatest());
        paramString1 = paramString2;
      }
      catch (IOException paramString2)
      {
        continue;
      }
      QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid，apk = " + paramContext + " md5 = " + paramString1);
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(paramContext).d2("FileInvalid").d3(paramString1).opResult(1000).report();
      localCdnPmUpdater.a();
      throw new InvalidFileException("pluginManager apk file is invalid!");
      bool = false;
      break;
      paramContext = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.Shadow
 * JD-Core Version:    0.7.0.1
 */