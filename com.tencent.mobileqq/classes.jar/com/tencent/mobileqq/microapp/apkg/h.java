package com.tencent.mobileqq.microapp.apkg;

import agph;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.microapp.sdk.BaseLibInfo;
import com.tencent.qphone.base.util.QLog;

final class h
  extends g.a
{
  h(g paramg, int paramInt, MiniAppConfig paramMiniAppConfig)
  {
    super(paramInt);
  }
  
  public void a(g.d paramd)
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.a.baseLibInfo.baseLibUrl)) && (!TextUtils.isEmpty(this.a.baseLibInfo.baseLibKey)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApkgManager", 2, "initApkgByConfig - base lib is not ready");
      }
      long l = System.currentTimeMillis();
      agph localagph = agph.a(BaseApplicationImpl.getApplication().getRuntime());
      DownloadParam localDownloadParam = new DownloadParam();
      localDownloadParam.filePos = 1;
      localDownloadParam.url = this.a.baseLibInfo.baseLibUrl;
      localagph.a(localDownloadParam, new i(this, paramd, l));
      return;
    }
    g.a(this.b, paramd, 1, null, "miniConfig not valid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.h
 * JD-Core Version:    0.7.0.1
 */