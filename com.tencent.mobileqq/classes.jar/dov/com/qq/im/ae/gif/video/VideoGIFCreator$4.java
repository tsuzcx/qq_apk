package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import bovf;
import bovx;
import bovy;
import bowb;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class VideoGIFCreator$4
  implements Runnable
{
  public VideoGIFCreator$4(bovy parambovy) {}
  
  public void run()
  {
    bovy.a(this.this$0).a();
    if (bovy.a(this.this$0) != null) {
      bovy.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = bovy.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (bovy.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = bovy.a(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    bovy.a(this.this$0).clearGLSLSelf();
    bovy.b(this.this$0).clearGLSLSelf();
    bovy.c(this.this$0).clearGLSLSelf();
    bovy.a(this.this$0).b();
    bovy.a(this.this$0).clear();
    bovy.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */