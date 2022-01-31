import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat;
import com.tencent.qphone.base.util.QLog;

public class jwu
  implements Runnable
{
  jwu(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.c, 2, "AutoCheckVideoRunnable");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().an = true;
    }
    MultiVideoCtrlLayerUI4NewGroupChat.h(this.a);
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jwu
 * JD-Core Version:    0.7.0.1
 */