import android.os.Handler;
import com.tencent.biz.troop.feeds.TroopNewGuidePopWindow;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import org.json.JSONObject;

public class oxw
  implements Runnable
{
  public oxw(TroopNewGuidePopWindow paramTroopNewGuidePopWindow, JSONObject paramJSONObject, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = TroopFeedsDataManager.TroopNotify.a(this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.b, this.jdField_a_of_type_OrgJsonJSONObject);
    this.jdField_a_of_type_ComTencentBizTroopFeedsTroopNewGuidePopWindow.jdField_a_of_type_AndroidOsHandler.post(new oxx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxw
 * JD-Core Version:    0.7.0.1
 */