package com.tencent.qqmini.sdk.ui;

import android.os.Build.VERSION;
import org.json.JSONArray;

class PhoneNumberManagementFragment$3$1$1
  implements Runnable
{
  PhoneNumberManagementFragment$3$1$1(PhoneNumberManagementFragment.3.1 param1) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      PhoneNumberManagementFragment.access$000(this.this$2.this$1.this$0).remove(this.this$2.this$1.val$position);
      PhoneNumberManagementFragment.access$100(this.this$2.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.PhoneNumberManagementFragment.3.1.1
 * JD-Core Version:    0.7.0.1
 */