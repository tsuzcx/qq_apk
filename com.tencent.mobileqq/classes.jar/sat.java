import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Observable;
import java.util.Observer;

public class sat
  implements Observer
{
  public sat(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.a.isFinishing()) {}
    while ((!(paramObject instanceof TroopUploadingThread.UploadState)) || (((TroopUploadingThread.UploadState)paramObject).a != 1)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetNewTroopHead = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
      this.a.u();
    }
    this.a.runOnUiThread(new sau(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sat
 * JD-Core Version:    0.7.0.1
 */