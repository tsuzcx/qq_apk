package dov.com.qq.im;

import android.app.Activity;
import android.graphics.Bitmap;
import bbdr;
import bbkx;
import bify;
import bigg;
import bjqu;

public class QIMCameraCaptureUnit$1
  implements Runnable
{
  public QIMCameraCaptureUnit$1(bify parambify) {}
  
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bigg.a(this.this$0.jdField_a_of_type_Bjqu.a(), true);
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bbdr.b(this.this$0.jdField_a_of_type_AndroidGraphicsBitmap, bbkx.a(3.0F), this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      }
      this.this$0.jdField_a_of_type_Bjqu.a().runOnUiThread(new QIMCameraCaptureUnit.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */