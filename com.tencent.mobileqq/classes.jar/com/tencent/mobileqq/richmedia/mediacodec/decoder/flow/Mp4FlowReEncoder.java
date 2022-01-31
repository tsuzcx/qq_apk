package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import axtu;
import axtx;
import axua;
import axud;
import axue;
import axuq;
import axur;
import axus;
import axuu;
import axvf;
import axvi;
import axvn;
import axvu;
import axwe;
import axwj;
import axwm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements axtx, axue, axus, axvu
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private axtu jdField_a_of_type_Axtu;
  private axur jdField_a_of_type_Axur = new axur();
  private axvf jdField_a_of_type_Axvf = new axvf();
  private axvi jdField_a_of_type_Axvi;
  private axvn jdField_a_of_type_Axvn;
  private axvu jdField_a_of_type_Axvu;
  private axwm jdField_a_of_type_Axwm;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<axua> jdField_a_of_type_JavaUtilComparator = new axuu(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a(List<axua> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((axua)paramList.get(0)).a() + " - " + ((axua)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((axua)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        axua localaxua = (axua)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localaxua.a();
        int j = k;
        if (this.jdField_a_of_type_Axwm != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Axwm.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Axwm.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Axvn != null) {
          this.jdField_a_of_type_Axvn.a();
        }
        localRenderBuffer.unbind();
        long l = (localaxua.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Axur.b(3553, j, localaxua.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localaxua.b();
        i += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Axwm != null) {
      this.jdField_a_of_type_Axwm.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<axua> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((axua)paramList.get(0)).a() + " - " + ((axua)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_Axur.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.jdField_b_of_type_Int, 33984);
      if ((axwe.a(this.jdField_a_of_type_Axvi.f)) || (this.jdField_a_of_type_Axvi.c != null))
      {
        this.jdField_a_of_type_Axwm = new axwm();
        if (axwe.a(this.jdField_a_of_type_Axvi.f)) {
          this.jdField_a_of_type_Axwm.a(axwe.a(this.jdField_a_of_type_Axvi.f));
        }
        if (this.jdField_a_of_type_Axvi.c != null)
        {
          localObject = axwe.a(106);
          ((axwj)localObject).a(this.jdField_a_of_type_Axvi.c);
          this.jdField_a_of_type_Axwm.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Axwm.onOutputSizeChanged(this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.jdField_b_of_type_Int);
        this.jdField_a_of_type_Axwm.init();
      }
      Object localObject = this.jdField_a_of_type_Axvi.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Axvi.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = axuq.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = axwe.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new axud(this.jdField_a_of_type_Axtu);
        ((axud)localObject).b = false;
        ((axud)localObject).a = EGL14.eglGetCurrentContext();
        ((axud)localObject).c = 2;
        this.jdField_a_of_type_Axvf.a((axud)localObject, this, this);
        if (this.jdField_a_of_type_Axvu != null)
        {
          this.jdField_a_of_type_Axvu.a();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Axvi.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
        }
        a_(1, localOutOfMemoryError);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      a_(4, localException);
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onEncodeStart ex=" + localException);
    }
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    a_(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong) {}
  
  public void a(axtu paramaxtu, axvi paramaxvi, axvu paramaxvu, axvn paramaxvn)
  {
    this.jdField_a_of_type_Axtu = paramaxtu;
    this.jdField_a_of_type_Axvi = paramaxvi;
    this.jdField_a_of_type_Axvu = paramaxvu;
    this.jdField_a_of_type_Axvn = paramaxvn;
    this.jdField_a_of_type_Axur.a(paramaxvi, this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Axvu != null) {
      this.jdField_a_of_type_Axvu.a(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      axuq.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    c();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    axua.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Axvf.a();
    if (this.jdField_a_of_type_Axvu != null) {
      this.jdField_a_of_type_Axvu.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axvu != null) {
      this.jdField_a_of_type_Axvu.b();
    }
  }
  
  public void b(long paramLong) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeStart");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_a_of_type_Axur.b();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Axur.b();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */