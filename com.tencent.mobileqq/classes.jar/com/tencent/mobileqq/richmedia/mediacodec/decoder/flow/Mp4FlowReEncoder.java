package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import bbko;
import bbkr;
import bbku;
import bbkx;
import bbky;
import bblk;
import bbll;
import bblm;
import bblo;
import bblz;
import bbmc;
import bbmh;
import bbmo;
import bbmy;
import bbnd;
import bbng;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements bbkr, bbky, bblm, bbmo
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private bbko jdField_a_of_type_Bbko;
  private bbll jdField_a_of_type_Bbll = new bbll();
  private bblz jdField_a_of_type_Bblz = new bblz();
  private bbmc jdField_a_of_type_Bbmc;
  private bbmh jdField_a_of_type_Bbmh;
  private bbmo jdField_a_of_type_Bbmo;
  private bbng jdField_a_of_type_Bbng;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<bbku> jdField_a_of_type_JavaUtilComparator = new bblo(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a(List<bbku> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((bbku)paramList.get(0)).a() + " - " + ((bbku)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((bbku)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        bbku localbbku = (bbku)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localbbku.a();
        int j = k;
        if (this.jdField_a_of_type_Bbng != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Bbng.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Bbng.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Bbmc.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmc.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Bbmh != null) {
          this.jdField_a_of_type_Bbmh.a();
        }
        localRenderBuffer.unbind();
        long l = (localbbku.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Bbll.b(3553, j, localbbku.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localbbku.b();
        i += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bbng != null) {
      this.jdField_a_of_type_Bbng.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<bbku> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((bbku)paramList.get(0)).a() + " - " + ((bbku)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_Bbll.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Bbmc.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmc.jdField_b_of_type_Int, 33984);
      if ((bbmy.a(this.jdField_a_of_type_Bbmc.f)) || (this.jdField_a_of_type_Bbmc.c != null))
      {
        this.jdField_a_of_type_Bbng = new bbng();
        if (bbmy.a(this.jdField_a_of_type_Bbmc.f)) {
          this.jdField_a_of_type_Bbng.a(bbmy.a(this.jdField_a_of_type_Bbmc.f));
        }
        if (this.jdField_a_of_type_Bbmc.c != null)
        {
          localObject = bbmy.a(106);
          ((bbnd)localObject).a(this.jdField_a_of_type_Bbmc.c);
          this.jdField_a_of_type_Bbng.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Bbng.onOutputSizeChanged(this.jdField_a_of_type_Bbmc.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmc.jdField_b_of_type_Int);
        this.jdField_a_of_type_Bbng.init();
      }
      Object localObject = this.jdField_a_of_type_Bbmc.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Bbmc.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = bblk.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = bbmy.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Bbmc.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmc.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new bbkx(this.jdField_a_of_type_Bbko);
        ((bbkx)localObject).b = false;
        ((bbkx)localObject).a = EGL14.eglGetCurrentContext();
        ((bbkx)localObject).c = 2;
        this.jdField_a_of_type_Bblz.a((bbkx)localObject, this, this);
        if (this.jdField_a_of_type_Bbmo != null)
        {
          this.jdField_a_of_type_Bbmo.a();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Bbmc.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
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
  
  public void a(bbko parambbko, bbmc parambbmc, bbmo parambbmo, bbmh parambbmh)
  {
    this.jdField_a_of_type_Bbko = parambbko;
    this.jdField_a_of_type_Bbmc = parambbmc;
    this.jdField_a_of_type_Bbmo = parambbmo;
    this.jdField_a_of_type_Bbmh = parambbmh;
    this.jdField_a_of_type_Bbll.a(parambbmc, this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Bbmo != null) {
      this.jdField_a_of_type_Bbmo.a(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      bblk.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    c();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    bbku.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Bblz.a();
    if (this.jdField_a_of_type_Bbmo != null) {
      this.jdField_a_of_type_Bbmo.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbmo != null) {
      this.jdField_a_of_type_Bbmo.b();
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
    this.jdField_a_of_type_Bbll.b();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Bbll.b();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */