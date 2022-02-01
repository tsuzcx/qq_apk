package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.common.GifUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.AEPath.GIF.FILES;
import dov.com.qq.im.ae.gif.preview.VideoFilterProcess;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;

class VideoGIFCreator$1$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  VideoGIFCreator$1$1(VideoGIFCreator.1 param1, String paramString) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(VideoGIFCreator.a(), 4, "gif creator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(VideoGIFCreator.c(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), 960, 480, -1, 0.0D, VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0));
    VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(true);
    paramSurfaceTexture = VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), 480, 480);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(1, 771);
    if (VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0) != null)
    {
      float f1 = -1.0F + VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).jdField_a_of_type_Float * 2.0F;
      float f2 = -1.0F + VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).b * 2.0F;
      float f3 = VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).c * 2.0F + f1;
      float f4 = VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).d * 2.0F + f2;
      VideoGIFCreator.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
      VideoGIFCreator.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).jdField_a_of_type_Int, paramSurfaceTexture.width, paramSurfaceTexture.height, -1, 0.0D, paramSurfaceTexture);
    }
    Frame localFrame = FrameBufferCache.getInstance().get(VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), VideoGIFCreator.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0));
    FrameUtil.clearFrame(localFrame, 0.0F, 0.0F, 0.0F, 0.0F, localFrame.width, localFrame.height);
    VideoGIFCreator.c(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(paramSurfaceTexture.getTextureId(), VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), VideoGIFCreator.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), -1, 0.0D, localFrame);
    Bitmap localBitmap = RendererUtils.saveTexture(localFrame);
    paramSurfaceTexture.unlock();
    localFrame.unlock();
    GLES20.glDisable(3042);
    VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(localBitmap, 55);
    localBitmap.recycle();
    QLog.d(VideoGIFCreator.a(), 4, "gif creator decodeToSurface()");
    if (!VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a())
    {
      QLog.d(VideoGIFCreator.a(), 4, "gifEncoder.close() start");
      VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a();
      QLog.d(VideoGIFCreator.a(), 4, "gifEncoder.close() end");
      QLog.d(VideoGIFCreator.a(), 4, "gif encode complete");
      paramSurfaceTexture = AEPath.GIF.FILES.b + File.separator + System.currentTimeMillis() + "_compressed.gif";
      FileUtil.c(paramSurfaceTexture);
      QLog.d(VideoGIFCreator.a(), 4, "gif compress start");
      int i = GifUtil.compressGif(this.jdField_a_of_type_JavaLangString, paramSurfaceTexture, 30);
      QLog.d(VideoGIFCreator.a(), 4, "gif compress end, ret = " + i);
      FileUtil.c(this.jdField_a_of_type_JavaLangString);
      if (i <= 0) {
        break label620;
      }
      VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(paramSurfaceTexture);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0.a();
      return;
      label620:
      VideoGIFCreator.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.1.1
 * JD-Core Version:    0.7.0.1
 */