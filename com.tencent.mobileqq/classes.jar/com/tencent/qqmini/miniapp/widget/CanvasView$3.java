package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class CanvasView$3
  implements Runnable
{
  CanvasView$3(CanvasView paramCanvasView, Bitmap paramBitmap, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    label530:
    for (;;)
    {
      try
      {
        if (this.val$currBitmap == null)
        {
          QMLog.e("CanvasView", "canvas save image error!----getCacheBitmapFromView return null!");
          this.val$req.fail();
          return;
        }
        int j = this.this$0.mpx2pxInt(this.val$paramObj.optDouble("width", 0.0D));
        int i = this.this$0.mpx2pxInt(this.val$paramObj.optDouble("height", 0.0D));
        int i2 = j;
        if (j <= 0) {
          i2 = this.this$0.getWidth();
        }
        int i3 = i;
        if (i <= 0) {
          i3 = this.this$0.getHeight();
        }
        int k = (int)this.val$paramObj.optDouble("destWidth", 0.0D);
        j = (int)this.val$paramObj.optDouble("destHeight", 0.0D);
        i = k;
        if (k <= 0) {
          i = this.this$0.px2mpxInt(i2);
        }
        if (j <= 0)
        {
          j = this.this$0.px2mpxInt(i3);
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("----saveBitmap---destWidth: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("---destHeight: ");
          ((StringBuilder)localObject).append(j);
          QMLog.d("CanvasView", ((StringBuilder)localObject).toString());
          localObject = null;
          Bitmap.Config localConfig = CanvasView.access$300(this.this$0, this.val$isPngFile);
          try
          {
            Bitmap localBitmap1 = Bitmap.createBitmap(i, j, localConfig);
            localObject = localBitmap1;
          }
          catch (Throwable localThrowable2)
          {
            QMLog.w("CanvasView", "saveBitmap() createBitmap error! try again use lower quality!", localThrowable2);
          }
          if (localObject == null)
          {
            float f = CanvasView.access$400(this.this$0, i, j, this.val$isPngFile);
            if (f < 1.0F)
            {
              m = (int)(i * f);
              k = (int)(j * f);
              try
              {
                Bitmap localBitmap2 = Bitmap.createBitmap(m, k, localConfig);
                localObject = localBitmap2;
              }
              catch (Throwable localThrowable3)
              {
                QMLog.w("CanvasView", "saveBitmap() createBitmap 2nd time error!try again use lower quality!", localThrowable3);
              }
            }
          }
          int m = i;
          k = j;
          int n = m;
          int i1 = k;
          if (localObject != null) {
            break label530;
          }
          double d = m;
          Double.isNaN(d);
          n = (int)(d / 1.4D);
          d = k;
          Double.isNaN(d);
          i1 = (int)(d / 1.4D);
          try
          {
            Bitmap localBitmap3 = Bitmap.createBitmap(n, i1, localConfig);
            localObject = localBitmap3;
          }
          catch (Throwable localThrowable4)
          {
            QMLog.e("CanvasView", "saveBitmap() createBitmap 3rd time error!", localThrowable4);
            break label530;
          }
          if (localObject == null)
          {
            this.val$req.fail();
            return;
          }
          CanvasView.access$500(this.this$0, i2, i3, i, j, n, i1, (Bitmap)localObject, this.val$paramObj, this.val$currBitmap, this.val$fileType, this.val$isPngFile, this.val$req);
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("canvasToTempFilePath failed: ");
        localStringBuilder.append(Log.getStackTraceString(localThrowable1));
        QMLog.e("CanvasView", localStringBuilder.toString());
        this.val$req.fail();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.3
 * JD-Core Version:    0.7.0.1
 */