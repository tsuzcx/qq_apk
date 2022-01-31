package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import axqx;
import bkkw;
import blae;
import blaw;
import blax;
import blay;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.io.FileNotFoundException;

public class VideoGIFCreator$1
  implements Runnable
{
  public VideoGIFCreator$1(blax paramblax, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(bkkw.b);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = ((File)localObject1).getPath() + File.separator + System.currentTimeMillis() + ".gif";
    try
    {
      blax.a(this.this$0).a(blax.a(this.this$0), blax.b(this.this$0), (String)localObject1);
      Object localObject2 = new axqx(null, 1);
      ((axqx)localObject2).b(((axqx)localObject2).a(blax.a(this.this$0), blax.b(this.this$0)));
      localObject2 = new int[1];
      GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
      blax.a(this.this$0, localObject2[0]);
      GLES20.glBindTexture(36197, blax.c(this.this$0));
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      blax.a(this.this$0).apply();
      blax.b(this.this$0).apply();
      blax.c(this.this$0).apply();
      blax.a(this.this$0).a(blax.a(this.this$0), blax.b(this.this$0));
      blax.a(this.this$0).a();
      blax.a(this.this$0, new SurfaceTexture(localObject2[0]));
      blax.a(this.this$0).setOnFrameAvailableListener(new blay(this, (String)localObject1));
      blax.a(this.this$0, new blaw());
      blax.a(this.this$0).a(this.a, 0L, 2147483647L, new Surface(blax.a(this.this$0)));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        QLog.d(blax.a(), 4, "gifEncoder init exception, msg = " + localFileNotFoundException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.1
 * JD-Core Version:    0.7.0.1
 */