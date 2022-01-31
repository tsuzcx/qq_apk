import com.tencent.av.VideoController;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.QavPanel;

public class jve
  implements Runnable
{
  public jve(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvUiQavPanel == null)) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.c()) && (VcSystemInfo.b()))
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, true);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365404, true);
      }
      while ((this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131365396)) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365396)))
      {
        this.a.D();
        return;
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131365404, false);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.b(2131365404, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jve
 * JD-Core Version:    0.7.0.1
 */