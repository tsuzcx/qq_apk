import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class qbh
{
  public int a;
  public long a;
  public long b = -1L;
  
  public qbh()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static qbh a()
  {
    qbh localqbh = new qbh();
    SharedPreferences localSharedPreferences = bhvy.a(onh.a(), true, false);
    localqbh.jdField_a_of_type_Long = localSharedPreferences.getLong("kandian_biu_0x210_seq", -1L);
    localqbh.b = localSharedPreferences.getLong("kandian_biu_0x210_uin", -1L);
    localqbh.jdField_a_of_type_Int = localSharedPreferences.getInt("kandian_biu_0x210_status", -1);
    return localqbh;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new KandianOx210MsgInfo.Biu0x210Msg.1(this, paramQQAppInterface), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbh
 * JD-Core Version:    0.7.0.1
 */