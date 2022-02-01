package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.HashMap;

public class GLMaskImageView
  extends GLImageView
{
  protected GLImage mMask = new GLImage();
  private String mMaskPath = "";
  RectF region = new RectF();
  
  public GLMaskImageView(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    initView(4);
  }
  
  public void release()
  {
    super.release();
    this.mMask.release();
    this.mMaskPath = "";
  }
  
  public void setMaskImage(String paramString)
  {
    if (!this.mMaskPath.equals(paramString))
    {
      this.mMask.loadTextureSync(paramString);
      this.mMaskPath = paramString;
    }
  }
  
  protected void transferVertexData()
  {
    super.transferVertexData();
    Object localObject = getCurrentDrawRegionSize();
    RectF localRectF = new RectF(this.context.getViewPort());
    this.region.setIntersect((RectF)localObject, localRectF);
    float f3 = (this.region.left - localRectF.left) / localRectF.width();
    float f2 = (localRectF.right - this.region.right) / localRectF.width();
    float f1 = (this.region.top - localRectF.top) / localRectF.height();
    float f4 = (localRectF.bottom - this.region.bottom) / localRectF.height();
    this.mVertexBuffer.put(f3);
    this.mVertexBuffer.put(f1);
    this.mVertexBuffer.put(f3);
    localObject = this.mVertexBuffer;
    f3 = 1.0F - f4;
    ((FloatBuffer)localObject).put(f3);
    localObject = this.mVertexBuffer;
    f2 = 1.0F - f2;
    ((FloatBuffer)localObject).put(f2);
    this.mVertexBuffer.put(f3);
    this.mVertexBuffer.put(f2);
    this.mVertexBuffer.put(f1);
  }
  
  protected void updateAttribute()
  {
    super.updateAttribute();
    int i = ((Integer)this.mProgramObject.attribute.get("a_texCoordMask")).intValue();
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.mProgramObject.getMaskOffset() * this.mVertexPointCount * 4);
    GLES20.glEnableVertexAttribArray(i);
    i = ((Integer)this.mProgramObject.uniform.get("u_texture_mask")).intValue();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.mMask.getTexture());
    GLES20.glUniform1i(i, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLMaskImageView
 * JD-Core Version:    0.7.0.1
 */