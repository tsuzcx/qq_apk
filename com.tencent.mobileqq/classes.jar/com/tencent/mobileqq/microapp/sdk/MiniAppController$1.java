package com.tencent.mobileqq.microapp.sdk;

import Wallet.ApkgConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.g;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.LinkedList;
import mqq.app.AppRuntime;

final class MiniAppController$1
  implements Runnable
{
  MiniAppController$1(MiniAppConfig paramMiniAppConfig) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (!(localObject instanceof QQAppInterface)) || (this.val$miniConfig == null)) {}
    do
    {
      return;
      localObject = (QQAppInterface)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppController", 2, "preDownApkgResources start");
      }
      localObject = ManagerProxy.getPreloadManager((AppRuntime)localObject);
      localDownloadParam = new DownloadParam();
      localDownloadParam.filePos = 1;
      localDownloadParam.url = this.val$miniConfig.baseLibInfo.baseLibUrl;
      ((PreloadManager)localObject).a(localDownloadParam, null);
    } while (new File(g.a(this.val$miniConfig.config)).exists());
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.headers = new LinkedList();
    localDownloadParam.url = (this.val$miniConfig.config.apkg_url + "?sign=" + URLEncoder.encode(this.val$miniConfig.config.cos_sign));
    ((PreloadManager)localObject).a(localDownloadParam, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppController.1
 * JD-Core Version:    0.7.0.1
 */