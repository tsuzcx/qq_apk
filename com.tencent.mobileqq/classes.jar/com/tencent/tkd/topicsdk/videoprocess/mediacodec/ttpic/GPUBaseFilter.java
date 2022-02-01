package com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.ProgramTools;
import com.tencent.aekit.openrender.util.ProgramTools.ProgramInfo;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import java.nio.FloatBuffer;

public class GPUBaseFilter
{
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(jdField_b_of_type_ArrayOfFloat);
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private static float[] jdField_b_of_type_ArrayOfFloat = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public int a;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private final String jdField_b_of_type_JavaLangString;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(jdField_a_of_type_ArrayOfFloat);
  private int c;
  
  public GPUBaseFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public GPUBaseFilter(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 3553;
    this.jdField_b_of_type_Int = 101;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = 3553;
    this.jdField_b_of_type_Int = 101;
  }
  
  protected static void a(int paramInt, String paramString)
  {
    if ((paramInt < 0) && (TopicSDK.b().a().a())) {
      throw new RuntimeException("Unable to locate '" + paramString + "' in program");
    }
  }
  
  private static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if ((i != 0) && (TopicSDK.b().a().a())) {
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }
  
  protected int a()
  {
    return this.c;
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a("onDrawFrame start");
    int m = a();
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
    GLES20.glUseProgram(m);
    a("glUseProgram");
    int i = GLES20.glGetAttribLocation(m, "aPosition");
    a(i, "aPosition");
    int j = GLES20.glGetAttribLocation(m, "aTextureCoord");
    a(j, "aTextureCoord");
    int k = GLES20.glGetUniformLocation(m, "uMVPMatrix");
    a(k, "uMVPMatrix");
    m = GLES20.glGetUniformLocation(m, "uTextureMatrix");
    a(m, "uTextureMatrix");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    a("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, this.jdField_b_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    a("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(k, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(m, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.jdField_a_of_type_Int, paramInt);
    b();
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.jdField_a_of_type_Int, 0);
  }
  
  protected void b() {}
  
  protected void c() {}
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ProgramTools.ProgramInfo localProgramInfo = ProgramTools.createProgram(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      if (localProgramInfo == null)
      {
        if (TopicSDK.b().a().a()) {
          throw new RuntimeException("failed creating program " + getClass().getSimpleName());
        }
      }
      else
      {
        this.c = localProgramInfo.programId;
        this.jdField_a_of_type_Boolean = true;
        a();
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    GLES20.glDeleteProgram(this.c);
    this.c = 0;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUBaseFilter
 * JD-Core Version:    0.7.0.1
 */