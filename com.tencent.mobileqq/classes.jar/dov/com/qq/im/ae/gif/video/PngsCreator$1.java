package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import axqx;
import bkxq;
import blaq;
import blas;
import blav;
import com.tencent.filter.BaseFilter;

public class PngsCreator$1
  implements Runnable
{
  public PngsCreator$1(blaq paramblaq, String paramString) {}
  
  public void run()
  {
    Object localObject = new axqx(null, 1);
    ((axqx)localObject).b(((axqx)localObject).a(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    blaq.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, blaq.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    blaq.a(this.this$0).apply();
    blaq.a(this.this$0).a(320, 320);
    blaq.a(this.this$0).a();
    blaq.a(this.this$0, new SurfaceTexture(blaq.a(this.this$0)));
    blaq.a(this.this$0).setOnFrameAvailableListener(new blas(this.this$0));
    blaq.a(this.this$0, new blav());
    blaq.a(this.this$0).a(this.a, new Surface(blaq.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */