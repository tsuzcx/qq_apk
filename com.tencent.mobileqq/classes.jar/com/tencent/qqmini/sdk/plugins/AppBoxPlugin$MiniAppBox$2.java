package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AppBoxPlugin$MiniAppBox$2
  implements AdProxy.IBoxADLisener
{
  AppBoxPlugin$MiniAppBox$2(AppBoxPlugin.MiniAppBox paramMiniAppBox, int paramInt1, int paramInt2) {}
  
  public void onDismiss()
  {
    QMLog.i("SDK_MiniAppBox", "gdtBox onDismiss");
    if (AppBoxPlugin.MiniAppBox.access$600(this.this$1) != null)
    {
      JSONObject localJSONObject = AppBoxPlugin.MiniAppBox.access$700(this.this$1, this.val$compId, -1);
      AppBoxPlugin.MiniAppBox.access$600(this.this$1).evaluateSubscribeJS("onAppBoxClose", localJSONObject.toString(), 0);
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    QMLog.i("SDK_MiniAppBox", "gdtBox onError, errCode = " + paramInt + ", errMsg = " + paramString);
    AppBoxPlugin.MiniAppBox.access$100(this.this$1, true, "operateAppBox", this.val$compId, paramInt, this.val$callbackId);
    AppBoxPlugin.MiniAppBox.access$502(this.this$1, false);
  }
  
  public void onLoad()
  {
    QMLog.i("SDK_MiniAppBox", "gdtBox onLoad");
    AppBoxPlugin.MiniAppBox.access$100(this.this$1, true, "operateAppBox", this.val$compId, 0, this.val$callbackId);
    AppBoxPlugin.MiniAppBox.access$502(this.this$1, false);
  }
  
  public void onShow()
  {
    QMLog.i("SDK_MiniAppBox", "gdtBox onShow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppBoxPlugin.MiniAppBox.2
 * JD-Core Version:    0.7.0.1
 */