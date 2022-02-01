package dov.com.qq.im.ae.camera.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.MainThread;
import anvx;
import bbgd;
import bbge;
import bbhl;
import bbhm;
import bbhq;
import bbht;
import bbmm;
import bbmy;
import bbna;
import bdax;
import bmwb;
import bnax;
import bnay;
import bnaz;
import bnbb;
import bnbe;
import bnbf;
import bnbg;
import bndr;
import bnep;
import bnfg;
import bnil;
import bnke;
import bnky;
import bnlk;
import bnlm;
import bnnl;
import bnqd;
import bnqe;
import bnqh;
import bnqm;
import bnqq;
import bnrh;
import bpnj;
import bprj;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.SensorUtil2;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(17)
public class AECameraGLSurfaceView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, bbgd, bbmy, bnbb
{
  private static final long GIF_SKIP_FRAME_INTERVAL = 83L;
  private static final int GIF_WANTED_SIZE = 640;
  private static final int MAX_PREVIEW_WIDTH = 720;
  private static final int RECORDING_OFF = 0;
  private static final int RECORDING_ON = 1;
  private static final String TAG = "AECameraGLSurfaceView";
  private static volatile boolean isSdkInited;
  private int activityOrientation;
  private bnax aeCaptureParam;
  private bndr aeEditMaterialSelectedListener;
  private bnlk aeExpressionRecognizer;
  private AECameraGLSurfaceView.AEGLSurfaceListener aeGLSurfaceListener;
  protected AudioCapture audioCapture;
  private boolean beautyEnable = true;
  protected AECameraGLSurfaceView.CaptureListener captureListener;
  public bnfg debugInfoCallback;
  private int drawFrameCount;
  protected AECameraGLSurfaceView.AEEffectListener effectListener;
  private EGLContext eglContext;
  private bbmm encodeConfig;
  private boolean faceEffectEnable = true;
  private boolean filterEnable = true;
  private boolean firstFrameActionDone;
  private bnqh fpsReporter = new bnqd();
  private int gifPreviewHeight;
  private int gifPreviewWidth;
  private long gifRecordFrameIndex;
  private long gifRecordStartTimestamp;
  private bbna hwVideoRecorder;
  private boolean isDynamicResolutionMode;
  protected boolean isFirstFrame = true;
  private boolean isGIFMode;
  private boolean isInit;
  private boolean isNeedVoiceEncode;
  private boolean isPaused = true;
  private boolean lastDetected;
  private boolean logTillHaveFrame = true;
  private AECameraGLSurfaceView.AEKitInitListener mAEKitInitListener;
  protected bbge mAudioChangeCapture;
  private bnbg mController;
  private bnbe mFilterProcess;
  private volatile boolean mHaveFrame;
  private final int mIdentityHashCode;
  private volatile boolean mIsTryLocationPermission;
  private VideoMaterial mLastVideoMaterial;
  private Runnable mOnFrameDrawCallback;
  private bnil mOrientationEventListener;
  private volatile boolean mPendingReqLocationPermission;
  private int mRecordingStatus;
  private float[] mSensorRotationMatrix = new float[16];
  protected int mSurfaceHeight = 480;
  protected int mSurfaceWidth = 320;
  private PointF mTouchStartPoint = new PointF(0.0F, 0.0F);
  private boolean needFace;
  private int notDetectedTimes;
  private boolean onFrameAvailableLogged;
  private int orientation = 90;
  protected boolean pauseFilterChainWhenCapture = true;
  private boolean preExtractFrame;
  protected bnlm recommendTextCallback;
  private volatile boolean recordingEnabled;
  protected int selectedCamera = 2;
  private volatile SensorUtil2 sensorUtil;
  private boolean sharpFaceEnable = true;
  private int smoothLevel;
  protected AEFilterManager.StickerInnerEffectFilterListener stickerInnerLutFilterListener;
  private boolean useVideoOrientation = true;
  private AEVideoCaptureResult videoCaptureResult;
  private int videoHeight;
  private int videoWidth;
  private bprj voiceRecognizer = new bprj();
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    initEGL();
    this.mIdentityHashCode = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bnqe.a().a("glSurfaceViewConstruct-begin");
    initEGL();
    this.mIdentityHashCode = System.identityHashCode(this);
    bnqe.a().a("glSurfaceViewConstruct-end");
  }
  
  private void addAEInitQueue(Runnable paramRunnable)
  {
    if (isAEKitAvailable()) {
      ((bnaz)this.mFilterProcess).a(paramRunnable);
    }
  }
  
  private void checkShowTips()
  {
    if ((this.mFilterProcess != null) && (((bnaz)this.mFilterProcess).a()))
    {
      ((bnaz)this.mFilterProcess).b();
      ((bnaz)this.mFilterProcess).c();
    }
  }
  
  private void collectDebugResolutionInfo(int paramInt1, int paramInt2) {}
  
  private void createFilterProcess()
  {
    if (this.mFilterProcess != null) {
      return;
    }
    bnrh.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    bmwb.a();
    if (FeatureManager.loadBasicFeatures())
    {
      this.mFilterProcess = new bnaz(this.mIdentityHashCode);
      ((bnaz)this.mFilterProcess).a(new AECameraGLSurfaceView.5(this));
      bnrh.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.mFilterProcess = new bnbf();
    bnrh.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
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
  
  @MainThread
  private void doLocationPermissionReqAndUpdateWMProps()
  {
    bnrh.b("AECameraGLSurfaceView", "doLocationPermissionReqAndUpdateWMProps");
    new bbhq((Activity)getContext(), new AECameraGLSurfaceView.17(this)).a();
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
      localObject = (bnaz)this.mFilterProcess;
      if (this.gifRecordStartTimestamp == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.gifRecordStartTimestamp = paramLong;
        bnnl.jdField_a_of_type_JavaUtilList = new ArrayList();
        bnnl.b = new ArrayList();
      }
      paramInt2 = ((bnaz)localObject).a(paramInt2);
    } while ((paramLong - this.gifRecordStartTimestamp) / 1000000L <= 83L * this.gifRecordFrameIndex);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.gifRecordFrameIndex) });
    this.gifRecordFrameIndex += 1L;
    if (((bnaz)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((bnaz)localObject).a().getFaceAttr();
      bnnl.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      bnnl.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      bnnl.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    frameToMediaCodecVideo(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void finishCapturePhoto(bnay parambnay)
  {
    if (this.captureListener != null) {
      this.captureListener.onPhotoCaptured(parambnay);
    }
  }
  
  private float getDist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4));
  }
  
  private void initEGL()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    setEGLContextFactory(new AECameraGLSurfaceView.2(this));
    setPreserveEGLContextOnPause(false);
    setRenderer(this);
    setRenderMode(0);
    preAction();
  }
  
  private void initFilterProcess()
  {
    bnqe.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.mFilterProcess == null) {
      createFilterProcess();
    }
    initOrientationEventListener();
    if ((this.mFilterProcess instanceof bnaz))
    {
      AEFilterManagerHolder.setFilterProcess((bnaz)this.mFilterProcess);
      if (this.mAEKitInitListener != null) {
        this.mAEKitInitListener.onAEKitInited();
      }
      ((bnaz)this.mFilterProcess).c(false);
      ((bnaz)this.mFilterProcess).a(this.stickerInnerLutFilterListener);
      ((bnaz)this.mFilterProcess).a(new AECameraGLSurfaceView.6(this));
      ((bnaz)this.mFilterProcess).a().setParam("SET_AEPROFILER_OBJ", this.fpsReporter);
    }
    SurfaceTexture localSurfaceTexture = this.mFilterProcess.a();
    localSurfaceTexture.setOnFrameAvailableListener(this);
    if (this.aeGLSurfaceListener != null) {
      this.aeGLSurfaceListener.onPreviewSurfaceTextureCreate(localSurfaceTexture);
    }
    bnqe.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void initOrientationEventListener()
  {
    this.mOrientationEventListener = new AECameraGLSurfaceView.13(this, getContext());
    if (this.mOrientationEventListener.canDetectOrientation()) {
      this.mOrientationEventListener.enable();
    }
  }
  
  public static void initSdk()
  {
    try
    {
      bnrh.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + isSdkInited);
      long l = System.currentTimeMillis();
      if (!isSdkInited)
      {
        bnrh.b("AECameraGLSurfaceView", "[initSdk] do init");
        isSdkInited = true;
        bnqe.a().a("glSurfaceViewStaticInit-begin");
        if (bmwb.a()) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.getPtvTemplateSDKPref());
        }
        bnqe.a().a("glSurfaceViewStaticInit-end");
      }
      bnrh.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l));
      return;
    }
    finally {}
  }
  
  private void initVideoSize(int paramInt1, int paramInt2)
  {
    int i = (int)(this.mSurfaceHeight * 1.0F / this.mSurfaceWidth * this.aeCaptureParam.c());
    if (bpnj.a().e()) {
      i = this.aeCaptureParam.b();
    }
    if (this.isDynamicResolutionMode)
    {
      arrayOfInt = bbhm.a(i, paramInt1, paramInt2);
      arrayOfInt = bbhm.a(arrayOfInt[0], arrayOfInt[1], this.aeCaptureParam.d(), this.aeCaptureParam.e(), 1.0F);
      this.videoWidth = arrayOfInt[0];
      this.videoHeight = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = bbhm.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, this.aeCaptureParam.a());
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
    arrayOfInt = bbhm.a(i, this.videoWidth, this.videoHeight);
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
  }
  
  private boolean isAEKitAvailable()
  {
    return (bnky.a()) && (this.mFilterProcess != null) && ((this.mFilterProcess instanceof bnaz));
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
    bnrh.b("AECameraGLSurfaceView", "preAction");
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
  
  private void recordGifFrames(int paramInt)
  {
    if ((isRecordingGIF()) && (this.gifRecordStartTimestamp > 0L))
    {
      Object localObject = (bnaz)this.mFilterProcess;
      if (this.aeExpressionRecognizer == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.aeExpressionRecognizer = new bnlk();
        this.aeExpressionRecognizer.a();
      }
      long l = (SystemClock.elapsedRealtimeNanos() - this.gifRecordStartTimestamp) / 1000000L;
      int i = this.aeExpressionRecognizer.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i);
      if ((i < 3) && ((float)l > (i + 0.5F) * 1000.0F) && (((bnaz)localObject).c()))
      {
        localObject = (PTFaceAttr)((bnaz)localObject).a().getFaceAttr();
        this.aeExpressionRecognizer.a(paramInt, (List)((PTFaceAttr)localObject).getAllFacePoints().get(0), (int)(this.gifPreviewWidth * ((PTFaceAttr)localObject).getFaceDetectScale()), (int)(this.gifPreviewHeight * ((PTFaceAttr)localObject).getFaceDetectScale()));
      }
    }
  }
  
  private void recoverAudioCapture()
  {
    if ((this.mLastVideoMaterial != null) && (VideoMaterialUtil.isAudio2textMaterial(this.mLastVideoMaterial))) {
      this.voiceRecognizer.a(getContext(), this.audioCapture);
    }
  }
  
  private void setTipsHandler(bnaz parambnaz)
  {
    if (this.effectListener != null) {
      this.effectListener.onSetFilterProcess(parambnaz);
    }
  }
  
  private void showToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.14(this, paramString));
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
    bnaz localbnaz = (bnaz)this.mFilterProcess;
    if ((localbnaz.b()) && (!localbnaz.c()) && (!this.lastDetected))
    {
      this.notDetectedTimes += 1;
      if (this.notDetectedTimes >= 4)
      {
        notifyDetectChange(localbnaz.b(), localbnaz.c());
        this.notDetectedTimes = 0;
      }
    }
    if ((!this.lastDetected) && (localbnaz.c())) {
      notifyDetectChange(localbnaz.b(), localbnaz.c());
    }
    if (!localbnaz.b()) {
      notifyDetectChange(localbnaz.b(), localbnaz.c());
    }
    if ((this.lastDetected) && (localbnaz.c())) {
      notifyDetectChange(localbnaz.b(), localbnaz.c());
    }
    this.lastDetected = localbnaz.c();
  }
  
  public boolean captureByCameraProxy()
  {
    if (!isAEKitAvailable()) {
      return true;
    }
    if (!((bnaz)this.mFilterProcess).e()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void capturePhotoByAEKit(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.19(this), paramInt);
  }
  
  protected void finishCaptureVideo(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i = 1;
    if (this.captureListener != null) {
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.7(this, paramAEVideoCaptureResult));
    }
    bbht.c();
    if (bdax.a().a == 1) {}
    for (;;)
    {
      bbhl.g(i);
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
    this.hwVideoRecorder.b();
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
    return ((this.mFilterProcess instanceof bnaz)) && (((bnaz)this.mFilterProcess).a() != null) && (((bnaz)this.mFilterProcess).a().getmPTSticker() != null) && (((bnaz)this.mFilterProcess).a().getmPTSticker().needTouchTriggerEvent());
  }
  
  public void init(bnax parambnax, AudioCapture paramAudioCapture)
  {
    if (this.aeCaptureParam != null) {
      throw new RuntimeException("init is already called");
    }
    if (parambnax == null) {
      throw new IllegalArgumentException("param captureParam is null");
    }
    this.aeCaptureParam = parambnax;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + parambnax);
    }
    this.hwVideoRecorder = new bbna();
    this.audioCapture = paramAudioCapture;
    this.mAudioChangeCapture = new bbge(this.aeCaptureParam.a, CodecParam.mAudioSampleRate, this);
    if (this.isNeedVoiceEncode)
    {
      parambnax = this.aeCaptureParam.a + File.separator + System.currentTimeMillis() + ".aac";
      this.audioCapture.a(true, parambnax);
    }
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
  
  protected void onAttachedToWindow()
  {
    bnrh.b("AECameraGLSurfaceView", "[onAttachedToWindow]" + toString());
    super.onAttachedToWindow();
    bnrh.b("AECameraGLSurfaceView", "[onAttachedToWindow] end");
  }
  
  public void onAudioCaptured(String paramString)
  {
    if ((!this.isNeedVoiceEncode) && (!this.mAudioChangeCapture.a()))
    {
      bnrh.d("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
      this.videoCaptureResult.audioDataFilePath = paramString;
      if (this.videoCaptureResult.videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onAudioChangeCaptured(String paramString)
  {
    if (this.mAudioChangeCapture.a())
    {
      bnrh.d("AECameraGLSurfaceView", "onAudioChangeCaptured---filePath=" + paramString);
      this.videoCaptureResult.audioDataFilePath = paramString;
      if (this.videoCaptureResult.videoMp4FilePath != null) {
        finishCaptureVideo(this.videoCaptureResult);
      }
    }
  }
  
  public void onAudioError(int paramInt)
  {
    if ((this.isNeedVoiceEncode) && (!this.mAudioChangeCapture.a()))
    {
      bnrh.d("AECameraGLSurfaceView", "onAudioError---errorCode=" + paramInt);
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
    this.mAudioChangeCapture.a(paramArrayOfByte, paramInt1, paramInt2);
    this.voiceRecognizer.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void onAudioInit()
  {
    if (this.audioCapture != null) {
      queueEvent(new AECameraGLSurfaceView.8(this));
    }
  }
  
  public void onAudioUnInit() {}
  
  public void onCameraPreviewSizeChanged(int paramInt1, int paramInt2)
  {
    int k = 720;
    bnrh.b("AECameraGLSurfaceView", "onCameraPreviewSizeChanged---cameraWidth=" + paramInt1 + ", cameraHeight=" + paramInt2 + ", mSurfaceWidth=" + this.mSurfaceWidth + ", mSurfaceHeight=" + this.mSurfaceHeight);
    double d = this.mSurfaceWidth / this.mSurfaceHeight;
    this.videoWidth = paramInt1;
    this.videoHeight = ((int)(this.videoWidth / d));
    int i;
    int j;
    if (this.isGIFMode)
    {
      int[] arrayOfInt = bbhm.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, 1.0F);
      arrayOfInt = bbhm.a(640, arrayOfInt[0], arrayOfInt[1]);
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
    bnrh.d("AECameraGLSurfaceView", "[onDestroy]");
    if (QLog.isDevelopLevel()) {
      bnrh.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.mIdentityHashCode + " ###");
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
      this.hwVideoRecorder.c();
    }
    queueEvent(new AECameraGLSurfaceView.4(this));
    bnrh.d("AECameraGLSurfaceView", "[onDestroy] end");
  }
  
  protected void onDetachedFromWindow()
  {
    bnrh.d("AECameraGLSurfaceView", "[onDetachedFromWindow]" + toString());
    super.onDetachedFromWindow();
    bnrh.d("AECameraGLSurfaceView", "[onDetachedFromWindow] end");
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    boolean bool = this.mHaveFrame;
    if (this.logTillHaveFrame)
    {
      this.drawFrameCount += 1;
      if (!bool) {
        break label45;
      }
    }
    label45:
    for (paramGL10 = "onDrawFrameReal-begin";; paramGL10 = "onDrawFrameFake-begin" + this.drawFrameCount)
    {
      bnqe.a().a(paramGL10);
      if (this.mFilterProcess != null) {
        break;
      }
      return;
    }
    if (this.logTillHaveFrame) {
      bnqe.a().a("FilterProcessInitFilters-begin");
    }
    this.mFilterProcess.g();
    if (this.logTillHaveFrame) {
      bnqe.a().a("FilterProcessInitFilters-end");
    }
    paramGL10 = this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, this.isGIFMode);
    if (isAEKitAvailable())
    {
      bnaz localbnaz = (bnaz)this.mFilterProcess;
      updateTipsView();
      checkShowTips();
      if (this.aeGLSurfaceListener != null) {
        this.aeGLSurfaceListener.onDrawFrameWithEffect(this.selectedCamera, localbnaz.a());
      }
      recordGifFrames(paramGL10[1]);
    }
    if ((this.preExtractFrame) && (!this.isGIFMode)) {
      this.mFilterProcess.c(paramGL10[1]);
    }
    drawToMediaCodec(paramGL10[1], null, null);
    if (this.mOnFrameDrawCallback != null) {
      queueEvent(new AECameraGLSurfaceView.12(this));
    }
    this.fpsReporter.d();
    if (!this.firstFrameActionDone)
    {
      this.firstFrameActionDone = true;
      bnqq.a().f();
      bnqm.a().ab();
      if (bnep.a()) {
        bnep.a(this.debugInfoCallback, 5000L);
      }
      if (this.aeGLSurfaceListener != null) {
        this.aeGLSurfaceListener.onFirstFrameDone();
      }
    }
    if (this.logTillHaveFrame) {
      if (!bool) {
        break label381;
      }
    }
    label381:
    for (paramGL10 = "onDrawFrameReal-end";; paramGL10 = "onDrawFrameFake-end" + this.drawFrameCount)
    {
      bnqe.a().a(paramGL10);
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
      bnqe.a().c();
      return;
    }
  }
  
  public void onEncodeAudioCaptured(String paramString)
  {
    if ((this.isNeedVoiceEncode) && (!this.mAudioChangeCapture.a()))
    {
      bnrh.d("AECameraGLSurfaceView", "onEncodeAudioCaptured---filePath=" + paramString);
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
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.11(this));
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
      if (this.mAudioChangeCapture.a())
      {
        this.mAudioChangeCapture.b();
        this.audioCapture.e();
        return;
      }
      this.audioCapture.e();
      return;
    }
    paramString = this.aeCaptureParam.a + "/noaudio";
    FileUtils.createFileIfNotExits(paramString);
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
    if (this.audioCapture != null)
    {
      if (!this.mAudioChangeCapture.a()) {
        break label62;
      }
      this.mAudioChangeCapture.a();
      this.audioCapture.a();
    }
    for (;;)
    {
      if (this.captureListener != null) {
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.10(this));
      }
      return;
      label62:
      this.audioCapture.a();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.mHaveFrame = true;
    if (!this.onFrameAvailableLogged)
    {
      this.onFrameAvailableLogged = true;
      bnqe.a().a("onFrameAvailable");
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
    bnrh.d("AECameraGLSurfaceView", "[onPause] hashCode=" + this.mIdentityHashCode + " ###");
    queueEvent(new AECameraGLSurfaceView.3(this));
    this.isPaused = true;
    if (this.mOrientationEventListener != null) {
      this.mOrientationEventListener.disable();
    }
    if (this.sensorUtil != null) {
      this.sensorUtil.stop();
    }
    super.onPause();
    bnrh.d("AECameraGLSurfaceView", "[onPause] end");
  }
  
  public void onPhotoCaptured(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.9(this, paramBitmap), 64, null, false);
  }
  
  public void onResume()
  {
    super.onResume();
    this.isPaused = false;
    if (this.sensorUtil != null) {
      this.sensorUtil.start();
    }
    if (QLog.isDevelopLevel()) {
      bnrh.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.mIdentityHashCode + " ###");
    }
    this.recordingEnabled = false;
    if ((this.mOrientationEventListener != null) && (this.mOrientationEventListener.canDetectOrientation())) {
      this.mOrientationEventListener.enable();
    }
    if (this.mPendingReqLocationPermission)
    {
      this.mPendingReqLocationPermission = false;
      this.mIsTryLocationPermission = true;
      doLocationPermissionReqAndUpdateWMProps();
    }
  }
  
  protected void onSelectFaceEffect(VideoMaterial paramVideoMaterial)
  {
    if (!isFaceEffectEnable()) {}
    while (this.effectListener == null) {
      return;
    }
    this.effectListener.onSelectFaceEffect(paramVideoMaterial);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    bnrh.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    bnqe.a().a("onSurfaceChanged-begin");
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    if (this.mFilterProcess != null) {
      this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, 0, 0, paramInt1, paramInt2);
    }
    if (this.smoothLevel != 0) {
      setBeautyLevel(this.smoothLevel);
    }
    bnqe.a().a("onSurfaceChanged-end");
    bnrh.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    bnrh.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    bnqe.a().a("onSurfaceCreated-begin");
    initFilterProcess();
    bnqe.a().a("onSurfaceCreated-end");
    bnrh.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!isAEKitAvailable()) || (this.mController == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    bnaz localbnaz = (bnaz)this.mFilterProcess;
    if ((paramMotionEvent != null) && (localbnaz.d()) && (!this.mController.c()))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = DeviceUtils.getScreenWidth(AEModule.getContext());
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        this.mTouchStartPoint.x = f1;
        this.mTouchStartPoint.y = f2;
        queueEvent(new AECameraGLSurfaceView.22(this, localbnaz, f1, f2, i));
        continue;
        if (getDist(this.mTouchStartPoint.x, this.mTouchStartPoint.y, f1, f2) > i * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.23(this, localbnaz, f1, f2, i));
          continue;
          queueEvent(new AECameraGLSurfaceView.24(this, localbnaz, f1, f2, i));
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void resetMaterial()
  {
    if (!isAEKitAvailable()) {}
    while (this.mFilterProcess == null) {
      return;
    }
    queueEvent(new AECameraGLSurfaceView.18(this));
  }
  
  public void setAECaptureController(bnbg parambnbg)
  {
    this.mController = parambnbg;
  }
  
  public void setAEKitInitListener(AECameraGLSurfaceView.AEKitInitListener paramAEKitInitListener)
  {
    this.mAEKitInitListener = paramAEKitInitListener;
  }
  
  public void setAeEditMaterialSelectedListener(bndr parambndr)
  {
    this.aeEditMaterialSelectedListener = parambndr;
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
      bnrh.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.smoothLevel = paramInt;
    queueEvent(new AECameraGLSurfaceView.20(this, paramInt));
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
    bnaz localbnaz;
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
            localbnaz = (bnaz)this.mFilterProcess;
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
    localbnaz.a(paramFilterCategoryItem);
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
    bnrh.b("AECameraGLSurfaceView", "[setMaterial] in set materialPath:" + paramString);
    ThreadManager.excute(new AECameraGLSurfaceView.16(this, new AECameraGLSurfaceView.15(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(bnke parambnke)
  {
    if ((parambnke == null) || (parambnke.equals(bnke.a)))
    {
      setMaterial(null);
      return;
    }
    setMaterial(parambnke.a());
  }
  
  public void setPauseFilterChainWhenCapture(boolean paramBoolean)
  {
    this.pauseFilterChainWhenCapture = paramBoolean;
    if ((this.mFilterProcess != null) && ((this.mFilterProcess instanceof bnaz))) {
      ((bnaz)this.mFilterProcess).a(paramBoolean);
    }
  }
  
  public void setPreExtractFrame(boolean paramBoolean)
  {
    this.preExtractFrame = paramBoolean;
  }
  
  public void setRecommendTextCallback(bnlm parambnlm)
  {
    this.recommendTextCallback = parambnlm;
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
    queueEvent(new AECameraGLSurfaceView.21(this, paramInt));
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.stickerInnerLutFilterListener = paramStickerInnerEffectFilterListener;
    if ((this.mFilterProcess != null) && ((this.mFilterProcess instanceof bnaz))) {
      ((bnaz)this.mFilterProcess).a(paramStickerInnerEffectFilterListener);
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
    bnrh.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.recordingEnabled);
    this.fpsReporter.e();
    String str = this.aeCaptureParam.a + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.useVideoOrientation) && (!this.isGIFMode)) {}
    for (int i = bbhm.b(this.orientation);; i = 0)
    {
      this.encodeConfig = new bbmm(str, this.videoWidth, this.videoHeight, this.aeCaptureParam.a(), this.aeCaptureParam.f(), false, i);
      this.encodeConfig.j = this.aeCaptureParam.h();
      this.encodeConfig.k = this.aeCaptureParam.i();
      this.videoCaptureResult = new AEVideoCaptureResult();
      this.videoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.videoCaptureResult.orientation = this.orientation;
      this.videoCaptureResult.type = 0;
      this.recordingEnabled = true;
      bbhm.a(false, false);
      return;
    }
  }
  
  public void stopCaptureVideo()
  {
    bnrh.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.recordingEnabled + ", recordingStatus=" + this.mRecordingStatus + ", isPaused=" + this.isPaused);
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
    if ((!PTHumanSegmenter.HUMAN_SEGMENT.isFunctionReady()) && (paramBoolean)) {
      QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131689799), 0).a();
    }
    while (!isAEKitAvailable()) {
      return;
    }
    ((bnaz)this.mFilterProcess).c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */