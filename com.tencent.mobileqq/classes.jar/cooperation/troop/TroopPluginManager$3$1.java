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
      localIntent.putExtra("troopUin", this.b.a);
      localIntent.putExtra("memberUin", this.b.c);
      localIntent.putExtra("fromFlag", this.b.d);
      localIntent.putExtra("troopCode", this.b.e);
      localIntent.putExtra("troopName", this.b.f);
      Object localObject1 = (TroopManager)this.b.b.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject1 = ((IBizTroopMemberInfoService)this.b.b.getRuntimeService(IBizTroopMemberInfoService.class, "")).getTroopMemberCard(this.b.a, this.b.c);
      Object localObject2 = (TroopMemberCard)this.a[2];
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        localIntent.putExtra("troopMemberCard", (Serializable)localObject1);
        localIntent.putExtra("hwCard", ((IBizTroopMemberInfoService)this.b.b.getRuntimeService(IBizTroopMemberInfoService.class, "")).getHWTroopMemberCard(this.b.a, this.b.c));
        localIntent.putExtra("isOrgMgr", false);
        localIntent.putExtra("isHisMgr", true);
        localIntent.putExtra("hasOrgs", true);
        localObject2 = new ArrayList();
        paramInt = i;
        while (paramInt < ((TroopMemberCard)localObject1).mOrgIds.size())
        {
          ((ArrayList)localObject2).add(((String)((TroopMemberCard)localObject1).mOrgIds.get(paramInt)).substring(this.b.a.length()));
          paramInt += 1;
        }
        localIntent.putExtra("orgIds", (Serializable)localObject2);
        TroopMemberCardProxyActivity.a(this.b.b, "troop_member_card_plugin.apk", HardCodeUtil.a(2131912968), TroopMemberCardProxyActivity.class, this.b.h, localIntent, this.b.g, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.b.b.getCurrentAccountUin(), this.b.i);
        return;
      }
      this.b.g.dismiss();
      QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131912969), 0).show();
      return;
    }
    this.b.g.dismiss();
    QQToast.makeText(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131912970), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop.TroopPluginManager.3.1
 * JD-Core Version:    0.7.0.1
 */