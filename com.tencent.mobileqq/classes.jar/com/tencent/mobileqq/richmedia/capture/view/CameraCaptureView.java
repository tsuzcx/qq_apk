package com.tencent.mobileqq.richmedia.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
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
  public static final CameraProxy a;
  private int jdField_A_of_type_Int;
  private boolean jdField_A_of_type_Boolean = true;
  private int jdField_B_of_type_Int;
  private boolean jdField_B_of_type_Boolean;
  private int C;
  private int D;
  private int E;
  protected int a;
  public long a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new CameraCaptureView.1(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected OrientationEventListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected NewFlowCameraOperator a;
  protected AudioChangerManager a;
  private DarkModeChecker.DarkModeListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker$DarkModeListener;
  private DarkModeChecker jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker;
  private CameraCaptureView.CameraChangeListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CameraChangeListener;
  protected CameraCaptureView.CameraPermissionListener a;
  protected CameraCaptureView.CaptureListener a;
  public CameraCaptureView.CaptureParam a;
  private CameraCaptureView.OnSurfaceCreatedListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OnSurfaceCreatedListener;
  public CameraCaptureView.OutPreviewCallback a;
  protected CameraCaptureView.VideoCaptureResult a;
  private CameraExceptionHandler jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
  protected AudioCapture a;
  protected EglHandlerThread a;
  protected EncodeConfig a;
  protected HWVideoRecorder a;
  protected TextureRender a;
  protected Map<String, RenderBuffer> a;
  public EGLConfig a;
  public EGLContext a;
  protected volatile boolean a;
  protected final float[] a;
  protected int b;
  private long b;
  protected boolean b;
  protected int c;
  private long c;
  protected volatile boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  protected boolean f;
  protected int g;
  public boolean g;
  protected int h;
  protected boolean h;
  protected int i;
  protected boolean i;
  protected int j;
  private boolean j;
  protected int k;
  private boolean k;
  protected int l;
  private volatile boolean l;
  protected int m;
  private boolean m;
  protected int n;
  private boolean n;
  protected int o;
  private boolean o;
  protected int p;
  private boolean p;
  protected int q;
  private boolean q;
  protected int r;
  private boolean r;
  protected int s;
  private boolean s;
  protected int t;
  private boolean t;
  protected int u;
  private boolean u;
  protected int v;
  private boolean v;
  protected int w;
  private boolean w;
  public int x;
  private volatile boolean x;
  public int y;
  private volatile boolean y;
  private int jdField_z_of_type_Int;
  private boolean jdField_z_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(null, null);
  }
  
  public CameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_o_of_type_Boolean = false;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = true;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_u_of_type_Int = 90;
    this.jdField_v_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_w_of_type_Int = 90;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_x_of_type_Boolean = false;
    this.jdField_y_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_x_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_y_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  public CameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_o_of_type_Boolean = false;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = true;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_u_of_type_Int = 90;
    this.jdField_v_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_w_of_type_Int = 90;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_x_of_type_Boolean = false;
    this.jdField_y_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_x_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_y_of_type_Int = 0;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      d(paramBoolean);
      return;
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    Activity localActivity = (Activity)getContext();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = new View(localActivity);
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.7F);
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      localActivity.addContentView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
      try
      {
        this.jdField_B_of_type_Int = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.C = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness", 255);
        this.jdField_r_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        this.jdField_B_of_type_Int = 1;
        this.C = 100;
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e("CameraCaptureView", 2, "turn FrontFlash Error ", localException);
      localException.printStackTrace();
    }
    else
    {
      if (this.jdField_r_of_type_Boolean)
      {
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness", this.C);
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness_mode", this.jdField_B_of_type_Int);
        this.jdField_r_of_type_Boolean = false;
      }
      View localView = this.jdField_a_of_type_AndroidViewView;
      if ((localView != null) && (localView.getParent() != null)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_k_of_type_Boolean) {
      return;
    }
    throw new RuntimeException("Not inited. Must be called after setCaptureParam");
  }
  
  private void l() {}
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  protected int a(boolean paramBoolean)
  {
    int i1 = this.jdField_s_of_type_Int;
    if (paramBoolean) {
      paramBoolean = a();
    } else if (this.jdField_f_of_type_Boolean) {
      paramBoolean = b();
    } else {
      paramBoolean = false;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      int i2;
      int i3;
      Object localObject2;
      if (paramBoolean)
      {
        RenderBuffer localRenderBuffer = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.f);
        i2 = i1;
        if (localRenderBuffer != null)
        {
          localRenderBuffer.bind();
          synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
          {
            this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
            this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null);
            QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
            QmcfManager.getInstance().setIsQQRun(false);
            l();
            i2 = localRenderBuffer.getTexId();
            localRenderBuffer.unbind();
          }
        }
        ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.g);
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
              this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, i2, null, (float[])localObject2);
              i3 = ((RenderBuffer)???).getTexId();
              ((RenderBuffer)???).unbind();
            }
            if (this.jdField_n_of_type_Int == ((RenderBuffer)???).getWidth())
            {
              i1 = i3;
              if (this.jdField_o_of_type_Int == ((RenderBuffer)???).getHeight()) {}
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
        localObject2 = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.d);
        i2 = i1;
        if (localObject2 != null)
        {
          ((RenderBuffer)localObject2).bind();
          synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
          {
            this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
            this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null);
            QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
            QmcfManager.getInstance().setIsQQRun(false);
            l();
            i2 = ((RenderBuffer)localObject2).getTexId();
            ((RenderBuffer)localObject2).unbind();
          }
        }
        ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.e);
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
              this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, i2, null, (float[])???);
              i3 = ((RenderBuffer)???).getTexId();
              ((RenderBuffer)???).unbind();
            }
            if (this.jdField_n_of_type_Int == ((RenderBuffer)???).getWidth())
            {
              i1 = i3;
              if (this.jdField_o_of_type_Int == ((RenderBuffer)???).getHeight()) {}
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
      ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.c);
      if (??? != null)
      {
        ((RenderBuffer)???).bind();
        synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
          float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
          QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
          l();
          ((RenderBuffer)???).unbind();
          return ((RenderBuffer)???).getTexId();
        }
      }
    }
    return i1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int = CameraCaptureView.CaptureParam.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam);
    if ((this.jdField_a_of_type_Int == 1) && (!CameraUtils.d())) {
      this.jdField_a_of_type_Int = 2;
    }
    if (this.jdField_i_of_type_Boolean) {
      setEGLContextClientVersion(2);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler = new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler);
    setRenderer(this);
    setRenderMode(0);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_JavaLangString, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this, jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager = new AudioChangerManager(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_JavaLangString, CodecParam.mAudioSampleRate, this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = new NewFlowCameraOperator();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker = new DarkModeChecker();
    QmcfManager.getInstance().setCameraMode(this.jdField_a_of_type_Int);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator == null) {
      return;
    }
    k();
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
    ((CameraFocusParams)localObject).jdField_a_of_type_Float = paramFloat1;
    ((CameraFocusParams)localObject).jdField_b_of_type_Float = paramFloat2;
    ((CameraFocusParams)localObject).jdField_a_of_type_Int = b();
    ((CameraFocusParams)localObject).jdField_b_of_type_Int = c();
    ((CameraFocusParams)localObject).jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    ((CameraFocusParams)localObject).jdField_c_of_type_Int = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).getPhotoOrientationDegree(this.jdField_v_of_type_Int);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a((CameraFocusParams)localObject, new CameraCaptureView.4(this));
  }
  
  protected void a(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, null);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = (this.jdField_u_of_type_Int + 360 - 90) % 360;
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
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, null);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
    if (localObject != null) {
      ((CameraCaptureView.CaptureListener)localObject).a(103);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      EncodeConfig localEncodeConfig = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig;
      if (localEncodeConfig != null)
      {
        int i1 = this.jdField_r_of_type_Int;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            paramArrayOfFloat1 = new StringBuilder();
            paramArrayOfFloat1.append("unknown status ");
            paramArrayOfFloat1.append(this.jdField_r_of_type_Int);
            throw new RuntimeException(paramArrayOfFloat1.toString());
          }
        }
        else
        {
          localEncodeConfig.a(EGL14.eglGetCurrentContext());
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a();
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig, this);
          this.jdField_r_of_type_Int = 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
        return;
      }
    }
    paramInt1 = this.jdField_r_of_type_Int;
    if (paramInt1 != 0)
    {
      if (paramInt1 == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.b();
        j();
        this.jdField_r_of_type_Int = 0;
        return;
      }
      paramArrayOfFloat1 = new StringBuilder();
      paramArrayOfFloat1.append("unknown status ");
      paramArrayOfFloat1.append(this.jdField_r_of_type_Int);
      throw new RuntimeException(paramArrayOfFloat1.toString());
    }
  }
  
  protected void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, SystemClock.elapsedRealtimeNanos());
  }
  
  protected void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    CameraCaptureView.CaptureListener localCaptureListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
    if (localCaptureListener != null) {
      localCaptureListener.a(paramPhotoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.10(this));
    ReportUtil.a();
    paramPhotoCaptureResult = (ICaptureReportUtil)QRoute.api(ICaptureReportUtil.class);
    int i2 = CameraControl.a().jdField_a_of_type_Int;
    int i1 = 1;
    if (i2 != 1) {
      i1 = 2;
    }
    paramPhotoCaptureResult.reportPhotoTaken(i1);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    CameraCaptureView.CaptureListener localCaptureListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
    if (localCaptureListener != null) {
      localCaptureListener.a(paramVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.11(this));
    ReportUtil.b();
    paramVideoCaptureResult = (ICaptureReportUtil)QRoute.api(ICaptureReportUtil.class);
    int i2 = CameraControl.a().jdField_a_of_type_Int;
    int i1 = 1;
    if (i2 != 1) {
      i1 = 2;
    }
    paramVideoCaptureResult.reportVideoCapture(i1);
  }
  
  protected void a(CameraControl.CustomSize paramCustomSize)
  {
    this.jdField_e_of_type_Int = paramCustomSize.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = paramCustomSize.jdField_b_of_type_Int;
    if (!this.jdField_f_of_type_Boolean)
    {
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int, 1.0F);
      this.jdField_n_of_type_Int = paramCustomSize[0];
      this.jdField_o_of_type_Int = paramCustomSize[1];
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = paramCustomSize[0];
      this.jdField_q_of_type_Int = paramCustomSize[1];
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).scaleVideoSize(CameraCaptureView.CaptureParam.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), this.jdField_p_of_type_Int, this.jdField_q_of_type_Int);
      this.jdField_p_of_type_Int = paramCustomSize[0];
      this.jdField_q_of_type_Int = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_aio_fbo");
      paramCustomSize.append(this.jdField_n_of_type_Int);
      paramCustomSize.append(this.jdField_o_of_type_Int);
      CameraCaptureView.CaptureParam.c = paramCustomSize.toString();
      queueEvent(new CameraCaptureView.7(this));
      if (QLog.isColorLevel())
      {
        paramCustomSize = new StringBuilder();
        paramCustomSize.append("onCameraSizeSelected(): cameraPreviewWidth=");
        paramCustomSize.append(this.jdField_d_of_type_Int);
        paramCustomSize.append(",cameraPreviewHeight=");
        paramCustomSize.append(this.jdField_e_of_type_Int);
        QLog.i("CameraCaptureView", 2, paramCustomSize.toString());
      }
    }
    else
    {
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).scaleVideoSize(CameraCaptureView.CaptureParam.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      int i1 = paramCustomSize[0];
      int i2 = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_riji_h_compress_fbo");
      paramCustomSize.append(i1);
      paramCustomSize.append(i2);
      CameraCaptureView.CaptureParam.d = paramCustomSize.toString();
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(i1, i2, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int, 1.0F);
      this.jdField_f_of_type_Int = paramCustomSize[0];
      this.jdField_g_of_type_Int = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_riji_h_clip_fbo");
      paramCustomSize.append(this.jdField_f_of_type_Int);
      paramCustomSize.append(this.jdField_g_of_type_Int);
      CameraCaptureView.CaptureParam.e = paramCustomSize.toString();
      this.jdField_j_of_type_Int = this.jdField_f_of_type_Int;
      this.jdField_k_of_type_Int = this.jdField_g_of_type_Int;
      CameraCaptureView.CaptureParam.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam);
      int i3 = CameraCaptureView.CaptureParam.e(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam);
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).scaleVideoSize(i3, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      i3 = paramCustomSize[0];
      int i4 = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_riji_l_compress_fbo");
      paramCustomSize.append(i3);
      paramCustomSize.append(i4);
      CameraCaptureView.CaptureParam.f = paramCustomSize.toString();
      paramCustomSize = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(i3, i4, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int, 1.0F);
      this.jdField_h_of_type_Int = paramCustomSize[0];
      this.jdField_i_of_type_Int = paramCustomSize[1];
      paramCustomSize = new StringBuilder();
      paramCustomSize.append("key_riji_l_clip_fbo");
      paramCustomSize.append(this.jdField_h_of_type_Int);
      paramCustomSize.append(this.jdField_i_of_type_Int);
      CameraCaptureView.CaptureParam.g = paramCustomSize.toString();
      this.jdField_l_of_type_Int = this.jdField_h_of_type_Int;
      this.jdField_m_of_type_Int = this.jdField_i_of_type_Int;
      queueEvent(new CameraCaptureView.8(this, i1, i2, i3, i4));
      if (QLog.isColorLevel())
      {
        paramCustomSize = new StringBuilder();
        paramCustomSize.append("onCameraSizeSelected(): cameraPreviewWidth=");
        paramCustomSize.append(this.jdField_d_of_type_Int);
        paramCustomSize.append(",cameraPreviewHeight=");
        paramCustomSize.append(this.jdField_e_of_type_Int);
        paramCustomSize.append("， highCompressCameraPreviewWidth=");
        paramCustomSize.append(i1);
        paramCustomSize.append(",highCompressCamerareviewHeight=");
        paramCustomSize.append(i2);
        paramCustomSize.append("， highCameraClipWidth=");
        paramCustomSize.append(this.jdField_f_of_type_Int);
        paramCustomSize.append(",highCameraClipHeight=");
        paramCustomSize.append(this.jdField_g_of_type_Int);
        paramCustomSize.append(", highVideoWidth=");
        paramCustomSize.append(this.jdField_j_of_type_Int);
        paramCustomSize.append(",highVideoHeight=");
        paramCustomSize.append(this.jdField_k_of_type_Int);
        paramCustomSize.append(" ,lowCompressCameraPreviewWidth=");
        paramCustomSize.append(i3);
        paramCustomSize.append(",lowCompressCamerareviewHeight=");
        paramCustomSize.append(i4);
        paramCustomSize.append(" ,lowCameraClipWidth=");
        paramCustomSize.append(this.jdField_h_of_type_Int);
        paramCustomSize.append(" ,lowCameraClipHeight=");
        paramCustomSize.append(this.jdField_i_of_type_Int);
        paramCustomSize.append(",lowVideoWidth=");
        paramCustomSize.append(this.jdField_l_of_type_Int);
        paramCustomSize.append(" ,lowVideoHeight=");
        paramCustomSize.append(this.jdField_m_of_type_Int);
        QLog.i("CameraCaptureView", 2, paramCustomSize.toString());
      }
    }
  }
  
  public void a(Exception paramException) {}
  
  public void a(RuntimeException paramRuntimeException) {}
  
  public void a(String paramString)
  {
    a(new CameraCaptureView.PhotoCaptureResult(1, 0, paramString, null, this.jdField_u_of_type_Int));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_f_of_type_Boolean) {
      if (paramBoolean)
      {
        this.jdField_o_of_type_Int = this.jdField_i_of_type_Int;
        this.jdField_n_of_type_Int = this.jdField_h_of_type_Int;
        if (this.jdField_e_of_type_Boolean)
        {
          localObject = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
          this.jdField_p_of_type_Int = localObject[0];
          this.jdField_q_of_type_Int = localObject[1];
        }
        else
        {
          localObject = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
          this.jdField_p_of_type_Int = localObject[0];
          this.jdField_q_of_type_Int = localObject[1];
        }
      }
      else
      {
        this.jdField_o_of_type_Int = this.jdField_g_of_type_Int;
        this.jdField_n_of_type_Int = this.jdField_f_of_type_Int;
        localObject = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).clipVideoSize(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
        this.jdField_p_of_type_Int = localObject[0];
        this.jdField_q_of_type_Int = localObject[1];
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    if (localObject != null) {
      ((NewFlowCameraOperator)localObject).a(this.jdField_o_of_type_Int, this.jdField_n_of_type_Int, b(), c());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("compress=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" onCameraSizeUpdate cameraClipHeight = ");
      ((StringBuilder)localObject).append(this.jdField_o_of_type_Int);
      ((StringBuilder)localObject).append(" cameraClipWidth=");
      ((StringBuilder)localObject).append(this.jdField_n_of_type_Int);
      ((StringBuilder)localObject).append(" videoWidth=");
      ((StringBuilder)localObject).append(this.jdField_p_of_type_Int);
      ((StringBuilder)localObject).append(" videoHeight=");
      ((StringBuilder)localObject).append(this.jdField_q_of_type_Int);
      QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_s_of_type_Boolean)
    {
      int i4 = this.jdField_d_of_type_Int;
      int i5 = this.jdField_e_of_type_Int;
      int i6 = this.D;
      int i2 = i4;
      int i1 = i5;
      if (i6 > 0)
      {
        int i3 = this.E;
        i2 = i4;
        i1 = i5;
        if (i3 > 0)
        {
          i1 = i6;
          i2 = i3;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker.a(paramArrayOfByte, i2, i1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker$DarkModeListener);
    }
    CameraCaptureView.OutPreviewCallback localOutPreviewCallback = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OutPreviewCallback;
    if (localOutPreviewCallback != null) {
      localOutPreviewCallback.a(paramArrayOfByte, paramCamera);
    }
    CameraControl.a().a(true, paramArrayOfByte);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected int b(int paramInt)
  {
    return paramInt;
  }
  
  public void b()
  {
    int i2 = Build.VERSION.SDK_INT;
    int i1 = 0;
    if ((i2 >= 23) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CameraPermissionListener != null))
    {
      Activity localActivity = (Activity)getContext();
      i2 = localActivity.checkSelfPermission("android.permission.CAMERA");
      int i3 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i2), " audio: ", Integer.valueOf(i3) });
      }
      if ((i2 != 0) || (i3 != 0))
      {
        if (this.jdField_x_of_type_Boolean) {
          break label121;
        }
        this.jdField_x_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CameraPermissionListener.d();
        return;
      }
    }
    i1 = 1;
    label121:
    if ((i1 != 0) || (this.jdField_y_of_type_Boolean))
    {
      c();
      e();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.d(paramBoolean);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected void c()
  {
    if (!this.jdField_k_of_type_Boolean) {
      return;
    }
    if (this.jdField_l_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "openCamera");
    }
    boolean bool = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_z_of_type_Int = 0;
    this.jdField_A_of_type_Int = 0;
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this.jdField_a_of_type_Int);
    this.jdField_l_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture;
      if (localObject != null) {
        ((AudioCapture)localObject).h();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Int == 1) {
        bool = true;
      }
      ((NewFlowCameraOperator)localObject).a(bool);
    }
    com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public void d()
  {
    if (!this.jdField_k_of_type_Boolean) {
      return;
    }
    if (!this.jdField_l_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "stopCamera");
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(false);
    this.jdField_m_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this.jdField_t_of_type_Boolean);
    this.jdField_l_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean)
    {
      AudioCapture localAudioCapture = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture;
      if (localAudioCapture != null) {
        localAudioCapture.i();
      }
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this);
    CameraHelper.a(this.jdField_a_of_type_Int);
    if ((this.jdField_z_of_type_Boolean) && (this.jdField_c_of_type_Long > 0L))
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
      this.jdField_y_of_type_Int = (this.jdField_x_of_type_Int - 15);
      this.jdField_c_of_type_Long = 0L;
    }
  }
  
  public void e()
  {
    if (!this.jdField_k_of_type_Boolean) {
      return;
    }
    if ((this.jdField_o_of_type_Boolean) && (this.jdField_l_of_type_Boolean) && ((!this.jdField_m_of_type_Boolean) || (this.jdField_z_of_type_Int != this.jdField_b_of_type_Int) || (this.jdField_A_of_type_Int != this.jdField_c_of_type_Int)))
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int == 0) || (this.jdField_A_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam;
        ((CameraCaptureView.CaptureParam)localObject).jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        ((CameraCaptureView.CaptureParam)localObject).jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCameraPreview, clipWidth:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(", clipHeight:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(", surfaceWidth:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(", surfaceHeight:");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_f_of_type_Boolean) {
        jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraControl.CustomSize(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int), new CameraControl.CustomSize(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int), 0, 30, this.jdField_f_of_type_Boolean);
      } else {
        jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraControl.CustomSize(CameraCaptureView.CaptureParam.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), CameraCaptureView.CaptureParam.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam)), new CameraControl.CustomSize(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int), 0, 30, this.jdField_f_of_type_Boolean);
      }
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this, true);
      f();
      this.jdField_m_of_type_Boolean = true;
      this.jdField_z_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_A_of_type_Int = this.jdField_c_of_type_Int;
    }
  }
  
  protected void f() {}
  
  protected void g()
  {
    ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new CameraCaptureView.13(this, getContext());
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
    if (localObject != null) {
      ((CameraCaptureView.CaptureListener)localObject).a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Create to FirstFrameShown cost : ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      ((StringBuilder)localObject).append("ms");
      QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceDestroy");
    }
    this.jdField_o_of_type_Boolean = false;
    if (!MediaCodecUtil.b())
    {
      localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RenderBuffer)((Iterator)localObject).next()).destroy();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      GlUtil.deleteTexture(this.jdField_s_of_type_Int);
      localObject = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
      if (localObject != null) {
        ((SurfaceTexture)localObject).release();
      }
      localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
      if (localObject != null) {
        ((TextureRender)localObject).release();
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localObject != null) {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
    }
    d();
  }
  
  protected void j() {}
  
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
            paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
            if (paramObject != null) {
              paramObject.a(true, "");
            }
            if ((paramVarArgs.length >= 2) && ((paramVarArgs[1] instanceof CameraControl.CustomSize)))
            {
              paramObject = (CameraControl.CustomSize)paramVarArgs[1];
              this.D = paramObject.jdField_a_of_type_Int;
              this.E = paramObject.jdField_b_of_type_Int;
            }
          }
          else if ((paramVarArgs[0] instanceof String))
          {
            paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
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
          paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
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
        paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
        if (paramObject != null) {
          paramObject.a(true, "");
        }
      }
      else if ((paramVarArgs[0] instanceof String))
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
        if (paramObject != null) {
          paramObject.a(false, (String)paramVarArgs[0]);
        }
      }
    }
    else if ((paramVarArgs[0] instanceof String))
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
      if (paramObject != null) {
        paramObject.a(false, (String)paramVarArgs[0]);
      }
    }
  }
  
  public void onAudioCaptured(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAudioCaptured filePath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
      ((CameraCaptureView.VideoCaptureResult)localObject).audioDataFilePath = paramString;
      if (((CameraCaptureView.VideoCaptureResult)localObject).videoMp4FilePath != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
  }
  
  public void onAudioChangeCaptured(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAudioCaptured filePath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("CameraCaptureView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
      ((CameraCaptureView.VideoCaptureResult)localObject).audioDataFilePath = paramString;
      if (((CameraCaptureView.VideoCaptureResult)localObject).videoMp4FilePath != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
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
    if ((this.jdField_d_of_type_Int != 0) && (this.jdField_e_of_type_Int != 0) && (this.jdField_a_of_type_JavaUtilMap.size() != 0))
    {
      if (!this.jdField_l_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraCaptureView", 2, "onDrawFrame ignore");
        }
        return;
      }
      long l1 = System.currentTimeMillis();
      if ((!this.jdField_z_of_type_Boolean) && (this.jdField_x_of_type_Int > 15))
      {
        this.jdField_z_of_type_Boolean = true;
        this.jdField_c_of_type_Long = l1;
      }
      boolean bool = this.jdField_c_of_type_Boolean;
      this.jdField_t_of_type_Int = a(bool);
      int i1 = a(this.jdField_t_of_type_Int);
      a(b(i1));
      a(i1, null, null);
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        h();
      }
      if (bool)
      {
        a(i1, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int);
        this.jdField_c_of_type_Boolean = false;
      }
      this.jdField_x_of_type_Int += 1;
      i1 = this.jdField_x_of_type_Int;
      FrameBufferCache.getInstance().forceRecycle();
      if (!this.jdField_j_of_type_Boolean)
      {
        ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).oldAioDrawFirstFrameDone();
        this.jdField_j_of_type_Boolean = true;
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.errorCode = paramInt;
    paramThrowable = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.b();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture.g();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture.g();
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_JavaLangString);
      paramString.append("/noaudio");
      paramString = paramString.toString();
      FileUtils.createFileIfNotExits(paramString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
      ((CameraCaptureView.VideoCaptureResult)localObject).audioDataFilePath = paramString;
      a((CameraCaptureView.VideoCaptureResult)localObject);
    }
    ThreadManager.postImmediately(new CameraCaptureView.9(this), null, false);
  }
  
  public void onEncodeFrame()
  {
    CameraCaptureView.VideoCaptureResult localVideoCaptureResult = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
    localVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void onEncodeStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a();
        this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture.a();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture.a();
      }
    }
    CameraCaptureView.CaptureListener localCaptureListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener;
    if (localCaptureListener != null) {
      localCaptureListener.b();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.a()) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.a().post(new CameraCaptureView.14(this, paramSurfaceTexture));
      return;
    }
    queueEvent(new CameraCaptureView.15(this, paramSurfaceTexture));
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onPause");
    }
    this.jdField_v_of_type_Boolean = false;
    this.jdField_w_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_q_of_type_Boolean) {
      c(false);
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(null);
    OrientationEventListener localOrientationEventListener = this.jdField_a_of_type_AndroidViewOrientationEventListener;
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
    this.jdField_w_of_type_Boolean = false;
    if (this.jdField_v_of_type_Boolean)
    {
      QLog.d("CameraCaptureView", 1, "onResume, blockCameraFlag return");
      return;
    }
    b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker;
    if (localObject != null) {
      ((DarkModeChecker)localObject).a();
    }
    localObject = this.jdField_a_of_type_AndroidViewOrientationEventListener;
    if ((localObject != null) && (((OrientationEventListener)localObject).canDetectOrientation())) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
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
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_o_of_type_Boolean = true;
    if ((!this.jdField_v_of_type_Boolean) && (!this.jdField_w_of_type_Boolean))
    {
      if (!this.jdField_B_of_type_Boolean)
      {
        b();
        this.jdField_B_of_type_Boolean = true;
      }
      return;
    }
    QLog.d("CameraCaptureView", 1, new Object[] { "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(this.jdField_v_of_type_Boolean), " ", Boolean.valueOf(this.jdField_w_of_type_Boolean) });
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceCreated");
    }
    this.jdField_o_of_type_Boolean = false;
    paramEGLConfig = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEglHandlerThread.start();
    if (paramEGLConfig != null) {
      paramEGLConfig.quitSafely();
    }
    this.jdField_s_of_type_Int = GlUtil.createTexture(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_s_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_r_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isNeedDrawOnOpenGLSingleThread();
    paramEGLConfig = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OnSurfaceCreatedListener;
    if (paramEGLConfig != null) {
      paramEGLConfig.a();
    }
    QmcfDevicesStrategy.a(paramGL10.glGetString(7937));
  }
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    this.jdField_v_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraChangeListener(CameraCaptureView.CameraChangeListener paramCameraChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CameraChangeListener = paramCameraChangeListener;
  }
  
  public void setCameraPermissionFinish(boolean paramBoolean)
  {
    this.jdField_y_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraPermissionListener(CameraCaptureView.CameraPermissionListener paramCameraPermissionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CameraPermissionListener = paramCameraPermissionListener;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "setCameraPermissionResult, ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_y_of_type_Boolean = true;
    c();
    e();
  }
  
  public void setCaptureListener(CameraCaptureView.CaptureListener paramCaptureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener = paramCaptureListener;
  }
  
  public void setCaptureParam(CameraCaptureView.CaptureParam paramCaptureParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam = paramCaptureParam;
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
    this.jdField_s_of_type_Boolean = paramBoolean;
  }
  
  public void setDarkModeListener(DarkModeChecker.DarkModeListener paramDarkModeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker$DarkModeListener = paramDarkModeListener;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setOnSurfaceCreatedListener(CameraCaptureView.OnSurfaceCreatedListener paramOnSurfaceCreatedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OnSurfaceCreatedListener = paramOnSurfaceCreatedListener;
  }
  
  public void setPreviewCallback(CameraCaptureView.OutPreviewCallback paramOutPreviewCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OutPreviewCallback = paramOutPreviewCallback;
  }
  
  public void setSceneMode(String paramString)
  {
    k();
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(paramString);
  }
  
  public void setSegmentMode(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setSyncStopCamera(boolean paramBoolean)
  {
    this.jdField_t_of_type_Boolean = paramBoolean;
  }
  
  public void setUseVideoOrientation(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setZoom(int paramInt)
  {
    k();
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */