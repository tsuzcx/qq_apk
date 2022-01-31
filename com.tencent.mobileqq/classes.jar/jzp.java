import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;

public class jzp
  implements Runnable
{
  public String a;
  
  public jzp(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.c, 2, "StartRecvAllVideoRunnable-->FunctionName=" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jzp
 * JD-Core Version:    0.7.0.1
 */