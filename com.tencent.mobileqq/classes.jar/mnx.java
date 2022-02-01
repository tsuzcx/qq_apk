import android.annotation.TargetApi;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@TargetApi(18)
public class mnx
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private bafx jdField_a_of_type_Bafx;
  private bafy jdField_a_of_type_Bafy;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private mns jdField_a_of_type_Mns;
  protected mnt a;
  private mny jdField_a_of_type_Mny;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  public mnx()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandlerThread.setPriority(10);
    this.jdField_a_of_type_Mny = new mny(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_Mns = new mns(this);
    this.jdField_a_of_type_Bafy = new bafy();
  }
  
  private void a(bafx parambafx)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording EGLContext = " + parambafx.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    this.jdField_a_of_type_Bafx = parambafx;
    this.jdField_a_of_type_JavaLangString = parambafx.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Mns.a(parambafx);
      this.jdField_a_of_type_Bafy.a(parambafx, this.jdField_a_of_type_Mns.a());
      if (this.jdField_a_of_type_Mnt != null) {
        this.jdField_a_of_type_Mnt.g();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + parambafx);
      }
      if (this.jdField_a_of_type_Mnt != null) {
        this.jdField_a_of_type_Mnt.a(1, localThrowable);
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
      mnu.c();
      if ((this.jdField_a_of_type_Mns.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Mns.c) && (this.jdField_a_of_type_Mns.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
        }
        if (this.jdField_a_of_type_Mnt != null) {
          this.jdField_a_of_type_Mnt.o();
        }
      }
      else
      {
        try
        {
          this.jdField_a_of_type_Mns.a();
          this.jdField_a_of_type_Bafy.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Mnt != null)
          {
            this.jdField_a_of_type_Mnt.h();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "videoFrameAvailable: exception. config = " + this.jdField_a_of_type_Bafx);
          }
          if (this.jdField_a_of_type_Mnt != null) {
            this.jdField_a_of_type_Mnt.a(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Mns.c();
          this.jdField_a_of_type_Bafy.a();
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
        this.jdField_a_of_type_Mns.b();
        this.jdField_a_of_type_Bafy.a();
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_Mnt != null)
        {
          this.jdField_a_of_type_Mnt.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Mnt = null;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Bafx);
        }
        if (this.jdField_a_of_type_Mnt != null) {
          this.jdField_a_of_type_Mnt.a(4, localException);
        }
        this.jdField_a_of_type_Mns.c();
        this.jdField_a_of_type_Bafy.a();
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
    this.jdField_a_of_type_Mny.sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.jdField_a_of_type_Mny.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
    this.jdField_a_of_type_Mny.sendMessage(localMessage);
  }
  
  public void a(bafx parambafx, mnt parammnt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "startRecording EGLContext = " + parambafx.a() + ", config=" + parambafx);
    }
    this.jdField_a_of_type_Mnt = parammnt;
    parammnt = Message.obtain();
    parammnt.obj = parambafx;
    parammnt.what = 0;
    this.jdField_a_of_type_Mny.sendMessage(parammnt);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((!this.jdField_a_of_type_Mns.b) || (this.jdField_a_of_type_Mns.c)) {
        break label43;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QavVideoAudioRecorder", 2, "audioFrameAvailable audio track ready but muxer not start");
      }
    }
    for (;;)
    {
      return;
      label43:
      if (!this.jdField_a_of_type_Mns.c)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = new Object[] { paramArrayOfByte, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Mny.sendMessage(localMessage);
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
        this.jdField_a_of_type_Mny.sendMessage(paramArrayOfByte);
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
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Mns != null) && (this.jdField_a_of_type_Mns.b);
  }
  
  public void b()
  {
    mny localmny = this.jdField_a_of_type_Mny;
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    bafy localbafy = this.jdField_a_of_type_Bafy;
    if (localHandlerThread != null) {
      localmny.post(new QavVideoAudioRecorder.1(this, localbafy, localHandlerThread));
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
      this.jdField_a_of_type_Mns.a(paramArrayOfByte, paramLong - this.b);
      if (this.jdField_a_of_type_Mnt != null) {
        this.jdField_a_of_type_Mnt.i();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.jdField_a_of_type_Mnt != null) {
        this.jdField_a_of_type_Mnt.a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Mns != null) && (this.jdField_a_of_type_Mns.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnx
 * JD-Core Version:    0.7.0.1
 */