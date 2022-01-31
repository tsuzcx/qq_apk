package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class GPUDrawPartFilter
  extends GPUBaseFilter
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.a(BaseApplicationImpl.getContext(), 2131230755);
  private float jdField_a_of_type_Float = 0.0F;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  private int e;
  private int f;
  private int g;
  
  public GPUDrawPartFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
  }
  
  public GPUDrawPartFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.d = 0;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    if (paramFloat > 1.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat < 0.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.b = paramBoolean;
        this.jdField_a_of_type_Float = paramFloat;
        return;
      }
    }
  }
  
  protected void c()
  {
    this.e = GLES20.glGetUniformLocation(a(), "percent");
    this.f = GLES20.glGetUniformLocation(a(), "drawPart");
    this.g = GLES20.glGetUniformLocation(a(), "cutX");
  }
  
  protected void f()
  {
    float f2 = 1.0F;
    int i = this.f;
    if (this.b)
    {
      f1 = 1.0F;
      GLES20.glUniform1f(i, f1);
      GLES20.glUniform1f(this.e, this.jdField_a_of_type_Float);
      i = this.g;
      if (!this.jdField_a_of_type_Boolean) {
        break label57;
      }
    }
    label57:
    for (float f1 = f2;; f1 = 2.0F)
    {
      GLES20.glUniform1f(i, f1);
      return;
      f1 = 2.0F;
      break;
    }
  }
  
  public String toString()
  {
    double d2 = 1.0D;
    int i = this.d;
    double d1;
    float f1;
    if (this.b)
    {
      d1 = 1.0D;
      f1 = this.jdField_a_of_type_Float;
      if (!this.jdField_a_of_type_Boolean) {
        break label77;
      }
    }
    for (;;)
    {
      return String.format("filter type=%s, draw left=%s, draw percent=%s, directionx=%s", new Object[] { Integer.valueOf(i), Double.valueOf(d1), Float.valueOf(f1), Double.valueOf(d2) });
      d1 = 2.0D;
      break;
      label77:
      d2 = 2.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUDrawPartFilter
 * JD-Core Version:    0.7.0.1
 */