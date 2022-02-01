package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import bost;
import bovr;
import bovw;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class PngsCreator$5
  implements Runnable
{
  public PngsCreator$5(bovr parambovr) {}
  
  public void run()
  {
    bovr.a(this.this$0).b();
    if (bovr.a(this.this$0) != null) {
      bovr.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = bovr.a(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    bovr.a(this.this$0).clearGLSLSelf();
    bovr.a(this.this$0).b();
    bovr.a(this.this$0).clear();
    bovr.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.5
 * JD-Core Version:    0.7.0.1
 */