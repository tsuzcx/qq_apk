package com.tencent.qqmini.sdk.runtime.util.TextureRender;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qqmini.sdk.log.QMLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class VideoTextureRenderer
  extends TextureSurfaceRenderer
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static float jdField_a_of_type_Float = 1.0F;
  private static float[] jdField_a_of_type_ArrayOfFloat = { -jdField_a_of_type_Float, jdField_a_of_type_Float, 0.0F, -jdField_a_of_type_Float, -jdField_a_of_type_Float, 0.0F, jdField_a_of_type_Float, -jdField_a_of_type_Float, 0.0F, jdField_a_of_type_Float, jdField_a_of_type_Float, 0.0F };
  private static short[] jdField_a_of_type_ArrayOfShort = { 0, 1, 2, 0, 2, 3 };
  private static float[] jdField_b_of_type_ArrayOfFloat = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private Context jdField_a_of_type_AndroidContentContext;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private String jdField_a_of_type_JavaLangString = "contain";
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private ShortBuffer jdField_a_of_type_JavaNioShortBuffer;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public VideoTextureRenderer(Context paramContext, Surface paramSurface, int paramInt1, int paramInt2, Handler paramHandler)
  {
    super(paramSurface, paramInt1, paramInt2, paramHandler);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_ArrayOfFloat = new float[16];
  }
  
  private void a(Context paramContext)
  {
    try
    {
      paramContext = ByteBuffer.allocateDirect(jdField_b_of_type_ArrayOfFloat.length * 4);
      paramContext.order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_JavaNioFloatBuffer = paramContext.asFloatBuffer();
      this.jdField_a_of_type_JavaNioFloatBuffer.put(jdField_b_of_type_ArrayOfFloat);
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glGenTextures(1, this.jdField_a_of_type_ArrayOfInt, 0);
      a("Texture generate");
      GLES20.glBindTexture(36197, this.jdField_a_of_type_ArrayOfInt[0]);
      a("Texture bind");
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ArrayOfInt[0]);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("miniapp-embedded", "setupTexture error.", paramContext);
    }
  }
  
  private void f()
  {
    try
    {
      QMLog.d("miniapp-embedded", "loadShaders");
      this.jdField_c_of_type_Int = GLES20.glCreateShader(35633);
      GLES20.glShaderSource(this.jdField_c_of_type_Int, "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}");
      GLES20.glCompileShader(this.jdField_c_of_type_Int);
      a("Vertex shader compile");
      this.d = GLES20.glCreateShader(35632);
      GLES20.glShaderSource(this.d, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}");
      GLES20.glCompileShader(this.d);
      a("Pixel shader compile");
      this.e = GLES20.glCreateProgram();
      GLES20.glAttachShader(this.e, this.jdField_c_of_type_Int);
      GLES20.glAttachShader(this.e, this.d);
      GLES20.glLinkProgram(this.e);
      a("Shader program compile");
      Object localObject = new int[1];
      GLES20.glGetProgramiv(this.e, 35714, (int[])localObject, 0);
      if (localObject[0] != 1)
      {
        localObject = GLES20.glGetProgramInfoLog(this.e);
        QMLog.e("miniapp-embedded", "Error while linking program:\n" + (String)localObject);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "loadShaders error.", localThrowable);
    }
  }
  
  private void g()
  {
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfShort.length * 2);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_JavaNioShortBuffer = localByteBuffer.asShortBuffer();
      this.jdField_a_of_type_JavaNioShortBuffer.put(jdField_a_of_type_ArrayOfShort);
      this.jdField_a_of_type_JavaNioShortBuffer.position(0);
      localByteBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfFloat.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.jdField_b_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
      this.jdField_b_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
      this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "setupVertexBuffer error.", localThrowable);
    }
  }
  
  private void h()
  {
    float f1;
    float f2;
    float f3;
    if ("contain".equals(this.jdField_a_of_type_JavaLangString))
    {
      f1 = Math.min(this.jdField_a_of_type_Int / this.f, this.jdField_b_of_type_Int / this.g);
      QMLog.d("miniapp-embedded", "contain scale : " + f1);
      f2 = Math.round((this.jdField_a_of_type_Int - this.f * f1) * 0.5F);
      f3 = Math.round((this.jdField_b_of_type_Int - this.g * f1) * 0.5F);
      GLES20.glViewport((int)f2, (int)f3, (int)(this.f * f1), (int)(f1 * this.g));
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
      if ("fill".equals(this.jdField_a_of_type_JavaLangString))
      {
        GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      else if ("cover".equals(this.jdField_a_of_type_JavaLangString))
      {
        f1 = Math.max(this.jdField_a_of_type_Int / this.f, this.jdField_b_of_type_Int / this.g);
        QMLog.d("miniapp-embedded", "cover scale : " + f1);
        f2 = Math.round((this.jdField_a_of_type_Int - this.f * f1) * 0.5F);
        f3 = Math.round((this.jdField_b_of_type_Int - this.g * f1) * 0.5F);
        GLES20.glViewport((int)f2, (int)f3, (int)(this.f * f1), (int)(f1 * this.g));
      }
    }
  }
  
  public SurfaceTexture a()
  {
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  }
  
  protected void a()
  {
    QMLog.d("miniapp-embedded", "initGLComponents ： " + Thread.currentThread());
    g();
    a(this.jdField_a_of_type_AndroidContentContext);
    f();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QMLog.e("miniapp-embedded", "setSurfaceSize " + paramInt1 + "; " + paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.e("miniapp-embedded", "setVideoSize " + paramInt1 + "; " + paramInt2 + "; " + paramString);
    this.f = paramInt1;
    this.g = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      QMLog.d("miniapp-embedded", paramString + ": glError " + GLUtils.getEGLErrorString(i));
    }
  }
  
  protected boolean a()
  {
    try
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_c_of_type_ArrayOfFloat);
          this.jdField_a_of_type_Boolean = false;
          if (this.jdField_b_of_type_Boolean) {
            h();
          }
          GLES20.glClearColor(1.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16384);
          GLES20.glUseProgram(this.e);
          int i = GLES20.glGetUniformLocation(this.e, "texture");
          int j = GLES20.glGetAttribLocation(this.e, "vTexCoordinate");
          int k = GLES20.glGetAttribLocation(this.e, "vPosition");
          int m = GLES20.glGetUniformLocation(this.e, "textureTransform");
          GLES20.glEnableVertexAttribArray(k);
          GLES20.glVertexAttribPointer(k, 3, 5126, false, 12, this.jdField_b_of_type_JavaNioFloatBuffer);
          GLES20.glBindTexture(36197, this.jdField_a_of_type_ArrayOfInt[0]);
          GLES20.glActiveTexture(33984);
          GLES20.glUniform1i(i, 0);
          GLES20.glEnableVertexAttribArray(j);
          GLES20.glVertexAttribPointer(j, 4, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
          GLES20.glUniformMatrix4fv(m, 1, false, this.jdField_c_of_type_ArrayOfFloat, 0);
          GLES20.glDrawElements(4, jdField_a_of_type_ArrayOfShort.length, 5123, this.jdField_a_of_type_JavaNioShortBuffer);
          GLES20.glDisableVertexAttribArray(k);
          GLES20.glDisableVertexAttribArray(j);
          return true;
        }
        return false;
      }
      finally {}
      return false;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "draw error.", localThrowable);
    }
  }
  
  protected void b()
  {
    GLES20.glDeleteTextures(1, this.jdField_a_of_type_ArrayOfInt, 0);
    GLES20.glDeleteProgram(this.e);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.util.TextureRender.VideoTextureRenderer
 * JD-Core Version:    0.7.0.1
 */