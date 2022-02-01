package com.tencent.mobileqq.floatscr;

import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.qphone.base.util.QLog;

class ColorScreenManager$1
  implements Runnable
{
  ColorScreenManager$1(ColorScreenManager paramColorScreenManager, int paramInt, VasManager.CompleteListener paramCompleteListener) {}
  
  public void run()
  {
    String str = "colorScreen.android." + this.jdField_a_of_type_Int;
    this.this$0.a(str, this.jdField_a_of_type_ComTencentMobileqqVasVasManager$CompleteListener, null);
    ColorScreenConfig localColorScreenConfig = this.this$0.a(this.jdField_a_of_type_Int);
    if (localColorScreenConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 1, "getLocalConfig return null, go to download");
      }
      this.this$0.a(this.jdField_a_of_type_Int);
      return;
    }
    this.this$0.a(str, localColorScreenConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.floatscr.ColorScreenManager.1
 * JD-Core Version:    0.7.0.1
 */