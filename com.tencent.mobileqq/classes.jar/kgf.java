import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagReport;
import com.tencent.av.ui.redbag.ResultData;

public class kgf
  implements Runnable
{
  public kgf(AVRedBagMgr paramAVRedBagMgr, ResultData paramResultData) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.b()) {
      this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a(this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr.a(), this.jdField_a_of_type_ComTencentAvUiRedbagResultData);
    }
    do
    {
      return;
      AVRedBagMgr.a(AVRedBagMgr.c(this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr), this.jdField_a_of_type_ComTencentAvUiRedbagResultData);
    } while (!this.jdField_a_of_type_ComTencentAvUiRedbagResultData.a());
    RedBagReport.a(this.jdField_a_of_type_ComTencentAvUiRedbagResultData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kgf
 * JD-Core Version:    0.7.0.1
 */