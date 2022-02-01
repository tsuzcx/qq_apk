import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;

public class ned
  implements ncu
{
  private EglHandlerThread jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private volatile Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private CopyOnWriteArrayList<WeakReference<nef>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private lpn jdField_a_of_type_Lpn;
  private lvj jdField_a_of_type_Lvj = new lvj();
  protected nct a;
  private nee jdField_a_of_type_Nee;
  private neg jdField_a_of_type_Neg;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private Integer jdField_b_of_type_JavaLangInteger;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private volatile boolean c = true;
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaLangInteger == null) || (paramInt1 != this.jdField_a_of_type_JavaLangInteger.intValue()) || (paramInt2 != this.jdField_b_of_type_JavaLangInteger.intValue()))
    {
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt1);
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt2);
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        k();
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null)
      {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), 33984);
        Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
        Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, 1.0F, -1.0F, 1.0F);
      }
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      }
      if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null)
      {
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), 33985);
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.jdField_a_of_type_JavaLangInteger.intValue() * this.jdField_b_of_type_JavaLangInteger.intValue() * 3 / 2);
        this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_JavaLangInteger.intValue() * this.jdField_b_of_type_JavaLangInteger.intValue() * 3 / 2];
      }
      if (this.jdField_a_of_type_Lpn == null)
      {
        this.jdField_a_of_type_Lpn = new lpn();
        this.jdField_a_of_type_Lpn.b();
        this.jdField_a_of_type_Lpn.a(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
      }
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong)
  {
    a(paramInt1 / 16 * 16, paramInt2 / 8 * 8);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_a_of_type_Nct.a(), this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_Lpn.a(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
    GLES20.glReadPixels(0, 0, this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue() * 3 / 8, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    this.jdField_a_of_type_JavaNioByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_JavaLangInteger.intValue() * this.jdField_b_of_type_JavaLangInteger.intValue() * 3 / 2);
    this.jdField_a_of_type_JavaNioByteBuffer.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((nef)localWeakReference.get()).a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), paramLong);
      }
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_Lvj.a(this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue(), 15);
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = new EglHandlerThread("eglHandelr_thread", null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.start();
      this.jdField_a_of_type_Nee = new nee(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.getLooper());
      this.jdField_a_of_type_Nee.sendEmptyMessage(152);
    }
  }
  
  private void j()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "initEgl");
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_Nct.a(this, this.jdField_a_of_type_Nee);
  }
  
  private void k()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "unInitEgl");
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
    if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_Lpn != null)
    {
      this.jdField_a_of_type_Lpn.c();
      this.jdField_a_of_type_Lpn = null;
    }
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    this.jdField_a_of_type_ArrayOfByte = null;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Nct != null) {
      return this.jdField_a_of_type_Nct.a();
    }
    return 0L;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "relasePlayVideo");
    if (this.jdField_a_of_type_Nct != null) {
      this.jdField_a_of_type_Nct.a();
    }
    if (this.jdField_a_of_type_Nee != null) {
      this.jdField_a_of_type_Nee.sendEmptyMessage(258);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramInt3 * 1.0F / paramInt2);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.jdField_a_of_type_Nct == null) || (this.jdField_a_of_type_Nct.a() == null) || (this.jdField_a_of_type_Nct.a() == -1)) {}
    do
    {
      return;
      this.jdField_a_of_type_Nct.a().updateTexImage();
      this.jdField_a_of_type_Nct.a().getTransformMatrix(this.jdField_a_of_type_ArrayOfFloat);
    } while (!this.c);
    a(paramInt1, paramInt2, paramLong);
  }
  
  public void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    h();
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramTPAudioFrameBuffer.getChannelLayout() != 3L) {
        break label273;
      }
      m = paramTPAudioFrameBuffer.getSize()[0] / 2;
      arrayOfByte = new byte[m];
      j = 0;
      k = 0;
      if (j < m)
      {
        i2 = (short)paramTPAudioFrameBuffer.data[0][(j * 2)];
        n = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 1)];
        i3 = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 2)];
        i1 = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 3)];
        i2 = (i2 + i3) / 2;
        n = (n + i1) / 2;
        i1 = k + 1;
        if (i2 > 127)
        {
          i = 127;
          label142:
          arrayOfByte[k] = i;
          k = i1 + 1;
          if (n <= 127) {
            break label197;
          }
          i = 127;
        }
        for (;;)
        {
          arrayOfByte[i1] = i;
          j += 2;
          break;
          if (i2 < -128)
          {
            i = -128;
            break label142;
          }
          i = (byte)i2;
          break label142;
          label197:
          if (n < -128) {
            i = -128;
          } else {
            i = (byte)n;
          }
        }
      }
      if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < 0.99F) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > 1.01F))
      {
        mvy.a();
        mvy.a(arrayOfByte, this.jdField_a_of_type_JavaLangFloat.floatValue());
      }
      mvy.a().a(arrayOfByte, arrayOfByte.length);
    }
    label273:
    while (paramTPAudioFrameBuffer.getChannelLayout() != 4L)
    {
      int m;
      byte[] arrayOfByte;
      int j;
      int k;
      int i2;
      int n;
      int i3;
      int i1;
      int i;
      return;
    }
    if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < 0.99F) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > 1.01F))
    {
      mvy.a();
      mvy.a(paramTPAudioFrameBuffer.data[0], this.jdField_a_of_type_JavaLangFloat.floatValue());
    }
    mvy.a().a(paramTPAudioFrameBuffer.data[0], paramTPAudioFrameBuffer.data[0].length);
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((nef)localWeakReference.get()).a(paramString);
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "playAudioByURL");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Nct != null) {
      this.jdField_a_of_type_Nct.a(this.jdField_a_of_type_JavaLangString, paramLong);
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      mvy.a(bjce.a().a());
      mvy.a().a(3);
    }
  }
  
  public void a(List<nec> paramList)
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "setPreLoadVideoResourceInfos infoList:=" + Arrays.toString(paramList.toArray()));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      nec localnec = (nec)paramList.next();
      this.jdField_a_of_type_Neg.a(localnec.jdField_a_of_type_JavaLangString, localnec.jdField_a_of_type_Long, 3000L);
    }
  }
  
  public void a(nef paramnef)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (paramnef == localWeakReference.get())) {
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramnef));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Nct != null) {
      this.jdField_a_of_type_Nct.a(true);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Nct.a()) {
          bool1 = true;
        }
      }
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Nct == null);
    return this.jdField_a_of_type_Nct.a();
  }
  
  public void b()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopVideoPlay");
    if (this.jdField_a_of_type_Nct != null) {
      this.jdField_a_of_type_Nct.b();
    }
  }
  
  public void b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((nef)localWeakReference.get()).b(paramString);
      }
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "playVideoByURl");
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {}
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        mvy.a(bjce.a().a());
        mvy.a().a(3);
      }
      return;
      if (!this.jdField_b_of_type_Boolean) {
        ndt.b().a(true);
      }
      this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Nct != null) {
        this.jdField_a_of_type_Nct.b(this.jdField_a_of_type_JavaLangString, paramLong);
      }
    }
  }
  
  public void b(nef paramnef)
  {
    Object localObject = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    if (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference == null) || (paramnef != localWeakReference.get())) {
        break label63;
      }
      localObject = localWeakReference;
    }
    label63:
    for (;;)
    {
      break;
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localObject);
      }
      return;
    }
  }
  
  public void c()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "stopVideoSend");
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {}
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    ndt.b().a(false);
  }
  
  public void c(String paramString)
  {
    bcst.b(null, "dc00898", "", "", "0X800B1F3", "0X800B1F3", 0, 0, "", "", "", "");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((nef)localWeakReference.get()).c(paramString);
      }
    }
  }
  
  public void d()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "init");
    this.jdField_a_of_type_Neg = new neg();
    this.jdField_a_of_type_Nct = new nct();
    i();
  }
  
  public void d(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((nef)localWeakReference.get()).d(paramString);
      }
    }
  }
  
  public void e()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "doOnResume");
    this.c = true;
  }
  
  public void f()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "doOnStop");
    this.c = false;
    if (this.jdField_a_of_type_Nee != null) {
      this.jdField_a_of_type_Nee.sendEmptyMessage(258);
    }
  }
  
  public void g()
  {
    QLog.d("AVGameMediaPlayerCtrl", 1, "unInit");
    if (this.jdField_a_of_type_Nct != null) {
      this.jdField_a_of_type_Nct.c();
    }
    this.jdField_a_of_type_Neg.a();
    c();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread != null)
    {
      if (this.jdField_a_of_type_Nee != null) {
        this.jdField_a_of_type_Nee.sendEmptyMessage(153);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.quitSafely();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = null;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaLangFloat != null) {
      return;
    }
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    int i = localAudioManager.getStreamVolume(0);
    int j = localAudioManager.getStreamMaxVolume(0);
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(i * 1.0F / j);
    bjcq.d("AVGameMediaPlayerCtrl", "init scaleFacors:=" + this.jdField_a_of_type_JavaLangFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ned
 * JD-Core Version:    0.7.0.1
 */