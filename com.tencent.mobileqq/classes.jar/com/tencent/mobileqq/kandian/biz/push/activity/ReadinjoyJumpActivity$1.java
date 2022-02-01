package com.tencent.mobileqq.kandian.biz.push.activity;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyJumpActivity$1
  implements Runnable
{
  ReadinjoyJumpActivity$1(ReadinjoyJumpActivity paramReadinjoyJumpActivity) {}
  
  public void run()
  {
    QLog.d("ReadinjoyJumpActivity", 1, "timeout ! show error page !");
    ReadInJoyLogicEngineEventDispatcher.a().b(ReadinjoyJumpActivity.a(this.this$0));
    ReadinjoyJumpActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadinjoyJumpActivity.1
 * JD-Core Version:    0.7.0.1
 */