package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import avxm;
import avxp;
import avxs;
import avxv;
import avxw;
import avyi;
import avyj;
import avyk;
import avym;
import avyx;
import avza;
import avzf;
import avzm;
import avzw;
import awab;
import awae;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements avxp, avxw, avyk, avzm
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private avxm jdField_a_of_type_Avxm;
  private avyj jdField_a_of_type_Avyj = new avyj();
  private avyx jdField_a_of_type_Avyx = new avyx();
  private avza jdField_a_of_type_Avza;
  private avzf jdField_a_of_type_Avzf;
  private avzm jdField_a_of_type_Avzm;
  private awae jdField_a_of_type_Awae;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<avxs> jdField_a_of_type_JavaUtilComparator = new avym(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a(List<avxs> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((avxs)paramList.get(0)).a() + " - " + ((avxs)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((avxs)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        avxs localavxs = (avxs)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localavxs.a();
        int j = k;
        if (this.jdField_a_of_type_Awae != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Awae.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Awae.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Avza.jdField_a_of_type_Int, this.jdField_a_of_type_Avza.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Avzf != null) {
          this.jdField_a_of_type_Avzf.a();
        }
        localRenderBuffer.unbind();
        long l = (localavxs.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Avyj.b(3553, j, localavxs.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localavxs.b();
        i += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Awae != null) {
      this.jdField_a_of_type_Awae.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<avxs> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((avxs)paramList.get(0)).a() + " - " + ((avxs)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_Avyj.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Avza.jdField_a_of_type_Int, this.jdField_a_of_type_Avza.jdField_b_of_type_Int, 33984);
      if ((avzw.a(this.jdField_a_of_type_Avza.f)) || (this.jdField_a_of_type_Avza.c != null))
      {
        this.jdField_a_of_type_Awae = new awae();
        if (avzw.a(this.jdField_a_of_type_Avza.f)) {
          this.jdField_a_of_type_Awae.a(avzw.a(this.jdField_a_of_type_Avza.f));
        }
        if (this.jdField_a_of_type_Avza.c != null)
        {
          localObject = avzw.a(106);
          ((awab)localObject).a(this.jdField_a_of_type_Avza.c);
          this.jdField_a_of_type_Awae.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Awae.onOutputSizeChanged(this.jdField_a_of_type_Avza.jdField_a_of_type_Int, this.jdField_a_of_type_Avza.jdField_b_of_type_Int);
        this.jdField_a_of_type_Awae.init();
      }
      Object localObject = this.jdField_a_of_type_Avza.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Avza.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = avyi.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = avzw.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Avza.jdField_a_of_type_Int, this.jdField_a_of_type_Avza.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new avxv(this.jdField_a_of_type_Avxm);
        ((avxv)localObject).b = false;
        ((avxv)localObject).a = EGL14.eglGetCurrentContext();
        ((avxv)localObject).c = 2;
        this.jdField_a_of_type_Avyx.a((avxv)localObject, this, this);
        if (this.jdField_a_of_type_Avzm != null)
        {
          this.jdField_a_of_type_Avzm.a();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Avza.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
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
  
  public void a(avxm paramavxm, avza paramavza, avzm paramavzm, avzf paramavzf)
  {
    this.jdField_a_of_type_Avxm = paramavxm;
    this.jdField_a_of_type_Avza = paramavza;
    this.jdField_a_of_type_Avzm = paramavzm;
    this.jdField_a_of_type_Avzf = paramavzf;
    this.jdField_a_of_type_Avyj.a(paramavza, this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Avzm != null) {
      this.jdField_a_of_type_Avzm.a(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      avyi.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    c();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    avxs.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Avyx.a();
    if (this.jdField_a_of_type_Avzm != null) {
      this.jdField_a_of_type_Avzm.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Avzm != null) {
      this.jdField_a_of_type_Avzm.b();
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
    this.jdField_a_of_type_Avyj.b();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Avyj.b();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */