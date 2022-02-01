package com.tencent.mobileqq.leba.business.mainbiz;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import cooperation.comic.PluginPreloader;
import cooperation.comic.QQComicPreloadManager;
import cooperation.qqreader.QRProcessManager;

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
        localIWebProcessPreload.preParseDns(LebaQzoneAndPluginPart.a, "key_health_dns_parse");
      }
      l = localIWebProcessPreload.getBusinessClickTimeMills((String)localObject, "game_center");
      if (System.currentTimeMillis() - l < 259200000L) {
        localIWebProcessPreload.preParseDns(LebaQzoneAndPluginPart.b, "key_gamecenter_dns_parse");
      }
      l = localIWebProcessPreload.getBusinessClickTimeMills((String)localObject, "reader");
      if (System.currentTimeMillis() - l < 259200000L) {
        localIWebProcessPreload.preParseDns(LebaQzoneAndPluginPart.c, "key_reader_dns_parse");
      }
    }
    localObject = (QRProcessManager)this.a.getManager(QQManagerFactory.QR_PROCESS_MANAGER);
    if (localObject != null) {
      ((QRProcessManager)localObject).a(6);
    }
    localObject = (QQComicPreloadManager)this.a.getManager(QQManagerFactory.QQCOMIC_PRELOAD_MANAGER);
    if (localObject != null) {
      PluginPreloader.a(((QQComicPreloadManager)localObject).a(6), 500L);
    }
    ExtendFriendLabelUtils.a(this.a, 100L);
    ThreadManager.post(new LebaQzoneAndPluginPart.12.1(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.12
 * JD-Core Version:    0.7.0.1
 */