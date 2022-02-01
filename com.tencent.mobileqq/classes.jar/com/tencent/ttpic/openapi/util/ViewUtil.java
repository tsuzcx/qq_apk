package com.tencent.ttpic.openapi.util;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.SpaceFilter;

public class ViewUtil
{
  private Frame copyFrame = new Frame();
  private boolean isInited = false;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private SpaceFilter mViewFilter = new SpaceFilter();
  private Frame viewFrame = new Frame();
  
  public void clear()
  {
    this.isInited = false;
    this.mCopyFilter.clearGLSL();
    this.mViewFilter.clearGLSL();
    this.copyFrame.unlock();
    this.copyFrame.clear();
    this.viewFrame.unlock();
    this.viewFrame.clear();
  }
  
  public void init()
  {
    this.mCopyFilter.apply();
    this.mViewFilter.apply();
    this.isInited = true;
  }
  
  public void show(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!this.isInited) {
      init();
    }
    this.mCopyFilter.setRotationAndFlip(0, 0, 1);
    this.mCopyFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, paramInt2 / paramInt3, this.copyFrame);
    this.mCopyFilter.setRotationAndFlip(0, 0, 0);
    this.mViewFilter.RenderProcess(this.copyFrame.getTextureId(), paramInt2, paramInt3, paramInt4, paramInt5, 0, 0.0D, this.viewFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.ViewUtil
 * JD-Core Version:    0.7.0.1
 */