package com.tencent.mobileqq.qqvideoplatform.api.impl;

import com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class VideoSoLoaderImpl
  implements IVideoSoLoader
{
  public static final String TAG = "[VideoPlatform]VideoSoManagerImpl";
  
  public boolean loadDownProxySync()
  {
    Object localObject = SoLoadManager.getInstance().loadSync("DownloadProxy");
    boolean bool;
    if (localObject != null) {
      bool = ((LoadExtResult)localObject).isSucc();
    } else {
      bool = false;
    }
    if (LogUtil.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadDownProxySync, bDownProxyResult  = ");
      ((StringBuilder)localObject).append(bool);
      LogUtil.d("[VideoPlatform]VideoSoManagerImpl", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public void loadSo(LoadSoCallback paramLoadSoCallback)
  {
    SoLoadManager localSoLoadManager = SoLoadManager.getInstance();
    paramLoadSoCallback = new VideoSoLoaderImpl.1(this, paramLoadSoCallback);
    localSoLoadManager.loadSequentially(new String[] { "TPCore-master", "DownloadProxy", "ckguard", "ckeygeneratorV2" }, paramLoadSoCallback);
  }
  
  public boolean loadTPCoreSync()
  {
    Object localObject = SoLoadManager.getInstance().loadSync("TPCore-master");
    boolean bool;
    if (localObject != null) {
      bool = ((LoadExtResult)localObject).isSucc();
    } else {
      bool = false;
    }
    if (LogUtil.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadTPCoreSync, bTPCoreResult  = ");
      ((StringBuilder)localObject).append(bool);
      LogUtil.d("[VideoPlatform]VideoSoManagerImpl", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqvideoplatform.api.impl.VideoSoLoaderImpl
 * JD-Core Version:    0.7.0.1
 */