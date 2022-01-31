import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder.1;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@TargetApi(18)
public class mns
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private avza jdField_a_of_type_Avza;
  private avzb jdField_a_of_type_Avzb;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private mnn jdField_a_of_type_Mnn;
  protected mno a;
  private mnt jdField_a_of_type_Mnt;
  private volatile boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  public mns()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandlerThread.setPriority(10);
    this.jdField_a_of_type_Mnt = new mnt(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    this.jdField_a_of_type_Mnn = new mnn(this);
    this.jdField_a_of_type_Avzb = new avzb();
  }
  
  private void a(avza paramavza)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording EGLContext = " + paramavza.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.b = -1L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
    this.jdField_a_of_type_Avza = paramavza;
    this.jdField_a_of_type_JavaLangString = paramavza.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Mnn.a(paramavza);
      this.jdField_a_of_type_Avzb.a(paramavza, this.jdField_a_of_type_Mnn.a());
      if (this.jdField_a_of_type_Mno != null) {
        this.jdField_a_of_type_Mno.g();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramavza);
      }
      if (this.jdField_a_of_type_Mno != null) {
        this.jdField_a_of_type_Mno.a(1, localThrowable);
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
      mnp.c();
      if ((this.jdField_a_of_type_Mnn.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Mnn.c) && (this.jdField_a_of_type_Mnn.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QavVideoAudioRecorder", 2, "handleVideoFrameAvailable video track ready but muxer not start");
        }
      }
      else {
        try
        {
          this.jdField_a_of_type_Mnn.a();
          this.jdField_a_of_type_Avzb.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong - this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_Mno != null)
          {
            this.jdField_a_of_type_Mno.h();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QavVideoAudioRecorder", 2, "videoFrameAvailable: exception. config = " + this.jdField_a_of_type_Avza);
          }
          if (this.jdField_a_of_type_Mno != null) {
            this.jdField_a_of_type_Mno.a(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Mnn.c();
          this.jdField_a_of_type_Avzb.a();
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
        this.jdField_a_of_type_Mnn.b();
        this.jdField_a_of_type_Avzb.a();
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_Mno != null)
        {
          this.jdField_a_of_type_Mno.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Mno = null;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QavVideoAudioRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Avza);
        }
        if (this.jdField_a_of_type_Mno != null) {
          this.jdField_a_of_type_Mno.a(4, localException);
        }
        this.jdField_a_of_type_Mnn.c();
        this.jdField_a_of_type_Avzb.a();
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
    this.jdField_a_of_type_Mnt.sendMessage(localMessage);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoAudioRecorder", 2, "videoFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + EGL14.eglGetCurrentContext());
    }
    this.jdField_a_of_type_Mnt.removeMessages(2);
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
    this.jdField_a_of_type_Mnt.sendMessage(localMessage);
  }
  
  public void a(avza paramavza, mno parammno)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavVideoAudioRecorder", 2, "startRecording EGLContext = " + paramavza.a() + ", config=" + paramavza);
    }
    this.jdField_a_of_type_Mno = parammno;
    parammno = Message.obtain();
    parammno.obj = paramavza;
    parammno.what = 0;
    this.jdField_a_of_type_Mnt.sendMessage(parammno);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 1, "audioFrameAvailable, audioData[" + paramArrayOfByte.length + "], pts[" + paramLong + "], mAudioBufCount[" + this.jdField_a_of_type_Int + "], mPts[" + this.c + "]");
      }
      if ((!this.jdField_a_of_type_Mnn.b) || (this.jdField_a_of_type_Mnn.c)) {
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
      if (!this.jdField_a_of_type_Mnn.c)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 3;
        localMessage.obj = new Object[] { paramArrayOfByte, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Mnt.sendMessage(localMessage);
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
        this.jdField_a_of_type_Mnt.sendMessage(paramArrayOfByte);
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
    mnt localmnt = this.jdField_a_of_type_Mnt;
    HandlerThread localHandlerThread = this.jdField_a_of_type_AndroidOsHandlerThread;
    avzb localavzb = this.jdField_a_of_type_Avzb;
    if (localHandlerThread != null) {
      localmnt.post(new QavVideoAudioRecorder.1(this, localavzb, localHandlerThread));
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
      this.jdField_a_of_type_Mnn.a(paramArrayOfByte, paramLong - this.b);
      if (this.jdField_a_of_type_Mno != null) {
        this.jdField_a_of_type_Mno.i();
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (this.jdField_a_of_type_Mno != null) {
        this.jdField_a_of_type_Mno.a(3, paramArrayOfByte);
      }
      QLog.e("QavVideoAudioRecorder", 1, "handleAudioFrameAvailable", paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mns
 * JD-Core Version:    0.7.0.1
 */