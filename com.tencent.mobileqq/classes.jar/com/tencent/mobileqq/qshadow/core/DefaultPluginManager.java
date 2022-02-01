package com.tencent.mobileqq.qshadow.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qshadow.constant.Constant;
import com.tencent.mobileqq.qshadow.interfaces.IQShadowPluginManager;
import com.tencent.mobileqq.qshadow.utils.AssetUtil;
import com.tencent.mobileqq.qshadow.utils.FileUtil;
import com.tencent.mobileqq.qshadow.utils.PluginIdUtil;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;
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
    paramString = "qshadow-" + this.mGroupId + ".zip";
    this.mPluginSdcardRootPath = Constant.getPluginRootPath(this.mContext, this.mGroupId);
    this.mPluginSdcardRootTempPath = (this.mPluginSdcardRootPath + "-temp");
    this.mPluginManagerFile = new File(this.mPluginSdcardRootPath, "qshadow-manager.apk");
    this.mPluginZipFile = new File(this.mPluginSdcardRootPath, paramString);
  }
  
  private boolean checkNetPluginFile()
  {
    File localFile1 = new File(this.mPluginSdcardRootTempPath, this.mPluginZipFile.getName());
    File localFile2 = new File(this.mPluginSdcardRootTempPath, this.mPluginManagerFile.getName());
    File localFile3 = new File(this.mPluginSdcardRootTempPath, "config.json");
    return (localFile1.exists()) && (localFile1.length() > 0L) && (localFile2.exists()) && (localFile2.length() > 0L) && (localFile3.exists()) && (localFile3.length() > 0L);
  }
  
  private String getAssetConfigFilePath()
  {
    return Constant.getAssetRootPath(this.mGroupId) + File.separator + "config.json";
  }
  
  private void initPluginManager()
  {
    this.mDynamicPluginManager = new DynamicPluginManager(new QShadowPmUpdater(this.mPluginManagerFile));
  }
  
  private void prepareFromAsset()
  {
    AssetUtil.copyFilesFromAssets(this.mContext, Constant.getAssetRootPath(this.mGroupId), this.mPluginSdcardRootPath);
  }
  
  private void prepareFromTemp()
  {
    File[] arrayOfFile = new File(this.mPluginSdcardRootTempPath).listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile1 = arrayOfFile[i];
      File localFile2 = new File(this.mPluginSdcardRootPath, localFile1.getName());
      if ((!localFile2.getParentFile().exists()) && (!localFile2.getParentFile().mkdirs())) {
        this.mLogger.warn("plugin_tag 创建目录失败: " + localFile2.getParentFile());
      }
      if (!localFile2.createNewFile()) {
        this.mLogger.warn("plugin_tag 新建文件失败: " + localFile2);
      }
      if (!FileUtil.moveFile(localFile2, localFile1)) {
        throw new RuntimeException("plugin_tag 插件升级包安装失败: " + localFile1.getAbsolutePath());
      }
      this.mLogger.warn("plugin_tag File: " + localFile2.getAbsolutePath() + " move result: " + localFile2.exists() + ", size: " + localFile2.length() + ", lastModify: " + localFile2.lastModified());
      i += 1;
    }
  }
  
  public void afterEnter(long paramLong, Bundle paramBundle) {}
  
  public void beforeEnter(long paramLong, Bundle paramBundle) {}
  
  public final void enter(Context paramContext, long paramLong, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    if (this.mLogger.isInfoEnabled()) {
      this.mLogger.info("enter " + this.mGroupId + " bundle " + paramBundle);
    }
    this.mSinglePool.execute(new DefaultPluginManager.1(this, paramLong, paramBundle, paramContext, paramEnterCallback));
  }
  
  public String getPluginZipPath()
  {
    return this.mPluginZipFile.getAbsolutePath();
  }
  
  public boolean installPlugin()
  {
    boolean bool = false;
    try
    {
      if (isPluginRunning())
      {
        this.mLogger.warn("plugin_tag 插件正在运行，不允许安装！");
        return bool;
      }
      for (;;)
      {
        try
        {
          String str2 = QShadowRepository.getInstalledPlugin(this.mContext, this.mGroupId, "");
          int i;
          if (checkNetPluginFile())
          {
            str1 = QShadowRepository.getUuidFromFile(new File(this.mPluginSdcardRootTempPath, "config.json"));
            if (!str1.equalsIgnoreCase(str2))
            {
              prepareFromTemp();
              i = 1;
              break label330;
              initPluginManager();
              Bundle localBundle = new Bundle();
              localBundle.putString("pluginZipPath", getPluginZipPath());
              if ((i != 0) && (!TextUtils.isEmpty(str2)))
              {
                this.mLogger.warn("plugin_tag delete old plugin uuid: " + str2);
                localBundle.putString("KEY_PLUGIN_UUID", str2);
              }
              this.mDynamicPluginManager.enter(this.mContext, 1001L, localBundle, null);
              if (!TextUtils.isEmpty(str1)) {
                QShadowRepository.saveInstalledPlugin(this.mContext, this.mGroupId, str1);
              }
              this.mLogger.warn("plugin_tag install manager success!");
              bool = true;
              break;
            }
            this.mLogger.warn("plugin_tag Temp目录插件与当前插件版本uuid一致，无需安装");
            i = 0;
            break label330;
          }
          String str1 = QShadowRepository.getUuidFromStream(this.mContext.getAssets().open(getAssetConfigFilePath()));
          if (!str1.equalsIgnoreCase(str2))
          {
            prepareFromAsset();
            i = 1;
          }
          else
          {
            this.mLogger.warn("plugin_tag Asset目录插件与当前插件版本uuid一致，无需安装");
            i = 0;
          }
        }
        catch (Exception localException)
        {
          this.mLogger.error("plugin_tag 插件安装失败：", localException);
          QShadowRepository.deleteInstalledPlugin(this.mContext, this.mGroupId);
          PluginRuntime.handleCrash(localException, this.mGroupId, this.mContext);
        }
      }
    }
    finally {}
  }
  
  public boolean isPluginInstalled()
  {
    return !TextUtils.isEmpty(QShadowRepository.getInstalledPlugin(this.mContext, this.mGroupId, ""));
  }
  
  public boolean isPluginRunning()
  {
    return this.mDynamicPluginManager != null;
  }
  
  public final boolean preInstall(File paramFile)
  {
    for (;;)
    {
      try
      {
        localFile = new File(this.mPluginSdcardRootTempPath);
        if (!localFile.exists()) {
          continue;
        }
        FileUtil.cleanDirectory(localFile);
        FileUtil.unZipFolder(paramFile.getAbsolutePath(), this.mPluginSdcardRootTempPath);
        boolean bool2 = checkNetPluginFile();
        bool1 = bool2;
        if (!bool2)
        {
          this.mLogger.warn("plugin_tag 插件包文件不合法，压缩包应内包含 config.json qshadow-manager.apk qshadow-pluginId.zip文件");
          FileUtil.cleanDirectory(localFile);
          bool1 = bool2;
        }
      }
      catch (Exception paramFile)
      {
        File localFile;
        this.mLogger.error("plugin_tag 插件包升级失败：", paramFile);
        PluginRuntime.handleCrash(paramFile, this.mGroupId, this.mContext);
        boolean bool1 = false;
        continue;
      }
      finally {}
      return bool1;
      localFile.mkdirs();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.core.DefaultPluginManager
 * JD-Core Version:    0.7.0.1
 */