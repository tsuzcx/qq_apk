import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.readinjoy.ReadInJoyHelper;

public class lxt
  implements Runnable
{
  public lxt(KandianOx210MsgInfo paramKandianOx210MsgInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, false).edit();
    localEditor.remove("kandian_push_0x210_msg_for_follow");
    localEditor.remove("kandian_push_0x210_c5_msg_time");
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxt
 * JD-Core Version:    0.7.0.1
 */