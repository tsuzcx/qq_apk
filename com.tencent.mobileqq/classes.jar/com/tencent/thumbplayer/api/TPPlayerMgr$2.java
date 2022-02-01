package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.core.common.ITPNativeLibraryExternalLoader;
import com.tencent.thumbplayer.utils.TPLogUtil;

final class TPPlayerMgr$2
  implements ITPNativeLibraryExternalLoader
{
  TPPlayerMgr$2(ITPModuleLoader paramITPModuleLoader) {}
  
  public boolean loadLib(String paramString1, String paramString2)
  {
    if (this.val$loader != null) {
      try
      {
        this.val$loader.loadLibrary(paramString1, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerMgr.2
 * JD-Core Version:    0.7.0.1
 */