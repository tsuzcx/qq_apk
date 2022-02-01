package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import bfrx;
import com.tencent.qphone.base.util.QLog;

class PageWebview$4
  implements Runnable
{
  PageWebview$4(PageWebview paramPageWebview, PageWebview.WebviewShotCallback paramWebviewShotCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.this$0.getContext().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject).widthPixels;
      int j = (int)(((DisplayMetrics)localObject).widthPixels * 0.8D);
      localObject = bfrx.a(this.this$0, i, j);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.PageWebview.4
 * JD-Core Version:    0.7.0.1
 */