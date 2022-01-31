package com.tencent.vbox;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.FloatBuffer;

public class VboxUtils
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  private static final int FLOAT_SIZE_BYTES = 4;
  public static final String TAG = VboxUtils.class.getSimpleName();
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
  private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
  private int inTexture;
  private int mDepthBuffer;
  private int mFramebuffer;
  private float[] mMVPMatrix = new float[16];
  private int mProgram;
  private FloatBuffer mTriangleVertices;
  private final float[] mTriangleVerticesData = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private int maMVPMatrixHandle;
  private int maPositionHandle;
  private int maProgram;
  private float[] maSTMatrix = new float[16];
  private int maSTMatrixHandle;
  private int maTextureHandle;
  private float[] mbSTMatrix = new float[16];
  private int outTexture;
  
  private void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Log.e(TAG, paramString + ": glError " + i);
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }
  
  private int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = loadShader(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      checkGlError("glAttachShader");
      GLES20.glAttachShader(k, j);
      checkGlError("glAttachShader");
      GLES20.glLinkProgram(k);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(k, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        Log.e(TAG, "Could not link program: ");
        Log.e(TAG, GLES20.glGetProgramInfoLog(k));
        GLES20.glDeleteProgram(k);
        return 0;
      }
    }
    return k;
  }
  
  private void drawOffscreen()
  {
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glUseProgram(this.mProgram);
    checkGlError("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.outTexture);
    this.mTriangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mTriangleVertices);
    checkGlError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.maPositionHandle);
    checkGlError("glEnableVertexAttribArray maPositionHandle");
    this.mTriangleVertices.position(3);
    GLES20.glVertexAttribPointer(this.maTextureHandle, 3, 5126, false, 20, this.mTriangleVertices);
    checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.maTextureHandle);
    checkGlError("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.maMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.maSTMatrixHandle, 1, false, this.maSTMatrix, 0);
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glFinish();
  }
  
  private void getaProgramParamHandler(int paramInt)
  {
    this.maPositionHandle = GLES20.glGetAttribLocation(paramInt, "aPosition");
    checkGlError("glGetAttribLocation aPosition");
    if (this.maPositionHandle == -1) {
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    this.maTextureHandle = GLES20.glGetAttribLocation(paramInt, "aTextureCoord");
    checkGlError("glGetAttribLocation aTextureCoord");
    if (this.maTextureHandle == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    this.maMVPMatrixHandle = GLES20.glGetUniformLocation(paramInt, "uMVPMatrix");
    checkGlError("glGetUniformLocation uMVPMatrix");
    if (this.maMVPMatrixHandle == -1) {
      throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    }
    this.maSTMatrixHandle = GLES20.glGetUniformLocation(paramInt, "uSTMatrix");
    checkGlError("glGetUniformLocation uSTMatrix");
    if (this.maSTMatrixHandle == -1) {
      throw new RuntimeException("Could not get attrib location for uSTMatrix");
    }
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    if (i != 0)
    {
      GLES20.glShaderSource(i, paramString);
      GLES20.glCompileShader(i);
      paramString = new int[1];
      GLES20.glGetShaderiv(i, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        Log.e(TAG, "Could not compile shader " + paramInt + ":");
        Log.e(TAG, GLES20.glGetShaderInfoLog(i));
        GLES20.glDeleteShader(i);
        return 0;
      }
    }
    return i;
  }
  
  private void prepareFramebuffer(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.outTexture);
    checkGlError("glBindTexture");
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    checkGlError("glTexImage");
    GLES20.glTexParameterf(3553, 10241, 9728.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    checkGlError("glTexParameter");
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    checkGlError("glGenFramebuffers");
    this.mFramebuffer = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.mFramebuffer);
    checkGlError("glBindTexture " + this.outTexture);
    GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
    checkGlError("glGenRenderbuffers");
    this.mDepthBuffer = arrayOfInt[0];
    GLES20.glBindRenderbuffer(36161, this.mDepthBuffer);
    checkGlError("glBindRenderbuffer ");
    GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    checkGlError("glRenderbufferStorage");
    GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mDepthBuffer);
    checkGlError("glFramebufferRenderbuffer");
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.outTexture, 0);
    checkGlError("glFramebufferTexture2D");
    paramInt1 = GLES20.glCheckFramebufferStatus(36160);
    if (paramInt1 != 36053) {
      throw new RuntimeException("Framebuffer not complete, status=" + paramInt1);
    }
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glActiveTexture(33984);
  }
  
  public void trans(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    new Thread(new VboxUtils.1(this, paramInt1, paramInt2, paramArrayOfByte1)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.VboxUtils
 * JD-Core Version:    0.7.0.1
 */