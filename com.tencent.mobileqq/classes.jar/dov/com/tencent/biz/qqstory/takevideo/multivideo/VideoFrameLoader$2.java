package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import java.lang.ref.WeakReference;
import java.util.List;

class VideoFrameLoader$2
  implements Runnable
{
  VideoFrameLoader$2(VideoFrameLoader paramVideoFrameLoader, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int != VideoFrameLoader.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject;
    if (VideoFrameLoader.a(this.this$0))
    {
      localObject = localBitmap;
      if (VideoFrameLoader.b(this.this$0)) {
        localObject = BitmapUtils.a(localBitmap, -VideoFrameLoader.a(this.this$0));
      }
      if (VideoFrameLoader.a(this.this$0) == null)
      {
        VideoFrameLoader.a(this.this$0, new GPUBitmapImageRender());
        VideoFrameLoader.a(this.this$0).a(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = VideoFrameLoader.a(this.this$0, VideoFrameLoader.a(this.this$0), (Bitmap)localObject, VideoFrameLoader.b(this.this$0));
    }
    for (;;)
    {
      VideoFrameLoader.a(this.this$0).add(localBitmap);
      localObject = null;
      if (VideoFrameLoader.a(this.this$0) != null) {
        localObject = (VideoFrameLoader.VideoFrameLoaderListener)VideoFrameLoader.a(this.this$0).get();
      }
      if (localObject != null) {
        ((VideoFrameLoader.VideoFrameLoaderListener)localObject).a(this.jdField_a_of_type_Int, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */