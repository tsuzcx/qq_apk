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
    if ((this.mMaskArray[0].hasValidData) && (!this.mMaskArray[1].hasValidData)) {
      return this.mMaskArray[0].mTextureId;
    }
    if ((!this.mMaskArray[0].hasValidData) && (this.mMaskArray[1].hasValidData)) {
      return this.mMaskArray[1].mTextureId;
    }
    if (!this.mMaskArray[0].hasValidData) {
      return 0;
    }
    int i = 0;
    int k = 0;
    int j = 0;
    BigHeadMaskManager.BGMask[] arrayOfBGMask;
    for (;;)
    {
      arrayOfBGMask = this.mMaskArray;
      if (i >= arrayOfBGMask.length) {
        break;
      }
      if (arrayOfBGMask[i].last) {
        k = i;
      } else {
        j = i;
      }
      i += 1;
    }
    if (paramBoolean)
    {
      this.mRenderMerge.setUserTextureId(arrayOfBGMask[j].mTextureId);
      this.mRenderMerge.bind();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(0, 768);
      this.mRender.drawTexture(3553, this.mMaskArray[k].mTextureId, null, null);
      GLES20.glDisable(3042);
      this.mRenderMerge.unbind();
      return this.mMaskArray[j].mTextureId;
    }
    return arrayOfBGMask[k].mTextureId;
  }
  
  public int getSpaceMask()
  {
    BigHeadMaskManager.BGMask[] arrayOfBGMask = this.mMaskArray;
    int j = arrayOfBGMask.length;
    int i = 0;
    while (i < j)
    {
      BigHeadMaskManager.BGMask localBGMask = arrayOfBGMask[i];
      if ((!localBGMask.last) && (!localBGMask.mUsed))
      {
        localBGMask.mUsed = true;
        localBGMask.hasValidData = false;
        return localBGMask.mTextureId;
      }
      i += 1;
    }
    return 0;
  }
  
  public void queueMask(int paramInt)
  {
    BigHeadMaskManager.BGMask[] arrayOfBGMask = this.mMaskArray;
    int j = arrayOfBGMask.length;
    int i = 0;
    while (i < j)
    {
      BigHeadMaskManager.BGMask localBGMask = arrayOfBGMask[i];
      if (localBGMask.mTextureId == paramInt)
      {
        if (localBGMask.mUsed)
        {
          localBGMask.mUsed = false;
          localBGMask.hasValidData = true;
          localBGMask.last = true;
        }
        else
        {
          throw new RuntimeException("状态错误或者使用错误...");
        }
      }
      else {
        localBGMask.last = false;
      }
      i += 1;
    }
  }
  
  public void release()
  {
    Object localObject1 = this.mMaskArray;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.destroy();
      }
      i += 1;
    }
    localObject1 = this.mRender;
    if (localObject1 != null) {
      ((TextureRender)localObject1).release();
    }
    localObject1 = this.mRenderMerge;
    if (localObject1 != null) {
      ((RenderBuffer)localObject1).destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadMaskManager
 * JD-Core Version:    0.7.0.1
 */