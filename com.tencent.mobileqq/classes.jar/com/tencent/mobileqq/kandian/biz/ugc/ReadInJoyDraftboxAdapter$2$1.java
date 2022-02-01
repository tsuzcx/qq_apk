package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import mqq.os.MqqHandler;

class ReadInJoyDraftboxAdapter$2$1
  implements Runnable
{
  ReadInJoyDraftboxAdapter$2$1(ReadInJoyDraftboxAdapter.2 param2) {}
  
  public void run()
  {
    boolean bool = ReadInJoyDraftboxAdapter.b(this.a.c).c(this.a.a.getId());
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxAdapter.2.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */