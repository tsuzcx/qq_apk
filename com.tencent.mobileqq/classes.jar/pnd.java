import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl;

public class pnd
  implements Runnable
{
  public pnd(AsyncImageable.AsyncImageableImpl paramAsyncImageableImpl, Drawable paramDrawable, Animation paramAnimation) {}
  
  public void run()
  {
    AsyncImageable.AsyncImageableImpl.a(this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageableImpl).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    AsyncImageable.AsyncImageableImpl.a(AsyncImageable.AsyncImageableImpl.a(this.jdField_a_of_type_ComTencentComponentMediaImageViewAsyncImageable$AsyncImageableImpl), this.jdField_a_of_type_AndroidViewAnimationAnimation, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pnd
 * JD-Core Version:    0.7.0.1
 */