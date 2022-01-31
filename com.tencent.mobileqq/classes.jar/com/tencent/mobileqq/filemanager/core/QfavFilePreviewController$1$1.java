package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import aqho;
import aqvs;
import aqvt;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(aqvt paramaqvt, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    aqvs.a(this.jdField_a_of_type_Aqvt.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    aqvs.a(this.jdField_a_of_type_Aqvt.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    aqvs.a(this.jdField_a_of_type_Aqvt.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    aqvs.b(this.jdField_a_of_type_Aqvt.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    aqvs.c(this.jdField_a_of_type_Aqvt.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + aqvs.a(this.jdField_a_of_type_Aqvt.a) + ", port=" + String.valueOf(aqvs.a(this.jdField_a_of_type_Aqvt.a)) + ", key=" + aqvs.b(this.jdField_a_of_type_Aqvt.a) + ", retCode =" + String.valueOf(aqvs.a(this.jdField_a_of_type_Aqvt.a)));
    }
    aqho localaqho;
    if (1 == aqvs.b(this.jdField_a_of_type_Aqvt.a))
    {
      localaqho = this.jdField_a_of_type_Aqvt.a.a;
      if (0L != aqvs.a(this.jdField_a_of_type_Aqvt.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localaqho.a(bool, aqvs.a(this.jdField_a_of_type_Aqvt.a), String.valueOf(aqvs.a(this.jdField_a_of_type_Aqvt.a)), aqvs.a(this.jdField_a_of_type_Aqvt.a), null, aqvs.b(this.jdField_a_of_type_Aqvt.a), null, aqvs.c(this.jdField_a_of_type_Aqvt.a), null);
      aqvs.b(this.jdField_a_of_type_Aqvt.a, 3);
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