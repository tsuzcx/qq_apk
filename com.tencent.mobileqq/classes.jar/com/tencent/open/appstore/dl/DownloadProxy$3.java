package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;

class DownloadProxy$3
  implements Runnable
{
  DownloadProxy$3(DownloadProxy paramDownloadProxy, Bundle paramBundle, String paramString, int paramInt, Activity paramActivity, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[doDownloadAction] pParams=");
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
    LogUtility.b("DownloadResolver", ((StringBuilder)localObject1).toString());
    if (this.a == null)
    {
      LogUtility.b("DownloadResolver", "[doDownloadAction] pParams == null return");
      return;
    }
    DownloadManagerV2.a().b();
    this.a.getString(DownloadConstants.b);
    this.a.putString(DownloadConstants.t, this.b);
    this.a.putString("big_brother_source_key", this.b);
    this.a.putInt(DownloadConstants.G, 1);
    localObject1 = this.a.getString(DownloadConstants.D);
    String str = this.a.getString(DownloadConstants.i);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("0"))) {
      this.a.putString(DownloadConstants.D, "");
    }
    localObject2 = this.a.getString(DownloadConstants.j);
    ApkUpdateDetail localApkUpdateDetail = this.e;
    localObject1 = localObject2;
    if (localApkUpdateDetail != null)
    {
      localObject1 = localObject2;
      if (localApkUpdateDetail.updatemethod == 2)
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(this.e.url))
          {
            this.a.putString(DownloadConstants.j, this.e.url);
            localObject1 = this.e.url;
          }
        }
      }
    }
    localObject1 = DownloadManagerV2.a().b((String)localObject1);
    if ((localObject1 == null) && ("biz_src_yyb".equals(this.b)) && (ControlPolicyUtil.h()))
    {
      int i = this.a.getInt(DownloadConstants.k);
      localObject2 = this.a.getString(DownloadConstants.f);
      if ((i == 5) && ("com.tencent.android.qqdownloader".equals(localObject2))) {
        DownloadProxy.a(this.a);
      }
    }
    else if ((localObject1 != null) && (!TextUtils.isEmpty(str)))
    {
      ((DownloadInfo)localObject1).h = str;
    }
    if (DownloadProxy.a(this.a))
    {
      LogUtility.a("DownloadResolver", "[doDownloadAction] installApp");
      return;
    }
    if (this.a.getInt(DownloadConstants.k) == 5) {
      this.a.putInt(DownloadConstants.k, 2);
    }
    if (this.c == 0)
    {
      if ((localObject1 != null) && (((DownloadInfo)localObject1).o == 1))
      {
        DownloadProxy.a(this.this$0, this.d, this.a, this.b, this.e, this.c);
        return;
      }
      boolean bool3 = APNUtil.k(CommonDataAdapter.a().b());
      boolean bool4 = APNUtil.j(CommonDataAdapter.a().b());
      if ((localObject1 != null) && (((DownloadInfo)localObject1).a() != 1)) {
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
      LogUtility.a("DownloadResolver", ((StringBuilder)localObject1).toString());
      if ((bool3) && (!bool2) && (!bool4) && (bool1) && (this.a.getBoolean(DownloadConstants.s)))
      {
        DownloadManagerV2.a().a(this.d, this.a, this.b, this.e, this.c);
        return;
      }
      DownloadProxy.a(this.this$0, this.a, this.b, this.e);
      return;
    }
    if ((localObject1 != null) && (((DownloadInfo)localObject1).o != 1))
    {
      DownloadProxy.a(this.this$0, this.a, this.b, this.e);
      return;
    }
    DownloadProxy.a(this.this$0, this.d, this.a, this.b, this.e, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadProxy.3
 * JD-Core Version:    0.7.0.1
 */