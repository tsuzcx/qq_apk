import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class qwi
{
  public int a;
  public long a;
  public long b = -1L;
  
  public qwi()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static qwi a()
  {
    qwi localqwi = new qwi();
    SharedPreferences localSharedPreferences = bnrf.a(ozs.a(), true, false);
    localqwi.jdField_a_of_type_Long = localSharedPreferences.getLong("kandian_biu_0x210_seq", -1L);
    localqwi.b = localSharedPreferences.getLong("kandian_biu_0x210_uin", -1L);
    localqwi.jdField_a_of_type_Int = localSharedPreferences.getInt("kandian_biu_0x210_status", -1);
    return localqwi;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new KandianOx210MsgInfo.Biu0x210Msg.1(this, paramQQAppInterface), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwi
 * JD-Core Version:    0.7.0.1
 */