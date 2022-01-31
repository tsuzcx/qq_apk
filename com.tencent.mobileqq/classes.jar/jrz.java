import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class jrz
  implements Runnable
{
  public jrz(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      QLog.d(this.a.c, 1, "init  double video Control not first time");
      String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().P;
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(42), str, Integer.valueOf(i) });
      DoubleVideoCtrlUI.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrz
 * JD-Core Version:    0.7.0.1
 */