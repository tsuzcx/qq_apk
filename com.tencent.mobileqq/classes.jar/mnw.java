import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

class mnw
  extends Handler
{
  private WeakReference<mnv> jdField_a_of_type_JavaLangRefWeakReference;
  
  public mnw(mnv parammnv1, Looper paramLooper, mnv parammnv2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammnv2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    mnv localmnv = (mnv)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmnv == null) {
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
          if (mnv.a(this.jdField_a_of_type_Mnv) == null) {
            mnv.a(this.jdField_a_of_type_Mnv, new ByteArrayOutputStream(32768));
          }
          if (paramMessage.obj != null)
          {
            mnv.a(localmnv, (avyy)paramMessage.obj);
            return;
          }
          throw new RuntimeException("MSG_START_RECORDING bundle == null");
        case 1: 
          mnv.a(localmnv);
          try
          {
            if (mnv.a(this.jdField_a_of_type_Mnv) != null)
            {
              mnv.a(this.jdField_a_of_type_Mnv).flush();
              mnv.a(this.jdField_a_of_type_Mnv).close();
              mnv.a(this.jdField_a_of_type_Mnv, null);
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
      mnv.a(localmnv, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
      return;
    }
    throw new RuntimeException("MSG_VIDEO_FRAME_AVAILABLE bundle == null");
    if (paramMessage.obj != null)
    {
      paramMessage = (Object[])paramMessage.obj;
      localmnv.b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
      return;
    }
    throw new RuntimeException("MSG_AUDIO_FRAME_AVAILABLE bundle == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mnw
 * JD-Core Version:    0.7.0.1
 */