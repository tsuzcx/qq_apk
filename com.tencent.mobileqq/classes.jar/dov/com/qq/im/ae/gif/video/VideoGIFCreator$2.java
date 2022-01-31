package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import biwd;
import biwg;
import com.tencent.view.RendererUtils;

public class VideoGIFCreator$2
  implements Runnable
{
  public VideoGIFCreator$2(biwd parambiwd, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    biwd.a(this.this$0, new biwg(this.this$0));
    biwd.a(this.this$0).jdField_a_of_type_Int = RendererUtils.createTexture(this.jdField_a_of_type_AndroidGraphicsBitmap);
    biwd.a(this.this$0).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    biwd.a(this.this$0).b = this.b;
    biwd.a(this.this$0).c = this.c;
    biwd.a(this.this$0).d = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.2
 * JD-Core Version:    0.7.0.1
 */