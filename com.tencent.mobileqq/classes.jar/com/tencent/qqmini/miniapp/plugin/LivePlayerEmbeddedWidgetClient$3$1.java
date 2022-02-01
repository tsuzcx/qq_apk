package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import org.json.JSONObject;

class LivePlayerEmbeddedWidgetClient$3$1
  implements Runnable
{
  LivePlayerEmbeddedWidgetClient$3$1(LivePlayerEmbeddedWidgetClient.3 param3, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      localObject1 = new File(MiniAppFileManager.getInstance().getTmpPath("jpg"));
      ((File)localObject1).getParentFile().mkdirs();
      LivePlayerEmbeddedWidgetClient.access$300(this.val$bitmap, (File)localObject1);
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("tempImagePath", ((File)localObject1).getAbsolutePath());
      ((JSONObject)localObject2).put("width", this.val$bitmap.getWidth());
      ((JSONObject)localObject2).put("height", this.val$bitmap.getHeight());
      localObject1 = ApiUtil.wrapCallbackOk(this.this$1.val$eventName, (JSONObject)localObject2);
      LivePlayerEmbeddedWidgetClient.access$400(this.this$1.this$0, this.this$1.val$callbackId, ((JSONObject)localObject1).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("takePhoto - evaluateCallbackJs：");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      QMLog.e("miniapp-embedded-live-player", ((StringBuilder)localObject2).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label146:
      break label146;
    }
    localObject1 = ApiUtil.wrapCallbackFail(this.this$1.val$eventName, new JSONObject());
    LivePlayerEmbeddedWidgetClient.access$400(this.this$1.this$0, this.this$1.val$callbackId, ((JSONObject)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.3.1
 * JD-Core Version:    0.7.0.1
 */