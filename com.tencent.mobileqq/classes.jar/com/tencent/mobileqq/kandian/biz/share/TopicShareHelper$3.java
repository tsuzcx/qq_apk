package com.tencent.mobileqq.kandian.biz.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class TopicShareHelper$3
  implements DialogInterface.OnDismissListener
{
  TopicShareHelper$3(TopicShareHelper paramTopicShareHelper) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (TopicShareHelper.a(this.a) != null) {
      TopicShareHelper.a(this.a).a(TopicShareHelper.a(this.a), TopicShareHelper.b(this.a), false, false);
    }
    TopicShareHelper.a(this.a, true);
    TopicShareHelper.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper.3
 * JD-Core Version:    0.7.0.1
 */