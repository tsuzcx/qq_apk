package com.tencent.qqmini.sdk.core.proxy.service;

import android.os.Bundle;
import bert;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class ShareProxyDefault$2$1
  implements bert
{
  ShareProxyDefault$2$1(ShareProxyDefault.2 param2, JSONObject paramJSONObject) {}
  
  public void onReceiveResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.this$1.val$result != null) {
      this.this$1.val$result.onReceiveResult(true, this.val$ret);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault.2.1
 * JD-Core Version:    0.7.0.1
 */