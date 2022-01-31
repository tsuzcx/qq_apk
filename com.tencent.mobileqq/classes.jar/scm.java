import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;

public class scm
  implements View.OnClickListener
{
  public scm(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363245: 
      ChatSettingForTroop.c(this.a);
      this.a.finish();
      return;
    }
    ChatSettingForTroop.d(this.a);
    if ((this.a.d == 1) || (this.a.a.isMember))
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_upright", 0, 0, new String[] { this.a.a.troopUin, TroopReportor.a(this.a.a) });
      return;
    }
    String str = this.a.a.troopUin;
    if (this.a.a.isMember) {}
    for (paramView = "1";; paramView = "0")
    {
      TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_upright", 0, 0, new String[] { str, paramView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scm
 * JD-Core Version:    0.7.0.1
 */