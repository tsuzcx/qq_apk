package dov.com.qq.im.ae.camera.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.MainThread;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.MaterialInnerEffectListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.AudioCaptureListener;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.SensorUtil2;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.camera.AECaptureParam;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex.CapturePhotoListener;
import dov.com.qq.im.ae.camera.filter.FilterProcessBase;
import dov.com.qq.im.ae.camera.filter.NonAEFilterProcess;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView.AEEditMaterialSelectedListener;
import dov.com.qq.im.ae.camera.ui.dashboard.AEDashboardUtil;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.IDebugInfoCallback;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.camera.util.AEOrientationEventListener;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.gif.AEExpressionRecognizer;
import dov.com.qq.im.ae.gif.AEExpressionRecognizer.RecommendTextCallback;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment;
import dov.com.qq.im.ae.perf.AEFpsManager;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.qq.im.ae.perf.IAEFpsManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoVoiceRecognizer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;
import org.light.device.LightDeviceUtils;
import org.light.utils.MustRunOnGLThread;

@TargetApi(17)
public class AECameraGLSurfaceView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, SensorEventListener, GLSurfaceView.Renderer, AudioCapture.AudioCaptureListener, HWEncodeListener, AEFilterProcessTex.CapturePhotoListener
{
  private static final long GIF_SKIP_FRAME_INTERVAL = 83L;
  private static final int GIF_WANTED_SIZE = 640;
  private static final int MAX_PREVIEW_WIDTH = 720;
  private static final int RECORDING_OFF = 0;
  private static final int RECORDING_ON = 1;
  private static final String TAG = "AECameraGLSurfaceView";
  private static volatile boolean isSdkInited = false;
  private int activityOrientation = 0;
  private AECaptureParam aeCaptureParam;
  private AEBottomListScrollView.AEEditMaterialSelectedListener aeEditMaterialSelectedListener;
  private AEExpressionRecognizer aeExpressionRecognizer;
  private AECameraGLSurfaceView.AEGLSurfaceListener aeGLSurfaceListener;
  protected AudioCapture audioCapture;
  private boolean beautyEnable = true;
  protected AECameraGLSurfaceView.CaptureListener captureListener;
  public AEVideoStoryDashboardPart.IDebugInfoCallback debugInfoCallback;
  private int drawFrameCount = 0;
  protected AECameraGLSurfaceView.AEEffectListener effectListener;
  private EGLContext eglContext;
  private EncodeConfig encodeConfig;
  private boolean faceEffectEnable = true;
  private boolean filterEnable = true;
  private boolean firstFrameActionDone;
  private IAEFpsManager fpsReporter = new AEFpsManager();
  private int gifPreviewHeight;
  private int gifPreviewWidth;
  private long gifRecordFrameIndex = 0L;
  private long gifRecordStartTimestamp = 0L;
  private HWVideoRecorder hwVideoRecorder;
  private boolean isDynamicResolutionMode;
  protected boolean isFirstFrame = true;
  private boolean isGIFMode = false;
  private boolean isInit = false;
  private boolean isNeedVoiceEncode = false;
  private boolean isPaused = true;
  private boolean lastDetected = false;
  private boolean logTillHaveFrame = true;
  private AECameraGLSurfaceView.AEKitInitListener mAEKitInitListener;
  private Sensor mAccelerometer;
  private AECaptureController mController;
  private FilterProcessBase mFilterProcess;
  private volatile boolean mHaveFrame = false;
  private final int mIdentityHashCode;
  private volatile boolean mIsTryLocationPermission = false;
  private VideoMaterial mLastVideoMaterial = null;
  private Runnable mOnFrameDrawCallback;
  private AEOrientationEventListener mOrientationEventListener;
  private volatile boolean mPendingReqLocationPermission = false;
  private int mRecordingStatus;
  private float[] mSensorRotationMatrix = new float[16];
  protected int mSurfaceHeight = 480;
  protected int mSurfaceWidth = 320;
  private PointF mTouchStartPoint = new PointF(0.0F, 0.0F);
  private boolean needFace = false;
  private int notDetectedTimes = 0;
  private boolean onFrameAvailableLogged = false;
  private int orientation = 90;
  protected boolean pauseFilterChainWhenCapture = true;
  private boolean preExtractFrame;
  protected AEExpressionRecognizer.RecommendTextCallback recommendTextCallback;
  private volatile boolean recordingEnabled;
  protected int selectedCamera = 2;
  SensorManager sensorManager;
  private volatile SensorUtil2 sensorUtil;
  private boolean sharpFaceEnable = true;
  private int smoothLevel = 0;
  protected AEFilterManager.MaterialInnerEffectListener stickerInnerLutFilterListener;
  private boolean useVideoOrientation = true;
  private AEVideoCaptureResult videoCaptureResult;
  private int videoHeight;
  private int videoWidth;
  private ShortVideoVoiceRecognizer voiceRecognizer = new ShortVideoVoiceRecognizer();
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    initEGL();
    this.mIdentityHashCode = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AELaunchRecorder.a().a("glSurfaceViewConstruct-begin");
    initEGL();
    this.mIdentityHashCode = System.identityHashCode(this);
    AELaunchRecorder.a().a("glSurfaceViewConstruct-end");
  }
  
  private void addAEInitQueue(Runnable paramRunnable)
  {
    if (isAEKitAvailable()) {
      ((AEFilterProcessTex)this.mFilterProcess).a(paramRunnable);
    }
  }
  
  private boolean checkLocationPermissionGranted()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
      return true;
    }
    return false;
  }
  
  private void checkShowTips()
  {
    if ((this.mFilterProcess != null) && (((AEFilterProcessTex)this.mFilterProcess).a()))
    {
      ((AEFilterProcessTex)this.mFilterProcess).b();
      ((AEFilterProcessTex)this.mFilterProcess).c();
    }
  }
  
  private void collectDebugResolutionInfo(int paramInt1, int paramInt2) {}
  
  private void createFilterProcess()
  {
    if (this.mFilterProcess != null) {
      return;
    }
    AEQLog.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    if ((AEKitForQQ.a()) && (FeatureManager.loadBasicFeatures()))
    {
      this.mFilterProcess = new AEFilterProcessTex(this.mIdentityHashCode);
      ((AEFilterProcessTex)this.mFilterProcess).a(new AECameraGLSurfaceView.6(this));
      AEQLog.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.mFilterProcess = new NonAEFilterProcess();
    AEQLog.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
  }
  
  private void destroyFilterProcess()
  {
    if (this.mFilterProcess != null)
    {
      this.mFilterProcess.h();
      this.mFilterProcess = null;
      if (this.aeGLSurfaceListener != null) {
        this.aeGLSurfaceListener.onPreviewSurfaceTextureRelease();
      }
    }
    AEFilterManagerHolder.setFilterProcess(null);
  }
  
  private void drawToMediaCodec(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    long l = SystemClock.elapsedRealtimeNanos();
    if ((isAEKitAvailable()) && (isRecordingGIF()))
    {
      drawToMediaCodecGif(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l);
      return;
    }
    frameToMediaCodecVideo(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, l);
  }
  
  private void drawToMediaCodecGif(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.mFilterProcess == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (AEFilterProcessTex)this.mFilterProcess;
      if (this.gifRecordStartTimestamp == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.gifRecordStartTimestamp = paramLong;
        AEGIFChunkPreviewFragment.a = new ArrayList();
      }
      paramInt2 = ((AEFilterProcessTex)localObject).a(paramInt2);
    } while ((paramLong - this.gifRecordStartTimestamp) / 1000000L <= 83L * this.gifRecordFrameIndex);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.gifRecordFrameIndex) });
    this.gifRecordFrameIndex += 1L;
    if (((AEFilterProcessTex)localObject).a() != null)
    {
      localObject = ((AEFilterProcessTex)localObject).a();
      AEGIFChunkPreviewFragment.a.add(localObject);
    }
    frameToMediaCodecVideo(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void finishCapturePhoto(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    if (this.captureListener != null) {
      this.captureListener.onPhotoCaptured(paramAEPhotoCaptureResult);
    }
  }
  
  private float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private int[] getPreviewSize(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    if (this.isGIFMode)
    {
      arrayOfInt = CaptureUtil.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, 1.0F);
      return CaptureUtil.a(640, arrayOfInt[0], arrayOfInt[1]);
    }
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt2 > 720)
    {
      i = (int)(720.0F / paramInt1 * paramInt2);
      j = 720;
    }
    arrayOfInt[0] = j;
    arrayOfInt[1] = i;
    return arrayOfInt;
  }
  
  private void initEGL()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new AECameraGLSurfaceView.3(this));
    setPreserveEGLContextOnPause(false);
    setRenderer(this);
    setRenderMode(0);
    preAction();
  }
  
  private void initFilterProcess()
  {
    AELaunchRecorder.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.mFilterProcess == null)
    {
      Log.d("AECameraGLSurfaceView", "initFilterProcess: mFilterProcess==null, createFilterProcess");
      createFilterProcess();
    }
    initOrientationEventListener();
    if ((this.mFilterProcess instanceof AEFilterProcessTex))
    {
      AEFilterManagerHolder.setFilterProcess((AEFilterProcessTex)this.mFilterProcess);
      if (this.mAEKitInitListener != null) {
        this.mAEKitInitListener.onAEKitInited();
      }
      ((AEFilterProcessTex)this.mFilterProcess).a(this.stickerInnerLutFilterListener);
      ((AEFilterProcessTex)this.mFilterProcess).a(new AECameraGLSurfaceView.7(this));
      ((AEFilterProcessTex)this.mFilterProcess).a(new AECameraGLSurfaceView.8(this));
    }
    SurfaceTexture localSurfaceTexture = this.mFilterProcess.a();
    localSurfaceTexture.setOnFrameAvailableListener(this);
    if (this.aeGLSurfaceListener != null) {
      this.aeGLSurfaceListener.onPreviewSurfaceTextureCreate(localSurfaceTexture);
    }
    AELaunchRecorder.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void initOrientationEventListener()
  {
    this.mOrientationEventListener = new AECameraGLSurfaceView.15(this, getContext());
    if (this.mOrientationEventListener.canDetectOrientation()) {
      this.mOrientationEventListener.enable();
    }
  }
  
  public static void initSdk()
  {
    try
    {
      AEQLog.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + isSdkInited);
      long l = System.currentTimeMillis();
      if (!isSdkInited)
      {
        AEQLog.b("AECameraGLSurfaceView", "[initSdk] do init");
        isSdkInited = true;
        AELaunchRecorder.a().a("glSurfaceViewStaticInit-begin");
        boolean bool = AEKitForQQ.a();
        AEQLog.b("AECameraGLSurfaceView", "[initSdk] , AEKitForQQ.init result = " + bool);
        if (bool) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.getPtvTemplateSDKPref());
        }
        AELaunchRecorder.a().a("glSurfaceViewStaticInit-end");
      }
      AEQLog.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l));
      return;
    }
    finally {}
  }
  
  private void initVideoSize(int paramInt1, int paramInt2)
  {
    int i = (int)(this.mSurfaceHeight * 1.0F / this.mSurfaceWidth * this.aeCaptureParam.c());
    if (DovSVParamManager.a().c()) {
      i = this.aeCaptureParam.b();
    }
    if (this.isDynamicResolutionMode)
    {
      arrayOfInt = CaptureUtil.a(i, paramInt1, paramInt2);
      arrayOfInt = CaptureUtil.a(arrayOfInt[0], arrayOfInt[1], this.aeCaptureParam.d(), this.aeCaptureParam.e(), 1.0F);
      this.videoWidth = arrayOfInt[0];
      this.videoHeight = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = CaptureUtil.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, this.aeCaptureParam.a());
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
    arrayOfInt = CaptureUtil.a(i, this.videoWidth, this.videoHeight);
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
  }
  
  private boolean isAEKitAvailable()
  {
    return (AEResUtil.a()) && (this.mFilterProcess != null) && ((this.mFilterProcess instanceof AEFilterProcessTex));
  }
  
  private boolean isFromCircle()
  {
    if ((getContext() instanceof Activity)) {
      return AECameraEntry.k(((Activity)getContext()).getIntent());
    }
    return false;
  }
  
  private boolean isFrontCamera()
  {
    return this.selectedCamera == 1;
  }
  
  private boolean isRecordingGIF()
  {
    return (this.isGIFMode) && (this.recordingEnabled) && (this.encodeConfig != null);
  }
  
  private void notifyDetectChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.effectListener != null) {
      this.effectListener.onDetectStateChange(paramBoolean1, paramBoolean2);
    }
  }
  
  private void preAction()
  {
    AEQLog.b("AECameraGLSurfaceView", "preAction");
    if (!isSdkInited) {
      initSdk();
    }
    try
    {
      this.sensorUtil = new SensorUtil2();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void preInflateInCircleCamera()
  {
    if ((!this.firstFrameActionDone) && (isFromCircle()) && (this.aeGLSurfaceListener != null)) {
      this.aeGLSurfaceListener.onFirstFrameDone();
    }
  }
  
  @MustRunOnGLThread
  private void prepareWMData(Map<String, String> paramMap)
  {
    if (!(this.mFilterProcess instanceof AEFilterProcessTex)) {}
    for (;;)
    {
      return;
      AEFilterManager localAEFilterManager = ((AEFilterProcessTex)this.mFilterProcess).a();
      if (localAEFilterManager == null) {
        continue;
      }
      AEQLog.b("AECameraGLSurfaceView", "prepareWMData: watermarkDict=" + paramMap);
      localAEFilterManager.wmAddInfoDict(paramMap);
      Object localObject2 = (String)paramMap.get("City");
      String str = (String)paramMap.get("Road");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = localStringBuilder.append((String)localObject1);
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = (String)localObject1;
      AEQLog.b("AECameraGLSurfaceView", "[prepareWMData] location : " + (String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localAEFilterManager.wmSetLocation((String)localObject1);
      }
      localObject1 = (String)paramMap.get("WeatherType");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        localAEFilterManager.wmSetWeatherCode(Integer.parseInt((String)localObject1));
        localObject1 = (String)paramMap.get("Weather");
        if (localObject1 != null) {
          localAEFilterManager.wmSetWeatherStr((String)localObject1);
        }
        paramMap = (String)paramMap.get("TempCurr");
        if (paramMap == null) {
          continue;
        }
        localAEFilterManager.wmSetTemperature(paramMap.replace(HardCodeUtil.a(2131716708), ""));
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          AEQLog.a("AECameraGLSurfaceView", localNumberFormatException);
        }
      }
    }
  }
  
  private void recordGifFrames(int paramInt)
  {
    if ((isRecordingGIF()) && (this.gifRecordStartTimestamp > 0L))
    {
      Object localObject = (AEFilterProcessTex)this.mFilterProcess;
      if (this.aeExpressionRecognizer == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.aeExpressionRecognizer = new AEExpressionRecognizer();
        this.aeExpressionRecognizer.a();
      }
      long l = (SystemClock.elapsedRealtimeNanos() - this.gifRecordStartTimestamp) / 1000000L;
      int i = this.aeExpressionRecognizer.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i);
      if ((i < 3) && ((float)l > (i + 0.5F) * 1000.0F) && (((AEFilterProcessTex)localObject).c()))
      {
        localObject = ((AEFilterProcessTex)localObject).a();
        this.aeExpressionRecognizer.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), this.gifPreviewWidth, this.gifPreviewHeight);
      }
    }
  }
  
  private void recoverAudioCapture()
  {
    if ((this.mLastVideoMaterial != null) && (this.mLastVideoMaterial.isAudio2textMaterial())) {
      this.voiceRecognizer.a(getContext(), this.audioCapture);
    }
  }
  
  @MainThread
  private void reqLocationPermissionAndReqWMDict()
  {
    AEQLog.b("AECameraGLSurfaceView", "reqLocationPermissionAndReqWMDict");
    new LocationPermissionHelper((Activity)getContext(), new AECameraGLSurfaceView.19(this)).a();
  }
  
  private void requestWMDict()
  {
    WatermarkDataManager.a().a(new AECameraGLSurfaceView.20(this));
  }
  
  private void setTipsHandler(AEFilterProcessTex paramAEFilterProcessTex)
  {
    if (this.effectListener != null) {
      this.effectListener.onSetFilterProcess(paramAEFilterProcessTex);
    }
  }
  
  private void showToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.16(this, paramString));
  }
  
  private short[] toShortArray(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length >> 1;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | paramArrayOfByte[(i * 2 + 1)] << 8));
      i += 1;
    }
    return arrayOfShort;
  }
  
  private void updateTipsView()
  {
    if (!isAEKitAvailable()) {
      return;
    }
    AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)this.mFilterProcess;
    if ((localAEFilterProcessTex.b()) && (!localAEFilterProcessTex.c()) && (!this.lastDetected))
    {
      this.notDetectedTimes += 1;
      if (this.notDetectedTimes >= 4)
      {
        notifyDetectChange(localAEFilterProcessTex.b(), localAEFilterProcessTex.c());
        this.notDetectedTimes = 0;
      }
    }
    if ((!this.lastDetected) && (localAEFilterProcessTex.c())) {
      notifyDetectChange(localAEFilterProcessTex.b(), localAEFilterProcessTex.c());
    }
    if (!localAEFilterProcessTex.b()) {
      notifyDetectChange(localAEFilterProcessTex.b(), localAEFilterProcessTex.c());
    }
    if ((this.lastDetected) && (localAEFilterProcessTex.c())) {
      notifyDetectChange(localAEFilterProcessTex.b(), true);
    }
    this.lastDetected = localAEFilterProcessTex.c();
  }
  
  public boolean captureByCameraProxy()
  {
    if (!isAEKitAvailable()) {
      return true;
    }
    if (!((AEFilterProcessTex)this.mFilterProcess).e()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void capturePhotoByAEKit(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.22(this), paramInt);
  }
  
  protected void finishCaptureVideo(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i = 1;
    if (this.captureListener != null) {
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.9(this, paramAEVideoCaptureResult));
    }
    ReportUtil.b();
    if (CameraControl.a().a == 1) {}
    for (;;)
    {
      CaptureReportUtil.f(i);
      return;
      i = 2;
    }
  }
  
  void frameToMediaCodecVideo(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.recordingEnabled) && (this.encodeConfig != null))
    {
      switch (this.mRecordingStatus)
      {
      default: 
        throw new RuntimeException("unknown status " + this.mRecordingStatus);
      case 0: 
        this.encodeConfig.a(EGL14.eglGetCurrentContext());
        this.hwVideoRecorder.a();
        this.hwVideoRecorder.a(this.encodeConfig, this);
        this.mRecordingStatus = 1;
      }
      this.hwVideoRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.mRecordingStatus)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.mRecordingStatus);
    }
    this.hwVideoRecorder.c();
    onMediaCodecStopRecord();
    this.mRecordingStatus = 0;
  }
  
  public String getCaptureDir()
  {
    if (this.aeCaptureParam != null) {
      return this.aeCaptureParam.a;
    }
    return null;
  }
  
  public int getEffectOrientation()
  {
    return this.orientation;
  }
  
  public MediaFormat getMediaFormat()
  {
    if (this.hwVideoRecorder != null) {
      return this.hwVideoRecorder.a();
    }
    return null;
  }
  
  public int getSelectedCamera()
  {
    return this.selectedCamera;
  }
  
  public int getSmoothLevel()
  {
    return this.smoothLevel;
  }
  
  public int getSurfaceHeight()
  {
    return this.mSurfaceHeight;
  }
  
  public int getSurfaceWidth()
  {
    return this.mSurfaceWidth;
  }
  
  public boolean hasTapEffect()
  {
    return ((this.mFilterProcess instanceof AEFilterProcessTex)) && (((AEFilterProcessTex)this.mFilterProcess).a() != null) && (((AEFilterProcessTex)this.mFilterProcess).a().currentMaterialNeedTouchTriggerEvent());
  }
  
  public void init(AECaptureParam paramAECaptureParam, AudioCapture paramAudioCapture)
  {
    if (this.aeCaptureParam != null) {
      throw new RuntimeException("init is already called");
    }
    if (paramAECaptureParam == null) {
      throw new IllegalArgumentException("param captureParam is null");
    }
    this.aeCaptureParam = paramAECaptureParam;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + paramAECaptureParam);
    }
    this.hwVideoRecorder = new HWVideoRecorder();
    this.audioCapture = paramAudioCapture;
    if (this.isNeedVoiceEncode)
    {
      paramAECaptureParam = this.aeCaptureParam.a + File.separator + System.currentTimeMillis() + ".aac";
      this.audioCapture.a(true, paramAECaptureParam);
    }
    this.sensorManager = ((SensorManager)getContext().getSystemService("sensor"));
    this.mAccelerometer = this.sensorManager.getDefaultSensor(1);
    this.fpsReporter.f();
    this.isInit = true;
  }
  
  public boolean isBeautyEnable()
  {
    return this.beautyEnable;
  }
  
  public boolean isFaceEffectEnable()
  {
    return this.faceEffectEnable;
  }
  
  public boolean isFilterEnable()
  {
    return this.filterEnable;
  }
  
  public boolean isRecording()
  {
    return this.recordingEnabled;
  }
  
  public boolean isSharpFaceEnable()
  {
    return this.sharpFaceEnable;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onAttachedToWindow()
  {
    AEQLog.b("AECameraGLSurfaceView", "[onAttachedToWindow]" + toString());
    super.onAttachedToWindow();
    AEQLog.b("AECameraGLSurfaceView", "[onAttachedToWindow] end");
  }
  
  public void onAudioCaptured(String paramString)
  {
    if (!this.isNeedVoiceEncode)
    {
      AEQLog.d("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
      this.videoCaptureResult.audioDataFilePath = paramString;
      if (this.videoCaptureResult.videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onAudioChangeCaptured(String paramString) {}
  
  public void onAudioError(int paramInt)
  {
    if (this.isNeedVoiceEncode)
    {
      AEQLog.d("AECameraGLSurfaceView", "onAudioError---errorCode=" + paramInt);
      this.videoCaptureResult.audioDataFilePath = "";
      if (this.videoCaptureResult.videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onAudioFrames(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    short[] arrayOfShort = toShortArray(paramArrayOfByte);
    double d = 0.0D;
    int i = 0;
    while (i < arrayOfShort.length)
    {
      d += arrayOfShort[i] * arrayOfShort[i];
      i += 1;
    }
    Math.log10(d / arrayOfShort.length);
    this.voiceRecognizer.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void onAudioInit()
  {
    if (this.audioCapture != null) {
      queueEvent(new AECameraGLSurfaceView.10(this));
    }
  }
  
  public void onAudioUnInit() {}
  
  public void onCameraPreviewSizeChanged(int paramInt1, int paramInt2)
  {
    int k = 720;
    AEQLog.b("AECameraGLSurfaceView", "onCameraPreviewSizeChanged---cameraWidth=" + paramInt1 + ", cameraHeight=" + paramInt2 + ", mSurfaceWidth=" + this.mSurfaceWidth + ", mSurfaceHeight=" + this.mSurfaceHeight);
    double d = this.mSurfaceWidth / this.mSurfaceHeight;
    this.videoWidth = paramInt1;
    this.videoHeight = ((int)(this.videoWidth / d));
    int i;
    int j;
    if (this.isGIFMode)
    {
      int[] arrayOfInt = CaptureUtil.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, 1.0F);
      arrayOfInt = CaptureUtil.a(640, arrayOfInt[0], arrayOfInt[1]);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
      this.gifPreviewWidth = i;
      this.gifPreviewHeight = j;
      this.videoWidth = this.gifPreviewWidth;
      this.videoHeight = this.gifPreviewHeight;
      if (this.mFilterProcess != null)
      {
        if (i <= 720) {
          break label290;
        }
        float f = 720.0F / i;
        j = (int)(j * f);
        i = k;
      }
    }
    label290:
    for (;;)
    {
      this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, paramInt1, paramInt2, i, j);
      this.aeGLSurfaceListener.onPreviewSizeChanged(i, j, this.mSurfaceWidth, this.mSurfaceHeight);
      this.mFilterProcess.a(this.videoWidth, this.videoHeight);
      collectDebugResolutionInfo(paramInt1, paramInt2);
      return;
      initVideoSize(paramInt1, paramInt2);
      j = paramInt2;
      i = paramInt1;
      break;
    }
  }
  
  public void onCameraPreviewStarted()
  {
    this.fpsReporter.b();
    this.isFirstFrame = true;
  }
  
  public void onCaptureError(int paramInt) {}
  
  public void onChangeCamera(int paramInt)
  {
    this.selectedCamera = paramInt;
    if (this.mFilterProcess != null) {
      this.mFilterProcess.b(false);
    }
    this.fpsReporter.a(isFrontCamera());
  }
  
  public void onDestroy()
  {
    AEQLog.d("AECameraGLSurfaceView", "[onDestroy]");
    if (QLog.isDevelopLevel()) {
      AEQLog.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.mIdentityHashCode + " ###");
    }
    this.mIsTryLocationPermission = false;
    if (this.voiceRecognizer != null) {
      this.voiceRecognizer.a();
    }
    if (this.mFilterProcess != null) {
      this.mFilterProcess.b(true);
    }
    this.fpsReporter.g();
    if (this.hwVideoRecorder != null) {
      this.hwVideoRecorder.d();
    }
    queueEvent(new AECameraGLSurfaceView.5(this));
    AEQLog.d("AECameraGLSurfaceView", "[onDestroy] end");
  }
  
  public void onDetachedFromWindow()
  {
    AEQLog.d("AECameraGLSurfaceView", "[onDetachedFromWindow]" + toString());
    super.onDetachedFromWindow();
    AEQLog.d("AECameraGLSurfaceView", "[onDetachedFromWindow] end");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.isPaused) {
      preInflateInCircleCamera();
    }
    boolean bool;
    label42:
    do
    {
      return;
      bool = this.mHaveFrame;
      if (this.logTillHaveFrame)
      {
        this.drawFrameCount += 1;
        if (!bool) {
          break;
        }
        paramGL10 = "onDrawFrameReal-begin";
        AELaunchRecorder.a().a(paramGL10);
      }
    } while (this.mFilterProcess == null);
    if (this.logTillHaveFrame) {
      AELaunchRecorder.a().a("FilterProcessInitFilters-begin");
    }
    this.mFilterProcess.g();
    if (this.logTillHaveFrame) {
      AELaunchRecorder.a().a("FilterProcessInitFilters-end");
    }
    paramGL10 = this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, this.isGIFMode);
    if (isAEKitAvailable())
    {
      AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)this.mFilterProcess;
      if (this.aeGLSurfaceListener != null) {
        this.aeGLSurfaceListener.onDrawFrameWithEffect(this.selectedCamera, localAEFilterProcessTex.a());
      }
      recordGifFrames(paramGL10[1]);
    }
    if ((this.preExtractFrame) && (!this.isGIFMode)) {
      this.mFilterProcess.c(paramGL10[1]);
    }
    drawToMediaCodec(paramGL10[1], null, null);
    if (this.mOnFrameDrawCallback != null) {
      queueEvent(new AECameraGLSurfaceView.14(this));
    }
    this.fpsReporter.d();
    if (!this.firstFrameActionDone)
    {
      this.firstFrameActionDone = true;
      AEBaseReportParam.a().g();
      AEBaseDataReporter.a().Z();
      if (AEDashboardUtil.a()) {
        AEDashboardUtil.a(this.debugInfoCallback, 5000L);
      }
      if (this.aeGLSurfaceListener != null) {
        this.aeGLSurfaceListener.onFirstFrameDone();
      }
    }
    if (this.logTillHaveFrame) {
      if (!bool) {
        break label384;
      }
    }
    label384:
    for (paramGL10 = "onDrawFrameReal-end";; paramGL10 = "onDrawFrameFake-end" + this.drawFrameCount)
    {
      AELaunchRecorder.a().a(paramGL10);
      if (bool) {
        this.logTillHaveFrame = false;
      }
      if ((!bool) || (!this.isFirstFrame)) {
        break;
      }
      this.isFirstFrame = false;
      if (this.captureListener != null) {
        this.captureListener.reportFirstFrameShown();
      }
      this.fpsReporter.c();
      AELaunchRecorder.a().c();
      return;
      paramGL10 = "onDrawFrameFake-begin" + this.drawFrameCount;
      break label42;
    }
  }
  
  public void onEncodeAudioCaptured(String paramString)
  {
    if (this.isNeedVoiceEncode)
    {
      AEQLog.d("AECameraGLSurfaceView", "onEncodeAudioCaptured---filePath=" + paramString);
      this.videoCaptureResult.audioDataFilePath = paramString;
      if (this.videoCaptureResult.videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.videoCaptureResult.errorCode = paramInt;
    if (this.captureListener != null) {
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.13(this));
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "onEncodeFinish filePath = " + paramString);
    }
    this.videoCaptureResult.videoMp4FilePath = paramString;
    if (this.audioCapture != null)
    {
      if (this.videoCaptureResult.audioDataFilePath != null)
      {
        finishCaptureVideo(this.videoCaptureResult);
        return;
      }
      this.audioCapture.e();
      return;
    }
    paramString = this.aeCaptureParam.a + "/noaudio";
    FileUtils.c(paramString);
    this.videoCaptureResult.audioDataFilePath = paramString;
    finishCaptureVideo(this.videoCaptureResult);
  }
  
  public void onEncodeFrame()
  {
    AEVideoCaptureResult localAEVideoCaptureResult = this.videoCaptureResult;
    localAEVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void onEncodeStart()
  {
    this.videoCaptureResult.videoFrameCount = 0;
    if (this.audioCapture != null) {
      this.audioCapture.a();
    }
    if (this.captureListener != null) {
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.12(this));
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.mHaveFrame = true;
    if (!this.onFrameAvailableLogged)
    {
      this.onFrameAvailableLogged = true;
      AELaunchRecorder.a().a("onFrameAvailable");
    }
    if (this.sensorUtil != null) {
      this.sensorUtil.getRotation(this.mSensorRotationMatrix);
    }
    queueEvent(new AECameraGLSurfaceView.1(this));
    requestRender();
  }
  
  protected void onMediaCodecStopRecord()
  {
    if (this.isGIFMode)
    {
      this.gifRecordStartTimestamp = 0L;
      this.gifRecordFrameIndex = 0L;
      QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord");
      if (this.aeExpressionRecognizer != null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "onMediaCodecStopRecord and aeExpressionRecognizer != null, release it");
        this.aeExpressionRecognizer.a(this.recommendTextCallback);
        this.aeExpressionRecognizer.b();
        this.aeExpressionRecognizer.c();
      }
    }
  }
  
  public void onPause()
  {
    AEQLog.d("AECameraGLSurfaceView", "[onPause] hashCode=" + this.mIdentityHashCode + " ###");
    queueEvent(new AECameraGLSurfaceView.4(this));
    this.sensorManager.unregisterListener(this);
    this.isPaused = true;
    if (this.mOrientationEventListener != null) {
      this.mOrientationEventListener.disable();
    }
    if (this.sensorUtil != null) {
      this.sensorUtil.stop();
    }
    super.onPause();
    AEQLog.d("AECameraGLSurfaceView", "[onPause] end");
  }
  
  public void onPhotoCaptured(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.11(this, paramBitmap), 64, null, false);
  }
  
  public void onResume()
  {
    super.onResume();
    this.isPaused = false;
    if (this.sensorUtil != null) {
      this.sensorUtil.start();
    }
    if (QLog.isDevelopLevel()) {
      AEQLog.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.mIdentityHashCode + " ###");
    }
    this.recordingEnabled = false;
    if ((this.mOrientationEventListener != null) && (this.mOrientationEventListener.canDetectOrientation())) {
      this.mOrientationEventListener.enable();
    }
    if (this.mPendingReqLocationPermission)
    {
      this.mPendingReqLocationPermission = false;
      this.mIsTryLocationPermission = true;
      reqLocationPermissionAndReqWMDict();
    }
    this.sensorManager.registerListener(this, this.mAccelerometer, 3);
  }
  
  protected void onSelectFaceEffect(VideoMaterial paramVideoMaterial)
  {
    if (!isFaceEffectEnable()) {}
    while (this.effectListener == null) {
      return;
    }
    this.effectListener.onSelectFaceEffect(paramVideoMaterial);
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((this.mFilterProcess instanceof AEFilterProcessTex)) {
      ((AEFilterProcessTex)this.mFilterProcess).a(paramSensorEvent);
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AEQLog.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    AELaunchRecorder.a().a("onSurfaceChanged-begin");
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    if (this.mFilterProcess != null)
    {
      paramGL10 = getPreviewSize(paramInt1, paramInt2);
      this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, 0, 0, paramGL10[0], paramGL10[1]);
    }
    if (this.smoothLevel != 0) {
      setBeautyLevel(this.smoothLevel);
    }
    AELaunchRecorder.a().a("onSurfaceChanged-end");
    AEQLog.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AEQLog.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    AELaunchRecorder.a().a("onSurfaceCreated-begin");
    initFilterProcess();
    AELaunchRecorder.a().a("onSurfaceCreated-end");
    AEQLog.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!isAEKitAvailable()) || (this.mController == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    AEFilterProcessTex localAEFilterProcessTex = (AEFilterProcessTex)this.mFilterProcess;
    if ((paramMotionEvent != null) && (localAEFilterProcessTex.d()) && (!this.mController.c()))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = LightDeviceUtils.getScreenWidth(AEModule.getContext());
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        this.mTouchStartPoint.x = f1;
        this.mTouchStartPoint.y = f2;
        queueEvent(new AECameraGLSurfaceView.25(this, localAEFilterProcessTex, f1, f2, i));
        continue;
        if (getDist(this.mTouchStartPoint.x, this.mTouchStartPoint.y, f1, f2) > i * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.26(this, localAEFilterProcessTex, f1, f2, i));
          continue;
          queueEvent(new AECameraGLSurfaceView.27(this, localAEFilterProcessTex, f1, f2, i));
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void resetMaterialWhenRecord()
  {
    if (!isAEKitAvailable()) {}
    while (this.mFilterProcess == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.21(this));
  }
  
  public void setAECaptureController(AECaptureController paramAECaptureController)
  {
    this.mController = paramAECaptureController;
  }
  
  public void setAEKitInitListener(AECameraGLSurfaceView.AEKitInitListener paramAEKitInitListener)
  {
    this.mAEKitInitListener = paramAEKitInitListener;
  }
  
  public void setAeEditMaterialSelectedListener(AEBottomListScrollView.AEEditMaterialSelectedListener paramAEEditMaterialSelectedListener)
  {
    this.aeEditMaterialSelectedListener = paramAEEditMaterialSelectedListener;
  }
  
  public void setAeGLSurfaceListener(AECameraGLSurfaceView.AEGLSurfaceListener paramAEGLSurfaceListener)
  {
    this.aeGLSurfaceListener = paramAEGLSurfaceListener;
  }
  
  public void setBeautyEnable(boolean paramBoolean)
  {
    this.beautyEnable = paramBoolean;
  }
  
  public void setBeautyLevel(int paramInt)
  {
    if ((!isAEKitAvailable()) || (!isBeautyEnable()))
    {
      AEQLog.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.smoothLevel = paramInt;
    queueEvent(new AECameraGLSurfaceView.23(this, paramInt));
  }
  
  public void setBundlePath(String paramString1, String paramString2)
  {
    if ((this.mFilterProcess instanceof AEFilterProcessTex)) {
      queueEvent(new AECameraGLSurfaceView.2(this, paramString1, paramString2));
    }
  }
  
  public void setCaptureListener(AECameraGLSurfaceView.CaptureListener paramCaptureListener)
  {
    this.captureListener = paramCaptureListener;
  }
  
  public void setCaptureRequest(AECameraGLSurfaceView.ExtractFrameRequest paramExtractFrameRequest)
  {
    if (this.mFilterProcess != null) {
      this.mFilterProcess.a(paramExtractFrameRequest);
    }
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.isDynamicResolutionMode = paramBoolean;
  }
  
  public void setFaceEffectEnable(boolean paramBoolean)
  {
    this.faceEffectEnable = paramBoolean;
  }
  
  public void setFaceEffectListener(AECameraGLSurfaceView.AEEffectListener paramAEEffectListener)
  {
    this.effectListener = paramAEEffectListener;
  }
  
  public void setFilter(FilterCategoryItem paramFilterCategoryItem)
  {
    if ((!isAEKitAvailable()) || (!isFilterEnable())) {}
    AEFilterProcessTex localAEFilterProcessTex;
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localAEFilterProcessTex = (AEFilterProcessTex)this.mFilterProcess;
          } while (paramFilterCategoryItem == null);
          localObject = paramFilterCategoryItem.a();
        } while (localObject == null);
        paramFilterCategoryItem = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
        if (!TextUtils.isEmpty(((FilterDesc)localObject).resRootPath)) {
          paramFilterCategoryItem = ((FilterDesc)localObject).resRootPath;
        }
        paramFilterCategoryItem = ((FilterDesc)localObject).getResFold(paramFilterCategoryItem);
        localObject = QQPtColorFilter.getColorFilterInfo(paramFilterCategoryItem);
      } while (localObject == null);
      paramFilterCategoryItem = paramFilterCategoryItem + ((QQPtColorFilterInfo)localObject).getColorPng();
    } while (!new File(paramFilterCategoryItem).exists());
    localAEFilterProcessTex.a(paramFilterCategoryItem);
  }
  
  public void setFilterEnable(boolean paramBoolean)
  {
    this.filterEnable = paramBoolean;
  }
  
  public void setIsGIFMode(boolean paramBoolean)
  {
    this.fpsReporter.b(paramBoolean);
    this.isGIFMode = paramBoolean;
  }
  
  public void setIsVoiceNeedEncode(boolean paramBoolean)
  {
    this.isNeedVoiceEncode = paramBoolean;
  }
  
  public void setMaterial(String paramString)
  {
    AEQLog.b("AECameraGLSurfaceView", "[setMaterial] in set materialPath:" + paramString);
    if (this.effectListener != null)
    {
      this.effectListener.onHidePagTip();
      this.effectListener.onHideNormalTip();
    }
    ThreadManager.excute(new AECameraGLSurfaceView.18(this, new AECameraGLSurfaceView.17(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData == null) || (paramAEMaterialMetaData.equals(AEMaterialMetaData.a)))
    {
      setMaterial(null);
      return;
    }
    setMaterial(paramAEMaterialMetaData.a());
  }
  
  public void setPauseFilterChainWhenCapture(boolean paramBoolean)
  {
    this.pauseFilterChainWhenCapture = paramBoolean;
    if ((this.mFilterProcess != null) && ((this.mFilterProcess instanceof AEFilterProcessTex))) {
      ((AEFilterProcessTex)this.mFilterProcess).a(paramBoolean);
    }
  }
  
  public void setPreExtractFrame(boolean paramBoolean)
  {
    this.preExtractFrame = paramBoolean;
  }
  
  public void setRecommendTextCallback(AEExpressionRecognizer.RecommendTextCallback paramRecommendTextCallback)
  {
    this.recommendTextCallback = paramRecommendTextCallback;
  }
  
  public void setSharpFaceEnable(boolean paramBoolean)
  {
    this.sharpFaceEnable = paramBoolean;
  }
  
  public void setSharpFaceLevel(int paramInt)
  {
    if ((!isAEKitAvailable()) || (!isSharpFaceEnable())) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.24(this, paramInt));
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.MaterialInnerEffectListener paramMaterialInnerEffectListener)
  {
    this.stickerInnerLutFilterListener = paramMaterialInnerEffectListener;
    if ((this.mFilterProcess != null) && ((this.mFilterProcess instanceof AEFilterProcessTex))) {
      ((AEFilterProcessTex)this.mFilterProcess).a(paramMaterialInnerEffectListener);
    }
  }
  
  public void setTapEvent(int paramInt, float paramFloat1, float paramFloat2)
  {
    queueEvent(new AECameraGLSurfaceView.TapRunnable(this, paramInt, paramFloat1 / this.mSurfaceWidth, paramFloat2 / this.mSurfaceHeight));
  }
  
  public void setUseVideoOrientation(boolean paramBoolean)
  {
    this.useVideoOrientation = paramBoolean;
  }
  
  public void startCaptureVideo()
  {
    AEQLog.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.recordingEnabled);
    this.fpsReporter.e();
    String str = this.aeCaptureParam.a + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.useVideoOrientation) && (!this.isGIFMode)) {}
    for (int i = CaptureUtil.b(this.orientation);; i = 0)
    {
      this.encodeConfig = new EncodeConfig(str, this.videoWidth, this.videoHeight, this.aeCaptureParam.a(), this.aeCaptureParam.f(), false, i);
      this.encodeConfig.j = this.aeCaptureParam.h();
      this.encodeConfig.k = this.aeCaptureParam.i();
      this.videoCaptureResult = new AEVideoCaptureResult();
      this.videoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.videoCaptureResult.orientation = this.orientation;
      this.videoCaptureResult.type = 0;
      this.recordingEnabled = true;
      CaptureUtil.a(false, false);
      return;
    }
  }
  
  public void stopCaptureVideo()
  {
    AEQLog.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.recordingEnabled + ", recordingStatus=" + this.mRecordingStatus + ", isPaused=" + this.isPaused);
    if (this.recordingEnabled)
    {
      this.recordingEnabled = false;
      if (this.mRecordingStatus != 0) {
        break label92;
      }
      if (this.captureListener != null) {
        this.captureListener.onCaptureError(102);
      }
    }
    label92:
    while (!this.isPaused) {
      return;
    }
    drawToMediaCodec(0, null, null);
  }
  
  public void switchSegment(boolean paramBoolean)
  {
    if (isAEKitAvailable()) {
      ((AEFilterProcessTex)this.mFilterProcess).c(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */