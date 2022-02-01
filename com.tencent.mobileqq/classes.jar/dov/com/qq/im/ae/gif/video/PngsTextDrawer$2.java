package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import bmve;
import bnmp;
import bnpj;
import bnpk;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PngsTextDrawer$2
  implements Runnable
{
  public PngsTextDrawer$2(bnpj parambnpj, bnpk parambnpk) {}
  
  public void run()
  {
    String str1 = bnpj.a(this.this$0) + System.currentTimeMillis();
    String str2;
    try
    {
      new File(str1).mkdirs();
      bnpj.a(this.this$0).a();
      Bitmap localBitmap1 = bnpj.a(this.this$0).a();
      Iterator localIterator = bnpj.a(this.this$0, bnpj.b(this.this$0)).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label334;
        }
        str2 = (String)localIterator.next();
        Bitmap localBitmap2 = bmve.a(str2, bnpj.a(this.this$0), bnpj.b(this.this$0), true);
        if (localBitmap2 == null) {
          break;
        }
        new Canvas(localBitmap2).drawBitmap(localBitmap1, bnpj.c(this.this$0), bnpj.d(this.this$0), new Paint());
        str2 = new File(str2).getName();
        bmve.a(str1 + File.separator + str2, localBitmap2);
        localBitmap2.recycle();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d(bnpj.a(), 4, "start add text exception, msg = " + localException.getMessage());
      if (this.a != null) {
        this.a.a();
      }
    }
    QLog.d(bnpj.a(), 4, new Object[] { "draw frame but bitmap == null, png path = ", str2 });
    label334:
    for (int i = 0;; i = 1)
    {
      bnpj.a(this.this$0).b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsTextDrawer.2
 * JD-Core Version:    0.7.0.1
 */