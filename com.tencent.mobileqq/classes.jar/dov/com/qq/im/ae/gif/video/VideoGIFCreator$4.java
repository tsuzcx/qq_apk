package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import blel;
import blfd;
import blfe;
import blfh;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class VideoGIFCreator$4
  implements Runnable
{
  public VideoGIFCreator$4(blfe paramblfe) {}
  
  public void run()
  {
    blfe.a(this.this$0).a();
    if (blfe.a(this.this$0) != null) {
      blfe.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = blfe.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (blfe.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = blfe.a(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    blfe.a(this.this$0).clearGLSLSelf();
    blfe.b(this.this$0).clearGLSLSelf();
    blfe.c(this.this$0).clearGLSLSelf();
    blfe.a(this.this$0).b();
    blfe.a(this.this$0).clear();
    blfe.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */