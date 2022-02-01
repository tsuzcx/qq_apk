package com.tencent.mobileqq.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.io.IOException;
import mqq.app.MobileQQ;

public class GPUImagePixelationFilter
  extends GPUDrawPartFilter
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.readTextFromRawResource(MobileQQ.getContext(), 2131230764);
  private float jdField_a_of_type_Float = 30.0F;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d = -1;
  private int e;
  
  public GPUImagePixelationFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
    this.mTextureType = 3553;
    this.mFilterType = 106;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.a(paramString, null);
      return;
    }
    catch (IOException paramString)
    {
      SLog.c("Q.qqstory.publish.edit GPUImagePixelationFilter", "setMosaicPath OutOfMemoryError", paramString);
    }
  }
  
  protected void onDestroy()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        SLog.b("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap recycle");
      }
    }
    int i = this.d;
    if (i != -1) {
      GlUtil.deleteTexture(i);
    }
  }
  
  protected void onDrawTexture()
  {
    super.onDrawTexture();
    GLES20.glUniform1f(this.jdField_a_of_type_Int, this.jdField_b_of_type_Float);
    GLES20.glUniform1f(this.jdField_b_of_type_Int, this.jdField_c_of_type_Float);
    GLES20.glUniform1f(this.jdField_c_of_type_Int, this.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      SLog.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap can't be null");
      return;
    }
    GLES20.glActiveTexture(33985);
    if ((this.d == -1) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        SLog.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap is recycled");
        return;
      }
      int i = this.d;
      if (i != -1) {
        GlUtil.deleteTexture(i);
      }
      this.d = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
    }
    GLES20.glBindTexture(3553, this.d);
    GLES20.glUniform1i(this.e, 1);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
    checkLocation(this.jdField_a_of_type_Int, "imageWidthFactor");
    this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
    checkLocation(this.jdField_b_of_type_Int, "imageHeightFactor");
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "pixel");
    checkLocation(this.jdField_c_of_type_Int, "mPixelLocation");
    this.e = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
    a(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    SLog.a("Q.qqstory.publish.edit GPUImagePixelationFilter", "onOutputSizeChanged width=%s, height=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.jdField_b_of_type_Float = 0.0009259259F;
    this.jdField_c_of_type_Float = 0.0005208334F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filter.GPUImagePixelationFilter
 * JD-Core Version:    0.7.0.1
 */