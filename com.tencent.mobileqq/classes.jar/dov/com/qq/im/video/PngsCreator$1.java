package dov.com.qq.im.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import auzd;
import bhrz;
import biap;
import biar;
import biau;
import com.tencent.filter.BaseFilter;

public class PngsCreator$1
  implements Runnable
{
  public PngsCreator$1(biap parambiap, String paramString) {}
  
  public void run()
  {
    Object localObject = new auzd(null, 1);
    ((auzd)localObject).b(((auzd)localObject).a(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    biap.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, biap.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    biap.a(this.this$0).apply();
    biap.a(this.this$0).a(320, 320);
    biap.a(this.this$0).a();
    biap.a(this.this$0, new SurfaceTexture(biap.a(this.this$0)));
    biap.a(this.this$0).setOnFrameAvailableListener(new biar(this.this$0));
    biap.a(this.this$0, new biau());
    biap.a(this.this$0).a(this.a, new Surface(biap.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */