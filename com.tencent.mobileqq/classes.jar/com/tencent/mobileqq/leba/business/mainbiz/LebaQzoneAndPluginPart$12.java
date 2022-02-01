package com.tencent.mobileqq.leba.business.mainbiz;

import android.text.TextUtils;
import com.tencent.comic.api.IQQPluginPreloadService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.plugin.preload.IExpandPluginPreload;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;

class LebaQzoneAndPluginPart$12
  implements Runnable
{
  LebaQzoneAndPluginPart$12(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.a.getCurrentAccountUin();
    IWebProcessPreload localIWebProcessPreload = (IWebProcessPreload)QRoute.api(IWebProcessPreload.class);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (localIWebProcessPreload != null))
    {
      long l = localIWebProcessPreload.getBusinessClickTimeMills((String)localObject, "health");
      if (System.currentTimeMillis() - l < 604800000L) {
        localIWebProcessPreload.preParseDns(LebaQzoneAndPluginPart.k, "key_health_dns_parse");
      }
      l = localIWebProcessPreload.getBusinessClickTimeMills((String)localObject, "game_center");
      if (System.currentTimeMillis() - l < 259200000L) {
        localIWebProcessPreload.preParseDns(LebaQzoneAndPluginPart.l, "key_gamecenter_dns_parse");
      }
      l = localIWebProcessPreload.getBusinessClickTimeMills((String)localObject, "reader");
      if (System.currentTimeMillis() - l < 259200000L) {
        localIWebProcessPreload.preParseDns(LebaQzoneAndPluginPart.m, "key_reader_dns_parse");
      }
    }
    localObject = (IQQPluginPreloadService)this.a.getRuntimeService(IQQPluginPreloadService.class);
    if (localObject != null) {
      ((IQQPluginPreloadService)localObject).preload(6, 500);
    }
    ((IExpandPluginPreload)QRoute.api(IExpandPluginPreload.class)).preloadProcessIfPlugin(this.a, 100L);
    ThreadManager.post(new LebaQzoneAndPluginPart.12.1(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.12
 * JD-Core Version:    0.7.0.1
 */