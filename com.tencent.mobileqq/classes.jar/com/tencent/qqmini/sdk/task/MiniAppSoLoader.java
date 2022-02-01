package com.tencent.qqmini.sdk.task;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineInstaller;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.QzoneModuleLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"WrongConstant"})
public class MiniAppSoLoader
{
  public static final String LIBNAME_AVSDK_SO = "liteavsdk";
  public static final String LIBNAME_LAME_MP3_SO = "mini_lamemp3";
  public static final String LIBNAME_LITEAVSDK_JAR = "liteavsdk.jar";
  public static final String LOCAL_ENGINE_VERSION = "0.1";
  private static final String TAG = "MiniAppSoLoader";
  private static final String TRTC_TAG = "[TRTC_SDK]";
  private static volatile MiniAppSoLoader sInstance;
  private boolean lameMp3SoLoaded = false;
  private InstalledEngine mEngine;
  private int mEngineType = 3;
  
  public MiniAppSoLoader()
  {
    Iterator localIterator = EngineInstaller.getInstalledEngine(this.mEngineType).iterator();
    while (localIterator.hasNext())
    {
      InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
      if (localInstalledEngine.isVerify) {
        this.mEngine = localInstalledEngine;
      }
    }
  }
  
  public static MiniAppSoLoader g()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new MiniAppSoLoader();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private String getBaseEnginePath(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine != null) && (paramInstalledEngine.isVerify)) {
      return paramInstalledEngine.engineDir;
    }
    return null;
  }
  
  private void onLog(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 3)
    {
      Integer localInteger = (Integer)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      paramArrayOfObject = (String)paramArrayOfObject[2];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localInteger);
      localStringBuilder.append("||");
      localStringBuilder.append(str);
      localStringBuilder.append("||");
      localStringBuilder.append(paramArrayOfObject);
      QMLog.e("[TRTC_SDK]", localStringBuilder.toString());
    }
  }
  
  public boolean isLameMp3SoLoaded()
  {
    return this.lameMp3SoLoaded;
  }
  
  public boolean loadAllMiniSo()
  {
    IWXLivePlayerProxy localIWXLivePlayerProxy = (IWXLivePlayerProxy)ProxyManager.get(IWXLivePlayerProxy.class);
    boolean bool1;
    StringBuilder localStringBuilder1;
    boolean bool3;
    if (this.mEngine != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mEngine.engineDir);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("liteavsdk.jar");
      localObject = ((StringBuilder)localObject).toString();
      if (localIWXLivePlayerProxy.needLoadAvJar()) {
        try
        {
          bool1 = QzoneModuleLoader.loadModuleDex((String)localObject, AppLoaderFactory.g().getContext(), getClass().getClassLoader(), "com.tencent.rtmp.ui.TXCloudVideoView", false);
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("load liteavsdk.jar failed, e:");
          localStringBuilder2.append(localException.toString());
          QMLog.e("MiniAppSoLoader", localStringBuilder2.toString());
        }
      } else {
        bool1 = false;
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("load liteavsdk.jar, path: ");
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append(", isload: ");
      localStringBuilder1.append(bool1);
      QMLog.e("MiniAppSoLoader", localStringBuilder1.toString());
      bool3 = bool1;
    }
    else
    {
      bool3 = false;
    }
    Object localObject = new String[1];
    localObject[0] = "mini_lamemp3";
    int j = localObject.length;
    int i = 0;
    boolean bool2 = true;
    while (i < j)
    {
      localStringBuilder1 = localObject[i];
      if (("liteavsdk".equals(localStringBuilder1)) && (!bool3))
      {
        QMLog.e("MiniAppSoLoader", "load liteavsdk.jar failed?!!, and don't load liteavsdk.so ?!!");
        bool2 = false;
      }
      else
      {
        if ((bool2) && (loadLibSo(localStringBuilder1))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
        if ("mini_lamemp3".equals(localStringBuilder1))
        {
          bool2 = bool1;
          if (bool1)
          {
            this.lameMp3SoLoaded = true;
            bool2 = bool1;
          }
        }
      }
      i += 1;
    }
    if (bool2)
    {
      localObject = this.mEngine;
      if ((localObject != null) && (!TextUtils.isEmpty(((InstalledEngine)localObject).engineDir)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadAllOk, TXLiveBase.setLibraryPath:");
        ((StringBuilder)localObject).append(this.mEngine.engineDir);
        QMLog.d("MiniAppSoLoader", ((StringBuilder)localObject).toString());
        localIWXLivePlayerProxy.hookListenerAndGoOn(this.mEngine.engineDir, new MiniAppSoLoader.InnerTXLiveBaseListenerImpl(this));
      }
    }
    return bool2;
  }
  
  public boolean loadLameMp3So()
  {
    return loadLibSo("mini_lamemp3");
  }
  
  protected boolean loadLibSo(String paramString)
  {
    if ((this.mEngine != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject2 = getBaseEnginePath(this.mEngine);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("lib");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(".so");
      localObject1 = ((StringBuilder)localObject1).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MiniEng]load so ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" from ");
      localStringBuilder.append((String)localObject1);
      QMLog.i("MiniAppSoLoader", localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return false;
      }
      try
      {
        System.load((String)localObject1);
        if (this.mEngine.loadStatus == 1) {
          this.mEngine.loadStatus = 3;
        }
        paramString = new StringBuilder();
        paramString.append("[MiniEng] load ");
        paramString.append((String)localObject1);
        paramString.append(" success.");
        QMLog.i("MiniAppSoLoader", paramString.toString());
        return true;
      }
      catch (Throwable paramString)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[MiniEng] load ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" fail: ");
        ((StringBuilder)localObject2).append(DebugUtil.getPrintableStackTrace(paramString));
        QMLog.e("MiniAppSoLoader", ((StringBuilder)localObject2).toString(), paramString);
        this.mEngine.loadStatus = 2;
        return false;
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[MiniEng]load so ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" from ");
    ((StringBuilder)localObject1).append(this.mEngine);
    QMLog.e("MiniAppSoLoader", ((StringBuilder)localObject1).toString());
    return false;
  }
  
  public void setEngine(InstalledEngine paramInstalledEngine)
  {
    this.mEngine = paramInstalledEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppSoLoader
 * JD-Core Version:    0.7.0.1
 */