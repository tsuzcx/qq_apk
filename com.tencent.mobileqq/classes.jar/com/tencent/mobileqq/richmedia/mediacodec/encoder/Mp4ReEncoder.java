package com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.richmedia.subtitles.BaseAnimDrawer;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.IMp4ReEncoder;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImageFilterGroup;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;

@TargetApi(11)
public class Mp4ReEncoder
  implements SurfaceTexture.OnFrameAvailableListener, HWDecodeListener, IMp4ReEncoder, HWEncodeListener
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private BaseAnimDrawer jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer;
  private DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig;
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder = new HWVideoDecoder();
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private Mp4ReEncoder.EncodeFilterRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender;
  private HWEncodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter;
  private GpuImageFilterGroup jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private GPUBaseFilter jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private GPUBaseFilter jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.d();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.d();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null) {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer.c();
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.d();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 96
    //   3: invokestatic 101	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:a	(I)I
    //   6: putfield 103	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_Int	I
    //   9: aload_0
    //   10: new 105	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer
    //   13: dup
    //   14: aload_0
    //   15: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   18: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   21: aload_0
    //   22: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   25: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   28: ldc 113
    //   30: invokespecial 116	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:<init>	(III)V
    //   33: putfield 118	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer;
    //   36: aload_0
    //   37: bipush 102
    //   39: invokestatic 123	com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   42: checkcast 69	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter
    //   45: putfield 67	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   48: aload_0
    //   49: getfield 67	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   52: aload_0
    //   53: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   56: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   59: aload_0
    //   60: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   63: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   66: invokevirtual 126	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter:a	(II)V
    //   69: aload_0
    //   70: getfield 67	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   73: invokevirtual 128	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter:a	()V
    //   76: aload_0
    //   77: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   80: getfield 130	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   83: invokestatic 133	com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Z
    //   86: ifne +13 -> 99
    //   89: aload_0
    //   90: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   93: getfield 136	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   96: ifnull +110 -> 206
    //   99: aload_0
    //   100: new 75	com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup
    //   103: dup
    //   104: invokespecial 137	com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:<init>	()V
    //   107: putfield 73	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   110: aload_0
    //   111: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   114: getfield 130	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   117: invokestatic 133	com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Z
    //   120: ifeq +20 -> 140
    //   123: aload_0
    //   124: getfield 73	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   127: aload_0
    //   128: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   131: getfield 130	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   134: invokestatic 123	com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   137: invokevirtual 140	com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;)V
    //   140: aload_0
    //   141: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   144: getfield 136	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   147: ifnull +31 -> 178
    //   150: bipush 106
    //   152: invokestatic 123	com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   155: astore_1
    //   156: aload_1
    //   157: checkcast 142	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUImagePixelationFilter
    //   160: aload_0
    //   161: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   164: getfield 136	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   167: invokevirtual 145	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUImagePixelationFilter:b	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: getfield 73	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   174: aload_1
    //   175: invokevirtual 140	com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;)V
    //   178: aload_0
    //   179: getfield 73	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   182: aload_0
    //   183: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   186: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   189: aload_0
    //   190: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   193: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   196: invokevirtual 146	com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(II)V
    //   199: aload_0
    //   200: getfield 73	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   203: invokevirtual 147	com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	()V
    //   206: aload_0
    //   207: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   210: getfield 149	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   213: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +312 -> 528
    //   219: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +11 -> 233
    //   225: ldc 163
    //   227: iconst_2
    //   228: ldc 165
    //   230: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   238: getfield 149	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   245: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   248: i2f
    //   249: aload_0
    //   250: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   253: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   256: i2f
    //   257: ldc 169
    //   259: aload_0
    //   260: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   263: getfield 170	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_d_of_type_Int	I
    //   266: i2f
    //   267: fdiv
    //   268: f2i
    //   269: invokestatic 175	com/tencent/mobileqq/activity/richmedia/subtitles/AnimDrawerFactory:a	(Ljava/lang/String;FFI)Lcom/tencent/mobileqq/activity/richmedia/subtitles/BaseAnimDrawer;
    //   272: putfield 85	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer	Lcom/tencent/mobileqq/activity/richmedia/subtitles/BaseAnimDrawer;
    //   275: aload_0
    //   276: getfield 85	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer	Lcom/tencent/mobileqq/activity/richmedia/subtitles/BaseAnimDrawer;
    //   279: ifnull +49 -> 328
    //   282: aload_0
    //   283: getfield 85	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer	Lcom/tencent/mobileqq/activity/richmedia/subtitles/BaseAnimDrawer;
    //   286: iconst_1
    //   287: invokevirtual 178	com/tencent/mobileqq/activity/richmedia/subtitles/BaseAnimDrawer:a	(Z)Z
    //   290: pop
    //   291: aload_0
    //   292: bipush 101
    //   294: invokestatic 123	com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   297: putfield 83	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   300: aload_0
    //   301: getfield 83	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   304: aload_0
    //   305: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   308: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   311: aload_0
    //   312: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   315: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   318: invokevirtual 179	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	(II)V
    //   321: aload_0
    //   322: getfield 83	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   325: invokevirtual 180	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	()V
    //   328: aload_0
    //   329: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   332: getfield 182	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   335: astore_1
    //   336: aload_1
    //   337: ifnull +120 -> 457
    //   340: aload_0
    //   341: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   344: getfield 182	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   347: invokestatic 188	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   350: astore_2
    //   351: aload_0
    //   352: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   355: getfield 191	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:g	I
    //   358: ifeq +220 -> 578
    //   361: aload_2
    //   362: sipush 360
    //   365: aload_0
    //   366: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   369: getfield 191	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:g	I
    //   372: isub
    //   373: i2f
    //   374: invokestatic 196	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   377: astore_1
    //   378: aload_0
    //   379: sipush 3553
    //   382: aload_1
    //   383: invokestatic 199	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:a	(ILandroid/graphics/Bitmap;)I
    //   386: putfield 54	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_d_of_type_Int	I
    //   389: aload_0
    //   390: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   393: getfield 202	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:i	I
    //   396: ifne +214 -> 610
    //   399: aload_0
    //   400: aload_1
    //   401: invokevirtual 208	android/graphics/Bitmap:getWidth	()I
    //   404: putfield 210	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:e	I
    //   407: aload_0
    //   408: aload_1
    //   409: invokevirtual 213	android/graphics/Bitmap:getHeight	()I
    //   412: putfield 214	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:f	I
    //   415: aload_1
    //   416: invokevirtual 217	android/graphics/Bitmap:recycle	()V
    //   419: aload_0
    //   420: sipush 1000
    //   423: invokestatic 123	com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   426: putfield 78	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   429: aload_0
    //   430: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   433: aload_0
    //   434: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   437: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   440: aload_0
    //   441: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   444: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   447: invokevirtual 179	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	(II)V
    //   450: aload_0
    //   451: getfield 78	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   454: invokevirtual 180	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	()V
    //   457: aload_0
    //   458: bipush 101
    //   460: invokestatic 123	com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   463: putfield 91	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   466: aload_0
    //   467: getfield 91	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   470: aload_0
    //   471: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   474: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   477: aload_0
    //   478: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   481: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   484: invokevirtual 179	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	(II)V
    //   487: aload_0
    //   488: getfield 91	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   491: invokevirtual 180	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	()V
    //   494: aload_0
    //   495: getfield 64	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder;
    //   498: aload_0
    //   499: getfield 219	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;
    //   502: aload_0
    //   503: getfield 103	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_Int	I
    //   506: aload_0
    //   507: aload_0
    //   508: invokevirtual 222	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;)V
    //   511: aload_0
    //   512: getfield 224	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWEncodeListener;
    //   515: ifnull +159 -> 674
    //   518: aload_0
    //   519: getfield 224	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWEncodeListener;
    //   522: invokeinterface 225 1 0
    //   527: return
    //   528: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq -203 -> 328
    //   534: ldc 163
    //   536: iconst_2
    //   537: ldc 227
    //   539: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   542: goto -214 -> 328
    //   545: astore_1
    //   546: aload_0
    //   547: iconst_4
    //   548: aload_1
    //   549: invokevirtual 233	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:a_	(ILjava/lang/Throwable;)V
    //   552: ldc 163
    //   554: iconst_1
    //   555: new 235	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   562: ldc 238
    //   564: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_1
    //   568: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: return
    //   578: aload_2
    //   579: astore_1
    //   580: aload_0
    //   581: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   584: getfield 202	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:i	I
    //   587: ifeq -209 -> 378
    //   590: aload_2
    //   591: sipush 360
    //   594: aload_0
    //   595: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   598: getfield 202	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:i	I
    //   601: isub
    //   602: i2f
    //   603: invokestatic 196	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   606: astore_1
    //   607: goto -229 -> 378
    //   610: aload_0
    //   611: aload_1
    //   612: invokevirtual 213	android/graphics/Bitmap:getHeight	()I
    //   615: putfield 210	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:e	I
    //   618: aload_0
    //   619: aload_1
    //   620: invokevirtual 208	android/graphics/Bitmap:getWidth	()I
    //   623: putfield 214	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:f	I
    //   626: goto -211 -> 415
    //   629: astore_1
    //   630: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq +35 -> 668
    //   636: ldc 163
    //   638: iconst_2
    //   639: new 235	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   646: ldc 251
    //   648: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: aload_0
    //   652: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   655: getfield 182	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   658: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: aload_1
    //   665: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   668: aload_0
    //   669: iconst_1
    //   670: aload_1
    //   671: invokevirtual 233	com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:a_	(ILjava/lang/Throwable;)V
    //   674: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	Mp4ReEncoder
    //   155	261	1	localObject1	Object
    //   545	23	1	localException	java.lang.Exception
    //   579	41	1	localObject2	Object
    //   629	42	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   350	241	2	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   0	99	545	java/lang/Exception
    //   99	140	545	java/lang/Exception
    //   140	178	545	java/lang/Exception
    //   178	206	545	java/lang/Exception
    //   206	233	545	java/lang/Exception
    //   233	328	545	java/lang/Exception
    //   328	336	545	java/lang/Exception
    //   340	378	545	java/lang/Exception
    //   378	415	545	java/lang/Exception
    //   415	419	545	java/lang/Exception
    //   419	457	545	java/lang/Exception
    //   457	527	545	java/lang/Exception
    //   528	542	545	java/lang/Exception
    //   580	607	545	java/lang/Exception
    //   610	626	545	java/lang/Exception
    //   630	668	545	java/lang/Exception
    //   668	674	545	java/lang/Exception
    //   340	378	629	java/lang/OutOfMemoryError
    //   378	415	629	java/lang/OutOfMemoryError
    //   415	419	629	java/lang/OutOfMemoryError
    //   580	607	629	java/lang/OutOfMemoryError
    //   610	626	629	java/lang/OutOfMemoryError
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    a_(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFrame wait timestamp = " + paramLong);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Long >= paramLong)
      {
        this.jdField_b_of_type_Boolean = true;
        QLog.e("Mp4ReEncoder", 2, "mLastDecodeTimestamp >= timestampNanos; mLastDecodeTimestamp = " + this.jdField_a_of_type_Long + " timestampNanos = " + paramLong);
        return;
      }
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = paramLong;
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onDecodeFrame start timestamp = " + paramLong);
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait(2000L);
        if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Int == 0) && (!this.jdField_c_of_type_Boolean)) {
          a_(3, new RuntimeException("frame wait timed out"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onDecodeFrame end timestamp = " + paramLong);
        }
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        if (!QLog.isColorLevel()) {
          break label274;
        }
        QLog.d("Mp4ReEncoder", 2, "onDecodeFrame InterruptedException");
        this.jdField_a_of_type_Boolean = false;
        throw localInterruptedException;
      }
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  public void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, Mp4ReEncoder.EncodeFilterRender paramEncodeFilterRender)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = paramEncodeConfig;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener = paramHWEncodeListener;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender = paramEncodeFilterRender;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(paramEncodeConfig, this);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener.a(paramString);
    }
    if (this.jdField_d_of_type_Int != -1)
    {
      GlUtil.a(this.jdField_d_of_type_Int);
      this.jdField_d_of_type_Int = -1;
    }
    if (this.jdField_c_of_type_Int != -1)
    {
      GlUtil.a(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
    }
    GlUtil.a(this.jdField_c_of_type_Int);
    d();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a();
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
  
  public void c()
  {
    SLog.d("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWVideoDecoder.a();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
  }
  
  public void l() {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.jdField_b_of_type_Long + " , mLastDecodeTimestamp " + this.jdField_a_of_type_Long);
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
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.e("Mp4ReEncoder", 2, "onFrameAvailable skipDecode");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Int != 0) || (this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_b_of_type_Int + " ; canceled=" + this.jdField_c_of_type_Boolean + "; stopped=" + this.jdField_d_of_type_Boolean);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable start");
    }
    if (this.jdField_a_of_type_Boolean) {
      a_(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
    }
    paramSurfaceTexture.updateTexImage();
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable timestap = " + this.jdField_b_of_type_Long);
    }
    float[] arrayOfFloat = new float[16];
    paramSurfaceTexture.getTransformMatrix(arrayOfFloat);
    ??? = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.jdField_c_of_type_Int, null, null);
    paramSurfaceTexture = (SurfaceTexture)???;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a(((RenderBuffer)???).a(), null, null);
      paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a();
      paramSurfaceTexture.b();
    }
    int i;
    if ((this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "subtitle encoder begin");
      }
      paramSurfaceTexture.c();
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer.a(this.jdField_b_of_type_Long / 1000000L)) {
        break label673;
      }
      paramSurfaceTexture.b();
      i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesBaseAnimDrawer.d();
      if (i >= 0) {
        this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(i, null, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "subtitle draw texture end");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null)
      {
        ??? = GPUBaseFilter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, this.e, this.f);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_d_of_type_Int, null, (float[])???);
        GLES20.glDisable(3042);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender.a();
      }
      paramSurfaceTexture.c();
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(paramSurfaceTexture.a(), arrayOfFloat, null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.a(), arrayOfFloat, null, this.jdField_b_of_type_Long);
      i = 1;
      while (i <= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.a(), arrayOfFloat, null, this.jdField_b_of_type_Long + i * 5 * 1000);
        i += 1;
      }
      label673:
      paramSurfaceTexture.b();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder
 * JD-Core Version:    0.7.0.1
 */