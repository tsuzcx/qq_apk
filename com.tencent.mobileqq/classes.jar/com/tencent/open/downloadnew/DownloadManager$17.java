package com.tencent.open.downloadnew;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;

class DownloadManager$17
  implements Runnable
{
  DownloadManager$17(DownloadManager paramDownloadManager, Bundle paramBundle, Activity paramActivity, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt) {}
  
  public void run()
  {
    Object localObject = new DownloadManager.17.1(this);
    DownloadManager.17.2 local2 = new DownloadManager.17.2(this);
    LogUtility.b("DownloadManager_", "dialog create and show");
    localObject = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131691388)).setPositiveButton(2131691386, local2).setNegativeButton(2131691387, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.17
 * JD-Core Version:    0.7.0.1
 */