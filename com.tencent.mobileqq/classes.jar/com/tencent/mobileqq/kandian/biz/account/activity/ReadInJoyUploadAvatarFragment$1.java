package com.tencent.mobileqq.kandian.biz.account.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

class ReadInJoyUploadAvatarFragment$1
  implements Runnable
{
  ReadInJoyUploadAvatarFragment$1(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, Activity paramActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.this$0.a = new ProgressDialog(this.a, 2131756189);
    this.this$0.a.setCancelable(true);
    this.this$0.a.show();
    this.this$0.a.setContentView(2131559561);
    ((TextView)this.this$0.a.findViewById(2131372646)).setText(HardCodeUtil.a(2131712898));
    this.this$0.a.setOnCancelListener(new ReadInJoyUploadAvatarFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment.1
 * JD-Core Version:    0.7.0.1
 */