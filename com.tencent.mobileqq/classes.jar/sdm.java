import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import java.util.ArrayList;

class sdm
  implements Runnable
{
  sdm(sdk paramsdk) {}
  
  public void run()
  {
    ArrayList localArrayList = TroopInfoActivity.a(this.a.a, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    this.a.a.jdField_a_of_type_AndroidOsHandler.post(new sdn(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sdm
 * JD-Core Version:    0.7.0.1
 */