package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import aruk;
import asku;
import askv;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(askv paramaskv, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    asku.a(this.jdField_a_of_type_Askv.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    asku.a(this.jdField_a_of_type_Askv.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    asku.a(this.jdField_a_of_type_Askv.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    asku.b(this.jdField_a_of_type_Askv.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    asku.c(this.jdField_a_of_type_Askv.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + asku.a(this.jdField_a_of_type_Askv.a) + ", port=" + String.valueOf(asku.a(this.jdField_a_of_type_Askv.a)) + ", key=" + asku.b(this.jdField_a_of_type_Askv.a) + ", retCode =" + String.valueOf(asku.a(this.jdField_a_of_type_Askv.a)));
    }
    aruk localaruk;
    if (1 == asku.b(this.jdField_a_of_type_Askv.a))
    {
      localaruk = this.jdField_a_of_type_Askv.a.a;
      if (0L != asku.a(this.jdField_a_of_type_Askv.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localaruk.a(bool, asku.a(this.jdField_a_of_type_Askv.a), String.valueOf(asku.a(this.jdField_a_of_type_Askv.a)), asku.a(this.jdField_a_of_type_Askv.a), null, asku.b(this.jdField_a_of_type_Askv.a), null, asku.c(this.jdField_a_of_type_Askv.a), null);
      asku.b(this.jdField_a_of_type_Askv.a, 3);
      return;
      label321:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.QfavFilePreviewController.1.1
 * JD-Core Version:    0.7.0.1
 */