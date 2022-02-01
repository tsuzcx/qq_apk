package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class NewStyleDropdownView$1$1
  implements Runnable
{
  NewStyleDropdownView$1$1(NewStyleDropdownView.1 param1, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "arrow clicked and postDelayed 250 run, set icon up and isLastDropDown true");
    }
    ((ImageView)this.a).setImageDrawable(this.b.a.c);
    if (this.b.a.f != null) {
      this.b.a.f.d();
    }
    this.b.a.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.1.1
 * JD-Core Version:    0.7.0.1
 */