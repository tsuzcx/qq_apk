package com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.ttpic.openapi.filter.stylizefilter.IStlylizeFilterIniter;
import java.util.Map;

public class FaceFeatherMaskFilterGroup
  extends AEChainI
  implements AEFilterI, IStlylizeFilterIniter
{
  private int fHeight;
  private int fWidth;
  private FaceHorizontalBlurFilter mFaceHorizontalBlurFilter = new FaceHorizontalBlurFilter();
  private FaceHorizontalErosionFilter mFaceHorizontalErosionFilter = new FaceHorizontalErosionFilter();
  private FaceVerticalBlurFilter mFaceVerticalBlurFilter = new FaceVerticalBlurFilter();
  private FaceVerticalErosionFilter mFaceVerticalErosionFilter = new FaceVerticalErosionFilter();
  private int textureID;
  
  private void updateFrameSize()
  {
    this.mFaceVerticalErosionFilter.updateFrameSize(this.fWidth, this.fHeight);
    this.mFaceHorizontalErosionFilter.updateFrameSize(this.fWidth, this.fHeight);
    this.mFaceVerticalBlurFilter.updateFrameSize(this.fWidth, this.fHeight);
    this.mFaceHorizontalBlurFilter.updateFrameSize(this.fWidth, this.fHeight);
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void apply()
  {
    this.mFaceHorizontalBlurFilter.apply();
    this.mFaceHorizontalErosionFilter.apply();
    this.mFaceVerticalBlurFilter.apply();
    this.mFaceVerticalErosionFilter.apply();
  }
  
  public void clear()
  {
    this.mFaceHorizontalBlurFilter.clearGLSLSelf();
    this.mFaceHorizontalErosionFilter.clearGLSLSelf();
    this.mFaceVerticalBlurFilter.clearGLSLSelf();
    this.mFaceVerticalErosionFilter.clearGLSLSelf();
  }
  
  public Frame render(Frame paramFrame)
  {
    updateFrameSize();
    Frame localFrame = FrameBufferCache.getInstance().get(this.fWidth, this.fHeight);
    this.mFaceVerticalErosionFilter.RenderProcess(this.textureID, this.fWidth, this.fHeight, -1, 0.0D, localFrame);
    paramFrame = FrameBufferCache.getInstance().get(this.fWidth, this.fHeight);
    this.mFaceHorizontalErosionFilter.RenderProcess(localFrame.getTextureId(), this.fWidth, this.fHeight, -1, 0.0D, paramFrame);
    if (localFrame != paramFrame) {
      localFrame.unlock();
    }
    localFrame = FrameBufferCache.getInstance().get(this.fWidth, this.fHeight);
    this.mFaceVerticalBlurFilter.RenderProcess(paramFrame.getTextureId(), this.fWidth, this.fHeight, -1, 0.0D, localFrame);
    if (paramFrame != localFrame) {
      paramFrame.unlock();
    }
    paramFrame = FrameBufferCache.getInstance().get(this.fWidth, this.fHeight);
    this.mFaceHorizontalBlurFilter.RenderProcess(localFrame.getTextureId(), this.fWidth, this.fHeight, -1, 0.0D, paramFrame);
    if (localFrame != paramFrame) {
      localFrame.unlock();
    }
    return paramFrame;
  }
  
  public void setTextureID(int paramInt)
  {
    this.textureID = paramInt;
  }
  
  public void updateFaceFeatherWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.fWidth = paramInt1;
    this.fHeight = paramInt2;
  }
  
  public void updateLutPaths(Map<String, String> paramMap) {}
  
  public void updateMateriaPaths(Map<String, String> paramMap) {}
  
  public void updatePreview(Object paramObject) {}
  
  public void updateRadius(int paramInt1, int paramInt2)
  {
    this.mFaceVerticalErosionFilter.updateRadius(paramInt2);
    this.mFaceHorizontalErosionFilter.updateRadius(paramInt1);
    this.mFaceVerticalBlurFilter.updateRadius(paramInt2);
    this.mFaceHorizontalBlurFilter.updateRadius(paramInt1);
  }
  
  public void updateThresholdValue(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter.FaceFeatherMaskFilterGroup
 * JD-Core Version:    0.7.0.1
 */