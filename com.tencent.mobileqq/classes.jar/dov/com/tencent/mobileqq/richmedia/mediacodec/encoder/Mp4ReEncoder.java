package dov.com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImageFilterGroup;
import java.util.ArrayList;

@TargetApi(11)
public class Mp4ReEncoder
  implements SurfaceTexture.OnFrameAvailableListener, HWEncodeListener, HWDecodeListener
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private HWEncodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
  private GPUAlphaBlendFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter;
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
  private HWVideoDecoder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = new HWVideoDecoder();
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private Mp4ReEncoder.EncodeFilterRender jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender;
  private GpuImageFilterGroup jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private RenderBuffer jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private long jdField_d_of_type_Long = -1L;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.c();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.c();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 96
    //   3: invokestatic 101	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:a	(I)I
    //   6: putfield 103	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_Int	I
    //   9: aload_0
    //   10: new 105	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer
    //   13: dup
    //   14: aload_0
    //   15: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   18: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   21: aload_0
    //   22: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   25: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   28: ldc 113
    //   30: invokespecial 116	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:<init>	(III)V
    //   33: putfield 118	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer;
    //   36: aload_0
    //   37: new 105	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer
    //   40: dup
    //   41: aload_0
    //   42: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   45: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   48: aload_0
    //   49: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   52: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   55: ldc 113
    //   57: invokespecial 116	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:<init>	(III)V
    //   60: putfield 120	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer;
    //   63: aload_0
    //   64: bipush 102
    //   66: invokestatic 125	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   69: checkcast 74	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter
    //   72: putfield 72	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   75: aload_0
    //   76: getfield 72	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   79: aload_0
    //   80: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   83: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   86: aload_0
    //   87: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   90: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   93: invokevirtual 128	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter:a	(II)V
    //   96: aload_0
    //   97: getfield 72	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   100: invokevirtual 130	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter:a	()V
    //   103: aload_0
    //   104: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   107: getfield 132	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   110: invokestatic 135	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Z
    //   113: ifne +13 -> 126
    //   116: aload_0
    //   117: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   120: getfield 138	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   123: ifnull +110 -> 233
    //   126: aload_0
    //   127: new 80	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup
    //   130: dup
    //   131: invokespecial 139	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:<init>	()V
    //   134: putfield 78	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   137: aload_0
    //   138: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   141: getfield 132	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   144: invokestatic 135	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Z
    //   147: ifeq +20 -> 167
    //   150: aload_0
    //   151: getfield 78	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   154: aload_0
    //   155: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   158: getfield 132	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   161: invokestatic 125	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   164: invokevirtual 142	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;)V
    //   167: aload_0
    //   168: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   171: getfield 138	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   174: ifnull +31 -> 205
    //   177: bipush 106
    //   179: invokestatic 125	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   182: astore_1
    //   183: aload_1
    //   184: checkcast 144	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUImagePixelationFilter
    //   187: aload_0
    //   188: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   191: getfield 138	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   194: invokevirtual 147	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUImagePixelationFilter:b	(Ljava/lang/String;)V
    //   197: aload_0
    //   198: getfield 78	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   201: aload_1
    //   202: invokevirtual 142	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;)V
    //   205: aload_0
    //   206: getfield 78	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   209: aload_0
    //   210: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   213: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   216: aload_0
    //   217: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   220: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   223: invokevirtual 148	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(II)V
    //   226: aload_0
    //   227: getfield 78	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   230: invokevirtual 149	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	()V
    //   233: aload_0
    //   234: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   237: getfield 151	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   240: astore_1
    //   241: aload_1
    //   242: ifnull +114 -> 356
    //   245: aload_0
    //   246: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   249: getfield 151	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   252: invokestatic 157	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   255: astore_2
    //   256: aload_0
    //   257: getfield 159	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   260: getfield 163	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_c_of_type_Boolean	Z
    //   263: ifeq +283 -> 546
    //   266: aload_2
    //   267: astore_1
    //   268: aload_2
    //   269: invokevirtual 169	android/graphics/Bitmap:getWidth	()I
    //   272: aload_2
    //   273: invokevirtual 172	android/graphics/Bitmap:getHeight	()I
    //   276: if_icmple +10 -> 286
    //   279: aload_2
    //   280: ldc 173
    //   282: invokestatic 178	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   285: astore_1
    //   286: aload_0
    //   287: sipush 3553
    //   290: aload_1
    //   291: invokestatic 181	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:a	(ILandroid/graphics/Bitmap;)I
    //   294: putfield 58	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_d_of_type_Int	I
    //   297: aload_0
    //   298: aload_1
    //   299: invokevirtual 169	android/graphics/Bitmap:getWidth	()I
    //   302: putfield 183	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_e_of_type_Int	I
    //   305: aload_0
    //   306: aload_1
    //   307: invokevirtual 172	android/graphics/Bitmap:getHeight	()I
    //   310: putfield 184	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:f	I
    //   313: aload_1
    //   314: invokevirtual 187	android/graphics/Bitmap:recycle	()V
    //   317: aload_0
    //   318: new 85	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter
    //   321: dup
    //   322: invokespecial 188	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:<init>	()V
    //   325: putfield 83	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   328: aload_0
    //   329: getfield 83	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   332: aload_0
    //   333: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   336: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   339: aload_0
    //   340: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   343: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   346: invokevirtual 189	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:a	(II)V
    //   349: aload_0
    //   350: getfield 83	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   353: invokevirtual 190	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:a	()V
    //   356: aload_0
    //   357: bipush 101
    //   359: invokestatic 125	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   362: putfield 88	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   365: aload_0
    //   366: getfield 88	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   369: aload_0
    //   370: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   373: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   376: aload_0
    //   377: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   380: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   383: invokevirtual 191	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	(II)V
    //   386: aload_0
    //   387: getfield 88	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   390: invokevirtual 192	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	()V
    //   393: aload_0
    //   394: new 194	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager
    //   397: dup
    //   398: iconst_2
    //   399: newarray int
    //   401: dup
    //   402: iconst_0
    //   403: bipush 120
    //   405: iastore
    //   406: dup
    //   407: iconst_1
    //   408: bipush 110
    //   410: iastore
    //   411: invokespecial 197	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:<init>	([I)V
    //   414: putfield 199	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   417: aload_0
    //   418: getfield 201	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   421: ifnull +24 -> 445
    //   424: aload_0
    //   425: getfield 201	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   428: invokevirtual 206	java/util/ArrayList:size	()I
    //   431: ifle +14 -> 445
    //   434: aload_0
    //   435: getfield 199	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   438: aload_0
    //   439: getfield 201	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   442: invokevirtual 209	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:b	(Ljava/util/List;)V
    //   445: aload_0
    //   446: getfield 211	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   449: ifnull +14 -> 463
    //   452: aload_0
    //   453: getfield 199	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   456: aload_0
    //   457: getfield 211	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   460: invokevirtual 214	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:a	(Ljava/util/ArrayList;)V
    //   463: aload_0
    //   464: getfield 199	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   467: aload_0
    //   468: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   471: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   474: aload_0
    //   475: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   478: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   481: aload_0
    //   482: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   485: getfield 111	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   488: aload_0
    //   489: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   492: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   495: invokevirtual 217	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:b	(IIII)V
    //   498: aload_0
    //   499: getfield 199	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   502: aload_0
    //   503: getfield 159	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   506: getfield 218	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Long	J
    //   509: invokevirtual 221	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:a	(J)V
    //   512: aload_0
    //   513: getfield 68	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;
    //   516: aload_0
    //   517: getfield 159	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   520: aload_0
    //   521: getfield 103	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_Int	I
    //   524: aload_0
    //   525: aload_0
    //   526: invokevirtual 224	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;)V
    //   529: aload_0
    //   530: getfield 226	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWEncodeListener;
    //   533: ifnull +12 -> 545
    //   536: aload_0
    //   537: getfield 226	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWEncodeListener;
    //   540: invokeinterface 227 1 0
    //   545: return
    //   546: aload_2
    //   547: sipush 360
    //   550: aload_0
    //   551: getfield 159	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   554: getfield 228	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_c_of_type_Int	I
    //   557: isub
    //   558: i2f
    //   559: invokestatic 178	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   562: astore_1
    //   563: goto -277 -> 286
    //   566: astore_1
    //   567: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +35 -> 605
    //   573: ldc 236
    //   575: iconst_2
    //   576: new 238	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   583: ldc 241
    //   585: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_0
    //   589: getfield 107	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   592: getfield 151	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   595: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: aload_1
    //   602: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   605: aload_0
    //   606: iconst_1
    //   607: aload_1
    //   608: invokevirtual 256	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:a_	(ILjava/lang/Throwable;)V
    //   611: return
    //   612: astore_1
    //   613: aload_0
    //   614: iconst_4
    //   615: aload_1
    //   616: invokevirtual 256	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:a_	(ILjava/lang/Throwable;)V
    //   619: ldc 236
    //   621: iconst_1
    //   622: new 238	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   629: ldc_w 258
    //   632: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_1
    //   636: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   639: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	646	0	this	Mp4ReEncoder
    //   182	381	1	localObject	Object
    //   566	42	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   612	24	1	localException	Exception
    //   255	292	2	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   245	266	566	java/lang/OutOfMemoryError
    //   268	286	566	java/lang/OutOfMemoryError
    //   286	317	566	java/lang/OutOfMemoryError
    //   546	563	566	java/lang/OutOfMemoryError
    //   0	126	612	java/lang/Exception
    //   126	167	612	java/lang/Exception
    //   167	205	612	java/lang/Exception
    //   205	233	612	java/lang/Exception
    //   233	241	612	java/lang/Exception
    //   245	266	612	java/lang/Exception
    //   268	286	612	java/lang/Exception
    //   286	317	612	java/lang/Exception
    //   317	356	612	java/lang/Exception
    //   356	445	612	java/lang/Exception
    //   445	463	612	java/lang/Exception
    //   463	545	612	java/lang/Exception
    //   546	563	612	java/lang/Exception
    //   567	605	612	java/lang/Exception
    //   605	611	612	java/lang/Exception
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    a_(paramInt + 10000, paramThrowable);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFrame wait timestamp = " + paramLong1 + " orgSampleTime: " + paramLong2);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_b_of_type_Long = paramLong2;
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaLangObject.notifyAll();
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onDecodeFrame start timestamp = " + paramLong1);
        }
      }
    }
  }
  
  public void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, HWEncodeListener paramHWEncodeListener, Mp4ReEncoder.EncodeFilterRender paramEncodeFilterRender)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = paramDecodeConfig;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = paramEncodeConfig;
    if ((paramDecodeConfig.jdField_a_of_type_Int == 1) || (paramDecodeConfig.jdField_a_of_type_Int == 3)) {
      this.jdField_e_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener = paramHWEncodeListener;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender = paramEncodeFilterRender;
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
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.o();
    if (this.jdField_c_of_type_Int != -1)
    {
      GlUtil.a(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
    }
    GlUtil.a(this.jdField_c_of_type_Int);
    h();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a();
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
  
  public void b(ArrayList paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void c()
  {
    SLog.d("Richard", "cancelEncode");
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "cancelEncode");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.a();
  }
  
  public void d()
  {
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeStart");
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeFinish");
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onDecodeCancel");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
  }
  
  public void g() {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_c_of_type_Long >= this.jdField_a_of_type_Long) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait onDecodeFrame. mLastAvailableTimestamp = " + this.jdField_c_of_type_Long + " , mLastDecodeTimestamp " + this.jdField_a_of_type_Long + " mLastDecodeSampleTimestamp :" + this.jdField_b_of_type_Long);
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
    if (QLog.isColorLevel()) {
      QLog.d("Mp4ReEncoder", 2, "onFrameAvailable wait");
    }
    label833:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Int != 0) || (this.jdField_d_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_b_of_type_Int + "; canceled=" + this.jdField_c_of_type_Boolean + "; stopped=" + this.jdField_d_of_type_Boolean);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Mp4ReEncoder", 2, "onFrameAvailable start");
        }
        if (this.jdField_a_of_type_Boolean) {
          a_(5, new RuntimeException("mFrameAvailable already set, frame could be dropped"));
        }
        try
        {
          paramSurfaceTexture.updateTexImage();
          this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("Mp4ReEncoder", 2, "onFrameAvailable timestap = " + this.jdField_c_of_type_Long);
          }
          float[] arrayOfFloat1 = new float[16];
          paramSurfaceTexture.getTransformMatrix(arrayOfFloat1);
          paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
          float[] arrayOfFloat2 = new float[16];
          Matrix.setIdentityM(arrayOfFloat2, 0);
          Matrix.rotateM(arrayOfFloat2, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.h, 0.0F, 0.0F, 1.0F);
          Matrix.scaleM(arrayOfFloat2, 0, 1.0F, -1.0F, 1.0F);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.a(this.jdField_c_of_type_Int, arrayOfFloat1, arrayOfFloat2);
          int i;
          if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender != null)
          {
            paramSurfaceTexture.c();
            i = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecEncoderMp4ReEncoder$EncodeFilterRender.a(paramSurfaceTexture.a(), this.jdField_c_of_type_Long);
            if (i != -1) {
              paramSurfaceTexture.b(i);
            }
            paramSurfaceTexture.b();
          }
          if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup == null) {
            break label833;
          }
          paramSurfaceTexture.c();
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a(paramSurfaceTexture.a(), null, null);
          paramSurfaceTexture = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.a();
          paramSurfaceTexture.b();
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter != null)
          {
            arrayOfFloat1 = GPUBaseFilter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int, this.jdField_e_of_type_Int, this.f);
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.a(this.jdField_d_of_type_Int, null, arrayOfFloat1);
          }
          paramSurfaceTexture.c();
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
          this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(l1, this.jdField_b_of_type_Long);
          paramSurfaceTexture.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(paramSurfaceTexture.a()));
          if ((!this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Long == -1L) || (this.jdField_c_of_type_Long - this.jdField_d_of_type_Long >= 16666666L))
          {
            arrayOfFloat1 = new float[16];
            Matrix.setIdentityM(arrayOfFloat1, 0);
            Matrix.scaleM(arrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
            this.jdField_d_of_type_Long = this.jdField_c_of_type_Long;
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.a(), null, arrayOfFloat1, this.jdField_c_of_type_Long);
            i = 1;
            if (i <= this.jdField_a_of_type_Int)
            {
              this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, paramSurfaceTexture.a(), null, arrayOfFloat1, this.jdField_c_of_type_Long + i * 5 * 1000);
              i += 1;
              continue;
              paramSurfaceTexture = finally;
            }
          }
        }
        catch (Exception paramSurfaceTexture)
        {
          paramSurfaceTexture.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          QLog.w("Mp4ReEncoder", 2, "onFrameAvailable error=" + this.jdField_b_of_type_Int + " ; canceled=" + this.jdField_c_of_type_Boolean);
          return;
        }
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoder", 2, "onFrameAvailable end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.encoder.Mp4ReEncoder
 * JD-Core Version:    0.7.0.1
 */