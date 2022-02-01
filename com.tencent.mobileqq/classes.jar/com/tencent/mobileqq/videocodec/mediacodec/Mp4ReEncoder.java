package com.tencent.mobileqq.videocodec.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.filter.FilterFactory;
import com.tencent.mobileqq.filter.GPUImagePixelationFilter;
import com.tencent.mobileqq.filter.GpuImageFilterGroup;
import com.tencent.mobileqq.filter.QQVideoGaussianBlurFilter;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.shortvideo.filter.QQTransferFilter;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class Mp4ReEncoder
  implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener, HWEncodeListener
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private GpuImageFilterGroup jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup;
  private QQVideoGaussianBlurFilter jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter;
  private GPUAlphaBlendFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter;
  protected DecodeConfig a;
  protected HWVideoDecoder a;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private TransferData jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData;
  private Mp4ReEncoder.EncodeFilterRender jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder$EncodeFilterRender;
  protected EncodeConfig a;
  private HWEncodeListener jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
  protected HWVideoRecorder a;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList<DynamicStickerData> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  private long jdField_b_of_type_Long = -1L;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList<TrackerStickerParam> jdField_b_of_type_JavaUtilArrayList = null;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  private int f;
  
  public Mp4ReEncoder()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = new HWVideoDecoder();
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null)
    {
      QLog.e("Mp4ReEncoder", 1, "rotateBitmap, arg source is null");
      return null;
    }
    android.graphics.Matrix localMatrix = new android.graphics.Matrix();
    localMatrix.postRotate(paramFloat);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.destroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter;
    if (localObject != null) {
      ((QQVideoGaussianBlurFilter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup;
    if (localObject != null) {
      ((GpuImageFilterGroup)localObject).destroy();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter;
    if (localObject != null) {
      ((GPUAlphaBlendFilter)localObject).destroy();
    }
  }
  
  public void a()
  {
    SLog.d("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
  }
  
  public void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, Mp4ReEncoder.EncodeFilterRender paramEncodeFilterRender)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig = paramEncodeConfig;
    if ((paramDecodeConfig.speedType == 1) || (paramDecodeConfig.speedType == 3)) {
      this.jdField_e_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener = paramHWEncodeListener;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder$EncodeFilterRender = paramEncodeFilterRender;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a(paramEncodeConfig, this);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData = new TransferData();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.fromJSONObject(paramString);
    }
  }
  
  public void a(ArrayList<DynamicStickerData> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a();
  }
  
  public void onDecodeCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.b();
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Int = (paramInt + 10000);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.b();
    HWEncodeListener localHWEncodeListener = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.onEncodeError(this.jdField_a_of_type_Int, paramThrowable);
    }
  }
  
  public void onDecodeFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.b();
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onDecodeFrame wait timestamp = ");
      ((StringBuilder)???).append(paramLong1);
      ((StringBuilder)???).append(" orgSampleTime: ");
      ((StringBuilder)???).append(paramLong2);
      QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_b_of_type_Long = paramLong2;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaLangObject.notifyAll();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onDecodeFrame start timestamp = ");
          ((StringBuilder)???).append(paramLong1);
          QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
        }
        try
        {
          this.jdField_a_of_type_JavaLangObject.wait(2000L);
          if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (!this.jdField_c_of_type_Boolean))
          {
            this.jdField_c_of_type_Long = -1L;
            this.jdField_a_of_type_Long = 0L;
            this.jdField_b_of_type_Long = 0L;
            onEncodeError(3, new RuntimeException("frame wait timed out"));
          }
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onDecodeFrame end timestamp = ");
            ((StringBuilder)???).append(paramLong1);
            QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
          }
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onDecodeFrame InterruptedException");
          }
          this.jdField_a_of_type_Boolean = false;
          throw localInterruptedException;
        }
      }
    }
  }
  
  public void onDecodeRepeat() {}
  
  public void onDecodeSeekTo(long paramLong) {}
  
  public void onDecodeStart()
  {
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
    HWEncodeListener localHWEncodeListener = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.onEncodeError(paramInt, paramThrowable);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    HWEncodeListener localHWEncodeListener = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.onEncodeFinish(paramString);
    }
    int i = this.jdField_d_of_type_Int;
    if (i != -1)
    {
      GlUtil.deleteTexture(i);
      this.jdField_d_of_type_Int = -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
    i = this.jdField_c_of_type_Int;
    if (i != -1)
    {
      GlUtil.deleteTexture(i);
      this.jdField_c_of_type_Int = -1;
    }
    GlUtil.deleteTexture(this.jdField_c_of_type_Int);
    b();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
  }
  
  public void onEncodeFrame()
  {
    HWEncodeListener localHWEncodeListener = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener;
    if (localHWEncodeListener != null) {
      localHWEncodeListener.onEncodeFrame();
    }
  }
  
  public void onEncodeStart()
  {
    for (;;)
    {
      try
      {
        this.jdField_c_of_type_Int = GlUtil.createTexture(36197);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, 33984);
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, 33984);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter = ((GPUOESBaseFilter)FilterFactory.a(102));
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.onOutputSizeChanged(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.init();
        if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.isLocal) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_c_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.isLandscape) {
            break label975;
          }
          i = -90;
          this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter = new QQVideoGaussianBlurFilter(i);
          this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.width, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.height, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        }
        if ((FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.f)) || (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_c_of_type_JavaLangString != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup = new GpuImageFilterGroup();
          if (FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.f)) {
            this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup.a(FilterFactory.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.f));
          }
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_c_of_type_JavaLangString;
          if (localObject1 != null) {
            try
            {
              localObject1 = FilterFactory.a(106);
              ((GPUImagePixelationFilter)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_c_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup.a((GPUBaseFilter)localObject1);
            }
            catch (Exception localException1)
            {
              QLog.e("Mp4ReEncoder", 1, "mosaic filter create error, ", localException1);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup.onOutputSizeChanged(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup.init();
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_JavaLangString;
        if (localObject2 != null) {
          try
          {
            localObject3 = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.isLocal)
            {
              localObject2 = localObject3;
              if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_d_of_type_Boolean)
              {
                localObject2 = localObject3;
                if (((Bitmap)localObject3).getWidth() > ((Bitmap)localObject3).getHeight()) {
                  localObject2 = a((Bitmap)localObject3, 90.0F);
                }
              }
            }
            else
            {
              localObject2 = a((Bitmap)localObject3, 360 - this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.adjustRotation);
            }
            this.jdField_d_of_type_Int = GlUtil.createTexture(3553, (Bitmap)localObject2);
            this.jdField_e_of_type_Int = ((Bitmap)localObject2).getWidth();
            this.f = ((Bitmap)localObject2).getHeight();
            ((Bitmap)localObject2).recycle();
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter = new GPUAlphaBlendFilter();
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.onOutputSizeChanged(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.init();
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Decode bitmap failed when onEncodeStart(). encodeConfig.watermarkPath= ");
              ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_JavaLangString);
              QLog.e("Mp4ReEncoder", 2, ((StringBuilder)localObject3).toString(), localOutOfMemoryError);
            }
            onEncodeError(1, localOutOfMemoryError);
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getChainBuilder();
        ((QQFilterRenderManager.ChainBuilder)localObject3).setUseSort(true);
        Object localObject4 = this.jdField_a_of_type_JavaUtilArrayList;
        QQTransferFilter localQQTransferFilter = null;
        if ((localObject4 != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          ((QQFilterRenderManager.ChainBuilder)localObject3).addFilter(120, null);
        }
        if (this.jdField_b_of_type_JavaUtilArrayList != null) {
          ((QQFilterRenderManager.ChainBuilder)localObject3).addFilter(110, null);
        }
        ((QQFilterRenderManager.ChainBuilder)localObject3).commit();
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setDynamicStickerParam(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setTrackerStickerParam(this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder$EncodeFilterRender != null) {
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder$EncodeFilterRender.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setVideoStartTime(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.startTimeMillSecond);
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData != null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasQQFilter(160))
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.pushChainBasedStackTopChain(160, null);
            localQQTransferFilter = (QQTransferFilter)this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilterByType(160);
          }
          localObject3 = localQQTransferFilter;
          if (localQQTransferFilter == null)
          {
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getQQFilters(160);
            localObject3 = localQQTransferFilter;
            if (localObject4 != null)
            {
              localObject3 = localQQTransferFilter;
              if (((List)localObject4).size() > 0)
              {
                localObject3 = localQQTransferFilter;
                if ((((List)localObject4).get(0) instanceof QQTransferFilter)) {
                  localObject3 = (QQTransferFilter)((List)localObject4).get(0);
                }
              }
            }
          }
          if (localObject3 != null)
          {
            ((QQTransferFilter)localObject3).setTransferData(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData);
            ((QQTransferFilter)localObject3).setSpeedRate(HWVideoDecoder.getSpeedRate(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.speedType));
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.startDecode(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig, this.jdField_c_of_type_Int, this, this);
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWEncodeListener.onEncodeStart();
          return;
        }
      }
      catch (Exception localException2)
      {
        onEncodeError(4, localException2);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onEncodeStart ex=");
        ((StringBuilder)localObject3).append(localException2);
        QLog.e("Mp4ReEncoder", 1, ((StringBuilder)localObject3).toString());
      }
      return;
      label975:
      int i = 0;
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    for (;;)
    {
      if ((this.jdField_c_of_type_Long < this.jdField_a_of_type_Long) || (this.jdField_d_of_type_Boolean)) {
        break label146;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = ");
        ((StringBuilder)???).append(this.jdField_c_of_type_Long);
        ((StringBuilder)???).append(", mLastDecodeTimestamp ");
        ((StringBuilder)???).append(this.jdField_a_of_type_Long);
        ((StringBuilder)???).append(", mLastDecodeSampleTimestamp :");
        ((StringBuilder)???).append(this.jdField_b_of_type_Long);
        QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
      }
      try
      {
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          this.jdField_b_of_type_JavaLangObject.wait(5L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    throw paramSurfaceTexture;
    label146:
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (!this.jdField_d_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onFrameAvailable start");
        }
        if (this.jdField_a_of_type_Boolean) {
          onEncodeError(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
        }
        try
        {
          paramSurfaceTexture.updateTexImage();
          this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("onFrameAvailable timestap = ");
            ((StringBuilder)???).append(this.jdField_c_of_type_Long);
            QLog.d("Mp4ReEncoder", 2, ((StringBuilder)???).toString());
          }
          float[] arrayOfFloat = new float[16];
          paramSurfaceTexture.getTransformMatrix(arrayOfFloat);
          ??? = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.recoverInitialTexId();
          paramSurfaceTexture = new float[16];
          android.opengl.Matrix.setIdentityM(paramSurfaceTexture, 0);
          android.opengl.Matrix.rotateM(paramSurfaceTexture, 0, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.h, 0.0F, 0.0F, 1.0F);
          android.opengl.Matrix.scaleM(paramSurfaceTexture, 0, 1.0F, -1.0F, 1.0F);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.jdField_c_of_type_Int, arrayOfFloat, paramSurfaceTexture);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          int i;
          if (this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter != null)
          {
            ((RenderBuffer)???).bind();
            i = this.jdField_a_of_type_ComTencentMobileqqFilterQQVideoGaussianBlurFilter.a(((RenderBuffer)???).getTexId());
            if (i != -1) {
              ((RenderBuffer)???).setTexId(i);
            }
            ((RenderBuffer)???).unbind();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder$EncodeFilterRender != null)
          {
            ((RenderBuffer)???).bind();
            i = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecMp4ReEncoder$EncodeFilterRender.a(((RenderBuffer)???).getTexId(), this.jdField_c_of_type_Long);
            if (i != -1) {
              ((RenderBuffer)???).setTexId(i);
            }
            ((RenderBuffer)???).unbind();
          }
          paramSurfaceTexture = (SurfaceTexture)???;
          if (this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup != null)
          {
            ((RenderBuffer)???).bind();
            this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup.drawTexture(((RenderBuffer)???).getTexId(), null, null);
            paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqFilterGpuImageFilterGroup.a();
            paramSurfaceTexture.unbind();
          }
          paramSurfaceTexture.bind();
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter != null)
          {
            ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, this.jdField_e_of_type_Int, this.f);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.drawTexture(this.jdField_d_of_type_Int, null, (float[])???);
          }
          paramSurfaceTexture.unbind();
          long l2 = this.jdField_c_of_type_Long;
          long l1 = l2;
          if (!this.jdField_b_of_type_Boolean)
          {
            this.jdField_b_of_type_Boolean = true;
            l1 = l2;
            if (this.jdField_c_of_type_Long > 0L) {
              l1 = 0L;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().SetTimeStamp(l1, this.jdField_b_of_type_Long);
          paramSurfaceTexture.setTexId(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(paramSurfaceTexture.getTexId()));
          if ((!this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Long == -1L) || (this.jdField_c_of_type_Long - this.jdField_d_of_type_Long >= 16666666L))
          {
            ??? = new float[16];
            android.opengl.Matrix.setIdentityM((float[])???, 0);
            android.opengl.Matrix.scaleM((float[])???, 0, 1.0F, -1.0F, 1.0F);
            this.jdField_d_of_type_Long = this.jdField_c_of_type_Long;
            this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.getTexId(), null, (float[])???, this.jdField_c_of_type_Long);
            i = 1;
            while (i <= this.jdField_b_of_type_Int)
            {
              this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.getTexId(), null, (float[])???, this.jdField_c_of_type_Long + i * 5 * 1000);
              i += 1;
            }
          }
          paramSurfaceTexture.recoverInitialTexId();
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
          }
          return;
        }
        catch (Exception paramSurfaceTexture)
        {
          paramSurfaceTexture.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          paramSurfaceTexture = new StringBuilder();
          paramSurfaceTexture.append("onFrameAvailable error=");
          paramSurfaceTexture.append(this.jdField_a_of_type_Int);
          paramSurfaceTexture.append(" ; canceled=");
          paramSurfaceTexture.append(this.jdField_c_of_type_Boolean);
          QLog.w("Mp4ReEncoder", 2, paramSurfaceTexture.toString());
          return;
        }
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append("onFrameAvailable error=");
      paramSurfaceTexture.append(this.jdField_a_of_type_Int);
      paramSurfaceTexture.append("; canceled=");
      paramSurfaceTexture.append(this.jdField_c_of_type_Boolean);
      paramSurfaceTexture.append("; stopped=");
      paramSurfaceTexture.append(this.jdField_d_of_type_Boolean);
      QLog.w("Mp4ReEncoder", 2, paramSurfaceTexture.toString());
      return;
    }
    for (;;)
    {
      throw paramSurfaceTexture;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder
 * JD-Core Version:    0.7.0.1
 */