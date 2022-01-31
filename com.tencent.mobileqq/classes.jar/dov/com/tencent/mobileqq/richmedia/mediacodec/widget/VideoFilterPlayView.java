package dov.com.tencent.mobileqq.richmedia.mediacodec.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import aony;
import aonz;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.BaseStickerTracker;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTracker2;
import dov.com.tencent.mobileqq.richmedia.mediacodec.tracker.SimpleStickerTrackerOrigin;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class VideoFilterPlayView
  extends HWVideoPlayView
{
  public static int g;
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private GpuImagePartsFilterGroup jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup;
  private BaseStickerTracker jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker;
  private VideoFilterPlayView.TrackerCallback jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private final LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private GPUBaseFilter jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private RenderBuffer jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private boolean jdField_b_of_type_Boolean;
  private GPUBaseFilter jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private boolean jdField_c_of_type_Boolean;
  public int h;
  
  public VideoFilterPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFilterPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    m();
    int i = g + 1;
    g = i;
    this.h = i;
  }
  
  private void a(@NonNull LinkedList paramLinkedList)
  {
    try
    {
      while (!paramLinkedList.isEmpty())
      {
        Runnable localRunnable = (Runnable)paramLinkedList.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    finally {}
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = QQFilterRenderManagerHolder.a();
    QQFilterRenderManagerHolder.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager);
  }
  
  private void n()
  {
    QQToast.a(getContext(), 1, "跟随失败！", 1).a();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback.a(null);
    }
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.o();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (!this.jdField_a_of_type_JavaNioByteBuffer.hasArray()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterPlayView", 2, "startTrackVideo trackByteBuffer is null ");
      }
      n();
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaNioByteBuffer.array();
    if ((localObject == null) && (localObject.length != this.jdField_a_of_type_ArrayOfByte.length))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterPlayView", 2, "trackByteBuffer array is not right length = " + localObject.length);
      }
      n();
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.a((byte[])localObject);
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = a();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.a((String)localObject, this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoFilterPlayView", 2, "initFirstFrame failed = ");
    }
    n();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoFilterPlayView", 2, "initTrackAlg x = " + paramFloat1 + ", y = " + paramFloat2 + ", width = " + paramFloat3 + ", height = " + paramFloat4 + ", rotation =" + paramInt);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.a(paramInt);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker = new SimpleStickerTracker2(this.jdField_c_of_type_Int, this.d);
        return;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker = new SimpleStickerTrackerOrigin(this.jdField_c_of_type_Int, this.d);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker = new SimpleStickerTrackerOrigin(this.jdField_c_of_type_Int, this.d);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
  }
  
  public void a(RenderBuffer paramRenderBuffer, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramRenderBuffer != null) {
      i = paramRenderBuffer.a();
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_JavaNioByteBuffer == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer trackData is null ");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaNioByteBuffer.rewind();
      if (i == 0) {
        break;
      }
      try
      {
        paramRenderBuffer = new int[1];
        GLES20.glGenFramebuffers(1, paramRenderBuffer, 0);
        GLES20.glBindFramebuffer(36160, paramRenderBuffer[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, paramRenderBuffer, 0);
        paramRenderBuffer[0] = 0;
        return;
      }
      catch (Exception paramRenderBuffer)
      {
        this.jdField_a_of_type_JavaNioByteBuffer.clear();
      }
    } while (!QLog.isColorLevel());
    QLog.e("VideoFilterPlayView", 2, "readTextureToBuffer error " + paramRenderBuffer.toString());
    return;
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
  }
  
  protected void a(@NonNull Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramRunnable);
      return;
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a(this.jdField_a_of_type_JavaUtilLinkedList);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    Matrix.rotateM(paramArrayOfFloat2, 0, this.e, 0.0F, 0.0F, 1.0F);
    Matrix.scaleM(paramArrayOfFloat2, 0, 1.0F, -1.0F, 1.0F);
    super.a(paramArrayOfFloat1, paramArrayOfFloat2);
    paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
    int i = paramArrayOfFloat1.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      paramArrayOfFloat1.c();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b("key_draw_screen", String.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b("key_width", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b("key_height", String.valueOf(this.d));
      int j = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(i);
      if (j != -1) {
        i = j;
      }
    }
    for (;;)
    {
      if (paramArrayOfFloat1 == this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer)
      {
        paramArrayOfFloat1 = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
        paramArrayOfFloat1.b();
        this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(i, null, null);
        i = paramArrayOfFloat1.a();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.f();
        if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.b()) {
          break label315;
        }
        paramArrayOfFloat1.c();
        if (paramArrayOfFloat1 != this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer) {
          break label307;
        }
        paramArrayOfFloat1 = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
        label206:
        paramArrayOfFloat1.b();
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a(i, null, null);
        i = paramArrayOfFloat1.a();
      }
      label307:
      label315:
      for (;;)
      {
        paramArrayOfFloat1.c();
        if (this.jdField_c_of_type_Boolean) {
          a(paramArrayOfFloat1, this.jdField_c_of_type_Int, this.d);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        paramArrayOfFloat1 = new float[16];
        Matrix.setIdentityM(paramArrayOfFloat1, 0);
        Matrix.scaleM(paramArrayOfFloat1, 0, 1.0F, -1.0F, 1.0F);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(i, null, paramArrayOfFloat1);
        return;
        paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
        break;
        paramArrayOfFloat1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
        break label206;
      }
    }
  }
  
  public void g()
  {
    QLog.w("VideoFilterPlayView", 4, "onDecodeRepeat. can't just repeat");
    super.g();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.a();
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.o();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.d();
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.jdField_c_of_type_Int, this.d, 33984);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.jdField_c_of_type_Int, this.d, 33984);
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a(this.jdField_c_of_type_Int, this.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(this.jdField_c_of_type_Int, this.d);
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {}
    try
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt1 * paramInt2 * 4];
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.wrap(this.jdField_a_of_type_ArrayOfByte);
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.c(this.jdField_c_of_type_Int, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterPlayView", 2, "onSurfaceChanged");
      }
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.a(this.jdField_c_of_type_Int, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      return;
    }
    catch (OutOfMemoryError paramGL10)
    {
      for (;;)
      {
        QLog.e("VideoFilterPlayView", 1, "init trackByteBuffer failed ", paramGL10);
        if (this.jdField_a_of_type_JavaNioByteBuffer != null)
        {
          this.jdField_a_of_type_JavaNioByteBuffer.clear();
          this.jdField_a_of_type_JavaNioByteBuffer = null;
        }
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    paramGL10 = FilterFactory.a(101);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = paramGL10;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = paramGL10;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup = new GpuImagePartsFilterGroup();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.b(this.jdField_c_of_type_Int, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.w("VideoFilterPlayView", 2, "VideoPlay, surfaceCreated success=");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterPlayView", 2, "onSurfaceCreated");
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.b();
    }
  }
  
  public void setColorFilterType(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup == null) || ((!this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.b()) && (paramInt == 0))) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a(paramInt, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setColorFilterType(int paramInt1, int paramInt2, float paramFloat, int paramInt3)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecRendererGpuImagePartsFilterGroup.a(paramInt1, paramInt2, paramFloat, paramInt3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setMosaicFilterType(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
      this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = null;
      return;
    }
    if (this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = FilterFactory.a(106);
      a(new aony(this));
    }
    ((GPUImagePixelationFilter)this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter).a(paramBitmap);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = this.jdField_c_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  }
  
  public void setTrackerCallback(VideoFilterPlayView.TrackerCallback paramTrackerCallback)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecWidgetVideoFilterPlayView$TrackerCallback = paramTrackerCallback;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
    }
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecTrackerBaseStickerTracker.c();
    }
    super.queueEvent(new aonz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.widget.VideoFilterPlayView
 * JD-Core Version:    0.7.0.1
 */