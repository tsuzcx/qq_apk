package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import biut;
import bivl;
import bivm;
import bivp;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class VideoGIFCreator$4
  implements Runnable
{
  public VideoGIFCreator$4(bivm parambivm) {}
  
  public void run()
  {
    bivm.a(this.this$0).a();
    if (bivm.a(this.this$0) != null) {
      bivm.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = bivm.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (bivm.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = bivm.a(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    bivm.a(this.this$0).clearGLSLSelf();
    bivm.b(this.this$0).clearGLSLSelf();
    bivm.c(this.this$0).clearGLSLSelf();
    bivm.a(this.this$0).b();
    bivm.a(this.this$0).clear();
    bivm.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */