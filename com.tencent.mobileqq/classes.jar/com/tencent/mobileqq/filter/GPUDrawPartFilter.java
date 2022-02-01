package com.tencent.mobileqq.filter;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import mqq.app.MobileQQ;

public class GPUDrawPartFilter
  extends GPUBaseFilter
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.readTextFromRawResource(MobileQQ.getContext(), 2131230763);
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  public GPUDrawPartFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
  }
  
  public GPUDrawPartFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.mFilterType = 0;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    paramFloat = f;
    if (f < 0.0F) {
      paramFloat = 0.0F;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  protected void onDrawTexture()
  {
    int i = this.jdField_b_of_type_Int;
    boolean bool = this.jdField_b_of_type_Boolean;
    float f2 = 1.0F;
    float f1;
    if (bool) {
      f1 = 1.0F;
    } else {
      f1 = 2.0F;
    }
    GLES20.glUniform1f(i, f1);
    GLES20.glUniform1f(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float);
    i = this.c;
    if (this.jdField_a_of_type_Boolean) {
      f1 = f2;
    } else {
      f1 = 2.0F;
    }
    GLES20.glUniform1f(i, f1);
  }
  
  protected void onInitialized()
  {
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "percent");
    this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "drawPart");
    this.c = GLES20.glGetUniformLocation(getProgram(), "cutX");
  }
  
  public String toString()
  {
    int i = this.mFilterType;
    boolean bool = this.jdField_b_of_type_Boolean;
    double d2 = 1.0D;
    double d1;
    if (bool) {
      d1 = 1.0D;
    } else {
      d1 = 2.0D;
    }
    float f = this.jdField_a_of_type_Float;
    if (!this.jdField_a_of_type_Boolean) {
      d2 = 2.0D;
    }
    return String.format("filter type=%s, draw left=%s, draw percent=%s, directionx=%s", new Object[] { Integer.valueOf(i), Double.valueOf(d1), Float.valueOf(f), Double.valueOf(d2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filter.GPUDrawPartFilter
 * JD-Core Version:    0.7.0.1
 */