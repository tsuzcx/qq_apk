package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import ahab;
import ahah;
import ahai;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder.EncodeFilterRender;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImageFilterGroup;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class Mp4FlowReEncoder
  implements HWDecodeListener, FlowDecodeListener, IMp4ReEncoder, HWEncodeListener
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig;
  private HWVideoFlowRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowHWVideoFlowRecorder = new HWVideoFlowRecorder();
  private VideoFlowDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder = new VideoFlowDecoder();
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private Mp4ReEncoder.EncodeFilterRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender;
  private HWEncodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener;
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private GpuImageFilterGroup jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private Comparator jdField_a_of_type_JavaUtilComparator = new ahah(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((ahab)paramList.get(0)).a() + " - " + ((ahab)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((ahab)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        ahab localahab = (ahab)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
        int k = localahab.a();
        int j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a();
          localRenderBuffer.b();
          j = localRenderBuffer.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender.a();
        }
        localRenderBuffer.c();
        long l = (localahab.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowHWVideoFlowRecorder.b(3553, j, localahab.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localahab.b();
        i += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.c();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((ahab)paramList.get(0)).a() + " - " + ((ahab)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowHWVideoFlowRecorder.a(new ahai(this, paramList));
    return paramList.size();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, 33984);
      if ((FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.f)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.c != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup = new GpuImageFilterGroup();
        if (FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.f)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a(FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.f));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.c != null)
        {
          localObject = FilterFactory.a(106);
          ((GPUImagePixelationFilter)localObject).b(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.c);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a();
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_JavaLangString;
      if (localObject != null) {}
      try
      {
        localObject = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = GlUtil.a(3553, (Bitmap)localObject);
        this.jdField_b_of_type_Int = ((Bitmap)localObject).getWidth();
        this.c = ((Bitmap)localObject).getHeight();
        ((Bitmap)localObject).recycle();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = FilterFactory.a(101);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
        localObject = new FlowDecodeConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig);
        ((FlowDecodeConfig)localObject).b = false;
        ((FlowDecodeConfig)localObject).a = EGL14.eglGetCurrentContext();
        ((FlowDecodeConfig)localObject).c = 2;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a((FlowDecodeConfig)localObject, this, this);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.a();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
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
  
  public void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, Mp4ReEncoder.EncodeFilterRender paramEncodeFilterRender)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = paramEncodeConfig;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener = paramHWEncodeListener;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender = paramEncodeFilterRender;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowHWVideoFlowRecorder.a(paramEncodeConfig, this);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.a(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      GlUtil.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    ahab.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.a_(paramInt, paramThrowable);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.b();
    }
  }
  
  public void b(long paramLong) {}
  
  public void d() {}
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeStart");
    }
  }
  
  public void f() {}
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowHWVideoFlowRecorder.c();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowHWVideoFlowRecorder.c();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */