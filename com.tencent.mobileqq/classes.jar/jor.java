import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI;
import com.tencent.qphone.base.util.QLog;

public class jor
  implements Runnable
{
  public jor(SmallScreenDoubleVideoControlUI paramSmallScreenDoubleVideoControlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo.c, 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(225);
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(localSessionInfo.c, 9);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), localSessionInfo.c, Boolean.valueOf(true) });
      QLog.d("SmallScreenDoubleVideoControlUI", 1, "exit when onCreate fail");
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jor
 * JD-Core Version:    0.7.0.1
 */