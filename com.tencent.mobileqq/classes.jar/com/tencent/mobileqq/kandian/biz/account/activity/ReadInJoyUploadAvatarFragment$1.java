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
    this.this$0.b = new ProgressDialog(this.a, 2131953338);
    this.this$0.b.setCancelable(true);
    this.this$0.b.show();
    this.this$0.b.setContentView(2131625585);
    ((TextView)this.this$0.b.findViewById(2131440191)).setText(HardCodeUtil.a(2131910468));
    this.this$0.b.setOnCancelListener(new ReadInJoyUploadAvatarFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.activity.ReadInJoyUploadAvatarFragment.1
 * JD-Core Version:    0.7.0.1
 */