package com.tencent.mobileqq.richmedia.capture.view;

import alrq;
import alun;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
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
import aqmy;
import bbgd;
import bbge;
import bbhk;
import bbhl;
import bbhm;
import bbho;
import bbhp;
import bbht;
import bbia;
import bbib;
import bbic;
import bbid;
import bbif;
import bbig;
import bbih;
import bbii;
import bbij;
import bbik;
import bbil;
import bbmm;
import bbmy;
import bbna;
import bczn;
import bczs;
import bdaw;
import bdax;
import bdba;
import bdbd;
import bdbe;
import bdbf;
import bdbm;
import bdcu;
import bddu;
import bhdj;
import bnqe;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.io.File;
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
  implements alun, SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, bbgd, bbmy, bczs, bdbe, bdbm
{
  public static final bdbf a;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  protected int a;
  protected long a;
  protected alrq a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new bbia(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected OrientationEventListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected bbge a;
  private bbho jdField_a_of_type_Bbho;
  private bbhp jdField_a_of_type_Bbhp;
  private bbif jdField_a_of_type_Bbif;
  protected bbig a;
  protected bbih a;
  public bbii a;
  private bbij jdField_a_of_type_Bbij;
  public bbik a;
  protected bbmm a;
  protected bbna a;
  private bdbd jdField_a_of_type_Bdbd;
  protected AudioCapture a;
  protected CameraCaptureView.VideoCaptureResult a;
  protected EglHandlerThread a;
  protected TextureRender a;
  protected Map<String, RenderBuffer> a;
  public EGLConfig a;
  public EGLContext a;
  protected volatile boolean a;
  protected final float[] a;
  public int b;
  protected long b;
  protected boolean b;
  public int c;
  public long c;
  protected volatile boolean c;
  protected int d;
  private long d;
  protected boolean d;
  protected int e;
  private long e;
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
  public int u;
  private boolean u;
  public int v;
  private volatile boolean v;
  public int w;
  private volatile boolean w;
  public int x;
  private boolean x;
  public int y;
  private boolean y;
  private int jdField_z_of_type_Int;
  private boolean jdField_z_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Bdbf = new bdbf(null, null);
  }
  
  public CameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_r_of_type_Boolean = true;
    this.jdField_u_of_type_Int = 90;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_w_of_type_Int = 90;
    this.jdField_y_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  public CameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_r_of_type_Boolean = true;
    this.jdField_u_of_type_Int = 90;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_w_of_type_Int = 90;
    this.jdField_y_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      e(paramBoolean);
      return;
    }
    jdField_a_of_type_Bdbf.c(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
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
        this.B = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.C = Settings.System.getInt(localActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(localActivity.getContentResolver(), "screen_brightness", 255);
        this.jdField_q_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        do
        {
          this.B = 1;
          this.C = 100;
        } while (!QLog.isColorLevel());
        QLog.e("CameraCaptureView", 2, "turn FrontFlash Error ", localException);
        localException.printStackTrace();
        return;
      }
      if (this.jdField_q_of_type_Boolean)
      {
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness", this.C);
        Settings.System.putInt(localException.getContentResolver(), "screen_brightness_mode", this.B);
        this.jdField_q_of_type_Boolean = false;
      }
    } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getParent() == null));
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void q()
  {
    if (!this.jdField_k_of_type_Boolean) {
      throw new RuntimeException("Not inited. Must be called after setCaptureParam");
    }
  }
  
  private void r() {}
  
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
      paramBoolean = b();
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
        Object localObject1 = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(bbii.f);
        if (localObject1 != null) {
          ((RenderBuffer)localObject1).bind();
        }
        synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null);
          QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
          QmcfManager.getInstance().setIsQQRun(false);
          r();
          i1 = ((RenderBuffer)localObject1).getTexId();
          ((RenderBuffer)localObject1).unbind();
          ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(bbii.g);
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
                b(true);
                i3 = i2;
              }
            }
          }
          return i3;
          if (this.jdField_f_of_type_Boolean) {
            paramBoolean = c();
          } else {
            paramBoolean = false;
          }
        }
      }
    }
    Object localObject3 = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(bbii.jdField_d_of_type_JavaLangString);
    if (localObject3 != null) {
      ((RenderBuffer)localObject3).bind();
    }
    synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null);
      QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
      QmcfManager.getInstance().setIsQQRun(false);
      r();
      i1 = ((RenderBuffer)localObject3).getTexId();
      ((RenderBuffer)localObject3).unbind();
      ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(bbii.e);
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
            b(false);
            i3 = i2;
          }
        }
      }
      return i3;
    }
    label571:
    ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(bbii.jdField_c_of_type_JavaLangString);
    if (??? != null)
    {
      ((RenderBuffer)???).bind();
      synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
        QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
        r();
        ((RenderBuffer)???).unbind();
        return ((RenderBuffer)???).getTexId();
      }
    }
    return i1;
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Bbna != null) {
      return this.jdField_a_of_type_Bbna.a();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Bbii.jdField_b_of_type_JavaLangString;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int = bbii.a(this.jdField_a_of_type_Bbii);
    if ((this.jdField_a_of_type_Int == 1) && (!aqmy.d())) {
      this.jdField_a_of_type_Int = 2;
    }
    if (this.jdField_i_of_type_Boolean) {
      setEGLContextClientVersion(2);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Bdbd = new bdbd(this.jdField_a_of_type_AndroidOsHandler, this);
    jdField_a_of_type_Bdbf.a(this.jdField_a_of_type_Bdbd);
    setRenderer(this);
    setRenderMode(0);
    this.jdField_a_of_type_Bbna = new bbna();
    if (this.jdField_a_of_type_Bbii.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Bbii.jdField_b_of_type_JavaLangString, 1, CodecParam.mAudioSampleRate, CodecParam.mAudioChannel, CodecParam.mAudioFormat, this, jdField_a_of_type_Bdbf.a());
      this.jdField_a_of_type_Bbge = new bbge(this.jdField_a_of_type_Bbii.jdField_b_of_type_JavaLangString, CodecParam.mAudioSampleRate, this);
    }
    this.jdField_a_of_type_Alrq = new alrq();
    this.jdField_a_of_type_Bbho = new bbho();
    QmcfManager.getInstance().setCameraMode(this.jdField_a_of_type_Int);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Alrq == null) {
      return;
    }
    q();
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureView", 2, "requestCameraFocus x:" + paramFloat1 + "y: " + paramFloat2 + ", Orientation:" + ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation());
    }
    bczn localbczn = new bczn();
    localbczn.jdField_a_of_type_Float = paramFloat1;
    localbczn.jdField_b_of_type_Float = paramFloat2;
    localbczn.jdField_a_of_type_Int = b();
    localbczn.jdField_b_of_type_Int = c();
    localbczn.jdField_a_of_type_Alrq = this.jdField_a_of_type_Alrq;
    localbczn.jdField_c_of_type_Int = bbhm.c(this.jdField_v_of_type_Int);
    jdField_a_of_type_Bdbf.a(localbczn, new bbic(this));
  }
  
  protected void a(int paramInt) {}
  
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
      while (this.jdField_a_of_type_Bbih == null) {}
      this.jdField_a_of_type_Bbih.a(103);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bbmm != null))
    {
      switch (this.jdField_r_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_r_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Bbmm.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Bbna.a();
        this.jdField_a_of_type_Bbna.a(this.jdField_a_of_type_Bbmm, this);
        this.jdField_r_of_type_Int = 1;
      }
      this.jdField_a_of_type_Bbna.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_r_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_r_of_type_Int);
    }
    this.jdField_a_of_type_Bbna.b();
    o();
    this.jdField_r_of_type_Int = 0;
  }
  
  protected void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, SystemClock.elapsedRealtimeNanos());
  }
  
  protected void a(bbil parambbil)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Bbih != null) {
      this.jdField_a_of_type_Bbih.a(parambbil);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.10(this));
    bbht.b();
    if (bdax.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      bbhl.e(i1);
      return;
      i1 = 2;
    }
  }
  
  protected void a(bdba parambdba)
  {
    this.jdField_e_of_type_Int = parambdba.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = parambdba.jdField_b_of_type_Int;
    if (!this.jdField_f_of_type_Boolean)
    {
      parambdba = bbhm.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Bbii.jdField_a_of_type_Int, this.jdField_a_of_type_Bbii.jdField_b_of_type_Int, 1.0F);
      this.jdField_n_of_type_Int = parambdba[0];
      this.jdField_o_of_type_Int = parambdba[1];
      parambdba = bbhm.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Bbii.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = parambdba[0];
      this.jdField_q_of_type_Int = parambdba[1];
      parambdba = bbhm.a(bbii.b(this.jdField_a_of_type_Bbii), this.jdField_p_of_type_Int, this.jdField_q_of_type_Int);
      this.jdField_p_of_type_Int = parambdba[0];
      this.jdField_q_of_type_Int = parambdba[1];
      bbii.jdField_c_of_type_JavaLangString = "key_aio_fbo" + this.jdField_n_of_type_Int + this.jdField_o_of_type_Int;
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
      parambdba = bbhm.a(bbii.b(this.jdField_a_of_type_Bbii), this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      i1 = parambdba[0];
      i2 = parambdba[1];
      bbii.jdField_d_of_type_JavaLangString = "key_riji_h_compress_fbo" + i1 + i2;
      parambdba = bbhm.a(i1, i2, this.jdField_a_of_type_Bbii.jdField_a_of_type_Int, this.jdField_a_of_type_Bbii.jdField_b_of_type_Int, 1.0F);
      this.jdField_f_of_type_Int = parambdba[0];
      this.jdField_g_of_type_Int = parambdba[1];
      bbii.e = "key_riji_h_clip_fbo" + this.jdField_f_of_type_Int + this.jdField_g_of_type_Int;
      this.jdField_j_of_type_Int = this.jdField_f_of_type_Int;
      this.jdField_k_of_type_Int = this.jdField_g_of_type_Int;
      bbii.f(this.jdField_a_of_type_Bbii);
      parambdba = bbhm.a(bbii.g(this.jdField_a_of_type_Bbii), this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      i3 = parambdba[0];
      i4 = parambdba[1];
      bbii.f = "key_riji_l_compress_fbo" + i3 + i4;
      parambdba = bbhm.a(i3, i4, this.jdField_a_of_type_Bbii.jdField_a_of_type_Int, this.jdField_a_of_type_Bbii.jdField_b_of_type_Int, 1.0F);
      this.jdField_h_of_type_Int = parambdba[0];
      this.jdField_i_of_type_Int = parambdba[1];
      bbii.g = "key_riji_l_clip_fbo" + this.jdField_h_of_type_Int + this.jdField_i_of_type_Int;
      this.jdField_l_of_type_Int = this.jdField_h_of_type_Int;
      this.jdField_m_of_type_Int = this.jdField_i_of_type_Int;
      queueEvent(new CameraCaptureView.8(this, i1, i2, i3, i4));
    } while (!QLog.isColorLevel());
    QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.jdField_d_of_type_Int + ",cameraPreviewHeight=" + this.jdField_e_of_type_Int + "， highCompressCameraPreviewWidth=" + i1 + ",highCompressCamerareviewHeight=" + i2 + "， highCameraClipWidth=" + this.jdField_f_of_type_Int + ",highCameraClipHeight=" + this.jdField_g_of_type_Int + ", highVideoWidth=" + this.jdField_j_of_type_Int + ",highVideoHeight=" + this.jdField_k_of_type_Int + " ,lowCompressCameraPreviewWidth=" + i3 + ",lowCompressCamerareviewHeight=" + i4 + " ,lowCameraClipWidth=" + this.jdField_h_of_type_Int + " ,lowCameraClipHeight=" + this.jdField_i_of_type_Int + ",lowVideoWidth=" + this.jdField_l_of_type_Int + " ,lowVideoHeight=" + this.jdField_m_of_type_Int);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Bbih != null) {
      this.jdField_a_of_type_Bbih.a(paramVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.11(this));
    bbht.c();
    if (bdax.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      bbhl.g(i1);
      return;
      i1 = 2;
    }
  }
  
  public void a(String paramString)
  {
    a(new bbil(1, 0, paramString, null, this.jdField_u_of_type_Int));
  }
  
  public void a(boolean paramBoolean)
  {
    q();
    try
    {
      QQLowLightFilter.enableNightMode(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected boolean a()
  {
    return aqmy.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    q();
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 23))
    {
      Activity localActivity = (Activity)getContext();
      if (!Settings.System.canWrite(localActivity)) {
        bhdj.a(localActivity, null, null);
      }
    }
    for (boolean bool = false;; bool = true)
    {
      if (bool) {
        this.jdField_p_of_type_Boolean = paramBoolean;
      }
      return bool;
    }
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
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_Bbig != null))
    {
      Activity localActivity = (Activity)getContext();
      i1 = localActivity.checkSelfPermission("android.permission.CAMERA");
      int i2 = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i1), " audio: ", Integer.valueOf(i2) });
      }
      if ((i1 != 0) || (i2 != 0)) {
        if (!this.jdField_v_of_type_Boolean)
        {
          this.jdField_v_of_type_Boolean = true;
          this.jdField_a_of_type_Bbig.a();
        }
      }
    }
    for (;;)
    {
      return;
      for (i1 = 0; (i1 != 0) || (this.jdField_w_of_type_Boolean); i1 = 1)
      {
        c();
        e();
        return;
      }
    }
  }
  
  protected void b(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, null);
  }
  
  protected void b(boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (this.jdField_f_of_type_Boolean)
    {
      if (!paramBoolean) {
        break label234;
      }
      this.jdField_o_of_type_Int = this.jdField_i_of_type_Int;
      this.jdField_n_of_type_Int = this.jdField_h_of_type_Int;
      if (!this.jdField_e_of_type_Boolean) {
        break label190;
      }
      arrayOfInt = bbhm.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Bbii.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Alrq != null) {
        this.jdField_a_of_type_Alrq.a(this.jdField_o_of_type_Int, this.jdField_n_of_type_Int, b(), c());
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "compress=" + paramBoolean + " onCameraSizeUpdate cameraClipHeight = " + this.jdField_o_of_type_Int + " cameraClipWidth=" + this.jdField_n_of_type_Int + " videoWidth=" + this.jdField_p_of_type_Int + " videoHeight=" + this.jdField_q_of_type_Int);
      }
      return;
      label190:
      arrayOfInt = bbhm.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Bbii.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
      continue;
      label234:
      this.jdField_o_of_type_Int = this.jdField_g_of_type_Int;
      this.jdField_n_of_type_Int = this.jdField_f_of_type_Int;
      arrayOfInt = bbhm.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Bbii.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
    }
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
    this.A = 0;
    jdField_a_of_type_Bdbf.a(this);
    jdField_a_of_type_Bdbf.b(this.jdField_a_of_type_Int);
    this.jdField_l_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Bbii.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f();
    }
    alrq localalrq;
    if (this.jdField_a_of_type_Alrq != null)
    {
      localalrq = this.jdField_a_of_type_Alrq;
      if (this.jdField_a_of_type_Int != 1) {
        break label126;
      }
    }
    for (;;)
    {
      localalrq.a(bool);
      alps.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return;
      label126:
      bool = false;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    jdField_a_of_type_Bdbf.e(paramBoolean);
  }
  
  protected boolean c()
  {
    return false;
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
      jdField_a_of_type_Bdbf.a(false);
      this.jdField_m_of_type_Boolean = false;
      jdField_a_of_type_Bdbf.b(this.jdField_s_of_type_Boolean);
      this.jdField_l_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Bbii.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.g();
      }
      jdField_a_of_type_Bdbf.b(this);
      jdField_a_of_type_Bdbf.b(PeakAppInterface.a);
      bbhk.a(this.jdField_a_of_type_Int);
    } while ((!this.jdField_x_of_type_Boolean) || (this.jdField_e_of_type_Long <= 0L));
    this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_e_of_type_Long);
    this.jdField_y_of_type_Int = (this.jdField_x_of_type_Int - 15);
    this.jdField_e_of_type_Long = 0L;
  }
  
  public void e()
  {
    if (!this.jdField_k_of_type_Boolean) {}
    while ((!this.jdField_n_of_type_Boolean) || (!this.jdField_l_of_type_Boolean) || ((this.jdField_m_of_type_Boolean) && (this.jdField_z_of_type_Int == this.jdField_b_of_type_Int) && (this.A == this.jdField_c_of_type_Int))) {
      return;
    }
    if ((this.jdField_a_of_type_Bbii.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Bbii.jdField_b_of_type_Int == 0) || (this.jdField_y_of_type_Boolean))
    {
      this.jdField_a_of_type_Bbii.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bbii.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "startCameraPreview, clipWidth:" + this.jdField_a_of_type_Bbii.jdField_a_of_type_Int + ", clipHeight:" + this.jdField_a_of_type_Bbii.jdField_b_of_type_Int + ", surfaceWidth:" + this.jdField_b_of_type_Int + ", surfaceHeight:" + this.jdField_c_of_type_Int);
    }
    if (this.jdField_f_of_type_Boolean) {
      jdField_a_of_type_Bdbf.a(new bdba(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int), new bdba(this.jdField_a_of_type_Bbii.jdField_a_of_type_Int, this.jdField_a_of_type_Bbii.jdField_b_of_type_Int), 0, 30, this.jdField_f_of_type_Boolean);
    }
    for (;;)
    {
      jdField_a_of_type_Bdbf.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this, true);
      f();
      this.jdField_m_of_type_Boolean = true;
      this.jdField_z_of_type_Int = this.jdField_b_of_type_Int;
      this.A = this.jdField_c_of_type_Int;
      return;
      jdField_a_of_type_Bdbf.a(new bdba(bbii.b(this.jdField_a_of_type_Bbii), bbii.c(this.jdField_a_of_type_Bbii)), new bdba(this.jdField_a_of_type_Bbii.jdField_a_of_type_Int, this.jdField_a_of_type_Bbii.jdField_b_of_type_Int), 0, 30, this.jdField_f_of_type_Boolean);
    }
  }
  
  protected void f() {}
  
  public void g()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "changeCamera");
    }
    q();
    if (!aqmy.d()) {
      return;
    }
    alrq localalrq;
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Alrq != null)
      {
        localalrq = this.jdField_a_of_type_Alrq;
        if (this.jdField_a_of_type_Int != 1) {
          break label126;
        }
      }
    }
    for (;;)
    {
      localalrq.a(bool);
      this.jdField_o_of_type_Boolean = false;
      QmcfManager.getInstance().setCameraMode(this.jdField_a_of_type_Int);
      d();
      c();
      e();
      if (this.jdField_a_of_type_Bbif != null) {
        this.jdField_a_of_type_Bbif.a();
      }
      a(this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Int = 1;
      break;
      label126:
      bool = false;
    }
  }
  
  public void h()
  {
    int i1 = 0;
    q();
    if (this.jdField_a_of_type_Bbih != null) {
      this.jdField_a_of_type_Bbih.f();
    }
    Object localObject;
    boolean bool;
    if (a())
    {
      if (this.jdField_p_of_type_Boolean) {
        d(true);
      }
      localObject = this.jdField_a_of_type_Bbii.jdField_b_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".jpg";
      FileUtils.createFileIfNotExits((String)localObject);
      localObject = new File((String)localObject);
      if (this.jdField_a_of_type_Int == 1)
      {
        bool = true;
        if (!this.jdField_a_of_type_Bbii.jdField_b_of_type_Boolean) {
          break label217;
        }
        i1 = bbhm.c(this.jdField_v_of_type_Int);
        label121:
        if (QLog.isColorLevel()) {
          QLog.i("CameraCaptureView", 2, "photoOrientation:" + i1);
        }
        if ((!this.jdField_p_of_type_Boolean) || (this.jdField_o_of_type_Boolean)) {
          break label222;
        }
        jdField_a_of_type_Bdbf.a(new bczn(true), new bbid(this, (File)localObject, i1, bool));
        label192:
        if (QLog.isColorLevel()) {
          QLog.d("CameraCaptureView", 2, "capturePhoto, use sysCamera");
        }
      }
    }
    for (;;)
    {
      i();
      return;
      bool = false;
      break;
      label217:
      i1 = 0;
      break label121;
      label222:
      jdField_a_of_type_Bdbf.a((File)localObject, new Rect(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int), this, i1, bool, 1, this.jdField_v_of_type_Int);
      break label192;
      if (this.jdField_p_of_type_Boolean)
      {
        i1 = 1500;
        d(true);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new CameraCaptureView.6(this), i1);
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "capturePhoto, use captureFrame");
      }
    }
  }
  
  protected void i() {}
  
  public void j()
  {
    q();
    if (this.jdField_p_of_type_Boolean) {
      d(true);
    }
    String str = this.jdField_a_of_type_Bbii.jdField_b_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".mp4";
    if (this.jdField_d_of_type_Boolean) {}
    for (int i1 = bbhm.b(this.jdField_u_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Bbmm = new bbmm(str, this.jdField_p_of_type_Int, this.jdField_q_of_type_Int, bbii.d(this.jdField_a_of_type_Bbii), bbii.e(this.jdField_a_of_type_Bbii), false, i1);
      this.jdField_a_of_type_Bbmm.jdField_j_of_type_Int = this.jdField_a_of_type_Bbii.jdField_c_of_type_Int;
      this.jdField_a_of_type_Bbmm.jdField_k_of_type_Int = this.jdField_a_of_type_Bbii.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = new CameraCaptureView.VideoCaptureResult();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.orientation = this.jdField_u_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.type = 0;
      if (this.jdField_a_of_type_Int == 2) {
        jdField_a_of_type_Bdbf.f();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      bbhm.a(false, false);
      return;
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_r_of_type_Int != 0) {
        break label81;
      }
      if (this.jdField_a_of_type_Bbih != null) {
        this.jdField_a_of_type_Bbih.a(102);
      }
    }
    for (;;)
    {
      jdField_a_of_type_Bdbf.g();
      jdField_a_of_type_Bdbf.h();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      bbht.jdField_a_of_type_Long = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      bbhl.jdField_a_of_type_Long = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      return;
      label81:
      if (this.jdField_u_of_type_Boolean) {
        a(0, null, null);
      }
    }
  }
  
  protected void l()
  {
    bbht.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath);
  }
  
  protected void m()
  {
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new bbib(this, getContext());
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    if (this.jdField_a_of_type_Bbih != null) {
      this.jdField_a_of_type_Bbih.e();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "Create to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_d_of_type_Long) + "ms");
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceDestroy");
    }
    this.jdField_n_of_type_Boolean = false;
    if (!bddu.a())
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
                if (!(paramVarArgs[0] instanceof bdba)) {
                  break;
                }
                a((bdba)paramVarArgs[0]);
              } while (this.jdField_a_of_type_Bbih == null);
              this.jdField_a_of_type_Bbih.a(true, "");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bbih == null));
            this.jdField_a_of_type_Bbih.a(false, (String)paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bbih == null));
          this.jdField_a_of_type_Bbih.a(false, (String)paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_Bbih == null));
        this.jdField_a_of_type_Bbih.a(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof bdba)) {
          break;
        }
        a((bdba)paramVarArgs[0]);
        if (this.jdField_a_of_type_Bbih != null) {
          this.jdField_a_of_type_Bbih.a(true, "");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof bdba)));
      paramObject = (bdba)paramVarArgs[1];
      this.D = paramObject.jdField_a_of_type_Int;
      this.E = paramObject.jdField_b_of_type_Int;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bbih == null));
    this.jdField_a_of_type_Bbih.a(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
  }
  
  protected void o() {}
  
  public void onAudioCaptured(String paramString)
  {
    if (!this.jdField_a_of_type_Bbge.a())
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
    if (this.jdField_a_of_type_Bbge.a())
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
      if ((!this.jdField_x_of_type_Boolean) && (this.jdField_x_of_type_Int > 15))
      {
        this.jdField_x_of_type_Boolean = true;
        this.jdField_e_of_type_Long = l1;
      }
      boolean bool = this.jdField_c_of_type_Boolean;
      this.jdField_t_of_type_Int = a(bool);
      int i1 = a(this.jdField_t_of_type_Int);
      b(b(i1));
      a(i1, null, null);
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        m();
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
    bnqe.a().a();
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void onEncodeAudioCaptured(String paramString) {}
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Bbih != null) {
      this.jdField_a_of_type_Bbih.a(104);
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onEncodeFinish filePath = " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath = paramString;
    if ((this.jdField_a_of_type_Bbii.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
    for (;;)
    {
      ThreadManager.postImmediately(new CameraCaptureView.9(this), null, false);
      return;
      if (this.jdField_a_of_type_Bbge.a())
      {
        this.jdField_a_of_type_Bbge.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        continue;
        paramString = this.jdField_a_of_type_Bbii.jdField_b_of_type_JavaLangString + "/noaudio";
        FileUtils.createFileIfNotExits(paramString);
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
    if ((this.jdField_a_of_type_Bbii.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null))
    {
      if (!this.jdField_a_of_type_Bbge.a()) {
        break label66;
      }
      this.jdField_a_of_type_Bbge.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bbih != null) {
        this.jdField_a_of_type_Bbih.g();
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
    this.jdField_t_of_type_Boolean = false;
    this.jdField_u_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_p_of_type_Boolean) {
      d(false);
    }
    jdField_a_of_type_Bdbf.a(null);
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    ThreadManagerV2.excute(new CameraCaptureView.3(this), 16, null, false);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_r_of_type_Boolean)
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
      this.jdField_a_of_type_Bbho.a(paramArrayOfByte, i1, i2, this.jdField_a_of_type_Bbhp);
    }
    if (this.jdField_a_of_type_Bbik != null) {
      this.jdField_a_of_type_Bbik.a(paramArrayOfByte, paramCamera);
    }
    bdax.a().a(true, paramArrayOfByte);
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onResume");
    }
    this.jdField_u_of_type_Boolean = false;
    if (this.jdField_t_of_type_Boolean)
    {
      QLog.d("CameraCaptureView", 1, "onResume, blockCameraFlag return");
      return;
    }
    b();
    if (this.jdField_a_of_type_Bbho != null) {
      this.jdField_a_of_type_Bbho.a();
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
    this.jdField_n_of_type_Boolean = true;
    if ((this.jdField_t_of_type_Boolean) || (this.jdField_u_of_type_Boolean)) {
      QLog.d("CameraCaptureView", 1, new Object[] { "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(this.jdField_t_of_type_Boolean), " ", Boolean.valueOf(this.jdField_u_of_type_Boolean) });
    }
    while (this.jdField_z_of_type_Boolean) {
      return;
    }
    b();
    this.jdField_z_of_type_Boolean = true;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceCreated");
    }
    this.jdField_n_of_type_Boolean = false;
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
    this.jdField_h_of_type_Boolean = bdaw.c();
    if (this.jdField_a_of_type_Bbij != null) {
      this.jdField_a_of_type_Bbij.a();
    }
    bdcu.a(paramGL10.glGetString(7937));
  }
  
  public void p()
  {
    queueEvent(new CameraCaptureView.17(this));
  }
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    this.jdField_t_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraChangeListener(bbif parambbif)
  {
    this.jdField_a_of_type_Bbif = parambbif;
  }
  
  public void setCameraPermissionFinish(boolean paramBoolean)
  {
    this.jdField_w_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraPermissionListener(bbig parambbig)
  {
    this.jdField_a_of_type_Bbig = parambbig;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "setCameraPermissionResult, ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_w_of_type_Boolean = true;
    c();
    e();
  }
  
  public void setCaptureListener(bbih parambbih)
  {
    this.jdField_a_of_type_Bbih = parambbih;
  }
  
  public void setCaptureParam(bbii parambbii)
  {
    if (this.jdField_a_of_type_Bbii != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_Bbii = parambbii;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "setCaptureParam : " + parambbii);
    }
    a();
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.jdField_r_of_type_Boolean = paramBoolean;
  }
  
  public void setDarkModeListener(bbhp parambbhp)
  {
    this.jdField_a_of_type_Bbhp = parambbhp;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setOnSurfaceCreatedListener(bbij parambbij)
  {
    this.jdField_a_of_type_Bbij = parambbij;
  }
  
  public void setPreviewCallback(bbik parambbik)
  {
    this.jdField_a_of_type_Bbik = parambbik;
  }
  
  public void setSceneMode(String paramString)
  {
    q();
    jdField_a_of_type_Bdbf.a(paramString);
  }
  
  public void setSegmentMode(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setSyncStopCamera(boolean paramBoolean)
  {
    this.jdField_s_of_type_Boolean = paramBoolean;
  }
  
  public void setUseVideoOrientation(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void setZoom(int paramInt)
  {
    q();
    jdField_a_of_type_Bdbf.c(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */