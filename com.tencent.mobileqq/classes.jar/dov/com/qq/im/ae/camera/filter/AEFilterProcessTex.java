package dov.com.qq.im.ae.camera.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.SensorEvent;
import android.opengl.GLES20;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.CropFilter;
import com.tencent.ttpic.openapi.filter.LightNode.ILightNodeTipsListener;
import com.tencent.ttpic.openapi.filter.SpaceFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import com.tencent.ttpic.openapi.util.AEStaticDetector;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.MustRunOnGLThread;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil;
import dov.com.qq.im.ae.debug.AECameraDebug;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.gif.GifFilterMgr;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AELightLogger;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.light.listener.LightAssetListener;
import org.light.utils.LightLogUtil;

public class AEFilterProcessTex
  extends FilterProcessBase
{
  private static SparseArray<VideoMaterial> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static String jdField_a_of_type_JavaLangString;
  private static boolean c;
  private static boolean e;
  private static int o = 0;
  private static int p = 0;
  private AEFilterManager.MaterialInnerEffectListener jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$MaterialInnerEffectListener;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter;
  private CropFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter;
  private LightNode.ILightNodeTipsListener jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode$ILightNodeTipsListener;
  private SpaceFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter;
  private AEFilterProcessTex.IEditableWatermarkMaterialRecover jdField_a_of_type_DovComQqImAeCameraFilterAEFilterProcessTex$IEditableWatermarkMaterialRecover;
  private ScaleFilter jdField_a_of_type_DovComQqImAeCameraFilterScaleFilter;
  private AECameraDebug jdField_a_of_type_DovComQqImAeDebugAECameraDebug = new AECameraDebug();
  private GifFilterMgr jdField_a_of_type_DovComQqImAeGifGifFilterMgr;
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private LightAssetListener jdField_a_of_type_OrgLightListenerLightAssetListener;
  public volatile boolean a;
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame;
  private BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter;
  private String jdField_b_of_type_JavaLangString;
  private boolean d;
  private boolean f;
  private int n = -1;
  private final int q;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_c_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
  }
  
  public AEFilterProcessTex(int paramInt)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.q = paramInt;
    j();
    i();
  }
  
  @Nullable
  private VideoMaterial a()
  {
    return (VideoMaterial)jdField_a_of_type_AndroidUtilSparseArray.get(this.q);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        i = -((this.l - 90 + 360) % 360);
        AEQLog.a("AEFilterProcessTex", "[captureFrame]:rotation = " + i);
        this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(i, 0, 0);
        if (this.l == 0) {
          break label165;
        }
        if (this.l != 180) {
          break label162;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Bitmap localBitmap;
        if (this.jdField_a_of_type_DovComQqImAeCameraFilterAEFilterProcessTex$CapturePhotoListener == null) {
          continue;
        }
        this.jdField_a_of_type_DovComQqImAeCameraFilterAEFilterProcessTex$CapturePhotoListener.onCaptureError(103);
        return;
      }
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(paramInt1, paramInt2, paramInt3, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
      this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 0);
      localBitmap = RendererUtils.saveTexture(this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
      if (this.jdField_a_of_type_DovComQqImAeCameraFilterAEFilterProcessTex$CapturePhotoListener != null) {
        this.jdField_a_of_type_DovComQqImAeCameraFilterAEFilterProcessTex$CapturePhotoListener.onPhotoCaptured(localBitmap);
      }
      if (this.jdField_f_of_type_Boolean) {
        o();
      }
      return;
      label162:
      continue;
      label165:
      int i = paramInt2;
      paramInt2 = paramInt3;
      paramInt3 = i;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glClearColor(0.92F, 0.93F, 0.96F, 1.0F);
      GLES20.glClear(16384);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
    }
    FrameUtil.clearFrame(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramInt1, paramInt2);
    this.jdField_a_of_type_DovComQqImAeCameraFilterScaleFilter.RenderProcess(paramInt3, paramInt1, paramInt1, -1, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.setRotationAndFlip(0, 0, 1);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.RenderProcess(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), paramInt1, paramInt2, 0, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
    if (paramBoolean) {
      GlUtil.setBlendModeSrcAlpha(false);
    }
  }
  
  public static void a(int paramInt, VideoMaterial paramVideoMaterial)
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramVideoMaterial);
  }
  
  private void b(@Nullable VideoMaterial paramVideoMaterial)
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(this.q, paramVideoMaterial);
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.BASIC4, paramInt);
    }
  }
  
  private boolean g()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {}
    while ((!DovSVParamManager.a().a()) || (!f()) || (!this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.canUseLargeImage())) {
      return false;
    }
    return true;
  }
  
  private static void i()
  {
    if (jdField_e_of_type_Boolean) {
      return;
    }
    jdField_e_of_type_Boolean = true;
    LightLogUtil.initLogger(new AELightLogger());
    LightLogUtil.setMinPriority(6);
  }
  
  private void j()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentFilterBaseFilter == null) {
        this.jdField_a_of_type_ComTencentFilterBaseFilter = new SurfaceTextureFilter();
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter == null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = new SpaceFilter();
      }
      if (this.jdField_b_of_type_ComTencentFilterBaseFilter == null) {
        this.jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraFilterScaleFilter == null) {
        this.jdField_a_of_type_DovComQqImAeCameraFilterScaleFilter = new ScaleFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter == null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter = new CropFilter();
      }
      if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == null) {
        this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
      }
      if (this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame == null) {
        this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
      }
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager();
      }
      if (this.jdField_a_of_type_DovComQqImAeGifGifFilterMgr == null) {
        this.jdField_a_of_type_DovComQqImAeGifGifFilterMgr = new GifFilterMgr();
      }
      return;
    }
    finally {}
  }
  
  @MustRunOnGLThread
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentFilterBaseFilter != null) {
      this.jdField_a_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.applyFilterChain(true, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    if (this.jdField_b_of_type_ComTencentFilterBaseFilter != null) {
      this.jdField_b_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraFilterScaleFilter != null) {
      this.jdField_a_of_type_DovComQqImAeCameraFilterScaleFilter.apply();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.apply();
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      n();
      l();
    }
    if (this.jdField_a_of_type_DovComQqImAeGifGifFilterMgr != null) {
      this.jdField_a_of_type_DovComQqImAeGifGifFilterMgr.a();
    }
    this.jdField_a_of_type_DovComQqImAeDebugAECameraDebug.a();
  }
  
  private void l()
  {
    VideoMaterial localVideoMaterial;
    if (a() != null)
    {
      localVideoMaterial = VideoMaterial.loadLightAsset(a().getDataPath());
      if (FeatureManager.ensureMaterialSoLoaded(localVideoMaterial))
      {
        AEQLog.b("AEFilterProcessTex", "recoverLastEffect---id=" + localVideoMaterial.getId());
        if (!localVideoMaterial.isWatermarkMaterial()) {
          break label138;
        }
        AEQLog.b("AEFilterProcessTex", "recoverLastEffect---is an editable watermark material");
        if (this.jdField_a_of_type_DovComQqImAeCameraFilterAEFilterProcessTex$IEditableWatermarkMaterialRecover != null) {
          this.jdField_a_of_type_DovComQqImAeCameraFilterAEFilterProcessTex$IEditableWatermarkMaterialRecover.recover(localVideoMaterial);
        }
      }
    }
    for (;;)
    {
      if (o > 0) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSmoothLevel(o);
      }
      if (p > 0) {
        d(p);
      }
      if ((jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited())) {
        c(jdField_c_of_type_Boolean);
      }
      return;
      label138:
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(localVideoMaterial);
      this.jdField_b_of_type_JavaLangString = localVideoMaterial.getId();
      continue;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
    }
  }
  
  private void m()
  {
    if (AEResUtil.a() != null)
    {
      Iterator localIterator = AEResUtil.a().keySet().iterator();
      while (localIterator.hasNext())
      {
        AEResInfo localAEResInfo = (AEResInfo)localIterator.next();
        if ((AEResUtil.b(localAEResInfo)) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null))
        {
          QLog.d("AEFilterProcessTex", 2, "[injectBundlePathsToLight] agentType:" + localAEResInfo.c + " | dir:" + AEResUtil.c(localAEResInfo));
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightBundle(AEResUtil.c(localAEResInfo), localAEResInfo.c);
        }
      }
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setStickerInnerLutFilterListener(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$MaterialInnerEffectListener);
    LogUtils.setEnable(false);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyNormalAlpha(0.8F);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.EYE_LIGHTEN, 35);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.REMOVE_POUNCH, 40);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyOrTransformLevel(BeautyRealConfig.TYPE.COLOR_TONE, 50);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeTipsListener(new AEFilterProcessTex.1(this));
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setLightNodeLightAssetListener(new AEFilterProcessTex.2(this));
    m();
    while ((this.jdField_a_of_type_JavaUtilQueue != null) && (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()))
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localRunnable != null) {
        localRunnable.run();
      }
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setStickerPause(true);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.onStickerStatusChange(true);
    }
  }
  
  public int a(int paramInt)
  {
    Frame localFrame = new Frame(-1, paramInt, this.i, this.j);
    return this.jdField_a_of_type_DovComQqImAeGifGifFilterMgr.a(localFrame).getTextureId();
  }
  
  public AEFilterManager a()
  {
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  }
  
  public PTFaceAttr a()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getFaceAttr();
  }
  
  public void a()
  {
    k();
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setPhoneRoll(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    o = paramInt;
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSmoothLevel(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateWidthHeight(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
  }
  
  public void a(PointF paramPointF, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.addMaskTouchPoint(paramPointF, paramInt);
  }
  
  public void a(SensorEvent paramSensorEvent)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSensorEventToLight(paramSensorEvent);
    }
  }
  
  public void a(Handler paramHandler)
  {
    AETipsManager.getInstance().setUIHandler(paramHandler, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, 0.1666666666666667D);
  }
  
  public void a(AEFilterManager.MaterialInnerEffectListener paramMaterialInnerEffectListener)
  {
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager$MaterialInnerEffectListener = paramMaterialInnerEffectListener;
  }
  
  public void a(LightNode.ILightNodeTipsListener paramILightNodeTipsListener)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterLightNode$ILightNodeTipsListener = paramILightNodeTipsListener;
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    b(paramVideoMaterial);
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      if ((paramVideoMaterial == null) || (paramVideoMaterial.getId() == null) || (paramVideoMaterial.getId().equals(this.jdField_b_of_type_JavaLangString))) {
        break label67;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
      this.jdField_b_of_type_JavaLangString = paramVideoMaterial.getId();
    }
    for (;;)
    {
      if (p > 0) {
        d(p);
      }
      return;
      label67:
      if ((paramVideoMaterial == null) || (paramVideoMaterial.getId() == null))
      {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
        this.jdField_b_of_type_JavaLangString = "none";
      }
      else
      {
        AEQLog.d("AEFilterProcessTex", "[setVideoMaterial] material is same");
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramVideoMaterial);
          this.jdField_b_of_type_JavaLangString = paramVideoMaterial.getId();
        }
      }
    }
  }
  
  public void a(AEFilterProcessTex.IEditableWatermarkMaterialRecover paramIEditableWatermarkMaterialRecover)
  {
    this.jdField_a_of_type_DovComQqImAeCameraFilterAEFilterProcessTex$IEditableWatermarkMaterialRecover = paramIEditableWatermarkMaterialRecover;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(paramRunnable);
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(paramString);
    }
  }
  
  public void a(LightAssetListener paramLightAssetListener)
  {
    AEQLog.a("AEFilterProcessTex", "setLightNodeLightAssetListener: " + paramLightAssetListener);
    this.jdField_a_of_type_OrgLightListenerLightAssetListener = paramLightAssetListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial() != null) && ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial().needFaceInfo()) || (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial().needBodyDetect()));
  }
  
  public int[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!f())
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ArrayOfInt[1] = 0;
      return this.jdField_a_of_type_ArrayOfInt;
    }
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_ComTencentFilterBaseFilter.updateMatrix(this.jdField_a_of_type_ArrayOfFloat);
    Object localObject = this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(this.k, this.g, this.h);
    if (AECameraDebug.jdField_a_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_DovComQqImAeDebugAECameraDebug.a())
      {
        this.jdField_a_of_type_DovComQqImAeDebugAECameraDebug.c();
        this.g = this.jdField_a_of_type_DovComQqImAeDebugAECameraDebug.a();
        this.h = this.jdField_a_of_type_DovComQqImAeDebugAECameraDebug.b();
      }
      localObject = this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_DovComQqImAeDebugAECameraDebug.c(), this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    }
    for (;;)
    {
      int i;
      int j;
      label217:
      Frame localFrame;
      if ((bool) && (g()))
      {
        AEDashboardUtil.a.jdField_a_of_type_Boolean = true;
        this.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_f_of_type_Int = this.jdField_b_of_type_Int;
        if (Math.abs(this.jdField_b_of_type_Double - this.jdField_a_of_type_Double) <= 0.01D) {
          break label598;
        }
        if (this.jdField_b_of_type_Double >= this.jdField_a_of_type_Double) {
          break label578;
        }
        i = this.h;
        j = (int)(i * this.jdField_b_of_type_Double);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.updateCorpRect(j, i, this.g, this.h);
        localFrame = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.RenderProcess(((Frame)localObject).getTextureId(), this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
        ((Frame)localObject).unlock();
      }
      for (;;)
      {
        try
        {
          localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.notifyDetectFaceAttr();
          if (localObject == null) {
            continue;
          }
          localList = ((PTFaceAttr)localObject).getFaceStatusList();
          if ((localList != null) && (!localList.isEmpty())) {
            continue;
          }
          this.n = -1;
        }
        catch (Throwable localThrowable)
        {
          List localList;
          label578:
          label598:
          QLog.d("AEFilterProcessTex", 1, "AEKit 渲染 start Throwable = " + localThrowable.getMessage());
          continue;
          this.n = ((FaceStatus)localThrowable.getFaceStatusList().get(0)).gender;
          continue;
          AEBaseReportParam.a().a(-1);
          continue;
          localThrowable.put("transparentMode", "0");
          continue;
        }
        AEBaseReportParam.a().a(this.n);
        i = localFrame.getTextureId();
        if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
        {
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setRotationMatrix(this.jdField_b_of_type_ArrayOfFloat);
          if (!this.jdField_d_of_type_Boolean) {
            AELaunchRecorder.a().a("filterMgrDraw-begin");
          }
          localObject = new HashMap();
          if (!paramBoolean) {
            continue;
          }
          ((HashMap)localObject).put("transparentMode", "1");
          this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateCameraConfigData((Map)localObject);
          i = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(localFrame.getTextureId(), bool, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTimestamp());
          if (!this.jdField_d_of_type_Boolean)
          {
            AELaunchRecorder.a().a("filterMgrDraw-end");
            this.jdField_d_of_type_Boolean = true;
          }
          localFrame.unlock();
        }
        a(paramInt1, paramInt2, i, paramBoolean);
        if (bool)
        {
          QLog.d("AEFilterProcessTex", 1, "in capture frame.");
          a(i, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
          this.jdField_b_of_type_Boolean = false;
        }
        FrameBufferCache.getInstance().forceRecycle();
        this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
        this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(i, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, -1, 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
        this.jdField_b_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 0);
        this.jdField_a_of_type_ArrayOfInt[0] = i;
        this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId();
        return this.jdField_a_of_type_ArrayOfInt;
        this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
        this.jdField_f_of_type_Int = this.jdField_d_of_type_Int;
        break;
        j = this.g;
        i = (int)(j / this.jdField_b_of_type_Double);
        break label217;
        j = this.g;
        i = this.h;
        break label217;
        if (localList.size() <= 1) {
          continue;
        }
        this.n = 3;
      }
    }
  }
  
  public void b()
  {
    AETipsManager.getInstance().checkVideoShowFaceView();
  }
  
  public void b(int paramInt)
  {
    p = paramInt;
    d(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    o = 0;
    p = 0;
    jdField_c_of_type_Boolean = false;
    if (paramBoolean) {
      b(null);
    }
  }
  
  public boolean b()
  {
    VideoMaterial localVideoMaterial = a();
    if (localVideoMaterial == null) {
      AEQLog.a("AEFilterProcessTex", "[isNeedFaceDetect]: false");
    }
    while ((TextUtils.isEmpty(localVideoMaterial.getDataPath())) || (!localVideoMaterial.needFaceInfo())) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    AETipsManager.getInstance().checkVideoShowBodyView();
  }
  
  public void c(boolean paramBoolean)
  {
    jdField_c_of_type_Boolean = paramBoolean;
    AEFilterProcessTex.3 local3 = new AEFilterProcessTex.3(this, paramBoolean);
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited()))
    {
      local3.run();
      return;
    }
    a(local3);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return false;
    }
    return AEStaticDetector.hasFaceData(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getFaceAttr());
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentFilterBaseFilter != null)
    {
      this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSL();
      this.jdField_a_of_type_ComTencentFilterBaseFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter.clearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterSpaceFilter = null;
    }
    if (this.jdField_b_of_type_ComTencentFilterBaseFilter != null)
    {
      this.jdField_b_of_type_ComTencentFilterBaseFilter.clearGLSL();
      this.jdField_b_of_type_ComTencentFilterBaseFilter = null;
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraFilterScaleFilter != null) {
      this.jdField_a_of_type_DovComQqImAeCameraFilterScaleFilter.clearGLSLSelf();
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter.clearGLSL();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterCropFilter = null;
    }
    if (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame != null)
    {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    if (this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame != null)
    {
      this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.destroy();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
    }
    if (this.jdField_a_of_type_DovComQqImAeGifGifFilterMgr != null)
    {
      this.jdField_a_of_type_DovComQqImAeGifGifFilterMgr.b();
      this.jdField_a_of_type_DovComQqImAeGifGifFilterMgr = null;
    }
    this.jdField_a_of_type_DovComQqImAeDebugAECameraDebug.b();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setIsAfterUpdateMaterial(paramBoolean);
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.needMaskRecordTouchPoint();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (a() != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial() != null) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getVideoMaterial().needResetWhenRecord())) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.stickerReset(true);
    }
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {}
    while ((a() == null) && (o <= 0) && (p <= 0) && (jdField_a_of_type_JavaLangString == null)) {
      return false;
    }
    return true;
  }
  
  public void f()
  {
    try
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilSet.add(this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.filter.AEFilterProcessTex
 * JD-Core Version:    0.7.0.1
 */