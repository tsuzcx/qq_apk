package com.tencent.mobileqq.videoplatform.imp;

import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class LoadSoImp
  implements ILoadSo
{
  private static final String TAG = "[VideoPlatForm]LoadSoImp";
  boolean mCkeygeneratorV2 = false;
  boolean mCkguard = false;
  boolean mDownProxyResult = false;
  boolean mTPCoreResult = false;
  
  private boolean loadCkGenSo()
  {
    try
    {
      System.loadLibrary("ckeygeneratorV2");
      if (LogUtil.isColorLevel()) {
        LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadCkGenSo success.");
      }
      this.mCkeygeneratorV2 = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadCkGenSo err.", localThrowable);
    }
    return false;
  }
  
  private boolean loadCkGuardSo()
  {
    try
    {
      System.loadLibrary("ckguard");
      if (LogUtil.isColorLevel()) {
        LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadCkGuardSo success.");
      }
      this.mCkguard = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadCkGuardSo err.", localThrowable);
    }
    return false;
  }
  
  private boolean loadDownloadProxySo()
  {
    try
    {
      System.loadLibrary("DownloadProxy");
      if (LogUtil.isColorLevel()) {
        LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadDownProxySync success.");
      }
      this.mDownProxyResult = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadDownProxySync err.", localThrowable);
    }
    return false;
  }
  
  private boolean loadTpCoreSo()
  {
    try
    {
      System.loadLibrary("TPCore-master");
      if (LogUtil.isColorLevel()) {
        LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadTpCoreSo success.");
      }
      this.mTPCoreResult = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadTpCoreSo err.", localThrowable);
    }
    return false;
  }
  
  public boolean isCkeygeneratorV2Load()
  {
    return this.mCkeygeneratorV2;
  }
  
  public boolean isCkguardLoad()
  {
    return this.mCkguard;
  }
  
  public boolean isDownProxyLoad()
  {
    return this.mDownProxyResult;
  }
  
  public boolean isTPCoreLoad()
  {
    return this.mTPCoreResult;
  }
  
  public boolean loadDownProxySync()
  {
    return loadDownloadProxySo();
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    loadTpCoreSo();
    loadDownloadProxySo();
    loadCkGuardSo();
    loadCkGenSo();
    if ((this.mTPCoreResult) && (this.mDownProxyResult) && (this.mCkguard) && (this.mCkeygeneratorV2))
    {
      paramLoadSoCallback.onLoad(true);
      return;
    }
    paramLoadSoCallback.onLoad(false);
  }
  
  public boolean loadTPCoreSync()
  {
    return loadTpCoreSo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.imp.LoadSoImp
 * JD-Core Version:    0.7.0.1
 */