package dov.com.qq.im.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Environment;
import android.view.Surface;
import auzd;
import bhwv;
import biav;
import biaw;
import biax;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;

public class VideoGIFCreator$1
  implements Runnable
{
  public VideoGIFCreator$1(biaw parambiaw, String paramString) {}
  
  public void run()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + System.currentTimeMillis() + ".gif";
    try
    {
      biaw.a(this.this$0).a(biaw.a(this.this$0), biaw.b(this.this$0), str);
      Object localObject = new auzd(null, 1);
      ((auzd)localObject).b(((auzd)localObject).a(biaw.a(this.this$0), biaw.b(this.this$0)));
      localObject = new int[1];
      GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
      biaw.a(this.this$0, localObject[0]);
      GLES20.glBindTexture(36197, biaw.c(this.this$0));
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      biaw.a(this.this$0).apply();
      biaw.b(this.this$0).apply();
      biaw.c(this.this$0).apply();
      biaw.a(this.this$0).a(biaw.a(this.this$0), biaw.b(this.this$0));
      biaw.a(this.this$0).a();
      biaw.a(this.this$0, new SurfaceTexture(localObject[0]));
      biaw.a(this.this$0).setOnFrameAvailableListener(new biax(this, str));
      biaw.a(this.this$0, new biav());
      biaw.a(this.this$0).a(this.a, 0L, 2147483647L, new Surface(biaw.a(this.this$0)));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        QLog.d(biaw.a(), 4, "gifEncoder init exception, msg = " + localFileNotFoundException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.video.VideoGIFCreator.1
 * JD-Core Version:    0.7.0.1
 */