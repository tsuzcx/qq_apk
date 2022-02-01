package com.tencent.qqmini.miniapp.widget.camera;

import android.util.Log;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class MiniAppCamera$5
  implements Runnable
{
  MiniAppCamera$5(MiniAppCamera paramMiniAppCamera, String paramString, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      String str = MiniAppCamera.access$200(this.this$0, this.val$videoPath);
      if (StringUtil.isEmpty(str))
      {
        Log.i("MiniAppCamera", "run: null video thumb path");
        this.val$req.fail();
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempThumbPath", this.this$0.getWxFilePath(str));
      localJSONObject.put("tempVideoPath", this.this$0.getWxFilePath(this.val$videoPath));
      this.val$req.jsService.evaluateCallbackJs(this.val$req.callbackId, localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      Log.w("MiniAppCamera", "run: failed to stop record", localException);
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.5
 * JD-Core Version:    0.7.0.1
 */