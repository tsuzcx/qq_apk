import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.readinjoy.ReadInJoyHelper;

public class lxp
  implements Runnable
{
  public lxp(KandianOx210MsgInfo paramKandianOx210MsgInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false).edit();
    localEditor.putString("kandian_push_ox210_msg", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.a());
    localEditor.putInt("kandian_push_ox210_c5_msg_count", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.a);
    localEditor.putLong("kandian_push_0x210_c5_msg_time", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.d);
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxp
 * JD-Core Version:    0.7.0.1
 */