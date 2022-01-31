package com.tencent.upload.common;

import SLICE_UPLOAD.stEnvironment;
import android.content.Context;
import com.tencent.upload.network.base.UploadSoDefaultLoader;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadSoLoader;
import java.io.File;

public final class UploadGlobalConfig
{
  private static final String KEEPIMG_TEST_FILE = "/sdcard/keep_image_tmp_file_206cce3cffb78a4a87f85bb0ad467288.txt";
  private static final String TAG = "UploadGlobalConfig";
  private static IUploadConfig sConfig;
  private static Context sContext;
  private static boolean sKeepImageTmpFile = false;
  private static IUploadEnv sUploadEnv;
  private static IUploadLog sUploadLog;
  private static IUploadReport sUploadReport;
  private static IUploadSoLoader sUploadSoLoader;
  
  public static final IUploadConfig getConfig()
  {
    return sConfig;
  }
  
  public static final Context getContext()
  {
    return sContext;
  }
  
  public static stEnvironment getEnv()
  {
    stEnvironment localstEnvironment = new stEnvironment();
    localstEnvironment.qua = sConfig.getQUA3();
    localstEnvironment.net = sUploadEnv.getCurrentNetworkCategory();
    localstEnvironment.operators = sUploadEnv.getProviderName();
    localstEnvironment.deviceInfo = sConfig.getDeviceInfo();
    localstEnvironment.source = 1;
    return localstEnvironment;
  }
  
  public static final IUploadEnv getUploadEnv()
  {
    return sUploadEnv;
  }
  
  public static final IUploadLog getUploadLog()
  {
    return sUploadLog;
  }
  
  public static IUploadReport getUploadReport()
  {
    if (sUploadReport == null) {
      sUploadReport = new UploadGlobalConfig.1();
    }
    return sUploadReport;
  }
  
  public static final IUploadSoLoader getUploadSoLoader()
  {
    if (sUploadSoLoader == null) {
      sUploadSoLoader = new UploadSoDefaultLoader();
    }
    return sUploadSoLoader;
  }
  
  public static void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv, IUploadSoLoader paramIUploadSoLoader)
  {
    if ((paramContext == null) || (paramIUploadConfig == null) || (paramIUploadEnv == null) || (paramIUploadSoLoader == null)) {
      throw new RuntimeException("upload组件init初始化参数错误！");
    }
    sContext = paramContext;
    sConfig = paramIUploadConfig;
    sUploadReport = paramIUploadReport;
    sUploadLog = paramIUploadLog;
    sUploadEnv = paramIUploadEnv;
    sUploadSoLoader = paramIUploadSoLoader;
  }
  
  public static void keepImageTmpFile(boolean paramBoolean)
  {
    sKeepImageTmpFile = paramBoolean;
  }
  
  public static boolean needKeepImageTmpFile()
  {
    if ((getConfig() != null) && (!getConfig().isReleaseMode()) && (new File("/sdcard/keep_image_tmp_file_206cce3cffb78a4a87f85bb0ad467288.txt").exists())) {
      return true;
    }
    return sKeepImageTmpFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.common.UploadGlobalConfig
 * JD-Core Version:    0.7.0.1
 */