package com.tencent.open.agent;

import bjbs;
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
    this.this$0.c = true;
    this.this$0.b.hide();
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.3
 * JD-Core Version:    0.7.0.1
 */