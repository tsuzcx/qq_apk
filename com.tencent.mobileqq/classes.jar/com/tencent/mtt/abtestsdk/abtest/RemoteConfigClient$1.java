package com.tencent.mtt.abtestsdk.abtest;

import com.tencent.mtt.abtestsdk.listener.GetConfigListener;
import com.tencent.mtt.abtestsdk.utils.OkHttpHelper;
import org.json.JSONObject;

class RemoteConfigClient$1
  implements Runnable
{
  RemoteConfigClient$1(RemoteConfigClient paramRemoteConfigClient, String paramString, JSONObject paramJSONObject, int paramInt, GetConfigListener paramGetConfigListener) {}
  
  public void run()
  {
    OkHttpHelper.getsInstance().postRequestWithJSONBody(this.val$remoteConfigUrl, this.val$postBodyJson, this.val$timeout, new RemoteConfigClient.OnConfigResCallBack(this.this$0, this.val$listener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.RemoteConfigClient.1
 * JD-Core Version:    0.7.0.1
 */