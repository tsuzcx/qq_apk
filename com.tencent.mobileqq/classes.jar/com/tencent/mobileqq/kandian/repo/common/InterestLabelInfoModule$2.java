package com.tencent.mobileqq.kandian.repo.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class InterestLabelInfoModule$2
  implements Runnable
{
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      InterestLabelInfoModule.a(this.this$0).clear();
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)((Iterator)localObject).next();
        this.this$0.updateEntity(localInterestLabelInfo);
        InterestLabelInfoModule.a(this.this$0).put(Integer.valueOf(localInterestLabelInfo.mInterestLabelID), localInterestLabelInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.InterestLabelInfoModule.2
 * JD-Core Version:    0.7.0.1
 */