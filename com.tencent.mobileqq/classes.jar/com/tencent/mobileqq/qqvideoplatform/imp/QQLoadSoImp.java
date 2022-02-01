package com.tencent.mobileqq.qqvideoplatform.imp;

import com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
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
    return VideoPlaySDKManager.getInstance().isSoLoadSuc();
  }
  
  public boolean isTPCoreLoad()
  {
    return VideoPlaySDKManager.getInstance().isSoLoadSuc();
  }
  
  public boolean loadDownProxySync()
  {
    return ((IVideoSoLoader)QRoute.api(IVideoSoLoader.class)).loadDownProxySync();
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "initSDKAsync, loadSo begin.");
    }
    ((IVideoSoLoader)QRoute.api(IVideoSoLoader.class)).loadSo(paramLoadSoCallback);
  }
  
  public boolean loadTPCoreSync()
  {
    return ((IVideoSoLoader)QRoute.api(IVideoSoLoader.class)).loadTPCoreSync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.imp.QQLoadSoImp
 * JD-Core Version:    0.7.0.1
 */