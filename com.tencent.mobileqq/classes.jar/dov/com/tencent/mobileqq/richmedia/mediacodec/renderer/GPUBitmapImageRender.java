package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglCore;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglSurfaceBase;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.tencent.mobileqq.shortvideo.filter.QQEncodeFilterRender;
import java.nio.IntBuffer;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GPUBitmapImageRender
  implements GLSurfaceView.Renderer
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private EglCore jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore;
  private EglSurfaceBase jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase;
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private QQEncodeFilterRender jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender;
  private int b;
  private int c = QQFilterRenderManagerHolder.jdField_a_of_type_Int;
  private int d;
  private int e;
  
  private void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase = new EglSurfaceBase(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.b();
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  /* Error */
  public Bitmap a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 55	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/FilterFactory:a	(I)Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;
    //   4: astore_2
    //   5: getstatic 56	dov/com/qq/im/QQFilterRenderManagerHolder:c	I
    //   8: invokestatic 59	dov/com/qq/im/QQFilterRenderManagerHolder:a	(I)Lcom/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnull +106 -> 119
    //   16: aload_0
    //   17: new 61	dov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender
    //   20: dup
    //   21: aload_3
    //   22: invokevirtual 66	com/tencent/mobileqq/shortvideo/filter/QQFilterRenderManager:a	()Ljava/util/List;
    //   25: aconst_null
    //   26: aload_0
    //   27: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:d	I
    //   30: aload_0
    //   31: getfield 47	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:e	I
    //   34: invokespecial 69	dov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender:<init>	(Ljava/util/List;Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;II)V
    //   37: putfield 71	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender	Ldov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender;
    //   40: aload_0
    //   41: getfield 71	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender	Ldov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender;
    //   44: iconst_1
    //   45: invokevirtual 74	dov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender:a	(Z)V
    //   48: aload_0
    //   49: getfield 71	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender	Ldov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender;
    //   52: ifnull +123 -> 175
    //   55: aload_2
    //   56: ifnull +119 -> 175
    //   59: aload_1
    //   60: fconst_1
    //   61: ldc 75
    //   63: invokestatic 80	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;FF)Landroid/graphics/Bitmap;
    //   66: astore_1
    //   67: aload_2
    //   68: invokevirtual 84	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:a	()V
    //   71: aload_0
    //   72: getfield 71	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender	Ldov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender;
    //   75: aload_0
    //   76: getfield 45	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:d	I
    //   79: aload_0
    //   80: getfield 47	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:e	I
    //   83: invokevirtual 85	dov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender:a	(II)V
    //   86: aload_0
    //   87: aload_1
    //   88: aload_2
    //   89: invokevirtual 88	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:a	(Landroid/graphics/Bitmap;Lcom/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter;)Landroid/graphics/Bitmap;
    //   92: astore_1
    //   93: aload_2
    //   94: invokevirtual 90	com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBaseFilter:c	()V
    //   97: aload_0
    //   98: getfield 71	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender	Ldov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender;
    //   101: invokevirtual 91	dov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender:a	()V
    //   104: aload_1
    //   105: fconst_1
    //   106: ldc 75
    //   108: invokestatic 80	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;FF)Landroid/graphics/Bitmap;
    //   111: astore_2
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 71	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender	Ldov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender;
    //   117: aload_2
    //   118: areturn
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 71	dov/com/tencent/mobileqq/richmedia/mediacodec/renderer/GPUBitmapImageRender:jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender	Ldov/com/tencent/mobileqq/shortvideo/filter/QQEncodeFilterRender;
    //   124: goto -76 -> 48
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: astore_2
    //   132: invokestatic 97	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq -23 -> 112
    //   138: ldc 99
    //   140: iconst_2
    //   141: new 101	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   148: ldc 104
    //   150: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_3
    //   154: invokevirtual 112	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   157: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_1
    //   167: astore_2
    //   168: goto -56 -> 112
    //   171: astore_3
    //   172: goto -42 -> 130
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -65 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	GPUBitmapImageRender
    //   0	180	1	paramBitmap	Bitmap
    //   4	173	2	localObject	Object
    //   11	11	3	localQQFilterRenderManager	QQFilterRenderManager
    //   127	27	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   171	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   59	93	127	java/lang/OutOfMemoryError
    //   93	112	171	java/lang/OutOfMemoryError
  }
  
  public Bitmap a(Bitmap paramBitmap, GPUBaseFilter paramGPUBaseFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = paramGPUBaseFilter;
    onSurfaceCreated(null, null);
    onSurfaceChanged(null, paramBitmap.getWidth(), paramBitmap.getHeight());
    onDrawFrame(null);
    onDrawFrame(null);
    paramGPUBaseFilter = IntBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight());
    GLES20.glReadPixels(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), 6408, 5121, paramGPUBaseFilter);
    paramGPUBaseFilter = paramGPUBaseFilter.array();
    paramBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(paramGPUBaseFilter));
    return paramBitmap;
  }
  
  public Bitmap a(Bitmap paramBitmap, List paramList, boolean paramBoolean)
  {
    GPUBaseFilter localGPUBaseFilter = FilterFactory.a(0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = QQFilterRenderManagerHolder.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (localGPUBaseFilter != null) && (paramList != null))
    {
      paramBitmap = UIUtils.a(paramBitmap, 1.0F, -1.0F);
      localGPUBaseFilter.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(this.d, this.e, this.d, this.e);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b("key_orientation_degree", String.valueOf(90));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(paramList);
      return UIUtils.a(a(paramBitmap, localGPUBaseFilter), 1.0F, -1.0F);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglSurfaceBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.o();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
      this.c = QQFilterRenderManagerHolder.jdField_a_of_type_Int;
    }
  }
  
  @TargetApi(17)
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = new EglCore(EGL14.eglGetCurrentContext(), 1);
    }
    c(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglCore = new EglCore(EGL14.EGL_NO_CONTEXT, 1);
    }
    c(paramInt1, paramInt2);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16640);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() % 2 == 1)
    {
      paramGL10 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + 1, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localObject = new Canvas(paramGL10);
      ((Canvas)localObject).drawARGB(0, 0, 0, 0);
      ((Canvas)localObject).drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
      this.jdField_a_of_type_Int = 1;
      if (paramGL10 != null) {
        break label252;
      }
    }
    label252:
    for (Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;; localObject = paramGL10)
    {
      this.b = GlUtil.a(3553, (Bitmap)localObject);
      if ((paramGL10 != null) && (!paramGL10.isRecycled())) {
        paramGL10.recycle();
      }
      paramGL10 = new float[16];
      Matrix.setIdentityM(paramGL10, 0);
      if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender != null) {
        this.b = this.jdField_a_of_type_DovComTencentMobileqqShortvideoFilterQQEncodeFilterRender.a(this.d, this.e, this.b, 0L);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b("key_draw_screen", String.valueOf(false));
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b("key_width", String.valueOf(this.d));
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b("key_height", String.valueOf(this.e));
        int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(this.b);
        if (i != -1) {
          this.b = i;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.b, null, paramGL10);
      return;
      this.jdField_a_of_type_Int = 0;
      paramGL10 = null;
      break;
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glUseProgram(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(this.d, this.e, this.d, this.e);
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender
 * JD-Core Version:    0.7.0.1
 */