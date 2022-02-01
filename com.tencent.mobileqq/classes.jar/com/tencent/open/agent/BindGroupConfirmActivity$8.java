package com.tencent.open.agent;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class BindGroupConfirmActivity$8
  implements Runnable
{
  BindGroupConfirmActivity$8(BindGroupConfirmActivity paramBindGroupConfirmActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      localObject = this.this$0;
      ((BindGroupConfirmActivity)localObject).a = DialogUtil.a((Context)localObject, 230);
    }
    if (!TextUtils.isEmpty(this.a)) {
      this.this$0.a.setMessage(this.a);
    }
    Object localObject = new BindGroupConfirmActivity.8.1(this);
    this.this$0.a.setTitle(2131719906);
    this.this$0.a.setPositiveButton(2131691064, (DialogInterface.OnClickListener)localObject);
    this.this$0.a.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.8
 * JD-Core Version:    0.7.0.1
 */