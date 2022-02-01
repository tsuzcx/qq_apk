package com.tencent.mobileqq.richmedia.capture.view;

import alrq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
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
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import aqmy;
import bbhk;
import bbhm;
import bbho;
import bbjf;
import bbjg;
import bbjh;
import bbji;
import bbjj;
import bbjk;
import bczs;
import bdaw;
import bdax;
import bdba;
import bdbf;
import bdbm;
import bdcu;
import bddu;
import bnqe;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
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

@TargetApi(18)
public class QIdentifierCaptureView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, bczs, bdbm
{
  public static final bdbf a;
  protected int a;
  public long a;
  protected alrq a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new bbjf(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected OrientationEventListener a;
  private bbho jdField_a_of_type_Bbho;
  protected bbjh a;
  protected bbji a;
  public bbjj a;
  public bbjk a;
  protected EglHandlerThread a;
  protected TextureRender a;
  protected Map<String, RenderBuffer> a;
  public EGLConfig a;
  public EGLContext a;
  protected boolean a;
  protected final float[] a;
  protected int b;
  private long b;
  public boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  private boolean e;
  protected int f;
  private boolean f;
  protected int g;
  private volatile boolean g;
  protected int h;
  private boolean h;
  protected int i;
  private boolean i;
  public int j;
  private boolean j;
  public int k;
  private boolean k;
  public int l;
  private boolean l;
  public int m;
  private volatile boolean m;
  public int n;
  private volatile boolean n;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean = true;
  private boolean q;
  
  static
  {
    jdField_a_of_type_Bdbf = new bdbf(null, null);
  }
  
  public QIdentifierCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_j_of_type_Int = 90;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_l_of_type_Int = 90;
    this.jdField_d_of_type_Boolean = true;
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  public QIdentifierCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_j_of_type_Int = 90;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_l_of_type_Int = 90;
    this.jdField_d_of_type_Boolean = true;
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
  }
  
  private void i() {}
  
  protected int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Int = bbjj.a(this.jdField_a_of_type_Bbjj);
    if ((this.jdField_a_of_type_Int == 1) && (!aqmy.d())) {
      this.jdField_a_of_type_Int = 2;
    }
    if (this.jdField_d_of_type_Boolean) {
      setEGLContextClientVersion(2);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    setRenderer(this);
    setRenderMode(0);
    this.jdField_a_of_type_Alrq = new alrq();
    this.jdField_a_of_type_Bbho = new bbho();
    QmcfManager.getInstance().setCameraMode(this.jdField_a_of_type_Int);
    this.jdField_f_of_type_Boolean = true;
  }
  
  protected void a(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, null);
  }
  
  protected void a(bdba parambdba)
  {
    this.jdField_e_of_type_Int = parambdba.jdField_a_of_type_Int;
    this.jdField_d_of_type_Int = parambdba.jdField_b_of_type_Int;
    parambdba = bbhm.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_Bbjj.jdField_a_of_type_Int, this.jdField_a_of_type_Bbjj.jdField_b_of_type_Int, 1.0F);
    this.jdField_f_of_type_Int = parambdba[0];
    this.jdField_g_of_type_Int = parambdba[1];
    bbjj.jdField_b_of_type_JavaLangString = "key_aio_fbo" + this.jdField_f_of_type_Int + this.jdField_g_of_type_Int;
    queueEvent(new QIdentifierCaptureView.4(this));
    if (QLog.isColorLevel()) {
      QLog.i("QIdentifierCaptureView", 2, "onCameraSizeSelected(): cameraPreviewWidth=" + this.jdField_d_of_type_Int + ",cameraPreviewHeight=" + this.jdField_e_of_type_Int);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_a_of_type_Bdbf.e(paramBoolean);
  }
  
  protected int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  protected int b(int paramInt)
  {
    return paramInt;
  }
  
  public void b()
  {
    int i1;
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_Bbjh != null))
    {
      i1 = ((Activity)getContext()).checkSelfPermission("android.permission.CAMERA");
      if (QLog.isColorLevel()) {
        QLog.d("QIdentifierCaptureView", 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i1) });
      }
      if (i1 != 0) {
        if (!this.jdField_m_of_type_Boolean)
        {
          this.jdField_m_of_type_Boolean = true;
          this.jdField_a_of_type_Bbjh.a();
        }
      }
    }
    for (;;)
    {
      return;
      for (i1 = 0; (i1 != 0) || (this.jdField_n_of_type_Boolean); i1 = 1)
      {
        c();
        e();
        return;
      }
    }
  }
  
  protected int c()
  {
    int i1 = this.jdField_h_of_type_Int;
    RenderBuffer localRenderBuffer = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(bbjj.jdField_b_of_type_JavaLangString);
    if (localRenderBuffer != null)
    {
      localRenderBuffer.bind();
      synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, localRenderBuffer.getWidth(), localRenderBuffer.getHeight());
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_h_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
        QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
        i();
        localRenderBuffer.unbind();
        return localRenderBuffer.getTexId();
      }
    }
    return i1;
  }
  
  protected void c()
  {
    boolean bool = true;
    if (!this.jdField_f_of_type_Boolean) {}
    while (this.jdField_g_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "openCamera");
    }
    this.jdField_h_of_type_Boolean = false;
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    jdField_a_of_type_Bdbf.a(this);
    jdField_a_of_type_Bdbf.b(this.jdField_a_of_type_Int);
    this.jdField_g_of_type_Boolean = true;
    alrq localalrq;
    if (this.jdField_a_of_type_Alrq != null)
    {
      localalrq = this.jdField_a_of_type_Alrq;
      if (this.jdField_a_of_type_Int != 1) {
        break label102;
      }
    }
    for (;;)
    {
      localalrq.a(bool);
      alps.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return;
      label102:
      bool = false;
    }
  }
  
  public void d()
  {
    if (!this.jdField_f_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_g_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("QIdentifierCaptureView", 2, "stopCamera");
      }
      jdField_a_of_type_Bdbf.a(false);
      this.jdField_h_of_type_Boolean = false;
      jdField_a_of_type_Bdbf.b(this.jdField_j_of_type_Boolean);
      this.jdField_g_of_type_Boolean = false;
      jdField_a_of_type_Bdbf.b(this);
      jdField_a_of_type_Bdbf.b(PeakAppInterface.a);
      bbhk.a(this.jdField_a_of_type_Int);
    } while ((!this.jdField_o_of_type_Boolean) || (this.jdField_b_of_type_Long <= 0L));
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_b_of_type_Long);
    this.jdField_n_of_type_Int = (this.jdField_m_of_type_Int - 15);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void e()
  {
    if (!this.jdField_f_of_type_Boolean) {}
    while ((!this.jdField_i_of_type_Boolean) || (!this.jdField_g_of_type_Boolean) || ((this.jdField_h_of_type_Boolean) && (this.jdField_o_of_type_Int == this.jdField_b_of_type_Int) && (this.jdField_p_of_type_Int == this.jdField_c_of_type_Int))) {
      return;
    }
    if ((this.jdField_a_of_type_Bbjj.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Bbjj.jdField_b_of_type_Int == 0) || (this.jdField_p_of_type_Boolean))
    {
      this.jdField_a_of_type_Bbjj.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Bbjj.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "startCameraPreview, clipWidth:" + this.jdField_a_of_type_Bbjj.jdField_a_of_type_Int + ", clipHeight:" + this.jdField_a_of_type_Bbjj.jdField_b_of_type_Int + ", surfaceWidth:" + this.jdField_b_of_type_Int + ", surfaceHeight:" + this.jdField_c_of_type_Int);
    }
    jdField_a_of_type_Bdbf.a(new bdba(bbjj.b(this.jdField_a_of_type_Bbjj), bbjj.c(this.jdField_a_of_type_Bbjj)), new bdba(this.jdField_a_of_type_Bbjj.jdField_a_of_type_Int, this.jdField_a_of_type_Bbjj.jdField_b_of_type_Int), 0, 30, false);
    jdField_a_of_type_Bdbf.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this, true);
    this.jdField_h_of_type_Boolean = true;
    this.jdField_o_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_p_of_type_Int = this.jdField_c_of_type_Int;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_Alrq != null) {
      this.jdField_a_of_type_Alrq.a(this.jdField_g_of_type_Int, this.jdField_f_of_type_Int, a(), b());
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new bbjg(this, getContext());
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    if (this.jdField_a_of_type_Bbji != null) {
      this.jdField_a_of_type_Bbji.a();
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onSurfaceDestroy");
    }
    this.jdField_i_of_type_Boolean = false;
    if (!bddu.a())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext()) {
        ((RenderBuffer)localIterator.next()).destroy();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      GlUtil.deleteTexture(this.jdField_h_of_type_Int);
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
      QLog.d("QIdentifierCaptureView", 2, " notify : eventId = " + paramInt + " ; sender = " + paramObject + " ; args = " + Arrays.toString(paramVarArgs));
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
              } while (this.jdField_a_of_type_Bbji == null);
              this.jdField_a_of_type_Bbji.a(true, "");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bbji == null));
            this.jdField_a_of_type_Bbji.a(false, (String)paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bbji == null));
          this.jdField_a_of_type_Bbji.a(false, (String)paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_Bbji == null));
        this.jdField_a_of_type_Bbji.a(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof bdba)) {
          break;
        }
        a((bdba)paramVarArgs[0]);
        if (this.jdField_a_of_type_Bbji != null) {
          this.jdField_a_of_type_Bbji.a(true, "");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof bdba)));
      paramObject = (bdba)paramVarArgs[1];
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bbji == null));
    this.jdField_a_of_type_Bbji.a(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.jdField_d_of_type_Int == 0) || (this.jdField_e_of_type_Int == 0) || (this.jdField_a_of_type_JavaUtilMap.size() == 0))
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      if (QLog.isColorLevel()) {
        QLog.d("QIdentifierCaptureView", 2, "onDrawFrame clean");
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_g_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QIdentifierCaptureView", 2, "onDrawFrame ignore");
      return;
      long l1 = System.currentTimeMillis();
      if ((!this.jdField_o_of_type_Boolean) && (this.jdField_m_of_type_Int > 15))
      {
        this.jdField_o_of_type_Boolean = true;
        this.jdField_b_of_type_Long = l1;
      }
      this.jdField_i_of_type_Int = c();
      a(b(a(this.jdField_i_of_type_Int)));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        g();
      }
      this.jdField_m_of_type_Int += 1;
      if (this.jdField_m_of_type_Int == 10) {}
      FrameBufferCache.getInstance().forceRecycle();
    } while (this.jdField_e_of_type_Boolean);
    bnqe.a().a();
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a()) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a().post(new QIdentifierCaptureView.6(this, paramSurfaceTexture));
      return;
    }
    queueEvent(new QIdentifierCaptureView.7(this, paramSurfaceTexture));
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onPause");
    }
    this.k = false;
    this.jdField_l_of_type_Boolean = true;
    d();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    jdField_a_of_type_Bdbf.a(null);
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    ThreadManagerV2.excute(new QIdentifierCaptureView.3(this), 16, null, false);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_a_of_type_Bbjk != null) {
      this.jdField_a_of_type_Bbjk.a(paramArrayOfByte, paramCamera);
    }
    bdax.a().a(true, paramArrayOfByte);
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onResume");
    }
    this.jdField_l_of_type_Boolean = false;
    if (this.k)
    {
      QLog.d("QIdentifierCaptureView", 1, "onResume, blockCameraFlag return");
      return;
    }
    b();
    if (this.jdField_a_of_type_Bbho != null) {
      this.jdField_a_of_type_Bbho.a();
    }
    if ((this.jdField_a_of_type_AndroidViewOrientationEventListener != null) && (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation())) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
    ThreadManagerV2.excute(new QIdentifierCaptureView.2(this), 16, null, false);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onSurfaceChanged(): width " + paramInt1 + ";height" + paramInt2);
    }
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_i_of_type_Boolean = true;
    if ((this.k) || (this.jdField_l_of_type_Boolean)) {
      QLog.d("QIdentifierCaptureView", 1, new Object[] { "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(this.k), " ", Boolean.valueOf(this.jdField_l_of_type_Boolean) });
    }
    while (this.q) {
      return;
    }
    b();
    this.q = true;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onSurfaceCreated");
    }
    this.jdField_i_of_type_Boolean = false;
    paramEGLConfig = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.start();
    if (paramEGLConfig != null) {
      paramEGLConfig.quitSafely();
    }
    this.jdField_h_of_type_Int = GlUtil.createTexture(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_h_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_c_of_type_Boolean = bdaw.c();
    bdcu.a(paramGL10.glGetString(7937));
  }
  
  public void setCaptureListener(bbji parambbji)
  {
    this.jdField_a_of_type_Bbji = parambbji;
  }
  
  public void setCaptureParam(bbjj parambbjj)
  {
    if (this.jdField_a_of_type_Bbjj != null) {
      throw new RuntimeException("setCaptureParam is already called");
    }
    this.jdField_a_of_type_Bbjj = parambbjj;
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "setCaptureParam : " + parambbjj);
    }
    a();
  }
  
  public void setPreviewCallback(bbjk parambbjk)
  {
    this.jdField_a_of_type_Bbjk = parambbjk;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "surfaceCreated");
    }
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "surfaceDestroyed");
    }
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView
 * JD-Core Version:    0.7.0.1
 */