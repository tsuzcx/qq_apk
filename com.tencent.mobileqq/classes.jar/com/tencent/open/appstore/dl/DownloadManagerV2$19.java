package com.tencent.open.appstore.dl;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;

class DownloadManagerV2$19
  implements Runnable
{
  DownloadManagerV2$19(DownloadManagerV2 paramDownloadManagerV2, Bundle paramBundle, Activity paramActivity, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt) {}
  
  public void run()
  {
    Object localObject = new DownloadManagerV2.19.1(this);
    DownloadManagerV2.19.2 local2 = new DownloadManagerV2.19.2(this);
    LogUtility.b("DownloadManagerV2", "dialog create and show");
    localObject = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131691310)).setPositiveButton(2131691308, local2).setNegativeButton(2131691309, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.19
 * JD-Core Version:    0.7.0.1
 */