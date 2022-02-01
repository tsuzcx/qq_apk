package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;

class BaseLibManager$1
  implements Runnable
{
  BaseLibManager$1(BaseLibManager paramBaseLibManager, BaseLibManager.UpdateListener paramUpdateListener) {}
  
  public void run()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", null);
    String str2 = StorageUtil.getPreference().getString("version", "1.19.0.00043");
    QMLog.i("miniapp-process_BaseLibManager", "updateBaseLib start. baseLibVersion=" + str2);
    QMLog.i("miniapp-process_BaseLibManager", "forceUpdateBaseLib current requestVersion is:" + str2);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib(str2, true, true, new BaseLibManager.1.1(this, str2, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1
 * JD-Core Version:    0.7.0.1
 */