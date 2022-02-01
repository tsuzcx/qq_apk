package com.tencent.mobileqq.troop.homework.entry.ui;

import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;

class PublishHomeWorkFragment$17
  implements Runnable
{
  PublishHomeWorkFragment$17(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void run()
  {
    EditText localEditText = this.this$0.a(this.this$0.a);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "弹起键盘");
    }
    if (localEditText != null) {
      InputMethodUtil.a(localEditText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.17
 * JD-Core Version:    0.7.0.1
 */