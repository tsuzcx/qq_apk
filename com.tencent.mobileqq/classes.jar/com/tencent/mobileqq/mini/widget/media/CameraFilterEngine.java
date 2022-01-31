package com.tencent.mobileqq.mini.widget.media;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class CameraFilterEngine
{
  public static final String POSITION_ATTRIBUTE = "aPosition";
  public static final String TEXTURE_COORD_ATTRIBUTE = "aTextureCoordinate";
  public static final String TEXTURE_MATRIX_UNIFORM = "uTextureMatrix";
  public static final String TEXTURE_SAMPLER_UNIFORM = "uTextureSampler";
  private static final float[] vertexData = { 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 0.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 1.0F, -1.0F, 1.0F, 0.0F };
  private final FloatBuffer mBuffer = createBuffer();
  private final int mShaderProgram = linkProgram(loadShader(35633, "attribute vec4 aPosition;\nuniform mat4 uTextureMatrix;\nattribute vec4 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  vTextureCoord = (uTextureMatrix * aTextureCoordinate).xy;\n  gl_Position = aPosition;\n}"), loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES uTextureSampler;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n}"));
  
  private FloatBuffer createBuffer()
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(vertexData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(vertexData, 0, vertexData.length).position(0);
    return localFloatBuffer;
  }
  
  private int linkProgram(int paramInt1, int paramInt2)
  {
    int i = GLES20.glCreateProgram();
    if (i == 0) {
      throw new RuntimeException("Create Program Failed!" + GLES20.glGetError());
    }
    GLES20.glAttachShader(i, paramInt1);
    GLES20.glAttachShader(i, paramInt2);
    GLES20.glLinkProgram(i);
    GLES20.glUseProgram(i);
    return i;
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt == 0) {
      throw new RuntimeException("Create Shader Failed!" + GLES20.glGetError());
    }
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    return paramInt;
  }
  
  public FloatBuffer getBuffer()
  {
    return this.mBuffer;
  }
  
  public int getShaderProgram()
  {
    return this.mShaderProgram;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.CameraFilterEngine
 * JD-Core Version:    0.7.0.1
 */