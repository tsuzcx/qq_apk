import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class jxi
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  public jxi(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.c, 2, "RefreshStatusTipsRunnale , type = " + this.jdField_a_of_type_Int + " , flag = " + this.jdField_a_of_type_Boolean);
    }
    int i = this.jdField_a_of_type_Int;
    if ((i == 50) || (i == 57) || (i == 52) || (i == 58) || (i == 59) || (i == 60)) {
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a != null) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.a(i, this.jdField_a_of_type_Boolean);
      }
    }
    while (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxi
 * JD-Core Version:    0.7.0.1
 */