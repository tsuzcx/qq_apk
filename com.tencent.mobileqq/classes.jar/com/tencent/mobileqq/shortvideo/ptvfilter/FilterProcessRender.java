package com.tencent.mobileqq.shortvideo.ptvfilter;

import ahon;
import ahoo;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.opengl.effects.EffectBeautyTools;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.activity.qwallet.QWalletCameraInterface;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoConfig;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureMonitorManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.TexturePileQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetector.FACE_DETECT_MODE;
import com.tencent.ttpic.facedetect.FaceDetectorManager;
import com.tencent.ttpic.facedetect.FaceDetectorManager.FACE_DET_TYPE;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.PhoneProperty;
import com.tencent.view.RendererUtils;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.util.List;
import mqq.app.AppRuntime;

@SuppressLint({"NewApi"})
public class FilterProcessRender
{
  private double jdField_a_of_type_Double;
  public int a;
  private long jdField_a_of_type_Long;
  private ahoo jdField_a_of_type_Ahoo = new ahoo(null);
  BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame jdField_a_of_type_ComTencentFilterFrame = new Frame();
  public QWalletCameraInterface a;
  public GestureKeyInfo a;
  volatile VideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList;
  private TexturePileQueue jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue = new TexturePileQueue();
  public FaceDetector a;
  VideoFlipFilter jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter = VideoFlipFilter.createVideoFlipFilter();
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private double jdField_b_of_type_Double = 1.0D;
  public int b;
  private long jdField_b_of_type_Long;
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  Frame jdField_b_of_type_ComTencentFilterFrame = new Frame();
  public volatile boolean b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[1];
  private int jdField_c_of_type_Int;
  Frame jdField_c_of_type_ComTencentFilterFrame = new Frame();
  public boolean c;
  private int jdField_d_of_type_Int;
  Frame jdField_d_of_type_ComTencentFilterFrame = new Frame();
  public volatile boolean d;
  private int jdField_e_of_type_Int;
  private Frame jdField_e_of_type_ComTencentFilterFrame = new Frame();
  public volatile boolean e;
  private int f;
  public volatile boolean f;
  private int g;
  public volatile boolean g;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = PhoneProperty.instance().isCannotReuseFrameBuffer();
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  
  public FilterProcessRender()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector = null;
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
  
  private Frame a(Frame paramFrame)
  {
    if (paramFrame == null) {
      return null;
    }
    Frame localFrame2 = paramFrame;
    Frame localFrame1 = paramFrame;
    for (paramFrame = localFrame2; (paramFrame.nextFrame != null) && (paramFrame.nextFrame.getTextureId() != 0); paramFrame = localFrame2)
    {
      localFrame2 = paramFrame.nextFrame;
      localFrame1 = paramFrame;
    }
    localFrame1.nextFrame = null;
    return paramFrame;
  }
  
  private String a()
  {
    return a(FaceDetectorManager.FACE_DET_TYPE.YOUTU.value);
  }
  
  private String a(int paramInt)
  {
    if (paramInt == FaceDetectorManager.FACE_DET_TYPE.YOUTU.value) {
      return "TOUTU";
    }
    return "Unknown";
  }
  
  private void a(float paramFloat)
  {
    a().setBeautyLevel(MediaCodecDPC.a() * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.i("FilterBeauty", 2, "setBeautyLevel " + paramFloat + "rate : " + MediaCodecDPC.a());
    }
  }
  
  private void a(int paramInt, ahoo paramahoo)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
    int n = RetrieveDataManager.DATA_TYPE.RGBA.value;
    if (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector != null) {
      n = this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.getDataType().value;
    }
    paramahoo.jdField_a_of_type_ArrayOfByte = RetrieveDataManager.getInstance().retrieveData(n, paramInt, paramahoo.jdField_a_of_type_Int, paramahoo.jdField_b_of_type_Int);
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[doFaceDetectInitAndFlip " + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
    }
  }
  
  private void a(ahoo paramahoo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
        if (paramBoolean)
        {
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          long l1 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[doTrackProceses=" + l1 + "us] forceDetect=" + paramBoolean);
          }
          if ((paramBoolean) || (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.needDetectFace())) {
            this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.postJob(new ahon(this, paramahoo));
          }
          if (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.detectExpression(2))
          {
            this.jdField_b_of_type_Boolean = true;
            PtvFilterTimeStatistics.b(l1);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.doTrack(paramahoo.jdField_a_of_type_ArrayOfByte, paramahoo.jdField_a_of_type_Int, paramahoo.jdField_b_of_type_Int);
          continue;
        }
        this.jdField_b_of_type_Boolean = false;
      }
      catch (Throwable paramahoo)
      {
        paramahoo.printStackTrace();
        return;
      }
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
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector = FaceDetectorManager.getInstance().getCurrentFaceDetector();
    boolean bool = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
    String str;
    if ((this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector != null) && (!this.k) && (bool))
    {
      YTCommonInterface.initAuth(BaseApplicationImpl.getContext(), "youtusdk_mqq.licence", 0, true);
      str = PtvFilterSoLoad.b(VideoEnvironment.a());
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.setModelPath(str);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.init();
      this.k = true;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "mFaceDetector path:" + str);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        VideoEnvironment.a("QQFilterRenderManager", "OutOfMemoryError:", localOutOfMemoryError);
        ShortVideoExceptionReporter.a(new RuntimeException("initFaceDetector failed"));
        this.k = false;
      }
    }
  }
  
  private void h()
  {
    VideoPreviewFaceOutlineDetector.getInstance().clearActionCounter();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null)
    {
      if (VideoMaterialUtil.isCosMaterial(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a())) {
        VideoPreviewFaceOutlineDetector.getInstance().setRefine(true);
      }
    }
    else {
      return;
    }
    VideoPreviewFaceOutlineDetector.getInstance().setRefine(false);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentFilterFrame.getLastRenderTextureId();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, FramePerformanceMonitor paramFramePerformanceMonitor, boolean paramBoolean3)
  {
    return a(paramInt1, paramInt2, paramInt3, this.jdField_a_of_type_Boolean, paramBoolean1, true, paramBoolean2, paramFramePerformanceMonitor, paramBoolean3);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, FramePerformanceMonitor paramFramePerformanceMonitor, boolean paramBoolean5)
  {
    long l1 = PtvFilterUtils.a();
    PtvFilterTimeStatistics.a();
    Object localObject1 = new float[16];
    Matrix.setIdentityM((float[])localObject1, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.nativeUpdateMatrix((float[])localObject1);
    Object localObject2 = VideoFilterTools.a().a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    PtvFilterTimeStatistics.jdField_a_of_type_Boolean = paramBoolean4;
    boolean bool1 = a((FilterRender)localObject2);
    boolean bool2 = b((FilterRender)localObject2);
    int n;
    if ((paramBoolean4) && (this.jdField_a_of_type_Boolean) && (bool1) && (paramBoolean1))
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      n = a(bool2, paramInt3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[BeautyTime1=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
      }
      if (n != -1) {
        this.jdField_a_of_type_ArrayOfInt[2] = n;
      }
      n = this.jdField_a_of_type_ArrayOfInt[2];
      paramBoolean4 = true;
    }
    for (;;)
    {
      g();
      if (((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (paramBoolean2)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface != null))
      {
        if (paramBoolean4) {
          break label1871;
        }
        if ((this.jdField_a_of_type_Boolean) && (bool1) && (paramBoolean1))
        {
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          n = a(bool2, paramInt3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[BeautyTime1=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
          }
          if (n != -1) {
            this.jdField_a_of_type_ArrayOfInt[2] = n;
          }
          n = this.jdField_a_of_type_ArrayOfInt[2];
          paramBoolean1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
        BaseFilter localBaseFilter = this.jdField_a_of_type_ComTencentFilterBaseFilter.getmNextFilter();
        this.jdField_a_of_type_ComTencentFilterBaseFilter.removeTheFilter(localBaseFilter);
        this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.RenderProcess(n, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Double, this.jdField_c_of_type_ComTencentFilterFrame);
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[mFlipFrame=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
        }
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_Ahoo.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
          this.jdField_a_of_type_Ahoo.jdField_b_of_type_Int = this.jdField_f_of_type_Int;
          if (this.k)
          {
            a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Ahoo);
            a(this.jdField_a_of_type_Ahoo, false);
          }
        }
        if (this.jdField_e_of_type_Boolean)
        {
          GestureMonitorManager.a().e();
          GestureMgrRecognize.a().a(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          localObject1 = GestureMgrRecognize.a().a();
          if ((localObject1 != null) && (((GestureKeyInfo)localObject1).jdField_a_of_type_Boolean) && (((GestureKeyInfo)localObject1).jdField_a_of_type_JavaLangString.equalsIgnoreCase(GestureFilterManager.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = ((GestureKeyInfo)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo.jdField_a_of_type_Long = System.currentTimeMillis();
          }
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo != null) {
            break label1611;
          }
          this.jdField_f_of_type_Boolean = false;
          label619:
          GestureMonitorManager.a().f();
          if ((this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
          {
            GestureRecognitionUtils.a(this.jdField_f_of_type_Boolean);
            QLog.d("GestureTestUse", 2, "we have record sucess result");
          }
          if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo == null)) {}
        }
        int i1 = 0;
        localObject1 = null;
        if (this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector != null)
        {
          i1 = this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.getFaceCount();
          localObject1 = this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector.getAllFaces();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getFaceCount faceCount=" + i1 + "] detectType=" + a());
        }
        label754:
        long l2;
        if (i1 > 0)
        {
          paramBoolean4 = true;
          NewFlowCameraActivity.jdField_a_of_type_Boolean = paramBoolean4;
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface != null) && (this.jdField_c_of_type_Int != 0) && (localObject1 != null)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletQWalletCameraInterface.a(i1, paramInt1, paramInt2, paramInt1 * 1.0F / this.jdField_c_of_type_Int / VideoMaterialUtil.SCALE_FACE_DETECT, (List)localObject1);
          }
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[onCameraCallBack<Qzone> steptime=" + l2 + "us]");
          }
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          n = this.jdField_a_of_type_ArrayOfInt[0];
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a().isSupportLandscape();
            n = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a(this.jdField_c_of_type_ComTencentFilterFrame.getFBO(), this.jdField_c_of_type_ComTencentFilterFrame.getTextureId(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, VideoMaterialUtil.SCALE_FACE_DETECT, this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector, System.currentTimeMillis()).getTextureId();
          }
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<TempFrame> steptime=" + l2 + "us]");
          }
          this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.RenderProcess(n, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_Double, this.jdField_d_of_type_ComTencentFilterFrame);
          int i2 = this.jdField_a_of_type_ArrayOfInt[1];
          n = i2;
          if (localObject2 != null)
          {
            n = i2;
            if (paramBoolean3) {
              n = ((FilterRender)localObject2).process(i2, -1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int).getTextureId();
            }
          }
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (!paramBoolean5) {
            break label1651;
          }
          localBaseFilter.RenderProcess(n, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, -2, this.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentFilterFrame);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentFilterBaseFilter.setNextFilter(localBaseFilter, null);
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<filterDrawTexture> steptime=" + l2 + "us] faceCount=" + i1);
          }
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<DrawWindow>  afterChange=" + this.i);
          }
          if (paramBoolean5)
          {
            if (!this.i) {
              break label1809;
            }
            this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_e_of_type_ComTencentFilterFrame.getTextureId(), paramInt1, paramInt2, 0, this.jdField_a_of_type_Double, this.jdField_b_of_type_ComTencentFilterFrame);
            this.jdField_e_of_type_ComTencentFilterFrame.clear();
            this.i = false;
            label1294:
            paramInt3 = a();
          }
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderOperation<DrawWindow> steptime=" + l2 + "us]");
          }
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (this.jdField_h_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentFilterFrame.clear();
            this.jdField_c_of_type_ComTencentFilterFrame.clear();
            this.jdField_d_of_type_ComTencentFilterFrame.clear();
          }
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[ReuseFrameBuffer=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us] cannotReuseFrameBuffer=" + this.jdField_h_of_type_Boolean);
          }
          l1 = (PtvFilterUtils.a() - l1) / 1000L;
          if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) || (!paramBoolean2)) {
            break label1837;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a();
          localObject1 = "";
          if (localObject2 != null) {
            localObject1 = ((VideoMaterial)localObject2).getId();
          }
          PtvFilterTimeStatistics.a((String)localObject1, l1);
          label1515:
          paramInt1 = this.jdField_h_of_type_Int + 1;
          this.jdField_h_of_type_Int = paramInt1;
          if (paramInt1 >= 20)
          {
            if ((!paramBoolean1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList == null) && (paramFramePerformanceMonitor != null)) {
              paramFramePerformanceMonitor.a(l1 / 1000L);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) {
              break label1845;
            }
            paramFramePerformanceMonitor = null;
            label1572:
            if (FlowCameraConstant.jdField_a_of_type_Int != 2) {
              break label1860;
            }
            localObject1 = "back";
            label1584:
            NewFlowCameraReporter.a((String)localObject1, paramBoolean1, paramFramePerformanceMonitor, l1 / 1000L);
          }
          return paramInt3;
          n = paramInt3;
          paramBoolean1 = paramBoolean4;
          break;
          label1611:
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo.jdField_a_of_type_Long + 2000L >= System.currentTimeMillis())
          {
            this.jdField_f_of_type_Boolean = true;
            break label619;
          }
          this.jdField_f_of_type_Boolean = false;
          break label619;
          paramBoolean4 = false;
          break label754;
          label1651:
          paramInt3 = n;
        }
        if ((localObject2 != null) && (paramBoolean3)) {
          n = ((FilterRender)localObject2).process(n, -1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int).getTextureId();
        }
        for (;;)
        {
          NewFlowCameraActivity.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (paramBoolean5) {
            this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(n, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, -2, this.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentFilterFrame);
          }
          for (;;)
          {
            this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
            l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<NofilterDrawTexture>=" + l2 + "us]");
            }
            PtvFilterTimeStatistics.c(l2);
            paramBoolean1 = paramBoolean4;
            break;
            paramInt3 = n;
          }
          label1809:
          this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentFilterFrame.getLastRenderTextureId(), paramInt1, paramInt2, 0, this.jdField_a_of_type_Double, this.jdField_b_of_type_ComTencentFilterFrame);
          break label1294;
          label1837:
          PtvFilterTimeStatistics.d(l1);
          break label1515;
          label1845:
          paramFramePerformanceMonitor = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a().getId();
          break label1572;
          label1860:
          localObject1 = "front";
          break label1584;
        }
        label1871:
        paramBoolean1 = paramBoolean4;
      }
      paramBoolean4 = false;
      n = paramInt3;
    }
  }
  
  public BeautyRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(BaseApplicationImpl.context, EffectBeautyTools.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  }
  
  public TexturePileQueue a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue;
  }
  
  public void a()
  {
    a(null, false);
    FaceDetectorManager.getInstance().destroy();
    this.jdField_a_of_type_ComTencentTtpicFacedetectFaceDetector = null;
    this.k = false;
    this.l = false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ApplyGLSLFilter(true, paramInt1, paramInt2);
  }
  
  public void a(VideoFilterList paramVideoFilterList, boolean paramBoolean)
  {
    this.i = true;
    this.jdField_e_of_type_ComTencentFilterFrame = a(this.jdField_a_of_type_ComTencentFilterFrame);
    this.jdField_e_of_type_ComTencentFilterFrame.nextFrame = null;
    if ((this.jdField_e_of_type_ComTencentFilterFrame != this.jdField_a_of_type_ComTencentFilterFrame) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentFilterFrame.clear();
    }
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a()))
    {
      GestureMgrRecognize.a().b();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.b();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = null;
      this.jdField_g_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("GestureTestUse", 2, "have run destroy here");
      }
    }
    h();
    if ((paramVideoFilterList != null) && (paramVideoFilterList.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = paramVideoFilterList;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.d();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Double);
    }
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
  
  public void b()
  {
    c();
    FaceDetectorManager.getInstance().destroy();
    this.k = false;
    this.l = false;
    VideoPreviewFaceOutlineDetector.getInstance().setFaceDetectMode(FaceDetector.FACE_DETECT_MODE.MULTIPLE);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue.a();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setNextFilter(this.jdField_b_of_type_ComTencentFilterBaseFilter, null);
    this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ApplyGLSLFilter();
    a(true, 0.0F);
    RendererUtils.setEnableLog(false);
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
    GestureMgrRecognize.a().a(i1);
    GestureMgrRecognize.a().b(i2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    float f1 = VideoEnvironment.a.a;
    if (Math.max(paramInt1, paramInt2) < 960) {
      f1 = 1.0F;
    }
    this.jdField_a_of_type_Int = ((int)(paramInt1 * f1));
    this.jdField_b_of_type_Int = ((int)(f1 * paramInt2));
    this.jdField_e_of_type_Int = ((int)(this.jdField_a_of_type_Int * VideoMaterialUtil.SCALE_FACE_DETECT));
    this.jdField_f_of_type_Int = ((int)(this.jdField_b_of_type_Int * VideoMaterialUtil.SCALE_FACE_DETECT));
    this.jdField_g_of_type_Int = (this.jdField_e_of_type_Int * this.jdField_f_of_type_Int * 4);
    this.jdField_b_of_type_Double = (paramInt1 / paramInt1);
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Double);
    }
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "updatePreviewSize:: width=" + paramInt1 + ";height=" + paramInt2 + ";widthFilter=" + this.jdField_a_of_type_Int + ";heightFilter=" + this.jdField_b_of_type_Int + ";mFaceDetectWidth" + this.jdField_e_of_type_Int + ";mFaceDetectHeight=" + this.jdField_f_of_type_Int);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (this.jdField_e_of_type_Boolean)
    {
      GestureMgrRecognize.a().a();
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    GestureMgrRecognize.a().b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentFilterFrame.clear();
    this.jdField_b_of_type_ComTencentFilterFrame.clear();
    this.jdField_c_of_type_ComTencentFilterFrame.clear();
    this.jdField_d_of_type_ComTencentFilterFrame.clear();
    this.jdField_e_of_type_ComTencentFilterFrame.clear();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.ClearGLSL();
    this.jdField_a_of_type_ComTencentTtpicFilterVideoFlipFilter.ClearGLSL();
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTexturePileQueue.b();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.b();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(null, true);
    b(paramInt1, paramInt2);
    this.j = true;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.c();
    }
  }
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender
 * JD-Core Version:    0.7.0.1
 */