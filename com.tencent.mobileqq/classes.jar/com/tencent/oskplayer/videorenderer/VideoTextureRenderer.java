package com.tencent.oskplayer.videorenderer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.concurrent.CountDownLatch;

public class VideoTextureRenderer
  extends TextureSurfaceRenderer
  implements SurfaceTexture.OnFrameAvailableListener
{
  public static final String LOG_TAG = "VideoTextureRenderer";
  private static short[] drawOrder = { 0, 1, 2, 0, 2, 3 };
  private static final String fragmentShaderCode = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;uniform samplerExternalOES texture;varying vec2 v_TexCoordinate;void main () {    vec4 color = texture2D(texture, v_TexCoordinate);    gl_FragColor = color;}";
  private static float[] squareCoords;
  private static float squareSize = 1.0F;
  private static final String vertexShaderCode = "attribute vec4 vPosition;attribute vec4 vTexCoordinate;uniform mat4 textureTransform;varying vec2 v_TexCoordinate;void main() {   v_TexCoordinate = (textureTransform * vTexCoordinate).xy;   gl_Position = vPosition;}";
  private Context ctx;
  private int currentTime;
  private ShortBuffer drawListBuffer;
  private int fragmentShaderHandle;
  private boolean frameAvailable = false;
  private CountDownLatch latch;
  private int shaderProgram;
  private FloatBuffer textureBuffer;
  private float[] textureCoords = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private int[] textures = new int[1];
  private FloatBuffer vertexBuffer;
  private int vertexShaderHandle;
  private int videoHeight;
  private SurfaceTexture videoTexture;
  private float[] videoTextureTransform;
  private int videoWidth;
  
  static
  {
    float f = squareSize;
    squareCoords = new float[] { -f, f, 0.0F, -f, -f, 0.0F, f, -f, 0.0F, f, f, 0.0F };
  }
  
  public VideoTextureRenderer(CountDownLatch paramCountDownLatch, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super(paramSurfaceTexture, paramInt1, paramInt2);
    this.latch = paramCountDownLatch;
    this.videoTextureTransform = new float[16];
  }
  
  private void loadShaders()
  {
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error while linking program:\n");
      localStringBuilder.append((String)localObject);
      PlayerUtils.log(6, "SurfaceTest", localStringBuilder.toString());
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
    this.videoTexture = new SurfaceTexture(this.textures[0]);
    this.videoTexture.setOnFrameAvailableListener(this);
    this.latch.countDown();
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
      PlayerUtils.log(6, "SurfaceTest", localStringBuilder.toString());
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
      if (this.frameAvailable)
      {
        this.videoTexture.updateTexImage();
        this.videoTexture.getTransformMatrix(this.videoTextureTransform);
        this.frameAvailable = false;
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
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
        GLES20.glViewport(0, 0, this.width, this.height);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return this.videoTexture;
  }
  
  protected void initGLComponents()
  {
    setupVertexBuffer();
    setupTexture();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.videorenderer.VideoTextureRenderer
 * JD-Core Version:    0.7.0.1
 */