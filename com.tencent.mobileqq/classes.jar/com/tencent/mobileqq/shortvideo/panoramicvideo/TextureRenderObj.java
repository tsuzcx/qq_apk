package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.GLPassThroughProgram;
import com.tencent.mobileqq.shortvideo.panoramicvideo.GL.TextureUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.MatrixUtil;

public class TextureRenderObj
  extends PassThroughRenderObj
{
  private int mTextureHeight;
  private int mTextureId;
  private int mTextureWidth;
  private Plane texturePlane = new Plane(false);
  
  public TextureRenderObj(Context paramContext)
  {
    super(paramContext);
  }
  
  public void destroyTexture()
  {
    GLES20.glDeleteTextures(1, new int[] { this.mTextureId }, 0);
  }
  
  public void onDrawFrame(int paramInt)
  {
    onPreDrawElements();
    GlUtil.checkGlError("onPreDrawElements");
    this.glPassThroughProgram.use();
    Matrix.setIdentityM(this.projectionMatrix, 0);
    GLES20.glViewport(0, 0, this.surfaceWidth, this.surfaceHeight);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    TextureUtil.bindTexture2D(this.mTextureId, 33984, this.glPassThroughProgram.getTextureSamplerHandle(), 0);
    this.texturePlane.uploadTexCoordinateBuffer(this.glPassThroughProgram.getTextureCoordinateHandle());
    this.texturePlane.uploadVerticesBuffer(this.glPassThroughProgram.getPositionHandle());
    MatrixUtil.updateProjection(this.mTextureWidth, this.mTextureHeight, this.surfaceWidth, this.surfaceHeight, 1, this.projectionMatrix);
    GLES20.glUniformMatrix4fv(this.glPassThroughProgram.getMVPMatrixHandle(), 1, false, this.projectionMatrix, 0);
    this.texturePlane.draw();
    GLES20.glDisable(3042);
  }
  
  public void setTextureId(int paramInt)
  {
    this.mTextureId = paramInt;
  }
  
  public void setTextureSize(int paramInt1, int paramInt2)
  {
    this.mTextureWidth = paramInt1;
    this.mTextureHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.TextureRenderObj
 * JD-Core Version:    0.7.0.1
 */