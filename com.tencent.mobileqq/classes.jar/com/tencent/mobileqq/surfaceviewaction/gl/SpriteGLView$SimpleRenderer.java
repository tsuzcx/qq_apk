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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Label jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int;
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private final float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private int d;
  private int e;
  private int f = 0;
  
  private SpriteGLView$SimpleRenderer(SpriteGLView paramSpriteGLView) {}
  
  @SuppressLint({"DefaultLocale"})
  public void onDrawFrame(GL10 paramGL10)
  {
    paramGL10 = SpriteGLView.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView);
    int i = 0;
    try
    {
      while (i < SpriteGLView.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).size())
      {
        ((Runnable)SpriteGLView.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).get(i)).run();
        i += 1;
      }
      SpriteGLView.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).clear();
      paramGL10 = SpriteGLView.b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView);
      i = 0;
      try
      {
        while (i < SpriteGLView.c(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).size())
        {
          ((Runnable)SpriteGLView.c(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).get(i)).run();
          i += 1;
        }
        GLES20.glClear(16640);
        paramGL10 = SpriteGLView.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).toArray();
        int j = paramGL10.length;
        i = 0;
        while (i < j)
        {
          Object localObject1 = paramGL10[i];
          if ((localObject1 instanceof Node))
          {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glUseProgram(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int);
            ((Node)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getHeight(), this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.d, this.e, this.jdField_c_of_type_ArrayOfFloat);
          }
          i += 1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.a)
        {
          this.f += 1;
          if (this.f >= 5)
          {
            i = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
            paramGL10 = String.format("fps: %.1f", new Object[] { Float.valueOf(this.f * 1000.0F / i) });
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            this.f = 0;
            this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, paramGL10);
          }
          GLES20.glUseProgram(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.c(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getHeight(), this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int, this.d, this.e, this.jdField_c_of_type_ArrayOfFloat);
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
    Matrix.frustumM(this.jdField_a_of_type_ArrayOfFloat, 0, -f1, f1, -1.0F, 1.0F, 3.0F, 7.0F);
    Matrix.setLookAtM(this.jdField_b_of_type_ArrayOfFloat, 0, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    Matrix.multiplyMM(this.jdField_c_of_type_ArrayOfFloat, 0, this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.c = (DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), 50.0F) - paramInt1 / 2);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel.d = (DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext(), 10.0F) - paramInt2 / 2);
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.o();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    try
    {
      paramGL10 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView;
      paramEGLConfig = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troop");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("shaders");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("VertexShader.glsl");
      paramEGLConfig = GLUtil.a(paramEGLConfig, ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troop");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("shaders");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("FragmentShader.glsl");
      paramGL10.jdField_c_of_type_Int = GLUtil.a(paramEGLConfig, GLUtil.a((Context)localObject, localStringBuilder.toString()));
      GLES20.glUseProgram(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int);
      this.jdField_a_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "vPosition");
      this.jdField_c_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "a_texCoord");
      this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "uMVPMatrix");
      this.d = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "s_texture");
      this.e = GLES20.glGetUniformLocation(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int, "v_alpha");
    }
    catch (Exception paramGL10)
    {
      QLog.e("SpriteGLView", 2, QLog.getStackTraceString(paramGL10));
    }
    paramGL10 = new StringBuilder();
    paramGL10.append("program = ");
    paramGL10.append(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_c_of_type_Int);
    paramGL10.append(",mPositionHandle =");
    paramGL10.append(this.jdField_a_of_type_Int);
    paramGL10.append(",mTexCoordHandle =");
    paramGL10.append(this.jdField_c_of_type_Int);
    paramGL10.append(",mMatrixHandle= ");
    paramGL10.append(this.jdField_b_of_type_Int);
    paramGL10.append(",mTexSamplerHandle =");
    paramGL10.append(this.d);
    paramGL10.append(",mAlphaHandle = ");
    paramGL10.append(this.e);
    QLog.i("SpriteGLView", 1, paramGL10.toString());
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView;
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlLabel = new Label(paramGL10, paramGL10.getContext(), "fps:", -1, 40);
    SpriteGLView.a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView.SimpleRenderer
 * JD-Core Version:    0.7.0.1
 */