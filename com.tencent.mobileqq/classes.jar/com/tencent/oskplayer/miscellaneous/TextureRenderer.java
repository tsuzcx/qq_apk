package com.tencent.oskplayer.miscellaneous;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(17)
public class TextureRenderer
{
  private static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  public static final String TAG = "TextureRenderer";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
  private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
  private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
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
  
  public TextureRenderer()
  {
    this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
    Matrix.setIdentityM(this.mSTMatrix, 0);
  }
  
  private boolean checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      ILogger localILogger = Logger.g();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkGlError] ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ");
      localStringBuilder.append(i);
      localILogger.e(str, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public static boolean checkLocationError(int paramInt, String paramString)
  {
    if (paramInt < 0)
    {
      ILogger localILogger = Logger.g();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkLocationError] Unable to locate '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in program");
      localILogger.e(str, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0)
    {
      Logger.g().e(TAG, "[createProgram] load vertex failed");
      return 10012;
    }
    int j = loadShader(35632, paramString2);
    if (j == 0)
    {
      Logger.g().e(TAG, "[createProgram] load fragment failed");
      return 10013;
    }
    this.mProgram = GLES20.glCreateProgram();
    int k = this.mProgram;
    if (k == 0)
    {
      Logger.g().e(TAG, "[createProgram] create program failed");
      return 10011;
    }
    GLES20.glAttachShader(k, i);
    if (checkGlError("glAttachShader vertexShader"))
    {
      this.mProgram = 0;
      return 10014;
    }
    GLES20.glAttachShader(this.mProgram, j);
    if (checkGlError("glAttachShader pixelShader"))
    {
      this.mProgram = 0;
      return 10015;
    }
    GLES20.glLinkProgram(this.mProgram);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(this.mProgram, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Logger.g().e(TAG, "[createProgram] Could not link program: ");
      paramString1 = Logger.g();
      paramString2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[createProgram] ");
      localStringBuilder.append(GLES20.glGetProgramInfoLog(this.mProgram));
      paramString1.e(paramString2, localStringBuilder.toString());
      GLES20.glDeleteProgram(this.mProgram);
      this.mProgram = 0;
      return 10016;
    }
    return 0;
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int j = GLES20.glCreateShader(paramInt);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("glCreateShader type=");
    ((StringBuilder)localObject).append(paramInt);
    StringBuilder localStringBuilder;
    if (checkGlError(((StringBuilder)localObject).toString()))
    {
      paramString = Logger.g();
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadShader] glCreateShader failed, shader=");
      localStringBuilder.append(j);
      paramString.e((String)localObject, localStringBuilder.toString());
      return 0;
    }
    GLES20.glShaderSource(j, paramString);
    GLES20.glCompileShader(j);
    paramString = new int[1];
    GLES20.glGetShaderiv(j, 35713, paramString, 0);
    int i = j;
    if (paramString[0] == 0)
    {
      paramString = Logger.g();
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadShader] Could not compile shader ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(":");
      paramString.e((String)localObject, localStringBuilder.toString());
      paramString = Logger.g();
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadShader] ");
      localStringBuilder.append(GLES20.glGetShaderInfoLog(j));
      paramString.e((String)localObject, localStringBuilder.toString());
      GLES20.glDeleteShader(j);
      i = 0;
    }
    return i;
  }
  
  public int createTexture()
  {
    int i = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    if (i != 0) {
      return i;
    }
    this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
    if (checkLocationError(this.maPositionHandle, "aPosition"))
    {
      Logger.g().e(TAG, "[createTexture] glGetAttribLocation aPosition failed");
      return 10017;
    }
    this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
    if (checkLocationError(this.maPositionHandle, "aTextureCoord"))
    {
      Logger.g().e(TAG, "[createTexture] glGetAttribLocation aTextureCoord failed");
      return 10017;
    }
    this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
    if (checkLocationError(this.maPositionHandle, "uMVPMatrix"))
    {
      Logger.g().e(TAG, "[createTexture] glGetAttribLocation uMVPMatrix failed");
      return 10018;
    }
    this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
    if (checkLocationError(this.maPositionHandle, "uSTMatrix"))
    {
      Logger.g().e(TAG, "[createTexture] glGetAttribLocation uSTMatrix failed");
      return 10018;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.mTextureID = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.mTextureID);
    if (checkGlError("glBindTexture mTextureID"))
    {
      Logger.g().e(TAG, "[createTexture] glBindTexture failed");
      return 10019;
    }
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    if (checkGlError("glTexParameter")) {
      return 10020;
    }
    return 0;
  }
  
  public void drawFrame(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    checkGlError("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.mSTMatrix);
    if (paramBoolean)
    {
      paramSurfaceTexture = this.mSTMatrix;
      paramSurfaceTexture[5] = (-paramSurfaceTexture[5]);
      paramSurfaceTexture[13] = (1.0F - paramSurfaceTexture[13]);
    }
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
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
    GLES20.glBindTexture(36197, 0);
  }
  
  public int getTextureId()
  {
    return this.mTextureID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.TextureRenderer
 * JD-Core Version:    0.7.0.1
 */