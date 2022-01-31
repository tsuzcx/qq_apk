import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import org.json.JSONException;
import org.json.JSONObject;

public final class llf
  implements Runnable
{
  public llf(RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing) {}
  
  public void run()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.b == 1) {
      str = "1";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq, "extLong", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.extLong));
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.parse();
      }
      JSONObject localJSONObject;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("folder_status", WeishiReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
        localJSONObject.put("algorithm_id", WeishiReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing));
        localJSONObject.put("reddot_style", str);
        localJSONObject.put("EnterType", "0");
        WeishiReportUtil.a(WeishiReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg.mStrategyIds, "0X8009290", localJSONObject.toString());
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.b != 2) {
          continue;
        }
        str = "0";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llf
 * JD-Core Version:    0.7.0.1
 */