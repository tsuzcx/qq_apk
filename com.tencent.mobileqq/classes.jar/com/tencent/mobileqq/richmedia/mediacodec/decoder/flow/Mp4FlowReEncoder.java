package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import auxr;
import auxu;
import auxx;
import auya;
import auyb;
import auyn;
import auyo;
import auyp;
import auyr;
import auzc;
import auzf;
import auzk;
import auzr;
import avab;
import avag;
import avaj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements auxu, auyb, auyp, auzr
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private auxr jdField_a_of_type_Auxr;
  private auyo jdField_a_of_type_Auyo = new auyo();
  private auzc jdField_a_of_type_Auzc = new auzc();
  private auzf jdField_a_of_type_Auzf;
  private auzk jdField_a_of_type_Auzk;
  private auzr jdField_a_of_type_Auzr;
  private avaj jdField_a_of_type_Avaj;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<auxx> jdField_a_of_type_JavaUtilComparator = new auyr(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a(List<auxx> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((auxx)paramList.get(0)).a() + " - " + ((auxx)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((auxx)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        auxx localauxx = (auxx)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localauxx.a();
        int j = k;
        if (this.jdField_a_of_type_Avaj != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Avaj.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Avaj.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Auzf.jdField_a_of_type_Int, this.jdField_a_of_type_Auzf.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Auzk != null) {
          this.jdField_a_of_type_Auzk.a();
        }
        localRenderBuffer.unbind();
        long l = (localauxx.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Auyo.b(3553, j, localauxx.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localauxx.b();
        i += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Avaj != null) {
      this.jdField_a_of_type_Avaj.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<auxx> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((auxx)paramList.get(0)).a() + " - " + ((auxx)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_Auyo.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Auzf.jdField_a_of_type_Int, this.jdField_a_of_type_Auzf.jdField_b_of_type_Int, 33984);
      if ((avab.a(this.jdField_a_of_type_Auzf.f)) || (this.jdField_a_of_type_Auzf.c != null))
      {
        this.jdField_a_of_type_Avaj = new avaj();
        if (avab.a(this.jdField_a_of_type_Auzf.f)) {
          this.jdField_a_of_type_Avaj.a(avab.a(this.jdField_a_of_type_Auzf.f));
        }
        if (this.jdField_a_of_type_Auzf.c != null)
        {
          localObject = avab.a(106);
          ((avag)localObject).a(this.jdField_a_of_type_Auzf.c);
          this.jdField_a_of_type_Avaj.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Avaj.onOutputSizeChanged(this.jdField_a_of_type_Auzf.jdField_a_of_type_Int, this.jdField_a_of_type_Auzf.jdField_b_of_type_Int);
        this.jdField_a_of_type_Avaj.init();
      }
      Object localObject = this.jdField_a_of_type_Auzf.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Auzf.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = auyn.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = avab.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Auzf.jdField_a_of_type_Int, this.jdField_a_of_type_Auzf.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new auya(this.jdField_a_of_type_Auxr);
        ((auya)localObject).b = false;
        ((auya)localObject).a = EGL14.eglGetCurrentContext();
        ((auya)localObject).c = 2;
        this.jdField_a_of_type_Auzc.a((auya)localObject, this, this);
        if (this.jdField_a_of_type_Auzr != null)
        {
          this.jdField_a_of_type_Auzr.a();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Auzf.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
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
  
  public void a(auxr paramauxr, auzf paramauzf, auzr paramauzr, auzk paramauzk)
  {
    this.jdField_a_of_type_Auxr = paramauxr;
    this.jdField_a_of_type_Auzf = paramauzf;
    this.jdField_a_of_type_Auzr = paramauzr;
    this.jdField_a_of_type_Auzk = paramauzk;
    this.jdField_a_of_type_Auyo.a(paramauzf, this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Auzr != null) {
      this.jdField_a_of_type_Auzr.a(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      auyn.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    c();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    auxx.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Auzc.a();
    if (this.jdField_a_of_type_Auzr != null) {
      this.jdField_a_of_type_Auzr.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Auzr != null) {
      this.jdField_a_of_type_Auzr.b();
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
    this.jdField_a_of_type_Auyo.b();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Auyo.b();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */