package com.tencent.qqmini.miniapp.widget.media;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import org.json.JSONObject;

class MiniAppLivePlayer$6$1
  implements Runnable
{
  MiniAppLivePlayer$6$1(MiniAppLivePlayer.6 param6, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(((MiniAppFileManager)this.this$1.this$0.baseRuntime.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
      ((File)localObject).getParentFile().mkdirs();
      MiniAppLivePlayer.access$800(this.val$bitmap, (File)localObject);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempImagePath", ((File)localObject).getAbsolutePath());
      localJSONObject2.put("width", this.val$bitmap.getWidth());
      localJSONObject2.put("height", this.val$bitmap.getHeight());
      localObject = ApiUtil.wrapCallbackOk(this.this$1.val$eventName, localJSONObject2);
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, ((JSONObject)localObject).toString());
      QMLog.e("MiniAppLivePlayer", "takePhoto - evaluateCallbackJs：" + ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1 = ApiUtil.wrapCallbackFail(this.this$1.val$eventName, new JSONObject());
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, localJSONObject1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.6.1
 * JD-Core Version:    0.7.0.1
 */