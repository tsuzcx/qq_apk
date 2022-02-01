package com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.filter.stylizefilter.IStlylizeFilterIniter;
import com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTLookupFilter;
import java.util.Map;

public class TTToonFilterGroup
  extends AEChainI
  implements AEFilterI, IStlylizeFilterIniter
{
  private GPUImageKuwaharaFilter mGpuImageKuwaharaFilter = new GPUImageKuwaharaFilter();
  private TTLookupFilter mTTLookupFilter = new TTLookupFilter();
  private TTToonEdgeFilter mTTToonEdgeFilter = new TTToonEdgeFilter();
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return render(paramFrame);
  }
  
  public void apply()
  {
    this.mGpuImageKuwaharaFilter.apply();
    this.mTTLookupFilter.apply();
    this.mTTToonEdgeFilter.apply();
  }
  
  public void clear()
  {
    this.mGpuImageKuwaharaFilter.clearGLSLSelf();
    this.mTTLookupFilter.clearGLSLSelf();
    this.mTTToonEdgeFilter.clearGLSLSelf();
  }
  
  public Frame render(Frame paramFrame)
  {
    return this.mGpuImageKuwaharaFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public void updateLutPaths(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0)) {
      return;
    }
    this.mTTLookupFilter.updateLutPaths(paramMap);
    this.mTTToonEdgeFilter.updateLutPaths(paramMap);
  }
  
  public void updateMateriaPaths(Map<String, String> paramMap)
  {
    this.mTTToonEdgeFilter.updateMateriaPaths(paramMap);
  }
  
  public void updatePreview(Object paramObject) {}
  
  public void updateThresholdValue(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.toonFilter.TTToonFilterGroup
 * JD-Core Version:    0.7.0.1
 */