import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@TargetApi(18)
public class mcw
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private auzf jdField_a_of_type_Auzf;
  private auzg jdField_a_of_type_Auzg;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private mcr jdField_a_of_type_Mcr;
  protected mcs a;
  private mcx jdField_a_of_type_Mcx;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  public mcw()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandlerThread.setPriority(10);
    this.jdField_a_of_type_Mcx = new mcx(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_Mcr = new mcr(this);
    this.jdField_a_of_type_Auzg = new auzg();
  }
  
  private void a(auzf paramauzf)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording EGLContext = " + paramauzf.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    this.jdField_a_of_type_Auzf = paramauzf;
    this.jdField_a_of_type_JavaLangString = paramauzf.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Mcr.a(paramauzf);
      this.jdField_a_of_type_Auzg.a(paramauzf, this.jdField_a_of_type_Mcr.a());
      if (this.jdField_a_of_type_Mcs != null) {
        this.jdField_a_of_type_Mcs.g();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramauzf);
      }
      if (this.jdField_a_of_type_Mcs != null) {
        this.jdField_a_of_type_Mcs.a(1, localThrowable);
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
      mct.c();
      if ((this.jdField_a_of_type_Mcr.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Mcr.c) && (this.jdField_a_of_type_Mcr.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
        }
      }
      else {
        try
        {
          this.jdField_a_of_type_Mcr.a();
          this.jdField_a_of_type_Auzg.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Mcs != null)
          {
            this.jdField_a_of_type_Mcs.h();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "videoFrameAvailable: exception. config = " + this.jdField_a_of_type_Auzf);
          }
          if (this.jdField_a_of_type_Mcs != null) {
            this.jdField_a_of_type_Mcs.a(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Mcr.c();
          this.jdField_a_of_type_Auzg.a();
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
        this.jdField_a_of_type_Mcr.b();
        this.jdField_a_of_type_Auzg.a();
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_Mcs != null)
        {
          this.jdField_a_of_type_Mcs.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Mcs = null;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Auzf);
        }
        if (this.jdField_a_of_type_Mcs != null) {
          this.jdField_a_of_type_Mcs.a(4, localException);
        }
        this.jdField_a_of_type_Mcr.c();
        this.jdField_a_of_type_Auzg.a();
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
    this.jdField_a_of_type_Mcx.sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoAudioRecorder", 2, "videoFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + EGL14.eglGetCurrentContext());
    }
    this.jdField_a_of_type_Mcx.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
    this.jdField_a_of_type_Mcx.sendMessage(localMessage);
  }
  
  public void a(auzf paramauzf, mcs parammcs)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "startRecording EGLContext = " + paramauzf.a() + ", config=" + paramauzf);
    }
    this.jdField_a_of_type_Mcs = parammcs;
    parammcs = Message.obtain();
    parammcs.obj = paramauzf;
    parammcs.what = 0;
    this.jdField_a_of_type_Mcx.sendMessage(parammcs);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 1, "audioFrameAvailable, audioData[" + paramArrayOfByte.length + "], pts[" + paramLong + "], mAudioBufCount[" + this.jdField_a_of_type_Int + "], mPts[" + this.c + "]");
      }
      if ((!this.jdField_a_of_type_Mcr.b) || (this.jdField_a_of_type_Mcr.c)) {
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
      if (!this.jdField_a_of_type_Mcr.c)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = new Object[] { paramArrayOfByte, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Mcx.sendMessage(localMessage);
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
        this.jdField_a_of_type_Mcx.sendMessage(paramArrayOfByte);
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
    mcx localmcx = this.jdField_a_of_type_Mcx;
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    auzg localauzg = this.jdField_a_of_type_Auzg;
    if (localHandlerThread != null) {
      localmcx.post(new QavVideoAudioRecorder.1(this, localauzg, localHandlerThread));
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
      this.jdField_a_of_type_Mcr.a(paramArrayOfByte, paramLong - this.b);
      if (this.jdField_a_of_type_Mcs != null) {
        this.jdField_a_of_type_Mcs.i();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.jdField_a_of_type_Mcs != null) {
        this.jdField_a_of_type_Mcs.a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcw
 * JD-Core Version:    0.7.0.1
 */