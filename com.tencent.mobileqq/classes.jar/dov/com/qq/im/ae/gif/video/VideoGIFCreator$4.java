package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import blzk;
import bmac;
import bmad;
import bmag;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class VideoGIFCreator$4
  implements Runnable
{
  public VideoGIFCreator$4(bmad parambmad) {}
  
  public void run()
  {
    bmad.a(this.this$0).a();
    if (bmad.a(this.this$0) != null) {
      bmad.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = bmad.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (bmad.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = bmad.a(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    bmad.a(this.this$0).clearGLSLSelf();
    bmad.b(this.this$0).clearGLSLSelf();
    bmad.c(this.this$0).clearGLSLSelf();
    bmad.a(this.this$0).b();
    bmad.a(this.this$0).clear();
    bmad.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */