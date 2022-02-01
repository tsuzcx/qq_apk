package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule.LoadDraftCallback;
import java.util.List;
import mqq.os.MqqHandler;

class ReadInJoyDraftboxFragment$1$1
  implements ReadInJoyDraftboxModule.LoadDraftCallback
{
  ReadInJoyDraftboxFragment$1$1(ReadInJoyDraftboxFragment.1 param1) {}
  
  public void a(List<ReadInJoyDraftboxItem> paramList)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxFragment.1.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxFragment.1.1
 * JD-Core Version:    0.7.0.1
 */