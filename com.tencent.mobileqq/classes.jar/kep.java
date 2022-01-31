import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.AVRedBagMgr.TestFlag;
import com.tencent.av.ui.redbag.GameSink;
import com.tencent.mobileqq.utils.AudioHelper;

public class kep
  implements Runnable
{
  public kep(AVRedBagMgr.TestFlag paramTestFlag, AVRedBagMgr paramAVRedBagMgr) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.jdField_c_of_type_JavaLangString = "0";
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.d = "0";
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.jdField_c_of_type_Boolean = false;
    AudioHelper.a("开始模拟onGameEnd, RedBagID[" + this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.a + "], playerGetRedbagResultCode[" + this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.jdField_c_of_type_JavaLangString + "], playerGetRedbagResultState[" + this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.d + "]");
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a().a(this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a, this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a().getCurrentAccountUin(), this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.a, this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$TestFlag.b, 1000, 2000, 2, 5, "231", "0", null, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kep
 * JD-Core Version:    0.7.0.1
 */