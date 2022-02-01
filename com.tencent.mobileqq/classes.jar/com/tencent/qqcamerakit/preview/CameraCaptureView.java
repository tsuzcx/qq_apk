package com.tencent.qqcamerakit.preview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.Toast;
import com.tencent.qqcamerakit.capture.CameraPreviewCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy.PictureCallback;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.capture.cameraextend.FocusOperator;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraCompatible;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraCompatibleConfig.KEY;
import com.tencent.qqcamerakit.common.Observer;
import com.tencent.qqcamerakit.common.QLog;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class CameraCaptureView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, CameraProxy.CameraAutoFocusCallBack, CameraProxy.PictureCallback, Observer
{
  private boolean A;
  private Matrix B = new Matrix();
  private long C = -1L;
  private long D = 0L;
  private CameraCaptureView.FrameListener E;
  private CameraPreviewCallBack F;
  private GLSurfaceView.EGLContextFactory G = new CameraCaptureView.1(this);
  public int a = 2;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  public EGLConfig h = null;
  public EGLContext i = null;
  private CameraProxy k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private int p;
  private int q;
  private final float[] r = new float[16];
  private int s;
  private int t;
  private SurfaceTexture u;
  private EglHandlerThread v;
  private TextureRender w;
  private RenderBuffer x;
  private boolean y = false;
  private FocusOperator z;
  
  public CameraCaptureView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public CameraCaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
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
    if (QLog.a())
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
      QLog.d("CameraCaptureView", 2, new Object[] { localStringBuilder.toString() });
    }
    return new int[] { i1, i2 };
  }
  
  private void b()
  {
    setEGLContextFactory(this.G);
    setEGLContextClientVersion(2);
    this.k = new CameraProxy(getContext(), null);
    setRenderer(this);
    setRenderMode(0);
    this.z = new FocusOperator();
  }
  
  private int c()
  {
    if ((!j) && (this.x == null)) {
      throw new AssertionError();
    }
    this.x.d();
    synchronized (this.u)
    {
      this.u.getTransformMatrix(this.r);
      float[] arrayOfFloat = GPUBaseFilter.a(this.d, this.e, this.x.b(), this.x.c());
      this.w.a(36197, this.t, this.r, arrayOfFloat);
      this.x.e();
      return this.x.a();
    }
  }
  
  public static int c(int paramInt)
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
  
  private void d()
  {
    if (!this.n)
    {
      if (!this.l) {
        return;
      }
      this.k.a(this);
      this.k.a(this.a);
      this.n = true;
    }
  }
  
  private void e()
  {
    if (!this.n) {
      return;
    }
    this.k.a(false);
    this.o = false;
    this.k.b(false);
    this.n = false;
    this.k.b(this);
  }
  
  private void f()
  {
    if ((this.m) && (this.n) && ((!this.o) || (this.p != this.b) || (this.q != this.c)))
    {
      if (QLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startCameraPreview, surfaceWidth:");
        localStringBuilder.append(this.b);
        localStringBuilder.append(", surfaceHeight:");
        localStringBuilder.append(this.c);
        QLog.d("CameraCaptureView", 2, new Object[] { localStringBuilder.toString() });
      }
      this.k.a(new CameraSize(1920, 1080), 30);
      this.k.a(this.u, this.F);
      this.o = true;
      this.p = this.b;
      this.q = this.c;
    }
  }
  
  private void g()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.C;
    if (l2 == -1L)
    {
      this.C = l1;
      return;
    }
    if (l1 - l2 >= 500L)
    {
      int i1 = (int)((float)this.D / ((float)(l1 - l2) / 1000.0F));
      CameraCaptureView.FrameListener localFrameListener = this.E;
      if (localFrameListener != null) {
        localFrameListener.a(i1);
      }
      this.C = l1;
      this.D = 0L;
    }
    this.D += 1L;
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public void a()
  {
    if (QLog.a()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "onSurfaceDestroy" });
    }
    this.m = false;
    SurfaceTexture localSurfaceTexture = this.u;
    if (localSurfaceTexture != null) {
      localSurfaceTexture.setOnFrameAvailableListener(null);
    }
    e();
  }
  
  protected void a(CameraSize paramCameraSize)
  {
    this.d = paramCameraSize.b;
    this.e = paramCameraSize.a;
    paramCameraSize = a(this.d, this.e, this.b, this.c, 1.0F);
    this.f = paramCameraSize[0];
    this.g = paramCameraSize[1];
    this.B = this.z.a(this.f, this.g, this.b, this.c, this.a);
    queueEvent(new CameraCaptureView.3(this));
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("/storage/emulated/0")) {
      str = paramString.replace("/storage/emulated/0", "SD卡");
    }
    paramString = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("已保存照片到");
    localStringBuilder.append(str);
    Toast.makeText(paramString, localStringBuilder.toString(), 1).show();
  }
  
  protected int b(int paramInt)
  {
    return paramInt;
  }
  
  public void notify(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs)
  {
    if (QLog.a()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "notify, eventId:", Integer.valueOf(paramInt1), "  errorCode:", Integer.valueOf(paramInt2), "  errorMsg:", paramString, "  args:", Arrays.toString(paramVarArgs) });
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return;
      }
      if (paramInt2 == 0)
      {
        a((CameraSize)paramVarArgs[0]);
        return;
      }
      Toast.makeText(getContext(), "相机打开失败", 1).show();
      return;
    }
    if (paramInt2 != 0) {
      Toast.makeText(getContext(), "相机打开失败", 1).show();
    }
  }
  
  public void onAutoFocusCallback(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.d != 0) && (this.e != 0) && (this.x != null))
    {
      if (!this.n)
      {
        if (QLog.a()) {
          QLog.d("CameraCaptureView", 2, new Object[] { "onDrawFrame ignore" });
        }
        return;
      }
      this.s = c();
      int i1 = b(a(this.s));
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.b, this.c);
      this.w.a(3553, i1, null, null);
      g();
      return;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if (QLog.a()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "onDrawFrame clean" });
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = new CameraCaptureView.2(this, paramSurfaceTexture);
    if ((this.v.a()) && (!this.y))
    {
      this.v.b().post(paramSurfaceTexture);
      return;
    }
    queueEvent(paramSurfaceTexture);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.a())
    {
      paramGL10 = new StringBuilder();
      paramGL10.append("onSurfaceChanged(): width ");
      paramGL10.append(paramInt1);
      paramGL10.append(";height");
      paramGL10.append(paramInt2);
      QLog.d("CameraCaptureView", 2, new Object[] { paramGL10.toString() });
    }
    this.m = true;
    this.b = paramInt1;
    this.c = paramInt2;
    d();
    f();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.a()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "onSurfaceCreated" });
    }
    this.m = false;
    paramGL10 = this.v;
    this.v = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.v.start();
    if (paramGL10 != null) {
      paramGL10.quitSafely();
    }
    this.w = new TextureRender();
    this.t = GlUtil.a(36197);
    this.u = new SurfaceTexture(this.t);
    this.u.setOnFrameAvailableListener(this);
    this.y = CameraCompatible.d(CameraCompatibleConfig.KEY.e);
  }
  
  public void setFrameListener(CameraCaptureView.FrameListener paramFrameListener)
  {
    this.E = paramFrameListener;
  }
  
  public void setFrontFlashEnable(Activity paramActivity, boolean paramBoolean)
  {
    this.k.a(paramActivity, paramBoolean);
  }
  
  public void setPreviewCallBack(CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    this.F = paramCameraPreviewCallBack;
  }
  
  public void setZoom(int paramInt)
  {
    this.k.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */