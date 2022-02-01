package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import atib;
import atyk;
import atyl;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(atyl paramatyl, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    atyk.a(this.jdField_a_of_type_Atyl.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    atyk.a(this.jdField_a_of_type_Atyl.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    atyk.a(this.jdField_a_of_type_Atyl.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    atyk.b(this.jdField_a_of_type_Atyl.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    atyk.c(this.jdField_a_of_type_Atyl.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + atyk.a(this.jdField_a_of_type_Atyl.a) + ", port=" + String.valueOf(atyk.a(this.jdField_a_of_type_Atyl.a)) + ", key=" + atyk.b(this.jdField_a_of_type_Atyl.a) + ", retCode =" + String.valueOf(atyk.a(this.jdField_a_of_type_Atyl.a)));
    }
    atib localatib;
    if (1 == atyk.b(this.jdField_a_of_type_Atyl.a))
    {
      localatib = this.jdField_a_of_type_Atyl.a.a;
      if (0L != atyk.a(this.jdField_a_of_type_Atyl.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localatib.a(bool, atyk.a(this.jdField_a_of_type_Atyl.a), String.valueOf(atyk.a(this.jdField_a_of_type_Atyl.a)), atyk.a(this.jdField_a_of_type_Atyl.a), null, atyk.b(this.jdField_a_of_type_Atyl.a), null, atyk.c(this.jdField_a_of_type_Atyl.a), null);
      atyk.b(this.jdField_a_of_type_Atyl.a, 3);
      return;
      label321:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1.1
 * JD-Core Version:    0.7.0.1
 */