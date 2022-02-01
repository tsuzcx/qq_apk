import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

class mns
  extends Handler
{
  private WeakReference<mnr> jdField_a_of_type_JavaLangRefWeakReference;
  
  public mns(mnr parammnr1, Looper paramLooper, mnr parammnr2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammnr2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    mnr localmnr = (mnr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmnr == null) {
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
          if (mnr.a(this.jdField_a_of_type_Mnr) == null) {
            mnr.a(this.jdField_a_of_type_Mnr, new ByteArrayOutputStream(32768));
          }
          if (paramMessage.obj != null)
          {
            mnr.a(localmnr, (batj)paramMessage.obj);
            return;
          }
          throw new RuntimeException("MSG_START_RECORDING bundle == null");
        case 1: 
          mnr.a(localmnr);
          try
          {
            if (mnr.a(this.jdField_a_of_type_Mnr) != null)
            {
              mnr.a(this.jdField_a_of_type_Mnr).flush();
              mnr.a(this.jdField_a_of_type_Mnr).close();
              mnr.a(this.jdField_a_of_type_Mnr, null);
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
      mnr.a(localmnr, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
      return;
    }
    throw new RuntimeException("MSG_VIDEO_FRAME_AVAILABLE bundle == null");
    if (paramMessage.obj != null)
    {
      paramMessage = (Object[])paramMessage.obj;
      localmnr.b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
      return;
    }
    throw new RuntimeException("MSG_AUDIO_FRAME_AVAILABLE bundle == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mns
 * JD-Core Version:    0.7.0.1
 */