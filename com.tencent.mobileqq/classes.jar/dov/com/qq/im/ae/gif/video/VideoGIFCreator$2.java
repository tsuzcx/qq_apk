package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import bnpn;
import bnpq;
import com.tencent.view.RendererUtils;

public class VideoGIFCreator$2
  implements Runnable
{
  public VideoGIFCreator$2(bnpn parambnpn, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void run()
  {
    bnpn.a(this.this$0, new bnpq(this.this$0));
    bnpn.a(this.this$0).jdField_a_of_type_Int = RendererUtils.createTexture(this.jdField_a_of_type_AndroidGraphicsBitmap);
    bnpn.a(this.this$0).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    bnpn.a(this.this$0).b = this.b;
    bnpn.a(this.this$0).c = this.c;
    bnpn.a(this.this$0).d = this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.VideoGIFCreator.2
 * JD-Core Version:    0.7.0.1
 */