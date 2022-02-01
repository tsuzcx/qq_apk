package com.tencent.open.agent;

import android.text.TextUtils;
import bhdj;
import bjbu;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class BindGroupConfirmActivity$8
  implements Runnable
{
  BindGroupConfirmActivity$8(BindGroupConfirmActivity paramBindGroupConfirmActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      this.this$0.a = bhdj.a(this.this$0, 230);
    }
    if (!TextUtils.isEmpty(this.a)) {
      this.this$0.a.setMessage(this.a);
    }
    bjbu localbjbu = new bjbu(this);
    this.this$0.a.setTitle(2131719595);
    this.this$0.a.setPositiveButton(2131691037, localbjbu);
    this.this$0.a.setNegativeButton(2131690697, localbjbu);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.8
 * JD-Core Version:    0.7.0.1
 */