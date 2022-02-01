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
  private static final float[] c = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private static final FloatBuffer d = GlUtil.createFloatBuffer(e);
  private static float[] e = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public int a = 3553;
  protected int b = 101;
  private final String f;
  private final String g;
  private int h;
  private boolean i;
  private FloatBuffer j = GlUtil.createFloatBuffer(c);
  
  public GPUBaseFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public GPUBaseFilter(String paramString1, String paramString2)
  {
    this.f = paramString1;
    this.g = paramString2;
    this.a = 3553;
    this.b = 101;
  }
  
  protected static void a(int paramInt, String paramString)
  {
    if (paramInt < 0)
    {
      if (!TopicSDK.d().b().s()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to locate '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in program");
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  private static void a(String paramString)
  {
    int k = GLES20.glGetError();
    if (k != 0)
    {
      if (!TopicSDK.d().b().s()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(k);
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a("onDrawFrame start");
    int i1 = e();
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
    GLES20.glUseProgram(i1);
    a("glUseProgram");
    int k = GLES20.glGetAttribLocation(i1, "aPosition");
    a(k, "aPosition");
    int m = GLES20.glGetAttribLocation(i1, "aTextureCoord");
    a(m, "aTextureCoord");
    int n = GLES20.glGetUniformLocation(i1, "uMVPMatrix");
    a(n, "uMVPMatrix");
    i1 = GLES20.glGetUniformLocation(i1, "uTextureMatrix");
    a(i1, "uTextureMatrix");
    GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, d);
    a("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(k);
    a("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(m, 2, 5126, false, 8, this.j);
    a("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(m);
    a("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(n, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(i1, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.a, paramInt);
    b();
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.a, 0);
  }
  
  protected void b() {}
  
  protected void c() {}
  
  public void d()
  {
    if (!this.i)
    {
      Object localObject = ProgramTools.createProgram(this.f, this.g);
      if (localObject == null)
      {
        if (!TopicSDK.d().b().s()) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("failed creating program ");
        ((StringBuilder)localObject).append(getClass().getSimpleName());
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      this.h = ((ProgramTools.ProgramInfo)localObject).programId;
      this.i = true;
      a();
    }
  }
  
  protected int e()
  {
    return this.h;
  }
  
  public void f()
  {
    this.i = false;
    GLES20.glDeleteProgram(this.h);
    this.h = 0;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUBaseFilter
 * JD-Core Version:    0.7.0.1
 */