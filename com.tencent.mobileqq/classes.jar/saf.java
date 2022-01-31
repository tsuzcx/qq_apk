import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;

public class saf
  implements View.OnClickListener
{
  public saf(ChatSettingForTroop paramChatSettingForTroop) {}
  
  @SuppressLint({"ServiceCast"})
  @TargetApi(11)
  public void onClick(View paramView)
  {
    String str;
    try
    {
      paramView = String.format(this.a.getString(2131435214), new Object[] { this.a.a.newTroopName, this.a.a.troopUin });
      if (Build.VERSION.SDK_INT < 11)
      {
        ((android.text.ClipboardManager)this.a.getSystemService("clipboard")).setText(paramView);
        if ((this.a.d != 1) && (!this.a.a.isMember)) {
          break label178;
        }
        str = this.a.a.troopUin;
        if (!this.a.a.isMember) {
          break label172;
        }
        paramView = "1";
        TroopReportor.a("Grp_set_new", "grpData_admin", "copy_grpuin", 0, 0, new String[] { str, paramView });
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        paramView = "";
        continue;
        ((android.content.ClipboardManager)this.a.getSystemService("clipboard")).setText(paramView);
        continue;
        label172:
        paramView = "0";
      }
      label178:
      str = this.a.a.troopUin;
      if (!this.a.a.isMember) {}
    }
    for (paramView = "1";; paramView = "0")
    {
      TroopReportor.a("Grp_set_new", "grpData_visitor", "copy_grpuin", 0, 0, new String[] { str, paramView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     saf
 * JD-Core Version:    0.7.0.1
 */