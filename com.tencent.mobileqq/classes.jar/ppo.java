import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class ppo
{
  public int a;
  public long a;
  public long b = -1L;
  
  public ppo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static ppo a()
  {
    ppo localppo = new ppo();
    SharedPreferences localSharedPreferences = bgmq.a(obz.a(), true, false);
    localppo.jdField_a_of_type_Long = localSharedPreferences.getLong("kandian_biu_0x210_seq", -1L);
    localppo.b = localSharedPreferences.getLong("kandian_biu_0x210_uin", -1L);
    localppo.jdField_a_of_type_Int = localSharedPreferences.getInt("kandian_biu_0x210_status", -1);
    return localppo;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new KandianOx210MsgInfo.Biu0x210Msg.1(this, paramQQAppInterface), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppo
 * JD-Core Version:    0.7.0.1
 */