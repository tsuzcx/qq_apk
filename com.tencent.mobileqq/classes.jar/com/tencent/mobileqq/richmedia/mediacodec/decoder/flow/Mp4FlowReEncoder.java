package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import axpl;
import axpo;
import axpr;
import axpu;
import axpv;
import axqh;
import axqi;
import axqj;
import axql;
import axqw;
import axqz;
import axre;
import axrl;
import axrv;
import axsa;
import axsd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements axpo, axpv, axqj, axrl
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private axpl jdField_a_of_type_Axpl;
  private axqi jdField_a_of_type_Axqi = new axqi();
  private axqw jdField_a_of_type_Axqw = new axqw();
  private axqz jdField_a_of_type_Axqz;
  private axre jdField_a_of_type_Axre;
  private axrl jdField_a_of_type_Axrl;
  private axsd jdField_a_of_type_Axsd;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<axpr> jdField_a_of_type_JavaUtilComparator = new axql(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a(List<axpr> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((axpr)paramList.get(0)).a() + " - " + ((axpr)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((axpr)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        axpr localaxpr = (axpr)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localaxpr.a();
        int j = k;
        if (this.jdField_a_of_type_Axsd != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Axsd.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Axsd.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Axqz.jdField_a_of_type_Int, this.jdField_a_of_type_Axqz.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Axre != null) {
          this.jdField_a_of_type_Axre.a();
        }
        localRenderBuffer.unbind();
        long l = (localaxpr.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Axqi.b(3553, j, localaxpr.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localaxpr.b();
        i += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Axsd != null) {
      this.jdField_a_of_type_Axsd.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<axpr> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((axpr)paramList.get(0)).a() + " - " + ((axpr)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_Axqi.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Axqz.jdField_a_of_type_Int, this.jdField_a_of_type_Axqz.jdField_b_of_type_Int, 33984);
      if ((axrv.a(this.jdField_a_of_type_Axqz.f)) || (this.jdField_a_of_type_Axqz.c != null))
      {
        this.jdField_a_of_type_Axsd = new axsd();
        if (axrv.a(this.jdField_a_of_type_Axqz.f)) {
          this.jdField_a_of_type_Axsd.a(axrv.a(this.jdField_a_of_type_Axqz.f));
        }
        if (this.jdField_a_of_type_Axqz.c != null)
        {
          localObject = axrv.a(106);
          ((axsa)localObject).a(this.jdField_a_of_type_Axqz.c);
          this.jdField_a_of_type_Axsd.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Axsd.onOutputSizeChanged(this.jdField_a_of_type_Axqz.jdField_a_of_type_Int, this.jdField_a_of_type_Axqz.jdField_b_of_type_Int);
        this.jdField_a_of_type_Axsd.init();
      }
      Object localObject = this.jdField_a_of_type_Axqz.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Axqz.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = axqh.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = axrv.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Axqz.jdField_a_of_type_Int, this.jdField_a_of_type_Axqz.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new axpu(this.jdField_a_of_type_Axpl);
        ((axpu)localObject).b = false;
        ((axpu)localObject).a = EGL14.eglGetCurrentContext();
        ((axpu)localObject).c = 2;
        this.jdField_a_of_type_Axqw.a((axpu)localObject, this, this);
        if (this.jdField_a_of_type_Axrl != null)
        {
          this.jdField_a_of_type_Axrl.a();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Axqz.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
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
  
  public void a(axpl paramaxpl, axqz paramaxqz, axrl paramaxrl, axre paramaxre)
  {
    this.jdField_a_of_type_Axpl = paramaxpl;
    this.jdField_a_of_type_Axqz = paramaxqz;
    this.jdField_a_of_type_Axrl = paramaxrl;
    this.jdField_a_of_type_Axre = paramaxre;
    this.jdField_a_of_type_Axqi.a(paramaxqz, this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Axrl != null) {
      this.jdField_a_of_type_Axrl.a(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      axqh.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    c();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    axpr.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Axqw.a();
    if (this.jdField_a_of_type_Axrl != null) {
      this.jdField_a_of_type_Axrl.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axrl != null) {
      this.jdField_a_of_type_Axrl.b();
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
    this.jdField_a_of_type_Axqi.b();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Axqi.b();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */