import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

class mop
  extends Handler
{
  private WeakReference<moo> jdField_a_of_type_JavaLangRefWeakReference;
  
  public mop(moo parammoo1, Looper paramLooper, moo parammoo2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammoo2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    moo localmoo = (moo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localmoo == null) {
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
          if (moo.a(this.jdField_a_of_type_Moo) == null) {
            moo.a(this.jdField_a_of_type_Moo, new ByteArrayOutputStream(32768));
          }
          if (paramMessage.obj != null)
          {
            moo.a(localmoo, (bbmc)paramMessage.obj);
            return;
          }
          throw new RuntimeException("MSG_START_RECORDING bundle == null");
        case 1: 
          moo.a(localmoo);
          try
          {
            if (moo.a(this.jdField_a_of_type_Moo) != null)
            {
              moo.a(this.jdField_a_of_type_Moo).flush();
              moo.a(this.jdField_a_of_type_Moo).close();
              moo.a(this.jdField_a_of_type_Moo, null);
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
      moo.a(localmoo, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
      return;
    }
    throw new RuntimeException("MSG_VIDEO_FRAME_AVAILABLE bundle == null");
    if (paramMessage.obj != null)
    {
      paramMessage = (Object[])paramMessage.obj;
      localmoo.b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
      return;
    }
    throw new RuntimeException("MSG_AUDIO_FRAME_AVAILABLE bundle == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mop
 * JD-Core Version:    0.7.0.1
 */