import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class kkx
  implements Runnable
{
  public kkx(AddContactTroopManage paramAddContactTroopManage, troopviewInfo.RspBody paramRspBody) {}
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopManage)
    {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopManage.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody = this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody;
      AddContactTroopManage.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopManage, this.jdField_a_of_type_TencentImTroop_viewTroopviewInfo$RspBody);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kkx
 * JD-Core Version:    0.7.0.1
 */