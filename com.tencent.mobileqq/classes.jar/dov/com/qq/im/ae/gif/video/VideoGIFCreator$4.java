package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import bnou;
import bnpm;
import bnpn;
import bnpq;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class VideoGIFCreator$4
  implements Runnable
{
  public VideoGIFCreator$4(bnpn parambnpn) {}
  
  public void run()
  {
    bnpn.a(this.this$0).a();
    if (bnpn.a(this.this$0) != null) {
      bnpn.a(this.this$0).release();
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = bnpn.c(this.this$0);
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (bnpn.a(this.this$0) != null)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = bnpn.a(this.this$0).a;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    bnpn.a(this.this$0).clearGLSLSelf();
    bnpn.b(this.this$0).clearGLSLSelf();
    bnpn.c(this.this$0).clearGLSLSelf();
    bnpn.a(this.this$0).b();
    bnpn.a(this.this$0).clear();
    bnpn.a(this.this$0).getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.4
 * JD-Core Version:    0.7.0.1
 */