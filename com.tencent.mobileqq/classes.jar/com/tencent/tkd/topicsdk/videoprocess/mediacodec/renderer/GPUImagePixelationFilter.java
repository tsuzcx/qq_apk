package com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.tkd.R.raw;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.GlUtil;

public class GPUImagePixelationFilter
  extends GPUDrawPartFilter
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.a(AppContext.a, R.raw.jdField_b_of_type_Int);
  private float jdField_a_of_type_Float = 30.0F;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  private int f = -1;
  private int g;
  
  GPUImagePixelationFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 3553;
    this.jdField_b_of_type_Int = 106;
  }
  
  private void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a()
  {
    super.a();
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(a(), "imageWidthFactor");
    a(this.jdField_c_of_type_Int, "imageWidthFactor");
    this.d = GLES20.glGetUniformLocation(a(), "imageHeightFactor");
    a(this.d, "imageHeightFactor");
    this.e = GLES20.glGetUniformLocation(a(), "pixel");
    a(this.e, "mPixelLocation");
    this.g = GLES20.glGetUniformLocation(a(), "sTexture2");
    a(this.jdField_a_of_type_Float);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onOutputSizeChanged width=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height=%s");
    localStringBuilder.append(paramInt2);
    TLog.b("GPUImagePixelationFilter", localStringBuilder.toString());
    this.jdField_b_of_type_Float = 0.0009259259F;
    this.jdField_c_of_type_Float = 0.0005208334F;
  }
  
  protected void b()
  {
    super.b();
    GLES20.glUniform1f(this.jdField_c_of_type_Int, this.jdField_b_of_type_Float);
    GLES20.glUniform1f(this.d, this.jdField_c_of_type_Float);
    GLES20.glUniform1f(this.e, this.jdField_a_of_type_Float);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      TLog.d("GPUImagePixelationFilter", "mosaic bitmap can't be null");
      return;
    }
    GLES20.glActiveTexture(33985);
    if ((this.f == -1) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        TLog.d("GPUImagePixelationFilter", "mosaic bitmap is recycled");
        return;
      }
      int i = this.f;
      if (i != -1) {
        GlUtil.a(i);
      }
      this.f = GlUtil.a(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
    }
    GLES20.glBindTexture(3553, this.f);
    GLES20.glUniform1i(this.g, 1);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        TLog.b("GPUImagePixelationFilter", "mosaic bitmap recycle");
      }
    }
    int i = this.f;
    if (i != -1) {
      GlUtil.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer.GPUImagePixelationFilter
 * JD-Core Version:    0.7.0.1
 */