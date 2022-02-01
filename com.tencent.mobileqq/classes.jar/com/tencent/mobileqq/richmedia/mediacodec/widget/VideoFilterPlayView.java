package com.tencent.mobileqq.richmedia.mediacodec.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import barv;
import bauf;
import bauk;
import bauo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class VideoFilterPlayView
  extends HWVideoPlayView
{
  public static int h;
  private bauo jdField_a_of_type_Bauo;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  protected final LinkedList<Runnable> a;
  private GPUBaseFilter jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private GPUBaseFilter c;
  public int i;
  
  public VideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    o();
    int j = h + 1;
    h = j;
    this.i = j;
  }
  
  private void o()
  {
    this.jdField_a_of_type_Bauo = new bauo();
    GPUBaseFilter localGPUBaseFilter = bauf.a(101);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = localGPUBaseFilter;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = localGPUBaseFilter;
    a(new VideoFilterPlayView.1(this));
  }
  
  protected void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_Bauo.a();
    int j = paramInt;
    if (this.jdField_a_of_type_Bauo.a())
    {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Bauo.drawTexture(paramInt, null, null);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      j = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(j, paramArrayOfFloat1, paramArrayOfFloat2);
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
  
  protected void a(@NonNull LinkedList<Runnable> paramLinkedList)
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
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    super.a(null, null);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    a(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void l()
  {
    QLog.w("VideoFilterPlayView", 4, "onDecodeRepeat. can't just repeat");
    super.l();
  }
  
  public void m()
  {
    super.m();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    this.jdField_a_of_type_Bauo.onOutputSizeChanged(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = bauf.a(101);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
  }
  
  public void setColorFilterType(int paramInt)
  {
    if ((!this.jdField_a_of_type_Bauo.a()) && (paramInt == 0)) {
      return;
    }
    this.jdField_a_of_type_Bauo.a(paramInt, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void setColorFilterType(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.jdField_a_of_type_Bauo.a(paramInt1, paramInt2, paramFloat, paramInt3, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
  }
  
  public void setMosaicFilterType(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
      return;
    }
    if (this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter == null)
    {
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = bauf.a(106);
      a(new VideoFilterPlayView.2(this));
    }
    ((bauk)this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter).a(paramBitmap, this.jdField_a_of_type_Barv.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = this.jdField_c_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */