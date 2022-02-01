package com.tencent.mobileqq.utils.abtest;

import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import java.util.List;

class ABTestController$3
  implements GetExperimentListener
{
  ABTestController$3(ABTestController paramABTestController) {}
  
  public void getExperimentFailed(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("abtest api load exp failed. i:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(". s:");
    localStringBuilder.append(paramString);
    ABTestUtil.a("ABTestController", localStringBuilder.toString());
  }
  
  public void getExperimentSucceed(List<ExpEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      synchronized (ABTestController.a(this.a))
      {
        ABTestController.a(this.a, paramList);
        return;
      }
    }
    ABTestUtil.a("ABTestController", "load exp failed. list empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestController.3
 * JD-Core Version:    0.7.0.1
 */