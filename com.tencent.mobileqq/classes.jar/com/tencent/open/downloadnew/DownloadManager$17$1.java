package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class DownloadManager$17$1
  implements DialogInterface.OnClickListener
{
  DownloadManager$17$1(DownloadManager.17 param17) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidOsBundle.putBoolean(DownloadConstants.s, false);
    DownloadApi.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.a.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.17.1
 * JD-Core Version:    0.7.0.1
 */