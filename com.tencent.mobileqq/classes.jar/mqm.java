import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@TargetApi(18)
public class mqm
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private axvi jdField_a_of_type_Axvi;
  private axvj jdField_a_of_type_Axvj;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private mqh jdField_a_of_type_Mqh;
  protected mqi a;
  private mqn jdField_a_of_type_Mqn;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  public mqm()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandlerThread.setPriority(10);
    this.jdField_a_of_type_Mqn = new mqn(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_Mqh = new mqh(this);
    this.jdField_a_of_type_Axvj = new axvj();
  }
  
  private void a(axvi paramaxvi)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording EGLContext = " + paramaxvi.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    this.jdField_a_of_type_Axvi = paramaxvi;
    this.jdField_a_of_type_JavaLangString = paramaxvi.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Mqh.a(paramaxvi);
      this.jdField_a_of_type_Axvj.a(paramaxvi, this.jdField_a_of_type_Mqh.a());
      if (this.jdField_a_of_type_Mqi != null) {
        this.jdField_a_of_type_Mqi.g();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramaxvi);
      }
      if (this.jdField_a_of_type_Mqi != null) {
        this.jdField_a_of_type_Mqi.a(1, localThrowable);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2);
    }
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable mIsRecording = " + this.jdField_a_of_type_Boolean);
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Long < 0L) {
        this.jdField_a_of_type_Long = paramLong;
      }
      mqj.c();
      if ((this.jdField_a_of_type_Mqh.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Mqh.c) && (this.jdField_a_of_type_Mqh.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
        }
      }
      else {
        try
        {
          this.jdField_a_of_type_Mqh.a();
          this.jdField_a_of_type_Axvj.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Mqi != null)
          {
            this.jdField_a_of_type_Mqi.h();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "videoFrameAvailable: exception. config = " + this.jdField_a_of_type_Axvi);
          }
          if (this.jdField_a_of_type_Mqi != null) {
            this.jdField_a_of_type_Mqi.a(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Mqh.c();
          this.jdField_a_of_type_Axvj.a();
          this.jdField_a_of_type_Boolean = false;
        }
      }
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 1, "handleStopRecording, mPts[" + this.c + "]");
    }
    if (this.jdField_a_of_type_Boolean) {}
    while (!QLog.isColorLevel()) {
      try
      {
        b(this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray(), this.c);
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
        this.jdField_a_of_type_Mqh.b();
        this.jdField_a_of_type_Axvj.a();
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_Mqi != null)
        {
          this.jdField_a_of_type_Mqi.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Mqi = null;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Axvi);
        }
        if (this.jdField_a_of_type_Mqi != null) {
          this.jdField_a_of_type_Mqi.a(4, localException);
        }
        this.jdField_a_of_type_Mqh.c();
        this.jdField_a_of_type_Axvj.a();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
    QLog.w("QavVideoAudioRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Mqn.sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoAudioRecorder", 2, "videoFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + EGL14.eglGetCurrentContext());
    }
    this.jdField_a_of_type_Mqn.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
    this.jdField_a_of_type_Mqn.sendMessage(localMessage);
  }
  
  public void a(axvi paramaxvi, mqi parammqi)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "startRecording EGLContext = " + paramaxvi.a() + ", config=" + paramaxvi);
    }
    this.jdField_a_of_type_Mqi = parammqi;
    parammqi = Message.obtain();
    parammqi.obj = paramaxvi;
    parammqi.what = 0;
    this.jdField_a_of_type_Mqn.sendMessage(parammqi);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 1, "audioFrameAvailable, audioData[" + paramArrayOfByte.length + "], pts[" + paramLong + "], mAudioBufCount[" + this.jdField_a_of_type_Int + "], mPts[" + this.c + "]");
      }
      if ((!this.jdField_a_of_type_Mqh.b) || (this.jdField_a_of_type_Mqh.c)) {
        break label117;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "audioFrameAvailable audio track ready but muxer not start");
      }
    }
    for (;;)
    {
      return;
      label117:
      if (!this.jdField_a_of_type_Mqh.c)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = new Object[] { paramArrayOfByte, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Mqn.sendMessage(localMessage);
        return;
      }
      try
      {
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte);
        if (this.jdField_a_of_type_Int == 0) {
          this.c = paramLong;
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int < 5) {
          continue;
        }
        this.jdField_a_of_type_Int = 0;
        paramArrayOfByte = Message.obtain();
        paramArrayOfByte.what = 3;
        paramArrayOfByte.obj = new Object[] { this.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray(), Long.valueOf(this.c) };
        this.jdField_a_of_type_Mqn.sendMessage(paramArrayOfByte);
        this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "audioFrameAvailable ", paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void b()
  {
    mqn localmqn = this.jdField_a_of_type_Mqn;
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    axvj localaxvj = this.jdField_a_of_type_Axvj;
    if (localHandlerThread != null) {
      localmqn.post(new QavVideoAudioRecorder.1(this, localaxvj, localHandlerThread));
    }
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    try
    {
      if (this.b < 0L)
      {
        this.b = paramLong;
        QLog.w("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable, begin, mStartAudioPts[" + this.b + "]");
      }
      this.jdField_a_of_type_Mqh.a(paramArrayOfByte, paramLong - this.b);
      if (this.jdField_a_of_type_Mqi != null) {
        this.jdField_a_of_type_Mqi.i();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.jdField_a_of_type_Mqi != null) {
        this.jdField_a_of_type_Mqi.a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mqm
 * JD-Core Version:    0.7.0.1
 */