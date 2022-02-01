package com.tencent.open.downloadnew;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;

final class DownloadApi$1
  implements Runnable
{
  DownloadApi$1(Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    Object localObject1 = DownloadApi.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doDownloadAction pParams=");
    ((StringBuilder)localObject2).append(this.a);
    ((StringBuilder)localObject2).append(" source=");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(" myAppConfig=");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append(" ac==null is");
    Object localObject3 = this.d;
    boolean bool2 = false;
    boolean bool1;
    if (localObject3 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject2).append(bool1);
    LogUtility.a((String)localObject1, ((StringBuilder)localObject2).toString());
    if (this.a == null)
    {
      LogUtility.e(DownloadApi.a, "doDownloadAction pParams == null return");
      return;
    }
    DownloadManager.b().a();
    localObject2 = this.a.getString(DownloadConstants.b);
    this.a.putString(DownloadConstants.t, this.b);
    this.a.putInt(DownloadConstants.G, 1);
    localObject3 = this.a.getString(DownloadConstants.D);
    localObject1 = this.a.getString(DownloadConstants.i);
    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (((String)localObject3).equals("0"))) {
      this.a.putString(DownloadConstants.D, "");
    }
    localObject2 = DownloadManager.b().d((String)localObject2);
    if ((localObject2 == null) && ("biz_src_yyb".equals(this.b)) && (ControlPolicyUtil.h()))
    {
      int i = this.a.getInt(DownloadConstants.k);
      localObject1 = this.a.getString(DownloadConstants.f);
      if ((i == 5) && (((String)localObject1).equals("com.tencent.android.qqdownloader"))) {
        DownloadApi.c(this.a);
      }
    }
    else if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ((DownloadInfo)localObject2).h = ((String)localObject1);
    }
    if (DownloadApi.c(this.a))
    {
      LogUtility.a(DownloadApi.a, "doDownloadAction installApp");
      return;
    }
    localObject1 = this.e;
    if ((localObject1 != null) && (((ApkUpdateDetail)localObject1).updatemethod == 2) && (TextUtils.isEmpty(this.a.getString(DownloadConstants.j))) && (!TextUtils.isEmpty(this.e.url))) {
      this.a.putString(DownloadConstants.j, this.e.url);
    }
    if (this.c == 0)
    {
      if ((localObject2 != null) && (((DownloadInfo)localObject2).o == 1))
      {
        DownloadApi.b(this.d, this.a, this.b, this.e, this.c);
        return;
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
      localObject1 = DownloadApi.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("check wifi dialog isWifiActive=");
      ((StringBuilder)localObject2).append(bool4);
      ((StringBuilder)localObject2).append(" isFirstDownload=");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" acIsNull=");
      ((StringBuilder)localObject2).append(bool2);
      LogUtility.a((String)localObject1, ((StringBuilder)localObject2).toString());
      if ((bool3) && (!bool2) && (!bool4) && (bool1) && (this.a.getBoolean(DownloadConstants.s)))
      {
        DownloadManager.b().a(this.d, this.a, this.b, this.e, this.c);
        return;
      }
      DownloadApi.a(this.a, this.b, this.e);
      return;
    }
    if ((localObject2 != null) && (((DownloadInfo)localObject2).o != 1))
    {
      DownloadApi.a(this.a, this.b, this.e);
      return;
    }
    DownloadApi.b(this.d, this.a, this.b, this.e, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.1
 * JD-Core Version:    0.7.0.1
 */