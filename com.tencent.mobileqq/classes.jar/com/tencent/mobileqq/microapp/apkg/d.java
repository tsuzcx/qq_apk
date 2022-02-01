package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import java.io.File;
import java.net.URLEncoder;
import java.util.LinkedList;

final class d
  implements ApkgConfigManager.a
{
  d(ApkgConfigManager paramApkgConfigManager, int paramInt, OnUpdateListener paramOnUpdateListener) {}
  
  public void onResult(int paramInt, MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2)
  {
    if ((paramInt == 0) && (this.a != paramMiniAppConfig.config.mini_version))
    {
      paramString1 = this.b;
      if (paramString1 != null) {
        paramString1.onCheckForUpdate(true);
      }
      if (new File(g.a(paramMiniAppConfig.config)).exists())
      {
        paramMiniAppConfig = this.b;
        if (paramMiniAppConfig != null) {
          paramMiniAppConfig.onUpdateSucc(true);
        }
      }
      else
      {
        paramString1 = g.a(paramMiniAppConfig.config);
        paramString2 = ManagerProxy.getPreloadManager(ApkgConfigManager.access$100(this.c));
        DownloadParam localDownloadParam = new DownloadParam();
        localDownloadParam.headers = new LinkedList();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMiniAppConfig.config.apkg_url);
        localStringBuilder.append("?sign=");
        localStringBuilder.append(URLEncoder.encode(paramMiniAppConfig.config.cos_sign));
        localDownloadParam.url = localStringBuilder.toString();
        paramString2.getResPath(localDownloadParam, new e(this, paramString1));
      }
    }
    else
    {
      paramMiniAppConfig = this.b;
      if (paramMiniAppConfig != null) {
        paramMiniAppConfig.onCheckForUpdate(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.d
 * JD-Core Version:    0.7.0.1
 */