package com.tencent.qqmini.sdk.runtime.widget.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera.Size;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import bhkf;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GlCameraSurfaceView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Camera.Size jdField_a_of_type_AndroidHardwareCamera$Size;
  private bhkf jdField_a_of_type_Bhkf;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private int b;
  
  public GlCameraSurfaceView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GlCameraSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private static int a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    GLES20.glBindTexture(36197, 0);
    return arrayOfInt[0];
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      return;
    }
    this.jdField_a_of_type_Int = a();
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_Bhkf = new bhkf();
  }
  
  private void c()
  {
    int m = 0;
    int i = getWidth();
    int j = getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    int k;
    int n;
    if (this.jdField_a_of_type_AndroidHardwareCamera$Size != null)
    {
      k = this.jdField_a_of_type_AndroidHardwareCamera$Size.height;
      n = this.jdField_a_of_type_AndroidHardwareCamera$Size.width;
      Log.i("CameraSurfaceView", "changeGlSurfaceSize: " + this.jdField_a_of_type_AndroidHardwareCamera$Size.width + "/" + this.jdField_a_of_type_AndroidHardwareCamera$Size.height);
      Log.i("CameraSurfaceView", "changeGlSurfaceSize: " + i + "/" + j);
      if (n * i > k * j)
      {
        n = n * i / k;
        k = (j - n) / 2;
        j = i;
        i = n;
      }
    }
    for (;;)
    {
      Log.i("CameraSurfaceView", "changeGlSurfaceSize: " + j + "/" + i);
      Log.i("CameraSurfaceView", "changeGlSurfaceSize: " + m + "/" + k);
      GLES20.glViewport(m, k, j, i);
      return;
      k = k * j / n;
      m = (i - k) / 2;
      i = j;
      n = 0;
      j = k;
      k = n;
      continue;
      k = i;
      n = 0;
      i = j;
      j = k;
      k = n;
    }
  }
  
  protected void a()
  {
    setEGLContextClientVersion(2);
    setRenderer(this);
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture) {}
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    }
    GLES20.glClearColor(1.0F, 0.0F, 0.0F, 0.0F);
    int i = GLES20.glGetAttribLocation(this.b, "aPosition");
    int j = GLES20.glGetAttribLocation(this.b, "aTextureCoordinate");
    int k = GLES20.glGetUniformLocation(this.b, "uTextureMatrix");
    int m = GLES20.glGetUniformLocation(this.b, "uTextureSampler");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.jdField_a_of_type_Int);
    GLES20.glUniform1i(m, 0);
    GLES20.glUniformMatrix4fv(k, 1, false, this.jdField_a_of_type_ArrayOfFloat, 0);
    if (this.jdField_a_of_type_JavaNioFloatBuffer != null)
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
      GLES20.glEnableVertexAttribArray(i);
      GLES20.glVertexAttribPointer(i, 2, 5126, false, 16, this.jdField_a_of_type_JavaNioFloatBuffer);
      this.jdField_a_of_type_JavaNioFloatBuffer.position(2);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 16, this.jdField_a_of_type_JavaNioFloatBuffer);
    }
    GLES20.glDrawArrays(4, 0, 6);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    requestRender();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Log.i("CameraSurfaceView", "onSurfaceChanged: ");
    c();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Log.i("CameraSurfaceView", "onSurfaceCreated: ");
    b();
    this.jdField_a_of_type_JavaNioFloatBuffer = this.jdField_a_of_type_Bhkf.a();
    this.b = this.jdField_a_of_type_Bhkf.a();
    GLES20.glGenFramebuffers(1, this.jdField_a_of_type_ArrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
  
  public void setCameraSize(Camera.Size paramSize)
  {
    if (paramSize.equals(this.jdField_a_of_type_AndroidHardwareCamera$Size)) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidHardwareCamera$Size = paramSize;
    } while (!this.jdField_a_of_type_Boolean);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.camera.GlCameraSurfaceView
 * JD-Core Version:    0.7.0.1
 */