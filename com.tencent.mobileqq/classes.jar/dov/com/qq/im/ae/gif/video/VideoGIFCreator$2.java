package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import com.tencent.view.RendererUtils;

class VideoGIFCreator$2
  implements Runnable
{
  VideoGIFCreator$2(VideoGIFCreator paramVideoGIFCreator, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    VideoGIFCreator.a(this.this$0, new VideoGIFCreator.TextConfig(this.this$0));
    VideoGIFCreator.a(this.this$0).jdField_a_of_type_Int = RendererUtils.createTexture(this.jdField_a_of_type_AndroidGraphicsBitmap);
    VideoGIFCreator.a(this.this$0).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    VideoGIFCreator.a(this.this$0).b = this.b;
    VideoGIFCreator.a(this.this$0).c = this.c;
    VideoGIFCreator.a(this.this$0).d = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.2
 * JD-Core Version:    0.7.0.1
 */