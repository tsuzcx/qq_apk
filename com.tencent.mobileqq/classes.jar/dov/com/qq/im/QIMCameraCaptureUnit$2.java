package dov.com.qq.im;

import android.app.Activity;
import android.graphics.Bitmap;
import bheg;
import bmul;
import bmuu;
import borh;
import com.tencent.mobileqq.utils.ViewUtils;

public class QIMCameraCaptureUnit$2
  implements Runnable
{
  public QIMCameraCaptureUnit$2(bmul parambmul) {}
  
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bmuu.a(this.this$0.jdField_a_of_type_Borh.a(), true);
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bheg.b(this.this$0.jdField_a_of_type_AndroidGraphicsBitmap, ViewUtils.dip2px(3.0F), this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      }
      this.this$0.jdField_a_of_type_Borh.a().runOnUiThread(new QIMCameraCaptureUnit.2.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */