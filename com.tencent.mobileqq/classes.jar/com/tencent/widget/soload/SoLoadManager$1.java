package com.tencent.widget.soload;

import besc;
import besg;
import besi;
import com.tencent.qphone.base.util.QLog;

public class SoLoadManager$1
  implements Runnable
{
  public SoLoadManager$1(besi parambesi, besc parambesc, besg parambesg, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load time out, loadParam:" + this.jdField_a_of_type_Besc);
    }
    this.jdField_a_of_type_Besc.a = 0L;
    this.jdField_a_of_type_Besg.a(7, LoadExtResult.create(7, this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.soload.SoLoadManager.1
 * JD-Core Version:    0.7.0.1
 */