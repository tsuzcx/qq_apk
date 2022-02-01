package com.tencent.mobileqq.qqexpand.plugin.preload.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.qflutter.ExpandModuleKey;
import com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher;
import com.tencent.mobileqq.qqexpand.utils.ExpandPreloadUtils;
import com.tencent.proxyinner.plugin.loader.ShadowPluginsProcessService;
import mqq.app.MobileQQ;

class ExpandPluginPreloadImpl$1
  implements Runnable
{
  ExpandPluginPreloadImpl$1(ExpandPluginPreloadImpl paramExpandPluginPreloadImpl, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (ExpandPluginPreloadImpl.access$000(this.this$0, this.a))
    {
      ShadowPluginsProcessService.a(MobileQQ.sMobileQQ);
      if (ExpandPreloadUtils.a(ExpandModuleKey.ExpandPluginPreload)) {
        ExpandPluginLauncher.a().a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.preload.impl.ExpandPluginPreloadImpl.1
 * JD-Core Version:    0.7.0.1
 */