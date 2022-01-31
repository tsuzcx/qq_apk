import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;

public class jpv
  implements Runnable
{
  public jpv(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().T)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1);
    this.a.jdField_a_of_type_ComTencentAvVideoController.b(229);
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().d;
    this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 21);
    if (i == 1) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().d = 3;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().i = 3000;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().g = false;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().E = 0;
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.b();
      return;
      if (i == 2) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().d = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpv
 * JD-Core Version:    0.7.0.1
 */