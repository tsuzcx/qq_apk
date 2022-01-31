package com.tencent.mobileqq.videoplatform.imp;

import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class LoadSoImp
  implements ILoadSo
{
  private static final String TAG = "[VideoPlatForm]LoadSoImp";
  boolean bCkeygeneratorV2 = false;
  boolean bCkguard = false;
  boolean bDownProxyResult = false;
  boolean bTPCoreResult = false;
  
  public boolean isCkeygeneratorV2Load()
  {
    return this.bCkeygeneratorV2;
  }
  
  public boolean isCkguardLoad()
  {
    return this.bCkguard;
  }
  
  public boolean isDownProxyLoad()
  {
    return this.bDownProxyResult;
  }
  
  public boolean isTPCoreLoad()
  {
    return this.bTPCoreResult;
  }
  
  public boolean loadDownProxySync()
  {
    try
    {
      System.loadLibrary("DownloadProxy");
      if (LogUtil.isColorLevel()) {
        LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadDownProxySync success.");
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadDownProxySync err.", localThrowable);
    }
    return false;
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    try
    {
      System.loadLibrary("TPCore-master");
      if (LogUtil.isColorLevel()) {
        LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadSo  SONAME_TPCORE_MASTER success.");
      }
      this.bTPCoreResult = true;
      return;
    }
    catch (Throwable localThrowable3)
    {
      try
      {
        System.loadLibrary("DownloadProxy");
        if (LogUtil.isColorLevel()) {
          LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadSo SONAME_DOWNLOADPROXY success.");
        }
      }
      catch (Throwable localThrowable3)
      {
        try
        {
          System.loadLibrary("ckguard");
          if (LogUtil.isColorLevel()) {
            LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadSo SONAME_CKGUARD success.");
          }
        }
        catch (Throwable localThrowable3)
        {
          try
          {
            for (;;)
            {
              System.loadLibrary("ckeygeneratorV2");
              if (LogUtil.isColorLevel()) {
                LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadSo SONAME_CKEYGENERATORV2 success.");
              }
              if ((!this.bTPCoreResult) || (!this.bDownProxyResult) || (!this.bCkguard) || (!this.bCkeygeneratorV2)) {
                break;
              }
              paramLoadSoCallback.onLoad(true);
              return;
              localThrowable1 = localThrowable1;
              LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadSo SONAME_TPCORE_MASTER err.", localThrowable1);
              continue;
              localThrowable2 = localThrowable2;
              LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadSo SONAME_DOWNLOADPROXY err.", localThrowable2);
              continue;
              localThrowable3 = localThrowable3;
              LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadSo SONAME_CKGUARD err.", localThrowable3);
            }
          }
          catch (Throwable localThrowable4)
          {
            for (;;)
            {
              LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadSo SONAME_CKEYGENERATORV2 err.", localThrowable4);
            }
            paramLoadSoCallback.onLoad(false);
          }
        }
      }
    }
  }
  
  public boolean loadTPCoreSync()
  {
    try
    {
      System.loadLibrary("TPCore-master");
      if (LogUtil.isColorLevel()) {
        LogUtil.d("[VideoPlatForm]LoadSoImp", 2, "loadTPCoreSync success.");
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e("[VideoPlatForm]LoadSoImp", 2, "loadTPCoreSync err.", localThrowable);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.imp.LoadSoImp
 * JD-Core Version:    0.7.0.1
 */