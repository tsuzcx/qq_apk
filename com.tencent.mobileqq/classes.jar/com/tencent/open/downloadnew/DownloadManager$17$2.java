package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class DownloadManager$17$2
  implements DialogInterface.OnClickListener
{
  DownloadManager$17$2(DownloadManager.17 param17) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.b);
      String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.j);
      String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.f);
      String str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i);
      String str4 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.l);
      boolean bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean(DownloadConstants.z, true);
      paramDialogInterface = new DownloadInfo(paramDialogInterface, str1.trim(), str2, str4, str3, null, this.a.jdField_a_of_type_JavaLangString, bool);
      this.a.this$0.a(10, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.17.2
 * JD-Core Version:    0.7.0.1
 */