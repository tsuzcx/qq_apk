package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import avyw;
import biih;
import biut;
import bivl;
import bivm;
import bivn;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.io.FileNotFoundException;

public class VideoGIFCreator$1
  implements Runnable
{
  public VideoGIFCreator$1(bivm parambivm, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(biih.b);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = ((File)localObject1).getPath() + File.separator + System.currentTimeMillis() + ".gif";
    try
    {
      bivm.a(this.this$0).a(bivm.a(this.this$0), bivm.b(this.this$0), (String)localObject1);
      Object localObject2 = new avyw(null, 1);
      ((avyw)localObject2).b(((avyw)localObject2).a(bivm.a(this.this$0), bivm.b(this.this$0)));
      localObject2 = new int[1];
      GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
      bivm.a(this.this$0, localObject2[0]);
      GLES20.glBindTexture(36197, bivm.c(this.this$0));
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      bivm.a(this.this$0).apply();
      bivm.b(this.this$0).apply();
      bivm.c(this.this$0).apply();
      bivm.a(this.this$0).a(bivm.a(this.this$0), bivm.b(this.this$0));
      bivm.a(this.this$0).a();
      bivm.a(this.this$0, new SurfaceTexture(localObject2[0]));
      bivm.a(this.this$0).setOnFrameAvailableListener(new bivn(this, (String)localObject1));
      bivm.a(this.this$0, new bivl());
      bivm.a(this.this$0).a(this.a, 0L, 2147483647L, new Surface(bivm.a(this.this$0)));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        QLog.d(bivm.a(), 4, "gifEncoder init exception, msg = " + localFileNotFoundException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.1
 * JD-Core Version:    0.7.0.1
 */