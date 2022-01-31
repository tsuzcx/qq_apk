package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import besl;
import besn;
import beso;
import besr;
import bfgv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class BaseLibManager$1
  implements Runnable
{
  public BaseLibManager$1(besn parambesn, besr parambesr) {}
  
  public void run()
  {
    String str1 = bfgv.a().getString("downloadUrl", null);
    String str2 = bfgv.a().getString("version", "1.12.1.00001");
    besl.b("miniapp-process_BaseLibManager", "updateBaseLib start. baseLibVersion=" + str2);
    besl.b("miniapp-process_BaseLibManager", "forceUpdateBaseLib current requestVersion is:" + str2);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib(str2, true, true, new beso(this, str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1
 * JD-Core Version:    0.7.0.1
 */