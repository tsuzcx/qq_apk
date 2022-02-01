package com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer;

import android.opengl.GLES20;
import com.tencent.tkd.R.raw;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.GlUtil;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUBaseFilter;
import org.jetbrains.annotations.NotNull;

public class GPUDrawPartFilter
  extends GPUBaseFilter
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.a(AppContext.a, R.raw.a);
  private float jdField_a_of_type_Float = 0.0F;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private int c;
  private int d;
  private int e;
  
  GPUDrawPartFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
  }
  
  GPUDrawPartFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
  }
  
  protected void a()
  {
    this.c = GLES20.glGetUniformLocation(a(), "percent");
    this.d = GLES20.glGetUniformLocation(a(), "drawPart");
    this.e = GLES20.glGetUniformLocation(a(), "cutX");
  }
  
  protected void b()
  {
    int i = this.d;
    boolean bool = this.jdField_b_of_type_Boolean;
    float f2 = 1.0F;
    float f1;
    if (bool) {
      f1 = 1.0F;
    } else {
      f1 = 2.0F;
    }
    GLES20.glUniform1f(i, f1);
    GLES20.glUniform1f(this.c, this.jdField_a_of_type_Float);
    i = this.e;
    if (this.jdField_a_of_type_Boolean) {
      f1 = f2;
    } else {
      f1 = 2.0F;
    }
    GLES20.glUniform1f(i, f1);
  }
  
  @NotNull
  public String toString()
  {
    int i = this.jdField_b_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.renderer.GPUDrawPartFilter
 * JD-Core Version:    0.7.0.1
 */