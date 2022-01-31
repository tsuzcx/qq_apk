package com.tencent.mobileqq.richmedia.capture.view;

import ahvy;
import ahyd;
import aiak;
import amfw;
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
import avrq;
import avrr;
import avsx;
import avtb;
import avtc;
import avtf;
import avtg;
import avtn;
import avub;
import avuc;
import avud;
import avue;
import avug;
import avuh;
import avui;
import avuj;
import avuk;
import avul;
import avum;
import avyy;
import avzk;
import avzm;
import axge;
import axgj;
import axho;
import axhp;
import axhs;
import axhv;
import axhw;
import axhx;
import axie;
import axik;
import axjp;
import axks;
import bbcv;
import bbdj;
import biwd;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQLowLightFilter;
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
  implements aiak, SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, avrq, avzk, axgj, axhw, axie
{
  public static final axhx a;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  protected int a;
  protected long a;
  protected ahvy a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new avub(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected OrientationEventListener a;
  private View jdField_a_of_type_AndroidViewView;
  protected avrr a;
  private avtf jdField_a_of_type_Avtf;
  private avtg jdField_a_of_type_Avtg;
  private avug jdField_a_of_type_Avug;
  protected avuh a;
  protected avui a;
  public avuj a;
  private avuk jdField_a_of_type_Avuk;
  public avul a;
  protected avyy a;
  protected avzm a;
  private axhv jdField_a_of_type_Axhv;
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
    jdField_a_of_type_Axhx = new axhx(null, null);
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
  
  private void f()
  {
    if (!this.jdField_k_of_type_Boolean) {
      throw new RuntimeException("Not inited. Must be called after setCaptureParam");
    }
  }
  
  private void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      g(paramBoolean);
      return;
    }
    jdField_a_of_type_Axhx.c(paramBoolean);
  }
  
  private void g(boolean paramBoolean)
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
  
  private void h() {}
  
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
      paramBoolean = d();
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
        Object localObject1 = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(avuj.f);
        if (localObject1 != null) {
          ((RenderBuffer)localObject1).bind();
        }
        synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null);
          QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
          QmcfManager.getInstance().setIsQQRun(false);
          h();
          i1 = ((RenderBuffer)localObject1).getTexId();
          ((RenderBuffer)localObject1).unbind();
          ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(avuj.g);
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
            paramBoolean = e();
          } else {
            paramBoolean = false;
          }
        }
      }
    }
    Object localObject3 = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(avuj.jdField_d_of_type_JavaLangString);
    if (localObject3 != null) {
      ((RenderBuffer)localObject3).bind();
    }
    synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, null);
      QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
      QmcfManager.getInstance().setIsQQRun(false);
      h();
      i1 = ((RenderBuffer)localObject3).getTexId();
      ((RenderBuffer)localObject3).unbind();
      ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(avuj.e);
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
    ??? = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(avuj.jdField_c_of_type_JavaLangString);
    if (??? != null)
    {
      ((RenderBuffer)???).bind();
      synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, ((RenderBuffer)???).getWidth(), ((RenderBuffer)???).getHeight());
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_s_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
        QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
        h();
        ((RenderBuffer)???).unbind();
        return ((RenderBuffer)???).getTexId();
      }
    }
    return i1;
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Avzm != null) {
      return this.jdField_a_of_type_Avzm.a();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Avuj.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount = 0;
    if ((this.jdField_a_of_type_Avuj.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null))
    {
      if (!this.jdField_a_of_type_Avrr.a()) {
        break label66;
      }
      this.jdField_a_of_type_Avrr.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Avui != null) {
        this.jdField_a_of_type_Avui.c();
      }
      return;
      label66:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Ahvy == null) {
      return;
    }
    f();
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureView", 2, "requestCameraFocus x:" + paramFloat1 + "y: " + paramFloat2 + ", Orientation:" + ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation());
    }
    axge localaxge = new axge();
    localaxge.jdField_a_of_type_Float = paramFloat1;
    localaxge.jdField_b_of_type_Float = paramFloat2;
    localaxge.jdField_a_of_type_Int = b();
    localaxge.jdField_b_of_type_Int = c();
    localaxge.jdField_a_of_type_Ahvy = this.jdField_a_of_type_Ahvy;
    localaxge.jdField_c_of_type_Int = avtc.c(this.jdField_v_of_type_Int);
    jdField_a_of_type_Axhx.a(localaxge, new avud(this));
  }
  
  public void a(int paramInt)
  {
    QLog.e("CameraCaptureView", 2, "onAudioError. errorCode = " + paramInt);
    switch (paramInt)
    {
    default: 
      return;
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.12(this));
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
      while (this.jdField_a_of_type_Avui == null) {}
      this.jdField_a_of_type_Avui.a(103);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Avyy != null))
    {
      switch (this.jdField_r_of_type_Int)
      {
      default: 
        throw new RuntimeException("unknown status " + this.jdField_r_of_type_Int);
      case 0: 
        this.jdField_a_of_type_Avyy.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_Avzm.a();
        this.jdField_a_of_type_Avzm.a(this.jdField_a_of_type_Avyy, this);
        this.jdField_r_of_type_Int = 1;
      }
      this.jdField_a_of_type_Avzm.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
      return;
    }
    switch (this.jdField_r_of_type_Int)
    {
    case 0: 
    default: 
      throw new RuntimeException("unknown status " + this.jdField_r_of_type_Int);
    }
    this.jdField_a_of_type_Avzm.b();
    w();
    this.jdField_r_of_type_Int = 0;
  }
  
  protected void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a(3553, paramInt, paramArrayOfFloat1, paramArrayOfFloat2, SystemClock.elapsedRealtimeNanos());
  }
  
  protected void a(avum paramavum)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Avui != null) {
      this.jdField_a_of_type_Avui.a(paramavum);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.10(this));
    avtn.b();
    if (axhp.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      avtb.g(i1);
      return;
      i1 = 2;
    }
  }
  
  protected void a(axhs paramaxhs)
  {
    this.jdField_e_of_type_Int = paramaxhs.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = paramaxhs.jdField_b_of_type_Int;
    if (!this.jdField_f_of_type_Boolean)
    {
      paramaxhs = avtc.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Avuj.jdField_a_of_type_Int, this.jdField_a_of_type_Avuj.jdField_b_of_type_Int, 1.0F);
      this.jdField_n_of_type_Int = paramaxhs[0];
      this.jdField_o_of_type_Int = paramaxhs[1];
      paramaxhs = avtc.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Avuj.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = paramaxhs[0];
      this.jdField_q_of_type_Int = paramaxhs[1];
      paramaxhs = avtc.a(avuj.b(this.jdField_a_of_type_Avuj), this.jdField_p_of_type_Int, this.jdField_q_of_type_Int);
      this.jdField_p_of_type_Int = paramaxhs[0];
      this.jdField_q_of_type_Int = paramaxhs[1];
      avuj.jdField_c_of_type_JavaLangString = "key_aio_fbo" + this.jdField_n_of_type_Int + this.jdField_o_of_type_Int;
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
      paramaxhs = avtc.a(avuj.b(this.jdField_a_of_type_Avuj), this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      i1 = paramaxhs[0];
      i2 = paramaxhs[1];
      avuj.jdField_d_of_type_JavaLangString = "key_riji_h_compress_fbo" + i1 + i2;
      paramaxhs = avtc.a(i1, i2, this.jdField_a_of_type_Avuj.jdField_a_of_type_Int, this.jdField_a_of_type_Avuj.jdField_b_of_type_Int, 1.0F);
      this.jdField_f_of_type_Int = paramaxhs[0];
      this.jdField_g_of_type_Int = paramaxhs[1];
      avuj.e = "key_riji_h_clip_fbo" + this.jdField_f_of_type_Int + this.jdField_g_of_type_Int;
      this.jdField_j_of_type_Int = this.jdField_f_of_type_Int;
      this.jdField_k_of_type_Int = this.jdField_g_of_type_Int;
      avuj.f(this.jdField_a_of_type_Avuj);
      paramaxhs = avtc.a(avuj.g(this.jdField_a_of_type_Avuj), this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      i3 = paramaxhs[0];
      i4 = paramaxhs[1];
      avuj.f = "key_riji_l_compress_fbo" + i3 + i4;
      paramaxhs = avtc.a(i3, i4, this.jdField_a_of_type_Avuj.jdField_a_of_type_Int, this.jdField_a_of_type_Avuj.jdField_b_of_type_Int, 1.0F);
      this.jdField_h_of_type_Int = paramaxhs[0];
      this.jdField_i_of_type_Int = paramaxhs[1];
      avuj.g = "key_riji_l_clip_fbo" + this.jdField_h_of_type_Int + this.jdField_i_of_type_Int;
      this.jdField_l_of_type_Int = this.jdField_h_of_type_Int;
      this.jdField_m_of_type_Int = this.jdField_i_of_type_Int;
      queueEvent(new CameraCaptureView.8(this, i1, i2, i3, i4));
    } while (!QLog.isColorLevel());
    QLog.i("CameraCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.jdField_d_of_type_Int + ",cameraPreviewHeight=" + this.jdField_e_of_type_Int + "， highCompressCameraPreviewWidth=" + i1 + ",highCompressCamerareviewHeight=" + i2 + "， highCameraClipWidth=" + this.jdField_f_of_type_Int + ",highCameraClipHeight=" + this.jdField_g_of_type_Int + ", highVideoWidth=" + this.jdField_j_of_type_Int + ",highVideoHeight=" + this.jdField_k_of_type_Int + " ,lowCompressCameraPreviewWidth=" + i3 + ",lowCompressCamerareviewHeight=" + i4 + " ,lowCameraClipWidth=" + this.jdField_h_of_type_Int + " ,lowCameraClipHeight=" + this.jdField_i_of_type_Int + ",lowVideoWidth=" + this.jdField_l_of_type_Int + " ,lowVideoHeight=" + this.jdField_m_of_type_Int);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    int i1 = 1;
    if (this.jdField_a_of_type_Avui != null) {
      this.jdField_a_of_type_Avui.a(paramVideoCaptureResult);
    }
    ThreadManager.getUIHandler().post(new CameraCaptureView.11(this));
    avtn.c();
    if (axhp.a().jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      avtb.i(i1);
      return;
      i1 = 2;
    }
  }
  
  public void a(Exception paramException) {}
  
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
          do
          {
            do
            {
              do
              {
                return;
                if (!(paramVarArgs[0] instanceof axhs)) {
                  break;
                }
                a((axhs)paramVarArgs[0]);
              } while (this.jdField_a_of_type_Avui == null);
              this.jdField_a_of_type_Avui.a(true, "");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Avui == null));
            this.jdField_a_of_type_Avui.a(false, (String)paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Avui == null));
          this.jdField_a_of_type_Avui.a(false, (String)paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_Avui == null));
        this.jdField_a_of_type_Avui.a(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof axhs)) {
          break;
        }
        a((axhs)paramVarArgs[0]);
        if (this.jdField_a_of_type_Avui != null) {
          this.jdField_a_of_type_Avui.a(true, "");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof axhs)));
      paramObject = (axhs)paramVarArgs[1];
      this.D = paramObject.jdField_a_of_type_Int;
      this.E = paramObject.jdField_b_of_type_Int;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Avui == null));
    this.jdField_a_of_type_Avui.a(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
  }
  
  public void a(RuntimeException paramRuntimeException) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onEncodeFinish filePath = " + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath = paramString;
    if ((this.jdField_a_of_type_Avuj.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
    for (;;)
    {
      ThreadManager.postImmediately(new CameraCaptureView.9(this), null, false);
      return;
      if (this.jdField_a_of_type_Avrr.a())
      {
        this.jdField_a_of_type_Avrr.b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.e();
        continue;
        paramString = this.jdField_a_of_type_Avuj.jdField_b_of_type_JavaLangString + "/noaudio";
        bbdj.c(paramString);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = paramString;
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
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
      arrayOfInt = avtc.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Avuj.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ahvy != null) {
        this.jdField_a_of_type_Ahvy.a(this.jdField_o_of_type_Int, this.jdField_n_of_type_Int, b(), c());
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "compress=" + paramBoolean + " onCameraSizeUpdate cameraClipHeight = " + this.jdField_o_of_type_Int + " cameraClipWidth=" + this.jdField_n_of_type_Int + " videoWidth=" + this.jdField_p_of_type_Int + " videoHeight=" + this.jdField_q_of_type_Int);
      }
      return;
      label190:
      arrayOfInt = avtc.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Avuj.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
      continue;
      label234:
      this.jdField_o_of_type_Int = this.jdField_g_of_type_Int;
      this.jdField_n_of_type_Int = this.jdField_f_of_type_Int;
      arrayOfInt = avtc.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Avuj.jdField_a_of_type_Float);
      this.jdField_p_of_type_Int = arrayOfInt[0];
      this.jdField_q_of_type_Int = arrayOfInt[1];
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
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
      this.jdField_a_of_type_Avtf.a(paramArrayOfByte, i1, i2, this.jdField_a_of_type_Avtg);
    }
    if (this.jdField_a_of_type_Avul != null) {
      this.jdField_a_of_type_Avul.a(paramArrayOfByte, paramCamera);
    }
    axhp.a().a(true, paramArrayOfByte);
  }
  
  protected boolean a()
  {
    return amfw.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    f();
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 23))
    {
      Activity localActivity = (Activity)getContext();
      if (!Settings.System.canWrite(localActivity)) {
        bbcv.a(localActivity, null, null);
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
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.errorCode = paramInt;
    if (this.jdField_a_of_type_Avui != null) {
      this.jdField_a_of_type_Avui.a(104);
    }
  }
  
  public void a_(String paramString)
  {
    a(new avum(1, 0, paramString, null, this.jdField_u_of_type_Int));
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
    CameraCaptureView.VideoCaptureResult localVideoCaptureResult = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
    localVideoCaptureResult.videoFrameCount += 1;
  }
  
  protected void b(int paramInt) {}
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.d();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b();
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c() {}
  
  protected void c(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, null);
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    f();
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
  
  public boolean c()
  {
    return (this.jdField_p_of_type_Int != 0) && (this.jdField_q_of_type_Int != 0);
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    jdField_a_of_type_Axhx.e(paramBoolean);
  }
  
  protected boolean d()
  {
    return false;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Int = avuj.a(this.jdField_a_of_type_Avuj);
    if ((this.jdField_a_of_type_Int == 1) && (!amfw.d())) {
      this.jdField_a_of_type_Int = 2;
    }
    if (this.jdField_i_of_type_Boolean) {
      setEGLContextClientVersion(2);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Axhv = new axhv(this.jdField_a_of_type_AndroidOsHandler, this);
    jdField_a_of_type_Axhx.a(this.jdField_a_of_type_Axhv);
    setRenderer(this);
    setRenderMode(0);
    this.jdField_a_of_type_Avzm = new avzm();
    if (this.jdField_a_of_type_Avuj.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(this.jdField_a_of_type_Avuj.jdField_b_of_type_JavaLangString, 1, axik.jdField_q_of_type_Int, axik.jdField_o_of_type_Int, axik.jdField_p_of_type_Int, this, jdField_a_of_type_Axhx.a());
      this.jdField_a_of_type_Avrr = new avrr(this.jdField_a_of_type_Avuj.jdField_b_of_type_JavaLangString, axik.jdField_q_of_type_Int, this);
    }
    this.jdField_a_of_type_Ahvy = new ahvy();
    this.jdField_a_of_type_Avtf = new avtf();
    QmcfManager.getInstance().setCameraMode(this.jdField_a_of_type_Int);
    this.jdField_k_of_type_Boolean = true;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_y_of_type_Boolean = paramBoolean;
  }
  
  protected boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onSurfaceDestroy");
    }
    this.jdField_n_of_type_Boolean = false;
    if (!axks.b())
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
    n();
  }
  
  public void i()
  {
    f();
    if (this.jdField_p_of_type_Boolean) {
      f(true);
    }
    String str = this.jdField_a_of_type_Avuj.jdField_b_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".mp4";
    if (this.jdField_d_of_type_Boolean) {}
    for (int i1 = avtc.b(this.jdField_u_of_type_Int);; i1 = 0)
    {
      this.jdField_a_of_type_Avyy = new avyy(str, this.jdField_p_of_type_Int, this.jdField_q_of_type_Int, avuj.d(this.jdField_a_of_type_Avuj), avuj.e(this.jdField_a_of_type_Avuj), false, i1);
      this.jdField_a_of_type_Avyy.jdField_j_of_type_Int = this.jdField_a_of_type_Avuj.jdField_c_of_type_Int;
      this.jdField_a_of_type_Avyy.jdField_k_of_type_Int = this.jdField_a_of_type_Avuj.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = new CameraCaptureView.VideoCaptureResult();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.orientation = this.jdField_u_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.type = 0;
      if (this.jdField_a_of_type_Int == 2) {
        jdField_a_of_type_Axhx.f();
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      avtc.a(false, false);
      return;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_r_of_type_Int != 0) {
        break label81;
      }
      if (this.jdField_a_of_type_Avui != null) {
        this.jdField_a_of_type_Avui.a(102);
      }
    }
    for (;;)
    {
      jdField_a_of_type_Axhx.g();
      jdField_a_of_type_Axhx.h();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      avtn.jdField_a_of_type_Long = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      avtb.jdField_a_of_type_Long = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      return;
      label81:
      if (this.jdField_u_of_type_Boolean) {
        a(0, null, null);
      }
    }
  }
  
  public void l()
  {
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_Avuh != null))
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
          this.jdField_a_of_type_Avuh.H_();
        }
      }
    }
    for (;;)
    {
      return;
      for (i1 = 0; (i1 != 0) || (this.jdField_w_of_type_Boolean); i1 = 1)
      {
        m();
        o();
        return;
      }
    }
  }
  
  protected void m()
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
    jdField_a_of_type_Axhx.a(this);
    jdField_a_of_type_Axhx.b(this.jdField_a_of_type_Int);
    this.jdField_l_of_type_Boolean = true;
    if ((this.jdField_a_of_type_Avuj.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.f();
    }
    ahvy localahvy;
    if (this.jdField_a_of_type_Ahvy != null)
    {
      localahvy = this.jdField_a_of_type_Ahvy;
      if (this.jdField_a_of_type_Int != 1) {
        break label126;
      }
    }
    for (;;)
    {
      localahvy.a(bool);
      ahua.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return;
      label126:
      bool = false;
    }
  }
  
  public void n()
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
      jdField_a_of_type_Axhx.a(false);
      this.jdField_m_of_type_Boolean = false;
      jdField_a_of_type_Axhx.b(this.jdField_s_of_type_Boolean);
      this.jdField_l_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Avuj.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.g();
      }
      jdField_a_of_type_Axhx.b(this);
      jdField_a_of_type_Axhx.b(PeakAppInterface.a);
      avsx.a(this.jdField_a_of_type_Int);
    } while ((!this.jdField_x_of_type_Boolean) || (this.jdField_e_of_type_Long <= 0L));
    this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_e_of_type_Long);
    this.jdField_y_of_type_Int = (this.jdField_x_of_type_Int - 15);
    this.jdField_e_of_type_Long = 0L;
  }
  
  public void o()
  {
    if (!this.jdField_k_of_type_Boolean) {}
    while ((!this.jdField_n_of_type_Boolean) || (!this.jdField_l_of_type_Boolean) || ((this.jdField_m_of_type_Boolean) && (this.jdField_z_of_type_Int == this.jdField_b_of_type_Int) && (this.A == this.jdField_c_of_type_Int))) {
      return;
    }
    if ((this.jdField_a_of_type_Avuj.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Avuj.jdField_b_of_type_Int == 0) || (this.jdField_y_of_type_Boolean))
    {
      this.jdField_a_of_type_Avuj.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Avuj.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "startCameraPreview, clipWidth:" + this.jdField_a_of_type_Avuj.jdField_a_of_type_Int + ", clipHeight:" + this.jdField_a_of_type_Avuj.jdField_b_of_type_Int + ", surfaceWidth:" + this.jdField_b_of_type_Int + ", surfaceHeight:" + this.jdField_c_of_type_Int);
    }
    if (this.jdField_f_of_type_Boolean) {
      jdField_a_of_type_Axhx.a(new axhs(this.jdField_c_of_type_Int, this.jdField_b_of_type_Int), new axhs(this.jdField_a_of_type_Avuj.jdField_a_of_type_Int, this.jdField_a_of_type_Avuj.jdField_b_of_type_Int), 0, 30, this.jdField_f_of_type_Boolean);
    }
    for (;;)
    {
      jdField_a_of_type_Axhx.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this, true);
      p();
      this.jdField_m_of_type_Boolean = true;
      this.jdField_z_of_type_Int = this.jdField_b_of_type_Int;
      this.A = this.jdField_c_of_type_Int;
      return;
      jdField_a_of_type_Axhx.a(new axhs(avuj.b(this.jdField_a_of_type_Avuj), avuj.c(this.jdField_a_of_type_Avuj)), new axhs(this.jdField_a_of_type_Avuj.jdField_a_of_type_Int, this.jdField_a_of_type_Avuj.jdField_b_of_type_Int), 0, 30, this.jdField_f_of_type_Boolean);
    }
  }
  
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
      int i1 = b(this.jdField_t_of_type_Int);
      c(a(i1));
      a(i1, null, null);
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        u();
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
    biwd.a().a();
    this.jdField_j_of_type_Boolean = true;
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
    n();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_p_of_type_Boolean) {
      f(false);
    }
    jdField_a_of_type_Axhx.a(null);
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    ThreadManagerV2.excute(new CameraCaptureView.3(this), 16, null, false);
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
    l();
    if (this.jdField_a_of_type_Avtf != null) {
      this.jdField_a_of_type_Avtf.a();
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
    l();
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
    this.jdField_h_of_type_Boolean = axho.c();
    if (this.jdField_a_of_type_Avuk != null) {
      this.jdField_a_of_type_Avuk.a();
    }
    axjp.a(paramGL10.glGetString(7937));
  }
  
  protected void p() {}
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "changeCamera");
    }
    f();
    if (!amfw.d()) {
      return;
    }
    ahvy localahvy;
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 2;
      if (this.jdField_a_of_type_Ahvy != null)
      {
        localahvy = this.jdField_a_of_type_Ahvy;
        if (this.jdField_a_of_type_Int != 1) {
          break label133;
        }
      }
    }
    label133:
    for (boolean bool = true;; bool = false)
    {
      localahvy.a(bool);
      this.jdField_o_of_type_Boolean = false;
      QmcfManager.getInstance().setCameraMode(this.jdField_a_of_type_Int);
      ahyd.a().a(true);
      n();
      m();
      o();
      if (this.jdField_a_of_type_Avug != null) {
        this.jdField_a_of_type_Avug.l();
      }
      b(this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Int = 1;
      break;
    }
  }
  
  public void r()
  {
    int i1 = 0;
    f();
    if (this.jdField_a_of_type_Avui != null) {
      this.jdField_a_of_type_Avui.b();
    }
    Object localObject;
    boolean bool;
    if (a())
    {
      if (this.jdField_p_of_type_Boolean) {
        f(true);
      }
      localObject = this.jdField_a_of_type_Avuj.jdField_b_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".jpg";
      bbdj.c((String)localObject);
      localObject = new File((String)localObject);
      if (this.jdField_a_of_type_Int == 1)
      {
        bool = true;
        if (!this.jdField_a_of_type_Avuj.jdField_b_of_type_Boolean) {
          break label217;
        }
        i1 = avtc.c(this.jdField_v_of_type_Int);
        label121:
        if (QLog.isColorLevel()) {
          QLog.i("CameraCaptureView", 2, "photoOrientation:" + i1);
        }
        if ((!this.jdField_p_of_type_Boolean) || (this.jdField_o_of_type_Boolean)) {
          break label222;
        }
        jdField_a_of_type_Axhx.a(new axge(true), new avue(this, (File)localObject, i1, bool));
        label192:
        if (QLog.isColorLevel()) {
          QLog.d("CameraCaptureView", 2, "capturePhoto, use sysCamera");
        }
      }
    }
    for (;;)
    {
      s();
      return;
      bool = false;
      break;
      label217:
      i1 = 0;
      break label121;
      label222:
      jdField_a_of_type_Axhx.a((File)localObject, new Rect(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int), this, i1, bool, 1, this.jdField_v_of_type_Int);
      break label192;
      if (this.jdField_p_of_type_Boolean)
      {
        i1 = 1500;
        f(true);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new CameraCaptureView.6(this), i1);
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "capturePhoto, use captureFrame");
      }
    }
  }
  
  protected void s() {}
  
  public void setBlockCameraFlag(boolean paramBoolean)
  {
    this.jdField_t_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraChangeListener(avug paramavug)
  {
    this.jdField_a_of_type_Avug = paramavug;
  }
  
  public void setCameraPermissionFinish(boolean paramBoolean)
  {
    this.jdField_w_of_type_Boolean = paramBoolean;
  }
  
  public void setCameraPermissionListener(avuh paramavuh)
  {
    this.jdField_a_of_type_Avuh = paramavuh;
  }
  
  public void setCameraPermissionResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "setCameraPermissionResult, ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_w_of_type_Boolean = true;
    m();
    o();
  }
  
  public void setCaptureListener(avui paramavui)
  {
    this.jdField_a_of_type_Avui = paramavui;
  }
  
  public void setCaptureParam(avuj paramavuj)
  {
    if (this.jdField_a_of_type_Avuj != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_Avuj = paramavuj;
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "setCaptureParam : " + paramavuj);
    }
    e();
  }
  
  public void setDarkModeEnable(boolean paramBoolean)
  {
    this.jdField_r_of_type_Boolean = paramBoolean;
  }
  
  public void setDarkModeListener(avtg paramavtg)
  {
    this.jdField_a_of_type_Avtg = paramavtg;
  }
  
  public void setDynamicResolutionMode(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setOnSurfaceCreatedListener(avuk paramavuk)
  {
    this.jdField_a_of_type_Avuk = paramavuk;
  }
  
  public void setPreviewCallback(avul paramavul)
  {
    this.jdField_a_of_type_Avul = paramavul;
  }
  
  public void setSceneMode(String paramString)
  {
    f();
    jdField_a_of_type_Axhx.a(paramString);
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
    f();
    jdField_a_of_type_Axhx.c(paramInt);
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
  
  protected void t()
  {
    avtn.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath);
  }
  
  protected void u()
  {
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new avuc(this, getContext());
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    if (this.jdField_a_of_type_Avui != null) {
      this.jdField_a_of_type_Avui.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "Create to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_d_of_type_Long) + "ms");
    }
  }
  
  public void v() {}
  
  protected void w() {}
  
  public void x()
  {
    queueEvent(new CameraCaptureView.17(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */