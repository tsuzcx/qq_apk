import android.graphics.Bitmap;
import android.view.animation.Animation;
import com.tencent.component.media.image.view.ExtendImageView;

public class piq
  implements Runnable
{
  public piq(ExtendImageView paramExtendImageView, Bitmap paramBitmap, Animation paramAnimation) {}
  
  public void run()
  {
    ExtendImageView.a(this.jdField_a_of_type_ComTencentComponentMediaImageViewExtendImageView, this.jdField_a_of_type_AndroidGraphicsBitmap);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation != null) {
      ExtendImageView.a(this.jdField_a_of_type_ComTencentComponentMediaImageViewExtendImageView, this.jdField_a_of_type_AndroidViewAnimationAnimation, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     piq
 * JD-Core Version:    0.7.0.1
 */