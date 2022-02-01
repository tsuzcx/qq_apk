package com.tencent.ttpic.openapi.filter.stylizefilter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import java.util.Map;

public class TTPencilFilterGroup
  extends AEChainI
  implements AEFilterI, IStlylizeFilterIniter
{
  private GPUImageLookupFilter mLookupFilter;
  private TTColorPencilFilter mTTColorPencilFilter = new TTColorPencilFilter();
  private TTGrayPencilFilter mTTGrayPencilFilter = new TTGrayPencilFilter();
  private TTMaximumFilter mTTMaximumFilter = new TTMaximumFilter();
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void apply()
  {
    this.mTTMaximumFilter.apply();
    this.mTTGrayPencilFilter.apply();
    this.mTTColorPencilFilter.apply();
    GPUImageLookupFilter localGPUImageLookupFilter = this.mLookupFilter;
    if (localGPUImageLookupFilter != null) {
      localGPUImageLookupFilter.apply();
    }
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    this.mTTMaximumFilter.clearGLSLSelf();
    this.mTTGrayPencilFilter.clearGLSLSelf();
    this.mTTColorPencilFilter.clearGLSLSelf();
    GPUImageLookupFilter localGPUImageLookupFilter = this.mLookupFilter;
    if (localGPUImageLookupFilter != null) {
      localGPUImageLookupFilter.clearGLSLSelf();
    }
    this.mIsApplied = false;
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.mLookupFilter == null) {
      return paramFrame;
    }
    this.mTTMaximumFilter.updateWidthHeightParam(2.0F / paramFrame.width, 2.0F / paramFrame.height);
    Frame localFrame1 = this.mTTMaximumFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width / 2, paramFrame.height / 2);
    this.mTTGrayPencilFilter.setTexture2(localFrame1.getTextureId());
    Frame localFrame2 = this.mTTGrayPencilFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    this.mTTColorPencilFilter.setTexture2(localFrame2.getTextureId());
    Frame localFrame3 = this.mTTColorPencilFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    this.mLookupFilter.RenderProcess(localFrame3.getTextureId(), localFrame3.width, localFrame3.height, -1, 0.0D, paramFrame);
    localFrame3.unlock();
    localFrame1.unlock();
    localFrame2.unlock();
    return paramFrame;
  }
  
  public void updateLutPaths(Map<String, String> paramMap)
  {
    int j = 1;
    int i;
    if (paramMap == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramMap.size() > 0) {
      j = 0;
    }
    if ((j | i) != 0) {
      return;
    }
    this.mLookupFilter = new GPUImageLookupFilter((String)paramMap.get("lut1"));
  }
  
  public void updateMateriaPaths(Map<String, String> paramMap)
  {
    this.mTTGrayPencilFilter.updateMateriaPaths(paramMap);
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateThresholdValue(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.TTPencilFilterGroup
 * JD-Core Version:    0.7.0.1
 */