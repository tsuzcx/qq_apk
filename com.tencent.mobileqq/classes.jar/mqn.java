import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

class mqn
  extends Handler
{
  private WeakReference<mqm> jdField_a_of_type_JavaLangRefWeakReference;
  
  public mqn(mqm parammqm1, Looper paramLooper, mqm parammqm2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammqm2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    mqm localmqm = (mqm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmqm == null) {
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        switch (i)
        {
        default: 
          throw new RuntimeException("Unhandled msg what=" + i);
        case 0: 
          if (mqm.a(this.jdField_a_of_type_Mqm) == null) {
            mqm.a(this.jdField_a_of_type_Mqm, new ByteArrayOutputStream(32768));
          }
          if (paramMessage.obj != null)
          {
            mqm.a(localmqm, (axvi)paramMessage.obj);
            return;
          }
          throw new RuntimeException("MSG_START_RECORDING bundle == null");
        case 1: 
          mqm.a(localmqm);
          try
          {
            if (mqm.a(this.jdField_a_of_type_Mqm) != null)
            {
              mqm.a(this.jdField_a_of_type_Mqm).flush();
              mqm.a(this.jdField_a_of_type_Mqm).close();
              mqm.a(this.jdField_a_of_type_Mqm, null);
              return;
            }
          }
          catch (IOException paramMessage) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("QavVideoAudioRecorder", 2, "AudioBuf.close() ", paramMessage);
    return;
    if (paramMessage.obj != null)
    {
      paramMessage = (Object[])paramMessage.obj;
      if ((paramMessage == null) || (paramMessage.length != 5)) {
        throw new IllegalArgumentException("args == null || args.length != 5");
      }
      mqm.a(localmqm, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
      return;
    }
    throw new RuntimeException("MSG_VIDEO_FRAME_AVAILABLE bundle == null");
    if (paramMessage.obj != null)
    {
      paramMessage = (Object[])paramMessage.obj;
      localmqm.b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
      return;
    }
    throw new RuntimeException("MSG_AUDIO_FRAME_AVAILABLE bundle == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mqn
 * JD-Core Version:    0.7.0.1
 */