package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import aqlx;
import arab;
import arac;
import com.tencent.qphone.base.util.QLog;

public class QfavFilePreviewController$1$1
  implements Runnable
{
  public QfavFilePreviewController$1$1(arac paramarac, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool = true;
    arab.a(this.jdField_a_of_type_Arac.a, this.jdField_a_of_type_AndroidOsBundle.getInt("previewPort", 80));
    arab.a(this.jdField_a_of_type_Arac.a, this.jdField_a_of_type_AndroidOsBundle.getLong("previewCode", 0L));
    arab.a(this.jdField_a_of_type_Arac.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewUid"));
    arab.b(this.jdField_a_of_type_Arac.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewHost"));
    arab.c(this.jdField_a_of_type_Arac.a, this.jdField_a_of_type_AndroidOsBundle.getString("previewKey"));
    if (QLog.isColorLevel()) {
      QLog.i("QfavFilePreviewController", 2, "handleRemoteCmd: mHost=" + arab.a(this.jdField_a_of_type_Arac.a) + ", port=" + String.valueOf(arab.a(this.jdField_a_of_type_Arac.a)) + ", key=" + arab.b(this.jdField_a_of_type_Arac.a) + ", retCode =" + String.valueOf(arab.a(this.jdField_a_of_type_Arac.a)));
    }
    aqlx localaqlx;
    if (1 == arab.b(this.jdField_a_of_type_Arac.a))
    {
      localaqlx = this.jdField_a_of_type_Arac.a.a;
      if (0L != arab.a(this.jdField_a_of_type_Arac.a)) {
        break label321;
      }
    }
    for (;;)
    {
      localaqlx.a(bool, arab.a(this.jdField_a_of_type_Arac.a), String.valueOf(arab.a(this.jdField_a_of_type_Arac.a)), arab.a(this.jdField_a_of_type_Arac.a), null, arab.b(this.jdField_a_of_type_Arac.a), null, arab.c(this.jdField_a_of_type_Arac.a), null);
      arab.b(this.jdField_a_of_type_Arac.a, 3);
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