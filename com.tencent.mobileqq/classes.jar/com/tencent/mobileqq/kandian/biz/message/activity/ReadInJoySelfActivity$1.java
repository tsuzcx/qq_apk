package com.tencent.mobileqq.kandian.biz.message.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;

class ReadInJoySelfActivity$1
  implements Runnable
{
  ReadInJoySelfActivity$1(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void run()
  {
    this.this$0.c.t();
    if (this.this$0.b != null) {
      ReadInJoyWebDataManager.a().a(this.this$0.a.getCurrentAccountUin(), this.this$0.b.P() ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoySelfActivity.1
 * JD-Core Version:    0.7.0.1
 */