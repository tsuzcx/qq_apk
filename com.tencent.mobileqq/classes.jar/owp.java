import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;

class owp
  implements Runnable
{
  owp(owi paramowi, TroopManager paramTroopManager, String paramString1, String paramString2, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_JavaLangString, this.b);
    if (localMessageRecord != null)
    {
      this.jdField_a_of_type_AndroidOsBundle.putLong("lastMsgTime", localMessageRecord.time);
      this.jdField_a_of_type_AndroidOsBundle.putString("lastMsgContent", localMessageRecord.msg);
      this.jdField_a_of_type_AndroidOsBundle.putInt("seq", this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Owi.a.a(73, this.jdField_a_of_type_AndroidOsBundle);
      return;
      this.jdField_a_of_type_AndroidOsBundle.putLong("lastMsgTime", 0L);
      this.jdField_a_of_type_AndroidOsBundle.putString("lastMsgContent", "");
      this.jdField_a_of_type_AndroidOsBundle.putInt("seq", this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owp
 * JD-Core Version:    0.7.0.1
 */