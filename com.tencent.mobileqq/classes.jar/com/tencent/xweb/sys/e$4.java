package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.xweb.internal.IWebView.a;
import org.xwalk.core.Log;

class e$4
  implements Runnable
{
  e$4(e parame, IWebView.a parama) {}
  
  public void run()
  {
    int i = this.b.b.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(this.b.b.getWidth(), i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.b.b.draw(localCanvas);
    this.a.a(localBitmap);
    Log.d("SysWebView", "bitmapCaptureFinished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.e.4
 * JD-Core Version:    0.7.0.1
 */