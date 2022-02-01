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

class MiniAppLivePlayer$7$1
  implements Runnable
{
  MiniAppLivePlayer$7$1(MiniAppLivePlayer.7 param7, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      localObject1 = new File(((MiniAppFileManager)this.this$1.this$0.baseRuntime.getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
      ((File)localObject1).getParentFile().mkdirs();
      MiniAppLivePlayer.access$900(this.val$bitmap, (File)localObject1);
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("tempImagePath", ((File)localObject1).getAbsolutePath());
      ((JSONObject)localObject2).put("width", this.val$bitmap.getWidth());
      ((JSONObject)localObject2).put("height", this.val$bitmap.getHeight());
      localObject1 = ApiUtil.wrapCallbackOk(this.this$1.val$eventName, (JSONObject)localObject2);
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, ((JSONObject)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("takePhoto - evaluateCallbackJs：");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      QMLog.e("MiniAppLivePlayer", ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label169:
      break label169;
    }
    localObject1 = ApiUtil.wrapCallbackFail(this.this$1.val$eventName, new JSONObject());
    this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, ((JSONObject)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.7.1
 * JD-Core Version:    0.7.0.1
 */