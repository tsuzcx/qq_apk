package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.AVPathUtil;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.activity.qwallet.QWalletCameraInterface;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.TexturePileQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.util.PhoneProperty;
import com.tencent.ytcommon.util.YTCommonInterface;
import dov.com.qq.im.ae.download.AEResUtil;
import mqq.app.AppRuntime;

@SuppressLint({"NewApi"})
public class FilterProcessRender
{
  private double jdField_a_of_type_Double = 0.0D;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public QWalletCameraInterface a;
  public GestureKeyInfo a;
  private FilterProcessRender.FaceDetectParam jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender$FaceDetectParam = new FilterProcessRender.FaceDetectParam(null);
  private TexturePileQueue jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue = new TexturePileQueue();
  private PTFaceAttr jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr;
  PTFaceDetector jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector = null;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private double jdField_b_of_type_Double;
  public int b;
  private long jdField_b_of_type_Long = 0L;
  Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public volatile boolean b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[1];
  private double jdField_c_of_type_Double;
  private int jdField_c_of_type_Int;
  Frame jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  BaseFilter jdField_c_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public boolean c;
  private double jdField_d_of_type_Double = 1.0D;
  private int jdField_d_of_type_Int;
  Frame jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  public volatile boolean d;
  private int jdField_e_of_type_Int = 0;
  private Frame jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  public volatile boolean e;
  private int f;
  public volatile boolean f;
  private int g;
  public volatile boolean g;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = PhoneProperty.instance().isCannotReuseFrameBuffer();
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int = 0;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = 0;
  private boolean jdField_k_of_type_Boolean = false;
  private boolean l = false;
  private boolean m = true;
  
  public FilterProcessRender()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = null;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
  }
  
  private int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int n = -1;
    BeautyRender localBeautyRender = a();
    if (localBeautyRender != null)
    {
      if (!paramBoolean) {
        break label42;
      }
      localBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      n = localBeautyRender.process(paramInt1, -1, paramInt2, paramInt3).getTextureId();
      return n;
      label42:
      localBeautyRender.setNeedSkinColor(true);
    }
  }
  
  private void a(float paramFloat)
  {
    a().setBeautyLevel(MediaCodecDPC.a() * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.i("FilterBeauty", 2, "setBeautyLevel " + paramFloat + "rate : " + MediaCodecDPC.a());
    }
  }
  
  private boolean a(FilterRender paramFilterRender)
  {
    if (!MediaCodecDPC.b()) {
      return false;
    }
    if (VideoFilterTools.b())
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramFilterRender != null) {
        if (paramFilterRender.getFilterType() != 3)
        {
          bool1 = bool2;
          if (!VideoFilterTools.a().c()) {}
        }
        else
        {
          bool1 = false;
        }
      }
      return bool1;
    }
    QLog.e("filterbeauty", 2, "checkSkinColorAvailable false");
    return false;
  }
  
  private boolean b(FilterRender paramFilterRender)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFilterRender != null) {
      if (paramFilterRender.getFilterType() != 1)
      {
        bool1 = bool2;
        if (paramFilterRender.getFilterType() != 2) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void h()
  {
    boolean bool = AEResUtil.e();
    String str;
    if ((!this.jdField_k_of_type_Boolean) && (bool))
    {
      YTCommonInterface.initAuthForQQ(BaseApplicationImpl.getContext());
      str = AEResUtil.b();
      if (!TextUtils.isEmpty(str)) {
        FeatureManager.setModelDir(str);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector = new PTFaceDetector();
      this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector.init();
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "mFaceDetector path:" + str);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        VideoEnvironment.LogDownLoad("QQFilterRenderManager", "OutOfMemoryError:", localOutOfMemoryError);
        ShortVideoExceptionReporter.a(new RuntimeException("initFaceDetector failed"));
        this.jdField_k_of_type_Boolean = false;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getLastRenderTextureId();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, FramePerformanceMonitor paramFramePerformanceMonitor, boolean paramBoolean3)
  {
    return a(paramInt1, paramInt2, paramInt3, this.jdField_a_of_type_Boolean, paramBoolean1, true, paramBoolean2, paramFramePerformanceMonitor, paramBoolean3);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, FramePerformanceMonitor paramFramePerformanceMonitor, boolean paramBoolean5)
  {
    long l1 = PtvFilterUtils.a();
    PtvFilterTimeStatistics.a();
    paramFramePerformanceMonitor = new float[16];
    Matrix.setIdentityM(paramFramePerformanceMonitor, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.updateMatrix(paramFramePerformanceMonitor);
    paramFramePerformanceMonitor = VideoFilterTools.a().a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    PtvFilterTimeStatistics.jdField_a_of_type_Boolean = paramBoolean4;
    paramBoolean2 = a(paramFramePerformanceMonitor);
    paramBoolean3 = b(paramFramePerformanceMonitor);
    if ((paramBoolean4) && (this.jdField_a_of_type_Boolean) && (paramBoolean2) && (paramBoolean1))
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      int n = a(paramBoolean3, paramInt3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[BeautyTime1=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
      }
      if (n != -1) {
        this.jdField_a_of_type_ArrayOfInt[2] = n;
      }
      n = this.jdField_a_of_type_ArrayOfInt[2];
    }
    h();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<DrawWindow>  afterChange=" + this.jdField_i_of_type_Boolean);
    }
    if (paramBoolean5)
    {
      if (!this.jdField_i_of_type_Boolean) {
        break label470;
      }
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), paramInt1, paramInt2, 0, this.jdField_a_of_type_Double, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
      this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      this.jdField_i_of_type_Boolean = false;
    }
    for (;;)
    {
      paramInt3 = a();
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      long l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderOperation<DrawWindow> steptime=" + l2 + "us]");
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
        this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
        this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
      }
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[ReuseFrameBuffer=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us] cannotReuseFrameBuffer=" + this.jdField_h_of_type_Boolean);
      }
      l1 = (PtvFilterUtils.a() - l1) / 1000L;
      return paramInt3;
      label470:
      this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getLastRenderTextureId(), paramInt1, paramInt2, 0, this.jdField_a_of_type_Double, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
    }
  }
  
  public BeautyRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(BaseApplicationImpl.context, AVPathUtil.i());
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  }
  
  public TexturePileQueue a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector = null;
    }
    this.jdField_k_of_type_Boolean = false;
    this.l = false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    if (paramBoolean)
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramFloat = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0).getInt("beauty_level" + str, (int)(NewFlowCameraActivity.b * 100.0F)) / 100.0F;
    }
    a(paramFloat);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr != null) {
      return this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getFaceCount();
    }
    return 0;
  }
  
  public void b()
  {
    c();
    this.jdField_k_of_type_Boolean = false;
    this.l = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue.a();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setNextFilter(this.jdField_b_of_type_ComTencentFilterBaseFilter, null);
    this.jdField_c_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_c_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    a(true, 0.0F);
    n = 200;
    i3 = 5;
    try
    {
      i1 = Integer.parseInt(PtvTemplateManager.h);
      n = i1;
      i2 = Integer.parseInt(PtvTemplateManager.g);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i2 = i3;
        int i1 = n;
        if (QLog.isColorLevel())
        {
          QLog.d("GestureTestUse", 2, "GestureMgr.getInstance().setRecognizeMillis number exception" + n);
          i2 = i3;
          i1 = n;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GestureTestUse", 2, "PtvTemplateManager.mGestureGapTime raw value " + PtvTemplateManager.h + ":GestureMgr.getInstance().setRecognizeMillis normal result" + i1 + ",frameRate is:" + i2);
    }
    GestureMgrRecognize.getInstance().setRecognizeMillis(i1);
    GestureMgrRecognize.getInstance().setRecognizeFrameRate(i2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = ((int)(paramInt1 * 1.0F));
    this.jdField_b_of_type_Int = ((int)(1.0F * paramInt2));
    this.jdField_b_of_type_Double = (paramInt1 / paramInt2);
    this.jdField_c_of_type_Double = (FaceDetector.FACE_DETECT_WIDTH / this.jdField_a_of_type_Int);
    this.jdField_e_of_type_Int = ((int)(this.jdField_a_of_type_Int * this.jdField_c_of_type_Double));
    this.jdField_f_of_type_Int = ((int)(this.jdField_b_of_type_Int * this.jdField_c_of_type_Double));
    this.jdField_g_of_type_Int = (this.jdField_e_of_type_Int * this.jdField_f_of_type_Int * 4);
    this.jdField_d_of_type_Double = (paramInt1 / paramInt1);
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "updatePreviewSize:: width=" + paramInt1 + ";height=" + paramInt2 + ";widthFilter=" + this.jdField_a_of_type_Int + ";heightFilter=" + this.jdField_b_of_type_Int + ";mFaceDetectWidth" + this.jdField_e_of_type_Int + ";mFaceDetectHeight=" + this.jdField_f_of_type_Int);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSL();
    this.jdField_c_of_type_ComTencentFilterBaseFilter.clearGLSL();
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue.b();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    VideoFilterTools.a().c();
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
  }
  
  public void g()
  {
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender
 * JD-Core Version:    0.7.0.1
 */