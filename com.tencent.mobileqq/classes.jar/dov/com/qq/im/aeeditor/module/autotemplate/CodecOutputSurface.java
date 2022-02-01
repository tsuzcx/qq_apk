package dov.com.qq.im.aeeditor.module.autotemplate;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.litelivesdk.afwraper.config.BuildConfig;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "width", "", "height", "(II)V", "mEGLContext", "Landroid/opengl/EGLContext;", "kotlin.jvm.PlatformType", "mEGLDisplay", "Landroid/opengl/EGLDisplay;", "mEGLSurface", "Landroid/opengl/EGLSurface;", "mFrameAvailable", "", "mFrameSyncObject", "Ljava/lang/Object;", "mFrameWrapper", "Ldov/com/qq/im/aeeditor/module/autotemplate/FrameWrapper;", "mHeight", "mPixelBuf", "Ljava/nio/ByteBuffer;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mTextureRender", "Ldov/com/qq/im/aeeditor/module/autotemplate/STextureRender;", "mWidth", "<set-?>", "Landroid/view/Surface;", "surface", "getSurface", "()Landroid/view/Surface;", "awaitNewImage", "", "drawImage", "invert", "eglSetup", "flipBitmapY", "Landroid/graphics/Bitmap;", "bitmap", "makeCurrent", "onFrameAvailable", "st", "release", "saveBitmap", "flipY", "setup", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
@RequiresApi(17)
public final class CodecOutputSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  public static final CodecOutputSurface.Companion a = new CodecOutputSurface.Companion(null);
  private static final boolean n = BuildConfig.a;
  private STextureRender b;
  private SurfaceTexture c;
  @Nullable
  private Surface d;
  @RequiresApi(17)
  private EGLDisplay e = EGL14.EGL_NO_DISPLAY;
  @RequiresApi(17)
  private EGLContext f = EGL14.EGL_NO_CONTEXT;
  @RequiresApi(17)
  private EGLSurface g = EGL14.EGL_NO_SURFACE;
  private int h;
  private int i;
  private final Object j = new Object();
  private boolean k;
  private ByteBuffer l;
  private final FrameWrapper m = new FrameWrapper();
  
  public CodecOutputSurface(int paramInt1, int paramInt2)
  {
    int i1;
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      this.h = paramInt1;
      this.i = paramInt2;
      f();
      c();
      e();
      return;
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  private final Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, -1.0F);
    if (paramBitmap.isRecycled()) {
      return paramBitmap;
    }
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    paramBitmap.recycle();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ret");
    return localObject;
  }
  
  private final void e()
  {
    this.b = new STextureRender();
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((STextureRender)localObject).b();
    if (n)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("textureID=");
      STextureRender localSTextureRender = this.b;
      if (localSTextureRender == null) {
        Intrinsics.throwNpe();
      }
      ((StringBuilder)localObject).append(localSTextureRender.a());
      Log.d("STextureRender", ((StringBuilder)localObject).toString());
    }
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.c = new SurfaceTexture(((STextureRender)localObject).a());
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((SurfaceTexture)localObject).setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
    this.d = new Surface(this.c);
    this.l = ByteBuffer.allocateDirect(this.h * this.i * 4);
    localObject = this.l;
    if (localObject != null) {
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
    }
  }
  
  @RequiresApi(17)
  private final void f()
  {
    this.e = EGL14.eglGetDisplay(0);
    if (this.e != EGL14.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (EGL14.eglInitialize(this.e, (int[])localObject, 0, (int[])localObject, 1))
      {
        localObject = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        EGLDisplay localEGLDisplay = this.e;
        int i1 = localObject.length;
        if (EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject, 0, i1, arrayOfInt, 0))
        {
          this.f = EGL14.eglCreateContext(this.e, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
          if (this.f != null)
          {
            i1 = this.h;
            int i2 = this.i;
            this.g = EGL14.eglCreatePbufferSurface(this.e, localObject[0], new int[] { 12375, i1, 12374, i2, 12344 }, 0);
            if (this.g != null) {
              return;
            }
            throw ((Throwable)new RuntimeException("surface was null"));
          }
          throw ((Throwable)new RuntimeException("null context"));
        }
        throw ((Throwable)new RuntimeException("unable to find RGB888+recordable ES2 EGL config"));
      }
      this.e = ((EGLDisplay)null);
      throw ((Throwable)new RuntimeException("unable to initialize EGL14"));
    }
    throw ((Throwable)new RuntimeException("unable to get EGL14 display"));
  }
  
  @Nullable
  public final Surface a()
  {
    return this.d;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.m.a(this.h, this.i);
    STextureRender localSTextureRender = this.b;
    if (localSTextureRender == null) {
      Intrinsics.throwNpe();
    }
    SurfaceTexture localSurfaceTexture = this.c;
    if (localSurfaceTexture == null) {
      Intrinsics.throwNpe();
    }
    localSTextureRender.a(localSurfaceTexture, paramBoolean);
  }
  
  @NotNull
  public final Bitmap b(boolean paramBoolean)
  {
    Object localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((ByteBuffer)localObject).rewind();
    GLES20.glReadPixels(0, 0, this.h, this.i, 6408, 5121, (Buffer)this.l);
    Bitmap localBitmap = Bitmap.createBitmap(this.h, this.i, Bitmap.Config.ARGB_8888);
    localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((ByteBuffer)localObject).rewind();
    localBitmap.copyPixelsFromBuffer((Buffer)this.l);
    localObject = localBitmap;
    if (paramBoolean)
    {
      Intrinsics.checkExpressionValueIsNotNull(localBitmap, "bmp");
      localObject = a(localBitmap);
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bmp");
    return localObject;
  }
  
  @RequiresApi(17)
  public final void b()
  {
    if (this.e != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglDestroySurface(this.e, this.g);
      EGL14.eglDestroyContext(this.e, this.f);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.e);
    }
    this.e = EGL14.EGL_NO_DISPLAY;
    this.f = EGL14.EGL_NO_CONTEXT;
    this.g = EGL14.EGL_NO_SURFACE;
    Surface localSurface = this.d;
    if (localSurface == null) {
      Intrinsics.throwNpe();
    }
    localSurface.release();
    this.b = ((STextureRender)null);
    this.d = ((Surface)null);
    this.c = ((SurfaceTexture)null);
  }
  
  @RequiresApi(17)
  public final void c()
  {
    EGLDisplay localEGLDisplay = this.e;
    EGLSurface localEGLSurface = this.g;
    if (EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.f)) {
      return;
    }
    throw ((Throwable)new RuntimeException("eglMakeCurrent failed"));
  }
  
  public final void d()
  {
    synchronized (this.j)
    {
      for (;;)
      {
        boolean bool = this.k;
        if (!bool) {
          try
          {
            this.j.wait(2500);
            if (!this.k) {
              throw ((Throwable)new RuntimeException("frame wait timed out"));
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw ((Throwable)new RuntimeException((Throwable)localInterruptedException));
          }
        }
      }
      this.k = false;
      Unit localUnit = Unit.INSTANCE;
      ??? = this.c;
      if (??? == null) {
        Intrinsics.throwNpe();
      }
      ((SurfaceTexture)???).updateTexImage();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void onFrameAvailable(@NotNull SurfaceTexture arg1)
  {
    Intrinsics.checkParameterIsNotNull(???, "st");
    if (n) {
      Log.d("STextureRender", "new frame available");
    }
    synchronized (this.j)
    {
      if (!this.k)
      {
        this.k = true;
        this.j.notifyAll();
        Unit localUnit = Unit.INSTANCE;
        return;
      }
      throw ((Throwable)new RuntimeException("mFrameAvailable already set, frame could be dropped"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.CodecOutputSurface
 * JD-Core Version:    0.7.0.1
 */