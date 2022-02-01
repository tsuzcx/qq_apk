package com.tencent.mtt.abtestsdk.ABTest;

import android.os.Message;
import com.tencent.mtt.abtestsdk.utils.OkHttpHelper;
import org.json.JSONObject;

class ABTestManager$1
  implements Runnable
{
  Message msg = this.val$uiHandler.obtainMessage();
  
  ABTestManager$1(ABTestManager paramABTestManager, ABTestManager.UIHandler paramUIHandler, String paramString1, JSONObject paramJSONObject, int paramInt, String paramString2) {}
  
  public void run()
  {
    OkHttpHelper.getsInstance().postRequestWithJSONBody(this.val$requestUrl, this.val$postBodyEncrypt, this.val$timeout, new ABTestManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.ABTest.ABTestManager.1
 * JD-Core Version:    0.7.0.1
 */