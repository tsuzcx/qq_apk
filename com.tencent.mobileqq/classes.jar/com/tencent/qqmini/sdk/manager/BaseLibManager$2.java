package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;

class BaseLibManager$2
  implements Runnable
{
  BaseLibManager$2(BaseLibManager paramBaseLibManager, BaseLibManager.UpdateListener paramUpdateListener) {}
  
  public void run()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", null);
    String str2 = StorageUtil.getPreference().getString("version", "1.29.0.00002");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateBaseLib start. baseLibVersion=");
    localStringBuilder.append(str2);
    QMLog.i("miniapp-process_BaseLibManager", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("forceUpdateBaseLib current requestVersion is:");
    localStringBuilder.append(str2);
    QMLog.i("miniapp-process_BaseLibManager", localStringBuilder.toString());
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib(str2, true, true, new BaseLibManager.2.1(this, str2, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.2
 * JD-Core Version:    0.7.0.1
 */