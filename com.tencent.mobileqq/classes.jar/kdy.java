import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class kdy
  extends Handler
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public kdy(QavVideoAudioRecorder paramQavVideoAudioRecorder1, Looper paramLooper, QavVideoAudioRecorder paramQavVideoAudioRecorder2)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQavVideoAudioRecorder2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    QavVideoAudioRecorder localQavVideoAudioRecorder = (QavVideoAudioRecorder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQavVideoAudioRecorder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QavVideoAudioRecorder", 2, "RecodeHandler.handleMessage: encoder is null");
      }
      return;
    }
    switch (i)
    {
    default: 
      throw new RuntimeException("Unhandled msg what=" + i);
    case 0: 
      if (paramMessage.obj != null)
      {
        QavVideoAudioRecorder.a(localQavVideoAudioRecorder, (EncodeConfig)paramMessage.obj);
        return;
      }
      throw new RuntimeException("MSG_START_RECORDING bundle == null");
    case 1: 
      QavVideoAudioRecorder.a(localQavVideoAudioRecorder);
      return;
    case 2: 
      if (paramMessage.obj != null)
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.length != 5)) {
          throw new IllegalArgumentException("args == null || args.length != 5");
        }
        QavVideoAudioRecorder.a(localQavVideoAudioRecorder, ((Integer)paramMessage[0]).intValue(), ((Integer)paramMessage[1]).intValue(), (float[])paramMessage[2], (float[])paramMessage[3], ((Long)paramMessage[4]).longValue());
        return;
      }
      throw new RuntimeException("MSG_VIDEO_FRAME_AVAILABLE bundle == null");
    }
    if (paramMessage.obj != null)
    {
      paramMessage = (Object[])paramMessage.obj;
      localQavVideoAudioRecorder.b((byte[])paramMessage[0], ((Long)paramMessage[1]).longValue());
      return;
    }
    throw new RuntimeException("MSG_AUDIO_FRAME_AVAILABLE bundle == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kdy
 * JD-Core Version:    0.7.0.1
 */