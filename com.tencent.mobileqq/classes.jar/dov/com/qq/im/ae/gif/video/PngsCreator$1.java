package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import bafv;
import blwy;
import blzw;
import blzy;
import bmab;
import com.tencent.filter.BaseFilter;

public class PngsCreator$1
  implements Runnable
{
  public PngsCreator$1(blzw paramblzw, String paramString) {}
  
  public void run()
  {
    Object localObject = new bafv(null, 1);
    ((bafv)localObject).b(((bafv)localObject).a(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    blzw.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, blzw.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    blzw.a(this.this$0).apply();
    blzw.a(this.this$0).a(320, 320);
    blzw.a(this.this$0).a();
    blzw.a(this.this$0, new SurfaceTexture(blzw.a(this.this$0)));
    blzw.a(this.this$0).setOnFrameAvailableListener(new blzy(this.this$0));
    blzw.a(this.this$0, new bmab());
    blzw.a(this.this$0).a(this.a, new Surface(blzw.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */