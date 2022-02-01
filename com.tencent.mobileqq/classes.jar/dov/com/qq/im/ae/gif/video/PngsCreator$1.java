package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglCore;
import dov.com.qq.im.ae.gif.filter.GifFilterProcess;

class PngsCreator$1
  implements Runnable
{
  PngsCreator$1(PngsCreator paramPngsCreator, String paramString) {}
  
  public void run()
  {
    Object localObject = new EglCore(null, 1);
    ((EglCore)localObject).b(((EglCore)localObject).a(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    PngsCreator.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, PngsCreator.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    PngsCreator.a(this.this$0).apply();
    PngsCreator.a(this.this$0).a(320, 320);
    PngsCreator.a(this.this$0).a();
    PngsCreator.a(this.this$0, new SurfaceTexture(PngsCreator.a(this.this$0)));
    PngsCreator.a(this.this$0).setOnFrameAvailableListener(new PngsCreator.DecodeFrameListener(this.this$0));
    PngsCreator.a(this.this$0, new RepeatVideoDecoder());
    PngsCreator.a(this.this$0).a(this.a, new Surface(PngsCreator.a(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */