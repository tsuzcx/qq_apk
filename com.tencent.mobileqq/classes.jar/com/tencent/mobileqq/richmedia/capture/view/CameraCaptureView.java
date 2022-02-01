package com.tencent.mobileqq.richmedia.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.report.api.ICaptureReportUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.audio.AudioChangerManager;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.camera2.CameraFocusParams;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraProxyCallBack;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.shortvideo.util.MediaCodecUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.mobileqq.videocodec.audio.AudioCapture.AudioCaptureListener;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(18)
public class CameraCaptureView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, CameraCover.PictureCallback, Observer, CameraExceptionHandler.Callback, CameraProxy.CameraProxyCallBack, AudioCapture.AudioCaptureListener, HWEncodeListener
{
  public static final CameraProxy a = new CameraProxy(null, null);
  protected CameraCaptureView.VideoCaptureResult A;
  protected int B;
  protected AudioChangerManager C;
  protected int D;
  protected int E;
  protected SurfaceTexture F;
  protected final float[] G = new float[16];
  protected Map<String, RenderBuffer> H = new HashMap();
  protected TextureRender I;
  protected EglHandlerThread J;
  public EGLConfig K = null;
  public EGLContext L = null;
  protected NewFlowCameraOperator M;
  public CameraCaptureView.CaptureParam N;
  protected OrientationEventListener O;
  protected int P = 90;
  protected int Q = 0;
  protected boolean R = true;
  protected boolean S = false;
  protected boolean T = false;
  public boolean U = true;
  protected int V = 90;
  protected boolean W = false;
  public int Z = 0;
  private int aA;
  private boolean aB = false;
  private long aC = System.currentTimeMillis();
  private boolean aD = false;
  private boolean aE;
  private boolean aF;
  private volatile boolean aG = false;
  private volatile boolean aH = false;
  private boolean aI = false;
  private long aJ = 0L;
  private boolean aK = true;
  private boolean aL;
  private CameraCaptureView.OnSurfaceCreatedListener aM;
  public long aa = 0L;
  public int ab = 0;
  protected boolean ac = true;
  public CameraCaptureView.OutPreviewCallback ad;
  private CameraCaptureView.CameraChangeListener ae;
  private boolean af;
  private GLSurfaceView.EGLContextFactory ag = new CameraCaptureView.1(this);
  private CameraExceptionHandler ah;
  private Handler ai;
  private boolean aj = false;
  private volatile boolean ak = false;
  private boolean al = false;
  private int am;
  private int an;
  private boolean ao = false;
  private boolean ap = false;
  private boolean aq = false;
  private boolean ar = false;
  private View as;
  private int at;
  private int au;
  private boolean av = false;
  private DarkModeChecker aw;
  private DarkModeChecker.DarkModeListener ax;
  private boolean ay = true;
  private int az;
  protected int b = 2;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected CameraCaptureView.CaptureListener s;
  protected CameraCaptureView.CameraPermissionListener t;
  protected HWVideoRecorder u;
  protected EncodeConfig v;
  protected volatile boolean w;
  protected boolean x = false;
  protected volatile boolean y = false;
  protected AudioCapture z;
  
  public CameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    setEGLContextFactory(this.ag);
  }
  
  public CameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextFactory(this.ag);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.b == 1)
    {
      e(paramBoolean);
      return;
    }
    a.c(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    Activity localActivity = (Activity)getContext();
    if (paramBoolean)
    {
      if (this.as == null) {
        this.as = new View(localActivity);
      }
      this.as.setBackgroundColor(-1);
      this.as.setAlpha(0.7F);
      if (this.as.getParent() != null) {
        ((ViewGroup)this.as.getParent()).removeView(this.as);
      }
      localActivity.addContentView(this.as, new ViewGroup.LayoutParams(-1, -1));
      try
      {
        this.at = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.au = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness", 255);
        this.av = true;
        return;
      }
      catch (Exception localException)
      {
        this.at = 1;
        this.au = 100;
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("CameraCaptureView", 2, "turn FrontFlash Error ", localException);
      localException.printStackTrace();
    }
    else
    {
      if (this.av)
      {
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness", this.au);
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness_mode", this.at);
        this.av = false;
      }
      View localView = this.as;
      if ((localView != null) && (localView.getParent() != null)) {
        ((ViewGroup)this.as.getParent()).removeView(this.as);
      }
    }
  }
  
  private void m()
  {
    if (this.aj) {
      return;
    }
    throw new RuntimeException("Not inited. Must be called after setCaptureParam");
  }
  
  private void n() {}
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  protected void a()
  {
    this.b = CameraCaptureView.CaptureParam.a(this.N);
    if ((this.b == 1) && (!CameraUtils.d())) {
      this.b = 2;
    }
    if (this.ac) {
      setEGLContextClientVersion(2);
    }
    this.ai = new Handler();
    this.ah = new CameraExceptionHandler(this.ai, this);
    a.a(this.ah);
    setRenderer(this);
    setRenderMode(0);
    this.u = new HWVideoRecorder();
    if (this.N.i)
    {
      this.z = new AudioCapture(this.N.h, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this, a.e());
      this.C = new AudioChangerManager(this.N.h, CodecParam.mAudioSampleRate, this);
    }
    this.M = new NewFlowCameraOperator();
    this.aw = new DarkModeChecker();
    QmcfManager.getInstance().setCameraMode(this.b);
    this.aj = true;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.M == null) {
      return;
    }
    m();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestCameraFocus x:");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append("y: ");
      ((StringBuilder)localObject).append(paramFloat2);
      ((StringBuilder)localObject).append(", Orientation:");
      ((StringBuilder)localObject).append(((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation());
      QLog.i("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new CameraFocusParams();
    ((CameraFocusParams)localObject).a = paramFloat1;
    ((CameraFocusParams)localObject).b = paramFloat2;
    ((CameraFocusParams)localObject).c = getFocusSurfaceWidth();
    ((CameraFocusParams)localObject).d = getFocusSurfaceHeight();
    ((CameraFocusParams)localObject).f = this.M;
    ((CameraFocusParams)localObject).e = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).getPhotoOrientationDegree(this.Q);
    a.a((CameraFocusParams)localObject, new CameraCaptureView.4(this));
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = (this.P + 360 - 90) % 360;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("captureFrame : width = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" ; height = ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" ; orientation = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new RenderBuffer(paramInt2, paramInt3, 33984);
      ((RenderBuffer)localObject).bind();
      this.I.drawTexture(3553, paramInt1, null, null);
      ((RenderBuffer)localObject).unbind();
      Bitmap localBitmap = GlUtil.captureFrame(((RenderBuffer)localObject).getTexId(), paramInt2, paramInt3, -i1);
      ((RenderBuffer)localObject).destroy();
      ThreadManager.excute(new CameraCaptureView.16(this, localBitmap), 64, null, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label168:
      break label168;
    }
    Object localObject = this.s;
    if (localObject != null) {
      ((CameraCaptureView.CaptureListener)localObject).a(103);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.w)
    {
      EncodeConfig localEncodeConfig = this.v;
      if (localEncodeConfig != null)
      {
        int i1 = this.B;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            paramArrayOfFloat1 = new StringBuilder();
            paramArrayOfFloat1.append("unknown status ");
            paramArrayOfFloat1.append(this.B);
            throw new RuntimeException(paramArrayOfFloat1.toString());
          }
        }
        else
        {
          localEncodeConfig.a(EGL14.eglGetCurrentContext());
          this.u.a();
          this.u.a(this.v, this);
          this.B = 1;
        }
        this.u.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        return;
      }
    }
    paramInt1 = this.B;
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1)
      {
        this.u.b();
        l();
        this.B = 0;
        return;
      }
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("unknown status ");
      paramArrayOfFloat1.append(this.B);
      throw new RuntimeException(paramArrayOfFloat1.toString());
    }
  }
  
  protected void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, SystemClock.elapsedRealtimeNanos());
  }
  
  protected void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    CameraCaptureView.CaptureListener localCaptureListener = this.s;
    if (localCaptureListener != null) {
      localCaptureListener.a(paramPhotoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.10(this));
    ReportUtil.a();
    paramPhotoCaptureResult = (ICaptureReportUtil)QRoute.api(ICaptureReportUtil.class);
    int i2 = CameraControl.a().g;
    int i1 = 1;
    if (i2 != 1) {
      i1 = 2;
    }
    paramPhotoCaptureResult.reportPhotoTaken(i1);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    CameraCaptureView.CaptureListener localCaptureListener = this.s;
    if (localCaptureListener != null) {
      localCaptureListener.a(paramVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.11(this));
    ReportUtil.b();
    paramVideoCaptureResult = (ICaptureReportUtil)QRoute.api(ICaptureReportUtil.class);
    int i2 = CameraControl.a().g;
    int i1 = 1;
    if (i2 != 1) {
      i1 = 2;
    }
    paramVideoCaptureResult.reportVideoCapture(i1);
  }
  
  protected void a(CameraControl.CustomSize paramCustomSize)
  {
    this.f = paramCustomSize.a;
    this.e = paramCustomSize.b;
    if (!this.T)
    {
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.e, this.f, this.N.a, this.N.b, 1.0F);
      this.o = paramCustomSize[0];
      this.p = paramCustomSize[1];
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.e, this.f, this.c, this.d, this.N.c);
      this.q = paramCustomSize[0];
      this.r = paramCustomSize[1];
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).scaleVideoSize(CameraCaptureView.CaptureParam.b(this.N), this.q, this.r);
      this.q = paramCustomSize[0];
      this.r = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_aio_fbo");
      paramCustomSize.append(this.o);
      paramCustomSize.append(this.p);
      CameraCaptureView.CaptureParam.k = paramCustomSize.toString();
      queueEvent(new CameraCaptureView.7(this));
      if (QLog.isColorLevel())
      {
        paramCustomSize = new StringBuilder();
        paramCustomSize.append("onCameraSizeSelected(): cameraPreviewWidth=");
        paramCustomSize.append(this.e);
        paramCustomSize.append(",cameraPreviewHeight=");
        paramCustomSize.append(this.f);
        QLog.i("CameraCaptureView", 2, paramCustomSize.toString());
      }
    }
    else
    {
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).scaleVideoSize(CameraCaptureView.CaptureParam.b(this.N), this.e, this.f);
      int i1 = paramCustomSize[0];
      int i2 = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_riji_h_compress_fbo");
      paramCustomSize.append(i1);
      paramCustomSize.append(i2);
      CameraCaptureView.CaptureParam.l = paramCustomSize.toString();
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(i1, i2, this.N.a, this.N.b, 1.0F);
      this.g = paramCustomSize[0];
      this.h = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_riji_h_clip_fbo");
      paramCustomSize.append(this.g);
      paramCustomSize.append(this.h);
      CameraCaptureView.CaptureParam.m = paramCustomSize.toString();
      this.k = this.g;
      this.l = this.h;
      CameraCaptureView.CaptureParam.d(this.N);
      int i3 = CameraCaptureView.CaptureParam.e(this.N);
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).scaleVideoSize(i3, this.e, this.f);
      i3 = paramCustomSize[0];
      int i4 = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_riji_l_compress_fbo");
      paramCustomSize.append(i3);
      paramCustomSize.append(i4);
      CameraCaptureView.CaptureParam.n = paramCustomSize.toString();
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(i3, i4, this.N.a, this.N.b, 1.0F);
      this.i = paramCustomSize[0];
      this.j = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_riji_l_clip_fbo");
      paramCustomSize.append(this.i);
      paramCustomSize.append(this.j);
      CameraCaptureView.CaptureParam.o = paramCustomSize.toString();
      this.m = this.i;
      this.n = this.j;
      queueEvent(new CameraCaptureView.8(this, i1, i2, i3, i4));
      if (QLog.isColorLevel())
      {
        paramCustomSize = new StringBuilder();
        paramCustomSize.append("onCameraSizeSelected(): cameraPreviewWidth=");
        paramCustomSize.append(this.e);
        paramCustomSize.append(",cameraPreviewHeight=");
        paramCustomSize.append(this.f);
        paramCustomSize.append("， highCompressCameraPreviewWidth=");
        paramCustomSize.append(i1);
        paramCustomSize.append(",highCompressCamerareviewHeight=");
        paramCustomSize.append(i2);
        paramCustomSize.append("， highCameraClipWidth=");
        paramCustomSize.append(this.g);
        paramCustomSize.append(",highCameraClipHeight=");
        paramCustomSize.append(this.h);
        paramCustomSize.append(", highVideoWidth=");
        paramCustomSize.append(this.k);
        paramCustomSize.append(",highVideoHeight=");
        paramCustomSize.append(this.l);
        paramCustomSize.append(" ,lowCompressCameraPreviewWidth=");
        paramCustomSize.append(i3);
        paramCustomSize.append(",lowCompressCamerareviewHeight=");
        paramCustomSize.append(i4);
        paramCustomSize.append(" ,lowCameraClipWidth=");
        paramCustomSize.append(this.i);
        paramCustomSize.append(" ,lowCameraClipHeight=");
        paramCustomSize.append(this.j);
        paramCustomSize.append(",lowVideoWidth=");
        paramCustomSize.append(this.m);
        paramCustomSize.append(" ,lowVideoHeight=");
        paramCustomSize.append(this.n);
        QLog.i("CameraCaptureView", 2, paramCustomSize.toString());
      }
    }
  }
  
  public void a(Exception paramException) {}
  
  public void a(RuntimeException paramRuntimeException) {}
  
  public void a(String paramString)
  {
    a(new CameraCaptureView.PhotoCaptureResult(1, 0, paramString, null, this.P));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.T) {
      if (paramBoolean)
      {
        this.p = this.j;
        this.o = this.i;
        if (this.S)
        {
          localObject = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.k, this.l, this.c, this.d, this.N.c);
          this.q = localObject[0];
          this.r = localObject[1];
        }
        else
        {
          localObject = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.m, this.n, this.c, this.d, this.N.c);
          this.q = localObject[0];
          this.r = localObject[1];
        }
      }
      else
      {
        this.p = this.h;
        this.o = this.g;
        localObject = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.k, this.l, this.c, this.d, this.N.c);
        this.q = localObject[0];
        this.r = localObject[1];
      }
    }
    Object localObject = this.M;
    if (localObject != null) {
      ((NewFlowCameraOperator)localObject).a(this.p, this.o, getFocusSurfaceWidth(), getFocusSurfaceHeight());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("compress=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" onCameraSizeUpdate cameraClipHeight = ");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(" cameraClipWidth=");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append(" videoWidth=");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append(" videoHeight=");
      ((StringBuilder)localObject).append(this.r);
      QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.ay)
    {
      int i4 = this.e;
      int i5 = this.f;
      int i6 = this.az;
      int i2 = i4;
      int i1 = i5;
      if (i6 > 0)
      {
        int i3 = this.aA;
        i2 = i4;
        i1 = i5;
        if (i3 > 0)
        {
          i1 = i6;
          i2 = i3;
        }
      }
      this.aw.a(paramArrayOfByte, i2, i1, this.ax);
    }
    CameraCaptureView.OutPreviewCallback localOutPreviewCallback = this.ad;
    if (localOutPreviewCallback != null) {
      localOutPreviewCallback.a(paramArrayOfByte, paramCamera);
    }
    CameraControl.a().a(true, paramArrayOfByte);
  }
  
  protected int b(int paramInt)
  {
    return paramInt;
  }
  
  protected int b(boolean paramBoolean)
  {
    int i1 = this.D;
    if (paramBoolean) {
      paramBoolean = i();
    } else if (this.T) {
      paramBoolean = j();
    } else {
      paramBoolean = false;
    }
    if (this.T)
    {
      int i2;
      int i3;
      Object localObject2;
      if (paramBoolean)
      {
        RenderBuffer localRenderBuffer = (RenderBuffer)this.H.get(CameraCaptureView.CaptureParam.n);
        i2 = i1;
        if (localRenderBuffer != null)
        {
          localRenderBuffer.bind();
          synchronized (this.F)
          {
            this.F.getTransformMatrix(this.G);
            this.I.drawTexture(36197, this.D, this.G, null);
            QmcfManager.getInstance().setSTMatrix(this.G);
            QmcfManager.getInstance().setIsQQRun(false);
            n();
            i2 = localRenderBuffer.getTexId();
            localRenderBuffer.unbind();
          }
        }
        ??? = (RenderBuffer)this.H.get(CameraCaptureView.CaptureParam.o);
        i1 = i2;
        if (??? != null)
        {
          i1 = i2;
          if (localObject1 != null)
          {
            if (localObject1.getWidth() == ((RenderBuffer)???).getWidth())
            {
              i3 = i2;
              if (localObject1.getHeight() == ((RenderBuffer)???).getHeight()) {}
            }
            else
            {
              ((RenderBuffer)???).bind();
              localObject2 = GPUBaseFilter.caculateCenterCropMvpMatrix(localObject1.getWidth(), localObject1.getHeight(), ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
              this.I.drawTexture(3553, i2, null, (float[])localObject2);
              i3 = ((RenderBuffer)???).getTexId();
              ((RenderBuffer)???).unbind();
            }
            if (this.o == ((RenderBuffer)???).getWidth())
            {
              i1 = i3;
              if (this.p == ((RenderBuffer)???).getHeight()) {}
            }
            else
            {
              a(true);
              return i3;
            }
          }
        }
      }
      else
      {
        localObject2 = (RenderBuffer)this.H.get(CameraCaptureView.CaptureParam.l);
        i2 = i1;
        if (localObject2 != null)
        {
          ((RenderBuffer)localObject2).bind();
          synchronized (this.F)
          {
            this.F.getTransformMatrix(this.G);
            this.I.drawTexture(36197, this.D, this.G, null);
            QmcfManager.getInstance().setSTMatrix(this.G);
            QmcfManager.getInstance().setIsQQRun(false);
            n();
            i2 = ((RenderBuffer)localObject2).getTexId();
            ((RenderBuffer)localObject2).unbind();
          }
        }
        ??? = (RenderBuffer)this.H.get(CameraCaptureView.CaptureParam.m);
        i1 = i2;
        if (??? != null)
        {
          i1 = i2;
          if (localObject3 != null)
          {
            if (localObject3.getWidth() == ((RenderBuffer)???).getWidth())
            {
              i3 = i2;
              if (localObject3.getHeight() == ((RenderBuffer)???).getHeight()) {}
            }
            else
            {
              ((RenderBuffer)???).bind();
              ??? = GPUBaseFilter.caculateCenterCropMvpMatrix(localObject3.getWidth(), localObject3.getHeight(), ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
              this.I.drawTexture(3553, i2, null, (float[])???);
              i3 = ((RenderBuffer)???).getTexId();
              ((RenderBuffer)???).unbind();
            }
            if (this.o == ((RenderBuffer)???).getWidth())
            {
              i1 = i3;
              if (this.p == ((RenderBuffer)???).getHeight()) {}
            }
            else
            {
              a(false);
              return i3;
            }
          }
        }
      }
    }
    else
    {
      ??? = (RenderBuffer)this.H.get(CameraCaptureView.CaptureParam.k);
      if (??? != null)
      {
        ((RenderBuffer)???).bind();
        synchronized (this.F)
        {
          this.F.getTransformMatrix(this.G);
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.e, this.f, ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
          this.I.drawTexture(36197, this.D, this.G, arrayOfFloat);
          QmcfManager.getInstance().setSTMatrix(this.G);
          n();
          ((RenderBuffer)???).unbind();
          return ((RenderBuffer)???).getTexId();
        }
      }
    }
    return i1;
  }
  
  public void b()
  {
    int i2 = Build.VERSION.SDK_INT;
    int i1 = 0;
    if ((i2 >= 23) && (this.t != null))
    {
      Activity localActivity = (Activity)getContext();
      i2 = localActivity.checkSelfPermission("android.permission.CAMERA");
      int i3 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i2), " audio: ", Integer.valueOf(i3) });
      }
      if ((i2 != 0) || (i3 != 0))
      {
        if (this.aG) {
          break label121;
        }
        this.aG = true;
        this.t.e();
        return;
      }
    }
    i1 = 1;
    label121:
    if ((i1 != 0) || (this.aH))
    {
      c();
      e();
    }
  }
  
  protected void c()
  {
    if (!this.aj) {
      return;
    }
    if (this.ak) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "openCamera");
    }
    boolean bool = false;
    this.al = false;
    this.am = 0;
    this.an = 0;
    a.a(this);
    a.b(this.b);
    this.ak = true;
    if (this.N.i)
    {
      localObject = this.z;
      if (localObject != null) {
        ((AudioCapture)localObject).i();
      }
    }
    Object localObject = this.M;
    if (localObject != null)
    {
      if (this.b == 1) {
        bool = true;
      }
      ((NewFlowCameraOperator)localObject).a(bool);
    }
    com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.b = this.b;
  }
  
  protected void c(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.c, this.d);
    this.I.drawTexture(3553, paramInt, null, null);
  }
  
  public void c(boolean paramBoolean)
  {
    a.d(paramBoolean);
  }
  
  public void d()
  {
    if (!this.aj) {
      return;
    }
    if (!this.ak) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "stopCamera");
    }
    a.a(false);
    this.al = false;
    a.b(this.aB);
    this.ak = false;
    if (this.N.i)
    {
      AudioCapture localAudioCapture = this.z;
      if (localAudioCapture != null) {
        localAudioCapture.j();
      }
    }
    a.b(this);
    CameraHelper.a(this.b);
    if ((this.aI) && (this.aJ > 0L))
    {
      this.aa = (System.currentTimeMillis() - this.aJ);
      this.ab = (this.Z - 15);
      this.aJ = 0L;
    }
  }
  
  public void e()
  {
    if (!this.aj) {
      return;
    }
    if ((this.ap) && (this.ak) && ((!this.al) || (this.am != this.c) || (this.an != this.d)))
    {
      Object localObject;
      if ((this.N.a == 0) || (this.N.b == 0) || (this.aK))
      {
        localObject = this.N;
        ((CameraCaptureView.CaptureParam)localObject).a = this.c;
        ((CameraCaptureView.CaptureParam)localObject).b = this.d;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCameraPreview, clipWidth:");
        ((StringBuilder)localObject).append(this.N.a);
        ((StringBuilder)localObject).append(", clipHeight:");
        ((StringBuilder)localObject).append(this.N.b);
        ((StringBuilder)localObject).append(", surfaceWidth:");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(", surfaceHeight:");
        ((StringBuilder)localObject).append(this.d);
        QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
      }
      if (this.T) {
        a.a(new CameraControl.CustomSize(this.d, this.c), new CameraControl.CustomSize(this.N.a, this.N.b), 0, 30, this.T);
      } else {
        a.a(new CameraControl.CustomSize(CameraCaptureView.CaptureParam.b(this.N), CameraCaptureView.CaptureParam.c(this.N)), new CameraControl.CustomSize(this.N.a, this.N.b), 0, 30, this.T);
      }
      a.a(this.F, null, this, true);
      f();
      this.al = true;
      this.am = this.c;
      this.an = this.d;
    }
  }
  
  protected void f() {}
  
  protected void g()
  {
    ReportUtil.a(this.A.videoFrameCount, this.A.videoMp4FilePath);
  }
  
  public String getCaptureDir()
  {
    return this.N.h;
  }
  
  public CameraCaptureView.CaptureParam getCaptureParam()
  {
    return this.N;
  }
  
  public boolean getDarkMode()
  {
    return false;
  }
  
  protected int getFocusSurfaceHeight()
  {
    return this.d;
  }
  
  protected int getFocusSurfaceWidth()
  {
    return this.c;
  }
  
  public MediaFormat getMediaFormat()
  {
    HWVideoRecorder localHWVideoRecorder = this.u;
    if (localHWVideoRecorder != null) {
      return localHWVideoRecorder.d();
    }
    return null;
  }
  
  public int getSelectedCamera()
  {
    return this.b;
  }
  
  public boolean getSwitchFlash()
  {
    return false;
  }
  
  protected void h()
  {
    this.O = new CameraCaptureView.13(this, getContext());
    if (this.O.canDetectOrientation()) {
      this.O.enable();
    }
    Object localObject = this.s;
    if (localObject != null) {
      ((CameraCaptureView.CaptureListener)localObject).a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Create to FirstFrameShown cost : ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.aC);
      ((StringBuilder)localObject).append("ms");
      QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected boolean i()
  {
    return false;
  }
  
  protected boolean j()
  {
    return false;
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceDestroy");
    }
    this.ap = false;
    if (!MediaCodecUtil.b())
    {
      localObject = this.H.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RenderBuffer)((Iterator)localObject).next()).destroy();
      }
      this.H.clear();
      GlUtil.deleteTexture(this.D);
      localObject = this.F;
      if (localObject != null) {
        ((SurfaceTexture)localObject).release();
      }
      localObject = this.I;
      if (localObject != null) {
        ((TextureRender)localObject).release();
      }
    }
    Object localObject = this.F;
    if (localObject != null) {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
    }
    d();
  }
  
  protected void l() {}
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" notify : eventId = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ; sender = ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" ; args = ");
      localStringBuilder.append(Arrays.toString(paramVarArgs));
      QLog.d("CameraCaptureView", 2, localStringBuilder.toString());
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 13)
        {
          if (paramInt != 14) {
            return;
          }
          if ((paramVarArgs[0] instanceof CameraControl.CustomSize))
          {
            a((CameraControl.CustomSize)paramVarArgs[0]);
            paramObject = this.s;
            if (paramObject != null) {
              paramObject.a(true, "");
            }
            if ((paramVarArgs.length >= 2) && ((paramVarArgs[1] instanceof CameraControl.CustomSize)))
            {
              paramObject = (CameraControl.CustomSize)paramVarArgs[1];
              this.az = paramObject.a;
              this.aA = paramObject.b;
            }
          }
          else if ((paramVarArgs[0] instanceof String))
          {
            paramObject = this.s;
            if (paramObject != null)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[Camera2]setCamera2 Params error:");
              localStringBuilder.append(paramVarArgs[0]);
              paramObject.a(false, localStringBuilder.toString());
            }
          }
        }
        else if ((paramVarArgs[0] instanceof Integer))
        {
          paramObject = this.s;
          if (paramObject != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[Camera2]openCamera2 error:");
            localStringBuilder.append(paramVarArgs[0]);
            paramObject.a(false, localStringBuilder.toString());
          }
        }
      }
      else if ((paramVarArgs[0] instanceof CameraControl.CustomSize))
      {
        a((CameraControl.CustomSize)paramVarArgs[0]);
        paramObject = this.s;
        if (paramObject != null) {
          paramObject.a(true, "");
        }
      }
      else if ((paramVarArgs[0] instanceof String))
      {
        paramObject = this.s;
        if (paramObject != null) {
          paramObject.a(false, (String)paramVarArgs[0]);
        }
      }
    }
    else if ((paramVarArgs[0] instanceof String))
    {
      paramObject = this.s;
      if (paramObject != null) {
        paramObject.a(false, (String)paramVarArgs[0]);
      }
    }
  }
  
  public void onAudioCaptured(String paramString)
  {
    if (!this.C.a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAudioCaptured filePath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.A;
      ((CameraCaptureView.VideoCaptureResult)localObject).audioDataFilePath = paramString;
      if (((CameraCaptureView.VideoCaptureResult)localObject).videoMp4FilePath != null) {
        a(this.A);
      }
    }
  }
  
  public void onAudioChangeCaptured(String paramString)
  {
    if (this.C.a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAudioCaptured filePath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.A;
      ((CameraCaptureView.VideoCaptureResult)localObject).audioDataFilePath = paramString;
      if (((CameraCaptureView.VideoCaptureResult)localObject).videoMp4FilePath != null) {
        a(this.A);
      }
    }
  }
  
  public void onAudioError(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAudioError. errorCode = ");
    localStringBuilder.append(paramInt);
    QLog.e("CameraCaptureView", 2, localStringBuilder.toString());
    if ((paramInt != -4) && (paramInt != -3) && (paramInt != -2) && (paramInt != -1)) {
      return;
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.12(this));
  }
  
  public void onAudioFrames(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void onAudioInit() {}
  
  public void onAudioUnInit() {}
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.e != 0) && (this.f != 0) && (this.H.size() != 0))
    {
      if (!this.ak)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraCaptureView", 2, "onDrawFrame ignore");
        }
        return;
      }
      long l1 = System.currentTimeMillis();
      if ((!this.aI) && (this.Z > 15))
      {
        this.aI = true;
        this.aJ = l1;
      }
      boolean bool = this.y;
      this.E = b(bool);
      int i1 = a(this.E);
      c(b(i1));
      a(i1, null, null);
      if (!this.x)
      {
        this.x = true;
        h();
      }
      if (bool)
      {
        a(i1, this.o, this.p);
        this.y = false;
      }
      this.Z += 1;
      i1 = this.Z;
      FrameBufferCache.getInstance().forceRecycle();
      if (!this.af)
      {
        ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).oldAioDrawFirstFrameDone();
        this.af = true;
      }
      return;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onDrawFrame clean");
    }
  }
  
  public void onEncodeAudioCaptured(String paramString) {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.A.errorCode = paramInt;
    paramThrowable = this.s;
    if (paramThrowable != null) {
      paramThrowable.a(104);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEncodeFinish filePath = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
    }
    this.A.videoMp4FilePath = paramString;
    if ((this.N.i) && (this.z != null))
    {
      if (this.A.audioDataFilePath != null)
      {
        a(this.A);
      }
      else if (this.C.a())
      {
        this.C.c();
        this.z.h();
      }
      else
      {
        this.z.h();
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append(this.N.h);
      paramString.append("/noaudio");
      paramString = paramString.toString();
      FileUtils.createFileIfNotExits(paramString);
      localObject = this.A;
      ((CameraCaptureView.VideoCaptureResult)localObject).audioDataFilePath = paramString;
      a((CameraCaptureView.VideoCaptureResult)localObject);
    }
    ThreadManager.postImmediately(new CameraCaptureView.9(this), null, false);
  }
  
  public void onEncodeFrame()
  {
    CameraCaptureView.VideoCaptureResult localVideoCaptureResult = this.A;
    localVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void onEncodeStart()
  {
    this.A.videoFrameCount = 0;
    if ((this.N.i) && (this.z != null)) {
      if (this.C.a())
      {
        this.C.b();
        this.z.b();
      }
      else
      {
        this.z.b();
      }
    }
    CameraCaptureView.CaptureListener localCaptureListener = this.s;
    if (localCaptureListener != null) {
      localCaptureListener.b();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.J.a()) && (!this.W))
    {
      this.J.b().post(new CameraCaptureView.14(this, paramSurfaceTexture));
      return;
    }
    queueEvent(new CameraCaptureView.15(this, paramSurfaceTexture));
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onPause");
    }
    this.aE = false;
    this.aF = true;
    d();
    this.ai.removeCallbacksAndMessages(null);
    if (this.ar) {
      d(false);
    }
    a.a(null);
    OrientationEventListener localOrientationEventListener = this.O;
    if (localOrientationEventListener != null) {
      localOrientationEventListener.disable();
    }
    ThreadManagerV2.excute(new CameraCaptureView.3(this), 16, null, false);
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onResume");
    }
    this.aF = false;
    if (this.aE)
    {
      QLog.d("CameraCaptureView", 1, "onResume, blockCameraFlag return");
      return;
    }
    b();
    Object localObject = this.aw;
    if (localObject != null) {
      ((DarkModeChecker)localObject).a();
    }
    localObject = this.O;
    if ((localObject != null) && (((OrientationEventListener)localObject).canDetectOrientation())) {
      this.O.enable();
    }
    ThreadManagerV2.excute(new CameraCaptureView.2(this), 16, null, false);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramGL10 = new StringBuilder();
      paramGL10.append("onSurfaceChanged(): width ");
      paramGL10.append(paramInt1);
      paramGL10.append(";height");
      paramGL10.append(paramInt2);
      QLog.d("CameraCaptureView", 2, paramGL10.toString());
    }
    this.c = paramInt1;
    this.d = paramInt2;
    this.ap = true;
    if ((!this.aE) && (!this.aF))
    {
      if (!this.aL)
      {
        b();
        this.aL = true;
      }
      return;
    }
    QLog.d("CameraCaptureView", 1, new Object[] { "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(this.aE), " ", Boolean.valueOf(this.aF) });
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceCreated");
    }
    this.ap = false;
    paramEGLConfig = this.J;
    this.J = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.J.start();
    if (paramEGLConfig != null) {
      paramEGLConfig.quitSafely();
    }
    this.D = GlUtil.createTexture(36197);
    this.F = new SurfaceTexture(this.D);
    this.F.setOnFrameAvailableListener(this);
    this.I = new TextureRender();
    this.B = 0;
    this.W = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isNeedDrawOnOpenGLSingleThread();
    paramEGLConfig = this.aM;
    if (paramEGLConfig != null) {
      paramEGLConfig.a();
    }
    QmcfDevicesStrategy.c(paramGL10.glGetString(7937));
  }
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    this.aE = paramBoolean;
  }
  
  public void setCameraChangeListener(CameraCaptureView.CameraChangeListener paramCameraChangeListener)
  {
    this.ae = paramCameraChangeListener;
  }
  
  public void setCameraPermissionFinish(boolean paramBoolean)
  {
    this.aH = paramBoolean;
  }
  
  public void setCameraPermissionListener(CameraCaptureView.CameraPermissionListener paramCameraPermissionListener)
  {
    this.t = paramCameraPermissionListener;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "setCameraPermissionResult, ", Boolean.valueOf(paramBoolean) });
    }
    this.aH = true;
    c();
    e();
  }
  
  public void setCaptureListener(CameraCaptureView.CaptureListener paramCaptureListener)
  {
    this.s = paramCaptureListener;
  }
  
  public void setCaptureParam(CameraCaptureView.CaptureParam paramCaptureParam)
  {
    if (this.N == null)
    {
      this.N = paramCaptureParam;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCaptureParam : ");
        localStringBuilder.append(paramCaptureParam);
        QLog.d("CameraCaptureView", 2, localStringBuilder.toString());
      }
      a();
      return;
    }
    throw new RuntimeException("setCaptureParam is already called");
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.ay = paramBoolean;
  }
  
  public void setDarkModeListener(DarkModeChecker.DarkModeListener paramDarkModeListener)
  {
    this.ax = paramDarkModeListener;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.T = paramBoolean;
  }
  
  public void setOnSurfaceCreatedListener(CameraCaptureView.OnSurfaceCreatedListener paramOnSurfaceCreatedListener)
  {
    this.aM = paramOnSurfaceCreatedListener;
  }
  
  public void setPreviewCallback(CameraCaptureView.OutPreviewCallback paramOutPreviewCallback)
  {
    this.ad = paramOutPreviewCallback;
  }
  
  public void setSceneMode(String paramString)
  {
    m();
    a.a(paramString);
  }
  
  public void setSegmentMode(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  public void setSyncStopCamera(boolean paramBoolean)
  {
    this.aB = paramBoolean;
  }
  
  public void setUseVideoOrientation(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }
  
  public void setZoom(int paramInt)
  {
    m();
    a.c(paramInt);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "surfaceCreated");
    }
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "surfaceDestroyed");
    }
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */