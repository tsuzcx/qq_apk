package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import aool;
import apcq;
import apcr;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(apcr paramapcr, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    apcq.a(this.jdField_a_of_type_Apcr.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    apcq.a(this.jdField_a_of_type_Apcr.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    apcq.a(this.jdField_a_of_type_Apcr.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    apcq.b(this.jdField_a_of_type_Apcr.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    apcq.c(this.jdField_a_of_type_Apcr.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + apcq.a(this.jdField_a_of_type_Apcr.a) + ", port=" + String.valueOf(apcq.a(this.jdField_a_of_type_Apcr.a)) + ", key=" + apcq.b(this.jdField_a_of_type_Apcr.a) + ", retCode =" + String.valueOf(apcq.a(this.jdField_a_of_type_Apcr.a)));
    }
    aool localaool;
    if (1 == apcq.b(this.jdField_a_of_type_Apcr.a))
    {
      localaool = this.jdField_a_of_type_Apcr.a.a;
      if (0L != apcq.a(this.jdField_a_of_type_Apcr.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localaool.a(bool, apcq.a(this.jdField_a_of_type_Apcr.a), String.valueOf(apcq.a(this.jdField_a_of_type_Apcr.a)), apcq.a(this.jdField_a_of_type_Apcr.a), null, apcq.b(this.jdField_a_of_type_Apcr.a), null, apcq.c(this.jdField_a_of_type_Apcr.a), null);
      apcq.b(this.jdField_a_of_type_Apcr.a, 3);
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