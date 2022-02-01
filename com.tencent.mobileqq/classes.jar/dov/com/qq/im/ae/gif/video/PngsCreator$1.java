package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import bbma;
import bost;
import bovr;
import bovt;
import bovw;
import com.tencent.filter.BaseFilter;

public class PngsCreator$1
  implements Runnable
{
  public PngsCreator$1(bovr parambovr, String paramString) {}
  
  public void run()
  {
    Object localObject = new bbma(null, 1);
    ((bbma)localObject).b(((bbma)localObject).a(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    bovr.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, bovr.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    bovr.a(this.this$0).apply();
    bovr.a(this.this$0).a(320, 320);
    bovr.a(this.this$0).a();
    bovr.a(this.this$0, new SurfaceTexture(bovr.a(this.this$0)));
    bovr.a(this.this$0).setOnFrameAvailableListener(new bovt(this.this$0));
    bovr.a(this.this$0, new bovw());
    bovr.a(this.this$0).a(this.a, new Surface(bovr.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */