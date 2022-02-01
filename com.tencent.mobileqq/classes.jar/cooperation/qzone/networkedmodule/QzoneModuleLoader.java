package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.hotpatch.PatchResolveForDalvik;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;

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
      if (Build.VERSION.SDK_INT < 21) {
        try
        {
          if (!sIsLibLoaded)
          {
            bool = Build.CPU_ABI.toLowerCase(Locale.US).contains("x86");
            if ((!bool) && (!SoLoadUtil.b()))
            {
              sIsLibLoaded = SoLoadUtilNew.loadSoByName(paramContext.getApplicationContext(), "qq_patch");
            }
            else
            {
              QLog.d("QzoneModuleLoader", 4, "is x86,so call loadNativeLibrary.");
              sIsLibLoaded = SoLoadUtil.a(paramContext.getApplicationContext(), "qq_patch", 0, false, false);
            }
          }
          if (sIsLibLoaded)
          {
            i = PatchResolveForDalvik.a(Arrays.asList(paramQzoneModuleRecord.mClassIds.split(";")), paramQzoneModuleRecord.mClassIdsCount);
            break label213;
          }
          paramContext = new StringBuilder();
          paramContext.append("resolvePatchClass failed: ");
          paramContext.append(paramString1);
          paramContext.append(" ,load so failed.");
          QLog.e("QzoneModuleLoader", 1, paramContext.toString());
          QzoneModuleReport.reportResolveClassRes(paramQzoneModuleRecord, "-1", (System.nanoTime() - l) / 1000000L);
        }
        catch (Throwable paramContext)
        {
          QLog.e("QzoneModuleLoader", 1, "catch an exception:", paramContext);
          i = -1;
          break label213;
        }
      }
      int i = 0;
      label213:
      if (i != 0)
      {
        paramContext = new StringBuilder();
        paramContext.append("resolvePatchClass failed: ");
        paramContext.append(paramString1);
        paramContext.append(" ,resolveRes: ");
        paramContext.append(i);
        paramContext.append(",classIdCount:");
        paramContext.append(paramQzoneModuleRecord.mClassIdsCount);
        QLog.e("QzoneModuleLoader", 1, paramContext.toString());
        paramString1 = QzoneModuleInjector.unloadDexElement(QzoneModuleConst.class.getClassLoader(), 0);
        l = (System.nanoTime() - l) / 1000000L;
        QzoneModuleReport.reportResolveClassRes(paramQzoneModuleRecord, "0", l);
        paramContext = new StringBuilder();
        paramContext.append("----------unloadDexElement ");
        paramContext.append(paramString1);
        paramContext.append(" , cost:");
        paramContext.append(l);
        QLog.i("QzoneModuleLoader", 1, paramContext.toString());
        return false;
      }
      l = (System.nanoTime() - l) / 1000000L;
      paramString1 = new StringBuilder();
      paramString1.append("----------resolve class successful, cost:");
      paramString1.append(l);
      QLog.i("QzoneModuleLoader", 1, paramString1.toString());
      QzoneModuleReport.reportResolveClassRes(paramQzoneModuleRecord, "1", l);
      return true;
    }
    paramContext = new StringBuilder();
    paramContext.append("loadModule failed: ");
    paramContext.append(paramString1);
    QLog.e("QzoneModuleLoader", 1, paramContext.toString());
    QzoneModuleReport.reportResolveClassRes(paramQzoneModuleRecord, "0", (System.nanoTime() - l) / 1000000L);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleLoader
 * JD-Core Version:    0.7.0.1
 */