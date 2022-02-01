package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

class InterestLabelInfoModule$1
  implements Runnable
{
  InterestLabelInfoModule$1(InterestLabelInfoModule paramInterestLabelInfoModule) {}
  
  public void run()
  {
    List localList = this.this$0.mEntityManager.query(InterestLabelInfo.class, true, null, null, null, null, null, null);
    this.this$0.a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.InterestLabelInfoModule.1
 * JD-Core Version:    0.7.0.1
 */