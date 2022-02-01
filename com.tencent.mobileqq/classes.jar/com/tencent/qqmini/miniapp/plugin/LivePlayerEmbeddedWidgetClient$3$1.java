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
      Object localObject = new File(MiniAppFileManager.getInstance().getTmpPath("jpg"));
      ((File)localObject).getParentFile().mkdirs();
      LivePlayerEmbeddedWidgetClient.access$300(this.val$bitmap, (File)localObject);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempImagePath", ((File)localObject).getAbsolutePath());
      localJSONObject2.put("width", this.val$bitmap.getWidth());
      localJSONObject2.put("height", this.val$bitmap.getHeight());
      localObject = ApiUtil.wrapCallbackOk(this.this$1.val$eventName, localJSONObject2);
      LivePlayerEmbeddedWidgetClient.access$400(this.this$1.this$0, this.this$1.val$callbackId, ((JSONObject)localObject).toString());
      QMLog.e("miniapp-embedded-live-player", "takePhoto - evaluateCallbackJs：" + ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1 = ApiUtil.wrapCallbackFail(this.this$1.val$eventName, new JSONObject());
      LivePlayerEmbeddedWidgetClient.access$400(this.this$1.this$0, this.this$1.val$callbackId, localJSONObject1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerEmbeddedWidgetClient.3.1
 * JD-Core Version:    0.7.0.1
 */