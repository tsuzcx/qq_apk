package com.tencent.open.agent;

import android.text.TextUtils;
import bdgm;
import bdjz;
import bfdg;

public class BindGroupConfirmActivity$8
  implements Runnable
{
  BindGroupConfirmActivity$8(BindGroupConfirmActivity paramBindGroupConfirmActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      this.this$0.a = bdgm.a(this.this$0, 230);
    }
    if (!TextUtils.isEmpty(this.a)) {
      this.this$0.a.setMessage(this.a);
    }
    bfdg localbfdg = new bfdg(this);
    this.this$0.a.setTitle(2131721029);
    this.this$0.a.setPositiveButton(2131691089, localbfdg);
    this.this$0.a.setNegativeButton(2131690648, localbfdg);
    if (!this.this$0.a.isShowing()) {
      this.this$0.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.8
 * JD-Core Version:    0.7.0.1
 */