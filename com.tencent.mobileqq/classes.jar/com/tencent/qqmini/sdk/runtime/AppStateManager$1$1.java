package com.tencent.qqmini.sdk.runtime;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class AppStateManager$1$1
  implements ICaptureImageCallback
{
  AppStateManager$1$1(AppStateManager.1 param1) {}
  
  public void onResult(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("--- getScreenshot failed, ");
      paramBitmap.append(this.a.val$miniAppInfo.appId);
      QMLog.i("minisdk-start_RuntimeState", paramBitmap.toString());
      return;
    }
    AppStateManager.access$100(this.a.this$0, paramBitmap, this.a.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager.1.1
 * JD-Core Version:    0.7.0.1
 */