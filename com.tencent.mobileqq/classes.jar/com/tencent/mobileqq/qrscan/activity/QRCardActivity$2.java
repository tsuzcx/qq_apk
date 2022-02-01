package com.tencent.mobileqq.qrscan.activity;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class QRCardActivity$2
  implements Runnable
{
  QRCardActivity$2(QRCardActivity paramQRCardActivity) {}
  
  public void run()
  {
    int m;
    int i;
    int j;
    try
    {
      localObject1 = HttpUtil.openUrlForByte(this.this$0, this.this$0.v, "GET", null, null);
      if (localObject1 == null) {
        return;
      }
      localBitmap = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      if (localBitmap == null) {
        return;
      }
      k = localBitmap.getWidth();
      m = localBitmap.getHeight();
      if (k > m)
      {
        i = m;
        if (k <= m) {
          break label457;
        }
        j = (k - m) / 2;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject1;
      Bitmap localBitmap;
      if (QLog.isColorLevel())
      {
        QLog.d("IQRScanConst_QrcodeScannerCard", 2, localOutOfMemoryError.getMessage());
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("IQRScanConst_QrcodeScannerCard", 2, localIllegalArgumentException.getMessage());
        return;
      }
    }
    catch (IOException localIOException)
    {
      label90:
      if (QLog.isColorLevel()) {
        QLog.d("IQRScanConst_QrcodeScannerCard", 2, localIOException.getMessage());
      }
    }
    for (int k = (m - k) / 2;; k = 0)
    {
      float f = 75;
      m = (int)(this.this$0.j * f);
      int n = (int)(f * this.this$0.j);
      Object localObject2 = new Rect(0, 0, i, i);
      localObject1 = new Rect(0, 0, m, n);
      RectF localRectF = new RectF((Rect)localObject1);
      Object localObject3 = new Matrix();
      ((Matrix)localObject3).setRectToRect(new RectF((Rect)localObject2), new RectF((Rect)localObject1), Matrix.ScaleToFit.FILL);
      localObject2 = Bitmap.createBitmap(localBitmap, j, k, i, i, (Matrix)localObject3, false);
      localBitmap.recycle();
      f = this.this$0.j;
      double d = f;
      Double.isNaN(d);
      i = (int)(d * 6.0D);
      localBitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
      localObject3 = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      ((Canvas)localObject3).drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      f = i;
      ((Canvas)localObject3).drawRoundRect(localRectF, f, f, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject3).drawBitmap((Bitmap)localObject2, (Rect)localObject1, (Rect)localObject1, localPaint);
      ((Bitmap)localObject2).recycle();
      localObject1 = new Message();
      ((Message)localObject1).what = 0;
      ((Message)localObject1).obj = localBitmap;
      this.this$0.F.sendMessage((Message)localObject1);
      return;
      return;
      i = k;
      break;
      label457:
      j = 0;
      if (k <= m) {
        break label90;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity.2
 * JD-Core Version:    0.7.0.1
 */