package com.tencent.qqmini.miniapp.core.page;

import android.widget.FrameLayout;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;

class BrandPageWebview$2$1
  implements Runnable
{
  BrandPageWebview$2$1(BrandPageWebview.2 param2) {}
  
  public void run()
  {
    QMLog.d("miniapp-embedded", "onHideCustomView begin");
    if (this.this$1.this$0.customContainer == null) {
      return;
    }
    this.this$1.this$0.customContainer.setVisibility(8);
    this.this$1.this$0.customViewCallback.onCustomViewHidden();
    try
    {
      this.this$1.this$0.customContainer.removeAllViews();
      label64:
      this.this$1.this$0.customContainer = null;
      this.this$1.this$0.mFullscreenView = null;
      this.this$1.this$0.customViewCallback = null;
      QMLog.d("miniapp-embedded", "onHideCustomView end");
      return;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.BrandPageWebview.2.1
 * JD-Core Version:    0.7.0.1
 */