package com.tencent.mtt.abtestsdk.ABTest;

import android.os.Message;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;
import org.json.JSONObject;

class ABTestManager$2
  implements Runnable
{
  private int connectTimes = 1;
  Message msg = this.val$uiHandler.obtainMessage();
  
  ABTestManager$2(ABTestManager paramABTestManager, ABTestManager.UIHandler paramUIHandler, String paramString1, JSONObject paramJSONObject, int paramInt, String paramString2) {}
  
  public void run()
  {
    ABTestUtil.postRequestWithJSONBody(this.val$requestUrl, this.val$postBodyEncrypt.toString(), this.val$timeout, new ABTestManager.2.1(this), this.this$0.builder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTest.ABTestManager.2
 * JD-Core Version:    0.7.0.1
 */