import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class mlo
  implements lci
{
  public mlo(VideoLayerUI paramVideoLayerUI, int paramInt, boolean paramBoolean) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMep != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMep.length > this.jdField_a_of_type_Int))
    {
      mrk.a("switch_camera", "onSwitchCameraFirstFrame", 3, new Object[0]);
      VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfMep[this.jdField_a_of_type_Int], this.jdField_a_of_type_Boolean);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString, 2, "onSwitchCameraFirstFrame Error : Index = " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlo
 * JD-Core Version:    0.7.0.1
 */