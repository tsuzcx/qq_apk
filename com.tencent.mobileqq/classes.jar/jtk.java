import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.VideoLayerUI;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class jtk
  extends TimerTask
{
  public jtk(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    for (;;)
    {
      return;
      SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo == null) {
        continue;
      }
      if (localSessionInfo.Q <= 0)
      {
        if (this.a.jdField_a_of_type_JavaUtilTimer == null) {
          continue;
        }
        this.a.jdField_a_of_type_JavaUtilTimer.cancel();
        this.a.jdField_a_of_type_JavaUtilTimer = null;
        return;
      }
      try
      {
        if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          l1 = ((AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c);
          long l2 = System.currentTimeMillis();
          if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (l1 == 0L) || (l2 - l1 <= this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q * 1000)) {
            continue;
          }
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.runOnUiThread(new jtl(this, l2, l1));
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AVLog.e(this.a.c, "StartGlassCheck e = " + localException.getMessage());
          long l1 = 0L;
          continue;
          l1 = 0L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtk
 * JD-Core Version:    0.7.0.1
 */