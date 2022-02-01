package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

public class QzoneModuleLoader
{
  public static final String TAG = "QzoneModuleLoader";
  
  public static boolean loadModuleDex(String paramString1, Context paramContext, ClassLoader paramClassLoader, String paramString2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("classloader is: ");
    localStringBuilder.append(paramClassLoader);
    localStringBuilder.append(" , classloader class is: ");
    localStringBuilder.append(paramClassLoader.getClass());
    QMLog.d("QzoneModuleLoader", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("load module: ");
    localStringBuilder.append(paramString1);
    QMLog.d("QzoneModuleLoader", localStringBuilder.toString());
    boolean bool2 = TextUtils.isEmpty(paramString1);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (!new File(paramString1).exists()) {
      return false;
    }
    long l = System.nanoTime();
    try
    {
      paramBoolean = QzoneModuleInjector.inject(paramContext, paramClassLoader, paramString1, paramString2, paramBoolean);
    }
    catch (Throwable paramContext)
    {
      QMLog.e("QzoneModuleLoader", "inject failed, catch an exception:", paramContext);
      paramBoolean = bool1;
    }
    l = (System.nanoTime() - l) / 1000000L;
    paramContext = new StringBuilder();
    paramContext.append("loaded module success ? ");
    paramContext.append(paramBoolean);
    paramContext.append(" --module:  ");
    paramContext.append(paramString1);
    paramContext.append(" , classloader: ");
    paramContext.append(paramClassLoader);
    paramContext.append(", cost:");
    paramContext.append(l);
    QMLog.d("QzoneModuleLoader", paramContext.toString());
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.QzoneModuleLoader
 * JD-Core Version:    0.7.0.1
 */