package com.tencent.mobileqq.surfaceviewaction.gl;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

class Texture$3
  implements Runnable
{
  Texture$3(Texture paramTexture) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Int != 0)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.this$0.jdField_a_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      GLES20.glFlush();
      if (QLog.isColorLevel()) {
        QLog.d("Texture", 2, "Texture->release real: textureId = " + this.this$0.jdField_a_of_type_Int + ", filePath = " + Texture.a(this.this$0));
      }
      this.this$0.jdField_a_of_type_Int = 0;
    }
    if ((this.this$0.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.this$0.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Texture.3
 * JD-Core Version:    0.7.0.1
 */