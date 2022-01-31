import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

public final class ntn
  implements URLDrawable.URLDrawableListener
{
  public ntn(ImageView paramImageView, Drawable paramDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "iconDrawable onLoadFialed, exception: " + QLog.getStackTraceString(paramThrowable));
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntn
 * JD-Core Version:    0.7.0.1
 */