import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class mlu
  implements lcg
{
  public mlu(VideoLayerUI paramVideoLayerUI, int paramInt, boolean paramBoolean) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMeu != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMeu.length > this.jdField_a_of_type_Int))
    {
      mrq.a("switch_camera", "onSwitchCameraFirstFrame", 3, new Object[0]);
      VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMeu[this.jdField_a_of_type_Int], this.jdField_a_of_type_Boolean);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onSwitchCameraFirstFrame Error : Index = " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mlu
 * JD-Core Version:    0.7.0.1
 */