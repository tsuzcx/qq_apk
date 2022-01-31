package com.tencent.mobileqq.richmedia.capture.view;

import ahld;
import ahle;
import ahlf;
import ahlg;
import ahlh;
import ahli;
import ahlj;
import ahlk;
import ahll;
import ahlm;
import ahln;
import ahlo;
import ahlp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.PreviewCallback;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture.AudioCaptureListener;
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
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import java.io.File;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

@TargetApi(18)
public class CameraCaptureView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback, GLSurfaceView.Renderer, CameraCover.PictureCallback, AudioCapture.AudioCaptureListener, HWEncodeListener, Observer, CameraExceptionHandler.Callback
{
  private static Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener = new ahli();
  private static final CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(null, null);
  private static int t;
  public int a;
  private long jdField_a_of_type_Long;
  public SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new ahld(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected OrientationEventListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected NewFlowCameraOperator a;
  protected AudioCapture a;
  private DarkModeChecker.DarkModeListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker$DarkModeListener;
  private DarkModeChecker jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker;
  protected CameraCaptureView.CaptureListener a;
  protected CameraCaptureView.CaptureParam a;
  private CameraCaptureView.VideoCaptureResult jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
  protected EglHandlerThread a;
  protected EncodeConfig a;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder;
  public RenderBuffer a;
  protected TextureRender a;
  private CameraExceptionHandler jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
  protected boolean a;
  protected final float[] a;
  public int b;
  private long b;
  protected boolean b;
  protected int c;
  private long c;
  public volatile boolean c;
  protected int d;
  boolean d;
  protected int e;
  protected boolean e;
  public int f;
  public boolean f;
  public int g;
  protected boolean g;
  protected int h;
  private boolean h;
  protected int i;
  private boolean i;
  protected int j;
  private boolean j;
  public int k;
  private boolean k;
  public int l;
  private volatile boolean l;
  public int m;
  private boolean m;
  public int n;
  private boolean n;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean = true;
  private int jdField_r_of_type_Int;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private boolean jdField_s_of_type_Boolean;
  
  public CameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = 1;
    this.jdField_h_of_type_Int = 480;
    this.jdField_i_of_type_Int = 640;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_l_of_type_Int = 90;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_n_of_type_Int = 90;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  public CameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 1;
    this.jdField_h_of_type_Int = 480;
    this.jdField_i_of_type_Int = 640;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_l_of_type_Int = 90;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_n_of_type_Int = 90;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  private void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(paramVideoCaptureResult);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ahlp(this));
    ReportUtil.c();
    if (CameraControl.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      CaptureReportUtil.i(i1);
      return;
      i1 = 2;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Int == 1)
    {
      d(paramBoolean);
      return;
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(paramBoolean);
  }
  
  private void c()
  {
    this.jdField_c_of_type_Int = CameraCaptureView.CaptureParam.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam);
    if (!CameraAbility.c()) {
      this.jdField_c_of_type_Int = 2;
    }
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler = new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener);
    setRenderer(this);
    setRenderMode(0);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = new HWVideoRecorder();
    if (CameraCaptureView.CaptureParam.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_JavaLangString, 1, CodecParam.jdField_q_of_type_Int, CodecParam.jdField_o_of_type_Int, CodecParam.jdField_p_of_type_Int, this, jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator = new NewFlowCameraOperator();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker = new DarkModeChecker();
    QmcfManager.a().a(this.jdField_c_of_type_Int);
    this.jdField_h_of_type_Boolean = true;
  }
  
  private void d()
  {
    if (!this.jdField_h_of_type_Boolean) {
      throw new RuntimeException("Not inited. Must be called after setCaptureParam");
    }
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
      do
      {
        try
        {
          this.jdField_r_of_type_Int = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness_mode");
          Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness_mode", 0);
          this.jdField_s_of_type_Int = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness");
          Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness", 255);
          this.jdField_p_of_type_Boolean = true;
          return;
        }
        catch (Exception localException)
        {
          do
          {
            this.jdField_r_of_type_Int = 1;
            this.jdField_s_of_type_Int = 100;
          } while (!QLog.isColorLevel());
          QLog.e("CameraCaptureView", 2, "turn FrontFlash Error ", localException);
          localException.printStackTrace();
          return;
        }
        if (this.jdField_c_of_type_Int == 2)
        {
          jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.c(false);
          return;
        }
      } while (this.jdField_c_of_type_Int != 1);
      if (this.jdField_p_of_type_Boolean)
      {
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness", this.jdField_s_of_type_Int);
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness_mode", this.jdField_r_of_type_Int);
        this.jdField_p_of_type_Boolean = false;
      }
    } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getParent() == null));
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void g()
  {
    boolean bool = true;
    if (!this.jdField_h_of_type_Boolean) {}
    while (this.jdField_i_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "startCamera");
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this);
    this.jdField_j_of_type_Boolean = false;
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this.jdField_c_of_type_Int);
    this.jdField_i_of_type_Boolean = true;
    if ((CameraCaptureView.CaptureParam.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
    }
    NewFlowCameraOperator localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
    if (this.jdField_c_of_type_Int == 1) {}
    for (;;)
    {
      localNewFlowCameraOperator.a(bool);
      CameraHelper.a(this.jdField_c_of_type_Int);
      com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
      return;
      bool = false;
    }
  }
  
  private void r()
  {
    if (!this.jdField_h_of_type_Boolean) {}
    while ((!this.jdField_m_of_type_Boolean) || (!this.jdField_i_of_type_Boolean) || ((this.jdField_j_of_type_Boolean) && (this.jdField_o_of_type_Int == this.jdField_a_of_type_Int) && (this.jdField_p_of_type_Int == this.jdField_b_of_type_Int))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "startCameraPreview");
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraControl.CustomSize(CameraCaptureView.CaptureParam.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), CameraCaptureView.CaptureParam.c(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam)), new CameraControl.CustomSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), 0, 30);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this, true);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_o_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_p_of_type_Int = this.jdField_b_of_type_Int;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount = 0;
    if ((CameraCaptureView.CaptureParam.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.aj_();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    d();
    Rect localRect1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
    Rect localRect2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramFloat1, paramFloat2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.5F);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureView", 2, "requestCameraFocus:" + paramFloat1 + " " + paramFloat2 + " " + localRect1 + " " + localRect2);
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(localRect1, localRect2, new ahlj(this));
  }
  
  /* Error */
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 107	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_l_of_type_Int	I
    //   4: sipush 360
    //   7: iadd
    //   8: bipush 90
    //   10: isub
    //   11: sipush 360
    //   14: irem
    //   15: istore 4
    //   17: invokestatic 343	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +51 -> 71
    //   23: ldc_w 345
    //   26: iconst_2
    //   27: new 424	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 425	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 457
    //   37: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_2
    //   41: invokevirtual 460	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: ldc_w 462
    //   47: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iload_3
    //   51: invokevirtual 460	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc_w 464
    //   57: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload 4
    //   62: invokevirtual 460	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 360	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: new 466	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer
    //   74: dup
    //   75: iload_2
    //   76: iload_3
    //   77: ldc_w 467
    //   80: invokespecial 469	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:<init>	(III)V
    //   83: astore 6
    //   85: aload 6
    //   87: invokevirtual 471	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:b	()V
    //   90: aload_0
    //   91: getfield 473	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender	Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/TextureRender;
    //   94: sipush 3553
    //   97: iload_1
    //   98: aconst_null
    //   99: aconst_null
    //   100: invokevirtual 478	com/tencent/mobileqq/richmedia/mediacodec/renderer/TextureRender:a	(II[F[F)V
    //   103: aload 6
    //   105: invokevirtual 479	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:c	()V
    //   108: aload 6
    //   110: invokevirtual 481	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:a	()I
    //   113: iload_2
    //   114: iload_3
    //   115: iload 4
    //   117: ineg
    //   118: invokestatic 486	com/tencent/mobileqq/richmedia/mediacodec/utils/GlUtil:a	(IIII)Landroid/graphics/Bitmap;
    //   121: astore 5
    //   123: aload 6
    //   125: invokevirtual 487	com/tencent/mobileqq/richmedia/mediacodec/renderer/RenderBuffer:d	()V
    //   128: new 424	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 425	java/lang/StringBuilder:<init>	()V
    //   135: aload_0
    //   136: getfield 185	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$CaptureParam;
    //   139: getfield 232	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$CaptureParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   142: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 489
    //   148: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokestatic 119	java/lang/System:currentTimeMillis	()J
    //   154: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   157: ldc_w 494
    //   160: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 442	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore 6
    //   168: aload 6
    //   170: invokestatic 498	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;)V
    //   173: new 500	java/io/File
    //   176: dup
    //   177: aload 6
    //   179: invokespecial 501	java/io/File:<init>	(Ljava/lang/String;)V
    //   182: astore 7
    //   184: aload 5
    //   186: aload 7
    //   188: invokestatic 506	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
    //   191: pop
    //   192: invokestatic 511	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   195: aload 7
    //   197: invokevirtual 514	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   200: invokestatic 517	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   203: aload_0
    //   204: new 519	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$PhotoCaptureResult
    //   207: dup
    //   208: iconst_0
    //   209: iconst_0
    //   210: aload 6
    //   212: aconst_null
    //   213: aload_0
    //   214: getfield 107	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_l_of_type_Int	I
    //   217: invokespecial 522	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$PhotoCaptureResult:<init>	(IILjava/lang/String;Landroid/graphics/Bitmap;I)V
    //   220: invokevirtual 525	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:b	(Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$PhotoCaptureResult;)V
    //   223: aload 5
    //   225: invokevirtual 530	android/graphics/Bitmap:recycle	()V
    //   228: getstatic 77	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;
    //   231: iconst_1
    //   232: invokevirtual 531	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(Z)V
    //   235: return
    //   236: astore 5
    //   238: aload_0
    //   239: getfield 134	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$CaptureListener;
    //   242: ifnull -7 -> 235
    //   245: aload_0
    //   246: getfield 134	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$CaptureListener;
    //   249: bipush 103
    //   251: invokeinterface 532 2 0
    //   256: return
    //   257: astore 7
    //   259: aload 7
    //   261: invokevirtual 533	java/io/IOException:printStackTrace	()V
    //   264: aload_0
    //   265: new 519	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$PhotoCaptureResult
    //   268: dup
    //   269: iconst_0
    //   270: iconst_m1
    //   271: aload 6
    //   273: aconst_null
    //   274: aload_0
    //   275: getfield 107	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:jdField_l_of_type_Int	I
    //   278: invokespecial 522	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$PhotoCaptureResult:<init>	(IILjava/lang/String;Landroid/graphics/Bitmap;I)V
    //   281: invokevirtual 525	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:b	(Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$PhotoCaptureResult;)V
    //   284: goto -61 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	CameraCaptureView
    //   0	287	1	paramInt1	int
    //   0	287	2	paramInt2	int
    //   0	287	3	paramInt3	int
    //   15	101	4	i1	int
    //   121	103	5	localBitmap	android.graphics.Bitmap
    //   236	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   83	189	6	localObject	Object
    //   182	14	7	localFile	File
    //   257	3	7	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   71	128	236	java/lang/OutOfMemoryError
    //   184	223	257	java/io/IOException
  }
  
  protected void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig != null))
    {
      switch (this.jdField_q_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_q_of_type_Int);
      case 0: 
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig, this);
        this.jdField_q_of_type_Int = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_q_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_q_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
    q();
    this.jdField_q_of_type_Int = 0;
  }
  
  protected void a(CameraControl.CustomSize paramCustomSize)
  {
    this.jdField_e_of_type_Int = paramCustomSize.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = paramCustomSize.jdField_b_of_type_Int;
    int[] arrayOfInt = CaptureUtil.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1.0F);
    this.jdField_f_of_type_Int = arrayOfInt[0];
    this.jdField_g_of_type_Int = arrayOfInt[1];
    arrayOfInt = CaptureUtil.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Float);
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
    arrayOfInt = CaptureUtil.a(CameraCaptureView.CaptureParam.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), this.jdField_h_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_h_of_type_Int = arrayOfInt[0];
    this.jdField_i_of_type_Int = arrayOfInt[1];
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramCustomSize.jdField_a_of_type_Int, paramCustomSize.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.jdField_d_of_type_Int + ",cameraPreviewHeight=" + this.jdField_e_of_type_Int + "， cameraClipWidth=" + this.jdField_f_of_type_Int + ",cameraClipHeight=" + this.jdField_g_of_type_Int + ", videoWidth=" + this.jdField_h_of_type_Int + ",videoHeight=" + this.jdField_i_of_type_Int);
    }
    queueEvent(new ahlm(this));
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
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
  }
  
  public void a(RuntimeException paramRuntimeException) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onEncodeFinish filePath = " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath = paramString;
    if ((CameraCaptureView.CaptureParam.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
    for (;;)
    {
      ThreadManager.postImmediately(new ahln(this), null, false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.d();
      continue;
      paramString = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_JavaLangString + "/noaudio";
      FileUtils.c(paramString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  protected boolean a()
  {
    return CameraUtils.a();
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    b(new CameraCaptureView.PhotoCaptureResult(1, 0, paramString, null, this.jdField_l_of_type_Int));
  }
  
  public void b()
  {
    CameraCaptureView.VideoCaptureResult localVideoCaptureResult = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
    localVideoCaptureResult.videoFrameCount += 1;
  }
  
  public void b(int paramInt)
  {
    QLog.e("CameraCaptureView", 2, "onAudioError. errorCode = " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    }
    ThreadManager.getUIHandler().post(new ahle(this));
  }
  
  protected void b(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(paramPhotoCaptureResult);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ahlo(this));
    ReportUtil.b();
    if (CameraControl.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      CaptureReportUtil.g(i1);
      return;
      i1 = 2;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onAudioCaptured filePath = " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    d();
    this.jdField_o_of_type_Boolean = paramBoolean;
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.d(this.jdField_o_of_type_Boolean);
  }
  
  protected boolean b()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public void c(boolean paramBoolean)
  {
    d();
    QQLowLightFilter.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.g_(paramBoolean);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void h()
  {
    if (!this.jdField_h_of_type_Boolean) {}
    while (!this.jdField_i_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "stopCamera");
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(false);
    this.jdField_j_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this.jdField_r_of_type_Boolean);
    this.jdField_i_of_type_Boolean = false;
    if ((CameraCaptureView.CaptureParam.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f();
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(this);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(null);
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(null);
  }
  
  public void i()
  {
    d();
    if (!CameraAbility.c()) {
      return;
    }
    NewFlowCameraOperator localNewFlowCameraOperator;
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_c_of_type_Int = 2;
      localNewFlowCameraOperator = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator;
      if (this.jdField_c_of_type_Int != 1) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      localNewFlowCameraOperator.a(bool);
      this.jdField_n_of_type_Boolean = false;
      QmcfManager.a().a(this.jdField_c_of_type_Int);
      AudioTranslator.a().a(true);
      h();
      g();
      r();
      return;
      this.jdField_c_of_type_Int = 1;
      break;
    }
  }
  
  public void j()
  {
    int i1 = 0;
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.B_();
    }
    if (a())
    {
      if (this.jdField_o_of_type_Boolean) {
        a(true);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".jpg";
      FileUtils.c((String)localObject);
      localObject = new File((String)localObject);
      boolean bool;
      if (this.jdField_c_of_type_Int == 1)
      {
        bool = true;
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Boolean) {
          break label160;
        }
      }
      label160:
      for (i1 = CaptureUtil.c(this.jdField_m_of_type_Int);; i1 = 0)
      {
        if ((!this.jdField_o_of_type_Boolean) || (this.jdField_n_of_type_Boolean)) {
          break label165;
        }
        jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(null, null, new ahlk(this, (File)localObject, i1, bool));
        return;
        bool = false;
        break;
      }
      label165:
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a((File)localObject, new Rect(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), this, i1, bool, 1);
      return;
    }
    if (this.jdField_o_of_type_Boolean)
    {
      i1 = 1500;
      a(true);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ahll(this), i1);
  }
  
  public void k()
  {
    d();
    if (this.jdField_o_of_type_Boolean) {
      a(true);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".mp4";
    int i1 = CaptureUtil.b(this.jdField_l_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = new EncodeConfig(str, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, CameraCaptureView.CaptureParam.d(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), CameraCaptureView.CaptureParam.e(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam), false, i1);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureParam.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = new CameraCaptureView.VideoCaptureResult();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.orientation = this.jdField_l_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.type = 0;
    if (this.jdField_c_of_type_Int == 2) {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.e();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_l_of_type_Boolean = true;
    CaptureUtil.a(false, false);
  }
  
  public void l()
  {
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = false;
      if ((this.jdField_q_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.a(102);
      }
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.f();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ReportUtil.jdField_a_of_type_Long = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    CaptureReportUtil.jdField_a_of_type_Long = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
  }
  
  public void m()
  {
    ReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath);
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new ahlf(this, getContext());
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.A_();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "Create to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_c_of_type_Long) + "ms");
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceDestroy");
    }
    this.jdField_m_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
    }
    h();
  }
  
  public void onDrawFrame(GL10 arg1)
  {
    if ((this.jdField_d_of_type_Int == 0) || (this.jdField_e_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null))
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
    }
    for (;;)
    {
      return;
      if (!this.jdField_i_of_type_Boolean) {
        continue;
      }
      long l1 = System.currentTimeMillis();
      System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        float[] arrayOfFloat = GPUBaseFilter.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b(), this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c());
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(36197, this.jdField_j_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
        QmcfManager.a().a(this.jdField_a_of_type_ArrayOfFloat);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
        System.currentTimeMillis();
        System.currentTimeMillis();
        int i1 = a(this.jdField_k_of_type_Int);
        System.currentTimeMillis();
        System.currentTimeMillis();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, i1, null, null);
        System.currentTimeMillis();
        System.currentTimeMillis();
        a(3553, i1, null, null, SystemClock.elapsedRealtimeNanos());
        System.currentTimeMillis();
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          n();
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          p();
        }
        if (this.jdField_c_of_type_Boolean)
        {
          a(i1, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
          this.jdField_c_of_type_Boolean = false;
        }
        long l2 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CameraCaptureView", 2, "onDrawFrame cost : " + (l2 - l1));
        return;
      }
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a()) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a().post(new ahlg(this, paramSurfaceTexture));
      return;
    }
    queueEvent(new ahlh(this, paramSurfaceTexture));
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onPause");
    }
    h();
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    GloableValue.b();
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_q_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker.a(paramArrayOfByte, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker$DarkModeListener);
    }
    CameraControl.a().a(true, paramArrayOfByte);
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = false;
    g();
    if (this.jdField_k_of_type_Boolean) {
      r();
    }
    if ((this.jdField_a_of_type_AndroidViewOrientationEventListener != null) && (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation())) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker.a();
    }
    GloableValue.a();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceChanged(): width " + paramInt1 + ";height" + paramInt2);
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_m_of_type_Boolean = true;
    g();
    r();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceCreated");
    }
    this.jdField_m_of_type_Boolean = false;
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.start();
    if (paramGL10 != null) {
      paramGL10.quitSafely();
    }
    this.jdField_j_of_type_Int = GlUtil.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_j_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
    this.jdField_q_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = CameraCompatibleList.c();
  }
  
  protected void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onFirstFrameShownEachOpenFrame");
    }
    NewFlowCameraReporter.b("first frame show");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$CaptureListener.g();
    }
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    CameraHelper.a(this.jdField_c_of_type_Int);
  }
  
  protected void q() {}
  
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
    c();
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.jdField_q_of_type_Boolean = paramBoolean;
  }
  
  public void setDarkModeListener(DarkModeChecker.DarkModeListener paramDarkModeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilDarkModeChecker$DarkModeListener = paramDarkModeListener;
  }
  
  public void setPreviewEnable(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "setPreviewEnable, " + paramBoolean);
    }
  }
  
  public void setSceneMode(String paramString)
  {
    d();
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(paramString);
  }
  
  public void setSegmentMode(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setSyncStopCamera(boolean paramBoolean)
  {
    this.jdField_r_of_type_Boolean = paramBoolean;
  }
  
  public void setZoom(int paramInt)
  {
    d();
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(paramInt);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "surfaceCreated");
    }
    super.surfaceCreated(paramSurfaceHolder);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "surfaceDestroyed");
    }
    super.surfaceDestroyed(paramSurfaceHolder);
    this.jdField_k_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */