package com.tencent.open.agent;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class BindGroupConfirmActivity$8
  implements Runnable
{
  BindGroupConfirmActivity$8(BindGroupConfirmActivity paramBindGroupConfirmActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      this.this$0.a = DialogUtil.a(this.this$0, 230);
    }
    if (!TextUtils.isEmpty(this.a)) {
      this.this$0.a.setMessage(this.a);
    }
    BindGroupConfirmActivity.8.1 local1 = new BindGroupConfirmActivity.8.1(this);
    this.this$0.a.setTitle(2131720173);
    this.this$0.a.setPositiveButton(2131691144, local1);
    this.this$0.a.setNegativeButton(2131690800, local1);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.8
 * JD-Core Version:    0.7.0.1
 */