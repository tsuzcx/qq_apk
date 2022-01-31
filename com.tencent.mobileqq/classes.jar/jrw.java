import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;

class jrw
  implements Runnable
{
  jrw(jrv paramjrv) {}
  
  public void run()
  {
    if ((this.a.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.a.jdField_a_of_type_ComTencentAvVideoController.a().g != 4) && (this.a.a.b == 1) && (!this.a.a.jdField_a_of_type_Boolean))
    {
      this.a.a.b(false);
      this.a.a.d(false);
      if ((this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
      {
        ((DoubleVideoCtrlUI)this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a();
        ((DoubleVideoCtrlUI)this.a.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).b(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jrw
 * JD-Core Version:    0.7.0.1
 */