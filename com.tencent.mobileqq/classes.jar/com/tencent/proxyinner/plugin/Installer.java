package com.tencent.proxyinner.plugin;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sixgod.pluginsdk.SixGodHelper;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.report.DataReport;
import com.tencent.proxyinner.utility.ThreadManager;
import com.tencent.proxyinner.utility.UtilFile;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Installer
{
  public static final int RES_INSTALL_DEX2OAT_FAIL = 5001;
  public static final int RES_INSTALL_HAS_INSTALLED = 5000;
  public static final int RES_INSTALL_MOVESO_FAIL = 5002;
  public static final int RES_INSTALL_SUCC = 0;
  static final String TAG = "XProxy | Installer";
  public static final int TYPE_INSTALL_NOMAL = 1;
  public static final int TYPE_INSTALL_PREINSTALL = 2;
  public static final int TYPE_INSTALL_SILENT_UPDATE = 3;
  String mApkPath;
  Context mContext;
  String mDexPath;
  InstallEvent mEvent;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1000) {
        if (Installer.this.mEvent != null)
        {
          i = paramAnonymousMessage.arg1;
          str = paramAnonymousMessage.getData().getString("errmsg");
          bool = paramAnonymousMessage.getData().getBoolean("hasdex2oat", false);
          if (i == 0)
          {
            j = Installer.this.mLocalPlugin.getMaxSdkVersion();
            Installer.this.mLocalPlugin.setPreinstalledPlugin(j, Installer.this.mApkPath, bool);
          }
          Installer.this.mEvent.onInstallResult(i, str);
        }
      }
      while (paramAnonymousMessage.what != 1001) {
        return;
      }
      int i = Installer.this.mLocalPlugin.getMaxSdkVersion();
      long l = paramAnonymousMessage.getData().getLong("timeconsume", 0L);
      int j = paramAnonymousMessage.arg1;
      paramAnonymousMessage = Installer.this.mLocalPlugin;
      String str = Installer.this.mApkPath;
      if (j == 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramAnonymousMessage.setPreinstalledPlugin(i, str, bool);
        DataReport.getInstance(Installer.this.mPluginId).reportDex2Oat(Installer.this.mLocalPlugin.getMaxSdkVersion(), 0, l);
        return;
      }
    }
  };
  String mLibPath;
  LocalPlugin mLocalPlugin;
  boolean mMoveSoFileInHost;
  String mOptPath;
  String mPackageName;
  String mPluginId;
  
  public Installer(Context paramContext, LocalPlugin paramLocalPlugin, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.mContext = paramContext;
    this.mOptPath = paramString2;
    this.mApkPath = paramString1;
    this.mLibPath = paramString4;
    this.mPackageName = paramString5;
    this.mLocalPlugin = paramLocalPlugin;
    this.mDexPath = paramString3;
    this.mPluginId = paramString6;
  }
  
  private void dex2oat()
  {
    String str = this.mApkPath + File.pathSeparator + UtilFile.getPluginSecondaryDexesPath(this.mContext, this.mPackageName, this.mLocalPlugin.getMaxSdkVersion());
    File localFile = new File(this.mOptPath);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    XLog.i("XProxy | Installer", "开始生成优化文件 multiApkPath = " + str + "time = " + System.currentTimeMillis());
    new DexClassLoader(str, this.mOptPath, null, this.mContext.getClassLoader().getParent());
    XLog.i("XProxy | Installer", "生成优化文件完成 time = " + System.currentTimeMillis());
  }
  
  private boolean isNeedReDex()
  {
    XLog.e("XProxy | Installer", "兼容插件升级的Bug");
    Object localObject1 = new File(UtilFile.getPluginSecondaryDexesRoot(this.mContext, "com.tencent.now"));
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return false;
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2.isFile()) && (valideDexfile(localObject2.getName())))
          {
            XLog.e("XProxy | Installer", "之前已经生成过class2.dex文件，需要重新安装");
            localObject2.delete();
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private void moveMultiDexFile()
  {
    XLog.i("XProxy | Installer", "开始拷贝dex文件，apk = " + this.mApkPath);
    long l1 = System.currentTimeMillis();
    SixGodHelper.moveDexFiles(this.mContext, this.mApkPath, this.mPackageName, String.valueOf(this.mLocalPlugin.getMaxSdkVersion()));
    long l2 = System.currentTimeMillis();
    XLog.i("XProxy | Installer", "拷贝dex文件完成，apk = " + this.mApkPath + " dTime = " + (l2 - l1));
  }
  
  private String moveSoFile(String paramString1, String paramString2)
  {
    boolean bool = true;
    do
    {
      try
      {
        if (!this.mMoveSoFileInHost)
        {
          XLog.i("XProxy | Installer", "使用默认方式解压so");
          bool = SixGodHelper.moveSoFile(this.mContext, paramString1, this.mPackageName, String.valueOf(this.mLocalPlugin.getMaxSdkVersion()));
        }
        else
        {
          XLog.i("XProxy | Installer", "开始回调上层进行so解压");
          if (!this.mEvent.onUnZipSoFile(paramString1, paramString2))
          {
            XLog.i("XProxy | Installer", "上层解压so失败,使用默认解压方式");
            bool = SixGodHelper.moveSoFile(this.mContext, paramString1, this.mPackageName, String.valueOf(this.mLocalPlugin.getMaxSdkVersion()));
          }
        }
      }
      catch (Exception paramString1)
      {
        XLog.e("XProxy | Installer", "解压so出现异常，e = " + paramString1.getMessage());
        paramString1.printStackTrace();
        return paramString1.getMessage();
      }
      return "sixgod move so fail!";
    } while (!bool);
    return "";
  }
  
  private void notifyDex2Oat(int paramInt, String paramString, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1001;
    localMessage.arg1 = paramInt;
    Bundle localBundle = new Bundle();
    localBundle.putString("errmsg", paramString);
    localBundle.putLong("timeconsume", paramLong);
    localMessage.setData(localBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  private void notifyInstallResult(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = paramInt1;
    localMessage.what = 1000;
    Bundle localBundle = new Bundle();
    localBundle.putString("errmsg", paramString);
    localBundle.putInt("type", paramInt2);
    localBundle.putBoolean("hasdex2oat", paramBoolean);
    localMessage.setData(localBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void dex2OatInSubThread()
  {
    int i = this.mLocalPlugin.getMaxSdkVersion();
    if (this.mLocalPlugin.getHasDex2Oat(i))
    {
      XLog.i("XProxy | Installer", "已经生成过oat文件，不处理 ，version = " + i);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new Runnable()
    {
      public void run()
      {
        long l = System.currentTimeMillis();
        try
        {
          Installer.this.dex2oat();
          Installer.this.notifyDex2Oat(0, "", System.currentTimeMillis() - l);
          return;
        }
        catch (Exception localException)
        {
          XLog.i("XProxy | Installer", "生成oat文件异常　ｅ=" + localException.getMessage());
          return;
        }
        finally
        {
          Installer.this.notifyDex2Oat(1, "", System.currentTimeMillis() - l);
        }
      }
    });
  }
  
  /* Error */
  public void installPlugin(final int paramInt, InstallEvent paramInstallEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   5: lstore 4
    //   7: aload_0
    //   8: aload_2
    //   9: putfield 244	com/tencent/proxyinner/plugin/Installer:mEvent	Lcom/tencent/proxyinner/plugin/Installer$InstallEvent;
    //   12: aload_0
    //   13: getfield 76	com/tencent/proxyinner/plugin/Installer:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   16: invokevirtual 126	com/tencent/proxyinner/plugin/LocalPlugin:getMaxSdkVersion	()I
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 76	com/tencent/proxyinner/plugin/Installer:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   24: iload_3
    //   25: invokevirtual 338	com/tencent/proxyinner/plugin/LocalPlugin:getPreInstalledPlugin	(I)Ljava/lang/String;
    //   28: invokestatic 344	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   31: ifne +85 -> 116
    //   34: new 117	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: getfield 72	com/tencent/proxyinner/plugin/Installer:mLibPath	Ljava/lang/String;
    //   42: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 143	java/io/File:exists	()Z
    //   50: ifne +8 -> 58
    //   53: aload_2
    //   54: invokevirtual 347	java/io/File:mkdir	()Z
    //   57: pop
    //   58: aload_0
    //   59: invokespecial 349	com/tencent/proxyinner/plugin/Installer:isNeedReDex	()Z
    //   62: ifne +54 -> 116
    //   65: ldc 26
    //   67: new 110	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   74: aload_0
    //   75: getfield 70	com/tencent/proxyinner/plugin/Installer:mApkPath	Ljava/lang/String;
    //   78: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc_w 351
    //   84: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 165	com/tencent/proxyinner/log/XLog:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: aload_0
    //   95: sipush 5000
    //   98: iload_1
    //   99: ldc_w 262
    //   102: aload_0
    //   103: getfield 76	com/tencent/proxyinner/plugin/Installer:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   106: iload_3
    //   107: invokevirtual 316	com/tencent/proxyinner/plugin/LocalPlugin:getHasDex2Oat	(I)Z
    //   110: invokespecial 96	com/tencent/proxyinner/plugin/Installer:notifyInstallResult	(IILjava/lang/String;Z)V
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: aload_0
    //   117: getfield 80	com/tencent/proxyinner/plugin/Installer:mPluginId	Ljava/lang/String;
    //   120: invokestatic 357	com/tencent/proxyinner/report/DataReport:getInstance	(Ljava/lang/String;)Lcom/tencent/proxyinner/report/DataReport;
    //   123: aload_0
    //   124: getfield 76	com/tencent/proxyinner/plugin/Installer:mLocalPlugin	Lcom/tencent/proxyinner/plugin/LocalPlugin;
    //   127: invokevirtual 126	com/tencent/proxyinner/plugin/LocalPlugin:getMaxSdkVersion	()I
    //   130: iload_1
    //   131: aload_0
    //   132: getfield 70	com/tencent/proxyinner/plugin/Installer:mApkPath	Ljava/lang/String;
    //   135: aload_0
    //   136: getfield 72	com/tencent/proxyinner/plugin/Installer:mLibPath	Ljava/lang/String;
    //   139: invokevirtual 361	com/tencent/proxyinner/report/DataReport:reportInstallStart	(IILjava/lang/String;Ljava/lang/String;)V
    //   142: invokestatic 327	com/tencent/proxyinner/utility/ThreadManager:getFileThreadHandler	()Landroid/os/Handler;
    //   145: new 8	com/tencent/proxyinner/plugin/Installer$2
    //   148: dup
    //   149: aload_0
    //   150: iload_1
    //   151: lload 4
    //   153: invokespecial 364	com/tencent/proxyinner/plugin/Installer$2:<init>	(Lcom/tencent/proxyinner/plugin/Installer;IJ)V
    //   156: invokevirtual 333	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   159: pop
    //   160: goto -47 -> 113
    //   163: astore_2
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_2
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	Installer
    //   0	168	1	paramInt	int
    //   0	168	2	paramInstallEvent	InstallEvent
    //   19	88	3	i	int
    //   5	147	4	l	long
    // Exception table:
    //   from	to	target	type
    //   2	58	163	finally
    //   58	113	163	finally
    //   116	160	163	finally
  }
  
  public boolean isPluginInstalled()
  {
    int i = this.mLocalPlugin.getMaxSdkVersion();
    return (!TextUtils.isEmpty(this.mLocalPlugin.getPreInstalledPlugin(i))) && (!isNeedReDex());
  }
  
  public void setMoveSoFileInHost(boolean paramBoolean)
  {
    this.mMoveSoFileInHost = paramBoolean;
  }
  
  public boolean valideDexfile(String paramString)
  {
    return Pattern.compile("classes[\\d]+\\.dex").matcher(paramString).matches();
  }
  
  public static abstract interface InstallEvent
  {
    public abstract void onInstallResult(int paramInt, String paramString);
    
    public abstract boolean onUnZipSoFile(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.plugin.Installer
 * JD-Core Version:    0.7.0.1
 */