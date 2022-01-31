package dov.com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.Matrix;
import android.text.TextUtils;
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
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
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
  private TransferData jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData;
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter.d();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.d();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 97
    //   3: invokestatic 102	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:a	(I)I
    //   6: putfield 104	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_Int	I
    //   9: aload_0
    //   10: new 106	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer
    //   13: dup
    //   14: aload_0
    //   15: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   18: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   21: aload_0
    //   22: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   25: getfield 113	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   28: ldc 114
    //   30: invokespecial 117	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:<init>	(III)V
    //   33: putfield 119	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer;
    //   36: aload_0
    //   37: new 106	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer
    //   40: dup
    //   41: aload_0
    //   42: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   45: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   48: aload_0
    //   49: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   52: getfield 113	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   55: ldc 114
    //   57: invokespecial 117	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:<init>	(III)V
    //   60: putfield 121	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer;
    //   63: aload_0
    //   64: bipush 102
    //   66: invokestatic 126	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   69: checkcast 75	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter
    //   72: putfield 73	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   75: aload_0
    //   76: getfield 73	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   79: aload_0
    //   80: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   83: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   86: aload_0
    //   87: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   90: getfield 113	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   93: invokevirtual 129	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter:a	(II)V
    //   96: aload_0
    //   97: getfield 73	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUOESBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter;
    //   100: invokevirtual 131	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUOESBaseFilter:a	()V
    //   103: aload_0
    //   104: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   107: getfield 133	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   110: invokestatic 136	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Z
    //   113: ifne +13 -> 126
    //   116: aload_0
    //   117: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   120: getfield 139	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   123: ifnull +110 -> 233
    //   126: aload_0
    //   127: new 81	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup
    //   130: dup
    //   131: invokespecial 140	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:<init>	()V
    //   134: putfield 79	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   137: aload_0
    //   138: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   141: getfield 133	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   144: invokestatic 136	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Z
    //   147: ifeq +20 -> 167
    //   150: aload_0
    //   151: getfield 79	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   154: aload_0
    //   155: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   158: getfield 133	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:f	I
    //   161: invokestatic 126	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   164: invokevirtual 143	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;)V
    //   167: aload_0
    //   168: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   171: getfield 139	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   174: ifnull +31 -> 205
    //   177: bipush 106
    //   179: invokestatic 126	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   182: astore_1
    //   183: aload_1
    //   184: checkcast 145	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUImagePixelationFilter
    //   187: aload_0
    //   188: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   191: getfield 139	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:c	Ljava/lang/String;
    //   194: invokevirtual 148	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUImagePixelationFilter:b	(Ljava/lang/String;)V
    //   197: aload_0
    //   198: getfield 79	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   201: aload_1
    //   202: invokevirtual 143	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;)V
    //   205: aload_0
    //   206: getfield 79	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   209: aload_0
    //   210: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   213: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   216: aload_0
    //   217: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   220: getfield 113	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   223: invokevirtual 149	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	(II)V
    //   226: aload_0
    //   227: getfield 79	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImageFilterGroup	Ldov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup;
    //   230: invokevirtual 150	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GpuImageFilterGroup:a	()V
    //   233: aload_0
    //   234: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   237: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   240: astore_1
    //   241: aload_1
    //   242: ifnull +114 -> 356
    //   245: aload_0
    //   246: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   249: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   252: invokestatic 158	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   255: astore_2
    //   256: aload_0
    //   257: getfield 160	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   260: getfield 164	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_c_of_type_Boolean	Z
    //   263: ifeq +399 -> 662
    //   266: aload_2
    //   267: astore_1
    //   268: aload_2
    //   269: invokevirtual 170	android/graphics/Bitmap:getWidth	()I
    //   272: aload_2
    //   273: invokevirtual 173	android/graphics/Bitmap:getHeight	()I
    //   276: if_icmple +10 -> 286
    //   279: aload_2
    //   280: ldc 174
    //   282: invokestatic 179	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   285: astore_1
    //   286: aload_0
    //   287: sipush 3553
    //   290: aload_1
    //   291: invokestatic 182	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:a	(ILandroid/graphics/Bitmap;)I
    //   294: putfield 59	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_d_of_type_Int	I
    //   297: aload_0
    //   298: aload_1
    //   299: invokevirtual 170	android/graphics/Bitmap:getWidth	()I
    //   302: putfield 184	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_e_of_type_Int	I
    //   305: aload_0
    //   306: aload_1
    //   307: invokevirtual 173	android/graphics/Bitmap:getHeight	()I
    //   310: putfield 185	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:f	I
    //   313: aload_1
    //   314: invokevirtual 188	android/graphics/Bitmap:recycle	()V
    //   317: aload_0
    //   318: new 86	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter
    //   321: dup
    //   322: invokespecial 189	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:<init>	()V
    //   325: putfield 84	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   328: aload_0
    //   329: getfield 84	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   332: aload_0
    //   333: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   336: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   339: aload_0
    //   340: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   343: getfield 113	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   346: invokevirtual 190	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:a	(II)V
    //   349: aload_0
    //   350: getfield 84	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUAlphaBlendFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter;
    //   353: invokevirtual 191	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUAlphaBlendFilter:a	()V
    //   356: aload_0
    //   357: bipush 101
    //   359: invokestatic 126	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   362: putfield 89	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   365: aload_0
    //   366: getfield 89	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   369: aload_0
    //   370: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   373: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   376: aload_0
    //   377: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   380: getfield 113	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   383: invokevirtual 192	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	(II)V
    //   386: aload_0
    //   387: getfield 89	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   390: invokevirtual 193	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	()V
    //   393: aload_0
    //   394: new 195	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager
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
    //   411: invokespecial 198	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:<init>	([I)V
    //   414: putfield 200	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   417: aload_0
    //   418: getfield 202	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   421: ifnull +24 -> 445
    //   424: aload_0
    //   425: getfield 202	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   428: invokevirtual 207	java/util/ArrayList:size	()I
    //   431: ifle +14 -> 445
    //   434: aload_0
    //   435: getfield 200	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   438: aload_0
    //   439: getfield 202	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   442: invokevirtual 210	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:b	(Ljava/util/List;)V
    //   445: aload_0
    //   446: getfield 212	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   449: ifnull +14 -> 463
    //   452: aload_0
    //   453: getfield 200	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   456: aload_0
    //   457: getfield 212	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   460: invokevirtual 215	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:a	(Ljava/util/ArrayList;)V
    //   463: aload_0
    //   464: getfield 200	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   467: aload_0
    //   468: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   471: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   474: aload_0
    //   475: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   478: getfield 113	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   481: aload_0
    //   482: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   485: getfield 112	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_a_of_type_Int	I
    //   488: aload_0
    //   489: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   492: getfield 113	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_Int	I
    //   495: invokevirtual 218	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:b	(IIII)V
    //   498: aload_0
    //   499: getfield 200	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   502: aload_0
    //   503: getfield 160	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   506: getfield 219	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Long	J
    //   509: invokevirtual 222	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:a	(J)V
    //   512: aload_0
    //   513: getfield 224	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData	Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;
    //   516: ifnull +112 -> 628
    //   519: aconst_null
    //   520: astore_1
    //   521: aload_0
    //   522: getfield 200	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   525: sipush 160
    //   528: invokevirtual 226	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:b	(I)Z
    //   531: ifne +11 -> 542
    //   534: aload_0
    //   535: getfield 200	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   538: invokevirtual 229	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:a	()Lcom/tencent/mobileqq/shortvideo/filter/QQTransferFilter;
    //   541: astore_1
    //   542: aload_1
    //   543: astore_2
    //   544: aload_1
    //   545: ifnonnull +57 -> 602
    //   548: aload_0
    //   549: getfield 200	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager	Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   552: sipush 160
    //   555: invokevirtual 232	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:a	(I)Ljava/util/List;
    //   558: astore_3
    //   559: aload_1
    //   560: astore_2
    //   561: aload_3
    //   562: ifnull +40 -> 602
    //   565: aload_1
    //   566: astore_2
    //   567: aload_3
    //   568: invokeinterface 235 1 0
    //   573: ifle +29 -> 602
    //   576: aload_1
    //   577: astore_2
    //   578: aload_3
    //   579: iconst_0
    //   580: invokeinterface 239 2 0
    //   585: instanceof 241
    //   588: ifeq +14 -> 602
    //   591: aload_3
    //   592: iconst_0
    //   593: invokeinterface 239 2 0
    //   598: checkcast 241	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter
    //   601: astore_2
    //   602: aload_2
    //   603: ifnull +25 -> 628
    //   606: aload_2
    //   607: aload_0
    //   608: getfield 224	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData	Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;
    //   611: invokevirtual 244	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter:a	(Lcom/tencent/mobileqq/shortvideo/videotransfer/TransferData;)V
    //   614: aload_2
    //   615: aload_0
    //   616: getfield 160	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   619: getfield 245	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_a_of_type_Int	I
    //   622: invokestatic 248	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:a	(I)F
    //   625: invokevirtual 251	com/tencent/mobileqq/shortvideo/filter/QQTransferFilter:a	(F)V
    //   628: aload_0
    //   629: getfield 69	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder;
    //   632: aload_0
    //   633: getfield 160	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   636: aload_0
    //   637: getfield 104	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_c_of_type_Int	I
    //   640: aload_0
    //   641: aload_0
    //   642: invokevirtual 254	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;ILandroid/graphics/SurfaceTexture$OnFrameAvailableListener;Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;)V
    //   645: aload_0
    //   646: getfield 256	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWEncodeListener;
    //   649: ifnull +12 -> 661
    //   652: aload_0
    //   653: getfield 256	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWEncodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/recorder/HWEncodeListener;
    //   656: invokeinterface 257 1 0
    //   661: return
    //   662: aload_2
    //   663: sipush 360
    //   666: aload_0
    //   667: getfield 160	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
    //   670: getfield 258	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:jdField_c_of_type_Int	I
    //   673: isub
    //   674: i2f
    //   675: invokestatic 179	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   678: astore_1
    //   679: goto -393 -> 286
    //   682: astore_1
    //   683: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq +37 -> 723
    //   689: ldc_w 266
    //   692: iconst_2
    //   693: new 268	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 271
    //   703: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload_0
    //   707: getfield 108	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig;
    //   710: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/encoder/EncodeConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   713: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: aload_1
    //   720: invokestatic 282	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   723: aload_0
    //   724: iconst_1
    //   725: aload_1
    //   726: invokevirtual 286	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:a_	(ILjava/lang/Throwable;)V
    //   729: return
    //   730: astore_1
    //   731: aload_0
    //   732: iconst_4
    //   733: aload_1
    //   734: invokevirtual 286	dov/com/tencent/mobileqq/richmedia/mediacodec/encoder/Mp4ReEncoder:a_	(ILjava/lang/Throwable;)V
    //   737: ldc_w 266
    //   740: iconst_1
    //   741: new 268	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   748: ldc_w 288
    //   751: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload_1
    //   755: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 294	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	765	0	this	Mp4ReEncoder
    //   182	497	1	localObject1	Object
    //   682	44	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   730	25	1	localException	Exception
    //   255	408	2	localObject2	Object
    //   558	34	3	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   245	266	682	java/lang/OutOfMemoryError
    //   268	286	682	java/lang/OutOfMemoryError
    //   286	317	682	java/lang/OutOfMemoryError
    //   662	679	682	java/lang/OutOfMemoryError
    //   0	126	730	java/lang/Exception
    //   126	167	730	java/lang/Exception
    //   167	205	730	java/lang/Exception
    //   205	233	730	java/lang/Exception
    //   233	241	730	java/lang/Exception
    //   245	266	730	java/lang/Exception
    //   268	286	730	java/lang/Exception
    //   286	317	730	java/lang/Exception
    //   317	356	730	java/lang/Exception
    //   356	445	730	java/lang/Exception
    //   445	463	730	java/lang/Exception
    //   463	519	730	java/lang/Exception
    //   521	542	730	java/lang/Exception
    //   548	559	730	java/lang/Exception
    //   567	576	730	java/lang/Exception
    //   578	602	730	java/lang/Exception
    //   606	628	730	java/lang/Exception
    //   628	661	730	java/lang/Exception
    //   662	679	730	java/lang/Exception
    //   683	723	730	java/lang/Exception
    //   723	729	730	java/lang/Exception
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
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.q();
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
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData = new TransferData();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.a(paramString);
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
    label844:
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
            break label844;
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
      paramSurfaceTexture.a();
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