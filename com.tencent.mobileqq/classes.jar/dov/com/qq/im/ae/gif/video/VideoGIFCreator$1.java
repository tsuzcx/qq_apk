package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import bbmk;
import bmwq;
import bnou;
import bnpm;
import bnpn;
import bnpo;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.io.FileNotFoundException;

public class VideoGIFCreator$1
  implements Runnable
{
  public VideoGIFCreator$1(bnpn parambnpn, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(bmwq.b);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = ((File)localObject1).getPath() + File.separator + System.currentTimeMillis() + ".gif";
    try
    {
      bnpn.a(this.this$0).a(bnpn.a(this.this$0), bnpn.b(this.this$0), (String)localObject1);
      Object localObject2 = new bbmk(null, 1);
      ((bbmk)localObject2).b(((bbmk)localObject2).a(bnpn.a(this.this$0), bnpn.b(this.this$0)));
      localObject2 = new int[1];
      GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
      bnpn.a(this.this$0, localObject2[0]);
      GLES20.glBindTexture(36197, bnpn.c(this.this$0));
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      bnpn.a(this.this$0).apply();
      bnpn.b(this.this$0).apply();
      bnpn.c(this.this$0).apply();
      bnpn.a(this.this$0).a(bnpn.a(this.this$0), bnpn.b(this.this$0));
      bnpn.a(this.this$0).a();
      bnpn.a(this.this$0, new SurfaceTexture(localObject2[0]));
      bnpn.a(this.this$0).setOnFrameAvailableListener(new bnpo(this, (String)localObject1));
      bnpn.a(this.this$0, new bnpm());
      bnpn.a(this.this$0).a(this.a, 0L, 2147483647L, new Surface(bnpn.a(this.this$0)));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        QLog.d(bnpn.a(), 4, "gifEncoder init exception, msg = " + localFileNotFoundException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.1
 * JD-Core Version:    0.7.0.1
 */