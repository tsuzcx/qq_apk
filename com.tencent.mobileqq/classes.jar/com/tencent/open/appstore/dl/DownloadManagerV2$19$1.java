package com.tencent.open.appstore.dl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadConstants;

class DownloadManagerV2$19$1
  implements DialogInterface.OnClickListener
{
  DownloadManagerV2$19$1(DownloadManagerV2.19 param19) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidOsBundle.putBoolean(DownloadConstants.r, false);
    DownloadProxy.a().a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.a.jdField_a_of_type_Int);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.19.1
 * JD-Core Version:    0.7.0.1
 */