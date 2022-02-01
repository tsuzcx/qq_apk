package com.tencent.mobileqq.richmedia.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
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
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qqconnectface.api.ICamera;
import com.tencent.mobileqq.qqconnectface.impl.FaceCameraProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.eglwraper.EglHandlerThread;
import com.tencent.mobileqq.shortvideo.util.MediaCodecUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
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
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, SizeListener
{
  protected int a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new QIdentifierCaptureView.1(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected OrientationEventListener a;
  private ICamera jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera;
  public CaptureParam a;
  public OutPreviewCallback a;
  protected QIdentifierCaptureView.CameraPermissionListener a;
  protected EglHandlerThread a;
  protected TextureRender a;
  protected Map<String, RenderBuffer> a;
  public EGLConfig a;
  public EGLContext a;
  protected boolean a;
  protected final float[] a;
  protected int b;
  public boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  private boolean e;
  protected int f;
  private volatile boolean f;
  protected int g;
  private boolean g;
  protected int h;
  private boolean h;
  protected int i;
  private boolean i;
  protected int j;
  private boolean j;
  protected int k;
  private volatile boolean k;
  private int jdField_l_of_type_Int;
  private volatile boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean = true;
  private boolean n;
  
  public QIdentifierCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    this.jdField_i_of_type_Int = 90;
    this.jdField_j_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_k_of_type_Int = 90;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    g();
  }
  
  public QIdentifierCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    this.jdField_i_of_type_Int = 90;
    this.jdField_j_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_k_of_type_Int = 90;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    g();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    float f1 = paramInt1;
    int i1 = c((int)(f1 * paramFloat));
    float f2 = paramInt2;
    int i2 = c((int)(f2 * paramFloat));
    f1 = f2 * 1.0F / f1;
    f2 = paramInt4 * 1.0F / paramInt3;
    if (f1 > f2) {
      i2 = c((int)(i1 * f2));
    } else {
      i1 = c((int)(i2 / f2));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clipVideoSize(");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(",");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(") = (");
      localStringBuilder.append(i1);
      localStringBuilder.append(",");
      localStringBuilder.append(i2);
      localStringBuilder.append(")");
      QLog.d("QIdentifierCaptureView", 2, localStringBuilder.toString());
    }
    return new int[] { i1, i2 };
  }
  
  private int c(int paramInt)
  {
    int i2 = paramInt % 16;
    int i1 = paramInt;
    if (i2 != 0)
    {
      if (i2 < 8) {
        return paramInt - i2;
      }
      i1 = paramInt + (16 - i2);
    }
    return i1;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera = new FaceCameraProxy();
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(this);
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public void a()
  {
    int i2 = Build.VERSION.SDK_INT;
    int i1 = 0;
    if ((i2 >= 23) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView$CameraPermissionListener != null))
    {
      i2 = ((Activity)getContext()).checkSelfPermission("android.permission.CAMERA");
      if (QLog.isColorLevel()) {
        QLog.d("QIdentifierCaptureView", 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i2) });
      }
      if (i2 != 0)
      {
        if (this.jdField_k_of_type_Boolean) {
          break label88;
        }
        this.jdField_k_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewQIdentifierCaptureView$CameraPermissionListener.a();
        return;
      }
    }
    i1 = 1;
    label88:
    if ((i1 != 0) || (this.jdField_l_of_type_Boolean))
    {
      b();
      d();
    }
  }
  
  protected void a(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    Object localObject = a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.jdField_d_of_type_Int, 1.0F);
    this.jdField_e_of_type_Int = localObject[0];
    this.jdField_f_of_type_Int = localObject[1];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_aio_fbo");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
    ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
    CaptureParam.a = ((StringBuilder)localObject).toString();
    queueEvent(new QIdentifierCaptureView.2(this));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCameraSizeSelected(): cameraPreviewWidth=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",cameraPreviewHeight=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("QIdentifierCaptureView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramBoolean);
  }
  
  protected int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected int b(int paramInt)
  {
    return paramInt;
  }
  
  protected void b()
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a();
    this.jdField_f_of_type_Boolean = true;
  }
  
  protected int c()
  {
    int i1 = this.jdField_g_of_type_Int;
    RenderBuffer localRenderBuffer = (RenderBuffer)this.jdField_a_of_type_JavaUtilMap.get(CaptureParam.a);
    if (localRenderBuffer != null)
    {
      localRenderBuffer.bind();
      synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
        float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, localRenderBuffer.getWidth(), localRenderBuffer.getHeight());
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_g_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
        QmcfManager.getInstance().setSTMatrix(this.jdField_a_of_type_ArrayOfFloat);
        localRenderBuffer.unbind();
        return localRenderBuffer.getTexId();
      }
    }
    return i1;
  }
  
  public void c()
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (!this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.b();
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_f_of_type_Boolean) && ((!this.jdField_g_of_type_Boolean) || (this.jdField_l_of_type_Int != this.jdField_a_of_type_Int) || (this.jdField_m_of_type_Int != this.jdField_b_of_type_Int)))
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.jdField_c_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.jdField_d_of_type_Int == 0) || (this.jdField_m_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam;
        ((CaptureParam)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_Int;
        ((CaptureParam)localObject).jdField_d_of_type_Int = this.jdField_b_of_type_Int;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCameraPreview, clipWidth:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append(", clipHeight:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam.jdField_d_of_type_Int);
        ((StringBuilder)localObject).append(", surfaceWidth:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(", surfaceHeight:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        QLog.d("QIdentifierCaptureView", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewOutPreviewCallback, true);
      this.jdField_g_of_type_Boolean = true;
      this.jdField_l_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_m_of_type_Int = this.jdField_b_of_type_Int;
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new QIdentifierCaptureView.3(this, getContext());
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onSurfaceDestroy");
    }
    this.jdField_h_of_type_Boolean = false;
    if (!MediaCodecUtil.b())
    {
      localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RenderBuffer)((Iterator)localObject).next()).destroy();
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      GlUtil.deleteTexture(this.jdField_g_of_type_Int);
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
    c();
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.jdField_c_of_type_Int != 0) && (this.jdField_d_of_type_Int != 0) && (this.jdField_a_of_type_JavaUtilMap.size() != 0))
    {
      if (!this.jdField_f_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIdentifierCaptureView", 2, new Object[] { "onDrawFrame ignore , cameraPreviewWidth : ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
        }
        return;
      }
      this.jdField_h_of_type_Int = c();
      a(b(a(this.jdField_h_of_type_Int)));
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        e();
      }
      FrameBufferCache.getInstance().forceRecycle();
      return;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, new Object[] { "onDrawFrame clean , cameraPreviewWidth : ", Integer.valueOf(this.jdField_e_of_type_Int), " cameraPreviewHeight : ", Integer.valueOf(this.jdField_d_of_type_Int), " mCacheRenderBuffers size : ", Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) });
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread.isInitSuccess()) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread.getHandler().post(new QIdentifierCaptureView.4(this, paramSurfaceTexture));
      return;
    }
    queueEvent(new QIdentifierCaptureView.5(this, paramSurfaceTexture));
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onPause");
    }
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = true;
    c();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    OrientationEventListener localOrientationEventListener = this.jdField_a_of_type_AndroidViewOrientationEventListener;
    if (localOrientationEventListener != null) {
      localOrientationEventListener.disable();
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onResume");
    }
    this.jdField_j_of_type_Boolean = false;
    if (this.jdField_i_of_type_Boolean)
    {
      QLog.d("QIdentifierCaptureView", 1, "onResume, blockCameraFlag return");
      return;
    }
    a();
    OrientationEventListener localOrientationEventListener = this.jdField_a_of_type_AndroidViewOrientationEventListener;
    if ((localOrientationEventListener != null) && (localOrientationEventListener.canDetectOrientation())) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
    }
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
      QLog.d("QIdentifierCaptureView", 2, paramGL10.toString());
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_h_of_type_Boolean = true;
    if ((!this.jdField_i_of_type_Boolean) && (!this.jdField_j_of_type_Boolean))
    {
      if (!this.n)
      {
        a();
        this.n = true;
      }
      return;
    }
    QLog.d("QIdentifierCaptureView", 1, new Object[] { "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(this.jdField_i_of_type_Boolean), " ", Boolean.valueOf(this.jdField_j_of_type_Boolean) });
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onSurfaceCreated");
    }
    this.jdField_h_of_type_Boolean = false;
    paramGL10 = this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoEglwraperEglHandlerThread.start();
    if (paramGL10 != null) {
      paramGL10.quitSafely();
    }
    this.jdField_g_of_type_Int = GlUtil.createTexture(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_g_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_c_of_type_Boolean = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isNeedDrawOnOpenGLSingleThread();
  }
  
  public void setCaptureListener(CaptureListener paramCaptureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramCaptureListener);
  }
  
  public void setCaptureParam(CaptureParam paramCaptureParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureParam = paramCaptureParam;
      if (this.jdField_d_of_type_Boolean) {
        setEGLContextClientVersion(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramCaptureParam);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      setRenderer(this);
      setRenderMode(0);
      this.jdField_e_of_type_Boolean = true;
      return;
    }
    throw new RuntimeException("setCaptureParam is already called");
  }
  
  public void setPreviewCallback(OutPreviewCallback paramOutPreviewCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewOutPreviewCallback = paramOutPreviewCallback;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView
 * JD-Core Version:    0.7.0.1
 */