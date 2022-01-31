package dov.com.qq.im.video;

import android.graphics.Bitmap;
import biaw;
import biaz;
import com.tencent.view.RendererUtils;

public class VideoGIFCreator$2
  implements Runnable
{
  public VideoGIFCreator$2(biaw parambiaw, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    biaw.a(this.this$0, new biaz(this.this$0));
    biaw.a(this.this$0).jdField_a_of_type_Int = RendererUtils.createTexture(this.jdField_a_of_type_AndroidGraphicsBitmap);
    biaw.a(this.this$0).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    biaw.a(this.this$0).b = this.b;
    biaw.a(this.this$0).c = this.c;
    biaw.a(this.this$0).d = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.video.VideoGIFCreator.2
 * JD-Core Version:    0.7.0.1
 */