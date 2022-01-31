package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class GPUOESMovieFilter
  extends GPUBaseFilter
{
  private static final short[] jdField_a_of_type_ArrayOfShort = { 0, 1, 2, 0, 2, 3 };
  private static float jdField_c_of_type_Float = 0.5F;
  public float a;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer;
  private boolean jdField_a_of_type_Boolean = true;
  public float b;
  private FloatBuffer b;
  private FloatBuffer jdField_c_of_type_JavaNioFloatBuffer;
  private float[] jdField_c_of_type_ArrayOfFloat = { -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  private float[] d;
  public int e;
  private float[] e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  public GPUOESMovieFilter()
  {
    super("attribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nattribute vec4 vTexAlphaCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    v_TexAlphaCoordinate = (textureTransform * vTexAlphaCoordinate).xy;\n    gl_Position = vPosition;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvarying vec2 v_TexAlphaCoordinate;\nuniform int v_isAlpha;\nuniform float real_half;\nuniform float x_add_margin;\n\nvoid main () {\n    if(v_TexCoordinate.x  > x_add_margin && v_TexCoordinate.x  < real_half - x_add_margin\n    && v_TexCoordinate.y  > 0.0 && v_TexCoordinate.y  < 1.0) {\n        vec4 color;\n        color = texture2D(texture, v_TexCoordinate);\n        float alpha = 1.0;\n        if (v_isAlpha == 1) {\n            alpha = texture2D(texture, v_TexAlphaCoordinate).g;\n        }\n        gl_FragColor = color;\n        gl_FragColor.a = gl_FragColor.a * alpha;\n        gl_FragColor.r = gl_FragColor.r * alpha;\n        gl_FragColor.g = gl_FragColor.g * alpha;\n        gl_FragColor.b = gl_FragColor.b * alpha;\n    } else {\n        gl_FragColor = vec4(0.0, 0.0, 0.0, 0.0);\n    } \n}");
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_e_of_type_Int = 255;
    this.jdField_c_of_type_Int = 36197;
    this.jdField_d_of_type_Int = 102;
    this.jdField_d_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, jdField_c_of_type_Float, 0.0F, 0.0F, 1.0F, jdField_c_of_type_Float, 1.0F, 0.0F, 1.0F };
    this.jdField_e_of_type_ArrayOfFloat = new float[] { jdField_c_of_type_Float, 1.0F, 0.0F, 1.0F, jdField_c_of_type_Float, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  }
  
  private void g()
  {
    int n = a();
    GLES20.glUseProgram(n);
    this.f = GLES20.glGetUniformLocation(n, "texture");
    this.g = GLES20.glGetAttribLocation(n, "vTexCoordinate");
    this.h = GLES20.glGetAttribLocation(n, "vTexAlphaCoordinate");
    this.i = GLES20.glGetAttribLocation(n, "vPosition");
    this.j = GLES20.glGetUniformLocation(n, "textureTransform");
    this.k = GLES20.glGetUniformLocation(n, "v_isAlpha");
    this.l = GLES20.glGetUniformLocation(n, "real_half");
    this.m = GLES20.glGetUniformLocation(n, "x_add_margin");
  }
  
  private void h()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfShort.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
    this.jdField_a_of_type_JavaNioShortBuffer.put(jdField_a_of_type_ArrayOfShort);
    this.jdField_a_of_type_JavaNioShortBuffer.position(0);
    this.jdField_c_of_type_JavaNioFloatBuffer = GlUtil.a(this.jdField_c_of_type_ArrayOfFloat);
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_JavaNioFloatBuffer != null) && (this.jdField_b_of_type_JavaNioFloatBuffer != null))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.clear();
      this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_d_of_type_ArrayOfFloat);
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      this.jdField_b_of_type_JavaNioFloatBuffer.clear();
      this.jdField_b_of_type_JavaNioFloatBuffer.put(this.jdField_e_of_type_ArrayOfFloat);
      this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
      return;
    }
    this.jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(this.jdField_d_of_type_ArrayOfFloat);
    this.jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(this.jdField_e_of_type_ArrayOfFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1;
    if ((this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Int != 0))
    {
      paramFloat1 = paramFloat1 / jdField_c_of_type_Float / (this.jdField_b_of_type_Int * 1.0F / this.jdField_a_of_type_Int);
      if (paramFloat1 > 1.0F)
      {
        f1 = 1.0F;
        if (paramFloat1 <= 1.0F) {
          break label294;
        }
        paramFloat1 = 1.0F / paramFloat1;
      }
    }
    for (;;)
    {
      float f2 = jdField_c_of_type_Float * 0.5F * (1.0F - f1);
      float f3 = (1.0F - paramFloat1) * 0.5F;
      paramFloat2 = f1 * (jdField_c_of_type_Float * paramFloat2);
      paramFloat1 *= paramFloat3;
      this.jdField_d_of_type_ArrayOfFloat[0] = (f2 + paramFloat2);
      this.jdField_d_of_type_ArrayOfFloat[1] = (1.0F - f3 + paramFloat1);
      this.jdField_d_of_type_ArrayOfFloat[4] = (f2 + paramFloat2);
      this.jdField_d_of_type_ArrayOfFloat[5] = (f3 + paramFloat1);
      this.jdField_d_of_type_ArrayOfFloat[8] = (jdField_c_of_type_Float - f2 + paramFloat2);
      this.jdField_d_of_type_ArrayOfFloat[9] = (f3 + paramFloat1);
      this.jdField_d_of_type_ArrayOfFloat[12] = (jdField_c_of_type_Float - f2 + paramFloat2);
      this.jdField_d_of_type_ArrayOfFloat[13] = (1.0F - f3 + paramFloat1);
      this.jdField_e_of_type_ArrayOfFloat[0] = (jdField_c_of_type_Float + f2 + paramFloat2);
      this.jdField_e_of_type_ArrayOfFloat[1] = (1.0F - f3 + paramFloat1);
      this.jdField_e_of_type_ArrayOfFloat[4] = (jdField_c_of_type_Float + f2 + paramFloat2);
      this.jdField_e_of_type_ArrayOfFloat[5] = (f3 + paramFloat1);
      this.jdField_e_of_type_ArrayOfFloat[8] = (1.0F - f2 + paramFloat2);
      this.jdField_e_of_type_ArrayOfFloat[9] = (f3 + paramFloat1);
      this.jdField_e_of_type_ArrayOfFloat[12] = (paramFloat2 + (1.0F - f2));
      this.jdField_e_of_type_ArrayOfFloat[13] = (paramFloat1 + (1.0F - f3));
      i();
      return;
      f1 = paramFloat1;
      break;
      label294:
      paramFloat1 = 1.0F;
      continue;
      paramFloat1 = 1.0F;
      f1 = 1.0F;
    }
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat)
  {
    if (this.jdField_c_of_type_JavaNioFloatBuffer == null) {
      return;
    }
    float[] arrayOfFloat = paramArrayOfFloat;
    if (paramArrayOfFloat == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    GLES20.glUseProgram(a());
    GLES20.glEnableVertexAttribArray(this.i);
    GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, this.jdField_c_of_type_JavaNioFloatBuffer);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.jdField_c_of_type_Int, paramInt);
    GLES20.glUniform1i(this.f, 0);
    float f1 = jdField_c_of_type_Float;
    float f2 = arrayOfFloat[0];
    GLES20.glUniform1f(this.l, f1 * f2);
    GLES20.glUniform1f(this.m, arrayOfFloat[0] / this.jdField_a_of_type_Int * 2.0F);
    GLES20.glEnableVertexAttribArray(this.g);
    GLES20.glVertexAttribPointer(this.g, 4, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
    if (this.jdField_a_of_type_Boolean)
    {
      GLES20.glUniform1i(this.k, 1);
      GLES20.glEnableVertexAttribArray(this.h);
      GLES20.glVertexAttribPointer(this.h, 4, 5126, false, 0, this.jdField_b_of_type_JavaNioFloatBuffer);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(this.j, 1, false, arrayOfFloat, 0);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      GLES20.glDrawElements(4, jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
      GLES20.glDisableVertexAttribArray(this.i);
      GLES20.glDisableVertexAttribArray(this.g);
      GLES20.glDisableVertexAttribArray(this.h);
      return;
      GLES20.glUniform1i(this.k, 0);
    }
  }
  
  protected void c()
  {
    g();
    h();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter
 * JD-Core Version:    0.7.0.1
 */