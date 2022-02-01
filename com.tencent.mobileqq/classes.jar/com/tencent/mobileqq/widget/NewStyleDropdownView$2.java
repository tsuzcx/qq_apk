package com.tencent.mobileqq.widget;

import com.tencent.qphone.base.util.QLog;

class NewStyleDropdownView$2
  implements Runnable
{
  NewStyleDropdownView$2(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "onDismiss arrow postDelayed 500 run and set isLastDropDown false");
    }
    this.this$0.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.2
 * JD-Core Version:    0.7.0.1
 */