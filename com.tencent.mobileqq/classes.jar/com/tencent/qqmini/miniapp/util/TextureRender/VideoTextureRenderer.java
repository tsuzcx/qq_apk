package com.tencent.qqmini.miniapp.util.TextureRender;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class VideoTextureRenderer
  extends TextureSurfaceRenderer
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final String TAG = "miniapp-embedded";
  private static short[] drawOrder = { 0, 1, 2, 0, 2, 3 };
  private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}";
  private static float[] squareCoords;
  private static float squareSize = 1.0F;
  private static float[] textureCoords = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private static final String vertexShaderCode = "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}";
  private boolean adjustViewport = false;
  private Context ctx;
  private ShortBuffer drawListBuffer;
  private int fragmentShaderHandle;
  private boolean frameAvailable = false;
  private String objectFit = "contain";
  private int shaderProgram;
  private FloatBuffer textureBuffer;
  private int[] textures = new int[1];
  private FloatBuffer vertexBuffer;
  private int vertexShaderHandle;
  private int videoHeight;
  private SurfaceTexture videoTexture;
  private float[] videoTextureTransform;
  private int videoWidth;
  
  static
  {
    squareCoords = new float[] { -squareSize, squareSize, 0.0F, -squareSize, -squareSize, 0.0F, squareSize, -squareSize, 0.0F, squareSize, squareSize, 0.0F };
  }
  
  public VideoTextureRenderer(Context paramContext, Surface paramSurface, int paramInt1, int paramInt2, Handler paramHandler)
  {
    super(paramSurface, paramInt1, paramInt2, paramHandler);
    this.ctx = paramContext;
    this.videoTextureTransform = new float[16];
  }
  
  private void adjustViewport()
  {
    float f1;
    float f2;
    float f3;
    if ("contain".equals(this.objectFit))
    {
      f1 = Math.min(this.width / this.videoWidth, this.height / this.videoHeight);
      QMLog.d("miniapp-embedded", "contain scale : " + f1);
      f2 = Math.round((this.width - this.videoWidth * f1) * 0.5F);
      f3 = Math.round((this.height - this.videoHeight * f1) * 0.5F);
      GLES20.glViewport((int)f2, (int)f3, (int)(this.videoWidth * f1), (int)(f1 * this.videoHeight));
    }
    for (;;)
    {
      this.adjustViewport = false;
      return;
      if ("fill".equals(this.objectFit))
      {
        GLES20.glViewport(0, 0, this.width, this.height);
      }
      else if ("cover".equals(this.objectFit))
      {
        f1 = Math.max(this.width / this.videoWidth, this.height / this.videoHeight);
        QMLog.d("miniapp-embedded", "cover scale : " + f1);
        f2 = Math.round((this.width - this.videoWidth * f1) * 0.5F);
        f3 = Math.round((this.height - this.videoHeight * f1) * 0.5F);
        GLES20.glViewport((int)f2, (int)f3, (int)(this.videoWidth * f1), (int)(f1 * this.videoHeight));
      }
    }
  }
  
  private void loadShaders()
  {
    try
    {
      QMLog.d("miniapp-embedded", "loadShaders");
      this.vertexShaderHandle = GLES20.glCreateShader(35633);
      GLES20.glShaderSource(this.vertexShaderHandle, "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}");
      GLES20.glCompileShader(this.vertexShaderHandle);
      checkGlError("Vertex shader compile");
      this.fragmentShaderHandle = GLES20.glCreateShader(35632);
      GLES20.glShaderSource(this.fragmentShaderHandle, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}");
      GLES20.glCompileShader(this.fragmentShaderHandle);
      checkGlError("Pixel shader compile");
      this.shaderProgram = GLES20.glCreateProgram();
      GLES20.glAttachShader(this.shaderProgram, this.vertexShaderHandle);
      GLES20.glAttachShader(this.shaderProgram, this.fragmentShaderHandle);
      GLES20.glLinkProgram(this.shaderProgram);
      checkGlError("Shader program compile");
      Object localObject = new int[1];
      GLES20.glGetProgramiv(this.shaderProgram, 35714, (int[])localObject, 0);
      if (localObject[0] != 1)
      {
        localObject = GLES20.glGetProgramInfoLog(this.shaderProgram);
        QMLog.e("miniapp-embedded", "Error while linking program:\n" + (String)localObject);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "loadShaders error.", localThrowable);
    }
  }
  
  private void setupTexture(Context paramContext)
  {
    try
    {
      paramContext = ByteBuffer.allocateDirect(textureCoords.length * 4);
      paramContext.order(ByteOrder.nativeOrder());
      this.textureBuffer = paramContext.asFloatBuffer();
      this.textureBuffer.put(textureCoords);
      this.textureBuffer.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glGenTextures(1, this.textures, 0);
      checkGlError("Texture generate");
      GLES20.glBindTexture(36197, this.textures[0]);
      checkGlError("Texture bind");
      this.videoTexture = new SurfaceTexture(this.textures[0]);
      this.videoTexture.setOnFrameAvailableListener(this);
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(1002);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("miniapp-embedded", "setupTexture error.", paramContext);
    }
  }
  
  private void setupVertexBuffer()
  {
    try
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
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("miniapp-embedded", "setupVertexBuffer error.", localThrowable);
    }
  }
  
  public void checkGlError(String paramString)
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
  
  protected void deinitGLComponents()
  {
    GLES20.glDeleteTextures(1, this.textures, 0);
    GLES20.glDeleteProgram(this.shaderProgram);
    this.videoTexture.release();
    this.videoTexture.setOnFrameAvailableListener(null);
  }
  
  protected boolean draw()
  {
    try
    {
      try
      {
        if (this.frameAvailable)
        {
          this.videoTexture.updateTexImage();
          this.videoTexture.getTransformMatrix(this.videoTextureTransform);
          this.frameAvailable = false;
          if (this.adjustViewport) {
            adjustViewport();
          }
          GLES20.glClearColor(1.0F, 0.0F, 0.0F, 0.0F);
          GLES20.glClear(16384);
          GLES20.glUseProgram(this.shaderProgram);
          int i = GLES20.glGetUniformLocation(this.shaderProgram, "texture");
          int j = GLES20.glGetAttribLocation(this.shaderProgram, "vTexCoordinate");
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
  
  public SurfaceTexture getVideoTexture()
  {
    return this.videoTexture;
  }
  
  protected void initGLComponents()
  {
    QMLog.d("miniapp-embedded", "initGLComponents ： " + Thread.currentThread());
    setupVertexBuffer();
    setupTexture(this.ctx);
    loadShaders();
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.frameAvailable = true;
      return;
    }
    finally {}
  }
  
  public void setSurfaceSize(int paramInt1, int paramInt2)
  {
    QMLog.e("miniapp-embedded", "setSurfaceSize " + paramInt1 + "; " + paramInt2);
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setVideoSize(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.e("miniapp-embedded", "setVideoSize " + paramInt1 + "; " + paramInt2 + "; " + paramString);
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    this.objectFit = paramString;
    this.adjustViewport = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.TextureRender.VideoTextureRenderer
 * JD-Core Version:    0.7.0.1
 */