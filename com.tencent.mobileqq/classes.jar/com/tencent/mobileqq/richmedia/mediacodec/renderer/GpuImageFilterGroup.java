package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GpuImageFilterGroup
  extends GPUBaseFilter
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List b;
  private int e = -1;
  
  private void g()
  {
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((RenderBuffer)localIterator.next()).d();
      }
      this.b = null;
    }
  }
  
  public RenderBuffer a()
  {
    if ((this.b != null) && (this.b.size() > 0)) {
      return (RenderBuffer)this.b.get(this.b.size() - 1);
    }
    throw new RuntimeException("please check your state");
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GPUBaseFilter)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GPUBaseFilter)((Iterator)localObject).next()).a(paramInt1, paramInt2);
    }
    g();
    this.b = new ArrayList();
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = j - 1;
    }
    j = 0;
    while (j < i)
    {
      localObject = new RenderBuffer(paramInt1, paramInt2, 33984);
      this.b.add(localObject);
      j += 1;
    }
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.e = paramInt;
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (paramInt != this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        ((RenderBuffer)this.b.get(paramInt)).b();
        ((GPUBaseFilter)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(this.e, null, null);
        ((RenderBuffer)this.b.get(paramInt)).c();
        this.e = ((RenderBuffer)this.b.get(paramInt)).a();
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (this.jdField_a_of_type_Boolean)
        {
          ((GPUBaseFilter)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(this.e, paramArrayOfFloat1, paramArrayOfFloat2);
        }
        else
        {
          ((RenderBuffer)this.b.get(paramInt)).b();
          ((GPUBaseFilter)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(this.e, paramArrayOfFloat1, paramArrayOfFloat2);
          ((RenderBuffer)this.b.get(paramInt)).c();
          this.e = ((RenderBuffer)this.b.get(paramInt)).a();
        }
      }
    }
  }
  
  public void a(@NonNull GPUBaseFilter paramGPUBaseFilter)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramGPUBaseFilter);
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((GPUBaseFilter)localIterator.next()).d();
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImageFilterGroup
 * JD-Core Version:    0.7.0.1
 */