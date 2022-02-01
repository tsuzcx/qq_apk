import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentHashMap;

public class ncv
{
  protected int a;
  private long jdField_a_of_type_Long;
  protected Point a;
  protected Rect a;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  protected aouq a;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  protected Boolean a;
  private ConcurrentHashMap<Long, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  protected volatile boolean a;
  protected byte[] a;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  protected int b;
  private long jdField_b_of_type_Long;
  protected volatile boolean b;
  protected byte[] b;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  protected int c;
  private long c;
  protected boolean c;
  protected byte[] c;
  protected int d;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = -1;
  private long jdField_e_of_type_Long;
  private long f;
  
  private Point a()
  {
    int k;
    int j;
    if (this.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      i = this.jdField_a_of_type_AndroidGraphicsRect.right;
      i = this.jdField_a_of_type_AndroidGraphicsRect.left;
      i = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      k = this.jdField_a_of_type_AndroidGraphicsRect.top;
      j = this.jdField_a_of_type_AndroidGraphicsRect.left;
    }
    for (int i = this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidGraphicsRect.top - (i - k);; i = this.jdField_b_of_type_Int - 480 - 40)
    {
      this.jdField_a_of_type_AndroidGraphicsPoint = new Point(j, i);
      return this.jdField_a_of_type_AndroidGraphicsPoint;
      j = (this.jdField_a_of_type_Int - 640) / 2;
    }
  }
  
  private void a(long paramLong) {}
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 1)) {
      return;
    }
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] == null) || (this.jdField_a_of_type_ArrayOfInt[0] != paramArrayOfByte1.length)) {}
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].clear();
      this.jdField_a_of_type_ArrayOfInt[0] = paramArrayOfByte1.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].put(paramArrayOfByte1);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].position(0);
      if (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] != null) {
        if (this.jdField_a_of_type_ArrayOfInt[1] == paramArrayOfByte2.length) {
          break label145;
        }
      }
    }
    catch (Throwable paramArrayOfByte1)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] = ByteBuffer.allocateDirect(paramArrayOfByte2.length);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].order(ByteOrder.nativeOrder());
        label145:
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].clear();
        this.jdField_a_of_type_ArrayOfInt[1] = paramArrayOfByte2.length;
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].put(paramArrayOfByte2);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].position(0);
        if (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] != null) {
          if (this.jdField_a_of_type_ArrayOfInt[2] == paramArrayOfByte3.length) {
            break label229;
          }
        }
      }
      catch (Throwable paramArrayOfByte1)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] = ByteBuffer.allocateDirect(paramArrayOfByte3.length);
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].order(ByteOrder.nativeOrder());
            label229:
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].clear();
            this.jdField_a_of_type_ArrayOfInt[2] = paramArrayOfByte3.length;
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].put(paramArrayOfByte3);
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].position(0);
            return;
            localThrowable = localThrowable;
            QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", localThrowable);
          }
          paramArrayOfByte1 = paramArrayOfByte1;
          QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", paramArrayOfByte1);
        }
        catch (Throwable paramArrayOfByte1)
        {
          for (;;)
          {
            QLog.e("AVGameMediaRenderHelper", 1, "textureYUV fail.", paramArrayOfByte1);
          }
        }
      }
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 1)) {
      return;
    }
    if (!this.jdField_a_of_type_Aouq.a()) {
      this.jdField_a_of_type_Aouq.a();
    }
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte);
        this.jdField_a_of_type_Aouq.a(this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0], this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1], this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2], this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
  }
  
  private void g()
  {
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] == null) || (this.jdField_c_of_type_Int == 0) || (this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 1)) {
      return;
    }
    QLog.d("AVGameMediaRenderHelper", 1, "loadVerticalBuffer");
    this.jdField_c_of_type_Boolean = false;
    float[] arrayOfFloat = new float[8];
    float[] tmp68_66 = arrayOfFloat;
    tmp68_66[0] = -1.0F;
    float[] tmp73_68 = tmp68_66;
    tmp73_68[1] = 1.0F;
    float[] tmp77_73 = tmp73_68;
    tmp77_73[2] = 1.0F;
    float[] tmp81_77 = tmp77_73;
    tmp81_77[3] = 1.0F;
    float[] tmp85_81 = tmp81_77;
    tmp85_81[4] = -1.0F;
    float[] tmp90_85 = tmp85_81;
    tmp90_85[5] = -1.0F;
    float[] tmp95_90 = tmp90_85;
    tmp95_90[6] = 1.0F;
    float[] tmp100_95 = tmp95_90;
    tmp100_95[7] = -1.0F;
    tmp100_95;
    int i;
    int j;
    float f1;
    float f2;
    if (this.jdField_a_of_type_AndroidGraphicsRect != null)
    {
      i = this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left;
      j = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
      int k = this.jdField_c_of_type_Int;
      int m = this.jdField_d_of_type_Int;
      f1 = i / j;
      f2 = k / m;
      if (f1 >= f2) {
        break label241;
      }
      f1 = i * f2 / j;
      arrayOfFloat[0] *= f1;
      arrayOfFloat[2] *= f1;
      arrayOfFloat[4] *= f1;
      arrayOfFloat[6] = (f1 * arrayOfFloat[6]);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aouq.a(arrayOfFloat);
      return;
      label241:
      if (f1 > f2)
      {
        f1 = i / (j * f2);
        arrayOfFloat[1] *= f1;
        arrayOfFloat[3] *= f1;
        arrayOfFloat[5] *= f1;
        arrayOfFloat[7] = (f1 * arrayOfFloat[7]);
      }
    }
  }
  
  public void a()
  {
    QLog.d("AVGameMediaRenderHelper", 1, "onGLSurfaceDestroy");
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
    this.jdField_a_of_type_Aouq.c();
    this.jdField_a_of_type_Aouq = null;
    this.jdField_a_of_type_ArrayOfByte = new byte[1];
    this.jdField_b_of_type_ArrayOfByte = new byte[1];
    this.jdField_c_of_type_ArrayOfByte = new byte[1];
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("AVGameMediaRenderHelper", 1, "onGLSurfaceCreate");
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Aouq = new aouq(0);
    this.jdField_a_of_type_ArrayOfByte = new byte[1];
    this.jdField_b_of_type_ArrayOfByte = new byte[1];
    this.jdField_c_of_type_ArrayOfByte = new byte[1];
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, 1.0F, -1.0F, 1.0F);
  }
  
  protected void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaLangBoolean == null))
    {
      QLog.d("AVGameMediaRenderHelper", 1, "renderVideoCover fail");
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      c();
    }
    for (;;)
    {
      d();
      return;
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("AVGameMediaRenderHelper", 1, "notifySelfMediaRender enable:=" + paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 1) && (!this.jdField_b_of_type_Boolean)) {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_ArrayOfByte = new byte[1];
        this.jdField_b_of_type_ArrayOfByte = new byte[1];
        this.jdField_c_of_type_ArrayOfByte = new byte[1];
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
        return;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ArrayOfByte == null))
    {
      QLog.d("AVGameMediaRenderHelper", 1, "onPushVideoMsg fail");
      return;
    }
    a(paramLong);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (this.jdField_a_of_type_ArrayOfByte.length != paramInt1 * paramInt2)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt1 * paramInt2];
      this.jdField_b_of_type_ArrayOfByte = new byte[paramInt1 * paramInt2 / 4];
      this.jdField_c_of_type_ArrayOfByte = new byte[paramInt1 * paramInt2 / 4];
      this.jdField_c_of_type_Boolean = true;
      QLog.d("AVGameMediaRenderHelper", 1, "onPushVideoMsg mRenderParamsChang;=true");
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_Boolean = true;
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
      System.arraycopy(paramArrayOfByte, this.jdField_a_of_type_ArrayOfByte.length, this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte.length);
      System.arraycopy(paramArrayOfByte, this.jdField_a_of_type_ArrayOfByte.length + this.jdField_b_of_type_ArrayOfByte.length, this.jdField_c_of_type_ArrayOfByte, 0, this.jdField_c_of_type_ArrayOfByte.length);
      e();
      return;
    }
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) || (this.jdField_e_of_type_Int == -1) || (this.jdField_a_of_type_AndroidGraphicsRect == null)) {
      return;
    }
    synchronized (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
      GLES20.glViewport(a().x, a().x, this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top);
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_e_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
      GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
  }
  
  protected void c()
  {
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_JavaLangBoolean == null) || (this.jdField_c_of_type_Int == 0) || (this.jdField_a_of_type_ArrayOfByte.length == 1) || (this.jdField_a_of_type_AndroidGraphicsRect == null)) {
      QLog.d("AVGameMediaRenderHelper", 1, "renderVideoCoverBySoft fail");
    }
    do
    {
      do
      {
        return;
        f();
        g();
      } while (this.jdField_a_of_type_ArrayOfByte.length == 1);
      GLES20.glViewport(a().x, a().y, this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top);
      this.jdField_a_of_type_Aouq.b();
      GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    } while (!this.jdField_d_of_type_Boolean);
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long += 1L;
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    }
    if (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long >= 1000L)
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("AVGameMediaRenderHelper", 1, "updateFPSRate mFrameRate:=" + this.jdField_c_of_type_Long);
      }
    }
  }
  
  public void e()
  {
    this.jdField_d_of_type_Long += 1L;
    if (this.jdField_e_of_type_Long == 0L) {
      this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
    }
    if (SystemClock.elapsedRealtime() - this.jdField_e_of_type_Long >= 1000L)
    {
      this.f = this.jdField_d_of_type_Long;
      this.jdField_d_of_type_Long = 0L;
      this.jdField_e_of_type_Long = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("AVGameMediaRenderHelper", 1, "updateFPSRate updateDecodeRate:=" + this.jdField_c_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ncv
 * JD-Core Version:    0.7.0.1
 */