package com.tencent.mobileqq.troop.homework.entry.ui;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;

class PublishHomeWorkFragment$15
  implements Runnable
{
  PublishHomeWorkFragment$15(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = ((PublishHomeWorkFragment)localObject).f(((PublishHomeWorkFragment)localObject).w);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "弹起键盘");
    }
    if (localObject != null) {
      InputMethodUtil.a((View)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.15
 * JD-Core Version:    0.7.0.1
 */