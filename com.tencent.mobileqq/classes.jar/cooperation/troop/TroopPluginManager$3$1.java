package cooperation.troop;

import android.app.Dialog;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;
import com.tencent.mobileqq.widget.QQToast;
import java.io.Serializable;
import java.util.ArrayList;

class TroopPluginManager$3$1
  implements TroopPluginCallback
{
  TroopPluginManager$3$1(TroopPluginManager.3 param3, Object[] paramArrayOfObject) {}
  
  public void onInstallFinish(int paramInt)
  {
    int i = 0;
    if (paramInt == 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("troopUin", this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("memberUin", this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("fromFlag", this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_Int);
      localIntent.putExtra("troopCode", this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.c);
      localIntent.putExtra("troopName", this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.d);
      Object localObject1 = (TroopManager)this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = ((IBizTroopMemberInfoService)this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberCard(this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_b_of_type_JavaLangString);
      Object localObject2 = (TroopMemberCard)this.jdField_a_of_type_ArrayOfJavaLangObject[2];
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        localIntent.putExtra("troopMemberCard", (Serializable)localObject1);
        localIntent.putExtra("hwCard", ((IBizTroopMemberInfoService)this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IBizTroopMemberInfoService.class, "")).getHWTroopMemberCard(this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_b_of_type_JavaLangString));
        localIntent.putExtra("isOrgMgr", false);
        localIntent.putExtra("isHisMgr", true);
        localIntent.putExtra("hasOrgs", true);
        localObject2 = new ArrayList();
        paramInt = i;
        while (paramInt < ((TroopMemberCard)localObject1).mOrgIds.size())
        {
          ((ArrayList)localObject2).add(((String)((TroopMemberCard)localObject1).mOrgIds.get(paramInt)).substring(this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_JavaLangString.length()));
          paramInt += 1;
        }
        localIntent.putExtra("orgIds", (Serializable)localObject2);
        TroopMemberCardProxyActivity.a(this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "troop_member_card_plugin.apk", HardCodeUtil.a(2131715494), TroopMemberCardProxyActivity.class, this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_AndroidAppActivity, localIntent, this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_AndroidAppDialog, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_b_of_type_Int);
        return;
      }
      this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_AndroidAppDialog.dismiss();
      QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715495), 0).a();
      return;
    }
    this.jdField_a_of_type_CooperationTroopTroopPluginManager$3.jdField_a_of_type_AndroidAppDialog.dismiss();
    QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131715496), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.3.1
 * JD-Core Version:    0.7.0.1
 */