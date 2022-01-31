import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;

class osa
  implements Runnable
{
  osa(orz paramorz) {}
  
  public void run()
  {
    if (this.a.a.jdField_c_of_type_Int == 1) {
      this.a.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.a.app.a(this.a.a.jdField_c_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (this.a.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.a.a.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      return;
      if (this.a.a.jdField_c_of_type_Int == 2)
      {
        this.a.a.jdField_a_of_type_AndroidGraphicsBitmap = this.a.a.app.a(this.a.a.jdField_c_of_type_JavaLangString, (byte)3, false, false);
        if (this.a.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.a.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.f();
        }
      }
      else
      {
        Drawable localDrawable = this.a.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.a.a.jdField_c_of_type_JavaLangString, true);
        if ((localDrawable instanceof BitmapDrawable)) {
          this.a.a.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localDrawable).getBitmap();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osa
 * JD-Core Version:    0.7.0.1
 */