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
    if (this.this$0.u == null)
    {
      localObject = this.this$0;
      ((BindGroupConfirmActivity)localObject).u = DialogUtil.a((Context)localObject, 230);
    }
    if (!TextUtils.isEmpty(this.a)) {
      this.this$0.u.setMessage(this.a);
    }
    Object localObject = new BindGroupConfirmActivity.8.1(this);
    this.this$0.u.setTitle(2131917511);
    this.this$0.u.setPositiveButton(2131888010, (DialogInterface.OnClickListener)localObject);
    this.this$0.u.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    if (!this.this$0.u.isShowing()) {
      this.this$0.u.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.8
 * JD-Core Version:    0.7.0.1
 */