package com.tencent.upload.common;

import SLICE_UPLOAD.stEnvironment;
import android.content.Context;
import com.tencent.upload.report.Report;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadLog;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.V2Config;
import java.io.File;

public final class a
{
  private static Context a;
  private static IUploadConfig b;
  private static IUploadReport c;
  private static IUploadLog d;
  private static IUploadEnv e;
  private static V2Config f;
  private static boolean g = false;
  
  public static final Context a()
  {
    return a;
  }
  
  public static void a(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv)
  {
    if ((paramContext == null) || (paramIUploadConfig == null) || (paramIUploadEnv == null)) {
      throw new RuntimeException("upload组件init初始化参数错误！");
    }
    a = paramContext;
    b = paramIUploadConfig;
    c = paramIUploadReport;
    d = paramIUploadLog;
    e = paramIUploadEnv;
    f = new V2Config();
    paramContext = f;
    if (paramIUploadEnv.getUploadVersion() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramContext.mUseUploadV2 = bool;
      f.mParallelFileNumber = paramIUploadEnv.getFileConcurrentCount();
      f.mFileSocketNumber = Math.max(1, paramIUploadEnv.getSocketCount());
      f.mBatchControlNumber = paramIUploadEnv.getBatchControlCount();
      return;
    }
  }
  
  public static final void a(V2Config paramV2Config)
  {
    f = new V2Config();
    f.mUseUploadV2 = paramV2Config.mUseUploadV2;
    f.mParallelFileNumber = paramV2Config.mParallelFileNumber;
    f.mFileSocketNumber = paramV2Config.mFileSocketNumber;
    f.mBatchControlNumber = paramV2Config.mBatchControlNumber;
  }
  
  public static void a(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static final IUploadConfig b()
  {
    return b;
  }
  
  public static IUploadReport c()
  {
    if (c == null) {
      c = new IUploadReport()
      {
        public void batchComplete() {}
        
        public void onUploadReport(Report paramAnonymousReport) {}
        
        public void openSessionReport(int paramAnonymousInt1, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt2) {}
      };
    }
    return c;
  }
  
  public static final IUploadLog d()
  {
    return d;
  }
  
  public static final IUploadEnv e()
  {
    return e;
  }
  
  public static final V2Config f()
  {
    return f;
  }
  
  public static stEnvironment g()
  {
    stEnvironment localstEnvironment = new stEnvironment();
    localstEnvironment.qua = b.getQUA3();
    localstEnvironment.net = e.getCurrentNetworkCategory();
    localstEnvironment.operators = e.getProviderName();
    localstEnvironment.deviceInfo = b.getDeviceInfo();
    localstEnvironment.source = 1;
    return localstEnvironment;
  }
  
  public static boolean h()
  {
    if ((b() != null) && (!b().isReleaseMode()) && (new File("/sdcard/keep_image_tmp_file_206cce3cffb78a4a87f85bb0ad467288.txt").exists())) {
      return true;
    }
    return g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.common.a
 * JD-Core Version:    0.7.0.1
 */