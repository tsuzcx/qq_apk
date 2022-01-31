package com.tencent.mobileqq.richmedia.mediacodec.widget;

import ahoy;
import ahoz;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class VideoFilterPlayView
  extends HWVideoPlayView
{
  public static int f;
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private GpuImagePartsFilterGroup jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  public final LinkedList a;
  private GPUBaseFilter jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private RenderBuffer jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private GPUBaseFilter c;
  public int g;
  
  public VideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    n();
    int i = f + 1;
    f = i;
    this.g = i;
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup = new GpuImagePartsFilterGroup();
    GPUBaseFilter localGPUBaseFilter = FilterFactory.a(101);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = localGPUBaseFilter;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = localGPUBaseFilter;
    a(new ahoy(this));
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.f();
    int i = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.b())
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a(paramInt, null, null);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      i = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(i, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
  }
  
  protected void a(@NonNull Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramRunnable);
      return;
    }
  }
  
  public void a(@NonNull LinkedList paramLinkedList)
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
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a(this.jdField_a_of_type_JavaUtilLinkedList);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    super.a(null, null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(), paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void l()
  {
    QLog.w("VideoFilterPlayView", 4, "onDecodeRepeat. can't just repeat");
    super.l();
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = FilterFactory.a(101);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
  }
  
  public void setColorFilterType(int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.b()) && (paramInt == 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a(paramInt, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void setColorFilterType(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a(paramInt1, paramInt2, paramFloat, paramInt3, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void setMosaicFilterType(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = FilterFactory.a(106);
      a(new ahoz(this));
    }
    ((GPUImagePixelationFilter)this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter).a(paramBitmap, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */