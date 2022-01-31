import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nhs
  implements Runnable
{
  public nhs(LbsManager paramLbsManager, int paramInt) {}
  
  public void run()
  {
    SLog.d("LbsManager", "onLocation Timeout  %d ms", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager.a(false, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager.b);
    LbsManager.a(this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhs
 * JD-Core Version:    0.7.0.1
 */