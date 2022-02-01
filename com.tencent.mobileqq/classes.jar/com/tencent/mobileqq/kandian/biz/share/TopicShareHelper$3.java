package com.tencent.mobileqq.kandian.biz.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class TopicShareHelper$3
  implements DialogInterface.OnDismissListener
{
  TopicShareHelper$3(TopicShareHelper paramTopicShareHelper) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (TopicShareHelper.c(this.a) != null) {
      TopicShareHelper.c(this.a).a(TopicShareHelper.d(this.a), TopicShareHelper.e(this.a), false, false);
    }
    TopicShareHelper.a(this.a, true);
    TopicShareHelper.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper.3
 * JD-Core Version:    0.7.0.1
 */