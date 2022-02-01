package com.tencent.mobileqq.shortvideo.util;

import ambf;
import ambh;
import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;

@TargetApi(17)
public class SVOpenglFlipFilter
{
  private int jdField_a_of_type_Int;
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
  private EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  private OffScreenInputSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private int jdField_b_of_type_Int;
  private EGLContext jdField_b_of_type_AndroidOpenglEGLContext;
  private EGLSurface jdField_b_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  private int c;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  
  public SVOpenglFlipFilter(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_AndroidOpenglEGLContext = paramEGLContext;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
  }
  
  public static void b(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      throw new RuntimeException("glGetError encountered (see log)" + paramString + " :glGetError: 0x" + Integer.toHexString(i));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = new OffScreenInputSurface(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_AndroidOpenglEGLContext);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.c();
      a(" precision highp float;\n varying vec2 textureCoordinateOut;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinateOut);\n}\n");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glUseProgram(this.c);
    GLES20.glUniform1i(this.d, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glDrawArrays(6, 0, 4);
    PtvFilterUtils.a(false);
  }
  
  public void a(String paramString)
  {
    this.c = ambh.a("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 textureCoordinateOut;\nvoid main()\n{\ntextureCoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", paramString);
    if (this.c == 0) {
      throw new SVOpenglFlipFilter.EGLCreateProgramException("initOpenGlAtrribute:createShaderProgram = 0");
    }
    GLES20.glUseProgram(this.c);
    this.e = GLES20.glGetAttribLocation(this.c, "position");
    this.f = GLES20.glGetAttribLocation(this.c, "textureCoordinateIn");
    this.d = GLES20.glGetUniformLocation(this.c, "inputImageTexture");
    ambf.a(this.jdField_a_of_type_ArrayOfInt, this.e, this.f);
    b("createSquareVtx");
    GLES20.glDisable(2929);
    GLES20.glDisable(2884);
    GLES20.glDisable(3042);
  }
  
  public boolean a(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    return (this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2) && (this.jdField_b_of_type_AndroidOpenglEGLContext != OffScreenInputSurface.a()) && (paramEGLContext.equals(this.jdField_b_of_type_AndroidOpenglEGLContext));
  }
  
  public void b()
  {
    this.c = 0;
    this.jdField_b_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface.b();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenInputSurface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SVOpenglFlipFilter
 * JD-Core Version:    0.7.0.1
 */