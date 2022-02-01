package com.tencent.open.downloadnew.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcircle.st.AppCircleReportManager;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

class DownloadReceiver$1
  implements Runnable
{
  DownloadReceiver$1(DownloadReceiver paramDownloadReceiver, String paramString1, String paramString2, NoticeParam paramNoticeParam, String paramString3, String paramString4, Context paramContext) {}
  
  public void run()
  {
    Object localObject2 = DownloadManager.b().d(this.a);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = DownloadManager.b().f(this.b);
    }
    if (localObject1 == null)
    {
      boolean bool;
      if ((this.c.d != null) && (!this.c.d.trim().equals(""))) {
        bool = true;
      } else {
        bool = false;
      }
      localObject2 = new DownloadInfo(this.a, this.c.e, this.c.d, this.c.b, this.c.k, this.c.j, "biz_src_yyb", bool);
    }
    else
    {
      if (TextUtils.isEmpty(((DownloadInfo)localObject1).d)) {
        localObject2 = this.c.e;
      } else {
        localObject2 = ((DownloadInfo)localObject1).d;
      }
      ((DownloadInfo)localObject1).d = ((String)localObject2);
      if (TextUtils.isEmpty(((DownloadInfo)localObject1).e)) {
        localObject2 = this.c.d;
      } else {
        localObject2 = ((DownloadInfo)localObject1).e;
      }
      ((DownloadInfo)localObject1).e = ((String)localObject2);
      if (TextUtils.isEmpty(((DownloadInfo)localObject1).h)) {
        localObject2 = this.c.k;
      } else {
        localObject2 = ((DownloadInfo)localObject1).h;
      }
      ((DownloadInfo)localObject1).h = ((String)localObject2);
      if (TextUtils.isEmpty(((DownloadInfo)localObject1).f)) {
        localObject2 = this.c.b;
      } else {
        localObject2 = ((DownloadInfo)localObject1).f;
      }
      ((DownloadInfo)localObject1).f = ((String)localObject2);
      localObject2 = localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(IntentFactory.b);
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(this.d);
    if (((StringBuilder)localObject1).toString().equals(this.e))
    {
      localObject1 = DownloadManager.b().d(this.a);
      if ((localObject1 != null) && ((((DownloadInfo)localObject1).a() == 2) || (((DownloadInfo)localObject1).a() == 20)))
      {
        ((DownloadInfo)localObject2).a(3);
        DownloadManager.b().a(3, (DownloadInfo)localObject2);
      }
      DownloadManager.b().g(((DownloadInfo)localObject2).c);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(IntentFactory.a);
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(this.d);
    if (((StringBuilder)localObject1).toString().equals(this.e))
    {
      DownloadManager.b().a((DownloadInfo)localObject2);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(IntentFactory.c);
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(this.d);
    if (((StringBuilder)localObject1).toString().equals(this.e))
    {
      DownloadManager.b().a((DownloadInfo)localObject2);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(IntentFactory.d);
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(this.d);
    if (((StringBuilder)localObject1).toString().equals(this.e))
    {
      AppUtil.a(this.f, DownloadManager.b().b(this.a), DownloadManager.b().c(this.a), ((DownloadInfo)localObject2).a("big_brother_ref_source_key"), ((DownloadInfo)localObject2).a("hideInstallSuccessPage"));
      AppCircleReportManager.a().a(100, (DownloadInfo)localObject2);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(IntentFactory.f);
    ((StringBuilder)localObject1).append(".");
    ((StringBuilder)localObject1).append(this.d);
    if (((StringBuilder)localObject1).toString().equals(this.e))
    {
      if ((MyAppApi.l().p()) && (localObject2 != null) && (((DownloadInfo)localObject2).o == 1))
      {
        if (this.c.j == null) {
          localObject1 = new Bundle();
        } else {
          localObject1 = this.c.j.getExtras();
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Bundle();
        }
        ((Bundle)localObject3).putString(DownloadConstants.b, ((DownloadInfo)localObject2).c);
        ((Bundle)localObject3).putString(DownloadConstants.c, ((DownloadInfo)localObject2).l);
        ((Bundle)localObject3).putString(DownloadConstants.d, ((DownloadInfo)localObject2).m);
        ((Bundle)localObject3).putString(DownloadConstants.f, ((DownloadInfo)localObject2).e);
        ((Bundle)localObject3).putInt(DownloadConstants.e, ((DownloadInfo)localObject2).n);
        MyAppApi.l().a(this.f.getApplicationContext(), (Bundle)localObject3, true, true);
        return;
      }
      Object localObject3 = new Intent();
      if (this.c.j == null) {
        localObject1 = new Bundle();
      } else {
        localObject1 = this.c.j.getExtras();
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Intent)localObject3).putExtras((Bundle)localObject2);
      ((Intent)localObject3).setClass(CommonDataAdapter.a().b(), QZoneAppListActivity.class);
      ((Intent)localObject3).putExtra("goto_type", 2);
      ((Intent)localObject3).addFlags(872415232);
      this.f.startActivity((Intent)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadReceiver.1
 * JD-Core Version:    0.7.0.1
 */