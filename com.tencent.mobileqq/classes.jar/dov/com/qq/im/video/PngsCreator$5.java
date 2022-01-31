package dov.com.qq.im.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import bhrz;
import biap;
import biau;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class PngsCreator$5
  implements Runnable
{
  public PngsCreator$5(biap parambiap) {}
  
  public void run()
  {
    biap.a(this.this$0).b();
    if (biap.a(this.this$0) != null) {
      biap.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = biap.a(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    biap.a(this.this$0).clearGLSLSelf();
    biap.a(this.this$0).b();
    biap.a(this.this$0).clear();
    biap.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.video.PngsCreator.5
 * JD-Core Version:    0.7.0.1
 */