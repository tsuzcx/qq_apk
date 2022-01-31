package com.tencent.open.agent;

import android.text.TextUtils;
import bdcd;
import bdfq;
import beyx;

public class BindGroupConfirmActivity$8
  implements Runnable
{
  BindGroupConfirmActivity$8(BindGroupConfirmActivity paramBindGroupConfirmActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      this.this$0.a = bdcd.a(this.this$0, 230);
    }
    if (!TextUtils.isEmpty(this.a)) {
      this.this$0.a.setMessage(this.a);
    }
    beyx localbeyx = new beyx(this);
    this.this$0.a.setTitle(2131721017);
    this.this$0.a.setPositiveButton(2131691088, localbeyx);
    this.this$0.a.setNegativeButton(2131690648, localbeyx);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.8
 * JD-Core Version:    0.7.0.1
 */