package com.tencent.mobileqq.utils.abtest;

import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.listener.ExpInitListener;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ABTestController$1
  implements ExpInitListener
{
  ABTestController$1(ABTestController paramABTestController, String paramString) {}
  
  public void expInitFailed()
  {
    ABTestUtil.a("ABTestController", "ExpInitListener#expInitFailed");
    ABTestController.b(this.b).set(0);
  }
  
  public void expInitSuccess()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ExpInitListener#expInitSuccess. cacheSize:");
    ((StringBuilder)localObject).append(ABTestController.a(this.b).size());
    ABTestUtil.a("ABTestController", ((StringBuilder)localObject).toString());
    ABTestController.b(this.b).set(2);
    if (ABTestController.a(this.b).isEmpty()) {
      return;
    }
    localObject = ABTestController.c(this.b);
    ABTestController.d(this.b).set(true);
    ABTestApi.switchAccountId(this.a, (GetExperimentListener)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ABTestController.1
 * JD-Core Version:    0.7.0.1
 */