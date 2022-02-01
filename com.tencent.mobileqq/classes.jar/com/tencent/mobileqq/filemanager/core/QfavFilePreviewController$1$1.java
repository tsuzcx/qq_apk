package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import asrx;
import atgq;
import atgr;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(atgr paramatgr, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    atgq.a(this.jdField_a_of_type_Atgr.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    atgq.a(this.jdField_a_of_type_Atgr.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    atgq.a(this.jdField_a_of_type_Atgr.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    atgq.b(this.jdField_a_of_type_Atgr.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    atgq.c(this.jdField_a_of_type_Atgr.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + atgq.a(this.jdField_a_of_type_Atgr.a) + ", port=" + String.valueOf(atgq.a(this.jdField_a_of_type_Atgr.a)) + ", key=" + atgq.b(this.jdField_a_of_type_Atgr.a) + ", retCode =" + String.valueOf(atgq.a(this.jdField_a_of_type_Atgr.a)));
    }
    asrx localasrx;
    if (1 == atgq.b(this.jdField_a_of_type_Atgr.a))
    {
      localasrx = this.jdField_a_of_type_Atgr.a.a;
      if (0L != atgq.a(this.jdField_a_of_type_Atgr.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localasrx.a(bool, atgq.a(this.jdField_a_of_type_Atgr.a), String.valueOf(atgq.a(this.jdField_a_of_type_Atgr.a)), atgq.a(this.jdField_a_of_type_Atgr.a), null, atgq.b(this.jdField_a_of_type_Atgr.a), null, atgq.c(this.jdField_a_of_type_Atgr.a), null);
      atgq.b(this.jdField_a_of_type_Atgr.a, 3);
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