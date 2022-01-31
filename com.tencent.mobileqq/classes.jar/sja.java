import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class sja
  implements URLDrawable.URLDrawableListener
{
  sja(siy paramsiy, String paramString, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    snb.c("813", "onLoadCanceled - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841259);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    snb.d("813", "onLoadFialed - " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841259);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    snb.a("813", "onLoadProgressed - " + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    siy.a(this.jdField_a_of_type_Siy, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidWidgetImageView);
    skq.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sja
 * JD-Core Version:    0.7.0.1
 */