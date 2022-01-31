package dov.com.qq.im.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import bhwv;
import biav;
import biaw;
import biaz;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class VideoGIFCreator$4
  implements Runnable
{
  public VideoGIFCreator$4(biaw parambiaw) {}
  
  public void run()
  {
    biaw.a(this.this$0).a();
    if (biaw.a(this.this$0) != null) {
      biaw.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = biaw.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (biaw.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = biaw.a(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    biaw.a(this.this$0).clearGLSLSelf();
    biaw.b(this.this$0).clearGLSLSelf();
    biaw.c(this.this$0).clearGLSLSelf();
    biaw.a(this.this$0).b();
    biaw.a(this.this$0).clear();
    biaw.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */