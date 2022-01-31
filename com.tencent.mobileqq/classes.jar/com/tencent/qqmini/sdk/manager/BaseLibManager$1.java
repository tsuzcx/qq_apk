package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import bgrl;
import bgrm;
import bgrp;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.StorageUtil;

public class BaseLibManager$1
  implements Runnable
{
  public BaseLibManager$1(bgrl parambgrl, bgrp parambgrp) {}
  
  public void run()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", null);
    String str2 = StorageUtil.getPreference().getString("version", "1.14.0.00225");
    QMLog.i("miniapp-process_BaseLibManager", "updateBaseLib start. baseLibVersion=" + str2);
    QMLog.i("miniapp-process_BaseLibManager", "forceUpdateBaseLib current requestVersion is:" + str2);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib(str2, true, true, new bgrm(this, str2, str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1
 * JD-Core Version:    0.7.0.1
 */