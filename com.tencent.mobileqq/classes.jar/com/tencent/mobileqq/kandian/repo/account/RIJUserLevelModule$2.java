package com.tencent.mobileqq.kandian.repo.account;

import java.util.Iterator;
import java.util.List;

class RIJUserLevelModule$2
  implements Runnable
{
  RIJUserLevelModule$2(RIJUserLevelModule paramRIJUserLevelModule, UserLevelInfo paramUserLevelInfo) {}
  
  public void run()
  {
    Iterator localIterator = RIJUserLevelModule.access$100(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((RIJUserLevelModule.UserLevelInfoUpdateListener)localIterator.next()).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule.2
 * JD-Core Version:    0.7.0.1
 */