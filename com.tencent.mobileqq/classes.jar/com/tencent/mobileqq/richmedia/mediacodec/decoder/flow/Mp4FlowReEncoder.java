package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import baej;
import baem;
import baep;
import baes;
import baet;
import baff;
import bafg;
import bafh;
import bafj;
import bafu;
import bafx;
import bagc;
import bagj;
import bagt;
import bagy;
import bahb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements baem, baet, bafh, bagj
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private baej jdField_a_of_type_Baej;
  private bafg jdField_a_of_type_Bafg = new bafg();
  private bafu jdField_a_of_type_Bafu = new bafu();
  private bafx jdField_a_of_type_Bafx;
  private bagc jdField_a_of_type_Bagc;
  private bagj jdField_a_of_type_Bagj;
  private bahb jdField_a_of_type_Bahb;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<baep> jdField_a_of_type_JavaUtilComparator = new bafj(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bahb != null) {
      this.jdField_a_of_type_Bahb.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  private void a(List<baep> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((baep)paramList.get(0)).a() + " - " + ((baep)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((baep)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        baep localbaep = (baep)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localbaep.a();
        int j = k;
        if (this.jdField_a_of_type_Bahb != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_Bahb.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_Bahb.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_Bafx.jdField_a_of_type_Int, this.jdField_a_of_type_Bafx.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_Bagc != null) {
          this.jdField_a_of_type_Bagc.a();
        }
        localRenderBuffer.unbind();
        long l = (localbaep.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_Bafg.b(3553, j, localbaep.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localbaep.b();
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<baep> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((baep)paramList.get(0)).a() + " - " + ((baep)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_Bafg.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    onEncodeError(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong) {}
  
  public void a(baej parambaej, bafx parambafx, bagj parambagj, bagc parambagc)
  {
    this.jdField_a_of_type_Baej = parambaej;
    this.jdField_a_of_type_Bafx = parambafx;
    this.jdField_a_of_type_Bagj = parambagj;
    this.jdField_a_of_type_Bagc = parambagc;
    this.jdField_a_of_type_Bafg.a(parambafx, this);
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
    this.jdField_a_of_type_Bafg.b();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_Bafg.b();
  }
  
  public void l() {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Bafu.a();
    if (this.jdField_a_of_type_Bagj != null) {
      this.jdField_a_of_type_Bagj.onEncodeError(paramInt, paramThrowable);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (this.jdField_a_of_type_Bagj != null) {
      this.jdField_a_of_type_Bagj.onEncodeFinish(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      baff.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    a();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    baep.a();
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_Bagj != null) {
      this.jdField_a_of_type_Bagj.onEncodeFrame();
    }
  }
  
  public void onEncodeStart()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Bafx.jdField_a_of_type_Int, this.jdField_a_of_type_Bafx.jdField_b_of_type_Int, 33984);
      if ((bagt.a(this.jdField_a_of_type_Bafx.f)) || (this.jdField_a_of_type_Bafx.c != null))
      {
        this.jdField_a_of_type_Bahb = new bahb();
        if (bagt.a(this.jdField_a_of_type_Bafx.f)) {
          this.jdField_a_of_type_Bahb.a(bagt.a(this.jdField_a_of_type_Bafx.f));
        }
        if (this.jdField_a_of_type_Bafx.c != null)
        {
          localObject = bagt.a(106);
          ((bagy)localObject).a(this.jdField_a_of_type_Bafx.c);
          this.jdField_a_of_type_Bahb.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_Bahb.onOutputSizeChanged(this.jdField_a_of_type_Bafx.jdField_a_of_type_Int, this.jdField_a_of_type_Bafx.jdField_b_of_type_Int);
        this.jdField_a_of_type_Bahb.init();
      }
      Object localObject = this.jdField_a_of_type_Bafx.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_Bafx.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = baff.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = bagt.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_Bafx.jdField_a_of_type_Int, this.jdField_a_of_type_Bafx.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new baes(this.jdField_a_of_type_Baej);
        ((baes)localObject).b = false;
        ((baes)localObject).a = EGL14.eglGetCurrentContext();
        ((baes)localObject).c = 2;
        this.jdField_a_of_type_Bafu.a((baes)localObject, this, this);
        if (this.jdField_a_of_type_Bagj != null)
        {
          this.jdField_a_of_type_Bagj.onEncodeStart();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_Bafx.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
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