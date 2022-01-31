import com.tencent.av.VideoController;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavPanel;

public class jtp
  implements Runnable
{
  public jtp(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.b()))
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365377, true);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365377, true);
      }
      while ((this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365369)) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365369)))
      {
        this.a.D();
        return;
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365377, false);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365377, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jtp
 * JD-Core Version:    0.7.0.1
 */