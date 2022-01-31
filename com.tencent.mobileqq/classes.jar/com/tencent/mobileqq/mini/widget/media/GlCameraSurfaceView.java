package com.tencent.mobileqq.mini.widget.media;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera.Size;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.util.Log;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GlCameraSurfaceView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer
{
  private static final String TAG = "CameraSurfaceView";
  private boolean isSurfaceCreate;
  private Camera.Size mCameraSize;
  private FloatBuffer mDataBuffer;
  private int[] mFBOIds = new int[1];
  private CameraFilterEngine mFilter;
  private SurfaceTexture mPreviewSt;
  private int mShaderProgram;
  private int mTextureId;
  private float[] transformMatrix = new float[16];
  
  public GlCameraSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GlCameraSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void changeGlSurfaceSize()
  {
    int m = 0;
    int i = getWidth();
    int j = getHeight();
    if ((i == 0) || (j == 0)) {
      return;
    }
    int k;
    int n;
    if (this.mCameraSize != null)
    {
      k = this.mCameraSize.height;
      n = this.mCameraSize.width;
      Log.i("CameraSurfaceView", "changeGlSurfaceSize: " + this.mCameraSize.width + "/" + this.mCameraSize.height);
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
  
  private static int createOESTextureObject()
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
  
  private void createPreviewSt()
  {
    if (this.mPreviewSt != null) {
      return;
    }
    this.mTextureId = createOESTextureObject();
    this.mPreviewSt = new SurfaceTexture(this.mTextureId);
    this.mPreviewSt.setOnFrameAvailableListener(this);
    this.mFilter = new CameraFilterEngine();
  }
  
  protected void init()
  {
    setEGLContextClientVersion(2);
    setRenderer(this);
  }
  
  protected void onCameraSurfaceCreate(SurfaceTexture paramSurfaceTexture) {}
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.mPreviewSt != null)
    {
      this.mPreviewSt.updateTexImage();
      this.mPreviewSt.getTransformMatrix(this.transformMatrix);
    }
    GLES20.glClearColor(1.0F, 0.0F, 0.0F, 0.0F);
    int i = GLES20.glGetAttribLocation(this.mShaderProgram, "aPosition");
    int j = GLES20.glGetAttribLocation(this.mShaderProgram, "aTextureCoordinate");
    int k = GLES20.glGetUniformLocation(this.mShaderProgram, "uTextureMatrix");
    int m = GLES20.glGetUniformLocation(this.mShaderProgram, "uTextureSampler");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.mTextureId);
    GLES20.glUniform1i(m, 0);
    GLES20.glUniformMatrix4fv(k, 1, false, this.transformMatrix, 0);
    if (this.mDataBuffer != null)
    {
      this.mDataBuffer.position(0);
      GLES20.glEnableVertexAttribArray(i);
      GLES20.glVertexAttribPointer(i, 2, 5126, false, 16, this.mDataBuffer);
      this.mDataBuffer.position(2);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 16, this.mDataBuffer);
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
    changeGlSurfaceSize();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Log.i("CameraSurfaceView", "onSurfaceCreated: ");
    createPreviewSt();
    this.mDataBuffer = this.mFilter.getBuffer();
    this.mShaderProgram = this.mFilter.getShaderProgram();
    GLES20.glGenFramebuffers(1, this.mFBOIds, 0);
    GLES20.glBindFramebuffer(36160, this.mFBOIds[0]);
    this.isSurfaceCreate = true;
    onCameraSurfaceCreate(this.mPreviewSt);
  }
  
  public void setCameraSize(Camera.Size paramSize)
  {
    if (paramSize.equals(this.mCameraSize)) {}
    do
    {
      return;
      this.mCameraSize = paramSize;
    } while (!this.isSurfaceCreate);
    changeGlSurfaceSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.GlCameraSurfaceView
 * JD-Core Version:    0.7.0.1
 */