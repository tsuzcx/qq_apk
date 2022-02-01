package com.tencent.mobileqq.vas.gldrawable;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IConfigStub;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GLDrawableDownloadHelper
{
  private static boolean a = true;
  private static boolean b = QVipSDKProcessor.c().a(Build.VERSION.SDK_INT);
  
  static
  {
    ThreadManagerV2.executeOnSubThread(new GLDrawableDownloadHelper.1());
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("GLDrawableV860.zip");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("GLDrawableV860.zip");
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    try
    {
      a(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramInt != 0) {}
    try
    {
      paramContext = new StringBuilder();
      paramContext.append("error: ");
      paramContext.append(paramInt);
      QLog.e("GLDrawableDownloadHelper", 1, paramContext.toString());
      break label52;
      GLDrawableApi.config().log("GLDrawable Loaded", null);
      label52:
      return;
    }
    finally {}
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("requestDownloadDepends isDirect=");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("GLDrawableDownloadHelper", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramBoolean)
      {
        ((IVasQuickUpdateService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "GLDrawableV860", "gldrawable");
      }
      else
      {
        localObject1 = new GLDrawableDownloadHelper.2();
        QIPCClientHelper.getInstance().callServer("VasFontIPCModule", "action_download_gldrawable", null, (EIPCResultCallback)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static boolean a(Context paramContext)
  {
    return new File(a(paramContext)).exists();
  }
  
  public static boolean b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper
 * JD-Core Version:    0.7.0.1
 */