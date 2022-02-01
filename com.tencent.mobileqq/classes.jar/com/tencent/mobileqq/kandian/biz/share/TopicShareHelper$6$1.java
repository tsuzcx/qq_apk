package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mobileqq.widget.QQProgressDialog;

class TopicShareHelper$6$1
  implements Runnable
{
  TopicShareHelper$6$1(TopicShareHelper.6 param6) {}
  
  public void run()
  {
    if ((TopicShareHelper.a(this.a.this$0) != null) && (TopicShareHelper.a(this.a.this$0).isShowing())) {
      TopicShareHelper.a(this.a.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper.6.1
 * JD-Core Version:    0.7.0.1
 */