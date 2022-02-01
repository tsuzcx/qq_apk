package com.tencent.mobileqq.qshadow.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qshadow.constant.QShadowConstant;
import com.tencent.mobileqq.qshadow.interfaces.IPluginOpenListener;
import com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager;
import com.tencent.mobileqq.qshadow.utils.AssetUtil;
import com.tencent.mobileqq.qshadow.utils.FileUtil;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.ShadowTag;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DefaultPluginManager
  implements IQShadowPluginManager
{
  private static final int MAX_RETRY_COUNT = 2;
  private static final String PLUGIN_MANAGER_APK_NAME = "qshadow-manager.apk";
  private Context mContext;
  private volatile DynamicPluginManager mDynamicPluginManager;
  private String mGroupId;
  private Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);
  private final File mPluginManagerFile;
  private final String mPluginSdcardRootPath;
  private final String mPluginSdcardRootTempPath;
  private final File mPluginZipFile;
  private Executor mSinglePool = Executors.newSingleThreadExecutor();
  private int retryCount = 0;
  
  public DefaultPluginManager(String paramString, Context paramContext)
  {
    this.mGroupId = PluginIdUtil.getGroupId(paramString);
    this.mContext = paramContext;
    paramString = new StringBuilder();
    paramString.append("qshadow-");
    paramString.append(this.mGroupId);
    paramString.append(".zip");
    paramString = paramString.toString();
    this.mPluginSdcardRootPath = QShadowConstant.getPluginRootPath(this.mContext, this.mGroupId);
    paramContext = new StringBuilder();
    paramContext.append(this.mPluginSdcardRootPath);
    paramContext.append("-temp");
    this.mPluginSdcardRootTempPath = paramContext.toString();
    this.mPluginManagerFile = new File(this.mPluginSdcardRootPath, "qshadow-manager.apk");
    this.mPluginZipFile = new File(this.mPluginSdcardRootPath, paramString);
  }
  
  private boolean checkPluginFileExists(String paramString)
  {
    File localFile1 = new File(paramString, this.mPluginZipFile.getName());
    File localFile2 = new File(paramString, this.mPluginManagerFile.getName());
    paramString = new File(paramString, "config.json");
    return (localFile1.exists()) && (localFile1.length() > 0L) && (localFile2.exists()) && (localFile2.length() > 0L) && (paramString.exists()) && (paramString.length() > 0L);
  }
  
  private String getAssetConfigFilePath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QShadowConstant.getAssetRootPath(this.mGroupId));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("config.json");
    return localStringBuilder.toString();
  }
  
  private void initPluginManager()
  {
    this.mDynamicPluginManager = new DynamicPluginManager(new QShadowPmUpdater(this.mPluginManagerFile));
  }
  
  private void prepareFromAsset()
  {
    Context localContext = this.mContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QShadowConstant.getAssetRootPath(this.mGroupId));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("config.json");
    AssetUtil.copyFilesFromAssets(localContext, localStringBuilder.toString(), this.mPluginSdcardRootPath);
    localContext = this.mContext;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(QShadowConstant.getAssetRootPath(this.mGroupId));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.mPluginManagerFile.getName());
    AssetUtil.copyFilesFromAssets(localContext, localStringBuilder.toString(), this.mPluginSdcardRootPath);
    localContext = this.mContext;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(QShadowConstant.getAssetRootPath(this.mGroupId));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.mPluginZipFile.getName());
    AssetUtil.copyFilesFromAssets(localContext, localStringBuilder.toString(), this.mPluginSdcardRootPath);
  }
  
  private void prepareFromFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1).listFiles();
    int j = paramString1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramString1[i];
      File localFile = new File(paramString2, ((File)localObject1).getName());
      Object localObject2;
      if ((!localFile.getParentFile().exists()) && (!localFile.getParentFile().mkdirs()))
      {
        localObject2 = this.mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("plugin_tag 创建目录失败: ");
        localStringBuilder.append(localFile.getParentFile());
        ((Logger)localObject2).warn(localStringBuilder.toString());
      }
      if (FileUtil.moveFile(localFile, (File)localObject1))
      {
        localObject1 = this.mLogger;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("plugin_tag File: ");
        ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
        ((StringBuilder)localObject2).append(" move result: ");
        ((StringBuilder)localObject2).append(localFile.exists());
        ((StringBuilder)localObject2).append(", size: ");
        ((StringBuilder)localObject2).append(localFile.length());
        ((StringBuilder)localObject2).append(", lastModify: ");
        ((StringBuilder)localObject2).append(localFile.lastModified());
        ((Logger)localObject1).warn(((StringBuilder)localObject2).toString());
        i += 1;
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append("plugin_tag 插件升级包安装失败: ");
        paramString1.append(((File)localObject1).getAbsolutePath());
        throw new RuntimeException(paramString1.toString());
      }
    }
  }
  
  public void afterEnter(long paramLong, Bundle paramBundle) {}
  
  public void beforeEnter(long paramLong, Bundle paramBundle) {}
  
  public final void enter(Context paramContext, long paramLong, Bundle paramBundle, IPluginOpenListener paramIPluginOpenListener)
  {
    if (this.mLogger.isWarnEnabled())
    {
      Logger localLogger = this.mLogger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter ");
      localStringBuilder.append(this.mGroupId);
      localStringBuilder.append(" bundle ");
      localStringBuilder.append(paramBundle);
      localLogger.warn(localStringBuilder.toString());
    }
    this.mSinglePool.execute(new DefaultPluginManager.1(this, paramLong, paramBundle, paramContext, paramIPluginOpenListener));
  }
  
  public String getPluginZipPath()
  {
    return this.mPluginZipFile.getAbsolutePath();
  }
  
  public boolean installPlugin()
  {
    for (;;)
    {
      try
      {
        if (isPluginRunning())
        {
          this.mLogger.warn("plugin_tag 插件正在运行，不允许安装！");
          return false;
        }
        try
        {
          str2 = QShadowRepository.getInstalledPlugin(this.mContext, this.mGroupId, "");
          if (checkPluginFileExists(this.mPluginSdcardRootTempPath))
          {
            str1 = QShadowRepository.getUuidFromFile(new File(this.mPluginSdcardRootTempPath, "config.json"));
            if (!str1.equalsIgnoreCase(str2))
            {
              prepareFromFile(this.mPluginSdcardRootTempPath, this.mPluginSdcardRootPath);
              break label399;
            }
            this.mLogger.warn("plugin_tag Temp目录插件与当前插件版本uuid一致，无需安装");
            break label404;
          }
          if (AssetUtil.isFileExists(this.mContext, getAssetConfigFilePath()))
          {
            str1 = QShadowRepository.getUuidFromStream(this.mContext.getAssets().open(getAssetConfigFilePath()));
            if (!str1.equalsIgnoreCase(str2))
            {
              prepareFromAsset();
              break label399;
            }
            this.mLogger.warn("plugin_tag Asset目录插件与当前插件版本uuid一致，无需安装");
            break label404;
          }
          str1 = QShadowRepository.getUuidFromFile(new File(this.mPluginSdcardRootPath, "config.json"));
          if (!str1.equalsIgnoreCase(str2)) {
            break label399;
          }
          this.mLogger.warn("plugin_tag qshadow-plugins目录插件与当前插件版本uuid一致，无需安装");
        }
        catch (Exception localException)
        {
          String str2;
          String str1;
          Bundle localBundle;
          Logger localLogger;
          StringBuilder localStringBuilder;
          this.mLogger.error("plugin_tag 插件安装失败：", localException);
          QShadowRepository.deleteInstalledPlugin(this.mContext, this.mGroupId);
          PluginRuntime.handleCrash(localException, this.mGroupId, this.mContext);
          release();
          return false;
        }
        initPluginManager();
        localBundle = new Bundle();
        localBundle.putString("pluginZipPath", getPluginZipPath());
        if ((i != 0) && (!TextUtils.isEmpty(str2)))
        {
          localLogger = this.mLogger;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("plugin_tag delete old plugin uuid: ");
          localStringBuilder.append(str2);
          localLogger.warn(localStringBuilder.toString());
          localBundle.putString("KEY_PLUGIN_UUID", str2);
        }
        this.mDynamicPluginManager.enter(this.mContext, 1001L, localBundle, null);
        if (!TextUtils.isEmpty(str1)) {
          QShadowRepository.saveInstalledPlugin(this.mContext, this.mGroupId, str1);
        }
        this.mLogger.warn("plugin_tag install manager success!");
        return true;
      }
      finally {}
      label399:
      int i = 1;
      continue;
      label404:
      i = 0;
    }
  }
  
  public boolean isPluginInstalled()
  {
    return TextUtils.isEmpty(QShadowRepository.getInstalledPlugin(this.mContext, this.mGroupId, "")) ^ true;
  }
  
  public boolean isPluginRunning()
  {
    return this.mDynamicPluginManager != null;
  }
  
  /* Error */
  public final boolean preInstall(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 92	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 90	com/tencent/mobileqq/qshadow/core/DefaultPluginManager:mPluginSdcardRootTempPath	Ljava/lang/String;
    //   10: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 133	java/io/File:exists	()Z
    //   18: ifeq +10 -> 28
    //   21: aload_3
    //   22: invokestatic 355	com/tencent/mobileqq/qshadow/utils/FileUtil:cleanDirectory	(Ljava/io/File;)V
    //   25: goto +8 -> 33
    //   28: aload_3
    //   29: invokevirtual 176	java/io/File:mkdirs	()Z
    //   32: pop
    //   33: aload_1
    //   34: invokevirtual 197	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 90	com/tencent/mobileqq/qshadow/core/DefaultPluginManager:mPluginSdcardRootTempPath	Ljava/lang/String;
    //   41: invokestatic 358	com/tencent/mobileqq/qshadow/utils/FileUtil:unZipFolder	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 90	com/tencent/mobileqq/qshadow/core/DefaultPluginManager:mPluginSdcardRootTempPath	Ljava/lang/String;
    //   49: invokespecial 259	com/tencent/mobileqq/qshadow/core/DefaultPluginManager:checkPluginFileExists	(Ljava/lang/String;)Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifne +19 -> 73
    //   57: aload_0
    //   58: getfield 43	com/tencent/mobileqq/qshadow/core/DefaultPluginManager:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   61: ldc_w 360
    //   64: invokeinterface 186 2 0
    //   69: aload_3
    //   70: invokestatic 355	com/tencent/mobileqq/qshadow/utils/FileUtil:cleanDirectory	(Ljava/io/File;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iload_2
    //   76: ireturn
    //   77: astore_1
    //   78: goto +33 -> 111
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 43	com/tencent/mobileqq/qshadow/core/DefaultPluginManager:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   86: ldc_w 362
    //   89: aload_1
    //   90: invokeinterface 336 3 0
    //   95: aload_1
    //   96: aload_0
    //   97: getfield 61	com/tencent/mobileqq/qshadow/core/DefaultPluginManager:mGroupId	Ljava/lang/String;
    //   100: aload_0
    //   101: getfield 63	com/tencent/mobileqq/qshadow/core/DefaultPluginManager:mContext	Landroid/content/Context;
    //   104: invokestatic 346	com/tencent/mobileqq/pluginsdk/PluginRuntime:handleCrash	(Ljava/lang/Throwable;Ljava/lang/String;Landroid/content/Context;)V
    //   107: aload_0
    //   108: monitorexit
    //   109: iconst_0
    //   110: ireturn
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	DefaultPluginManager
    //   0	115	1	paramFile	File
    //   52	24	2	bool	boolean
    //   13	57	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   2	25	77	finally
    //   28	33	77	finally
    //   33	53	77	finally
    //   57	73	77	finally
    //   82	107	77	finally
    //   2	25	81	java/lang/Exception
    //   28	33	81	java/lang/Exception
    //   33	53	81	java/lang/Exception
    //   57	73	81	java/lang/Exception
  }
  
  public final void release()
  {
    this.mSinglePool.execute(new DefaultPluginManager.2(this));
  }
  
  public boolean uninstallPlugin()
  {
    if (isPluginRunning())
    {
      this.mLogger.warn("plugin_tag plugin is running, don't allow uninstall it!");
      return false;
    }
    File localFile1 = new File(this.mPluginSdcardRootPath);
    File localFile2 = new File(Constant.getPluginInstalledPath(this.mContext, this.mGroupId));
    try
    {
      QShadowRepository.deleteInstalledPlugin(this.mContext, this.mGroupId);
      FileUtil.cleanDirectory(localFile1);
      FileUtil.cleanDirectory(localFile2);
      return true;
    }
    catch (Exception localException)
    {
      this.mLogger.error("plugin_tag uninstall plugin", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.core.DefaultPluginManager
 * JD-Core Version:    0.7.0.1
 */