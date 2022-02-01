package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

final class DownloadJSApi$1
  implements Runnable
{
  DownloadJSApi$1(Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("doDownloadAction pParams=");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(" source=");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(" myAppConfig=");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append(" ac==null is");
    Object localObject2 = this.d;
    boolean bool2 = false;
    boolean bool1;
    if (localObject2 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject1).append(bool1);
    LogUtility.a("DownloadJSApi", ((StringBuilder)localObject1).toString());
    localObject1 = this.a;
    if (localObject1 == null)
    {
      LogUtility.e("DownloadJSApi", "doDownloadAction pParams == null return");
      return;
    }
    localObject2 = ((Bundle)localObject1).getString(DownloadConstants.b);
    this.a.putString(DownloadConstants.t, this.b);
    this.a.putInt(DownloadConstants.G, 1);
    String str = this.a.getString(DownloadConstants.D);
    localObject1 = this.a.getString(DownloadConstants.i);
    if ((TextUtils.isEmpty(str)) || (str.equals("0"))) {
      this.a.putString(DownloadConstants.D, "");
    }
    localObject2 = DownloadManager.b().d((String)localObject2);
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      ((DownloadInfo)localObject2).h = ((String)localObject1);
    }
    localObject1 = this.e;
    if ((localObject1 != null) && (((ApkUpdateDetail)localObject1).updatemethod == 2) && (TextUtils.isEmpty(this.a.getString(DownloadConstants.j))) && (!TextUtils.isEmpty(this.e.url))) {
      this.a.putString(DownloadConstants.j, this.e.url);
    }
    boolean bool3 = APNUtil.k(CommonDataAdapter.a().b());
    boolean bool4 = APNUtil.j(CommonDataAdapter.a().b());
    if ((localObject2 != null) && (((DownloadInfo)localObject2).a() != 1)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (this.d == null) {
      bool2 = true;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("check wifi dialog isWifiActive=");
    ((StringBuilder)localObject1).append(bool4);
    ((StringBuilder)localObject1).append(" isFirstDownload=");
    ((StringBuilder)localObject1).append(bool1);
    ((StringBuilder)localObject1).append(" acIsNull=");
    ((StringBuilder)localObject1).append(bool2);
    LogUtility.a("DownloadJSApi", ((StringBuilder)localObject1).toString());
    if ((bool3) && (!bool2) && (!bool4) && (bool1) && (this.a.getBoolean(DownloadConstants.s)))
    {
      DownloadJSApi.b(this.d, this.a, this.b, this.e, this.c);
      return;
    }
    DownloadJSApi.a(this.a, this.b, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi.1
 * JD-Core Version:    0.7.0.1
 */