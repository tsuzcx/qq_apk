package com.tencent.mtt.abtestsdk.abtest;

import com.tencent.mtt.abtestsdk.listener.GetFeatureListener;
import com.tencent.mtt.abtestsdk.utils.OkHttpHelper;
import org.json.JSONObject;

class FeatureClient$1
  implements Runnable
{
  FeatureClient$1(FeatureClient paramFeatureClient, String paramString1, JSONObject paramJSONObject, int paramInt, GetFeatureListener paramGetFeatureListener, String paramString2) {}
  
  public void run()
  {
    OkHttpHelper.getsInstance().postRequestWithJSONBody(this.val$featureUrl, this.val$postBodyJson, this.val$timeout, new FeatureClient.OnResCallBack(this.this$0, this.val$listener, this.val$featureKey));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.FeatureClient.1
 * JD-Core Version:    0.7.0.1
 */