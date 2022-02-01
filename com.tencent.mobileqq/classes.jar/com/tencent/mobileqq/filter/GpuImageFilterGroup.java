package com.tencent.mobileqq.filter;

import android.support.annotation.NonNull;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GpuImageFilterGroup
  extends GPUBaseFilter
{
  private boolean a = false;
  private List<GPUBaseFilter> b = new ArrayList();
  private List<RenderBuffer> c;
  private int d = -1;
  
  private void b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RenderBuffer)((Iterator)localObject).next()).destroy();
      }
      this.c = null;
    }
  }
  
  public RenderBuffer a()
  {
    List localList = this.c;
    if ((localList != null) && (localList.size() > 0))
    {
      localList = this.c;
      return (RenderBuffer)localList.get(localList.size() - 1);
    }
    throw new RuntimeException("please check your state");
  }
  
  public void a(@NonNull GPUBaseFilter paramGPUBaseFilter)
  {
    this.b.add(paramGPUBaseFilter);
  }
  
  public void destroy()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GPUBaseFilter)localIterator.next()).destroy();
    }
    b();
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.d = paramInt;
    paramInt = 0;
    while (paramInt < this.b.size())
    {
      if (paramInt != this.b.size() - 1)
      {
        ((RenderBuffer)this.c.get(paramInt)).bind();
        ((GPUBaseFilter)this.b.get(paramInt)).drawTexture(this.d, null, null);
        ((RenderBuffer)this.c.get(paramInt)).unbind();
        this.d = ((RenderBuffer)this.c.get(paramInt)).getTexId();
      }
      else if (this.a)
      {
        ((GPUBaseFilter)this.b.get(paramInt)).drawTexture(this.d, paramArrayOfFloat1, paramArrayOfFloat2);
      }
      else
      {
        ((RenderBuffer)this.c.get(paramInt)).bind();
        ((GPUBaseFilter)this.b.get(paramInt)).drawTexture(this.d, paramArrayOfFloat1, paramArrayOfFloat2);
        ((RenderBuffer)this.c.get(paramInt)).unbind();
        this.d = ((RenderBuffer)this.c.get(paramInt)).getTexId();
      }
      paramInt += 1;
    }
  }
  
  public void init()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((GPUBaseFilter)localIterator.next()).init();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GPUBaseFilter)((Iterator)localObject).next()).onOutputSizeChanged(paramInt1, paramInt2);
    }
    b();
    this.c = new ArrayList();
    int j = this.b.size();
    int i = j;
    if (this.a) {
      i = j - 1;
    }
    j = 0;
    while (j < i)
    {
      localObject = new RenderBuffer(paramInt1, paramInt2, 33984);
      this.c.add(localObject);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.GpuImageFilterGroup
 * JD-Core Version:    0.7.0.1
 */