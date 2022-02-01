package com.tencent.mobileqq.filter;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.util.LinkedList;

public class GpuImagePartsFilterGroup
  extends GPUBaseFilter
{
  private GPUDrawPartFilter a;
  private GPUDrawPartFilter b;
  private final LinkedList<Runnable> c = new LinkedList();
  
  private void a(@NonNull Runnable paramRunnable)
  {
    synchronized (this.c)
    {
      this.c.add(paramRunnable);
      return;
    }
  }
  
  private void a(@NonNull LinkedList<Runnable> paramLinkedList)
  {
    try
    {
      while (!paramLinkedList.isEmpty())
      {
        Runnable localRunnable = (Runnable)paramLinkedList.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5)
  {
    a(new GpuImagePartsFilterGroup.2(this, paramInt1, paramInt4, paramInt5, paramInt2, paramInt3, paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (FilterFactory.b(paramInt1))
    {
      a(new GpuImagePartsFilterGroup.1(this, paramInt1, paramInt2, paramInt3));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("filterType ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" is invalid color filter type");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return (this.a != null) || (this.b != null);
  }
  
  public void b()
  {
    a(this.c);
  }
  
  public void destroy()
  {
    GPUDrawPartFilter localGPUDrawPartFilter = this.a;
    if (localGPUDrawPartFilter != null) {
      localGPUDrawPartFilter.destroy();
    }
    localGPUDrawPartFilter = this.b;
    if (localGPUDrawPartFilter != null) {
      localGPUDrawPartFilter.destroy();
    }
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (!a())
    {
      SLog.e("Q.qqstory.publish.edit GpuImagePartsFilterGroup", "must set filters before draw texture");
      return;
    }
    GPUDrawPartFilter localGPUDrawPartFilter = this.a;
    if (localGPUDrawPartFilter != null) {
      localGPUDrawPartFilter.drawTexture(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
    }
    this.b.drawTexture(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void init()
  {
    GPUDrawPartFilter localGPUDrawPartFilter = this.a;
    if ((localGPUDrawPartFilter != null) && (!localGPUDrawPartFilter.isInitialized())) {
      this.a.init();
    }
    localGPUDrawPartFilter = this.b;
    if ((localGPUDrawPartFilter != null) && (!localGPUDrawPartFilter.isInitialized())) {
      this.b.init();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    GPUDrawPartFilter localGPUDrawPartFilter = this.a;
    if (localGPUDrawPartFilter != null) {
      localGPUDrawPartFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
    localGPUDrawPartFilter = this.b;
    if (localGPUDrawPartFilter != null) {
      localGPUDrawPartFilter.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filter.GpuImagePartsFilterGroup
 * JD-Core Version:    0.7.0.1
 */