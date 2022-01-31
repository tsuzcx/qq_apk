import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;

class san
  implements Runnable
{
  san(sam paramsam) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    TroopMemberInfo localTroopMemberInfo;
    if (this.a.a.app != null)
    {
      localObject1 = localObject2;
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
      {
        localObject1 = DBUtils.a().a(this.a.a.app, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.a.app.getCurrentAccountUin());
        if (localObject1 != null) {
          break label171;
        }
        localTroopMemberInfo = DBUtils.a().a(this.a.a.app, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.a.app.getCurrentAccountUin());
        localObject1 = localObject2;
        if (localTroopMemberInfo == null) {}
      }
    }
    label171:
    for (localObject1 = localTroopMemberInfo.troopnick;; localObject1 = ((TroopMemberCardInfo)localObject1).name)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.a.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = ((String)localObject1);
        this.a.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     san
 * JD-Core Version:    0.7.0.1
 */