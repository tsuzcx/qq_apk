package com.tencent.qqmini.miniapp.widget.media;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import java.io.File;
import org.json.JSONObject;

class MiniAppLivePusher$4$1
  implements Runnable
{
  MiniAppLivePusher$4$1(MiniAppLivePusher.4 param4, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(((MiniAppFileManager)MiniAppLivePusher.access$100(this.this$1.this$0).getManager(MiniAppFileManager.class)).getTmpPath("jpg"));
      ((File)localObject).getParentFile().mkdirs();
      MiniAppLivePusher.access$200(this.val$bitmap, (File)localObject);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempImagePath", ((File)localObject).getAbsolutePath());
      localJSONObject2.put("width", this.val$bitmap.getWidth());
      localJSONObject2.put("height", this.val$bitmap.getHeight());
      localObject = ApiUtil.wrapCallbackOk(this.this$1.val$eventName, localJSONObject2);
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1 = ApiUtil.wrapCallbackFail(this.this$1.val$eventName, new JSONObject());
      this.this$1.val$req.jsService.evaluateCallbackJs(this.this$1.val$req.callbackId, localJSONObject1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.4.1
 * JD-Core Version:    0.7.0.1
 */