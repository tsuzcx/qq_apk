package com.tencent.mobileqq.troop.homework.entry.ui;

import android.widget.EditText;
import beex;
import com.tencent.qphone.base.util.QLog;

class PublishHomeWorkFragment$13
  implements Runnable
{
  PublishHomeWorkFragment$13(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void run()
  {
    EditText localEditText = this.this$0.a(this.this$0.a);
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "弹起键盘");
    }
    if (localEditText != null) {
      beex.a(localEditText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.13
 * JD-Core Version:    0.7.0.1
 */