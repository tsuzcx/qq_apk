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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/CodecOutputSurface;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "width", "", "height", "(II)V", "mEGLContext", "Landroid/opengl/EGLContext;", "kotlin.jvm.PlatformType", "mEGLDisplay", "Landroid/opengl/EGLDisplay;", "mEGLSurface", "Landroid/opengl/EGLSurface;", "mFrameAvailable", "", "mFrameSyncObject", "Ljava/lang/Object;", "mFrameWrapper", "Ldov/com/qq/im/aeeditor/module/autotemplate/FrameWrapper;", "mHeight", "mPixelBuf", "Ljava/nio/ByteBuffer;", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mTextureRender", "Ldov/com/qq/im/aeeditor/module/autotemplate/STextureRender;", "mWidth", "<set-?>", "Landroid/view/Surface;", "surface", "getSurface", "()Landroid/view/Surface;", "awaitNewImage", "", "drawImage", "invert", "eglSetup", "flipBitmapY", "Landroid/graphics/Bitmap;", "bitmap", "makeCurrent", "onFrameAvailable", "st", "release", "saveBitmap", "flipY", "setup", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
@RequiresApi(17)
public final class CodecOutputSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  public static final CodecOutputSurface.Companion a;
  private static final boolean jdField_b_of_type_Boolean = BuildConfig.jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  @RequiresApi(17)
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
  @RequiresApi(17)
  private EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
  @RequiresApi(17)
  private EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
  @Nullable
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final FrameWrapper jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateFrameWrapper = new FrameWrapper();
  private STextureRender jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateSTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateCodecOutputSurface$Companion = new CodecOutputSurface.Companion(null);
  }
  
  public CodecOutputSurface(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    e();
    b();
    d();
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
  
  private final void d()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateSTextureRender = new STextureRender();
    Object localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateSTextureRender;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((STextureRender)localObject).a();
    if (jdField_b_of_type_Boolean)
    {
      localObject = new StringBuilder().append("textureID=");
      STextureRender localSTextureRender = this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateSTextureRender;
      if (localSTextureRender == null) {
        Intrinsics.throwNpe();
      }
      Log.d("STextureRender", localSTextureRender.a());
    }
    localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateSTextureRender;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(((STextureRender)localObject).a());
    localObject = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((SurfaceTexture)localObject).setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_Int * this.jdField_b_of_type_Int * 4);
    localObject = this.jdField_a_of_type_JavaNioByteBuffer;
    if (localObject != null) {
      ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
    }
  }
  
  @RequiresApi(17)
  private final void e()
  {
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw ((Throwable)new RuntimeException("unable to get EGL14 display"));
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.jdField_a_of_type_AndroidOpenglEGLDisplay = ((EGLDisplay)null);
      throw ((Throwable)new RuntimeException("unable to initialize EGL14"));
    }
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_AndroidOpenglEGLDisplay;
    int i = localObject.length;
    if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject, 0, i, arrayOfInt, 0)) {
      throw ((Throwable)new RuntimeException("unable to find RGB888+recordable ES2 EGL config"));
    }
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    if (this.jdField_a_of_type_AndroidOpenglEGLContext == null) {
      throw ((Throwable)new RuntimeException("null context"));
    }
    i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.eglCreatePbufferSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, localObject[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
    if (this.jdField_a_of_type_AndroidOpenglEGLSurface == null) {
      throw ((Throwable)new RuntimeException("surface was null"));
    }
  }
  
  @NotNull
  public final Bitmap a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaNioByteBuffer;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((ByteBuffer)localObject).rewind();
    GLES20.glReadPixels(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 6408, 5121, (Buffer)this.jdField_a_of_type_JavaNioByteBuffer);
    localObject = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
    ByteBuffer localByteBuffer = this.jdField_a_of_type_JavaNioByteBuffer;
    if (localByteBuffer == null) {
      Intrinsics.throwNpe();
    }
    localByteBuffer.rewind();
    ((Bitmap)localObject).copyPixelsFromBuffer((Buffer)this.jdField_a_of_type_JavaNioByteBuffer);
    if (paramBoolean)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "bmp");
      localObject = a((Bitmap)localObject);
    }
    for (;;)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "bmp");
      return localObject;
    }
  }
  
  @Nullable
  public final Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  @RequiresApi(17)
  public final void a()
  {
    if (this.jdField_a_of_type_AndroidOpenglEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglDestroySurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface);
      EGL14.eglDestroyContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.jdField_a_of_type_AndroidOpenglEGLDisplay);
    }
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.EGL_NO_CONTEXT;
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.EGL_NO_SURFACE;
    Surface localSurface = this.jdField_a_of_type_AndroidViewSurface;
    if (localSurface == null) {
      Intrinsics.throwNpe();
    }
    localSurface.release();
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateSTextureRender = ((STextureRender)null);
    this.jdField_a_of_type_AndroidViewSurface = ((Surface)null);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = ((SurfaceTexture)null);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateFrameWrapper.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    STextureRender localSTextureRender = this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateSTextureRender;
    if (localSTextureRender == null) {
      Intrinsics.throwNpe();
    }
    SurfaceTexture localSurfaceTexture = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localSurfaceTexture == null) {
      Intrinsics.throwNpe();
    }
    localSTextureRender.a(localSurfaceTexture, paramBoolean);
  }
  
  @RequiresApi(17)
  public final void b()
  {
    if (!EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLContext)) {
      throw ((Throwable)new RuntimeException("eglMakeCurrent failed"));
    }
  }
  
  public final void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait(2500);
            if (!this.jdField_a_of_type_Boolean) {
              throw ((Throwable)new RuntimeException("frame wait timed out"));
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw ((Throwable)new RuntimeException((Throwable)localInterruptedException));
          }
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    Unit localUnit = Unit.INSTANCE;
    ??? = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (??? == null) {
      Intrinsics.throwNpe();
    }
    ((SurfaceTexture)???).updateTexImage();
  }
  
  public void onFrameAvailable(@NotNull SurfaceTexture arg1)
  {
    Intrinsics.checkParameterIsNotNull(???, "st");
    if (jdField_b_of_type_Boolean) {
      Log.d("STextureRender", "new frame available");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean) {
        throw ((Throwable)new RuntimeException("mFrameAvailable already set, frame could be dropped"));
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangObject.notifyAll();
    Unit localUnit = Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.CodecOutputSurface
 * JD-Core Version:    0.7.0.1
 */