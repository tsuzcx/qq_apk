package com.tencent.open.appcommon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

final class AppClient$1
  implements Runnable
{
  AppClient$1(String paramString1, Bundle paramBundle1, String paramString2, Activity paramActivity, Intent paramIntent, Bundle paramBundle2) {}
  
  public void run()
  {
    if (MyAppApi.l().p())
    {
      Object localObject = DownloadManager.b().d(this.a);
      if (localObject != null)
      {
        if (((DownloadInfo)localObject).o == 1)
        {
          this.b.putString(DownloadConstants.b, ((DownloadInfo)localObject).c);
          this.b.putString(DownloadConstants.c, ((DownloadInfo)localObject).l);
          this.b.putString(DownloadConstants.d, ((DownloadInfo)localObject).m);
          this.b.putString(DownloadConstants.i, this.c);
          this.b.putString(DownloadConstants.f, ((DownloadInfo)localObject).e);
          this.b.putInt(DownloadConstants.e, ((DownloadInfo)localObject).n);
          MyAppApi.l().a(this.d, this.b, false, false);
          return;
        }
        this.d.startActivityForResult(this.e, 200);
        return;
      }
      localObject = this.f;
      if ((localObject != null) && (((Bundle)localObject).containsKey(DownloadConstants.f)))
      {
        this.b.putAll(this.f);
        MyAppApi.l().a(this.d, this.b, false, false);
        return;
      }
      this.d.startActivityForResult(this.e, 200);
      return;
    }
    this.d.startActivityForResult(this.e, 200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient.1
 * JD-Core Version:    0.7.0.1
 */