package com.tencent.xaction.openapi.api.impl;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xaction.openapi.DynamicClassLoader;
import com.tencent.xaction.openapi.api.IDynamicLoader;
import com.tencent.xaction.openapi.api.IXADownload;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
public class DynamicLoaderImpl
  implements IDynamicLoader
{
  private static final String APK_NAME = "xaction.apk";
  private static final boolean DEBUG = false;
  public static final File INSTALL_ROOT = new File(BaseApplication.getContext().getFilesDir(), "xactionlib");
  private static final File OPTIMIZED_DIRECTORY = new File(INSTALL_ROOT, "opt");
  private static final String TAG = "DynamicLoader";
  private DexClassLoader classLoader = null;
  private boolean isLoad = false;
  
  private boolean checkCRC(File paramFile1, File paramFile2)
  {
    long l1 = IOUtil.getCRC32Value(paramFile1);
    boolean bool = false;
    if (l1 == -1L) {
      return false;
    }
    long l2 = IOUtil.getCRC32Value(paramFile2);
    if (l2 == -1L) {
      return false;
    }
    if (l2 == l1) {
      bool = true;
    }
    return bool;
  }
  
  private void doLoadApk()
  {
    try
    {
      DexClassLoader localDexClassLoader = initClassLoader(getInstallRoot(), getApkFile());
      if (localDexClassLoader != null)
      {
        this.classLoader = localDexClassLoader;
        this.isLoad = true;
        showTestToast(BaseApplication.getContext(), "XA动态加载成功");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loaded xa version:");
        localStringBuilder.append(getXAVersion(localDexClassLoader));
        QLog.d("DynamicLoader", 1, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @NotNull
  private File getApkFile()
  {
    if (!QVipSDKProcessor.e().m())
    {
      QLog.d("DynamicLoader", 1, "xaDynamicEnable:false");
      return new File("none");
    }
    if (!((IXADownload)QRoute.api(IXADownload.class)).isNoNeedDownload())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download xaDynamic package:");
      localStringBuilder.append(IXADownload.SCID);
      QLog.d("DynamicLoader", 1, localStringBuilder.toString());
      ((IXADownload)QRoute.api(IXADownload.class)).requestDownload();
    }
    return ((IXADownload)QRoute.api(IXADownload.class)).getDownloadPath();
  }
  
  @NotNull
  private File getInstallRoot()
  {
    if (!INSTALL_ROOT.exists()) {
      INSTALL_ROOT.mkdirs();
    }
    return INSTALL_ROOT;
  }
  
  @Nullable
  private DexClassLoader initClassLoader(File paramFile1, File paramFile2)
  {
    if (paramFile1.exists())
    {
      if (!paramFile2.exists()) {
        return null;
      }
      File localFile = new File(paramFile1, "xaction.apk");
      if (!checkCRC(localFile, paramFile2))
      {
        FileUtils.deleteFilesInDirectory(paramFile1.getAbsolutePath());
        FileUtils.copyFile(paramFile2, localFile);
      }
      if (!OPTIMIZED_DIRECTORY.exists()) {
        OPTIMIZED_DIRECTORY.mkdirs();
      }
      if (OPTIMIZED_DIRECTORY.exists())
      {
        if (!OPTIMIZED_DIRECTORY.isDirectory()) {
          return null;
        }
        return new DynamicClassLoader(localFile.getAbsolutePath(), OPTIMIZED_DIRECTORY.getAbsolutePath(), null, DynamicLoaderImpl.class.getClassLoader());
      }
    }
    return null;
  }
  
  private void showTestToast(Context paramContext, String paramString)
  {
    QLog.d("DynamicLoader", 1, paramString);
  }
  
  public ClassLoader getClassLoader()
  {
    return this.classLoader;
  }
  
  public String getXAVersion(DexClassLoader paramDexClassLoader)
  {
    try
    {
      paramDexClassLoader = paramDexClassLoader.loadClass("com.tencent.xaction.BuildConfig").getConstructor(new Class[0]).newInstance(new Object[0]);
      paramDexClassLoader = (String)paramDexClassLoader.getClass().getField("VERSION_NAME").get(paramDexClassLoader);
      return paramDexClassLoader;
    }
    catch (Exception paramDexClassLoader)
    {
      QLog.d("DynamicLoader", 1, paramDexClassLoader, new Object[0]);
    }
    return "";
  }
  
  public boolean isLoaded()
  {
    return (this.isLoad) && (this.classLoader != null);
  }
  
  public void loadSync()
  {
    if (this.isLoad) {
      return;
    }
    try
    {
      if (this.isLoad) {
        return;
      }
      doLoadApk();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.impl.DynamicLoaderImpl
 * JD-Core Version:    0.7.0.1
 */