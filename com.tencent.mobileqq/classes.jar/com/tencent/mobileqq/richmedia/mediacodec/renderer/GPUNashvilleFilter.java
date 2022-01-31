package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GPUNashvilleFilter
  extends GPUDrawPartFilter
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.a(BaseApplicationImpl.getContext(), 2131230753);
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private int e = -1;
  private int f;
  
  public GPUNashvilleFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
    this.d = 6;
  }
  
  protected void b()
  {
    super.b();
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeStream(BaseApplicationImpl.getContext().getResources().openRawResource(2130843334));
      this.f = GLES20.glGetUniformLocation(a(), "sTexture2");
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        SLog.e("Q.qqstory.publish.edit GPUNashvilleFilter", "OutOfMemoryError:%s", new Object[] { localOutOfMemoryError.getMessage() });
      }
    }
  }
  
  protected void d()
  {
    if (this.e != -1) {
      GlUtil.a(this.e);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      SLog.b("Q.qqstory.publish.edit GPUNashvilleFilter", "mosaic bitmap recycle");
    }
  }
  
  protected void e()
  {
    super.e();
    GLES20.glActiveTexture(33985);
    if (this.e == -1)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        QLog.w("Q.qqstory.publish.edit GPUNashvilleFilter", 1, "bitmap error");
        return;
      }
      this.e = GlUtil.a(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    GLES20.glBindTexture(3553, this.e);
    GLES20.glUniform1i(this.f, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUNashvilleFilter
 * JD-Core Version:    0.7.0.1
 */