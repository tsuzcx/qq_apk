package com.tencent.open.appcommon.now.download.local;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;

class DownloadNativeApi$1
  implements Runnable
{
  DownloadNativeApi$1(DownloadNativeApi paramDownloadNativeApi, DownloadInfo paramDownloadInfo, DownloadTaskInfo paramDownloadTaskInfo, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new DownloadNativeApi.1.1(this);
    DownloadNativeApi.1.2 local2 = new DownloadNativeApi.1.2(this);
    LogUtility.b("DownloadNativeApi", "dialog create and show");
    localObject = new AlertDialog.Builder(this.c).setMessage(this.c.getString(2131888265)).setPositiveButton(2131888263, local2).setNegativeButton(2131888264, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.c.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1
 * JD-Core Version:    0.7.0.1
 */