import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import java.util.ArrayList;

public class sit
  implements Runnable
{
  public sit(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
      return;
    }
    ArrayList localArrayList = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    this.a.jdField_a_of_type_AndroidOsHandler.post(new siu(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sit
 * JD-Core Version:    0.7.0.1
 */