import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class rpm
{
  public int a;
  public long a;
  public long b = -1L;
  
  public rpm()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static rpm a()
  {
    rpm localrpm = new rpm();
    SharedPreferences localSharedPreferences = bmhv.a(pkh.a(), true, false);
    localrpm.jdField_a_of_type_Long = localSharedPreferences.getLong("kandian_biu_0x210_seq", -1L);
    localrpm.b = localSharedPreferences.getLong("kandian_biu_0x210_uin", -1L);
    localrpm.jdField_a_of_type_Int = localSharedPreferences.getInt("kandian_biu_0x210_status", -1);
    return localrpm;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new KandianOx210MsgInfo.Biu0x210Msg.1(this, paramQQAppInterface), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpm
 * JD-Core Version:    0.7.0.1
 */