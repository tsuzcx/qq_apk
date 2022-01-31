package com.tencent.mobileqq.mini.widget.media;

import android.util.Log;
import baip;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class MiniAppCamera$5
  implements Runnable
{
  MiniAppCamera$5(MiniAppCamera paramMiniAppCamera, String paramString1, String paramString2, WebviewContainer paramWebviewContainer, int paramInt) {}
  
  public void run()
  {
    try
    {
      String str = MiniAppCamera.access$300(this.this$0, this.val$videoPath);
      if (baip.a(str))
      {
        Log.i("MiniAppCamera", "run: null video thumb path");
        MiniAppCamera.access$400(this.this$0, this.val$event, this.val$wc, this.val$callBackId);
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempThumbPath", MiniAppFileManager.getInstance().getWxFilePath(str));
      localJSONObject.put("tempVideoPath", MiniAppFileManager.getInstance().getWxFilePath(this.val$videoPath));
      this.val$wc.appBrandRuntime.serviceRuntime.evaluateCallbackJs(this.val$callBackId, localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      Log.w("MiniAppCamera", "run: failed to stop record", localException);
      MiniAppCamera.access$400(this.this$0, this.val$event, this.val$wc, this.val$callBackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppCamera.5
 * JD-Core Version:    0.7.0.1
 */