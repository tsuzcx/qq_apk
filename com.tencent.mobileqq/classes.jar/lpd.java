import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;

public class lpd
  extends lpv
  implements SurfaceTexture.OnFrameAvailableListener
{
  private float jdField_a_of_type_Float = -1.0F;
  private final int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private final lpe jdField_a_of_type_Lpe = new lpe();
  private lpf jdField_a_of_type_Lpf;
  private lqe jdField_a_of_type_Lqe;
  private final lwf jdField_a_of_type_Lwf = new lwf();
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private final int jdField_b_of_type_Int = 2;
  private long jdField_b_of_type_Long;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private final lwf jdField_b_of_type_Lwf = new lwf();
  private boolean jdField_b_of_type_Boolean = true;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private final int jdField_c_of_type_Int = 3;
  private long jdField_c_of_type_Long;
  private int d;
  private int e;
  private int f;
  private int g = 100;
  
  @RequiresApi(api=21)
  private void b()
  {
    this.d = GlUtil.createTexture(36197);
    GLES20.glBindTexture(36197, 0);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.d);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this, a());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setDefaultBufferSize(this.e, this.f);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Lpe.a();
    if (QLog.isColorLevel()) {
      QLog.i("EGLScreenCaptureThread", 2, "initGLEnv");
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
    }
    if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_Lqe != null)
    {
      this.jdField_a_of_type_Lqe.c();
      this.jdField_a_of_type_Lqe = null;
    }
    this.jdField_a_of_type_Lpe.b();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("EGLScreenCaptureThread", 2, "releaseGLEnv");
    }
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_b_of_type_Lwf.a()) || (this.jdField_a_of_type_Lwf.a())) {
      i();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 2000L);
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("EGLScreenCaptureThread", 4, "check, param not valid.");
      }
    }
  }
  
  private void h()
  {
    boolean bool = this.jdField_a_of_type_Lwf.a(this.jdField_b_of_type_Lwf);
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || (bool))
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Lwf.jdField_a_of_type_Int, this.jdField_a_of_type_Lwf.jdField_b_of_type_Int, 33984);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || (bool))
      {
        if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
        }
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_Lwf.jdField_a_of_type_Int, this.jdField_a_of_type_Lwf.jdField_b_of_type_Int, 33985);
      }
      if (this.jdField_a_of_type_Lqe == null)
      {
        this.jdField_a_of_type_Lqe = new lqe();
        this.jdField_a_of_type_Lqe.b();
      }
      if (bool) {
        this.jdField_a_of_type_Lqe.a(this.jdField_a_of_type_Lwf.jdField_a_of_type_Int, this.jdField_a_of_type_Lwf.jdField_b_of_type_Int);
      }
      if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (bool)) {
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.jdField_a_of_type_Lwf.jdField_a_of_type_Int * this.jdField_a_of_type_Lwf.jdField_b_of_type_Int * 3 / 2);
      }
    }
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (bool)) {
      this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Lwf.jdField_a_of_type_Int * this.jdField_a_of_type_Lwf.jdField_b_of_type_Int * 3 / 2];
    }
  }
  
  private void i()
  {
    long l6 = SystemClock.elapsedRealtime();
    h();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    if (this.jdField_b_of_type_ArrayOfFloat == null)
    {
      this.jdField_b_of_type_ArrayOfFloat = GPUBaseFilter.caculateCenterCropMvpMatrix(this.e, this.f, this.jdField_a_of_type_Lwf.jdField_a_of_type_Int, this.jdField_a_of_type_Lwf.jdField_b_of_type_Int);
      Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, 1.0F, -1.0F, 1.0F);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.d, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    long l7 = Math.abs(SystemClock.elapsedRealtime() - l6);
    long l4 = 0L;
    long l5 = 0L;
    long l1 = 0L;
    long l3;
    long l2;
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      l1 = SystemClock.elapsedRealtime();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
      this.jdField_a_of_type_Lqe.a(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
      l3 = Math.abs(SystemClock.elapsedRealtime() - l1);
      l1 = SystemClock.elapsedRealtime();
      GLES20.glReadPixels(0, 0, this.jdField_a_of_type_Lwf.jdField_a_of_type_Int, this.jdField_a_of_type_Lwf.jdField_b_of_type_Int * 3 / 8, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
      l2 = Math.abs(SystemClock.elapsedRealtime() - l1);
      this.jdField_a_of_type_JavaNioByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Lwf.jdField_a_of_type_Int * this.jdField_a_of_type_Lwf.jdField_b_of_type_Int * 3 / 2);
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      localObject = this.jdField_a_of_type_Lpf;
      if (localObject == null) {
        break label398;
      }
      l1 = SystemClock.elapsedRealtime();
      ((lpf)localObject).a(this.jdField_a_of_type_ArrayOfByte, this.g, 2, this.jdField_a_of_type_Lwf);
      l1 = SystemClock.elapsedRealtime() - l1;
    }
    for (;;)
    {
      this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      l4 = this.jdField_c_of_type_Long;
      this.jdField_a_of_type_Lpe.a(l7, l3, l2, l1, l4 - l6);
      return;
      localObject = GlUtil.captureFrame(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), this.jdField_a_of_type_Lwf.jdField_a_of_type_Int, this.jdField_a_of_type_Lwf.jdField_b_of_type_Int, 0);
      lpf locallpf = this.jdField_a_of_type_Lpf;
      l3 = l4;
      l2 = l5;
      if (locallpf != null)
      {
        l1 = SystemClock.elapsedRealtime();
        locallpf.a((Bitmap)localObject, this.jdField_a_of_type_Lwf);
        l1 = SystemClock.elapsedRealtime() - l1;
        l3 = l4;
        l2 = l5;
        continue;
        label398:
        l1 = 0L;
      }
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  @RequiresApi(api=21)
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      c();
      b();
      return;
    case 2: 
      e();
      f();
      return;
    }
    g();
  }
  
  public void a(lpf paramlpf)
  {
    this.jdField_a_of_type_Lpf = paramlpf;
  }
  
  public void a(lwf paramlwf)
  {
    if ((paramlwf == null) || (!paramlwf.a())) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("EGLScreenCaptureThread", 4, "updateRecordParam cur[" + this.jdField_b_of_type_Lwf + "], come[" + paramlwf + "]");
    }
    this.jdField_b_of_type_Lwf.a(paramlwf);
  }
  
  @RequiresApi(api=18)
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("EGLScreenCaptureThread", 4, "quit");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.getLooper().quitSafely();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    int i = 0;
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_b_of_type_Long += 1L;
      l = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Long = l;
      if (this.jdField_a_of_type_ArrayOfFloat == null) {
        this.jdField_a_of_type_ArrayOfFloat = new float[16];
      }
      paramSurfaceTexture.updateTexImage();
      paramSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      this.jdField_a_of_type_Float = ((float)paramSurfaceTexture.getTimestamp());
      if (this.jdField_a_of_type_Float != 0.0F) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("EGLScreenCaptureThread", 4, "onFrameAvailable, time[" + this.jdField_a_of_type_Float + "]");
    return;
    long l = Math.abs(l - this.jdField_c_of_type_Long);
    if (this.jdField_c_of_type_Long != 0L) {
      if (l >= this.jdField_a_of_type_Lwf.jdField_a_of_type_Long) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {}
      for (l = Math.min(this.jdField_a_of_type_Lwf.jdField_a_of_type_Long - l, 2000L);; l = 2000L)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, l);
        if ((i != 0) || ((!this.jdField_b_of_type_Lwf.a()) && (!this.jdField_a_of_type_Lwf.a()))) {
          break;
        }
        i();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpd
 * JD-Core Version:    0.7.0.1
 */