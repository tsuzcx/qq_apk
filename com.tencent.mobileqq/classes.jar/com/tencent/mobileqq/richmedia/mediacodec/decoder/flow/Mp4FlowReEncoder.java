package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import bbky;
import bblb;
import bble;
import bblh;
import bbli;
import bblu;
import bblv;
import bblw;
import bbly;
import bbmj;
import bbmm;
import bbmr;
import bbmy;
import bbni;
import bbnn;
import bbnq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements bblb, bbli, bblw, bbmy
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private bbky jdField_a_of_type_Bbky;
  private bblv jdField_a_of_type_Bblv = new bblv();
  private bbmj jdField_a_of_type_Bbmj = new bbmj();
  private bbmm jdField_a_of_type_Bbmm;
  private bbmr jdField_a_of_type_Bbmr;
  private bbmy jdField_a_of_type_Bbmy;
  private bbnq jdField_a_of_type_Bbnq;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<bble> jdField_a_of_type_JavaUtilComparator = new bbly(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bbnq != null) {
      this.jdField_a_of_type_Bbnq.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  private void a(List<bble> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((bble)paramList.get(0)).a() + " - " + ((bble)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((bble)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        bble localbble = (bble)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localbble.a();
        int j = k;
        if (this.jdField_a_of_type_Bbnq != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Bbnq.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Bbnq.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Bbmm.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmm.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Bbmr != null) {
          this.jdField_a_of_type_Bbmr.a();
        }
        localRenderBuffer.unbind();
        long l = (localbble.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Bblv.b(3553, j, localbble.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localbble.b();
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<bble> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((bble)paramList.get(0)).a() + " - " + ((bble)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_Bblv.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    onEncodeError(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong) {}
  
  public void a(bbky parambbky, bbmm parambbmm, bbmy parambbmy, bbmr parambbmr)
  {
    this.jdField_a_of_type_Bbky = parambbky;
    this.jdField_a_of_type_Bbmm = parambbmm;
    this.jdField_a_of_type_Bbmy = parambbmy;
    this.jdField_a_of_type_Bbmr = parambbmr;
    this.jdField_a_of_type_Bblv.a(parambbmm, this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(long paramLong) {}
  
  public void d() {}
  
  public void e() {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeStart");
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_a_of_type_Bblv.b();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Bblv.b();
  }
  
  public void l() {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Bbmj.a();
    if (this.jdField_a_of_type_Bbmy != null) {
      this.jdField_a_of_type_Bbmy.onEncodeError(paramInt, paramThrowable);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (this.jdField_a_of_type_Bbmy != null) {
      this.jdField_a_of_type_Bbmy.onEncodeFinish(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      bblu.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    a();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    bble.a();
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_Bbmy != null) {
      this.jdField_a_of_type_Bbmy.onEncodeFrame();
    }
  }
  
  public void onEncodeStart()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Bbmm.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmm.jdField_b_of_type_Int, 33984);
      if ((bbni.a(this.jdField_a_of_type_Bbmm.f)) || (this.jdField_a_of_type_Bbmm.c != null))
      {
        this.jdField_a_of_type_Bbnq = new bbnq();
        if (bbni.a(this.jdField_a_of_type_Bbmm.f)) {
          this.jdField_a_of_type_Bbnq.a(bbni.a(this.jdField_a_of_type_Bbmm.f));
        }
        if (this.jdField_a_of_type_Bbmm.c != null)
        {
          localObject = bbni.a(106);
          ((bbnn)localObject).a(this.jdField_a_of_type_Bbmm.c);
          this.jdField_a_of_type_Bbnq.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Bbnq.onOutputSizeChanged(this.jdField_a_of_type_Bbmm.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmm.jdField_b_of_type_Int);
        this.jdField_a_of_type_Bbnq.init();
      }
      Object localObject = this.jdField_a_of_type_Bbmm.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Bbmm.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = bblu.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = bbni.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Bbmm.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmm.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new bblh(this.jdField_a_of_type_Bbky);
        ((bblh)localObject).b = false;
        ((bblh)localObject).a = EGL14.eglGetCurrentContext();
        ((bblh)localObject).c = 2;
        this.jdField_a_of_type_Bbmj.a((bblh)localObject, this, this);
        if (this.jdField_a_of_type_Bbmy != null)
        {
          this.jdField_a_of_type_Bbmy.onEncodeStart();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Bbmm.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
        }
        onEncodeError(1, localOutOfMemoryError);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      onEncodeError(4, localException);
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onEncodeStart ex=" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */