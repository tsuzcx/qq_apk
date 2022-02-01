package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import java.lang.ref.WeakReference;

class RIJUgcUtils$RIJUGCAccountStatusCheckCallback$1
  implements Runnable
{
  RIJUgcUtils$RIJUGCAccountStatusCheckCallback$1(RIJUgcUtils.RIJUGCAccountStatusCheckCallback paramRIJUGCAccountStatusCheckCallback, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    if (i == 2) {
      RIJUgcUtils.a((Activity)RIJUgcUtils.RIJUGCAccountStatusCheckCallback.a(this.this$0).get());
    } else if (i == 1) {
      RIJUgcUtils.b((Activity)RIJUgcUtils.RIJUGCAccountStatusCheckCallback.a(this.this$0).get(), RIJUgcUtils.RIJUGCAccountStatusCheckCallback.b(this.this$0));
    }
    ReadInJoyHelper.W();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.RIJUGCAccountStatusCheckCallback.1
 * JD-Core Version:    0.7.0.1
 */