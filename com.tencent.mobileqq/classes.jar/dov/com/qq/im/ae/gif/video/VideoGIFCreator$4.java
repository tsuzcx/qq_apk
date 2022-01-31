package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import blae;
import blaw;
import blax;
import blba;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class VideoGIFCreator$4
  implements Runnable
{
  public VideoGIFCreator$4(blax paramblax) {}
  
  public void run()
  {
    blax.a(this.this$0).a();
    if (blax.a(this.this$0) != null) {
      blax.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = blax.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (blax.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = blax.a(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    blax.a(this.this$0).clearGLSLSelf();
    blax.b(this.this$0).clearGLSLSelf();
    blax.c(this.this$0).clearGLSLSelf();
    blax.a(this.this$0).b();
    blax.a(this.this$0).clear();
    blax.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */