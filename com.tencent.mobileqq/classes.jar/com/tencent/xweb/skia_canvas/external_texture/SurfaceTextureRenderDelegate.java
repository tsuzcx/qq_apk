package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.SystemClock;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class SurfaceTextureRenderDelegate
  implements SurfaceTexture.OnFrameAvailableListener, Runnable
{
  private static final String LOG_TAG = "STRenderDelegate";
  private static final short[] drawOrder = { 0, 1, 2, 0, 2, 3 };
  private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}";
  private static final float[] squareCoords;
  private static float squareSize = 1.0F;
  private static final String vertexShaderCode = "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}";
  private ShortBuffer drawListBuffer;
  private EGL10 egl;
  private EGLConfig eglConfig;
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface fakeEglSurface;
  private volatile boolean frameAvailable;
  private List<SurfaceTextureRender> mDownStreamSurfaceTextureRenderList;
  private List<SurfaceTexture> mPendingRemoveSurfaceTextureList;
  private List<Runnable> mReleaseRunnableList;
  private volatile boolean mShouldRun;
  private SurfaceTexture mUpstreamSurfaceTexture;
  private boolean mUseFakeSurface;
  private Thread mWorkThread;
  private int shaderProgram;
  private FloatBuffer textureBuffer;
  private final float[] textureCoords = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private int[] textures = new int[1];
  private FloatBuffer vertexBuffer;
  private float[] videoTextureTransform = new float[16];
  
  static
  {
    float f = squareSize;
    squareCoords = new float[] { -f, f, 0.0F, -f, -f, 0.0F, f, -f, 0.0F, f, f, 0.0F };
  }
  
  public SurfaceTextureRenderDelegate(SurfaceTexture paramSurfaceTexture)
  {
    this.mUpstreamSurfaceTexture = paramSurfaceTexture;
    this.mUpstreamSurfaceTexture.setOnFrameAvailableListener(this);
    this.mReleaseRunnableList = new ArrayList();
    this.mDownStreamSurfaceTextureRenderList = new ArrayList();
    this.mPendingRemoveSurfaceTextureList = new ArrayList();
    this.mShouldRun = true;
    this.mWorkThread = new Thread(this);
    this.mWorkThread.start();
  }
  
  public SurfaceTextureRenderDelegate(SurfaceTexture paramSurfaceTexture1, SurfaceTexture paramSurfaceTexture2)
  {
    this(paramSurfaceTexture1);
    addDownStreamSurfaceTexture(paramSurfaceTexture2);
  }
  
  private EGLConfig chooseEglConfig()
  {
    Object localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = getConfig();
    if (this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt, arrayOfEGLConfig, 1, (int[])localObject))
    {
      if (localObject[0] > 0) {
        return arrayOfEGLConfig[0];
      }
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to choose config: ");
    ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.egl.eglGetError()));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  private void deinitGL()
  {
    if (this.fakeEglSurface != EGL10.EGL_NO_SURFACE) {
      this.egl.eglDestroySurface(this.eglDisplay, this.fakeEglSurface);
    }
    this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    try
    {
      Iterator localIterator = this.mDownStreamSurfaceTextureRenderList.iterator();
      while (localIterator.hasNext()) {
        ((SurfaceTextureRender)localIterator.next()).deinitGL();
      }
      this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
      this.egl.eglTerminate(this.eglDisplay);
      Log.d("STRenderDelegate", "OpenGL deinit OK.");
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void eglMakeCurrentContextWithoutSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext, EGLConfig paramEGLConfig)
  {
    if ((this.mUseFakeSurface) || (!paramEGL10.eglMakeCurrent(paramEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, paramEGLContext)))
    {
      if (!this.mUseFakeSurface)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("egl makeCurrent with no surface ");
        localStringBuilder.append(paramEGL10.eglGetError());
        Log.e("STRenderDelegate", localStringBuilder.toString());
      }
      if (this.fakeEglSurface == EGL10.EGL_NO_SURFACE)
      {
        this.fakeEglSurface = paramEGL10.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, new int[] { 12375, 1, 12374, 1, 12344 });
        this.mUseFakeSurface = true;
      }
      paramEGLConfig = this.fakeEglSurface;
      if (!paramEGL10.eglMakeCurrent(paramEGLDisplay, paramEGLConfig, paramEGLConfig, paramEGLContext))
      {
        paramEGLDisplay = new StringBuilder();
        paramEGLDisplay.append("egl makeCurrent with fake surface ");
        paramEGLDisplay.append(paramEGL10.eglGetError());
        Log.e("STRenderDelegate", paramEGLDisplay.toString());
      }
    }
  }
  
  private int[] getConfig()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  private void initGL()
  {
    this.egl = ((EGL10)EGLContext.getEGL());
    this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.fakeEglSurface = EGL10.EGL_NO_SURFACE;
    int[] arrayOfInt = new int[2];
    this.egl.eglInitialize(this.eglDisplay, arrayOfInt);
    this.eglConfig = chooseEglConfig();
    this.eglContext = createContext(this.egl, this.eglDisplay, this.eglConfig);
    eglMakeCurrentContextWithoutSurface(this.egl, this.eglDisplay, this.eglContext, this.eglConfig);
  }
  
  private void initOffScreenGL()
  {
    if (this.egl == null)
    {
      Log.d("STRenderDelegate", "initOffScreenGL");
      initGL();
      setupVertexBuffer();
      setupTexture();
      loadShaders();
    }
  }
  
  private void loadShaders()
  {
    int i = GLES20.glCreateShader(35633);
    GLES20.glShaderSource(i, "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}");
    GLES20.glCompileShader(i);
    checkGlError("Vertex shader compile");
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(j, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}");
    GLES20.glCompileShader(j);
    checkGlError("Pixel shader compile");
    this.shaderProgram = GLES20.glCreateProgram();
    GLES20.glAttachShader(this.shaderProgram, i);
    GLES20.glAttachShader(this.shaderProgram, j);
    GLES20.glLinkProgram(this.shaderProgram);
    checkGlError("Shader program compile");
    Object localObject = new int[1];
    GLES20.glGetProgramiv(this.shaderProgram, 35714, (int[])localObject, 0);
    if (localObject[0] != 1)
    {
      localObject = GLES20.glGetProgramInfoLog(this.shaderProgram);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error while linking program:\n");
      localStringBuilder.append((String)localObject);
      Log.e("SurfaceTest", localStringBuilder.toString());
    }
  }
  
  private void setupTexture()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.textureBuffer = localByteBuffer.asFloatBuffer();
    this.textureBuffer.put(this.textureCoords);
    this.textureBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glGenTextures(1, this.textures, 0);
    checkGlError("Texture generate");
    GLES20.glBindTexture(36197, this.textures[0]);
    checkGlError("Texture bind");
    this.mUpstreamSurfaceTexture.attachToGLContext(this.textures[0]);
  }
  
  private void setupVertexBuffer()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(drawOrder.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.drawListBuffer = localByteBuffer.asShortBuffer();
    this.drawListBuffer.put(drawOrder);
    this.drawListBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(squareCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.vertexBuffer = localByteBuffer.asFloatBuffer();
    this.vertexBuffer.put(squareCoords);
    this.vertexBuffer.position(0);
  }
  
  private void transferToDownStream(List<SurfaceTextureRender> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SurfaceTextureRender localSurfaceTextureRender = (SurfaceTextureRender)paramList.next();
      localSurfaceTextureRender.init(this.egl, this.eglContext, this.eglDisplay, this.eglConfig);
      localSurfaceTextureRender.makeCurrent();
      localSurfaceTextureRender.adjustViewPort();
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      GLES20.glUseProgram(this.shaderProgram);
      int i = GLES20.glGetUniformLocation(this.shaderProgram, "texture");
      int j = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinate");
      checkGlError("glGetAttribLocation");
      int k = GLES20.glGetAttribLocation(this.shaderProgram, "vPosition");
      int m = GLES20.glGetUniformLocation(this.shaderProgram, "textureTransform");
      GLES20.glEnableVertexAttribArray(k);
      GLES20.glVertexAttribPointer(k, 3, 5126, false, 12, this.vertexBuffer);
      GLES20.glBindTexture(36197, this.textures[0]);
      GLES20.glActiveTexture(33984);
      GLES20.glUniform1i(i, 0);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(j, 4, 5126, false, 0, this.textureBuffer);
      GLES20.glUniformMatrix4fv(m, 1, false, this.videoTextureTransform, 0);
      GLES20.glDrawElements(4, drawOrder.length, 5123, this.drawListBuffer);
      GLES20.glDisableVertexAttribArray(k);
      GLES20.glDisableVertexAttribArray(j);
      localSurfaceTextureRender.swapBuffer();
    }
  }
  
  public void addDownStreamSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.mDownStreamSurfaceTextureRenderList.add(new SurfaceTextureRender(paramSurfaceTexture));
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append("mDownStreamSurfaceTextureRenderList size is ");
      paramSurfaceTexture.append(this.mDownStreamSurfaceTextureRenderList.size());
      Log.d("STRenderDelegate", paramSurfaceTexture.toString());
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void addReleaseCallback(Runnable paramRunnable)
  {
    this.mReleaseRunnableList.add(paramRunnable);
  }
  
  public void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(GLUtils.getEGLErrorString(i));
      Log.e("STRenderDelegate", localStringBuilder.toString());
    }
  }
  
  public void destroy()
  {
    this.mShouldRun = false;
  }
  
  public int getAvailableDownStreamCount()
  {
    try
    {
      int i = this.mDownStreamSurfaceTextureRenderList.size();
      int j = this.mPendingRemoveSurfaceTextureList.size();
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.frameAvailable = true;
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void removeDownStreamSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.mPendingRemoveSurfaceTextureList.add(paramSurfaceTexture);
      return;
    }
    finally
    {
      paramSurfaceTexture = finally;
      throw paramSurfaceTexture;
    }
  }
  
  public void run()
  {
    initOffScreenGL();
    long l;
    if (this.mShouldRun)
    {
      l = SystemClock.uptimeMillis();
      eglMakeCurrentContextWithoutSurface(this.egl, this.eglDisplay, this.eglContext, this.eglConfig);
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = this.mDownStreamSurfaceTextureRenderList.iterator();
          while (localIterator2.hasNext())
          {
            SurfaceTextureRender localSurfaceTextureRender = (SurfaceTextureRender)localIterator2.next();
            SurfaceTexture localSurfaceTexture = localSurfaceTextureRender.getSurface();
            if (this.mPendingRemoveSurfaceTextureList.contains(localSurfaceTexture)) {
              localArrayList.add(localSurfaceTextureRender);
            }
          }
          this.mDownStreamSurfaceTextureRenderList.removeAll(localArrayList);
          this.mPendingRemoveSurfaceTextureList.clear();
          if (!this.frameAvailable) {
            break label214;
          }
          this.mUpstreamSurfaceTexture.updateTexImage();
          this.mUpstreamSurfaceTexture.getTransformMatrix(this.videoTextureTransform);
          this.frameAvailable = false;
          localArrayList = new ArrayList(this.mDownStreamSurfaceTextureRenderList);
          transferToDownStream(localArrayList);
          try
          {
            l = SystemClock.uptimeMillis() - l;
            if (l <= 16L) {
              break label265;
            }
            l = 0L;
            Thread.sleep(l);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        break;
        label214:
        break;
      }
      finally {}
      deinitGL();
      Iterator localIterator1 = this.mReleaseRunnableList.iterator();
      while (localIterator1.hasNext()) {
        ((Runnable)localIterator1.next()).run();
      }
      return;
      label265:
      l = 16L - l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SurfaceTextureRenderDelegate
 * JD-Core Version:    0.7.0.1
 */