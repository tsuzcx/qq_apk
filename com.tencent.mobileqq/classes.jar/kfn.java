import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.av.ui.funchat.record.QavVideoAudioRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeInputSurface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class kfn
  implements Runnable
{
  public kfn(QavVideoAudioRecorder paramQavVideoAudioRecorder, EncodeInputSurface paramEncodeInputSurface, HandlerThread paramHandlerThread) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeInputSurface.a();
    }
    try
    {
      if (VersionUtils.h())
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quitSafely();
        QLog.i("QavVideoAudioRecorder", 1, "onDestroy quitSafely");
        return;
      }
      this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
      QLog.i("QavVideoAudioRecorder", 1, "onDestroy quit");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QavVideoAudioRecorder", 1, "onDestroy Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kfn
 * JD-Core Version:    0.7.0.1
 */