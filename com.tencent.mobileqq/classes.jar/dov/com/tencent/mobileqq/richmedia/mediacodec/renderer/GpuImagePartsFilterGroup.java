package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.support.annotation.NonNull;
import anxd;
import anxe;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import java.util.LinkedList;

public class GpuImagePartsFilterGroup
  extends GPUBaseFilter
{
  private float jdField_a_of_type_Float;
  private GPUDrawPartFilter jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter;
  private final LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private GPUDrawPartFilter b;
  
  private void a(@NonNull Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramRunnable);
      return;
    }
  }
  
  private void a(@NonNull LinkedList paramLinkedList)
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
    }
    finally {}
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter != null) && (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter.a())) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter.a();
    }
    if ((this.b != null) && (!this.b.a())) {
      this.b.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter.a(paramInt1, paramInt2);
    }
    if (this.b != null) {
      this.b.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5)
  {
    a(new anxe(this, paramInt1, paramInt4, paramInt5, paramInt2, paramInt3, paramFloat));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!FilterFactory.a(paramInt1)) {
      throw new IllegalArgumentException("filterType " + paramInt1 + " is invalid color filter type");
    }
    a(new anxd(this, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (!b())
    {
      SLog.e("Q.qqstory.publish.edit GpuImagePartsFilterGroup", "must set filters before draw texture");
      return;
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter.a(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
    }
    this.b.a(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter != null) || (this.b != null);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGPUDrawPartFilter.c();
    }
    if (this.b != null) {
      this.b.c();
    }
  }
  
  public void f()
  {
    a(this.jdField_a_of_type_JavaUtilLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup
 * JD-Core Version:    0.7.0.1
 */