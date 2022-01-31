package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import bkxq;
import blaq;
import blav;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class PngsCreator$5
  implements Runnable
{
  public PngsCreator$5(blaq paramblaq) {}
  
  public void run()
  {
    blaq.a(this.this$0).b();
    if (blaq.a(this.this$0) != null) {
      blaq.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = blaq.a(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    blaq.a(this.this$0).clearGLSLSelf();
    blaq.a(this.this$0).b();
    blaq.a(this.this$0).clear();
    blaq.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.5
 * JD-Core Version:    0.7.0.1
 */