package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import anxs;
import aolw;
import aolx;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(aolx paramaolx, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    aolw.a(this.jdField_a_of_type_Aolx.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    aolw.a(this.jdField_a_of_type_Aolx.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    aolw.a(this.jdField_a_of_type_Aolx.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    aolw.b(this.jdField_a_of_type_Aolx.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    aolw.c(this.jdField_a_of_type_Aolx.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + aolw.a(this.jdField_a_of_type_Aolx.a) + ", port=" + String.valueOf(aolw.a(this.jdField_a_of_type_Aolx.a)) + ", key=" + aolw.b(this.jdField_a_of_type_Aolx.a) + ", retCode =" + String.valueOf(aolw.a(this.jdField_a_of_type_Aolx.a)));
    }
    anxs localanxs;
    if (1 == aolw.b(this.jdField_a_of_type_Aolx.a))
    {
      localanxs = this.jdField_a_of_type_Aolx.a.a;
      if (0L != aolw.a(this.jdField_a_of_type_Aolx.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localanxs.a(bool, aolw.a(this.jdField_a_of_type_Aolx.a), String.valueOf(aolw.a(this.jdField_a_of_type_Aolx.a)), aolw.a(this.jdField_a_of_type_Aolx.a), null, aolw.b(this.jdField_a_of_type_Aolx.a), null, aolw.c(this.jdField_a_of_type_Aolx.a), null);
      aolw.b(this.jdField_a_of_type_Aolx.a, 3);
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