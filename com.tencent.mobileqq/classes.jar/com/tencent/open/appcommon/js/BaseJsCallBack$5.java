package com.tencent.open.appcommon.js;

import android.os.Bundle;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;
import org.json.JSONException;
import org.json.JSONObject;

class BaseJsCallBack$5
  implements Runnable
{
  BaseJsCallBack$5(BaseJsCallBack paramBaseJsCallBack, String paramString) {}
  
  public void run()
  {
    try
    {
      if (BaseJsCallBack.access$000(this.this$0) != null)
      {
        JSONObject localJSONObject = new JSONObject(this.a);
        SendMsg localSendMsg = new SendMsg("setActionButton");
        localSendMsg.b.putString("iconType", localJSONObject.optString("iconType"));
        localSendMsg.b.putString("visible", localJSONObject.optString("visible"));
        localSendMsg.b.putString("callBackKey", localJSONObject.optString("callBackKey"));
        localSendMsg.b.putString("rightText", localJSONObject.optString("text"));
        BaseJsCallBack.access$000(this.this$0).b(localSendMsg);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseJsCallBack.5
 * JD-Core Version:    0.7.0.1
 */