package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class BigHeadMaskManager
{
  private int mHeight;
  private BigHeadMaskManager.BGMask[] mMaskArray = new BigHeadMaskManager.BGMask[2];
  private TextureRender mRender;
  private RenderBuffer mRenderMerge;
  private int mWidth;
  
  public BigHeadMaskManager(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.mMaskArray[0] = createTexture();
    this.mMaskArray[1] = createTexture();
    this.mRenderMerge = new RenderBuffer(this.mWidth, this.mHeight);
    this.mRender = new TextureRender();
  }
  
  private BigHeadMaskManager.BGMask createTexture()
  {
    BigHeadMaskManager.BGMask localBGMask = new BigHeadMaskManager.BGMask();
    localBGMask.mTextureId = GlUtil.createTextureAllocate(this.mWidth, this.mHeight, true);
    return localBGMask;
  }
  
  public int getMergedMask(boolean paramBoolean)
  {
    int i = 0;
    if ((this.mMaskArray[0].hasValidData) && (!this.mMaskArray[1].hasValidData)) {
      i = this.mMaskArray[0].mTextureId;
    }
    do
    {
      return i;
      if ((!this.mMaskArray[0].hasValidData) && (this.mMaskArray[1].hasValidData)) {
        return this.mMaskArray[1].mTextureId;
      }
    } while (!this.mMaskArray[0].hasValidData);
    i = 0;
    int k = 0;
    int j = 0;
    if (i < this.mMaskArray.length)
    {
      if (this.mMaskArray[i].last) {
        j = i;
      }
      for (;;)
      {
        i += 1;
        break;
        k = i;
      }
    }
    if (paramBoolean)
    {
      this.mRenderMerge.setUserTextureId(this.mMaskArray[k].mTextureId);
      this.mRenderMerge.bind();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(0, 768);
      this.mRender.drawTexture(3553, this.mMaskArray[j].mTextureId, null, null);
      GLES20.glDisable(3042);
      this.mRenderMerge.unbind();
      return this.mMaskArray[k].mTextureId;
    }
    return this.mMaskArray[j].mTextureId;
  }
  
  public int getSpaceMask()
  {
    int k = 0;
    BigHeadMaskManager.BGMask[] arrayOfBGMask = this.mMaskArray;
    int m = arrayOfBGMask.length;
    int i = 0;
    int j = k;
    if (i < m)
    {
      BigHeadMaskManager.BGMask localBGMask = arrayOfBGMask[i];
      if (localBGMask.last) {}
      while (localBGMask.mUsed)
      {
        i += 1;
        break;
      }
      localBGMask.mUsed = true;
      localBGMask.hasValidData = false;
      j = localBGMask.mTextureId;
    }
    return j;
  }
  
  public void queueMask(int paramInt)
  {
    BigHeadMaskManager.BGMask[] arrayOfBGMask = this.mMaskArray;
    int j = arrayOfBGMask.length;
    int i = 0;
    if (i < j)
    {
      BigHeadMaskManager.BGMask localBGMask = arrayOfBGMask[i];
      if (localBGMask.mTextureId == paramInt) {
        if (localBGMask.mUsed)
        {
          localBGMask.mUsed = false;
          localBGMask.hasValidData = true;
        }
      }
      for (localBGMask.last = true;; localBGMask.last = false)
      {
        i += 1;
        break;
        throw new RuntimeException("状态错误或者使用错误...");
      }
    }
  }
  
  public void release()
  {
    BigHeadMaskManager.BGMask[] arrayOfBGMask = this.mMaskArray;
    int j = arrayOfBGMask.length;
    int i = 0;
    while (i < j)
    {
      BigHeadMaskManager.BGMask localBGMask = arrayOfBGMask[i];
      if (localBGMask != null) {
        localBGMask.destroy();
      }
      i += 1;
    }
    if (this.mRender != null) {
      this.mRender.release();
    }
    if (this.mRenderMerge != null) {
      this.mRenderMerge.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadMaskManager
 * JD-Core Version:    0.7.0.1
 */