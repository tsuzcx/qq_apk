package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import bmuw;
import bmuy;
import bmuz;
import bmva;
import bmvb;
import bmvc;
import bmvd;
import bmvf;
import bmvg;
import bmvi;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

@TargetApi(14)
public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static int jdField_a_of_type_Int;
  private static final bmvf jdField_a_of_type_Bmvf = new bmvf(null);
  private GLSurfaceView.Renderer jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer;
  private bmvb jdField_a_of_type_Bmvb;
  private bmvc jdField_a_of_type_Bmvc;
  private bmvd jdField_a_of_type_Bmvd;
  private bmvg jdField_a_of_type_Bmvg;
  private GLTextureView.GLThread jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GLTextureView.2(this);
  private final WeakReference<GLTextureView> jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  int d = 0;
  private int e;
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  @TargetApi(14)
  private float a()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return getAlpha();
    }
    return 1.0F;
  }
  
  @SuppressLint({"UseValueOf"})
  public static Integer a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (Integer)paramContext.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramContext, new Object[] { new String(paramString), new Integer(paramInt) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return Integer.valueOf(paramInt);
  }
  
  private void a()
  {
    jdField_a_of_type_Int = a(getContext(), "ro.opengles.version", 0).intValue();
    setSurfaceTextureListener(this);
    addOnLayoutChangeListener(new bmuw(this));
  }
  
  @TargetApi(14)
  private void a(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      setAlpha(paramFloat);
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, "TextureView setAlpha,alpha:" + paramFloat);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.b();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_c_of_type_Int != paramInt2) || (this.d != paramInt3))
    {
      this.jdField_c_of_type_Int = paramInt2;
      this.d = paramInt3;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.a(paramInt2, paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("GLTextureView", 2, " surfaceChanged, onWindowResize");
      }
    }
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_Boolean) && (a() != 1.0F)) {
      a(1.0F);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " surfaceChanged, w:" + paramInt2 + ",h:" + paramInt3 + " use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.c();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.a(paramRunnable);
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.a();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.d();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer != null)) {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread == null) {
        break label74;
      }
    }
    label74:
    for (int i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.a();; i = 1)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread = new GLTextureView.GLThread(this.jdField_a_of_type_JavaLangRefWeakReference);
      if (i != 1) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.a(i);
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.start();
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.d();
    }
    this.jdField_b_of_type_Boolean = true;
    super.onDetachedFromWindow();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
    Log.d("GLTextureView", "onSurfaceTextureAvailable");
    long l = System.currentTimeMillis();
    a(paramSurfaceTexture);
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 250L);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureAvailable surfaceCreated use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_Boolean = false;
    Log.d("GLTextureView", "onSurfaceTextureDestroyed");
    b(paramSurfaceTexture);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureDestroyed");
    }
    a(0.0F);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    Log.d("GLTextureView", "onSurfaceTextureSizeChanged");
    a(paramSurfaceTexture, 0, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureSizeChanged surfaceChanged use:" + (System.currentTimeMillis() - l));
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setDebugFlags(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setEGLConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new bmuy(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void setEGLConfigChooser(bmvb parambmvb)
  {
    b();
    this.jdField_a_of_type_Bmvb = parambmvb;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new bmvi(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    b();
    this.e = paramInt;
  }
  
  public void setEGLContextFactory(bmvc parambmvc)
  {
    b();
    this.jdField_a_of_type_Bmvc = parambmvc;
  }
  
  public void setEGLWindowSurfaceFactory(bmvd parambmvd)
  {
    b();
    this.jdField_a_of_type_Bmvd = parambmvd;
  }
  
  public void setGLWrapper(bmvg parambmvg)
  {
    this.jdField_a_of_type_Bmvg = parambmvg;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    b();
    if (this.jdField_a_of_type_Bmvb == null) {
      this.jdField_a_of_type_Bmvb = new bmvi(this, true);
    }
    if (this.jdField_a_of_type_Bmvc == null) {
      this.jdField_a_of_type_Bmvc = new bmuz(this, null);
    }
    if (this.jdField_a_of_type_Bmvd == null) {
      this.jdField_a_of_type_Bmvd = new bmva(null);
    }
    this.jdField_a_of_type_AndroidOpenglGLSurfaceView$Renderer = paramRenderer;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread = new GLTextureView.GLThread(this.jdField_a_of_type_JavaLangRefWeakReference);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView$GLThread.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView
 * JD-Core Version:    0.7.0.1
 */