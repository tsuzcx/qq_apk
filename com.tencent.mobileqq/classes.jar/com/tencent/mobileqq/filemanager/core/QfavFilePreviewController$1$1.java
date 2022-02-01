package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import asyq;
import atpa;
import atpb;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(atpb paramatpb, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    atpa.a(this.jdField_a_of_type_Atpb.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    atpa.a(this.jdField_a_of_type_Atpb.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    atpa.a(this.jdField_a_of_type_Atpb.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    atpa.b(this.jdField_a_of_type_Atpb.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    atpa.c(this.jdField_a_of_type_Atpb.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + atpa.a(this.jdField_a_of_type_Atpb.a) + ", port=" + String.valueOf(atpa.a(this.jdField_a_of_type_Atpb.a)) + ", key=" + atpa.b(this.jdField_a_of_type_Atpb.a) + ", retCode =" + String.valueOf(atpa.a(this.jdField_a_of_type_Atpb.a)));
    }
    asyq localasyq;
    if (1 == atpa.b(this.jdField_a_of_type_Atpb.a))
    {
      localasyq = this.jdField_a_of_type_Atpb.a.a;
      if (0L != atpa.a(this.jdField_a_of_type_Atpb.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localasyq.a(bool, atpa.a(this.jdField_a_of_type_Atpb.a), String.valueOf(atpa.a(this.jdField_a_of_type_Atpb.a)), atpa.a(this.jdField_a_of_type_Atpb.a), null, atpa.b(this.jdField_a_of_type_Atpb.a), null, atpa.c(this.jdField_a_of_type_Atpb.a), null);
      atpa.b(this.jdField_a_of_type_Atpb.a, 3);
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