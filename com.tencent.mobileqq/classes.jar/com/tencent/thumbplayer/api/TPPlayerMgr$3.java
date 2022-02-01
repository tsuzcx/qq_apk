package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.utils.TPLogUtil;

final class TPPlayerMgr$3
  implements ITPDLProxyNativeLibLoader
{
  TPPlayerMgr$3(ITPModuleLoader paramITPModuleLoader) {}
  
  public boolean loadLib(String paramString1, String paramString2)
  {
    ITPModuleLoader localITPModuleLoader = this.val$loader;
    if (localITPModuleLoader != null) {
      try
      {
        localITPModuleLoader.loadLibrary(paramString1, paramString2);
        return true;
      }
      catch (Throwable paramString1)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayerMgr.java]", paramString1);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMgr.3
 * JD-Core Version:    0.7.0.1
 */