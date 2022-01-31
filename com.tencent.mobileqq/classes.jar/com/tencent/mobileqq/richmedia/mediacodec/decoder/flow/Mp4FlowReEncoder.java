package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import avxk;
import avxn;
import avxq;
import avxt;
import avxu;
import avyg;
import avyh;
import avyi;
import avyk;
import avyv;
import avyy;
import avzd;
import avzk;
import avzu;
import avzz;
import awac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements avxn, avxu, avyi, avzk
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private avxk jdField_a_of_type_Avxk;
  private avyh jdField_a_of_type_Avyh = new avyh();
  private avyv jdField_a_of_type_Avyv = new avyv();
  private avyy jdField_a_of_type_Avyy;
  private avzd jdField_a_of_type_Avzd;
  private avzk jdField_a_of_type_Avzk;
  private awac jdField_a_of_type_Awac;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<avxq> jdField_a_of_type_JavaUtilComparator = new avyk(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a(List<avxq> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((avxq)paramList.get(0)).a() + " - " + ((avxq)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((avxq)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        avxq localavxq = (avxq)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localavxq.a();
        int j = k;
        if (this.jdField_a_of_type_Awac != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Awac.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Awac.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Avyy.jdField_a_of_type_Int, this.jdField_a_of_type_Avyy.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Avzd != null) {
          this.jdField_a_of_type_Avzd.a();
        }
        localRenderBuffer.unbind();
        long l = (localavxq.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Avyh.b(3553, j, localavxq.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localavxq.b();
        i += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Awac != null) {
      this.jdField_a_of_type_Awac.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<avxq> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((avxq)paramList.get(0)).a() + " - " + ((avxq)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_Avyh.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Avyy.jdField_a_of_type_Int, this.jdField_a_of_type_Avyy.jdField_b_of_type_Int, 33984);
      if ((avzu.a(this.jdField_a_of_type_Avyy.f)) || (this.jdField_a_of_type_Avyy.c != null))
      {
        this.jdField_a_of_type_Awac = new awac();
        if (avzu.a(this.jdField_a_of_type_Avyy.f)) {
          this.jdField_a_of_type_Awac.a(avzu.a(this.jdField_a_of_type_Avyy.f));
        }
        if (this.jdField_a_of_type_Avyy.c != null)
        {
          localObject = avzu.a(106);
          ((avzz)localObject).a(this.jdField_a_of_type_Avyy.c);
          this.jdField_a_of_type_Awac.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Awac.onOutputSizeChanged(this.jdField_a_of_type_Avyy.jdField_a_of_type_Int, this.jdField_a_of_type_Avyy.jdField_b_of_type_Int);
        this.jdField_a_of_type_Awac.init();
      }
      Object localObject = this.jdField_a_of_type_Avyy.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Avyy.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = avyg.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = avzu.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Avyy.jdField_a_of_type_Int, this.jdField_a_of_type_Avyy.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new avxt(this.jdField_a_of_type_Avxk);
        ((avxt)localObject).b = false;
        ((avxt)localObject).a = EGL14.eglGetCurrentContext();
        ((avxt)localObject).c = 2;
        this.jdField_a_of_type_Avyv.a((avxt)localObject, this, this);
        if (this.jdField_a_of_type_Avzk != null)
        {
          this.jdField_a_of_type_Avzk.a();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Avyy.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
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
  
  public void a(avxk paramavxk, avyy paramavyy, avzk paramavzk, avzd paramavzd)
  {
    this.jdField_a_of_type_Avxk = paramavxk;
    this.jdField_a_of_type_Avyy = paramavyy;
    this.jdField_a_of_type_Avzk = paramavzk;
    this.jdField_a_of_type_Avzd = paramavzd;
    this.jdField_a_of_type_Avyh.a(paramavyy, this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Avzk != null) {
      this.jdField_a_of_type_Avzk.a(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      avyg.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    c();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    avxq.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Avyv.a();
    if (this.jdField_a_of_type_Avzk != null) {
      this.jdField_a_of_type_Avzk.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Avzk != null) {
      this.jdField_a_of_type_Avzk.b();
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
    this.jdField_a_of_type_Avyh.b();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Avyh.b();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */