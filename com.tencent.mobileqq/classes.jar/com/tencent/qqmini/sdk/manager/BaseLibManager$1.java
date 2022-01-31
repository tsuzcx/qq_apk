package com.tencent.qqmini.sdk.manager;

import android.content.SharedPreferences;
import betc;
import bete;
import betf;
import beti;
import bfhm;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

public class BaseLibManager$1
  implements Runnable
{
  public BaseLibManager$1(bete parambete, beti parambeti) {}
  
  public void run()
  {
    String str1 = bfhm.a().getString("downloadUrl", null);
    String str2 = bfhm.a().getString("version", "1.13.0.00013");
    betc.b("miniapp-process_BaseLibManager", "updateBaseLib start. baseLibVersion=" + str2);
    betc.b("miniapp-process_BaseLibManager", "forceUpdateBaseLib current requestVersion is:" + str2);
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).updateBaseLib(str2, true, true, new betf(this, str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.BaseLibManager.1
 * JD-Core Version:    0.7.0.1
 */