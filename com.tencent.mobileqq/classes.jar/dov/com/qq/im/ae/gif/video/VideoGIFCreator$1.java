package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import bbma;
import boez;
import bovf;
import bovx;
import bovy;
import bovz;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.io.FileNotFoundException;

public class VideoGIFCreator$1
  implements Runnable
{
  public VideoGIFCreator$1(bovy parambovy, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(boez.b);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = ((File)localObject1).getPath() + File.separator + System.currentTimeMillis() + ".gif";
    try
    {
      bovy.a(this.this$0).a(bovy.a(this.this$0), bovy.b(this.this$0), (String)localObject1);
      Object localObject2 = new bbma(null, 1);
      ((bbma)localObject2).b(((bbma)localObject2).a(bovy.a(this.this$0), bovy.b(this.this$0)));
      localObject2 = new int[1];
      GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
      bovy.a(this.this$0, localObject2[0]);
      GLES20.glBindTexture(36197, bovy.c(this.this$0));
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      bovy.a(this.this$0).apply();
      bovy.b(this.this$0).apply();
      bovy.c(this.this$0).apply();
      bovy.a(this.this$0).a(bovy.a(this.this$0), bovy.b(this.this$0));
      bovy.a(this.this$0).a();
      bovy.a(this.this$0, new SurfaceTexture(localObject2[0]));
      bovy.a(this.this$0).setOnFrameAvailableListener(new bovz(this, (String)localObject1));
      bovy.a(this.this$0, new bovx());
      bovy.a(this.this$0).a(this.a, 0L, 2147483647L, new Surface(bovy.a(this.this$0)));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        QLog.d(bovy.a(), 4, "gifEncoder init exception, msg = " + localFileNotFoundException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.1
 * JD-Core Version:    0.7.0.1
 */