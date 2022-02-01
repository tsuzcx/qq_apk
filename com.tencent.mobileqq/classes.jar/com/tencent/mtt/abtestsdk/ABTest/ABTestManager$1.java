package com.tencent.mtt.abtestsdk.ABTest;

import android.os.Message;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;

class ABTestManager$1
  implements Runnable
{
  private int connectTimes = 1;
  Message msg = this.val$uiHandler.obtainMessage();
  
  ABTestManager$1(ABTestManager paramABTestManager, ABTestManager.UIHandler paramUIHandler, String paramString, int paramInt) {}
  
  public void run()
  {
    ABTestUtil.getRequest(this.val$requestUrl, this.val$timeout, new ABTestManager.1.1(this), this.this$0.builder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTest.ABTestManager.1
 * JD-Core Version:    0.7.0.1
 */