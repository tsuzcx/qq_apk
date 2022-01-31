package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import bivm;
import bivp;
import com.tencent.view.RendererUtils;

public class VideoGIFCreator$2
  implements Runnable
{
  public VideoGIFCreator$2(bivm parambivm, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    bivm.a(this.this$0, new bivp(this.this$0));
    bivm.a(this.this$0).jdField_a_of_type_Int = RendererUtils.createTexture(this.jdField_a_of_type_AndroidGraphicsBitmap);
    bivm.a(this.this$0).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    bivm.a(this.this$0).b = this.b;
    bivm.a(this.this$0).c = this.c;
    bivm.a(this.this$0).d = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.2
 * JD-Core Version:    0.7.0.1
 */