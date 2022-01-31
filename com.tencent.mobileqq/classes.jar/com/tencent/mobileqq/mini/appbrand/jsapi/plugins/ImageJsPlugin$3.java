package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ImageJsPlugin$3
  implements MiniAppController.ActivityResultListener
{
  ImageJsPlugin$3(ImageJsPlugin paramImageJsPlugin, JsRuntime paramJsRuntime, int paramInt) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("ImageJsPlugin", 2, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    if (paramInt1 == 4)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("photoPath");
        QLog.d("ImageJsPlugin", 2, "doOnActivityResult photoPath=" + paramIntent);
        if (paramIntent != null)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramIntent);
          ImageJsPlugin.access$300(this.this$0, localArrayList, this.val$webview, this.val$callbackId);
        }
      }
      for (;;)
      {
        MiniAppController.getInstance().removeActivityResultListener(this);
        return true;
        if (paramInt2 == 0) {
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, "chooseImage", null, "fail cancel", this.val$callbackId);
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */