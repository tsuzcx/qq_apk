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
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.AudioCaptureListener;
import com.tencent.mobileqq.richmedia.capture.audio.AudioChangerManager;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.camera2.CameraFocusParams;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.CameraProxyCallBack;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.mobileqq.shortvideo.util.MediaCodecUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
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
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, CameraCover.PictureCallback, AudioCapture.AudioCaptureListener, HWEncodeListener, Observer, CameraExceptionHandler.Callback, CameraProxy.CameraProxyCallBack
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
  protected AudioCapture a;
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
  protected EglHandlerThread a;
  protected EncodeConfig a;
  protected HWVideoRecorder a;
  private CameraExceptionHandler jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
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
    }
    do
    {
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
        do
        {
          this.jdField_B_of_type_Int = 1;
          this.C = 100;
        } while (!QLog.isColorLevel());
        QLog.e("CameraCaptureView", 2, "turn FrontFlash Error ", localException);
        localException.printStackTrace();
        return;
      }
      if (this.jdField_r_of_type_Boolean)
      {
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness", this.C);
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness_mode", this.jdField_B_of_type_Int);
        this.jdField_r_of_type_Boolean = false;
      }
    } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getParent() == null));
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void k()
  {
    if (!this.jdField_k_of_type_Boolean) {
      throw new RuntimeException("Not inited. Must be called after setCaptureParam");
    }
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
    }
    int i3;
    int i2;
    for (;;)
    {
      if (!this.jdField_f_of_type_Boolean) {
        break label571;
      }
      if (paramBoolean)
      {
        Object localObject1 = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.f);
        if (localObject1 != null) {
          ((RenderBuffer)localObject1).bind();
        }
        synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null);
          QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
          QmcfManager.getInstance().setIsQQRun(false);
          l();
          i1 = ((RenderBuffer)localObject1).getTexId();
          ((RenderBuffer)localObject1).unbind();
          ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.g);
          i3 = i1;
          if (??? != null)
          {
            i3 = i1;
            if (localObject1 != null)
            {
              if (((RenderBuffer)localObject1).getWidth() == ((RenderBuffer)???).getWidth())
              {
                i2 = i1;
                if (((RenderBuffer)localObject1).getHeight() == ((RenderBuffer)???).getHeight()) {}
              }
              else
              {
                ((RenderBuffer)???).bind();
                localObject1 = GPUBaseFilter.caculateCenterCropMvpMatrix(((RenderBuffer)localObject1).getWidth(), ((RenderBuffer)localObject1).getHeight(), ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
                this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, i1, null, (float[])localObject1);
                i2 = ((RenderBuffer)???).getTexId();
                ((RenderBuffer)???).unbind();
              }
              if (this.jdField_n_of_type_Int == ((RenderBuffer)???).getWidth())
              {
                i3 = i2;
                if (this.jdField_o_of_type_Int == ((RenderBuffer)???).getHeight()) {}
              }
              else
              {
                a(true);
                i3 = i2;
              }
            }
          }
          return i3;
          if (this.jdField_f_of_type_Boolean) {
            paramBoolean = b();
          } else {
            paramBoolean = false;
          }
        }
      }
    }
    Object localObject3 = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.d);
    if (localObject3 != null) {
      ((RenderBuffer)localObject3).bind();
    }
    synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null);
      QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
      QmcfManager.getInstance().setIsQQRun(false);
      l();
      i1 = ((RenderBuffer)localObject3).getTexId();
      ((RenderBuffer)localObject3).unbind();
      ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CameraCaptureView.CaptureParam.e);
      i3 = i1;
      if (??? != null)
      {
        i3 = i1;
        if (localObject3 != null)
        {
          if (((RenderBuffer)localObject3).getWidth() == ((RenderBuffer)???).getWidth())
          {
            i2 = i1;
            if (((RenderBuffer)localObject3).getHeight() == ((RenderBuffer)???).getHeight()) {}
          }
          else
          {
            ((RenderBuffer)???).bind();
            localObject3 = GPUBaseFilter.caculateCenterCropMvpMatrix(((RenderBuffer)localObject3).getWidth(), ((RenderBuffer)localObject3).getHeight(), ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
            this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, i1, null, (float[])localObject3);
            i2 = ((RenderBuffer)???).getTexId();
            ((RenderBuffer)???).unbind();
          }
          if (this.jdField_n_of_type_Int == ((RenderBuffer)???).getWidth())
          {
            i3 = i2;
            if (this.jdField_o_of_type_Int == ((RenderBuffer)???).getHeight()) {}
          }
          else
          {
            a(false);
            i3 = i2;
          }
        }
      }
      return i3;
    }
    label571:
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_JavaLangString, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this, jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a());
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
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureView", 2, "requestCameraFocus x:" + paramFloat1 + "y: " + paramFloat2 + ", Orientation:" + ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation());
    }
    CameraFocusParams localCameraFocusParams = new CameraFocusParams();
    localCameraFocusParams.jdField_a_of_type_Float = paramFloat1;
    localCameraFocusParams.jdField_b_of_type_Float = paramFloat2;
    localCameraFocusParams.jdField_a_of_type_Int = b();
    localCameraFocusParams.jdField_b_of_type_Int = c();
    localCameraFocusParams.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    localCameraFocusParams.jdField_c_of_type_Int = CaptureUtil.c(this.jdField_v_of_type_Int);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(localCameraFocusParams, new CameraCaptureView.4(this));
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
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "captureFrame : width = " + paramInt2 + " ; height = " + paramInt3 + " ; orientation = " + i1);
    }
    try
    {
      RenderBuffer localRenderBuffer = new RenderBuffer(paramInt2, paramInt3, 33984);
      localRenderBuffer.bind();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt1, null, null);
      localRenderBuffer.unbind();
      Bitmap localBitmap = GlUtil.captureFrame(localRenderBuffer.getTexId(), paramInt2, paramInt3, -i1);
      localRenderBuffer.destroy();
      ThreadManager.excute(new CameraCaptureView.16(this, localBitmap), 64, null, false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener == null) {}
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(103);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig != null))
    {
      switch (this.jdField_r_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_r_of_type_Int);
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig, this);
        this.jdField_r_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_r_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_r_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
    j();
    this.jdField_r_of_type_Int = 0;
  }
  
  protected void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, SystemClock.elapsedRealtimeNanos());
  }
  
  protected void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(paramPhotoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.10(this));
    ReportUtil.a();
    if (CameraControl.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      CaptureReportUtil.d(i1);
      return;
      i1 = 2;
    }
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(paramVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.11(this));
    ReportUtil.b();
    if (CameraControl.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      CaptureReportUtil.f(i1);
      return;
      i1 = 2;
    }
  }
  
  protected void a(CameraControl.CustomSize paramCustomSize)
  {
    this.jdField_e_of_type_Int = paramCustomSize.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = paramCustomSize.jdField_b_of_type_Int;
    if (!this.jdField_f_of_type_Boolean)
    {
      paramCustomSize = CaptureUtil.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int, 1.0F);
      this.jdField_n_of_type_Int = paramCustomSize[0];
      this.jdField_o_of_type_Int = paramCustomSize[1];
      paramCustomSize = CaptureUtil.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = paramCustomSize[0];
      this.jdField_q_of_type_Int = paramCustomSize[1];
      paramCustomSize = CaptureUtil.a(CameraCaptureView.CaptureParam.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), this.jdField_p_of_type_Int, this.jdField_q_of_type_Int);
      this.jdField_p_of_type_Int = paramCustomSize[0];
      this.jdField_q_of_type_Int = paramCustomSize[1];
      CameraCaptureView.CaptureParam.c = "key_aio_fbo" + this.jdField_n_of_type_Int + this.jdField_o_of_type_Int;
      queueEvent(new CameraCaptureView.7(this));
      if (QLog.isColorLevel()) {
        QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.jdField_d_of_type_Int + ",cameraPreviewHeight=" + this.jdField_e_of_type_Int);
      }
    }
    int i1;
    int i2;
    int i3;
    int i4;
    do
    {
      return;
      paramCustomSize = CaptureUtil.a(CameraCaptureView.CaptureParam.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      i1 = paramCustomSize[0];
      i2 = paramCustomSize[1];
      CameraCaptureView.CaptureParam.d = "key_riji_h_compress_fbo" + i1 + i2;
      paramCustomSize = CaptureUtil.a(i1, i2, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int, 1.0F);
      this.jdField_f_of_type_Int = paramCustomSize[0];
      this.jdField_g_of_type_Int = paramCustomSize[1];
      CameraCaptureView.CaptureParam.e = "key_riji_h_clip_fbo" + this.jdField_f_of_type_Int + this.jdField_g_of_type_Int;
      this.jdField_j_of_type_Int = this.jdField_f_of_type_Int;
      this.jdField_k_of_type_Int = this.jdField_g_of_type_Int;
      CameraCaptureView.CaptureParam.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam);
      paramCustomSize = CaptureUtil.a(CameraCaptureView.CaptureParam.e(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      i3 = paramCustomSize[0];
      i4 = paramCustomSize[1];
      CameraCaptureView.CaptureParam.f = "key_riji_l_compress_fbo" + i3 + i4;
      paramCustomSize = CaptureUtil.a(i3, i4, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int, 1.0F);
      this.jdField_h_of_type_Int = paramCustomSize[0];
      this.jdField_i_of_type_Int = paramCustomSize[1];
      CameraCaptureView.CaptureParam.g = "key_riji_l_clip_fbo" + this.jdField_h_of_type_Int + this.jdField_i_of_type_Int;
      this.jdField_l_of_type_Int = this.jdField_h_of_type_Int;
      this.jdField_m_of_type_Int = this.jdField_i_of_type_Int;
      queueEvent(new CameraCaptureView.8(this, i1, i2, i3, i4));
    } while (!QLog.isColorLevel());
    QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.jdField_d_of_type_Int + ",cameraPreviewHeight=" + this.jdField_e_of_type_Int + "， highCompressCameraPreviewWidth=" + i1 + ",highCompressCamerareviewHeight=" + i2 + "， highCameraClipWidth=" + this.jdField_f_of_type_Int + ",highCameraClipHeight=" + this.jdField_g_of_type_Int + ", highVideoWidth=" + this.jdField_j_of_type_Int + ",highVideoHeight=" + this.jdField_k_of_type_Int + " ,lowCompressCameraPreviewWidth=" + i3 + ",lowCompressCamerareviewHeight=" + i4 + " ,lowCameraClipWidth=" + this.jdField_h_of_type_Int + " ,lowCameraClipHeight=" + this.jdField_i_of_type_Int + ",lowVideoWidth=" + this.jdField_l_of_type_Int + " ,lowVideoHeight=" + this.jdField_m_of_type_Int);
  }
  
  public void a(String paramString)
  {
    a(new CameraCaptureView.PhotoCaptureResult(1, 0, paramString, null, this.jdField_u_of_type_Int));
  }
  
  protected void a(boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (this.jdField_f_of_type_Boolean)
    {
      if (!paramBoolean) {
        break label235;
      }
      this.jdField_o_of_type_Int = this.jdField_i_of_type_Int;
      this.jdField_n_of_type_Int = this.jdField_h_of_type_Int;
      if (!this.jdField_e_of_type_Boolean) {
        break label191;
      }
      arrayOfInt = CaptureUtil.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(this.jdField_o_of_type_Int, this.jdField_n_of_type_Int, b(), c());
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "compress=" + paramBoolean + " onCameraSizeUpdate cameraClipHeight = " + this.jdField_o_of_type_Int + " cameraClipWidth=" + this.jdField_n_of_type_Int + " videoWidth=" + this.jdField_p_of_type_Int + " videoHeight=" + this.jdField_q_of_type_Int);
      }
      return;
      label191:
      arrayOfInt = CaptureUtil.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
      continue;
      label235:
      this.jdField_o_of_type_Int = this.jdField_g_of_type_Int;
      this.jdField_n_of_type_Int = this.jdField_f_of_type_Int;
      arrayOfInt = CaptureUtil.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
    }
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
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CameraPermissionListener != null))
    {
      Activity localActivity = (Activity)getContext();
      i1 = localActivity.checkSelfPermission("android.permission.CAMERA");
      int i2 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i1), " audio: ", Integer.valueOf(i2) });
      }
      if ((i1 != 0) || (i2 != 0)) {
        if (!this.jdField_x_of_type_Boolean)
        {
          this.jdField_x_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CameraPermissionListener.a();
        }
      }
    }
    for (;;)
    {
      return;
      for (i1 = 0; (i1 != 0) || (this.jdField_y_of_type_Boolean); i1 = 1)
      {
        c();
        e();
        return;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.e(paramBoolean);
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
    boolean bool = true;
    if (!this.jdField_k_of_type_Boolean) {}
    while (this.jdField_l_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "openCamera");
    }
    this.jdField_m_of_type_Boolean = false;
    this.jdField_z_of_type_Int = 0;
    this.jdField_A_of_type_Int = 0;
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this.jdField_a_of_type_Int);
    this.jdField_l_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f();
    }
    NewFlowCameraOperator localNewFlowCameraOperator;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator != null)
    {
      localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
      if (this.jdField_a_of_type_Int != 1) {
        break label127;
      }
    }
    for (;;)
    {
      localNewFlowCameraOperator.a(bool);
      com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return;
      label127:
      bool = false;
    }
  }
  
  public void d()
  {
    if (!this.jdField_k_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_l_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "stopCamera");
      }
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(false);
      this.jdField_m_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this.jdField_t_of_type_Boolean);
      this.jdField_l_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.g();
      }
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this);
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(PeakAppInterface.a);
      CameraHelper.a(this.jdField_a_of_type_Int);
    } while ((!this.jdField_z_of_type_Boolean) || (this.jdField_c_of_type_Long <= 0L));
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_c_of_type_Long);
    this.jdField_y_of_type_Int = (this.jdField_x_of_type_Int - 15);
    this.jdField_c_of_type_Long = 0L;
  }
  
  public void e()
  {
    if (!this.jdField_k_of_type_Boolean) {}
    while ((!this.jdField_o_of_type_Boolean) || (!this.jdField_l_of_type_Boolean) || ((this.jdField_m_of_type_Boolean) && (this.jdField_z_of_type_Int == this.jdField_b_of_type_Int) && (this.jdField_A_of_type_Int == this.jdField_c_of_type_Int))) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int == 0) || (this.jdField_A_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "startCameraPreview, clipWidth:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int + ", clipHeight:" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int + ", surfaceWidth:" + this.jdField_b_of_type_Int + ", surfaceHeight:" + this.jdField_c_of_type_Int);
    }
    if (this.jdField_f_of_type_Boolean) {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraControl.CustomSize(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int), new CameraControl.CustomSize(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int), 0, 30, this.jdField_f_of_type_Boolean);
    }
    for (;;)
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this, true);
      f();
      this.jdField_m_of_type_Boolean = true;
      this.jdField_z_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_A_of_type_Int = this.jdField_c_of_type_Int;
      return;
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraControl.CustomSize(CameraCaptureView.CaptureParam.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), CameraCaptureView.CaptureParam.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam)), new CameraControl.CustomSize(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int), 0, 30, this.jdField_f_of_type_Boolean);
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "Create to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_b_of_type_Long) + "ms");
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceDestroy");
    }
    this.jdField_o_of_type_Boolean = false;
    if (!MediaCodecUtil.a())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((RenderBuffer)localIterator.next()).destroy();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      GlUtil.deleteTexture(this.jdField_s_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
    }
    d();
  }
  
  protected void j() {}
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, " notify : eventId = " + paramInt + " ; sender = " + paramObject + " ; args = " + Arrays.toString(paramVarArgs));
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!(paramVarArgs[0] instanceof CameraControl.CustomSize)) {
                  break;
                }
                a((CameraControl.CustomSize)paramVarArgs[0]);
              } while (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener == null);
              this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(true, "");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener == null));
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(false, (String)paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener == null));
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(false, (String)paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener == null));
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof CameraControl.CustomSize)) {
          break;
        }
        a((CameraControl.CustomSize)paramVarArgs[0]);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(true, "");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof CameraControl.CustomSize)));
      paramObject = (CameraControl.CustomSize)paramVarArgs[1];
      this.D = paramObject.jdField_a_of_type_Int;
      this.E = paramObject.jdField_b_of_type_Int;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener == null));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
  }
  
  public void onAudioCaptured(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "onAudioCaptured filePath = " + paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
  }
  
  public void onAudioChangeCaptured(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "onAudioCaptured filePath = " + paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
  }
  
  public void onAudioError(int paramInt)
  {
    QLog.e("CameraCaptureView", 2, "onAudioError. errorCode = " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.12(this));
  }
  
  public void onAudioFrames(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void onAudioInit() {}
  
  public void onAudioUnInit() {}
  
  public void onCameraException(Exception paramException) {}
  
  public void onDispatchThreadException(RuntimeException paramRuntimeException) {}
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.jdField_d_of_type_Int == 0) || (this.jdField_e_of_type_Int == 0) || (this.jdField_a_of_type_JavaUtilMap.size() == 0))
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "onDrawFrame clean");
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_l_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CameraCaptureView", 2, "onDrawFrame ignore");
      return;
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
      if (this.jdField_x_of_type_Int == 10) {}
      FrameBufferCache.getInstance().forceRecycle();
    } while (this.jdField_j_of_type_Boolean);
    AELaunchRecorder.a().a();
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void onEncodeAudioCaptured(String paramString) {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(104);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onEncodeFinish filePath = " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
    for (;;)
    {
      ThreadManager.postImmediately(new CameraCaptureView.9(this), null, false);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        continue;
        paramString = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_JavaLangString + "/noaudio";
        FileUtils.c(paramString);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
  }
  
  public void onEncodeFrame()
  {
    CameraCaptureView.VideoCaptureResult localVideoCaptureResult = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
    localVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void onEncodeStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a()) {
        break label66;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioChangerManager.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.b();
      }
      return;
      label66:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a()) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a().post(new CameraCaptureView.14(this, paramSurfaceTexture));
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
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    ThreadManagerV2.excute(new CameraCaptureView.3(this), 16, null, false);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_s_of_type_Boolean)
    {
      int i3 = this.jdField_d_of_type_Int;
      int i4 = this.jdField_e_of_type_Int;
      int i2 = i4;
      int i1 = i3;
      if (this.D > 0)
      {
        i2 = i4;
        i1 = i3;
        if (this.E > 0)
        {
          i1 = this.E;
          i2 = this.D;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker.a(paramArrayOfByte, i1, i2, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker$DarkModeListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OutPreviewCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OutPreviewCallback.a(paramArrayOfByte, paramCamera);
    }
    CameraControl.a().a(true, paramArrayOfByte);
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker.a();
    }
    if ((this.jdField_a_of_type_AndroidViewOrientationEventListener != null) && (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation())) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    ThreadManagerV2.excute(new CameraCaptureView.2(this), 16, null, false);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceChanged(): width " + paramInt1 + ";height" + paramInt2);
    }
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_o_of_type_Boolean = true;
    if ((this.jdField_v_of_type_Boolean) || (this.jdField_w_of_type_Boolean)) {
      QLog.d("CameraCaptureView", 1, new Object[] { "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(this.jdField_v_of_type_Boolean), " ", Boolean.valueOf(this.jdField_w_of_type_Boolean) });
    }
    while (this.jdField_B_of_type_Boolean) {
      return;
    }
    b();
    this.jdField_B_of_type_Boolean = true;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceCreated");
    }
    this.jdField_o_of_type_Boolean = false;
    paramEGLConfig = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.start();
    if (paramEGLConfig != null) {
      paramEGLConfig.quitSafely();
    }
    this.jdField_s_of_type_Int = GlUtil.createTexture(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_s_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_r_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = CameraCompatibleList.c();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OnSurfaceCreatedListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$OnSurfaceCreatedListener.a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam = paramCaptureParam;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "setCaptureParam : " + paramCaptureParam);
    }
    a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */