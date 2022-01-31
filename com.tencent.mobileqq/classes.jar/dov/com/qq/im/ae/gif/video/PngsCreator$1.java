package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import avyw;
import bisg;
import bivf;
import bivh;
import bivk;
import com.tencent.filter.BaseFilter;

public class PngsCreator$1
  implements Runnable
{
  public PngsCreator$1(bivf parambivf, String paramString) {}
  
  public void run()
  {
    Object localObject = new avyw(null, 1);
    ((avyw)localObject).b(((avyw)localObject).a(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    bivf.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, bivf.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    bivf.a(this.this$0).apply();
    bivf.a(this.this$0).a(320, 320);
    bivf.a(this.this$0).a();
    bivf.a(this.this$0, new SurfaceTexture(bivf.a(this.this$0)));
    bivf.a(this.this$0).setOnFrameAvailableListener(new bivh(this.this$0));
    bivf.a(this.this$0, new bivk());
    bivf.a(this.this$0).a(this.a, new Surface(bivf.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */