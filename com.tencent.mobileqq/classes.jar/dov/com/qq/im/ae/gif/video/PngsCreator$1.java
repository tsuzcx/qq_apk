package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import bath;
import bnrf;
import bnuf;
import bnuh;
import bnuk;
import com.tencent.filter.BaseFilter;

public class PngsCreator$1
  implements Runnable
{
  public PngsCreator$1(bnuf parambnuf, String paramString) {}
  
  public void run()
  {
    Object localObject = new bath(null, 1);
    ((bath)localObject).b(((bath)localObject).a(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    bnuf.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, bnuf.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    bnuf.a(this.this$0).apply();
    bnuf.a(this.this$0).a(320, 320);
    bnuf.a(this.this$0).a();
    bnuf.a(this.this$0, new SurfaceTexture(bnuf.a(this.this$0)));
    bnuf.a(this.this$0).setOnFrameAvailableListener(new bnuh(this.this$0));
    bnuf.a(this.this$0, new bnuk());
    bnuf.a(this.this$0).a(this.a, new Surface(bnuf.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */