import android.content.res.Resources;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class joz
  implements Runnable
{
  public joz(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.f();
      if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        TipsManager.c(103);
        TipsManager.c(106);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
        str = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131429413);
        TipsManager.a(107, str);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107, str, false);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a.jdField_a_of_type_Long, true, true);
      this.a.a(true, false, true);
      if (this.a.d == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.e("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     joz
 * JD-Core Version:    0.7.0.1
 */