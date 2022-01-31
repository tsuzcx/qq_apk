package com.tencent.qq.effect.alphavideo.videoplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.qq.effect.utils.LogUtil;

public class SurfaceTextureBlendRender
  extends BaseRender
{
  private static final String TAG = "VideoPlayer|SurfaceTextureBlendRender";
  private int mPositionHandleOES;
  private int mShaderProgramOES;
  private int mTextureCoordinateHandleOES;
  private int mTextureParamHandleOES;
  private int mTextureTransformHandleOES;
  private int[] mTexturesOES = new int[1];
  private Surface mVideoSurface;
  private SurfaceTexture videoTexture;
  
  public SurfaceTextureBlendRender()
  {
    super(1);
  }
  
  public void destroy()
  {
    GLES20.glDeleteTextures(1, this.mTexturesOES, 0);
    GLES20.glDeleteProgram(this.mShaderProgramOES);
    releaseSurface();
    releaseSurfaceTexture();
  }
  
  public void draw(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GLES20.glUseProgram(this.mShaderProgramOES);
        GLES20.glClear(16384);
        GLES20.glBindTexture(36197, this.mTexturesOES[0]);
        GLES20.glActiveTexture(33984);
        GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
        if (this.videoTexture != null)
        {
          this.videoTexture.updateTexImage();
          this.videoTexture.getTransformMatrix(this.textureTransform);
          GLES20.glEnableVertexAttribArray(this.mPositionHandleOES);
          if (!paramBoolean)
          {
            GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, this.vertexBuffer);
            GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleOES);
            GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleOES, 4, 5126, false, 0, this.textureCoordsBuffer);
            GLES20.glUniformMatrix4fv(this.mTextureTransformHandleOES, 1, false, this.textureTransform, 0);
            GLES20.glDrawElements(5, this.drawOrder.length, 5123, this.drawListBuffer);
            GLES20.glDisableVertexAttribArray(this.mPositionHandleOES);
            GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleOES);
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
          }
        }
        else
        {
          GLES20.glUseProgram(0);
          GLES20.glBindTexture(36197, 0);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        LogUtil.v("VideoPlayer|SurfaceTextureBlendRender", " Exception in draw oes");
        paramArrayOfByte.printStackTrace();
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
        return;
      }
      GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, this.vertexBuffer_horizonal_reverse);
    }
  }
  
  public void drawFBO(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        GLES20.glUseProgram(this.mShaderProgramOES);
        GLES20.glClear(16384);
        GLES20.glBindTexture(36197, this.mTexturesOES[0]);
        GLES20.glActiveTexture(33984);
        GLES20.glUniform1i(this.mTextureParamHandleOES, 0);
        if (this.videoTexture != null)
        {
          this.videoTexture.updateTexImage();
          this.videoTexture.getTransformMatrix(this.textureTransform);
          GLES20.glEnableVertexAttribArray(this.mPositionHandleOES);
          if (!paramBoolean)
          {
            GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, this.vertexBuffer_vertical_reverse);
            GLES20.glEnableVertexAttribArray(this.mTextureCoordinateHandleOES);
            GLES20.glVertexAttribPointer(this.mTextureCoordinateHandleOES, 4, 5126, false, 0, this.textureCoordsBuffer);
            GLES20.glUniformMatrix4fv(this.mTextureTransformHandleOES, 1, false, this.textureTransform, 0);
            GLES20.glDrawElements(5, this.drawOrder.length, 5123, this.drawListBuffer);
            GLES20.glDisableVertexAttribArray(this.mPositionHandleOES);
            GLES20.glDisableVertexAttribArray(this.mTextureCoordinateHandleOES);
            GLES20.glBindTexture(36197, 0);
            GLES20.glUseProgram(0);
          }
        }
        else
        {
          GLES20.glUseProgram(0);
          GLES20.glBindTexture(36197, 0);
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        LogUtil.v("VideoPlayer|SurfaceTextureBlendRender", " Exception in drawFBO oes");
        paramArrayOfByte.printStackTrace();
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
        return;
      }
      GLES20.glVertexAttribPointer(this.mPositionHandleOES, 2, 5126, false, 0, this.vertexBuffer_horizonal_vertical_reverse);
    }
  }
  
  public Surface getSurface()
  {
    return this.mVideoSurface;
  }
  
  public SurfaceTexture getVideoTexture()
  {
    return this.videoTexture;
  }
  
  public void releaseSurface()
  {
    if (this.mVideoSurface != null)
    {
      this.mVideoSurface.release();
      this.mVideoSurface = null;
      LogUtil.v("VideoPlayer|SurfaceTextureBlendRender", " release  surface");
    }
  }
  
  public void releaseSurfaceTexture()
  {
    if (this.videoTexture != null)
    {
      this.videoTexture.release();
      this.videoTexture = null;
      LogUtil.v("VideoPlayer|SurfaceTextureBlendRender", " release  surface texture");
    }
  }
  
  public void setup()
  {
    LogUtil.v("VideoPlayer|SurfaceTextureBlendRender", "setup OES");
    checkGlError(" setup OES ");
    setupVertexBuffer();
    setupTextureCoordsBuffer();
    this.mShaderProgramOES = ShaderHelper.createAndLinkProgram(ShaderHelper.compileShader(35633, "precision mediump float;\nattribute vec4 vPosition;\nattribute vec4 vTexCoordinate;\nuniform mat4 textureTransform;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n    v_TexCoordinate = (textureTransform * vTexCoordinate).xy;\n    gl_Position = vPosition;\n}\n"), ShaderHelper.compileShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES texture;\nvarying vec2 v_TexCoordinate;\nvoid main () {\n   vec4 color = texture2D(texture, v_TexCoordinate);\n   vec2 v_TexCoordinate1 = v_TexCoordinate;\n   v_TexCoordinate1.x = v_TexCoordinate.x + 0.5;\n    vec4 color1 = texture2D(texture, v_TexCoordinate1);\n   color.a = color1.r;\n    gl_FragColor = color;\n}\n"), new String[] { "texture", "vPosition", "vTexCoordinate", "textureTransform" });
    GLES20.glUseProgram(this.mShaderProgramOES);
    this.mTextureParamHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "texture");
    this.mTextureCoordinateHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vTexCoordinate");
    this.mPositionHandleOES = GLES20.glGetAttribLocation(this.mShaderProgramOES, "vPosition");
    this.mTextureTransformHandleOES = GLES20.glGetUniformLocation(this.mShaderProgramOES, "textureTransform");
    GLES20.glUseProgram(0);
    checkGlError("Texture generate OES>>");
    GLES20.glGenTextures(1, this.mTexturesOES, 0);
    GLES20.glBindTexture(36197, this.mTexturesOES[0]);
    checkGlError("Texture bind");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    this.videoTexture = new SurfaceTexture(this.mTexturesOES[0]);
    this.mVideoSurface = new Surface(this.videoTexture);
    GLES20.glBindTexture(36197, 0);
    GLES20.glBindTexture(3553, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.render.SurfaceTextureBlendRender
 * JD-Core Version:    0.7.0.1
 */