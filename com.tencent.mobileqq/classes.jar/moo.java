import android.annotation.TargetApi;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@TargetApi(18)
public class moo
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private bbmc jdField_a_of_type_Bbmc;
  private bbmd jdField_a_of_type_Bbmd;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private moj jdField_a_of_type_Moj;
  protected mok a;
  private mop jdField_a_of_type_Mop;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  public moo()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandlerThread.setPriority(10);
    this.jdField_a_of_type_Mop = new mop(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_Moj = new moj(this);
    this.jdField_a_of_type_Bbmd = new bbmd();
  }
  
  private void a(bbmc parambbmc)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording EGLContext = " + parambbmc.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    this.jdField_a_of_type_Bbmc = parambbmc;
    this.jdField_a_of_type_JavaLangString = parambbmc.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Moj.a(parambbmc);
      this.jdField_a_of_type_Bbmd.a(parambbmc, this.jdField_a_of_type_Moj.a());
      if (this.jdField_a_of_type_Mok != null) {
        this.jdField_a_of_type_Mok.g();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + parambbmc);
      }
      if (this.jdField_a_of_type_Mok != null) {
        this.jdField_a_of_type_Mok.a(1, localThrowable);
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
      mol.c();
      if ((this.jdField_a_of_type_Moj.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Moj.c) && (this.jdField_a_of_type_Moj.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
        }
        if (this.jdField_a_of_type_Mok != null) {
          this.jdField_a_of_type_Mok.o();
        }
      }
      else
      {
        try
        {
          this.jdField_a_of_type_Moj.a();
          this.jdField_a_of_type_Bbmd.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Mok != null)
          {
            this.jdField_a_of_type_Mok.h();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "videoFrameAvailable: exception. config = " + this.jdField_a_of_type_Bbmc);
          }
          if (this.jdField_a_of_type_Mok != null) {
            this.jdField_a_of_type_Mok.a(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Moj.c();
          this.jdField_a_of_type_Bbmd.a();
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
        this.jdField_a_of_type_Moj.b();
        this.jdField_a_of_type_Bbmd.a();
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_Mok != null)
        {
          this.jdField_a_of_type_Mok.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Mok = null;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Bbmc);
        }
        if (this.jdField_a_of_type_Mok != null) {
          this.jdField_a_of_type_Mok.a(4, localException);
        }
        this.jdField_a_of_type_Moj.c();
        this.jdField_a_of_type_Bbmd.a();
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
    this.jdField_a_of_type_Mop.sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    this.jdField_a_of_type_Mop.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
    this.jdField_a_of_type_Mop.sendMessage(localMessage);
  }
  
  public void a(bbmc parambbmc, mok parammok)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "startRecording EGLContext = " + parambbmc.a() + ", config=" + parambbmc);
    }
    this.jdField_a_of_type_Mok = parammok;
    parammok = Message.obtain();
    parammok.obj = parambbmc;
    parammok.what = 0;
    this.jdField_a_of_type_Mop.sendMessage(parammok);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((!this.jdField_a_of_type_Moj.b) || (this.jdField_a_of_type_Moj.c)) {
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
      if (!this.jdField_a_of_type_Moj.c)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = new Object[] { paramArrayOfByte, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Mop.sendMessage(localMessage);
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
        this.jdField_a_of_type_Mop.sendMessage(paramArrayOfByte);
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
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Moj != null) && (this.jdField_a_of_type_Moj.b);
  }
  
  public void b()
  {
    mop localmop = this.jdField_a_of_type_Mop;
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    bbmd localbbmd = this.jdField_a_of_type_Bbmd;
    if (localHandlerThread != null) {
      localmop.post(new QavVideoAudioRecorder.1(this, localbbmd, localHandlerThread));
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
      this.jdField_a_of_type_Moj.a(paramArrayOfByte, paramLong - this.b);
      if (this.jdField_a_of_type_Mok != null) {
        this.jdField_a_of_type_Mok.i();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.jdField_a_of_type_Mok != null) {
        this.jdField_a_of_type_Mok.a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Moj != null) && (this.jdField_a_of_type_Moj.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     moo
 * JD-Core Version:    0.7.0.1
 */