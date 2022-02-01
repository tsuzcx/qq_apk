package com.tencent.mobileqq.screendetect;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class ScreenShotFragment$1
  implements ScreenShotAdapter.OnHolderItemClickListener
{
  ScreenShotFragment$1(ScreenShotFragment paramScreenShotFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotInnerAdapter OnItemClickListener : position = " + paramInt + ", view = " + paramView);
    }
    ScreenShotFragment.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.1
 * JD-Core Version:    0.7.0.1
 */