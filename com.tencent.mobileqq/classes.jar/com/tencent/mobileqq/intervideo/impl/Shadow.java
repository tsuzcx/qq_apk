package com.tencent.mobileqq.intervideo.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.CdnPmUpdater;
import com.tencent.mobileqq.intervideo.DataLocalTmpPmUpdater;
import com.tencent.mobileqq.intervideo.IVLoggerFactory;
import com.tencent.mobileqq.intervideo.IVPluginManager;
import com.tencent.mobileqq.intervideo.InvalidFileException;
import com.tencent.mobileqq.intervideo.PluginManagerWrapper;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.shadow.core.common.LoggerFactory;
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
    catch (ExecutionException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
    catch (InterruptedException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
    catch (TimeoutException paramContext)
    {
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("updateException").d1(paramContext.toString()).report();
      throw paramContext;
    }
  }
  
  private static PluginManagerWrapper a(String paramString, CdnPmUpdater paramCdnPmUpdater)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("pluginManagerWrapper ，sPluginManagerWrapper = ");
    ((StringBuilder)???).append(jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper);
    ((StringBuilder)???).append(" bizType:");
    ((StringBuilder)???).append(paramString);
    QLog.i("shadow::Shadow", 2, ((StringBuilder)???).toString());
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper == null)
      {
        jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper = new PluginManagerWrapper(paramString, paramCdnPmUpdater);
        paramString = new StringBuilder();
        paramString.append("new pluginManagerWrapper : ");
        paramString.append(jdField_a_of_type_ComTencentMobileqqIntervideoPluginManagerWrapper);
        QLog.i("shadow::Shadow", 2, paramString.toString());
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
    long l1 = System.currentTimeMillis();
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("shadow").opName(paramString1).opType("CdnGetBizPm").toUin(paramString2);
    Object localObject1 = new DataLocalTmpPmUpdater(paramString1);
    if (((DataLocalTmpPmUpdater)localObject1).getLatest() != null) {
      return new PluginManagerWrapper(paramString1, (PluginManagerUpdater)localObject1);
    }
    CdnPmUpdater localCdnPmUpdater = new CdnPmUpdater(paramContext.getApplicationContext(), paramString1, paramString2, "9_1");
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("wasUpdating:");
      paramString2.append(localCdnPmUpdater.wasUpdating());
      paramString2.append(" getLatest:");
      paramString2.append(localCdnPmUpdater.getLatest());
      QLog.i("shadow::Shadow", 2, paramString2.toString());
    }
    boolean bool;
    if ((!localCdnPmUpdater.wasUpdating()) && (localCdnPmUpdater.getLatest() != null)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("needWaitingUpdate:");
      paramString2.append(bool);
      QLog.i("shadow::Shadow", 2, paramString2.toString());
    }
    if (TextUtils.equals("GVideo", paramString1)) {
      localCdnPmUpdater.a(new Shadow.2(paramString1));
    }
    paramString2 = localCdnPmUpdater.update();
    if (bool) {
      try
      {
        paramString2.get();
      }
      catch (InterruptedException paramContext)
      {
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(2).report();
        throw paramContext;
      }
      catch (ExecutionException paramContext)
      {
        l2 = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(1).report();
        throw paramContext;
      }
    }
    localObject1 = paramContext.getPackageManager();
    paramString2 = localCdnPmUpdater.getLatest();
    paramContext = "";
    String str;
    if (paramString2 != null) {
      str = localCdnPmUpdater.getLatest().getAbsolutePath();
    } else {
      str = "";
    }
    long l2 = System.currentTimeMillis();
    paramString2 = null;
    Object localObject2 = null;
    try
    {
      try
      {
        localObject1 = ((PackageManager)localObject1).getPackageArchiveInfo(str, 128);
        localObject2 = localObject1;
        paramString2 = (String)localObject1;
        localStringBuilder = new StringBuilder();
        localObject2 = localObject1;
        paramString2 = (String)localObject1;
        localStringBuilder.append("getPackageArchiveInfo，timespan = ");
        localObject2 = localObject1;
        paramString2 = (String)localObject1;
        l3 = System.currentTimeMillis();
        localObject2 = localObject1;
      }
      finally
      {
        StringBuilder localStringBuilder;
        long l3;
        label461:
        if (localObject2 != null) {}
      }
    }
    catch (Exception localException)
    {
      break label666;
    }
    try
    {
      localStringBuilder.append(l3 - l2);
      localObject2 = localObject1;
      QLog.i("shadow::Shadow", 2, localStringBuilder.toString());
      if (localObject1 == null) {}
    }
    catch (Exception paramString2)
    {
      break label551;
    }
    try
    {
      paramString1 = MD5FileUtil.a(localCdnPmUpdater.getLatest());
      paramContext = paramString1;
    }
    catch (IOException paramString1)
    {
      break label461;
    }
    paramString1 = new StringBuilder();
    paramString1.append("pluginManager apk file is invalid，apk = ");
    paramString1.append(str);
    paramString1.append(" md5 = ");
    paramString1.append(paramContext);
    QLog.i("shadow::Shadow", 1, paramString1.toString());
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(str).d2("FileInvalid").d3(paramContext).opResult(1000).report();
    localCdnPmUpdater.a();
    throw new InvalidFileException("pluginManager apk file is invalid!");
    label551:
    paramString2 = (String)localObject1;
    try
    {
      paramString1 = MD5FileUtil.a(localCdnPmUpdater.getLatest());
      paramContext = paramString1;
    }
    catch (IOException paramString1)
    {
      label574:
      break label574;
    }
    paramString1 = new StringBuilder();
    paramString1.append("pluginManager apk file is invalid，apk = ");
    paramString1.append(str);
    paramString1.append(" md5 = ");
    paramString1.append(paramContext);
    QLog.i("shadow::Shadow", 1, paramString1.toString());
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(str).d2("FileInvalid").d3(paramContext).opResult(1000).report();
    localCdnPmUpdater.a();
    throw new InvalidFileException("pluginManager apk file is invalid!");
    throw paramString1;
    label666:
    if (paramString2 != null)
    {
      l2 = System.currentTimeMillis();
      if (TextUtils.equals("GVideo", paramString1)) {
        paramContext = a(paramString1, localCdnPmUpdater);
      } else {
        paramContext = new PluginManagerWrapper(paramString1, localCdnPmUpdater);
      }
      jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(Boolean.toString(bool)).d2(Long.toString(l2 - l1)).opResult(0).report();
      return paramContext;
    }
    try
    {
      paramString1 = MD5FileUtil.a(localCdnPmUpdater.getLatest());
      paramContext = paramString1;
    }
    catch (IOException paramString1)
    {
      label746:
      break label746;
    }
    paramString1 = new StringBuilder();
    paramString1.append("pluginManager apk file is invalid，apk = ");
    paramString1.append(str);
    paramString1.append(" md5 = ");
    paramString1.append(paramContext);
    QLog.i("shadow::Shadow", 1, paramString1.toString());
    jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.d1(str).d2("FileInvalid").d3(paramContext).opResult(1000).report();
    localCdnPmUpdater.a();
    throw new InvalidFileException("pluginManager apk file is invalid!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.impl.Shadow
 * JD-Core Version:    0.7.0.1
 */