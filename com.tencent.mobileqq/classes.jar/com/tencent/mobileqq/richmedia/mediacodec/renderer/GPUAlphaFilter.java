package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.FloatBuffer;

public class GPUAlphaFilter
  extends GPUBaseFilter
{
  private static final FloatBuffer a;
  private static final FloatBuffer b;
  
  static
  {
    jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_a_of_type_ArrayOfFloat);
    jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_b_of_type_ArrayOfFloat);
  }
  
  public GPUAlphaFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nattribute vec4 a_color;\nvarying vec4 v_color;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n    v_color = a_color;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\nvarying vec4 v_color;\n\nvoid main() {\n    gl_FragColor = v_color * texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public GPUAlphaFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, FloatBuffer paramFloatBuffer)
  {
    a("onDrawFrame start");
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    int n = a();
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null)
    {
      paramArrayOfFloat1 = new float[16];
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
    GLES20.glUseProgram(n);
    a("glUseProgram");
    int i = GLES20.glGetAttribLocation(n, "aPosition");
    a(i, "aPosition");
    int j = GLES20.glGetAttribLocation(n, "aTextureCoord");
    a(j, "aTextureCoord");
    int k = GLES20.glGetAttribLocation(n, "a_color");
    a(k, "a_color");
    int m = GLES20.glGetUniformLocation(n, "uMVPMatrix");
    a(m, "uMVPMatrix");
    n = GLES20.glGetUniformLocation(n, "uTextureMatrix");
    a(n, "uTextureMatrix");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    a("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, jdField_b_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    a("glEnableVertexAttribArray mTextureHandle");
    GLES20.glVertexAttribPointer(k, 4, 5126, false, 0, paramFloatBuffer);
    a("glVertexAttribPointer aColor");
    GLES20.glEnableVertexAttribArray(k);
    a("glEnableVertexAttribArray aColor");
    GLES20.glUniformMatrix4fv(m, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(n, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, paramInt);
    f();
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, 0);
    GLES20.glDisable(3042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaFilter
 * JD-Core Version:    0.7.0.1
 */