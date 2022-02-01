package cooperation.qzone;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.util.Singleton;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl;
import common.config.service.QzoneConfig;
import cooperation.plugin.IPluginManager;
import cooperation.qzone.cache.QZoneFilePath;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class QZoneStartupMonitor
{
  private static final String DEX_SUFFIX = ".dex";
  private static final String KEY_RECOVERY_COUNT_COUNT = "key_recovery_count";
  private static final String MONITOR_FILE_DIR = "qzone_monitor_dir";
  private static final String MONITOR_FILE_NAME = "qzone_startup_monitor";
  private static final int MSG_STARTUP_FAIL = 1;
  private static final String TAG = "QZoneStartupMonitor";
  private static Singleton<QZoneStartupMonitor, Void> singleton = new QZoneStartupMonitor.1();
  private final byte OAT_BIT = 2;
  private final byte STARTUP_BIT = 1;
  private Handler handler = new QZoneStartupMonitor.2(this, ThreadManager.getSubThreadLooper());
  private volatile boolean hasReported = false;
  private FileObserver observer;
  private volatile boolean startupSucess = false;
  
  public static void afterLoadPlugin()
  {
    if (BaseApplicationImpl.sProcessId == 2)
    {
      QLog.i("QZoneStartupMonitor", 1, "afterLoadPlugin");
      File localFile = new File(BaseApplicationImpl.getApplication().getDir("qzone_monitor_dir", 0), "qzone_startup_monitor");
      if (localFile.exists())
      {
        if (deleteFile(localFile))
        {
          QLog.i("QZoneStartupMonitor", 1, "monitor 文件删除成功");
          return;
        }
        QLog.w("QZoneStartupMonitor", 1, "qzone_startup_monitor删除失败");
      }
    }
  }
  
  private void backupQZoneDex()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("backupQZoneDex:ExternalStorageState():");
      ((StringBuilder)localObject1).append(Environment.getExternalStorageState().equals("mounted"));
      ((StringBuilder)localObject1).append(",canWrite:");
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().canWrite());
      QLog.d("QZoneStartupMonitor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new File(QZoneFilePath.BACKUP_DIR);
    boolean bool1;
    if (!((File)localObject1).exists())
    {
      boolean bool2 = ((File)localObject1).mkdirs();
      bool1 = bool2;
      if (!bool2) {
        bool1 = ((File)localObject1).mkdirs();
      }
    }
    else if (!((File)localObject1).isDirectory())
    {
      bool1 = deleteFile((File)localObject1);
    }
    else
    {
      bool1 = true;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("创建或者删除目标是否成功：");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("QZoneStartupMonitor", 2, ((StringBuilder)localObject2).toString());
    }
    if (bool1)
    {
      localObject2 = PluginUtils.getOptimizedDexPath(BaseApplicationImpl.getContext());
      localObject2 = optimizedFileFor(PluginUtils.getInstalledPluginPath(BaseApplicationImpl.getContext(), "qzone_plugin.apk"), (File)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qzone_plugin_");
      localStringBuilder.append(QUA.getQUA3());
      localObject1 = new File((File)localObject1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("copy from ");
      localStringBuilder.append(((File)localObject2).getPath());
      localStringBuilder.append(" to ");
      localStringBuilder.append(((File)localObject1).getPath());
      QLog.i("QZoneStartupMonitor", 1, localStringBuilder.toString());
      FileUtils.copyFile((File)localObject2, (File)localObject1);
    }
  }
  
  public static void beforeLoadPlugin()
  {
    if (BaseApplicationImpl.sProcessId == 2)
    {
      QLog.i("QZoneStartupMonitor", 1, "beforeLoadPlugin");
      File localFile = new File(BaseApplicationImpl.getApplication().getDir("qzone_monitor_dir", 0), "qzone_startup_monitor");
      if (!localFile.exists()) {
        try
        {
          localFile.createNewFile();
          return;
        }
        catch (IOException localIOException)
        {
          QLog.w("QZoneStartupMonitor", 1, "", localIOException);
        }
      }
    }
  }
  
  @NonNull
  private static Pair<Integer, Throwable> checkElfFile(Context paramContext, String paramString)
  {
    if (isArt())
    {
      Object localObject = PluginUtils.getOptimizedDexPath(paramContext);
      paramContext = optimizedFileFor(PluginUtils.getInstalledPluginPath(paramContext, paramString), (File)localObject);
      if (paramContext.exists()) {
        return ShareElfFile.checkOat(paramContext);
      }
      QLog.w("QZoneStartupMonitor", 1, "qzone_plugin.dex不存在");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pluginid: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",path:");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append(" not found");
      return new Pair(Integer.valueOf(-9), new IOException(((StringBuilder)localObject).toString()));
    }
    QLog.i("QZoneStartupMonitor", 1, "非ART机器");
    return new Pair(Integer.valueOf(0), null);
  }
  
  public static boolean deleteFile(File paramFile)
  {
    boolean bool = paramFile.exists();
    int i = 0;
    if (bool)
    {
      int j;
      do
      {
        bool = paramFile.delete();
        j = i + 1;
        if (bool) {
          break;
        }
        i = j;
      } while (j < 2);
      return bool;
    }
    return false;
  }
  
  public static QZoneStartupMonitor getInstance()
  {
    return (QZoneStartupMonitor)singleton.get(null);
  }
  
  private static boolean isArt()
  {
    String str = System.getProperty("java.vm.version");
    int i;
    if ((str != null) && (str.startsWith("2"))) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (Build.VERSION.SDK_INT >= 21);
  }
  
  private static File optimizedFileFor(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getName();
    paramFile1 = str;
    if (!str.endsWith(".dex"))
    {
      int i = str.lastIndexOf(".");
      if (i < 0)
      {
        paramFile1 = new StringBuilder();
        paramFile1.append(str);
        paramFile1.append(".dex");
        paramFile1 = paramFile1.toString();
      }
      else
      {
        paramFile1 = new StringBuilder(i + 4);
        paramFile1.append(str, 0, i);
        paramFile1.append(".dex");
        paramFile1 = paramFile1.toString();
      }
    }
    return new File(paramFile2, paramFile1);
  }
  
  private void reInstallQzone()
  {
    if (!QzonePluginProxyActivityProxyImpl.isQzoneExist())
    {
      Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
      {
        localObject1 = (QQAppInterface)localObject1;
        Object localObject2 = (IPluginManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_PLUGIN);
        QLog.i("QZoneStartupMonitor", 1, "reInstallQzone cancelInstall:qzone_plugin.apk");
        ((IPluginManager)localObject2).cancelInstall("qzone_plugin.apk");
        if (!((IPluginManager)localObject2).isPlugininstalled("qzone_plugin.apk"))
        {
          localObject2 = PluginUtils.getOptimizedDexPath(BaseApplicationImpl.getContext());
          localObject2 = optimizedFileFor(PluginUtils.getInstalledPluginPath(BaseApplicationImpl.getContext(), "qzone_plugin.apk"), (File)localObject2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reInstallQzone delete odex:");
          localStringBuilder.append(((File)localObject2).getPath());
          QLog.i("QZoneStartupMonitor", 1, localStringBuilder.toString());
          deleteFile((File)localObject2);
          QZoneHelper.preloadQzone((AppRuntime)localObject1, "reInstallQzone");
        }
      }
      else
      {
        QLog.i("QZoneStartupMonitor", 1, "非手q 进程，不进行卸载");
      }
    }
    else
    {
      QLog.i("QZoneStartupMonitor", 1, "qzone 进程存在，什么都不要做");
    }
  }
  
  private void report(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void monitor()
  {
    for (;;)
    {
      try
      {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "startup_monitor_enable", 1) == 1)
        {
          i = 1;
          if (i == 0)
          {
            QLog.i("QZoneStartupMonitor", 1, "WNS 开关配置关闭monitor");
            return;
          }
          if (this.observer == null)
          {
            File localFile = BaseApplicationImpl.getApplication().getDir("qzone_monitor_dir", 0);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("monitor dir:");
              localStringBuilder.append(localFile.getPath());
              QLog.d("QZoneStartupMonitor", 2, localStringBuilder.toString());
            }
            this.observer = new QZoneStartupMonitor.3(this, localFile.getPath(), 768);
            this.observer.startWatching();
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor
 * JD-Core Version:    0.7.0.1
 */