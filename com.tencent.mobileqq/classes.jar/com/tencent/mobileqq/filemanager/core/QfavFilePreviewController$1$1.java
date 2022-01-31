package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import aooq;
import apcu;
import apcv;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(apcv paramapcv, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    apcu.a(this.jdField_a_of_type_Apcv.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    apcu.a(this.jdField_a_of_type_Apcv.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    apcu.a(this.jdField_a_of_type_Apcv.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    apcu.b(this.jdField_a_of_type_Apcv.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    apcu.c(this.jdField_a_of_type_Apcv.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + apcu.a(this.jdField_a_of_type_Apcv.a) + ", port=" + String.valueOf(apcu.a(this.jdField_a_of_type_Apcv.a)) + ", key=" + apcu.b(this.jdField_a_of_type_Apcv.a) + ", retCode =" + String.valueOf(apcu.a(this.jdField_a_of_type_Apcv.a)));
    }
    aooq localaooq;
    if (1 == apcu.b(this.jdField_a_of_type_Apcv.a))
    {
      localaooq = this.jdField_a_of_type_Apcv.a.a;
      if (0L != apcu.a(this.jdField_a_of_type_Apcv.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localaooq.a(bool, apcu.a(this.jdField_a_of_type_Apcv.a), String.valueOf(apcu.a(this.jdField_a_of_type_Apcv.a)), apcu.a(this.jdField_a_of_type_Apcv.a), null, apcu.b(this.jdField_a_of_type_Apcv.a), null, apcu.c(this.jdField_a_of_type_Apcv.a), null);
      apcu.b(this.jdField_a_of_type_Apcv.a, 3);
      return;
      label321:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1.1
 * JD-Core Version:    0.7.0.1
 */