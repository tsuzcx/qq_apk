package com.tencent.mobileqq.qqvideoplatform.imp;

import com.tencent.mobileqq.soload.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.ILoadSo;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class QQLoadSoImp
  implements ILoadSo
{
  boolean a = false;
  
  public boolean isCkeygeneratorV2Load()
  {
    return this.a;
  }
  
  public boolean isCkguardLoad()
  {
    return this.a;
  }
  
  public boolean isDownProxyLoad()
  {
    return this.a;
  }
  
  public boolean isTPCoreLoad()
  {
    return this.a;
  }
  
  public boolean loadDownProxySync()
  {
    boolean bool = false;
    LoadExtResult localLoadExtResult = SoLoadManager.a().a("DownloadProxy");
    if (localLoadExtResult != null) {
      bool = localLoadExtResult.isSucc();
    }
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadDownProxySync, bDownProxyResult  = " + bool);
    }
    return bool;
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "initSDKAsync, loadSo begin.");
    }
    SoLoadManager localSoLoadManager = SoLoadManager.a();
    paramLoadSoCallback = new QQLoadSoImp.1(this, paramLoadSoCallback);
    localSoLoadManager.a(new String[] { "TPCore-master", "DownloadProxy", "ckguard", "ckeygeneratorV2" }, paramLoadSoCallback);
  }
  
  public boolean loadTPCoreSync()
  {
    boolean bool = false;
    LoadExtResult localLoadExtResult = SoLoadManager.a().a("TPCore-master");
    if (localLoadExtResult != null) {
      bool = localLoadExtResult.isSucc();
    }
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "loadTPCoreSync, bTPCoreResult  = " + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.imp.QQLoadSoImp
 * JD-Core Version:    0.7.0.1
 */