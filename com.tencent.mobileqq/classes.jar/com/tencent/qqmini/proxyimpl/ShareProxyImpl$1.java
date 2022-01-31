package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

class ShareProxyImpl$1
  implements MiniProgramShareUtils.OnShareListener
{
  ShareProxyImpl$1(ShareProxyImpl paramShareProxyImpl, AsyncResult paramAsyncResult) {}
  
  public void onShared(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.val$result.onReceiveResult(paramBoolean2, new JSONObject().put("needShareCallback", paramBoolean1));
      return;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */