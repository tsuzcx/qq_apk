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
  private GLSurfaceView.EGLContextFactory A = new QIdentifierCaptureView.1(this);
  private Handler B;
  private boolean C = false;
  private volatile boolean D = false;
  private boolean E = false;
  private int F;
  private int G;
  private boolean H = false;
  private boolean I;
  private boolean J;
  private volatile boolean K = false;
  private volatile boolean L = false;
  private boolean M = true;
  private boolean N;
  private ICamera O;
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected QIdentifierCaptureView.CameraPermissionListener g;
  protected boolean h = false;
  public OutPreviewCallback i;
  protected int j;
  protected int k;
  protected SurfaceTexture l;
  protected final float[] m = new float[16];
  protected Map<String, RenderBuffer> n = new HashMap();
  protected TextureRender o;
  protected EglHandlerThread p;
  public EGLConfig q = null;
  public EGLContext r = null;
  public CaptureParam s;
  protected OrientationEventListener t;
  protected int u = 90;
  protected int v = 0;
  public boolean w = true;
  protected int x = 90;
  protected boolean y = false;
  protected boolean z = true;
  
  public QIdentifierCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
    setEGLContextFactory(this.A);
    h();
  }
  
  public QIdentifierCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextFactory(this.A);
    h();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    float f1 = paramInt1;
    int i1 = d((int)(f1 * paramFloat));
    float f2 = paramInt2;
    int i2 = d((int)(f2 * paramFloat));
    f1 = f2 * 1.0F / f1;
    f2 = paramInt4 * 1.0F / paramInt3;
    if (f1 > f2) {
      i2 = d((int)(i1 * f2));
    } else {
      i1 = d((int)(i2 / f2));
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
  
  private int d(int paramInt)
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
  
  private void h()
  {
    this.O = new FaceCameraProxy();
    this.O.a(this);
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public void a()
  {
    int i2 = Build.VERSION.SDK_INT;
    int i1 = 0;
    if ((i2 >= 23) && (this.g != null))
    {
      i2 = ((Activity)getContext()).checkSelfPermission("android.permission.CAMERA");
      if (QLog.isColorLevel()) {
        QLog.d("QIdentifierCaptureView", 2, new Object[] { "startCameraWithPermission, camera: ", Integer.valueOf(i2) });
      }
      if (i2 != 0)
      {
        if (this.K) {
          break label88;
        }
        this.K = true;
        this.g.a();
        return;
      }
    }
    i1 = 1;
    label88:
    if ((i1 != 0) || (this.L))
    {
      b();
      d();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.c = paramInt2;
    Object localObject = a(this.c, this.d, this.s.c, this.s.d, 1.0F);
    this.e = localObject[0];
    this.f = localObject[1];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_aio_fbo");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(this.f);
    CaptureParam.g = ((StringBuilder)localObject).toString();
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
    this.O.a(paramBoolean);
  }
  
  protected int b(int paramInt)
  {
    return paramInt;
  }
  
  protected void b()
  {
    if (!this.C) {
      return;
    }
    if (this.D) {
      return;
    }
    this.E = false;
    this.F = 0;
    this.G = 0;
    this.O.a();
    this.D = true;
  }
  
  public void c()
  {
    if (!this.C) {
      return;
    }
    if (!this.D) {
      return;
    }
    this.E = false;
    this.O.b();
    this.D = false;
  }
  
  protected void c(int paramInt)
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, this.a, this.b);
    this.o.drawTexture(3553, paramInt, null, null);
  }
  
  public void d()
  {
    if (!this.C) {
      return;
    }
    if ((this.H) && (this.D) && ((!this.E) || (this.F != this.a) || (this.G != this.b)))
    {
      Object localObject;
      if ((this.s.c == 0) || (this.s.d == 0) || (this.M))
      {
        localObject = this.s;
        ((CaptureParam)localObject).c = this.a;
        ((CaptureParam)localObject).d = this.b;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCameraPreview, clipWidth:");
        ((StringBuilder)localObject).append(this.s.c);
        ((StringBuilder)localObject).append(", clipHeight:");
        ((StringBuilder)localObject).append(this.s.d);
        ((StringBuilder)localObject).append(", surfaceWidth:");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(", surfaceHeight:");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("QIdentifierCaptureView", 2, ((StringBuilder)localObject).toString());
      }
      this.O.a(this.l, null, this.i, true);
      this.E = true;
      this.F = this.a;
      this.G = this.b;
    }
  }
  
  protected void e()
  {
    this.t = new QIdentifierCaptureView.3(this, getContext());
    if (this.t.canDetectOrientation()) {
      this.t.enable();
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onSurfaceDestroy");
    }
    this.H = false;
    if (!MediaCodecUtil.b())
    {
      localObject = this.n.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((RenderBuffer)((Iterator)localObject).next()).destroy();
      }
      this.n.clear();
      GlUtil.deleteTexture(this.j);
      localObject = this.l;
      if (localObject != null) {
        ((SurfaceTexture)localObject).release();
      }
      localObject = this.o;
      if (localObject != null) {
        ((TextureRender)localObject).release();
      }
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((SurfaceTexture)localObject).setOnFrameAvailableListener(null);
    }
    c();
  }
  
  protected int g()
  {
    int i1 = this.j;
    RenderBuffer localRenderBuffer = (RenderBuffer)this.n.get(CaptureParam.g);
    if (localRenderBuffer != null)
    {
      localRenderBuffer.bind();
      synchronized (this.l)
      {
        this.l.getTransformMatrix(this.m);
        float[] arrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.c, this.d, localRenderBuffer.getWidth(), localRenderBuffer.getHeight());
        this.o.drawTexture(36197, this.j, this.m, arrayOfFloat);
        QmcfManager.getInstance().setSTMatrix(this.m);
        localRenderBuffer.unbind();
        return localRenderBuffer.getTexId();
      }
    }
    return i1;
  }
  
  protected int getFocusSurfaceHeight()
  {
    return this.b;
  }
  
  protected int getFocusSurfaceWidth()
  {
    return this.a;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.c != 0) && (this.d != 0) && (this.n.size() != 0))
    {
      if (!this.D)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIdentifierCaptureView", 2, new Object[] { "onDrawFrame ignore , cameraPreviewWidth : ", Boolean.valueOf(this.D) });
        }
        return;
      }
      this.k = g();
      c(b(a(this.k)));
      if (!this.h)
      {
        this.h = true;
        e();
      }
      FrameBufferCache.getInstance().forceRecycle();
      return;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, new Object[] { "onDrawFrame clean , cameraPreviewWidth : ", Integer.valueOf(this.e), " cameraPreviewHeight : ", Integer.valueOf(this.d), " mCacheRenderBuffers size : ", Integer.valueOf(this.n.size()) });
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.p.isInitSuccess()) && (!this.y))
    {
      this.p.getHandler().post(new QIdentifierCaptureView.4(this, paramSurfaceTexture));
      return;
    }
    queueEvent(new QIdentifierCaptureView.5(this, paramSurfaceTexture));
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onPause");
    }
    this.I = false;
    this.J = true;
    c();
    this.B.removeCallbacksAndMessages(null);
    OrientationEventListener localOrientationEventListener = this.t;
    if (localOrientationEventListener != null) {
      localOrientationEventListener.disable();
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onResume");
    }
    this.J = false;
    if (this.I)
    {
      QLog.d("QIdentifierCaptureView", 1, "onResume, blockCameraFlag return");
      return;
    }
    a();
    OrientationEventListener localOrientationEventListener = this.t;
    if ((localOrientationEventListener != null) && (localOrientationEventListener.canDetectOrientation())) {
      this.t.enable();
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
    this.a = paramInt1;
    this.b = paramInt2;
    this.H = true;
    if ((!this.I) && (!this.J))
    {
      if (!this.N)
      {
        a();
        this.N = true;
      }
      return;
    }
    QLog.d("QIdentifierCaptureView", 1, new Object[] { "onSurfaceChanged, blockCameraFlag return, ", Boolean.valueOf(this.I), " ", Boolean.valueOf(this.J) });
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIdentifierCaptureView", 2, "onSurfaceCreated");
    }
    this.H = false;
    paramGL10 = this.p;
    this.p = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.p.start();
    if (paramGL10 != null) {
      paramGL10.quitSafely();
    }
    this.j = GlUtil.createTexture(36197);
    this.l = new SurfaceTexture(this.j);
    this.l.setOnFrameAvailableListener(this);
    this.o = new TextureRender();
    this.y = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isNeedDrawOnOpenGLSingleThread();
  }
  
  public void setCaptureListener(CaptureListener paramCaptureListener)
  {
    this.O.a(paramCaptureListener);
  }
  
  public void setCaptureParam(CaptureParam paramCaptureParam)
  {
    if (this.s == null)
    {
      this.s = paramCaptureParam;
      if (this.z) {
        setEGLContextClientVersion(2);
      }
      this.O.a(paramCaptureParam);
      this.B = new Handler(Looper.getMainLooper());
      setRenderer(this);
      setRenderMode(0);
      this.C = true;
      return;
    }
    throw new RuntimeException("setCaptureParam is already called");
  }
  
  public void setPreviewCallback(OutPreviewCallback paramOutPreviewCallback)
  {
    this.i = paramOutPreviewCallback;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentifierCaptureView
 * JD-Core Version:    0.7.0.1
 */