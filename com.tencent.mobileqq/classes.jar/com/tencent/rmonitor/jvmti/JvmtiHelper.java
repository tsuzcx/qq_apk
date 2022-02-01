package com.tencent.rmonitor.jvmti;

import android.app.Application;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.StackUtil;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public class JvmtiHelper
{
  private static final String TAG = "RMonitor_jvmti_JvmtiHelper";
  private static boolean isAgent = false;
  private static final ConcurrentHashMap<String, String> threadStack = new ConcurrentHashMap();
  
  public static boolean canUseJvmTi()
  {
    return isAgent;
  }
  
  private static boolean checkVersionO()
  {
    return (Build.VERSION.SDK_INT == 26) || (Build.VERSION.SDK_INT == 27);
  }
  
  public static void enterThread(String paramString)
  {
    if (threadStack.containsKey(paramString)) {
      Logger.b.w(new String[] { "RMonitor_jvmti_JvmtiHelper", "Has double thread name ", paramString });
    }
    threadStack.put(paramString, StackUtil.getThrowableStack());
  }
  
  public static void exitThread(String paramString)
  {
    threadStack.remove(paramString);
  }
  
  public static long[] getGcInfo()
  {
    return JvmtiNative.getGcInfo();
  }
  
  public static void init()
  {
    try
    {
      if ((AndroidVersion.e()) && (!AndroidVersion.f()) && (BaseInfo.app != null) && (!isAgent))
      {
        ClassLoader localClassLoader = BaseInfo.app.getClassLoader();
        String str = (String)ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class }).invoke(localClassLoader, new Object[] { "rmonitorjvmti" });
        File localFile = BaseInfo.app.getFilesDir();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("qapm_agent_");
        localStringBuilder.append(BaseInfo.userMeta.sdkVersion);
        localStringBuilder.append(".so");
        localFile = new File(localFile, localStringBuilder.toString());
        if (!localFile.exists()) {
          FileUtil.a(new File(str), localFile);
        }
        FileUtil.e("rmonitorjvmti");
        if ((JvmtiNative.loadSym(checkVersionO())) && (JvmtiNative.nativeDoHook(AndroidVersion.f())))
        {
          JvmtiNative.openJdwp();
          JvmtiNative.proxyAttachJvmtiAgent(checkVersionO(), localFile.getAbsolutePath(), null, localClassLoader);
          isAgent = true;
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_jvmti_JvmtiHelper", localThrowable);
      return;
    }
    catch (Exception localException)
    {
      Logger.b.a("RMonitor_jvmti_JvmtiHelper", localException);
    }
  }
  
  public static void triggerThreadTidy()
  {
    new Handler(ThreadManager.f()).post(new JvmtiHelper.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.jvmti.JvmtiHelper
 * JD-Core Version:    0.7.0.1
 */