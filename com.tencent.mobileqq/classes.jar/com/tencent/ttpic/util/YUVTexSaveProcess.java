package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.view.FilterDefault;

public class YUVTexSaveProcess
  implements TexSaveProcess
{
  private byte[] mData;
  private BaseFilter mFilter = new BaseFilter(GLSLRender.FILTER_RGB2YUV_SHADER);
  private Frame mRenderFrame = new Frame();
  private byte[] mYUVAData;
  
  private void initData(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2 * 3 / 2;
    if ((this.mData == null) || (this.mData.length < i))
    {
      this.mData = new byte[i];
      this.mYUVAData = new byte[paramInt1 * paramInt2 * 4];
    }
  }
  
  public void clear()
  {
    this.mFilter.clearGLSLSelf();
    this.mRenderFrame.clear();
    this.mData = null;
    this.mYUVAData = null;
  }
  
  public void init()
  {
    this.mFilter.ApplyGLSLFilter(true, 0.0F, 0.0F);
  }
  
  public boolean retrieveData(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    return false;
  }
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3)
  {
    init();
    initData(paramInt2, paramInt3);
    this.mRenderFrame.bindFrame(-1, paramInt2, paramInt3, 0.0D);
    this.mFilter.OnDrawFrameGLSL();
    this.mFilter.renderTexture(paramInt1, paramInt2, paramInt3);
    if (FilterDefault.currentShareIndex < 0) {
      GLSLRender.nativeToRGBData(this.mYUVAData, paramInt2, paramInt3);
    }
    for (;;)
    {
      AlgoUtils.YUVX2YUV(this.mYUVAData, this.mData, paramInt2, paramInt3);
      return this.mData;
      GLSLRender.nativePushDataFromTexture(this.mYUVAData, paramInt2, paramInt3, FilterDefault.currentShareIndex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.YUVTexSaveProcess
 * JD-Core Version:    0.7.0.1
 */