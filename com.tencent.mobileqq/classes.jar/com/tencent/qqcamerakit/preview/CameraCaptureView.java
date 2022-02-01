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
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new CameraCaptureView.1(this);
  private CameraPreviewCallBack jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack;
  private CameraProxy jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy;
  private FocusOperator jdField_a_of_type_ComTencentQqcamerakitCaptureCameraextendFocusOperator;
  private CameraCaptureView.FrameListener jdField_a_of_type_ComTencentQqcamerakitPreviewCameraCaptureView$FrameListener;
  private EglHandlerThread jdField_a_of_type_ComTencentQqcamerakitPreviewEglHandlerThread;
  private RenderBuffer jdField_a_of_type_ComTencentQqcamerakitPreviewRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentQqcamerakitPreviewTextureRender;
  public EGLConfig a;
  public EGLContext a;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  protected int b;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  protected int c;
  private boolean c;
  protected int d;
  private boolean d;
  protected int e;
  private boolean e;
  protected int f;
  private boolean f;
  protected int g;
  private boolean g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public CameraCaptureView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    this.jdField_f_of_type_Boolean = false;
    b();
  }
  
  public CameraCaptureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig = null;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
    this.jdField_f_of_type_Boolean = false;
    b();
  }
  
  private int a()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentQqcamerakitPreviewRenderBuffer == null)) {
      throw new AssertionError();
    }
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewRenderBuffer.a();
    synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      float[] arrayOfFloat = GPUBaseFilter.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentQqcamerakitPreviewRenderBuffer.b(), this.jdField_a_of_type_ComTencentQqcamerakitPreviewRenderBuffer.c());
      this.jdField_a_of_type_ComTencentQqcamerakitPreviewTextureRender.a(36197, this.k, this.jdField_a_of_type_ArrayOfFloat, arrayOfFloat);
      this.jdField_a_of_type_ComTencentQqcamerakitPreviewRenderBuffer.b();
      return this.jdField_a_of_type_ComTencentQqcamerakitPreviewRenderBuffer.a();
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    float f1 = paramInt1;
    int m = c((int)(f1 * paramFloat));
    float f2 = paramInt2;
    int n = c((int)(f2 * paramFloat));
    f1 = f2 * 1.0F / f1;
    f2 = paramInt4 * 1.0F / paramInt3;
    if (f1 > f2) {
      n = c((int)(m * f2));
    } else {
      m = c((int)(n / f2));
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
      localStringBuilder.append(m);
      localStringBuilder.append(",");
      localStringBuilder.append(n);
      localStringBuilder.append(")");
      QLog.d("CameraCaptureView", 2, new Object[] { localStringBuilder.toString() });
    }
    return new int[] { m, n };
  }
  
  private void b()
  {
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy = new CameraProxy(getContext(), null);
    setRenderer(this);
    setRenderMode(0);
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraextendFocusOperator = new FocusOperator();
  }
  
  public static int c(int paramInt)
  {
    int n = paramInt % 16;
    int m = paramInt;
    if (n != 0)
    {
      if (n < 8) {
        return paramInt - n;
      }
      m = paramInt + (16 - n);
    }
    return m;
  }
  
  private void c()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.a(this);
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.a(this.jdField_a_of_type_Int);
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  private void d()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.a(false);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.b(false);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.b(this);
  }
  
  private void e()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && ((!this.jdField_e_of_type_Boolean) || (this.h != this.jdField_b_of_type_Int) || (this.i != this.jdField_c_of_type_Int)))
    {
      if (QLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startCameraPreview, surfaceWidth:");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(", surfaceHeight:");
        localStringBuilder.append(this.jdField_c_of_type_Int);
        QLog.d("CameraCaptureView", 2, new Object[] { localStringBuilder.toString() });
      }
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.a(new CameraSize(1920, 1080), 30);
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack);
      this.jdField_e_of_type_Boolean = true;
      this.h = this.jdField_b_of_type_Int;
      this.i = this.jdField_c_of_type_Int;
    }
  }
  
  private void f()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (l2 == -1L)
    {
      this.jdField_a_of_type_Long = l1;
      return;
    }
    if (l1 - l2 >= 500L)
    {
      int m = (int)((float)this.jdField_b_of_type_Long / ((float)(l1 - l2) / 1000.0F));
      CameraCaptureView.FrameListener localFrameListener = this.jdField_a_of_type_ComTencentQqcamerakitPreviewCameraCaptureView$FrameListener;
      if (localFrameListener != null) {
        localFrameListener.a(m);
      }
      this.jdField_a_of_type_Long = l1;
      this.jdField_b_of_type_Long = 0L;
    }
    this.jdField_b_of_type_Long += 1L;
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
    this.jdField_c_of_type_Boolean = false;
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localSurfaceTexture != null) {
      localSurfaceTexture.setOnFrameAvailableListener(null);
    }
    d();
  }
  
  protected void a(CameraSize paramCameraSize)
  {
    this.jdField_d_of_type_Int = paramCameraSize.jdField_b_of_type_Int;
    this.jdField_e_of_type_Int = paramCameraSize.jdField_a_of_type_Int;
    paramCameraSize = a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, 1.0F);
    this.jdField_f_of_type_Int = paramCameraSize[0];
    this.jdField_g_of_type_Int = paramCameraSize[1];
    this.jdField_a_of_type_AndroidGraphicsMatrix = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraextendFocusOperator.a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int);
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
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.jdField_d_of_type_Int != 0) && (this.jdField_e_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentQqcamerakitPreviewRenderBuffer != null))
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        if (QLog.a()) {
          QLog.d("CameraCaptureView", 2, new Object[] { "onDrawFrame ignore" });
        }
        return;
      }
      this.j = a();
      int m = b(a(this.j));
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentQqcamerakitPreviewTextureRender.a(3553, m, null, null);
      f();
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
    if ((this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglHandlerThread.a()) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglHandlerThread.a().post(paramSurfaceTexture);
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
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    c();
    e();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.a()) {
      QLog.d("CameraCaptureView", 2, new Object[] { "onSurfaceCreated" });
    }
    this.jdField_c_of_type_Boolean = false;
    paramGL10 = this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglHandlerThread;
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglHandlerThread = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewEglHandlerThread.start();
    if (paramGL10 != null) {
      paramGL10.quitSafely();
    }
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewTextureRender = new TextureRender();
    this.k = GlUtil.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.k);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_f_of_type_Boolean = CameraCompatible.d(CameraCompatibleConfig.KEY.e);
  }
  
  public void setFrameListener(CameraCaptureView.FrameListener paramFrameListener)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitPreviewCameraCaptureView$FrameListener = paramFrameListener;
  }
  
  public void setFrontFlashEnable(Activity paramActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.a(paramActivity, paramBoolean);
  }
  
  public void setPreviewCallBack(CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack = paramCameraPreviewCallBack;
  }
  
  public void setZoom(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraProxy.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.CameraCaptureView
 * JD-Core Version:    0.7.0.1
 */