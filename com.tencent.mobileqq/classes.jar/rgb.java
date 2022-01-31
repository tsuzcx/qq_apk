import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import java.util.HashMap;

class rgb
  implements Runnable
{
  rgb(rga paramrga, boolean paramBoolean, String paramString, Bitmap paramBitmap, Drawable paramDrawable) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Rga.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      AccountManageActivity.b(this.jdField_a_of_type_Rga.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity).put(this.jdField_a_of_type_Rga.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_Rga.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    this.jdField_a_of_type_Rga.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rgb
 * JD-Core Version:    0.7.0.1
 */