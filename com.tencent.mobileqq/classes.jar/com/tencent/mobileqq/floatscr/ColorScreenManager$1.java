package com.tencent.mobileqq.floatscr;

import auml;
import aumm;
import bhpa;
import com.tencent.qphone.base.util.QLog;

public class ColorScreenManager$1
  implements Runnable
{
  public ColorScreenManager$1(aumm paramaumm, int paramInt, bhpa parambhpa) {}
  
  public void run()
  {
    String str = "colorScreen.android." + this.jdField_a_of_type_Int;
    this.this$0.a(str, this.jdField_a_of_type_Bhpa, null);
    auml localauml = this.this$0.a(this.jdField_a_of_type_Int);
    if (localauml == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 1, "getLocalConfig return null, go to download");
      }
      this.this$0.a(this.jdField_a_of_type_Int);
      return;
    }
    this.this$0.a(str, localauml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.floatscr.ColorScreenManager.1
 * JD-Core Version:    0.7.0.1
 */