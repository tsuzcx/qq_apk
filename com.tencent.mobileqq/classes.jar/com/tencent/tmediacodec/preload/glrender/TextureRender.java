package com.tencent.tmediacodec.preload.glrender;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class TextureRender
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  private static final String TAG = "TextureRender";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
  private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
  private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  private float[] mMVPMatrix = new float[16];
  private int mProgram;
  private float[] mSTMatrix = new float[16];
  private int mTextureID = -12345;
  private FloatBuffer mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private final float[] mTriangleVerticesData = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private int maPositionHandle;
  private int maTextureHandle;
  private int muMVPMatrixHandle;
  private int muSTMatrixHandle;
  
  public TextureRender()
  {
    this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
    Matrix.setIdentityM(this.mSTMatrix, 0);
  }
  
  private int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {
      return 0;
    }
    int j = loadShader(35632, paramString2);
    if (j == 0) {
      return 0;
    }
    int k = GLES20.glCreateProgram();
    checkGlError("glCreateProgram");
    if (k == 0) {
      Log.e("TextureRender", "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    checkGlError("glAttachShader");
    GLES20.glAttachShader(k, j);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("TextureRender", "Could not link program: ");
      Log.e("TextureRender", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("glCreateShader type=");
    localStringBuilder.append(paramInt);
    checkGlError(localStringBuilder.toString());
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      paramString = new StringBuilder();
      paramString.append("Could not compile shader ");
      paramString.append(paramInt);
      paramString.append(":");
      Log.e("TextureRender", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(" ");
      paramString.append(GLES20.glGetShaderInfoLog(j));
      Log.e("TextureRender", paramString.toString());
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
  
  public void changeFragmentShader(String paramString)
  {
    GLES20.glDeleteProgram(this.mProgram);
    this.mProgram = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", paramString);
    if (this.mProgram != 0) {
      return;
    }
    throw new RuntimeException("failed creating program");
  }
  
  public void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i == 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(i);
    Log.e("TextureRender", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": glError ");
    localStringBuilder.append(i);
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  @TargetApi(11)
  public void drawFrame(SurfaceTexture paramSurfaceTexture)
  {
    checkGlError("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.mSTMatrix);
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.mProgram);
    checkGlError("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.mTextureID);
    this.mTriangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mTriangleVertices);
    checkGlError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.maPositionHandle);
    checkGlError("glEnableVertexAttribArray maPositionHandle");
    this.mTriangleVertices.position(3);
    GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, this.mTriangleVertices);
    checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.maTextureHandle);
    checkGlError("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glFinish();
  }
  
  public int getTextureId()
  {
    return this.mTextureID;
  }
  
  public void surfaceCreated()
  {
    this.mProgram = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    int i = this.mProgram;
    if (i != 0)
    {
      this.maPositionHandle = GLES20.glGetAttribLocation(i, "aPosition");
      checkGlError("glGetAttribLocation aPosition");
      if (this.maPositionHandle != -1)
      {
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        checkGlError("glGetAttribLocation aTextureCoord");
        if (this.maTextureHandle != -1)
        {
          this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
          checkGlError("glGetUniformLocation uMVPMatrix");
          if (this.muMVPMatrixHandle != -1)
          {
            this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
            checkGlError("glGetUniformLocation uSTMatrix");
            if (this.muSTMatrixHandle != -1)
            {
              int[] arrayOfInt = new int[1];
              GLES20.glGenTextures(1, arrayOfInt, 0);
              this.mTextureID = arrayOfInt[0];
              GLES20.glBindTexture(36197, this.mTextureID);
              checkGlError("glBindTexture mTextureID");
              GLES20.glTexParameterf(36197, 10241, 9728.0F);
              GLES20.glTexParameterf(36197, 10240, 9729.0F);
              GLES20.glTexParameteri(36197, 10242, 33071);
              GLES20.glTexParameteri(36197, 10243, 33071);
              checkGlError("glTexParameter");
              return;
            }
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
          }
          throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
      }
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    throw new RuntimeException("failed creating program");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.glrender.TextureRender
 * JD-Core Version:    0.7.0.1
 */