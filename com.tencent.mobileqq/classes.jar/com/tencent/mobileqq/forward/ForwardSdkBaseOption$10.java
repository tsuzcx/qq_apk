package com.tencent.mobileqq.forward;

import android.app.Activity;
import com.tencent.biz.widgets.ShareResultDialog.IShareResultCallback;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.open.business.base.Constants;

class ForwardSdkBaseOption$10
  implements ShareResultDialog.IShareResultCallback
{
  ForwardSdkBaseOption$10(ForwardSdkBaseOption paramForwardSdkBaseOption) {}
  
  public void a(boolean paramBoolean)
  {
    if (ForwardRecentActivity.class.isInstance(this.a.a))
    {
      if (!this.a.a.isFinishing()) {
        if (paramBoolean) {
          this.a.a(0, "", "");
        } else {
          this.a.a(-1, Constants.d, Constants.d);
        }
      }
      if (this.a.l) {
        ForwardSdkBaseOption.a(this.a.a, true, "shareToQQ", this.a.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.10
 * JD-Core Version:    0.7.0.1
 */