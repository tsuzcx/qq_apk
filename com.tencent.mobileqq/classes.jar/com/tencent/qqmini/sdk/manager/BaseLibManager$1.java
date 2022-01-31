package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import bdnw;
import bdoa;
import bdob;
import bdoe;
import bdzf;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class BaseLibManager$1
  implements Runnable
{
  public BaseLibManager$1(bdoa parambdoa, bdoe parambdoe) {}
  
  public void run()
  {
    String str1 = bdzf.a().getString("downloadUrl", null);
    String str2 = bdzf.a().getString("version", "1.10.0.00173");
    bdnw.b("miniapp-process_BaseLibManager", "updateBaseLib start. baseLibVersion=" + str2);
    bdnw.b("miniapp-process_BaseLibManager", "forceUpdateBaseLib current requestVersion is:" + str2);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib(str2, true, true, new bdob(this, str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1
 * JD-Core Version:    0.7.0.1
 */