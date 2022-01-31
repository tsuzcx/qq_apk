import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;

public class jzl
  implements Runnable
{
  jzl(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.i())
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(0L, false, 0L);
      if (QLog.isColorLevel()) {
        QLog.e(this.a.c, 2, "RefreshNoiseStateRunnable refreshUserNoiseState return true");
      }
    }
    Handler localHandler;
    Runnable localRunnable;
    if (this.a.e != null)
    {
      localHandler = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      localRunnable = this.a.e;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.c >= 2000L) {
        break label105;
      }
    }
    label105:
    for (long l = 2000L;; l = this.a.jdField_a_of_type_ComTencentAvVideoController.c)
    {
      localHandler.postDelayed(localRunnable, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jzl
 * JD-Core Version:    0.7.0.1
 */