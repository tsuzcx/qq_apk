package dov.com.qq.im.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglCore;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AEPath.GIF.FILES;
import dov.com.qq.im.ae.gif.preview.VideoFilterProcess;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.io.FileNotFoundException;

class VideoGIFCreator$1
  implements Runnable
{
  VideoGIFCreator$1(VideoGIFCreator paramVideoGIFCreator, String paramString) {}
  
  public void run()
  {
    Object localObject1 = new File(AEPath.GIF.FILES.b);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = ((File)localObject1).getPath() + File.separator + System.currentTimeMillis() + ".gif";
    try
    {
      VideoGIFCreator.a(this.this$0).a(VideoGIFCreator.a(this.this$0), VideoGIFCreator.b(this.this$0), (String)localObject1);
      Object localObject2 = new EglCore(null, 1);
      ((EglCore)localObject2).b(((EglCore)localObject2).a(VideoGIFCreator.a(this.this$0), VideoGIFCreator.b(this.this$0)));
      localObject2 = new int[1];
      GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
      VideoGIFCreator.a(this.this$0, localObject2[0]);
      GLES20.glBindTexture(36197, VideoGIFCreator.c(this.this$0));
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameterf(36197, 10241, 9729.0F);
      GLES20.glTexParameterf(36197, 10242, 33071.0F);
      GLES20.glTexParameterf(36197, 10243, 33071.0F);
      VideoGIFCreator.a(this.this$0).apply();
      VideoGIFCreator.b(this.this$0).apply();
      VideoGIFCreator.c(this.this$0).apply();
      VideoGIFCreator.a(this.this$0).a(VideoGIFCreator.a(this.this$0), VideoGIFCreator.b(this.this$0));
      VideoGIFCreator.a(this.this$0).a();
      VideoGIFCreator.a(this.this$0, new SurfaceTexture(localObject2[0]));
      VideoGIFCreator.a(this.this$0).setOnFrameAvailableListener(new VideoGIFCreator.1.1(this, (String)localObject1));
      VideoGIFCreator.a(this.this$0, new VideoDecoder());
      VideoGIFCreator.a(this.this$0).a(this.a, 0L, 2147483647L, new Surface(VideoGIFCreator.a(this.this$0)));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        QLog.d(VideoGIFCreator.a(), 4, "gifEncoder init exception, msg = " + localFileNotFoundException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.1
 * JD-Core Version:    0.7.0.1
 */