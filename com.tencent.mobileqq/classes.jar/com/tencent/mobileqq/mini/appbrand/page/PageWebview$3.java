package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import bbac;
import com.tencent.qphone.base.util.QLog;

class PageWebview$3
  implements Runnable
{
  PageWebview$3(PageWebview paramPageWebview, PageWebview.WebviewShotCallback paramWebviewShotCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.getContext().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = (int)(((DisplayMetrics)localObject).widthPixels * 0.8D);
      localObject = bbac.a(this.this$0, i, j);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        if (this.val$callback != null) {
          this.val$callback.onShotReady((Bitmap)localObject);
        }
      }
      else if (this.val$callback != null)
      {
        this.val$callback.onShotReady(null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(PageWebview.access$000(), 1, "shotWebview error.");
      if (this.val$callback != null) {
        this.val$callback.onShotReady(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.PageWebview.3
 * JD-Core Version:    0.7.0.1
 */