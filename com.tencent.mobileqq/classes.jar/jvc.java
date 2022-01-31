import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class jvc
  implements Runnable
{
  public jvc(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(239);
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 9);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, Boolean.valueOf(true) });
      QLog.d(this.a.c, 1, "exit when OnCreate");
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jvc
 * JD-Core Version:    0.7.0.1
 */