package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONObject;

class DataJsPlugin$13
  implements AdProxy.ICmdListener
{
  DataJsPlugin$13(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      paramBoolean = DataJsPlugin.access$500(this.this$0, paramBoolean, paramJSONObject, this.val$req, this.val$constAdType);
      if (paramBoolean) {}
      return;
    }
    catch (Exception paramJSONObject)
    {
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */