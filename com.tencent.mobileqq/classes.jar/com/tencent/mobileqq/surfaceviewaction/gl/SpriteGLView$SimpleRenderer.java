package com.tencent.mobileqq.surfaceviewaction.gl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mobileqq.surfaceviewaction.util.GLUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class SpriteGLView$SimpleRenderer
  implements GLSurfaceView.Renderer
{
  private final float[] b = new float[16];
  private final float[] c = new float[16];
  private final float[] d = new float[16];
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private long j;
  private int k = 0;
  private Label l;
  
  private SpriteGLView$SimpleRenderer(SpriteGLView paramSpriteGLView) {}
  
  @SuppressLint({"DefaultLocale"})
  public void onDrawFrame(GL10 paramGL10)
  {
    paramGL10 = SpriteGLView.b(this.a);
    int m = 0;
    try
    {
      while (m < SpriteGLView.c(this.a).size())
      {
        ((Runnable)SpriteGLView.c(this.a).get(m)).run();
        m += 1;
      }
      SpriteGLView.c(this.a).clear();
      paramGL10 = SpriteGLView.d(this.a);
      m = 0;
      try
      {
        while (m < SpriteGLView.e(this.a).size())
        {
          ((Runnable)SpriteGLView.e(this.a).get(m)).run();
          m += 1;
        }
        GLES20.glClear(16640);
        paramGL10 = SpriteGLView.a(this.a).toArray();
        int n = paramGL10.length;
        m = 0;
        while (m < n)
        {
          Object localObject1 = paramGL10[m];
          if ((localObject1 instanceof Node))
          {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glUseProgram(this.a.w);
            ((Node)localObject1).c(this.a.getWidth(), this.a.getHeight(), this.e, this.g, this.f, this.h, this.i, this.d);
          }
          m += 1;
        }
        if (this.a.u)
        {
          this.k += 1;
          if (this.k >= 5)
          {
            m = (int)(System.currentTimeMillis() - this.j);
            paramGL10 = String.format("fps: %.1f", new Object[] { Float.valueOf(this.k * 1000.0F / m) });
            this.j = System.currentTimeMillis();
            this.k = 0;
            this.l.a(this.a, paramGL10);
          }
          GLES20.glUseProgram(this.a.w);
          this.l.c(this.a.getWidth(), this.a.getHeight(), this.e, this.g, this.f, this.h, this.i, this.d);
        }
        GLES20.glFlush();
        return;
      }
      finally {}
      throw localObject3;
    }
    finally {}
    for (;;) {}
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    float f1 = paramInt1 / paramInt2;
    Matrix.frustumM(this.b, 0, -f1, f1, -1.0F, 1.0F, 3.0F, 7.0F);
    Matrix.setLookAtM(this.c, 0, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    Matrix.multiplyMM(this.d, 0, this.b, 0, this.c, 0);
    this.l.d = (DisplayUtil.a(this.a.getContext(), 50.0F) - paramInt1 / 2);
    this.l.e = (DisplayUtil.a(this.a.getContext(), 10.0F) - paramInt2 / 2);
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    this.a.p();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    try
    {
      paramGL10 = this.a;
      paramEGLConfig = this.a.getContext();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troop");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("shaders");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("VertexShader.glsl");
      paramEGLConfig = GLUtil.a(paramEGLConfig, ((StringBuilder)localObject).toString());
      localObject = this.a.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("shaders");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("FragmentShader.glsl");
      paramGL10.w = GLUtil.a(paramEGLConfig, GLUtil.a((Context)localObject, localStringBuilder.toString()));
      GLES20.glUseProgram(this.a.w);
      this.e = GLES20.glGetAttribLocation(this.a.w, "vPosition");
      this.g = GLES20.glGetAttribLocation(this.a.w, "a_texCoord");
      this.f = GLES20.glGetUniformLocation(this.a.w, "uMVPMatrix");
      this.h = GLES20.glGetUniformLocation(this.a.w, "s_texture");
      this.i = GLES20.glGetUniformLocation(this.a.w, "v_alpha");
    }
    catch (Exception paramGL10)
    {
      QLog.e("SpriteGLView", 2, QLog.getStackTraceString(paramGL10));
    }
    paramGL10 = new StringBuilder();
    paramGL10.append("program = ");
    paramGL10.append(this.a.w);
    paramGL10.append(",mPositionHandle =");
    paramGL10.append(this.e);
    paramGL10.append(",mTexCoordHandle =");
    paramGL10.append(this.g);
    paramGL10.append(",mMatrixHandle= ");
    paramGL10.append(this.f);
    paramGL10.append(",mTexSamplerHandle =");
    paramGL10.append(this.h);
    paramGL10.append(",mAlphaHandle = ");
    paramGL10.append(this.i);
    QLog.i("SpriteGLView", 1, paramGL10.toString());
    paramGL10 = this.a;
    this.l = new Label(paramGL10, paramGL10.getContext(), "fps:", -1, 40);
    SpriteGLView.a(this.a, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView.SimpleRenderer
 * JD-Core Version:    0.7.0.1
 */