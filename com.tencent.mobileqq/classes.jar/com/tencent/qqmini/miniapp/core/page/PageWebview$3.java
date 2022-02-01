package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class PageWebview$3
  implements Runnable
{
  PageWebview$3(PageWebview paramPageWebview, PageWebview.WebviewShotCallback paramWebviewShotCallback) {}
  
  public void run()
  {
    label133:
    try
    {
      localObject = this.this$0.getContext().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = ((DisplayMetrics)localObject).widthPixels;
      double d = j;
      Double.isNaN(d);
      j = (int)(d * 0.8D);
      localObject = PageWebview.screenShot(this.this$0, i, j);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        if (this.val$callback == null) {
          break label133;
        }
        this.val$callback.onShotReady((Bitmap)localObject);
        return;
      }
      if (this.val$callback == null) {
        break label133;
      }
      this.val$callback.onShotReady(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label107:
      break label107;
    }
    QMLog.e("PageWebview", "shotWebview error.");
    localObject = this.val$callback;
    if (localObject != null) {
      ((PageWebview.WebviewShotCallback)localObject).onShotReady(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebview.3
 * JD-Core Version:    0.7.0.1
 */