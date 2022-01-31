import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public final class olo
  implements Runnable
{
  public olo(EglHandlerThread paramEglHandlerThread, int paramInt1, int paramInt2, List paramList, int paramInt3, QQProgressNotifier paramQQProgressNotifier, Activity paramActivity) {}
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a();
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "EglHandlerThread initSuccess:" + bool);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.a().post(new olp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olo
 * JD-Core Version:    0.7.0.1
 */