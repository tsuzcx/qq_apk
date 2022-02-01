package com.tencent.open.appcommon.now.download.local;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;

class DownloadNativeApi$1$1
  implements DialogInterface.OnClickListener
{
  DownloadNativeApi$1$1(DownloadNativeApi.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DownloadCenterImpl.a().a(this.a.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    DownloadNativeApi.a(this.a.this$0).a(this.a.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadTaskInfo);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1.1
 * JD-Core Version:    0.7.0.1
 */