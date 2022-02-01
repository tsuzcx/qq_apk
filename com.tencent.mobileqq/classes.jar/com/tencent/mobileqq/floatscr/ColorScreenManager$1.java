package com.tencent.mobileqq.floatscr;

import auvw;
import auvx;
import bhzw;
import com.tencent.qphone.base.util.QLog;

public class ColorScreenManager$1
  implements Runnable
{
  public ColorScreenManager$1(auvx paramauvx, int paramInt, bhzw parambhzw) {}
  
  public void run()
  {
    String str = "colorScreen.android." + this.jdField_a_of_type_Int;
    this.this$0.a(str, this.jdField_a_of_type_Bhzw, null);
    auvw localauvw = this.this$0.a(this.jdField_a_of_type_Int);
    if (localauvw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 1, "getLocalConfig return null, go to download");
      }
      this.this$0.a(this.jdField_a_of_type_Int);
      return;
    }
    this.this$0.a(str, localauvw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.floatscr.ColorScreenManager.1
 * JD-Core Version:    0.7.0.1
 */