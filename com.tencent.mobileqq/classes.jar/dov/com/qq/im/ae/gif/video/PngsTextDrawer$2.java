package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import bkkd;
import bkxx;
import blat;
import blau;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PngsTextDrawer$2
  implements Runnable
{
  public PngsTextDrawer$2(blat paramblat, blau paramblau) {}
  
  public void run()
  {
    String str1 = blat.a(this.this$0) + System.currentTimeMillis();
    String str2;
    try
    {
      new File(str1).mkdirs();
      blat.a(this.this$0).b();
      Bitmap localBitmap1 = blat.a(this.this$0).a();
      Iterator localIterator = blat.a(this.this$0, blat.b(this.this$0)).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label334;
        }
        str2 = (String)localIterator.next();
        Bitmap localBitmap2 = bkkd.a(str2, blat.a(this.this$0), blat.b(this.this$0), true);
        if (localBitmap2 == null) {
          break;
        }
        new Canvas(localBitmap2).drawBitmap(localBitmap1, blat.c(this.this$0), blat.d(this.this$0), new Paint());
        str2 = new File(str2).getName();
        bkkd.a(str1 + File.separator + str2, localBitmap2);
        localBitmap2.recycle();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d(blat.a(), 4, "start add text exception, msg = " + localException.getMessage());
      if (this.a != null) {
        this.a.a();
      }
    }
    QLog.d(blat.a(), 4, new Object[] { "draw frame but bitmap == null, png path = ", str2 });
    label334:
    for (int i = 0;; i = 1)
    {
      blat.a(this.this$0).c();
      if (this.a == null) {
        break;
      }
      if (i != 0)
      {
        this.a.a(localException);
        return;
      }
      this.a.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsTextDrawer.2
 * JD-Core Version:    0.7.0.1
 */