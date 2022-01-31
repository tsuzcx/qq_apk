import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenVideoController;
import com.tencent.av.ui.ControlUIObserver;

public class jpm
  implements Runnable
{
  public jpm(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      break label10;
    }
    label10:
    while (this.a.jdField_a_of_type_ComTencentAvVideoController.a() == null) {
      return;
    }
    int i;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().T)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 1);
      this.a.jdField_a_of_type_ComTencentAvVideoController.b(226);
      i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().d;
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a().c, 21);
      if (i != 1) {
        break label262;
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().d = 3;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().i = 3000;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().g = false;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().E = 0;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().g) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().Q > 0)) {
        SmallScreenVideoController.a(this.a);
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiControlUIObserver.h();
      return;
      label262:
      if (i == 2) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().d = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jpm
 * JD-Core Version:    0.7.0.1
 */