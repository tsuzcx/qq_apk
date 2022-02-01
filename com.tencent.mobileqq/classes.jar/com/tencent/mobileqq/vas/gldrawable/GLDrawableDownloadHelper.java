package com.tencent.mobileqq.vas.gldrawable;

import android.content.Context;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.io.File;
import mqq.app.AppRuntime;

public class GLDrawableDownloadHelper
{
  public static File a(Context paramContext)
  {
    return GLDrawableProxy.a(paramContext);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    if (paramContext.endsWith(File.separator)) {
      return paramContext + "GLDrawableV8417.zip";
    }
    return paramContext + File.separator + "GLDrawableV8417.zip";
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
    for (;;)
    {
      try
      {
        QLog.e("GLDrawableDownloadHelper", 1, "error: " + paramInt);
        return;
      }
      finally {}
      paramContext = GLDrawableWraper.a();
      if ((paramContext instanceof GLDrawableLoaderImpl)) {
        ((GLDrawableLoaderImpl)paramContext).b();
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject1 instanceof QQAppInterface)) {
          ((IVasQuickUpdateService)((AppRuntime)localObject1).getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(1004L, "GLDrawableV8417", "gldrawable");
        }
        return;
      }
      finally {}
      Object localObject1 = new GLDrawableDownloadHelper.1();
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.k, null, (EIPCResultCallback)localObject1);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return new File(a(paramContext)).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper
 * JD-Core Version:    0.7.0.1
 */