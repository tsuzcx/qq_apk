package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import blax;
import blba;
import com.tencent.view.RendererUtils;

public class VideoGIFCreator$2
  implements Runnable
{
  public VideoGIFCreator$2(blax paramblax, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    blax.a(this.this$0, new blba(this.this$0));
    blax.a(this.this$0).jdField_a_of_type_Int = RendererUtils.createTexture(this.jdField_a_of_type_AndroidGraphicsBitmap);
    blax.a(this.this$0).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    blax.a(this.this$0).b = this.b;
    blax.a(this.this$0).c = this.c;
    blax.a(this.this$0).d = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.2
 * JD-Core Version:    0.7.0.1
 */