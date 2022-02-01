package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

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
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImageFilterGroup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
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
  private GpuImageFilterGroup jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup;
  private GPUBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Comparator<DecodedFrame> jdField_a_of_type_JavaUtilComparator = new Mp4FlowReEncoder.1(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.destroy();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.destroy();
    }
  }
  
  private void a(List<DecodedFrame> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : frameList is null or size is 0!");
    }
    for (;;)
    {
      return;
      QLog.d("FlowEdit_Mp4FlowReEncoder", 1, "handleFrameListAvailable : size " + paramList.size() + ", range [" + ((DecodedFrame)paramList.get(0)).a() + " - " + ((DecodedFrame)paramList.get(paramList.size() - 1)).a() + "]");
      Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
      if (this.jdField_a_of_type_Long == 9223372036854775807L)
      {
        this.jdField_a_of_type_Long = ((DecodedFrame)paramList.get(0)).a();
        QLog.d("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. firstFrameTimeStamp = " + this.jdField_a_of_type_Long);
      }
      int i = 0;
      while (i < paramList.size())
      {
        DecodedFrame localDecodedFrame = (DecodedFrame)paramList.get(i);
        RenderBuffer localRenderBuffer = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        int k = localDecodedFrame.a();
        int j = k;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup != null)
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.drawTexture(k, null, null);
          localRenderBuffer = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a();
          localRenderBuffer.bind();
          j = localRenderBuffer.getTexId();
        }
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter != null)
        {
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, this.jdField_b_of_type_Int, this.c);
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(770, 771);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.drawTexture(this.jdField_a_of_type_Int, null, arrayOfFloat);
          GLES20.glDisable(3042);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender.a();
        }
        localRenderBuffer.unbind();
        long l = (localDecodedFrame.a() - this.jdField_a_of_type_Long) * 1000L;
        QLog.i("FlowEdit_Mp4FlowReEncoder", 2, "handleFrameAvailable. textureId = " + j + ", timeStampOfFrameNano = " + l);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowHWVideoFlowRecorder.b(3553, j, localDecodedFrame.a, null, l);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
        localDecodedFrame.b();
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(List<DecodedFrame> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : frameList is null or size is 0!");
      return 0;
    }
    QLog.i("FlowEdit_Mp4FlowReEncoder", 1, "onFrameReached : size " + paramList.size() + ", range [" + ((DecodedFrame)paramList.get(0)).a() + " - " + ((DecodedFrame)paramList.get(paramList.size() - 1)).a() + "]");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(paramList.size());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowHWVideoFlowRecorder.a(new Mp4FlowReEncoder.HandleFrameListRunable(this, paramList));
    return paramList.size();
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    onEncodeError(paramInt + 10000, paramThrowable);
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
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeError(paramInt, paramThrowable);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeFinish(paramString);
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      GlUtil.b(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
    a();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    DecodedFrame.a();
  }
  
  public void onEncodeFrame()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeFrame();
    }
  }
  
  public void onEncodeStart()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, 33984);
      if ((FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.f)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.c != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup = new GpuImageFilterGroup();
        if (FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.f)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a(FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.f));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.c != null)
        {
          localObject = FilterFactory.a(106);
          ((GPUImagePixelationFilter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.c);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a((GPUBaseFilter)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.onOutputSizeChanged(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.init();
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
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter = FilterFactory.a(101);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUBaseFilter.init();
        localObject = new FlowDecodeConfig(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig);
        ((FlowDecodeConfig)localObject).b = false;
        ((FlowDecodeConfig)localObject).a = EGL14.eglGetCurrentContext();
        ((FlowDecodeConfig)localObject).c = 2;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowVideoFlowDecoder.a((FlowDecodeConfig)localObject, this, this);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.onEncodeStart();
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FlowEdit_Mp4FlowReEncoder", 2, "Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= " + this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_JavaLangString, localOutOfMemoryError);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder
 * JD-Core Version:    0.7.0.1
 */