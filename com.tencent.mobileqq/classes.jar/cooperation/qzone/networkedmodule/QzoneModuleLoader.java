package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QzoneModuleLoader
{
  public static final String TAG = "QzoneModuleLoader";
  private static boolean sIsLibLoaded = false;
  
  public static boolean loadModuleDex(String paramString1, Context paramContext, ClassLoader paramClassLoader, String paramString2, QzoneModuleRecord paramQzoneModuleRecord)
  {
    return loadModuleDex(paramString1, paramContext, paramClassLoader, paramString2, paramQzoneModuleRecord, false);
  }
  
  public static boolean loadModuleDex(String paramString1, Context paramContext, ClassLoader paramClassLoader, String paramString2, QzoneModuleRecord paramQzoneModuleRecord, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("classloader is: ");
      localStringBuilder.append(paramClassLoader);
      localStringBuilder.append(" , classloader class is: ");
      localStringBuilder.append(paramClassLoader.getClass());
      QLog.d("QzoneModuleLoader", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load module: ");
    localStringBuilder.append(paramString1);
    QLog.d("QzoneModuleLoader", 4, localStringBuilder.toString());
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
      QLog.e("QzoneModuleLoader", 1, "inject failed, catch an exception:", paramContext);
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
    QLog.d("QzoneModuleLoader", 1, paramContext.toString());
    if (paramQzoneModuleRecord != null) {
      QzoneModuleReport.reportLoadRes(paramQzoneModuleRecord, paramBoolean, l);
    }
    return paramBoolean;
  }
  
  public static boolean loadModuleDex2MainClassLoader(String paramString1, Context paramContext, String paramString2, QzoneModuleRecord paramQzoneModuleRecord)
  {
    long l = System.nanoTime();
    boolean bool = loadModuleDex(paramString1, paramContext, QzoneModuleConst.class.getClassLoader(), paramString2, paramQzoneModuleRecord, true);
    if (bool)
    {
      l = (System.nanoTime() - l) / 1000000L;
      paramString1 = new StringBuilder();
      paramString1.append("----------resolve class successful, cost:");
      paramString1.append(l);
      QLog.i("QzoneModuleLoader", 1, paramString1.toString());
      QzoneModuleReport.reportResolveClassRes(paramQzoneModuleRecord, "1", l);
      return bool;
    }
    paramContext = new StringBuilder();
    paramContext.append("loadModule failed: ");
    paramContext.append(paramString1);
    QLog.e("QzoneModuleLoader", 1, paramContext.toString());
    QzoneModuleReport.reportResolveClassRes(paramQzoneModuleRecord, "0", (System.nanoTime() - l) / 1000000L);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleLoader
 * JD-Core Version:    0.7.0.1
 */