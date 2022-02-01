package com.tencent.open.agent;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class BindGroupActivity$3
  implements Runnable
{
  BindGroupActivity$3(BindGroupActivity paramBindGroupActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onGetOpenId timeout.");
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    BindGroupActivity localBindGroupActivity = this.this$0;
    localBindGroupActivity.c = true;
    localBindGroupActivity.b.hide();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.3
 * JD-Core Version:    0.7.0.1
 */