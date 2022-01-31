package dov.com.qq.im;

import aekt;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import bkil;

class QIMCameraCaptureUnit$1$1
  implements Runnable
{
  QIMCameraCaptureUnit$1$1(QIMCameraCaptureUnit.1 param1) {}
  
  public void run()
  {
    if ((this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.a.this$0.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.a.this$0.jdField_a_of_type_AndroidWidgetImageView.getResources(), this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap);
      int i = aekt.a(36.0F, this.a.this$0.jdField_a_of_type_AndroidWidgetImageView.getResources());
      localBitmapDrawable.setBounds(0, 0, i, i);
      this.a.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localBitmapDrawable);
      this.a.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.this$0.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      return;
    }
    this.a.this$0.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.1.1
 * JD-Core Version:    0.7.0.1
 */