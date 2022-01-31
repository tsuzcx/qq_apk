package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.BufferUtils;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Utils.PlaneTextureRotationUtil;
import java.nio.FloatBuffer;

public class Plane
{
  private final float[] TRIANGLES_DATA_CW = { -1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private FloatBuffer mTexCoordinateBuffer;
  private FloatBuffer mVerticesBuffer = BufferUtils.getFloatBuffer(this.TRIANGLES_DATA_CW, 0);
  
  public Plane(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTexCoordinateBuffer = BufferUtils.getFloatBuffer(PlaneTextureRotationUtil.getRotation(0, false, true), 0);
      return;
    }
    this.mTexCoordinateBuffer = BufferUtils.getFloatBuffer(PlaneTextureRotationUtil.TEXTURE_NO_ROTATION, 0);
  }
  
  public void draw()
  {
    GLES20.glDrawArrays(5, 0, 4);
  }
  
  public FloatBuffer getTexCoordinateBuffer()
  {
    return this.mTexCoordinateBuffer;
  }
  
  public FloatBuffer getVerticesBuffer()
  {
    return this.mVerticesBuffer;
  }
  
  public Plane resetTrianglesDataWithRect(RectF paramRectF)
  {
    this.TRIANGLES_DATA_CW[0] = paramRectF.left;
    this.TRIANGLES_DATA_CW[1] = paramRectF.bottom;
    this.TRIANGLES_DATA_CW[3] = paramRectF.left;
    this.TRIANGLES_DATA_CW[4] = paramRectF.top;
    this.TRIANGLES_DATA_CW[6] = paramRectF.right;
    this.TRIANGLES_DATA_CW[7] = paramRectF.bottom;
    this.TRIANGLES_DATA_CW[9] = paramRectF.right;
    this.TRIANGLES_DATA_CW[10] = paramRectF.top;
    this.mVerticesBuffer = BufferUtils.getFloatBuffer(this.TRIANGLES_DATA_CW, 0);
    return this;
  }
  
  public Plane scale(float paramFloat)
  {
    float[] arrayOfFloat = new float[this.TRIANGLES_DATA_CW.length];
    System.arraycopy(this.TRIANGLES_DATA_CW, 0, arrayOfFloat, 0, this.TRIANGLES_DATA_CW.length);
    int i = 0;
    while (i < arrayOfFloat.length)
    {
      arrayOfFloat[i] *= paramFloat;
      i += 1;
    }
    this.mVerticesBuffer = BufferUtils.getFloatBuffer(arrayOfFloat, 0);
    return this;
  }
  
  public void setTexCoordinateBuffer(FloatBuffer paramFloatBuffer)
  {
    this.mTexCoordinateBuffer = paramFloatBuffer;
  }
  
  public void setVerticesBuffer(FloatBuffer paramFloatBuffer)
  {
    this.mVerticesBuffer = paramFloatBuffer;
  }
  
  public void uploadTexCoordinateBuffer(int paramInt)
  {
    FloatBuffer localFloatBuffer = getTexCoordinateBuffer();
    if (localFloatBuffer == null) {
      return;
    }
    localFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(paramInt, 2, 5126, false, 0, localFloatBuffer);
    GlUtil.checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(paramInt);
    GlUtil.checkGlError("glEnableVertexAttribArray maTextureHandle");
  }
  
  public void uploadVerticesBuffer(int paramInt)
  {
    FloatBuffer localFloatBuffer = getVerticesBuffer();
    if (localFloatBuffer == null) {
      return;
    }
    localFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(paramInt, 3, 5126, false, 0, localFloatBuffer);
    GlUtil.checkGlError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(paramInt);
    GlUtil.checkGlError("glEnableVertexAttribArray maPositionHandle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.Plane
 * JD-Core Version:    0.7.0.1
 */