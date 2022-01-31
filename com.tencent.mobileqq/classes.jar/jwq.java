import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class jwq
  implements Runnable
{
  public jwq(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_Boolean) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_ComTencentAvVideoController.a(String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b), this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_JavaUtilMap.put(String.valueOf(this.jdField_a_of_type_Long), str);
    QLog.d(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.c, 1, "refreshUI --> user name mark name=" + str + ", mApp.getCurrentAccountUin()=" + String.valueOf(this.jdField_a_of_type_Long) + ", mMapNickNameCache.size()=" + this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.jdField_a_of_type_JavaUtilMap.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jwq
 * JD-Core Version:    0.7.0.1
 */