package dov.com.qq.im.ae.current;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.GifUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

class GIFCreator$1
  implements Runnable
{
  GIFCreator$1(GIFCreator paramGIFCreator, GIFCreator.Callback paramCallback) {}
  
  public void run()
  {
    QLog.d(GIFCreator.a(), 4, "gif encode loop");
    try
    {
      GIFCreator.a(this.this$0).a(320, 320, GIFCreator.a(this.this$0));
      GIFCreator.a(this.this$0).a(false);
      long l = System.currentTimeMillis();
      Object localObject1 = GIFCreator.a(this.this$0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = GIFCreator.a(this.this$0, (String)localObject2, 320, 320, false);
        if (localObject3 != null)
        {
          QLog.d(GIFCreator.a(), 4, "gif encode frame start");
          GIFCreator.a(this.this$0).a((Bitmap)localObject3, 55);
          QLog.d(GIFCreator.a(), 4, "gif encode frame end");
          ((Bitmap)localObject3).recycle();
        }
        else
        {
          QLog.d(GIFCreator.a(), 4, new Object[] { "gif encode frame but bitmap == null, png path = ", localObject2 });
          i = 0;
          break label175;
        }
      }
      int i = 1;
      label175:
      GIFCreator.a(this.this$0).a();
      localObject1 = GIFCreator.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gif encode duration = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      FileUtil.c(GIFCreator.b(this.this$0));
      l = System.currentTimeMillis();
      int j = GifUtil.compressGif(GIFCreator.a(this.this$0), GIFCreator.b(this.this$0), 30);
      localObject1 = GIFCreator.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gif compress duration = ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      localObject1 = GIFCreator.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gif compress ret = ");
      ((StringBuilder)localObject2).append(j);
      QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      if (j <= 0) {
        i = 0;
      }
      FileUtil.c(GIFCreator.a(this.this$0));
      QLog.d(GIFCreator.a(), 4, new Object[] { "gif create success, gif path = ", GIFCreator.b(this.this$0) });
      localObject1 = this.a;
      if (localObject1 != null) {
        if (i != 0) {
          ((GIFCreator.Callback)localObject1).onGifCreateSuccess(GIFCreator.b(this.this$0));
        } else {
          ((GIFCreator.Callback)localObject1).onGifCreateFail();
        }
      }
      GIFCreator.a(this.this$0).getLooper().quit();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject2 = GIFCreator.a();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("gifEncoder init exception, gifPath = ");
      ((StringBuilder)localObject3).append(GIFCreator.a(this.this$0));
      ((StringBuilder)localObject3).append(", msg = ");
      ((StringBuilder)localObject3).append(localFileNotFoundException.getMessage());
      QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
      GIFCreator.Callback localCallback = this.a;
      if (localCallback != null) {
        localCallback.onGifCreateFail();
      }
      GIFCreator.a(this.this$0).getLooper().quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.current.GIFCreator.1
 * JD-Core Version:    0.7.0.1
 */