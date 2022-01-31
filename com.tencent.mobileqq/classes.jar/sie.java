import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import java.util.ArrayList;

class sie
  implements Runnable
{
  sie(sic paramsic) {}
  
  public void run()
  {
    ArrayList localArrayList = TroopInfoActivity.a(this.a.a, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    this.a.a.jdField_a_of_type_AndroidOsHandler.post(new sif(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sie
 * JD-Core Version:    0.7.0.1
 */