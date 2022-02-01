package com.tencent.qqmini.sdk.task;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IWXLivePlayerProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineInstaller;
import com.tencent.qqmini.sdk.manager.InstalledEngine;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"WrongConstant"})
public class MiniAppSoLoader
{
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
    IWXLivePlayerProxy localIWXLivePlayerProxy = (IWXLivePlayerProxy)ProxyManager.getNew(IWXLivePlayerProxy.class);
    boolean bool = loadLibSo("mini_lamemp3");
    if (bool) {
      this.lameMp3SoLoaded = true;
    }
    if (bool)
    {
      InstalledEngine localInstalledEngine = this.mEngine;
      if ((localInstalledEngine != null) && (!TextUtils.isEmpty(localInstalledEngine.engineDir))) {
        ThreadManager.getUIHandler().post(new MiniAppSoLoader.1(this, localIWXLivePlayerProxy));
      }
    }
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppSoLoader
 * JD-Core Version:    0.7.0.1
 */