package dov.com.qq.im.ae.camera.core;

import amtj;
import android.annotation.TargetApi;
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
import azzu;
import azzv;
import babc;
import babd;
import babk;
import bafx;
import bagj;
import bagl;
import bbuc;
import bljd;
import blno;
import blnp;
import blnq;
import blns;
import blnt;
import blnu;
import blnv;
import blpl;
import blqi;
import blrg;
import blrx;
import bluh;
import blvb;
import blwa;
import blwc;
import blyb;
import bmat;
import bmau;
import bmax;
import bmbc;
import bmbg;
import bmbx;
import bnxr;
import bobr;
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
import dov.com.qq.im.ae.download.AEResUtil;
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
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, azzu, bagj, blns
{
  private static final long GIF_SKIP_FRAME_INTERVAL = 83L;
  private static final int GIF_WANTED_SIZE = 640;
  private static final int MAX_PREVIEW_WIDTH = 720;
  private static final int RECORDING_OFF = 0;
  private static final int RECORDING_ON = 1;
  private static final String TAG = "AECameraGLSurfaceView";
  private static volatile boolean isSdkInited;
  private int activityOrientation;
  private blno aeCaptureParam;
  private blqi aeEditMaterialSelectedListener;
  private blwa aeExpressionRecognizer;
  private AECameraGLSurfaceView.AEGLSurfaceListener aeGLSurfaceListener;
  protected AudioCapture audioCapture;
  private boolean beautyEnable = true;
  protected AECameraGLSurfaceView.CaptureListener captureListener;
  public blrx debugInfoCallback;
  private int drawFrameCount;
  protected AECameraGLSurfaceView.AEEffectListener effectListener;
  private EGLContext eglContext;
  private bafx encodeConfig;
  private boolean faceEffectEnable = true;
  private boolean filterEnable = true;
  private boolean firstFrameActionDone;
  private bmax fpsReporter = new bmat();
  private int gifPreviewHeight;
  private int gifPreviewWidth;
  private long gifRecordFrameIndex;
  private long gifRecordStartTimestamp;
  private bagl hwVideoRecorder;
  private boolean isDynamicResolutionMode;
  protected boolean isFirstFrame = true;
  private boolean isGIFMode;
  private boolean isInit;
  private boolean isNeedVoiceEncode;
  private boolean isPaused = true;
  private boolean lastDetected;
  private boolean logTillHaveFrame = true;
  private AECameraGLSurfaceView.AEKitInitListener mAEKitInitListener;
  protected azzv mAudioChangeCapture;
  private blnv mController;
  private blnt mFilterProcess;
  private volatile boolean mHaveFrame;
  private final int mIdentityHashCode;
  private boolean mIsTryLocationPermission;
  private VideoMaterial mLastVideoMaterial;
  private Runnable mOnFrameDrawCallback;
  private bluh mOrientationEventListener;
  private int mRecordingStatus;
  private float[] mSensorRotationMatrix = new float[16];
  protected int mSurfaceHeight = 480;
  protected int mSurfaceWidth = 320;
  private PointF mTouchStartPoint = new PointF(0.0F, 0.0F);
  private boolean needFace;
  private int notDetectedTimes;
  private boolean onFrameAvailableLogged;
  private int orientation = 90;
  private boolean preExtractFrame;
  protected blwc recommendTextCallback;
  private volatile boolean recordingEnabled;
  private blpl sceneListener;
  protected int selectedCamera = 2;
  private volatile SensorUtil2 sensorUtil;
  private boolean sharpFaceEnable = true;
  private int smoothLevel;
  protected AEFilterManager.StickerInnerEffectFilterListener stickerInnerLutFilterListener;
  private boolean useVideoOrientation = true;
  private AEVideoCaptureResult videoCaptureResult;
  private int videoHeight;
  private int videoWidth;
  private bobr voiceRecognizer = new bobr();
  
  public AECameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    initEGL();
    this.mIdentityHashCode = System.identityHashCode(this);
  }
  
  public AECameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bmau.a().a("glSurfaceViewConstruct-begin");
    initEGL();
    this.mIdentityHashCode = System.identityHashCode(this);
    bmau.a().a("glSurfaceViewConstruct-end");
  }
  
  private void addAEInitQueue(Runnable paramRunnable)
  {
    if (isAEKitAvailable()) {
      ((blnq)this.mFilterProcess).a(paramRunnable);
    }
  }
  
  private void checkShowTips()
  {
    if ((this.mFilterProcess != null) && (((blnq)this.mFilterProcess).a()))
    {
      ((blnq)this.mFilterProcess).b();
      ((blnq)this.mFilterProcess).c();
    }
  }
  
  private void collectDebugResolutionInfo(int paramInt1, int paramInt2) {}
  
  private void createFilterProcess()
  {
    if (this.mFilterProcess != null) {
      return;
    }
    bmbx.b("AECameraGLSurfaceView", "createFilterProcess---BEGIN");
    bljd.a();
    if (FeatureManager.loadBasicFeatures())
    {
      this.mFilterProcess = new blnq(this.mIdentityHashCode);
      bmbx.b("AECameraGLSurfaceView", "createFilterProcess---create AEFilterProcessTex");
      return;
    }
    this.mFilterProcess = new blnu();
    bmbx.d("AECameraGLSurfaceView", "createFilterProcess---create NonAEFilterProcess");
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
      localObject = (blnq)this.mFilterProcess;
      if (this.gifRecordStartTimestamp == 0L)
      {
        QLog.d("AECameraGLSurfaceView", 4, "frameToMediaCodec, gifRecordStartTimestamp == 0");
        this.gifRecordStartTimestamp = paramLong;
        blyb.jdField_a_of_type_JavaUtilList = new ArrayList();
        blyb.b = new ArrayList();
      }
      paramInt2 = ((blnq)localObject).a(paramInt2);
    } while ((paramLong - this.gifRecordStartTimestamp) / 1000000L <= 83L * this.gifRecordFrameIndex);
    QLog.d("AECameraGLSurfaceView", 4, new Object[] { "frameToMediaCodec, encode frame, gifRecordFrameIndex = ", Long.valueOf(this.gifRecordFrameIndex) });
    this.gifRecordFrameIndex += 1L;
    if (((blnq)localObject).a() != null)
    {
      localObject = (PTFaceAttr)((blnq)localObject).a().getFaceAttr();
      blyb.jdField_a_of_type_JavaUtilList.add(((PTFaceAttr)localObject).getAllFacePoints());
      blyb.b.add(((PTFaceAttr)localObject).getAllFaceAngles());
      blyb.jdField_a_of_type_Double = ((PTFaceAttr)localObject).getFaceDetectScale();
    }
    frameToMediaCodecVideo(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, (paramLong / 1.5D));
  }
  
  private void finishCapturePhoto(blnp paramblnp)
  {
    if (this.captureListener != null) {
      this.captureListener.onPhotoCaptured(paramblnp);
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
    bmau.a().a("AECameraGLSurfaceView", "initFilterProcess---begin");
    if (this.mFilterProcess == null) {
      createFilterProcess();
    }
    initOrientationEventListener();
    if ((this.mFilterProcess instanceof blnq))
    {
      AEFilterManagerHolder.setFilterProcess((blnq)this.mFilterProcess);
      if (this.mAEKitInitListener != null) {
        this.mAEKitInitListener.onAEKitInited();
      }
      ((blnq)this.mFilterProcess).b(false);
      ((blnq)this.mFilterProcess).a(this.stickerInnerLutFilterListener);
      ((blnq)this.mFilterProcess).a().setParam("SET_AEPROFILER_OBJ", this.fpsReporter);
    }
    SurfaceTexture localSurfaceTexture = this.mFilterProcess.a();
    localSurfaceTexture.setOnFrameAvailableListener(this);
    if (this.aeGLSurfaceListener != null) {
      this.aeGLSurfaceListener.onPreviewSurfaceTextureCreate(localSurfaceTexture);
    }
    bmau.a().a("AECameraGLSurfaceView", "initFilterProcess---end");
  }
  
  private void initOrientationEventListener()
  {
    this.mOrientationEventListener = new AECameraGLSurfaceView.11(this, getContext());
    if (this.mOrientationEventListener.canDetectOrientation()) {
      this.mOrientationEventListener.enable();
    }
  }
  
  public static void initSdk()
  {
    try
    {
      bmbx.b("AECameraGLSurfaceView", "[initSdk] + BEGIN, isSdkInited = " + isSdkInited);
      long l = System.currentTimeMillis();
      if (!isSdkInited)
      {
        bmbx.b("AECameraGLSurfaceView", "[initSdk] do init");
        isSdkInited = true;
        bmau.a().a("glSurfaceViewStaticInit-begin");
        if (bljd.a()) {
          VideoPrefsUtil.init(BaseApplicationImpl.getContext(), ShortVideoUtils.getPtvTemplateSDKPref());
        }
        bmau.a().a("glSurfaceViewStaticInit-end");
      }
      bmbx.b("AECameraGLSurfaceView", "[initSdk] + END, time cost = " + (System.currentTimeMillis() - l));
      return;
    }
    finally {}
  }
  
  private void initVideoSize(int paramInt1, int paramInt2)
  {
    int i = (int)(this.mSurfaceHeight * 1.0F / this.mSurfaceWidth * this.aeCaptureParam.c());
    if (bnxr.a().e()) {
      i = this.aeCaptureParam.b();
    }
    if (this.isDynamicResolutionMode)
    {
      arrayOfInt = babd.a(i, paramInt1, paramInt2);
      arrayOfInt = babd.a(arrayOfInt[0], arrayOfInt[1], this.aeCaptureParam.d(), this.aeCaptureParam.e(), 1.0F);
      this.videoWidth = arrayOfInt[0];
      this.videoHeight = arrayOfInt[1];
      return;
    }
    int[] arrayOfInt = babd.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, this.aeCaptureParam.a());
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
    arrayOfInt = babd.a(i, this.videoWidth, this.videoHeight);
    this.videoWidth = arrayOfInt[0];
    this.videoHeight = arrayOfInt[1];
  }
  
  private boolean isAEKitAvailable()
  {
    return (AEResUtil.isAEBaseSoReady()) && (this.mFilterProcess != null) && ((this.mFilterProcess instanceof blnq));
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
    bmbx.b("AECameraGLSurfaceView", "preAction");
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
      Object localObject = (blnq)this.mFilterProcess;
      if (this.aeExpressionRecognizer == null)
      {
        QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer == null, create it");
        this.aeExpressionRecognizer = new blwa();
        this.aeExpressionRecognizer.a();
      }
      long l = (SystemClock.elapsedRealtimeNanos() - this.gifRecordStartTimestamp) / 1000000L;
      int i = this.aeExpressionRecognizer.a();
      QLog.d("AECameraGLSurfaceView", 4, "recording gif, aeExpressionRecognizer.getFrameCount() == " + i);
      if ((i < 3) && ((float)l > (i + 0.5F) * 1000.0F) && (((blnq)localObject).c()))
      {
        localObject = (PTFaceAttr)((blnq)localObject).a().getFaceAttr();
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
  
  private void setTipsHandler(blnq paramblnq)
  {
    if (this.effectListener != null) {
      this.effectListener.onSetFilterProcess(paramblnq);
    }
  }
  
  private void showToast(String paramString)
  {
    ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.12(this, paramString));
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
    blnq localblnq = (blnq)this.mFilterProcess;
    if ((localblnq.b()) && (!localblnq.c()) && (!this.lastDetected))
    {
      this.notDetectedTimes += 1;
      if (this.notDetectedTimes >= 4)
      {
        notifyDetectChange(localblnq.b(), localblnq.c());
        this.notDetectedTimes = 0;
      }
    }
    if ((!this.lastDetected) && (localblnq.c())) {
      notifyDetectChange(localblnq.b(), localblnq.c());
    }
    if (!localblnq.b()) {
      notifyDetectChange(localblnq.b(), localblnq.c());
    }
    if ((this.lastDetected) && (localblnq.c())) {
      notifyDetectChange(localblnq.b(), localblnq.c());
    }
    this.lastDetected = localblnq.c();
  }
  
  public void capturePhotoByAEKit(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed(new AECameraGLSurfaceView.16(this), paramInt);
  }
  
  protected void finishCaptureVideo(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    int i = 1;
    if (this.captureListener != null) {
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.5(this, paramAEVideoCaptureResult));
    }
    babk.c();
    if (bbuc.a().a == 1) {}
    for (;;)
    {
      babc.g(i);
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
    return ((this.mFilterProcess instanceof blnq)) && (((blnq)this.mFilterProcess).a() != null) && (((blnq)this.mFilterProcess).a().getmPTSticker() != null) && (((blnq)this.mFilterProcess).a().getmPTSticker().needTouchTriggerEvent());
  }
  
  public void init(blno paramblno, AudioCapture paramAudioCapture)
  {
    if (this.aeCaptureParam != null) {
      throw new RuntimeException("init is already called");
    }
    if (paramblno == null) {
      throw new IllegalArgumentException("param captureParam is null");
    }
    this.aeCaptureParam = paramblno;
    if (QLog.isColorLevel()) {
      QLog.d("AECameraGLSurfaceView", 2, "setCaptureParam : " + paramblno);
    }
    this.hwVideoRecorder = new bagl();
    this.audioCapture = paramAudioCapture;
    this.mAudioChangeCapture = new azzv(this.aeCaptureParam.a, CodecParam.mAudioSampleRate, this);
    if (this.isNeedVoiceEncode)
    {
      paramblno = this.aeCaptureParam.a + File.separator + System.currentTimeMillis() + ".aac";
      this.audioCapture.a(true, paramblno);
    }
    this.fpsReporter.f();
    this.isInit = true;
  }
  
  public boolean isBeautyEnable()
  {
    return this.beautyEnable;
  }
  
  public boolean isEffectAvailable()
  {
    if (!isAEKitAvailable()) {
      return true;
    }
    if (!((blnq)this.mFilterProcess).e()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
    bmbx.b("AECameraGLSurfaceView", "[onAttachedToWindow]" + toString());
    super.onAttachedToWindow();
    bmbx.b("AECameraGLSurfaceView", "[onAttachedToWindow] end");
  }
  
  public void onAudioCaptured(String paramString)
  {
    if ((!this.isNeedVoiceEncode) && (!this.mAudioChangeCapture.a()))
    {
      bmbx.d("AECameraGLSurfaceView", "onAudioCaptured---filePath=" + paramString);
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
      bmbx.d("AECameraGLSurfaceView", "onAudioChangeCaptured---filePath=" + paramString);
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
      bmbx.d("AECameraGLSurfaceView", "onAudioError---errorCode=" + paramInt);
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
      queueEvent(new AECameraGLSurfaceView.6(this));
    }
  }
  
  public void onAudioUnInit() {}
  
  public void onCameraPreviewSizeChanged(int paramInt1, int paramInt2)
  {
    int k = 720;
    bmbx.b("AECameraGLSurfaceView", "onCameraPreviewSizeChanged---cameraWidth=" + paramInt1 + ", cameraHeight=" + paramInt2 + ", mSurfaceWidth=" + this.mSurfaceWidth + ", mSurfaceHeight=" + this.mSurfaceHeight);
    double d = this.mSurfaceWidth / this.mSurfaceHeight;
    this.videoWidth = paramInt1;
    this.videoHeight = ((int)(this.videoWidth / d));
    int i;
    int j;
    if (this.isGIFMode)
    {
      int[] arrayOfInt = babd.a(paramInt1, paramInt2, this.mSurfaceWidth, this.mSurfaceHeight, 1.0F);
      arrayOfInt = babd.a(640, arrayOfInt[0], arrayOfInt[1]);
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
      this.mFilterProcess.a(false);
    }
    this.fpsReporter.a(isFrontCamera());
  }
  
  public void onDestroy()
  {
    bmbx.d("AECameraGLSurfaceView", "[onDestroy]");
    if (QLog.isDevelopLevel()) {
      bmbx.a("AECameraGLSurfaceView", "### onDestroy, hashCode=" + this.mIdentityHashCode + " ###");
    }
    if (this.voiceRecognizer != null) {
      this.voiceRecognizer.a();
    }
    if (this.mFilterProcess != null) {
      this.mFilterProcess.a(true);
    }
    this.fpsReporter.g();
    if (this.hwVideoRecorder != null) {
      this.hwVideoRecorder.c();
    }
    queueEvent(new AECameraGLSurfaceView.4(this));
    bmbx.d("AECameraGLSurfaceView", "[onDestroy] end");
  }
  
  protected void onDetachedFromWindow()
  {
    bmbx.d("AECameraGLSurfaceView", "[onDetachedFromWindow]" + toString());
    super.onDetachedFromWindow();
    bmbx.d("AECameraGLSurfaceView", "[onDetachedFromWindow] end");
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
      bmau.a().a(paramGL10);
      if (this.mFilterProcess != null) {
        break;
      }
      return;
    }
    if (this.logTillHaveFrame) {
      bmau.a().a("FilterProcessInitFilters-begin");
    }
    this.mFilterProcess.g();
    if (this.logTillHaveFrame) {
      bmau.a().a("FilterProcessInitFilters-end");
    }
    paramGL10 = this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, this.isGIFMode);
    if (isAEKitAvailable())
    {
      blnq localblnq = (blnq)this.mFilterProcess;
      updateTipsView();
      checkShowTips();
      if (this.sceneListener != null) {
        this.sceneListener.a(this.selectedCamera, localblnq.a());
      }
      recordGifFrames(paramGL10[1]);
    }
    if ((this.preExtractFrame) && (!this.isGIFMode)) {
      this.mFilterProcess.c(paramGL10[1]);
    }
    drawToMediaCodec(paramGL10[1], null, null);
    if (this.mOnFrameDrawCallback != null) {
      queueEvent(new AECameraGLSurfaceView.10(this));
    }
    this.fpsReporter.d();
    if (!this.firstFrameActionDone)
    {
      this.firstFrameActionDone = true;
      bmbg.a().f();
      bmbc.a().ab();
      if (blrg.a()) {
        blrg.a(this.debugInfoCallback, 5000L);
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
      bmau.a().a(paramGL10);
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
      bmau.a().c();
      return;
    }
  }
  
  public void onEncodeAudioCaptured(String paramString)
  {
    if ((this.isNeedVoiceEncode) && (!this.mAudioChangeCapture.a()))
    {
      bmbx.d("AECameraGLSurfaceView", "onEncodeAudioCaptured---filePath=" + paramString);
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
      ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.9(this));
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
        ThreadManager.getUIHandler().post(new AECameraGLSurfaceView.8(this));
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
      bmau.a().a("onFrameAvailable");
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
    bmbx.d("AECameraGLSurfaceView", "[onPause] hashCode=" + this.mIdentityHashCode + " ###");
    queueEvent(new AECameraGLSurfaceView.3(this));
    this.isPaused = true;
    if (this.mOrientationEventListener != null) {
      this.mOrientationEventListener.disable();
    }
    if (this.sensorUtil != null) {
      this.sensorUtil.stop();
    }
    super.onPause();
    bmbx.d("AECameraGLSurfaceView", "[onPause] end");
  }
  
  public void onPhotoCaptured(Bitmap paramBitmap)
  {
    ThreadManager.excute(new AECameraGLSurfaceView.7(this, paramBitmap), 64, null, false);
  }
  
  public void onResume()
  {
    super.onResume();
    this.isPaused = false;
    if (this.sensorUtil != null) {
      this.sensorUtil.start();
    }
    if (QLog.isDevelopLevel()) {
      bmbx.a("AECameraGLSurfaceView", "### onResume, hashCode=" + this.mIdentityHashCode + " ###");
    }
    this.recordingEnabled = false;
    if ((this.mOrientationEventListener != null) && (this.mOrientationEventListener.canDetectOrientation())) {
      this.mOrientationEventListener.enable();
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
    bmbx.b("AECameraGLSurfaceView", "[onSurfaceChanged] + BEGIN, width = " + paramInt1 + ", height = " + paramInt2);
    bmau.a().a("onSurfaceChanged-begin");
    this.mSurfaceWidth = paramInt1;
    this.mSurfaceHeight = paramInt2;
    if (this.mFilterProcess != null) {
      this.mFilterProcess.a(this.mSurfaceWidth, this.mSurfaceHeight, 0, 0, paramInt1, paramInt2);
    }
    if (this.smoothLevel != 0) {
      setBeautyLevel(this.smoothLevel);
    }
    bmau.a().a("onSurfaceChanged-end");
    bmbx.b("AECameraGLSurfaceView", "[onSurfaceChanged] + END, width = " + paramInt1 + ", height = " + paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    bmbx.b("AECameraGLSurfaceView", "[onSurfaceCreated] + BEGIN");
    bmau.a().a("onSurfaceCreated-begin");
    initFilterProcess();
    bmau.a().a("onSurfaceCreated-end");
    bmbx.b("AECameraGLSurfaceView", "[onSurfaceCreated] + END");
  }
  
  protected void onSurfaceDestroy()
  {
    this.mIsTryLocationPermission = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    if ((!isAEKitAvailable()) || (this.mController == null)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    blnq localblnq = (blnq)this.mFilterProcess;
    if ((paramMotionEvent != null) && (localblnq.d()) && (!this.mController.c()))
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
        queueEvent(new AECameraGLSurfaceView.19(this, localblnq, f1, f2, i));
        continue;
        if (getDist(this.mTouchStartPoint.x, this.mTouchStartPoint.y, f1, f2) > i * 0.05F)
        {
          queueEvent(new AECameraGLSurfaceView.20(this, localblnq, f1, f2, i));
          continue;
          queueEvent(new AECameraGLSurfaceView.21(this, localblnq, f1, f2, i));
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
    queueEvent(new AECameraGLSurfaceView.15(this));
  }
  
  public void setAECaptureController(blnv paramblnv)
  {
    this.mController = paramblnv;
  }
  
  public void setAEKitInitListener(AECameraGLSurfaceView.AEKitInitListener paramAEKitInitListener)
  {
    this.mAEKitInitListener = paramAEKitInitListener;
  }
  
  public void setAeEditMaterialSelectedListener(blqi paramblqi)
  {
    this.aeEditMaterialSelectedListener = paramblqi;
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
      bmbx.b("AECameraGLSurfaceView", "[setBeautyLevel] level = " + paramInt + ", isAEKitAvailable is false");
      return;
    }
    this.smoothLevel = paramInt;
    queueEvent(new AECameraGLSurfaceView.17(this, paramInt));
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
    blnq localblnq;
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
            localblnq = (blnq)this.mFilterProcess;
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
    localblnq.a(paramFilterCategoryItem);
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
    ThreadManager.excute(new AECameraGLSurfaceView.14(this, new AECameraGLSurfaceView.13(this, paramString)), 64, null, true);
  }
  
  public void setMaterialMetaData(blvb paramblvb)
  {
    if ((paramblvb == null) || (paramblvb.equals(blvb.a)))
    {
      setMaterial(null);
      return;
    }
    setMaterial(paramblvb.a());
  }
  
  public void setPreExtractFrame(boolean paramBoolean)
  {
    this.preExtractFrame = paramBoolean;
  }
  
  public void setRecommendTextCallback(blwc paramblwc)
  {
    this.recommendTextCallback = paramblwc;
  }
  
  public void setSceneListener(blpl paramblpl)
  {
    this.sceneListener = paramblpl;
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
    queueEvent(new AECameraGLSurfaceView.18(this, paramInt));
  }
  
  public void setStickerInnerLutFilterListener(AEFilterManager.StickerInnerEffectFilterListener paramStickerInnerEffectFilterListener)
  {
    this.stickerInnerLutFilterListener = paramStickerInnerEffectFilterListener;
    if ((this.mFilterProcess != null) && ((this.mFilterProcess instanceof blnq))) {
      ((blnq)this.mFilterProcess).a(paramStickerInnerEffectFilterListener);
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
    bmbx.b("AECameraGLSurfaceView", "startCaptureVideo---recordingEnabled=" + this.recordingEnabled);
    this.fpsReporter.e();
    String str = this.aeCaptureParam.a + File.separator + System.currentTimeMillis() + ".mp4";
    if ((this.useVideoOrientation) && (!this.isGIFMode)) {}
    for (int i = babd.b(this.orientation);; i = 0)
    {
      this.encodeConfig = new bafx(str, this.videoWidth, this.videoHeight, this.aeCaptureParam.a(), this.aeCaptureParam.f(), false, i);
      this.encodeConfig.j = this.aeCaptureParam.h();
      this.encodeConfig.k = this.aeCaptureParam.i();
      this.videoCaptureResult = new AEVideoCaptureResult();
      this.videoCaptureResult.startTimeMs = System.currentTimeMillis();
      this.videoCaptureResult.orientation = this.orientation;
      this.videoCaptureResult.type = 0;
      this.recordingEnabled = true;
      babd.a(false, false);
      return;
    }
  }
  
  public void stopCaptureVideo()
  {
    bmbx.b("AECameraGLSurfaceView", "stopCaptureVideo---recordingEnabled=" + this.recordingEnabled + ", recordingStatus=" + this.mRecordingStatus + ", isPaused=" + this.isPaused);
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
      QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131689790), 0).a();
    }
    while (!isAEKitAvailable()) {
      return;
    }
    ((blnq)this.mFilterProcess).b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */