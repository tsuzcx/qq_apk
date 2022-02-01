package dov.com.qq.im;

import android.app.Activity;
import android.graphics.Bitmap;
import bhmq;
import bhtq;
import bocn;
import bocv;
import bqai;

public class QIMCameraCaptureUnit$1
  implements Runnable
{
  public QIMCameraCaptureUnit$1(bocn parambocn) {}
  
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bocv.a(this.this$0.jdField_a_of_type_Bqai.a(), true);
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
        this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.b(this.this$0.jdField_a_of_type_AndroidGraphicsBitmap, bhtq.a(3.0F), this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      }
      this.this$0.jdField_a_of_type_Bqai.a().runOnUiThread(new QIMCameraCaptureUnit.1.1(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */