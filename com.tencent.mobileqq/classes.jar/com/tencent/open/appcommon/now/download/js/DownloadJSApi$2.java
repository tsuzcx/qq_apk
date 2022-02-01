package com.tencent.open.appcommon.now.download.js;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;

final class DownloadJSApi$2
  implements Runnable
{
  DownloadJSApi$2(Bundle paramBundle, Activity paramActivity, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt) {}
  
  public void run()
  {
    Object localObject = new DownloadJSApi.2.1(this);
    DownloadJSApi.2.2 local2 = new DownloadJSApi.2.2(this);
    LogUtility.b("DownloadJSApi", "dialog create and show");
    localObject = new AlertDialog.Builder(this.b).setMessage(this.b.getString(2131888265)).setPositiveButton(2131888263, local2).setNegativeButton(2131888264, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.b.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadJSApi.2
 * JD-Core Version:    0.7.0.1
 */