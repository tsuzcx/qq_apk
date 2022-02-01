package com.tencent.mtt.abtestsdk.abtest;

import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.OkHttpHelper;
import org.json.JSONObject;

class ExperimentClient$1
  implements Runnable
{
  ExperimentClient$1(ExperimentClient paramExperimentClient, String paramString1, JSONObject paramJSONObject, int paramInt, String paramString2, OnUpdateExperimentsListener paramOnUpdateExperimentsListener) {}
  
  public void run()
  {
    OkHttpHelper.getsInstance().postRequestWithJSONBody(this.val$expUrl, this.val$postBodyJson, this.val$timeout, new ExperimentClient.OnExpResCallBack(this.this$0, this.val$expName, this.val$listener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.ExperimentClient.1
 * JD-Core Version:    0.7.0.1
 */