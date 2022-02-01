package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

class TPListenerManager$3
  implements Runnable
{
  TPListenerManager$3(TPListenerManager paramTPListenerManager, int paramInt) {}
  
  public void run()
  {
    String str = TPDLProxyUtils.losePackageCheck(this.val$sendPackageCount);
    TPDownloadProxyNative.getInstance().setUserData("lose_package_check_info", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager.3
 * JD-Core Version:    0.7.0.1
 */