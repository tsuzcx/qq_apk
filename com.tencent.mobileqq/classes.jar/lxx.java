import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.readinjoy.ReadInJoyHelper;

public class lxx
  implements Runnable
{
  public lxx(KandianOx210MsgInfo.Biu0x210Msg paramBiu0x210Msg, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false).edit();
    localEditor.putLong("kandian_biu_0x210_seq", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Long);
    localEditor.putLong("kandian_biu_0x210_uin", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.b);
    localEditor.putInt("kandian_biu_0x210_status", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo$Biu0x210Msg.jdField_a_of_type_Int);
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxx
 * JD-Core Version:    0.7.0.1
 */