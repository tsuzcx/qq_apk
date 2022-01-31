import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class jsg
  implements Runnable
{
  public jsg(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(233);
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 9);
      QLog.d(this.a.c, 1, "exit when onBackPressed");
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsg
 * JD-Core Version:    0.7.0.1
 */