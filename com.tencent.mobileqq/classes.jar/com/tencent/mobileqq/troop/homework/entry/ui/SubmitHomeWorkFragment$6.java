package com.tencent.mobileqq.troop.homework.entry.ui;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;

class SubmitHomeWorkFragment$6
  implements Runnable
{
  SubmitHomeWorkFragment$6(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ((SubmitHomeWorkFragment)localObject).b(((SubmitHomeWorkFragment)localObject).a);
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "弹起键盘");
    }
    if (localObject != null) {
      InputMethodUtil.a((View)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment.6
 * JD-Core Version:    0.7.0.1
 */