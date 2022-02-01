package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;

public class MyAppApi$CopyAndInstallTask
  extends YybHandleUtil.InstallBaseTask
{
  MyAppApi.InstallParams a;
  
  public MyAppApi$CopyAndInstallTask(MyAppApi paramMyAppApi, Activity paramActivity, MyAppApi.InstallParams paramInstallParams)
  {
    super(paramActivity);
    this.a = paramInstallParams;
  }
  
  protected void a(Boolean paramBoolean)
  {
    a();
    if (paramBoolean.booleanValue())
    {
      if (YybHandleUtil.a())
      {
        Object localObject = this.b;
        ((MyAppApi)localObject).d = true;
        ((MyAppApi)localObject).e = false;
        long l = -1L;
        int i = this.a.e;
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 3) {
              l = this.b.a(this.a.a, this.a.b, this.a.c);
            } else {
              l = this.b.b(this.a.a);
            }
          }
          else
          {
            localObject = this.b;
            ((MyAppApi)localObject).p = true;
            if (((MyAppApi)localObject).q != null) {
              l = this.b.d().addDownloadTaskFromAuthorize(this.b.q, "2");
            } else {
              LogUtility.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
            }
          }
        }
        else {
          l = this.b.b(this.a.a, this.a.b, this.a.c);
        }
        localObject = this.b;
        ((MyAppApi)localObject).f = l;
        ((MyAppApi)localObject).g = System.currentTimeMillis();
        if ((paramBoolean.booleanValue()) && (this.a.a != null))
        {
          paramBoolean = StaticAnalyz.a(this.a.a.getString(DownloadConstants.i), "NEWYYB");
          StaticAnalyz.a("311", paramBoolean, this.a.a.getString(DownloadConstants.b));
          localObject = CommonDataAdapter.a().b();
          if (localObject != null) {
            StaticAnalyz.a((Context)localObject, "312", paramBoolean, this.a.a.getString(DownloadConstants.b));
          }
        }
        if ((this.b.k != null) && (this.b.k.isShowing())) {
          this.b.k.dismiss();
        }
      }
      else
      {
        if (this.a.d != null) {
          this.a.d.onClick(null, 0);
        }
        this.b.i = null;
      }
    }
    else
    {
      if (this.a.d != null) {
        this.a.d.onClick(null, 0);
      }
      this.b.i = null;
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.a.d != null) {
      this.a.d.onClick(null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.CopyAndInstallTask
 * JD-Core Version:    0.7.0.1
 */